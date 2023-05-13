package com.Advanced.SE.Project.model.service;

import java.util.ArrayList;

public class OrangeInternetFactory implements ServiceFactory{

	@Override
	public Service createInstance() {
		ArrayList<String> label = new ArrayList<>();
		label.add("Phone Number");
		
		return new Service(new Form("Orange", ServiceType.Internet, label), false);	
	}

}