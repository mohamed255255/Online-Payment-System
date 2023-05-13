package com.Advanced.SE.Project.model.receipt;
import java.util.ArrayList;

import com.Advanced.SE.Project.model.service.Form;

public class ReceiptDB {
	private ArrayList<Receipt> receipts; 
	private static ReceiptDB receiptdb;
	
	private ReceiptDB() {
		receipts = new ArrayList<Receipt>();
	}
	
	public static ReceiptDB getInstance() {
		if(receiptdb == null) {
			receiptdb = new ReceiptDB();
		}
		return receiptdb; 
	}
	public Receipt getReceipt(int receiptId) throws Exception {
		if(receiptId > receipts.size())
			throw new Exception("No receipt with such Id");
		return receipts.get(receiptId - 1);
	}
	public ArrayList<Receipt> getReceipts(){
		return receipts;
	}
	
	public int addReceipt(String userEmail , Form form, double amount) {
		receipts.add( new Receipt(receipts.size() + 1 , userEmail, form, amount) );
		return receipts.size();
	}
}