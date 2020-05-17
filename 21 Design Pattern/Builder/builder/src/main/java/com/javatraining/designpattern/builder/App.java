package com.javatraining.designpattern.builder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	Phone phone=new PhoneBuilder().setOs("Android").setRam(5).getPhone();
//        System.out.println(phone);
    	
    	CarTelescopic1 carTelescopic1=new CarTelescopic1("full");
    	System.out.println(carTelescopic1);
    	
    	CarTelescopic2 carTelescopic2=new CarTelescopic2("full");
    	System.out.println(carTelescopic2);
    	
    	Car.CarBuilder carBuilder=new Car.CarBuilder("full");
    	Car car=carBuilder.dropOfLocation("lA").roadAssistance("full").build();
    	System.out.println(car);
    }
}
