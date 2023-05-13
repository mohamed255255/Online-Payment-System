package com.Advanced.SE.Project.controller.admin;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.Advanced.SE.Project.model.discount.DiscountDB;
import com.Advanced.SE.Project.model.receipt.ReceiptDB;
import com.Advanced.SE.Project.model.refundrequest.RefundRequest;
import com.Advanced.SE.Project.model.refundrequest.RefundRequestDB;
import com.Advanced.SE.Project.model.user.User;
import com.Advanced.SE.Project.model.user.UserDB;
import com.Advanced.SE.Project.model.receipt.Receipt;

@RestController
public class AdminFunctionalititesController {
	//add discount. URL => /admin/adddiscount/. Method => Post
	@PostMapping("/admin/adddiscount/")
	public String addDiscount(@RequestParam("Promocode") String promoCode, @RequestParam("Precentage") Double precentage, @RequestParam("Service") String service) {
		try {
			DiscountDB.getInstance().add(promoCode, precentage, service);
		}catch(Exception e) {
			return e.getMessage();
		}
		return "Success!";
	}
	//view all transactions. URL=> /admin/viewtransactions/. Method => GET
	@GetMapping("/admin/viewtransactions/")
	public List<Receipt> viewTransactions(){
		return ReceiptDB.getInstance().getReceipts();
	}
	//view refund requests.URL=> /admin/viewrefundrequests/. Method => GET
	@GetMapping("/admin/viewrefundrequests/")
	public List<RefundRequest> viewRefundRequests(){
		return RefundRequestDB.getInstance().getRefundRequests();
	}
	//accept or reject a refund request
	//status rejected = -1, accepted = 1No Environment
	@PostMapping("/admin/refundrequest/verdict/")
	public String setRequestStatus(@RequestParam("RequestId") int requestId, @RequestParam("Verdict") int status){
		//get request
		RefundRequest request;
		try {
			request = RefundRequestDB.getInstance().getRefundRequest(requestId);
		} catch (Exception e) {
			return e.getMessage();
		}
		
		//if was accepted or rejected before return
		if(request.getstatus() != 0)
			return "This request was given a verdict before!";
		
		//accept and return
		if(status == 1) {
			request.setStatus(status);
			try {
				//get receipt
				Receipt receipt = ReceiptDB.getInstance().getReceipt(request.getreceipt());
				
				//get user to add to their wallet
				User user = UserDB.getInstance().getUser(receipt.getUserEmail());
				user.getWallet().addToBalance(receipt.getAmount());
			}catch(Exception e) {
				return e.getMessage();
			}
			return "Success Money is returned to User's wallet!";
		}
		//reject and return
		else if (status == -1) {
			request.setStatus(status);
			return "Succes the request status is set to rejected!";
		}
		
		//at this point status must be wrong
		return "Invalid verdict!";
	}
}