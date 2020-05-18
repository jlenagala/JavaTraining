package com.javatraining.designpattern.corExample;

public abstract class AccessLevel {

	protected static final double BASE = 1000;

	protected AccessLevel accessLevel;

	abstract protected double getAllowable();

	abstract protected String getRole();

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void processRequest(AccessRequest accessRequest) {

		if (accessRequest.getAmount() < this.getAllowable()) {
			System.out.println("Approved"+getRole());
		}

		else if (accessLevel != null) {
			accessLevel.processRequest(accessRequest);

		}

	}

}
