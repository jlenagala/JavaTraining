package com.javatraining.designpattern.memento;

public class Item {
	String name;

	@Override
	public String toString() {
		return "Item [name=" + name + "]";
	}

	public Item(String name) {
		super();
		this.name = name;
	}
	

	
}
