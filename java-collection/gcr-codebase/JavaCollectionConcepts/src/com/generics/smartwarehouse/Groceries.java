package com.generics.smartwarehouse;

public class Groceries extends WarehouseItem {
	private String expiryDate;

	// Constructor
	public Groceries(String name, double price, String expiryDate) {
		super(name, price);
		this.expiryDate = expiryDate;
	}

	@Override
	public String getCategory() {
		return "Groceries";
	}

	// good string representation
	@Override
	public String toString() {
		return super.toString() + " | Expiry: " + expiryDate;
	}
}