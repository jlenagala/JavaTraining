package com.javatraining.designpattern.factorymethod;

public class PlatinumPackage extends Package {

	@Override
	protected void createPackage() {
		// TODO Auto-generated method stub
		decorations.add(new BridalDeco());
		decorations.add(new BridesMaidDeco());
		decorations.add(new ParentsDeco());
	}
	

}
