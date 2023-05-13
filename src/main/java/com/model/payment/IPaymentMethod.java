package com.Advanced.SE.Project.model.payment;
public interface IPaymentMethod {
	void pay(Double amount) throws Exception;
}