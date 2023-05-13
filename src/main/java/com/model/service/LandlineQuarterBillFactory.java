package com.Advanced.SE.Project.model.service;

import java.util.ArrayList;

public class LandlineQuarterBillFactory implements ServiceFactory{

	@Override
	public Service createInstance() {
		ArrayList<String> label = new ArrayList<>();
		label.add("Telephone Number");
		
		return new Service(new Form("Quarter Bill", ServiceType.Landline, label), false);	
	}
}