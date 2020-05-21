package com.javatraining.designpattern.mementoexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class CareTaker {

	Stack<ReservationLog.ReservationMemento> history = new Stack();

	public void save(ReservationLog reservationLog) {
		history.push(reservationLog.save());
	}

	public void revert(ReservationLog reservationLog) {
		if (!history.isEmpty()) {
			reservationLog.revert(history.pop());
		} else
			System.out.println("Cannot undo");
	}

}
