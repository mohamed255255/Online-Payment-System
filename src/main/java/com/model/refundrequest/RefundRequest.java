package com.Advanced.SE.Project.model.refundrequest;

import lombok.Setter;

@Setter
public class RefundRequest {
	private int requestId, receiptId, status; 
	private String reason;
	
	public RefundRequest(int requestId, int receiptId, String reason) {
		this.requestId = requestId;
		this.receiptId = receiptId;
		this.reason = reason;
		this.status = 0;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getrequestnumber() {
		return requestId;
	}
	public int getreceipt() {
		return receiptId; 
	}
	public String getreason() {
		return reason; 
	}
	public int getstatus() {
		return status;
	}
}