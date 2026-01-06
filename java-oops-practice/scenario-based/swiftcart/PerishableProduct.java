package com.scenariobasedquestion.swiftcart;

// Perishable products have higher discount
public class PerishableProduct extends Product {
	private String expiryDate;
	
	public PerishableProduct(String name, double price, String category, String expiryDate) {
		super(name, price, category);
		this.expiryDate = expiryDate;
	}
	
	@Override
	public double calculateDiscount() {
		return getPrice() * 0.15; // 15% discount on perishable items
	}
	
	public String getExpiryDate() {
		return expiryDate;
	}
	
	@Override
	public void displayProduct() {
		super.displayProduct();
		System.out.println("  Type: Perishable | Expiry: " + expiryDate);
	}
}
