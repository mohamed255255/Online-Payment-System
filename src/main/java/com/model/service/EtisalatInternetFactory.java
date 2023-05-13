package com.Advanced.SE.Project.model.service;

import java.util.ArrayList;

public class EtisalatInternetFactory implements ServiceFactory {

	@Override
	public Service createInstance() {
		ArrayList<String> label = new ArrayList<>();
		label.add("Phone Number");
		
		return new Service(new Form("Etisalat", ServiceType.Internet, label), false);	
	}
}