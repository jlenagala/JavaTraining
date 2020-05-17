package com.javatraining.designpattern.builderexample;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//Phone phone=new PhoneBuilder().setOs("Android").setRam(5).getPhone();
        
    	
    	Phone.PhoneBuilder phoneBuilder=new Phone.PhoneBuilder("full");
    	Phone phone=phoneBuilder.screenSize(8).ram(8).build();
    	System.out.println(phone);
    }
}
