package com.javatraining.designpattern.builder;

public class Car {

	private final String insuarance;
	private final Boolean etc;
	private final String roadAssistance;
	private final String dropOfLocation;

	
	public Car(CarBuilder carBuilder) {

		this.insuarance = carBuilder.insuarance;
		this.etc = carBuilder.etc;
		this.roadAssistance = carBuilder.roadAssistance;
		this.dropOfLocation = carBuilder.dropOfLocation;
	}

	static class CarBuilder {

		public Car build() {
			return new Car(this);
		}

		private String insuarance;
		private Boolean etc;
		private String roadAssistance;
		private String dropOfLocation;

		public CarBuilder(String insuarance) {
			this.insuarance = insuarance;
		}

		public CarBuilder etc(Boolean etc) {
			this.etc = etc;
			return this;
		}

		public CarBuilder roadAssistance(String roadAssistance) {
			this.roadAssistance = roadAssistance;
			return this;
		}

		public CarBuilder dropOfLocation(String dropOfLocation) {
			this.dropOfLocation = dropOfLocation;
			return this;
		}

	}

	@Override
	public String toString() {
		return "Car [insuarance=" + insuarance + ", etc=" + etc + ", roadAssistance=" + roadAssistance
				+ ", dropOfLocation=" + dropOfLocation + "]";
	}

}
