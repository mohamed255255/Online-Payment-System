package com.Advanced.SE.Project.model.service;

import java.util.ArrayList;

public class SchoolDonationFactory implements ServiceFactory {

	@Override
	public Service createInstance() {
		ArrayList<String> label = new ArrayList<>();
		label.add("School name");
		
		return new Service(new Form("School", ServiceType.Donation, label), false);	
	}
}