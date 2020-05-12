package com.javatraining.designpattern.factorymethod;

public class SilverPackage extends Package {

	@Override
	protected void createPackage() {
		// TODO Auto-generated method stub
		decorations.add(new BridalDeco());
		decorations.add(new BridesMaidDeco());
		
	}
	

}
