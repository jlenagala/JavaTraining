package com.javatraining.designpattern.factorymethodexample;


public class App 
{
    public static void main( String[] args )
    {	
    	OperatingSystem aPackage = OSFactory.showOS(OSType.ANDROID);
	System.out.println(aPackage);

	OperatingSystem aPackage1 = OSFactory.showOS(OSType.APPLE);
	System.out.println(aPackage1);

	OperatingSystem aPackage2 = OSFactory.showOS(OSType.OTHER);
	System.out.println(aPackage2);
    }
}
