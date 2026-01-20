package com.generics.onlinemarketplace;

public class Gadget extends Product {

	// Constructor with price validation
	public Gadget(String name, double price) {
		super(name, price);
		if (price < 50.0 || price > 5000.0) {
			throw new IllegalArgumentException("Gadget price must be between $50 and $5000");
		}
	}

	@Override
	public String getCategory() {
		return "Gadget";
	}
}