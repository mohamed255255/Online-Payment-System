package com.Advanced.SE.Project.model.service;

import java.util.ArrayList;

public class CancerHospitalDonationFactory implements ServiceFactory{

	@Override
	public Service createInstance() {
		ArrayList<String> label = new ArrayList<>();
		label.add("Hospital Name");
		
		return new Service(new Form("Cancer Hospital", ServiceType.Donation, label), false);	
	}

}
