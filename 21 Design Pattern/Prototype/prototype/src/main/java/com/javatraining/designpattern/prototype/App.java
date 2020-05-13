package com.javatraining.designpattern.prototype;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Registry registry=new Registry();
       
       Car car=(Car) registry.getVehicle(VehicleType.CAR);
       System.out.println(car);
       
       car.setType("Lux");
       System.out.println(car);
       
       Car car1=(Car) registry.getVehicle(VehicleType.CAR);
       System.out.println(car1);
    }
}
