package com.Advanced.SE.Project.model.payment;

public class Wallet implements IPaymentMethod {
	private Double balance;
	public Wallet(){
		balance = 0d;
	}
	@Override
	public void pay(Double amount) throws Exception {
		if(balance < amount) {
			throw new Exception("There is no enough balance to complete the payment successfully");
		}
		balance -= amount;
	}
	public void addToBalance(Double amount) {
		balance += amount;
	}
	public Double getBalance() {
		return balance;
	}
}