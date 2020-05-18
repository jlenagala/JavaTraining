package com.javatraining.designpattern.corExample;

public class AccessRequest {
	private double amount;
	private String purpose;
	public AccessRequest(double amount, String purpose) {
		super();
		this.amount = amount;
		this.purpose = purpose;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	
	

}
