package com.generics.smartwarehouse;

public abstract class WarehouseItem {
	private static int nextId = 1;

	private int id;
	private String name;
	private double price;

	// Constructor
	public WarehouseItem(String name, double price) {
		this.id = nextId++;
		this.name = name;
		this.price = price;
	}

	// Returns item ID
	public int getId() {
		return id;
	}

	// Returns item name
	public String getName() {
		return name;
	}

	// Returns item price
	public double getPrice() {
		return price;
	}

	// Subclasses provide category
	public abstract String getCategory();

	// good string representation
	@Override
	public String toString() {
		return String.format("%s | Name: %s | ID: %d | Price: $%.2f", getCategory(), name, id, price);
	}
}