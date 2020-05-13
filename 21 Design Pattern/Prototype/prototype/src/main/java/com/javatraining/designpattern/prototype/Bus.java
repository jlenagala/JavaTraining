package com.javatraining.designpattern.prototype;

public class Bus extends Vehicle {
	private int numberOfSeats;

	@Override
	public String toString() {
		return "Bus [numberOfSeats=" + numberOfSeats + "]";
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

}
