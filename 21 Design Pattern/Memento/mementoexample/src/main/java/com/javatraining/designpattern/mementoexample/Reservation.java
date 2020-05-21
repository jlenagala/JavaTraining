package com.javatraining.designpattern.mementoexample;

public class Reservation {
 private String reservationNo;

public Reservation(String reservationNo) {
	super();
	this.reservationNo = reservationNo;
}

@Override
public String toString() {
	return "Reservation [reservationNo=" + reservationNo + "]";
}
 
 
}
