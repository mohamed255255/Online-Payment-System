package com.Advanced.SE.Project.controller.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

import com.Advanced.SE.Project.model.discount.*;
import com.Advanced.SE.Project.model.payment.*;
import com.Advanced.SE.Project.model.receipt.*;
import com.Advanced.SE.Project.model.refundrequest.*;
import com.Advanced.SE.Project.model.service.*;
import com.Advanced.SE.Project.model.user.*;

@RestController
public class UserFunctionalitiesController {
	
	//search for a service. URL => /user/searchservice/{serviceType}. Method => GET 
	@GetMapping(value = "/user/searchservice/{serviceType}")
	public Collection<String> search(@PathVariable("serviceType")String servicetype, HttpServletRequest request){
		
		//check user
		String ip = request.getRemoteAddr();

		if(ActiveUsers.getInstance().getUser(ip) == null)
			return null;
		
		try {
			//get service providers of serviceType
			return ServiceDB.getInstance().getServices(servicetype);
		}catch(Exception e) {
			return null;
		}
	}
	
	//get service form. URL => /user/{serviceType}/{serviceName}/form. Method => GET
	@GetMapping("/user/serviceform/{serviceType}/{serviceName}")
	public Collection<String> getServiceForm(@PathVariable("serviceType")String servicetype, @PathVariable("serviceName") String serviceName, HttpServletRequest request) {
		//check user
		String ip = request.getRemoteAddr();
		if(ActiveUsers.getInstance().getUser(ip) == null)
			return null;
		
		//get service
		Service service = null;
		try {
			service = ServiceDB.getInstance().getService(servicetype, serviceName);
		} catch (Exception e) {
			return null;
		}
		
		if(service == null)
			return null;
		
		//get labels from service
		return service.getForm().getLabels();
	}
	
	//get payment options for a service. URL => /user/{serviceType}/{serviceName}/paymentoptions/. Method => GET
	@GetMapping(value = "/user/paymentoptions/{serviceType}/{serviceName}/")
	public Collection<String> getPaymentOptions(@PathVariable("serviceType")String servicetype, @PathVariable("serviceName") String serviceName, HttpServletRequest request){
		//check user
		String ip = request.getRemoteAddr();
		if(ActiveUsers.getInstance().getUser(ip) == null)
			return null;
		
		//get service
		Service service = null;
		try {
			service = ServiceDB.getInstance().getService(servicetype, serviceName);
		} catch (Exception e) {
			return null;
		}
		if(service == null)
			return null;
		
		//list options and check if service accepts COD to list it or no
		ArrayList<String> options = new ArrayList<>();
		options.add("Credit Card");
		options.add("Wallet");
		if(service.acceptCOD()) 
			options.add("COD");
		return options;
	}
	
	//pay for service. URL => /user/pay/{serviceType}/{serviceName}/. Method => POST
	@PostMapping(value = "/user/pay/{serviceType}/{serviceName}/")
	public String pay( @PathVariable("serviceType") String servicetype, @PathVariable("serviceName") String serviceName, @RequestParam("Form") List<String> formResponse, @RequestParam("PaymentOption") String paymentOption, @RequestParam(name = "Promocode", required = false) String promocode, @RequestParam(name = "CardNumber", required = false) String cardNum, @RequestParam(name = "CVV", required = false) Integer CVV, HttpServletRequest request) {
		//check user
		String ip = request.getRemoteAddr();
		if(ActiveUsers.getInstance().getUser(ip) == null)
			return null;
		//local services have their own functions (local services ex. Add to wallet)
		if(servicetype.equals("Local"))
			return null;
		
		//get service
		Service service;
		try {
			service = ServiceDB.getInstance().getService(servicetype, serviceName);
		}catch(Exception e) {
			return e.getMessage();
		}
		if(service == null)
			return "No such service or service provider!";
		
		//set form
		service.getForm().setResponse(formResponse);;
		List<String> responses = service.getForm().getResponses();

		//get amount
		Double amount;
		try {
			amount = Double.valueOf(responses.get(responses.size() - 1));
		}catch(Exception e) {
			return "Invalid Amount!";
		}

		if(amount < 0)
			return "Invalid Amount!";

		//apply discount
		if(promocode != null){
			Discount discount = DiscountDB.getInstance().getDiscount(promocode);
			if(discount == null)
				return "Invalid promocode!";
			if(servicetype.equals(discount.getService().name()) || discount.getService().equals(ServiceType.General))
				amount -= amount*discount.getPrecentage();
			else 
				return "Invalid promocode for current service!";
		}
		
		//payment process
		//Initialize payment method
		IPaymentMethod paymentmethod = null;
		if(paymentOption.equals("CreditCard")) {
			if(cardNum == null)
				return "credit card number was not provided!";
			if(CVV == null)
				return "CVV was not provided!";
			paymentmethod = new CreditCard(cardNum, CVV);
		}
		else if(paymentOption.equals("COD")) {
			paymentmethod = new COD();
		}
		else if (paymentOption.equals("Wallet")) {
			paymentmethod = ActiveUsers.getInstance().getUser(ip).getWallet();
		}
		else {
			return "Invalid Payment Option!";
		}
		
		//pay
		try {
			paymentmethod.pay(amount);
		} catch (Exception e) {
			return e.getMessage();
		}
		
		//handle form
		try {
			service.handler(service.getForm());
		}catch (Exception e) {}
		
		//issue a receipt
		int receiptId = ReceiptDB.getInstance().addReceipt(ActiveUsers.getInstance().getUser(ip).getEmail() , service.getForm(), amount);
		return "Success your receipt number is " + Integer.toString(receiptId) + "!";
	}
			
