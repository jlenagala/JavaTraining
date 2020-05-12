package com.javatraining.designpattern.factorymethod;

import java.util.ArrayList;
import java.util.List;

public abstract class Package {
	protected List<Decoration> decorations=new ArrayList();

	public Package() {
		createPackage();
	}

	protected abstract void createPackage();
	

@Override
public String toString() {
	// TODO Auto-generated method stub
	return "Package{" +" decorations=" + decorations +'}';
}
	
}

