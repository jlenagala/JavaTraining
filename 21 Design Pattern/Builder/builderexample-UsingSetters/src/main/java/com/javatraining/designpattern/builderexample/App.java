package com.javatraining.designpattern.builderexample;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Phone phone=new PhoneBuilder().setOs("Android").setRam(5).getPhone();
        System.out.println(phone);
    }
}
