package com.javatraining.designpattern.corExample;

public class Role extends AccessLevel {

	@Override
	protected double getAllowable() {
		// TODO Auto-generated method stub
		return accessLevel.getAllowable();
	}

	@Override
	protected String getRole() {
		// TODO Auto-generated method stub
		return accessLevel.getRole();
	}

	@Override
	protected void processRequest(AccessRequest accessRequest) {
		System.out.println("Approved " + getRole());

	}

}
