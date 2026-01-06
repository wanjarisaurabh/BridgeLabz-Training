package com.scenariobasedquestion.swiftcart;

// Base Product class
public class Product {
	private String name;
	private double price;
	private String category;
	
	public Product(String name, double price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	// Polymorphic method - can be overridden
	public double calculateDiscount() {
		return 0.0; // No discount by default
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getCategory() {
		return category;
	}
	
	// Only Cart can use setPrice through package-private access
	void setPrice(double price) {
		this.price = price;
	}
	
	public void displayProduct() {
		System.out.println("Product: " + name + " | Price: $" + price + " | Category: " + category);
	}
}
