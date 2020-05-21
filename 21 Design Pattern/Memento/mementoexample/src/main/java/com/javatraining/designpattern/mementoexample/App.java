package com.javatraining.designpattern.mementoexample;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	CareTaker careTaker=new CareTaker();
    	ReservationLog reservationLog=new ReservationLog();
    	reservationLog.addReservation(new Reservation("re 001"));
    	careTaker.save(reservationLog);
    	System.out.println(reservationLog);
    	
    	reservationLog.addReservation(new Reservation("re 002"));
    	careTaker.save(reservationLog);
    	System.out.println(reservationLog);
    	
    	reservationLog.addReservation(new Reservation("re 003"));
    	careTaker.save(reservationLog);
    	System.out.println(reservationLog);
    	
    	reservationLog.addReservation(new Reservation("re 004"));
    	careTaker.save(reservationLog);
    	System.out.println(reservationLog);
    	
    	reservationLog.addReservation(new Reservation("re 005"));
    	careTaker.save(reservationLog);
    	System.out.println(reservationLog);
    	
    	reservationLog.addReservation(new Reservation("re 006"));
    	//careTaker.save(reservationBook);
    	System.out.println(reservationLog);
    	
    	careTaker.revert(reservationLog);
    	System.out.println(reservationLog);
    	
    	reservationLog.addReservation(new Reservation("book7"));
    	//careTaker.save(reservationBook);
    	System.out.println(reservationLog);
    	careTaker.revert(reservationLog);
    	System.out.println(reservationLog);
    	careTaker.revert(reservationLog);
    	System.out.println(reservationLog);
    	careTaker.revert(reservationLog);
    	System.out.println(reservationLog);
    	careTaker.revert(reservationLog);
//    	System.out.println(reservationBook);
//    	careTaker.revert(reservationBook);
//    	System.out.println(reservationBook);
//    	careTaker.revert(reservationBook);
//    	System.out.println(reservationBook);
    }
}