	//Ask for a refund. URL => user/refundrequest/. Method => POST
	@PostMapping(value = "user/refundrequest/")
	public String refundRequest(@RequestParam("ReceiptId") int receiptId, @RequestParam("Reason") String reason, HttpServletRequest request) {
		//check user
		String ip = request.getRemoteAddr();
		User currentUser = ActiveUsers.getInstance().getUser(ip);
		if(currentUser == null)
			return null;
		
		//make sure user is making a request on his own receipt
		try {
			Receipt receipt = ReceiptDB.getInstance().getReceipt(receiptId);
			if(receipt.getUserEmail().equals(currentUser.getEmail()) == false)
				return "You don't have a receipt with that id!";
		}catch(Exception e) {
			return e.getMessage();
		}
		
		//make the request
		int requestId;
		try {
			requestId = RefundRequestDB.getInstance().add(receiptId, reason);
		}catch(Exception e) {
			return e.getMessage();
		}
		return "Success your request Id is " + requestId + "!";
	}
	
	//check discounts. URL => user/discounts/. Method => GET
	@GetMapping(value = "user/discounts/")
	public Collection<Discount> getDiscount(HttpServletRequest request){
		//check user
		String ip = request.getRemoteAddr();
		if(ActiveUsers.getInstance().getUser(ip) == null)
			return null;
		
		return DiscountDB.getInstance().getDiscounts();
	}
	
	//public addToWallet. /user/addtowallet. Method => POST
	@PostMapping(value = "user/addtowallet/")
	public String addToWallet(@RequestParam("Amount") Double amount, @RequestParam("CardNumber") String cardNum, @RequestParam("CVV") Integer CVV , HttpServletRequest request) {
		String ip = request.getRemoteAddr();
		if(ActiveUsers.getInstance().getUser(ip) == null)
			return null;
		
		if(amount < 0)
			return "Invalid amount";
		//Instantiate credit card
		if(cardNum == null)
			return "credit card number was not provided";
		if(CVV == null)
			return "CVV was not provided";
		//pay using credit card
		IPaymentMethod paymentmethod = new CreditCard(cardNum, CVV);
		try {
			paymentmethod.pay(amount);
		} catch (Exception e) {}
		
		Wallet wallet = ActiveUsers.getInstance().getUser(ip).getWallet();
		wallet.addToBalance(amount);
		
		AddToWalletFactory addToWalletFactory = new AddToWalletFactory();
		Service addToWalletService = addToWalletFactory.createInstance();
		Form addToWalletForm = addToWalletService.getForm();

		List<String> response = new ArrayList<>();
		response.add(Double.toString(amount));
		addToWalletForm.setResponse(response);

		int receiptId = ReceiptDB.getInstance().addReceipt(ActiveUsers.getInstance().getUser(ip).getEmail(), addToWalletForm, amount);
		return "Success you wallet balance now is " + wallet.getBalance() + " and you receipt Id is " + receiptId + "!";
	}
}