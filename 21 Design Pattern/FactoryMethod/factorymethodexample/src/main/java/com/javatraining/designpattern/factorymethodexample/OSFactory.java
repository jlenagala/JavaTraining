package com.javatraining.designpattern.factorymethodexample;


public class OSFactory {
	public static OperatingSystem showOS(OSType osType) {
		switch (osType) {

		case ANDROID:
			return new AndroidOS();
		case APPLE:
			return new AppleOS();
		case OTHER:
			return new OtherOS();

		default:
			return null;

		}
	}

}
