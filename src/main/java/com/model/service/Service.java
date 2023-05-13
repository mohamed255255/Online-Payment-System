package com.Advanced.SE.Project.model.service;
public class Service{
	private Form form;
	private boolean acceptCOD;
    
	public Service(Form form, boolean acceptCOD){
    	this.form = form;
    	this.acceptCOD = acceptCOD;
    }
    public boolean acceptCOD() {
    	return acceptCOD;
    }
    public Form getForm(){
    	return form;
    }
    public void handler(Form form) throws Exception {
    	//if this was a real project, here form or some kind of message would be send to ServiceProvider
    }
}