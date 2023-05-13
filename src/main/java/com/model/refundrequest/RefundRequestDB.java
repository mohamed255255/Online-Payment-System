package com.Advanced.SE.Project.model.refundrequest;
import java.util.ArrayList;

public class RefundRequestDB {
	private ArrayList <RefundRequest> refundrequests; 
	private static RefundRequestDB refundrequestdb = null; 
	
	private RefundRequestDB() {
		refundrequests = new ArrayList<RefundRequest>();
	}
	
	public static RefundRequestDB getInstance(){
		if(refundrequestdb == null) {
			refundrequestdb = new RefundRequestDB();
		}
		return refundrequestdb; 
	}
	public int add(int receiptId, String reason) throws Exception{
		for(RefundRequest request: refundrequests) {
			if(request.getreceipt() != receiptId) continue;
			
			throw new Exception("The request on this receipt exists already"); 
		}
		refundrequests.add( new RefundRequest(refundrequests.size()+1, receiptId, reason) );
		return refundrequests.size();
	}
	
	public ArrayList<RefundRequest> getRefundRequests (){
		return refundrequests; 
	}
	
	public RefundRequest getRefundRequest(int req_num) throws Exception {
		if(req_num > refundrequests.size())
			throw new Exception("No refund request with such reqId");
		return refundrequests.get(req_num - 1);
	}
}