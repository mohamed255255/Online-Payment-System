package com.Advanced.SE.Project.model.receipt;
import java.time.LocalDateTime;
import com.Advanced.SE.Project.model.service.Form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Receipt{
	private int receiptId;
	private LocalDateTime date;
	private String userEmail; 
	private Form form;
	private double amount;
	
	public Receipt(int receiptId, String userEmail, Form form, double amount) {
		this.receiptId = receiptId;
		this.date = LocalDateTime.now();
		this.userEmail = userEmail;
		this.form = form;
		this.amount = amount; 
	}
	
	public boolean match(int receiptId) {
		return (this.receiptId == receiptId);
	}
	
	public int getReceiptId() {
		return this.receiptId; 
	}
	public LocalDateTime getTime() {
		return date;
	}
	public String getUserEmail() {
		return this.userEmail;
	}
	public Form getForm() {
		return this.form;
	}
	public double getAmount() {
		return this.amount;
	}
}