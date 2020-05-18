package com.javatraining.designpattern.chainofresponsibility;

public class Invoice {
	private int invoiceNumber;
	private double amount;
	private double tax;
	public void setTax(double tax) {
		this.tax = tax;
	}
	public Invoice(int invoiceNumber, double amount) {
		super();
		this.invoiceNumber = invoiceNumber;
		this.amount = amount;
	}
	public int getInvoiceNumber() {
		return invoiceNumber;
	}
	public double getAmount() {
		return amount;
	}
	public double getTax() {
		return tax;
	}
	
	
}
