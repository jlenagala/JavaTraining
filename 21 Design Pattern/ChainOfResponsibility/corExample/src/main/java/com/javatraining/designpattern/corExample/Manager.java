package com.javatraining.designpattern.corExample;

public class Manager extends AccessLevel {

	@Override
	protected double getAllowable() {
		// TODO Auto-generated method stub
		return BASE*10;
	}

	@Override
	protected String getRole() {
		// TODO Auto-generated method stub
		return "Manager";
	}
	

}
