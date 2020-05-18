package com.javatraining.designpattern.chainofresponsibility;

public class SSF extends Handler{

	@Override
	public double applyTax(Invoice invoice) {
		
		invoice.setTax(invoice.getTax()+invoice.getAmount()*0.04);
		System.out.println("SSF Calculated");
		return invoice.getTax();
		
	}

}
