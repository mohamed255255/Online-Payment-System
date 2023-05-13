package com.Advanced.SE.Project.model.discount;
import java.util.Collection;
import java.util.TreeMap;

import com.Advanced.SE.Project.model.service.ServiceType;

public class DiscountDB {
	private TreeMap<String, Discount> discounts;
	private static DiscountDB discountdb = null;
	private DiscountDB() {
		discounts = new TreeMap<>();
	}
	public static DiscountDB getInstance() {
		if(discountdb == null) {
			discountdb = new DiscountDB();
		}
		return discountdb;
	}
	public void add(String promoCode, Double precentage, String service) throws Exception {
		ServiceType serviceType = ServiceType.valueOf(service);
		Discount discount = new Discount(promoCode, precentage, serviceType);
		discounts.put(promoCode, discount);
	}
	public Discount getDiscount(String promocode){
		return discounts.get(promocode);
	}
	public Collection<Discount> getDiscounts(){
		return discounts.values();
	}
}