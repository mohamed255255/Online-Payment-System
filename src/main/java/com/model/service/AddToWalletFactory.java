package com.Advanced.SE.Project.model.service;

import java.util.ArrayList;

public class AddToWalletFactory implements ServiceFactory {

	@Override
	public Service createInstance() {
		ArrayList<String> label = new ArrayList<>();
		
		return new Service(new Form("Add To Wallet", ServiceType.Local, label), false);
	}
}