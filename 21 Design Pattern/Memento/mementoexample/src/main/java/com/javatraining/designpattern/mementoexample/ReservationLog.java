package com.javatraining.designpattern.mementoexample;

import java.util.ArrayList;

public class ReservationLog {

	ArrayList<Reservation> reservations = new ArrayList<Reservation>();

	public void addReservation(Reservation reservation) {
		reservations.add(reservation);
	}

	public ArrayList<Reservation> getReservations() {

		return (ArrayList<Reservation>) reservations.clone();

	}



	@Override
	public String toString() {
		return "ReservationBook [reservations=" + reservations + "]";
	}

	public ReservationMemento save() {
		return new ReservationMemento(getReservations());

	}
	public void revert(ReservationMemento reservationMemento) {
		reservations=reservationMemento.getReservations();
	}

	static class ReservationMemento {
		ArrayList<Reservation> reservations;

		public ReservationMemento(ArrayList<Reservation> reservations) {
			super();
			this.reservations = reservations;
		}

		private ArrayList<Reservation> getReservations() {
			return reservations;
		}

	}

}
