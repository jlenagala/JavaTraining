package com.javatraining.designpattern.builder;

public class CarTelescopic1 {
	private String insuarance;
	private Boolean etc;
	private String roadAssistance;
	private String dropOfLocation;

	public CarTelescopic1(String insuarance) {
		super();
		this.insuarance = insuarance;
	}
	public CarTelescopic1(String insuarance, Boolean etc) {
		this(insuarance);
		this.etc = etc;
	}
	public CarTelescopic1(String insuarance, Boolean etc, String roadAssistance) {
		this( insuarance,etc);
		this.etc = etc;
		this.roadAssistance = roadAssistance;
	}

	public CarTelescopic1(String insuarance, Boolean etc, String roadAssistance, String dropOfLocation) {
		this(insuarance, etc,roadAssistance);
		this.dropOfLocation = dropOfLocation;
	}
	@Override
	public String toString() {
		return "CarTelescopic1 [insuarance=" + insuarance + ", etc=" + etc + ", roadAssistance=" + roadAssistance
				+ ", dropOfLocation=" + dropOfLocation + "]";
	}

}
