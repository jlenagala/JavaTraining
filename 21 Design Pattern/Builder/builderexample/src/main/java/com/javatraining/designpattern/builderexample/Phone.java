package com.javatraining.designpattern.builderexample;

public class Phone {
	
	private String os;
	private int ram;
	private String processor;
	private double screenSize;
	private int battery;

	public Phone(PhoneBuilder phoneBuilder) {
		this.os =phoneBuilder.os;
		this.ram = phoneBuilder.ram;
		this.processor = phoneBuilder.processor;
		this.screenSize = phoneBuilder.screenSize;
		this.battery = phoneBuilder.battery;
	}

	static class PhoneBuilder {
		private String os;
		private int ram;
		private String processor;
		private double screenSize;
		private int battery;

		public Phone build() {
			return new Phone(this);
		}

		public PhoneBuilder(String os) {
			this.os = os;
		}

		public PhoneBuilder ram(int ram) {
			this.ram = ram;
			return this;
		}

		public PhoneBuilder processor(String processor) {
			this.processor = processor;
			return this;
		}

		public PhoneBuilder screenSize(double screenSize) {
			this.screenSize = screenSize;
			return this;
		}

		public PhoneBuilder battery(int battery) {
			this.battery = battery;
			return this;
		}

	}

	@Override
	public String toString() {
		return "Phone [os=" + os + ", ram=" + ram + ", processor=" + processor + ", screenSize=" + screenSize
				+ ", battery=" + battery + "]";
	}

}
