package com.Advanced.SE.Project.model.service;

import java.util.ArrayList;

public class LandlineMonthlyBillFactory implements ServiceFactory{

	@Override
	public Service createInstance() {
		ArrayList<String> label = new ArrayList<>();
		label.add("Telephone Number");
		
		return new Service(new Form("Monthly Bill", ServiceType.Landline, label), false);	
	}
}