package com.Advanced.SE.Project.model.service;

import java.util.Collection;
import java.util.TreeMap;

public class ServiceDB {
	private TreeMap<ServiceType, TreeMap<String, ServiceFactory>> services;
	private static ServiceDB serviceProviderdb;
	private ServiceDB() {
		services = new TreeMap<>();
		buildDB();
	}
	public static ServiceDB getInstance() {
		if(serviceProviderdb == null) {
			serviceProviderdb = new ServiceDB();
		}
		return serviceProviderdb;
	}
	public Collection<String> getServices(String servicetype) throws Exception{
		ServiceType serviceType = ServiceType.valueOf(servicetype);
		return services.get(serviceType).keySet();
	}
	public Service getService(String servicetype, String name) throws Exception{
		ServiceType serviceType = ServiceType.valueOf(servicetype);
		if(services.get(serviceType) == null)
			return null;
		return services.get(serviceType).get(name).createInstance();
	}
    public void buildDB(){
    	//add services here
		TreeMap<String, ServiceFactory> currentservice = new TreeMap<>();
		//add mobile
		currentservice.put("Etisalat", new EtisalatMobileFactory());
		currentservice.put("WE", new WEMobileFactory());
		currentservice.put("Vodafone", new VodafoneMobileFactory());
		currentservice.put("Orange", new OrangeMobileFactory());
		services.put(ServiceType.Mobile, currentservice);
		currentservice = new TreeMap<>();
		//add internet
		currentservice.put("Etisalat", new EtisalatInternetFactory());
		currentservice.put("WE", new WEInternetFactory());
		currentservice.put("Vodafone", new VodafoneInternetFactory());
		currentservice.put("Orange", new OrangeInternetFactory());
		services.put(ServiceType.Internet, currentservice);
		currentservice = new TreeMap<>();
		//add land line
		currentservice.put("Monthly", new LandlineMonthlyBillFactory());
		currentservice.put("Quarter", new LandlineQuarterBillFactory());
		services.put(ServiceType.Landline, currentservice);
		currentservice = new TreeMap<>();
		//add donations
		currentservice.put("NGOs", new NGODonationFactory());
		currentservice.put("School", new SchoolDonationFactory());
		currentservice.put("Cancer Hospital", new CancerHospitalDonationFactory());
		services.put(ServiceType.Donation, currentservice);
    }
}