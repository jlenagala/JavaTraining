package com.javatraining.designpattern.corExample;

public class CEO extends AccessLevel {

	@Override
	protected double getAllowable() {
		// TODO Auto-generated method stub
		return BASE * 100000;

	}

	@Override
	protected String getRole() {
		// TODO Auto-generated method stub
		return "CEO";
	}

	@Override
	protected void processRequest(AccessRequest accessRequest) {
		if (accessRequest.getAmount() < this.getAllowable()) {
			System.out.println("Approved " + getRole());
		}

		else if (accessLevel != null) {
			accessLevel.processRequest(accessRequest);

		}
	}

}
