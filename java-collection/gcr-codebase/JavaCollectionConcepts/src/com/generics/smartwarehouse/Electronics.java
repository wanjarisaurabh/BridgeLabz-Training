package com.generics.smartwarehouse;

public class Electronics extends WarehouseItem {
	private String brand;

	// Constructor
	public Electronics(String name, double price, String brand) {
		super(name, price);
		this.brand = brand;
	}

	@Override
	public String getCategory() {
		return "Electronics";
	}

	// good string representation
	@Override
	public String toString() {
		return super.toString() + " | Brand: " + brand;
	}
}