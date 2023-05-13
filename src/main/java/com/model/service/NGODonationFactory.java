package com.Advanced.SE.Project.model.service;

import java.util.ArrayList;

public class NGODonationFactory implements ServiceFactory {

	@Override
	public Service createInstance() {
		ArrayList<String> label = new ArrayList<>();
		label.add("Non Profitable Oragnization name");
		
		return new Service(new Form("NGO", ServiceType.Donation, label), false);	
	}
}