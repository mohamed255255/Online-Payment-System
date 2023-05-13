package com.Advanced.SE.Project.model.service;
import java.util.List;
import java.util.ArrayList;

public class Form {
	String serviceProviderName;
	ServiceType serviceType;
	List<String> label, response;
    public Form(String serviceProviderName, ServiceType serviceType, ArrayList<String> label){
    	this.serviceProviderName = serviceProviderName;
    	this.serviceType = serviceType;
    	
    	this.label = new ArrayList<>(label);
    	this.label.add("amount");
    	
    	this.response = new ArrayList<>(label.size());
    }
    
	public void setResponse(List<String> response){
		this.response = response;
	}

    public List<String> getLabels() {
    	return label;
    }
    public List<String> getResponses(){
    	return response;
    }
    
    public String getServiceProviderName() {
    	return serviceProviderName;
    }
    public String getServiceType() {
    	return serviceType.name();
    }
}