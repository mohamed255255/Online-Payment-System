package com.Advanced.SE.Project.model.discount;
import com.Advanced.SE.Project.model.service.ServiceType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Discount {
	private String promoCode;
	private Double precentage;
	private ServiceType service;
}