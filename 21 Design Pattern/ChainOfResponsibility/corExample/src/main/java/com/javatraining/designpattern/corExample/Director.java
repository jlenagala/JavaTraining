package com.javatraining.designpattern.corExample;

public class Director extends AccessLevel {

	@Override
	protected double getAllowable() {
		// TODO Auto-generated method stub
		return BASE*20;
	}

	@Override
	protected String getRole() {
		// TODO Auto-generated method stub
		return "Director";
	}
	
	@Override
	protected void processRequest(AccessRequest accessRequest) {
		if (accessRequest.getAmount() < this.getAllowable()) {
		System.out.println("Approved"+getRole());
	}

	else if (accessLevel != null) {
		accessLevel.processRequest(accessRequest);

	}
	}

}
