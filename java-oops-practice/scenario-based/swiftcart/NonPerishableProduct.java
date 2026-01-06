package com.scenariobasedquestion.swiftcart;

// Non-perishable products have standard discount
public class NonPerishableProduct extends Product {
	private int shelfLife; // in months
	
	public NonPerishableProduct(String name, double price, String category, int shelfLife) {
		super(name, price, category);
		this.shelfLife = shelfLife;
	}
	
	@Override
	public double calculateDiscount() {
		return getPrice() * 0.05; // 5% discount on non-perishable items
	}
	
	public int getShelfLife() {
		return shelfLife;
	}
	
	@Override
	public void displayProduct() {
		super.displayProduct();
		System.out.println("  Type: Non-Perishable | Shelf Life: " + shelfLife + " months");
	}
}
