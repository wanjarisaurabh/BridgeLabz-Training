package com.generics.smartwarehouse;

public class Furniture extends WarehouseItem {
	private String material;

	// Constructor
	public Furniture(String name, double price, String material) {
		super(name, price);
		this.material = material;
	}

	@Override
	public String getCategory() {
		return "Furniture";
	}

	// good string representation
	@Override
	public String toString() {
		return super.toString() + " | Material: " + material;
	}
}