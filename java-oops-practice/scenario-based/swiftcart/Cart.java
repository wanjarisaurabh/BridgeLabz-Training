package com.scenariobasedquestion.swiftcart;

import java.util.ArrayList;
import java.util.HashMap;

// Cart class manages products and checkout
public class Cart implements ICheckout {
	private ArrayList<Product> products;
	private HashMap<Product, Integer> quantities; // Track quantity for each product
	private double totalPrice;
	private double couponDiscount;
	
	// Constructor without pre-selected items
	public Cart() {
		this.products = new ArrayList<>();
		this.quantities = new HashMap<>();
		this.totalPrice = 0.0;
		this.couponDiscount = 0.0;
	}
	
	// Constructor with pre-selected items
	public Cart(ArrayList<Product> preSelectedProducts) {
		this.products = new ArrayList<>(preSelectedProducts);
		this.quantities = new HashMap<>();
		for (Product p : preSelectedProducts) {
			quantities.put(p, 1);
		}
		calculateTotal();
		this.couponDiscount = 0.0;
	}
	
	public void addProduct(Product product, int quantity) {
		if (products.contains(product)) {
			int currentQty = quantities.get(product);
			quantities.put(product, currentQty + quantity);
		} else {
			products.add(product);
			quantities.put(product, quantity);
		}
		calculateTotal();
		System.out.println("Added " + quantity + "x " + product.getName() + " to cart");
	}
	
	public void removeProduct(Product product) {
		if (products.contains(product)) {
			products.remove(product);
			quantities.remove(product);
			calculateTotal();
			System.out.println("Removed " + product.getName() + " from cart");
		}
	}
	
	// Encapsulated method - only Cart can update total price
	private void calculateTotal() {
		totalPrice = 0.0;
		for (Product product : products) {
			int quantity = quantities.get(product);
			totalPrice += product.getPrice() * quantity; // Using operators
		}
	}
	
	@Override
	public void applyDiscount() {
		double productDiscount = 0.0;
		
		// Polymorphism: different discount for different product types
		for (Product product : products) {
			int quantity = quantities.get(product);
			productDiscount += product.calculateDiscount() * quantity;
		}
		
		totalPrice = totalPrice - productDiscount - couponDiscount; // Using operators
		System.out.println("Product Discount Applied: $" + String.format("%.2f", productDiscount));
		if (couponDiscount > 0) {
			System.out.println("Coupon Discount Applied: $" + String.format("%.2f", couponDiscount));
		}
	}
	
	public void applyCoupon(double discount) {
		this.couponDiscount = discount;
		System.out.println("Coupon added: $" + discount);
	}
	
	@Override
	public void generateBill() {
		System.out.println("\n========== SWIFTCART BILL ==========");
		System.out.println("Items in Cart:");
		for (Product product : products) {
			int quantity = quantities.get(product);
			double itemTotal = product.getPrice() * quantity;
			System.out.println(quantity + "x " + product.getName() + " @ $" + 
					product.getPrice() + " = $" + String.format("%.2f", itemTotal));
		}
		System.out.println("------------------------------------");
		System.out.println("Total: $" + String.format("%.2f", totalPrice));
		System.out.println("====================================\n");
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public void displayCart() {
		System.out.println("\n--- Cart Contents ---");
		if (products.isEmpty()) {
			System.out.println("Cart is empty");
		} else {
			for (Product product : products) {
				System.out.print(quantities.get(product) + "x ");
				product.displayProduct();
			}
			System.out.println("Current Total: $" + String.format("%.2f", totalPrice));
		}
	}
}
