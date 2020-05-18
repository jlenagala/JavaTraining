package com.javatraining.designpattern.chainofresponsibility;

public class BTT extends Handler{

	@Override
	public double applyTax(Invoice invoice) {
		
		invoice.setTax(invoice.getTax()+invoice.getAmount()*0.03);
		System.out.println("BTT Calculated");
		if(invoice.getAmount()>200 && invoice.getAmount()<=300 ) {
			return invoice.getTax();
		}
		else {
			return successor.applyTax(invoice);
		}
		
	}

}
