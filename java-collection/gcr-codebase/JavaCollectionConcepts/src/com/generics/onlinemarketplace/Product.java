package com.generics.onlinemarketplace;

public abstract class Product {
	private String name;
	private double price;

	// Constructor
	protected Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	// Returns category (implemented by subclasses)
	public abstract String getCategory();

	// good string representation
	@Override
	public String toString() {
		return String.format("%s: %s - $%.2f", getCategory(), name, price);
	}
}