package com.scenariobasedquestion.swiftcart;

import java.util.ArrayList;

public class SwiftCartDemo {
	public static void main(String[] args) {
		System.out.println("=== SwiftCart - Grocery Shopping App ===\n");
		
		// Create different types of products
		PerishableProduct milk = new PerishableProduct("Milk", 3.99, "Dairy", "2026-01-15");
		PerishableProduct bread = new PerishableProduct("Whole Wheat Bread", 2.49, "Bakery", "2026-01-10");
		NonPerishableProduct rice = new NonPerishableProduct("Basmati Rice", 15.99, "Grains", 24);
		NonPerishableProduct pasta = new NonPerishableProduct("Pasta", 4.99, "Grains", 36);
		Product soap = new Product("Hand Soap", 1.99, "Personal Care");
		
		// Display products
		System.out.println("--- Available Products ---");
		milk.displayProduct();
		bread.displayProduct();
		rice.displayProduct();
		pasta.displayProduct();
		soap.displayProduct();
		
		// Create empty cart
		Cart cart1 = new Cart();
		cart1.addProduct(milk, 2);
		cart1.addProduct(bread, 1);
		cart1.addProduct(rice, 1);
		
		cart1.displayCart();
		
		// Generate bill before discount
		cart1.generateBill();
		
		// Apply coupon and discounts
		System.out.println("\n--- Applying Discounts ---");
		cart1.applyCoupon(5.0);
		cart1.applyDiscount();
		
		// Generate final bill
		cart1.generateBill();
		
		System.out.println("\n--- Creating Cart with Pre-selected Items ---");
		ArrayList<Product> preSelected = new ArrayList<>();
		preSelected.add(pasta);
		preSelected.add(soap);
		
		Cart cart2 = new Cart(preSelected);
		cart2.displayCart();
		cart2.addProduct(milk, 1);
		
		cart2.applyDiscount();
		cart2.generateBill();
	}
}
