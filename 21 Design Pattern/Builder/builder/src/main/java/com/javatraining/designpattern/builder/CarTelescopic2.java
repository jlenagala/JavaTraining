package com.javatraining.designpattern.builder;

public class CarTelescopic2 {
	private String insuarance;
	private Boolean etc;
	private String roadAssistance;
	private String dropOfLocation;
	

	public CarTelescopic2(String insuarance, Boolean etc, String roadAssistance, String dropOfLocation) {
		super();
		this.insuarance = insuarance;
		this.etc = etc;
		this.roadAssistance = roadAssistance;
		this.dropOfLocation = dropOfLocation;
	}
	
	public CarTelescopic2(String insuarance, Boolean etc, String roadAssistance) {
		this( insuarance,etc,roadAssistance,null);
	}
	
	public CarTelescopic2(String insuarance, Boolean etc) {
		this(insuarance,etc,null);
	}
	public CarTelescopic2(String insuarance) {
		
		this(insuarance,null);
	}

	@Override
	public String toString() {
		return "CarTelescopic2 [insuarance=" + insuarance + ", etc=" + etc + ", roadAssistance=" + roadAssistance
				+ ", dropOfLocation=" + dropOfLocation + "]";
	}
	
	
	
	

}
