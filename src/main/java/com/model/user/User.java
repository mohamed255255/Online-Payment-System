package com.Advanced.SE.Project.model.user;

import com.Advanced.SE.Project.model.payment.Wallet;

public class User {
	private String email;
	private String password;
	private Wallet wallet;
	
	public User(String email , String password) {
		this.email = email;
		this.password=password;
		wallet = new Wallet();
	}
	public String getEmail() {
		return this.email;
	}
	public Wallet getWallet() {
		return this.wallet;
	}
	public boolean verifyPassword(String password) {
		return this.password.equals(password);
	}
}