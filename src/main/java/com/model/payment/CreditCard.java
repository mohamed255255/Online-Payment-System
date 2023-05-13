package com.Advanced.SE.Project.model.payment;

public class CreditCard implements IPaymentMethod{
	private String CreditCardNum;
	private int CVV;
	public CreditCard(String CreditCardNum, int CVV){
		this.CreditCardNum = CreditCardNum;
		this.CVV = CVV;
	}
	@Override
	public void pay(Double amount) throws Exception {
		//here should a message send to the bank with credit card number and cvv to complete payment
	}
}