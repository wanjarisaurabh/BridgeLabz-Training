/*
2. Dynamic Online Marketplace
Concepts: Type Parameters, Generic Methods, Bounded Type Parameters
Problem Statement:
	Build a generic product catalog for an online marketplace that supports various product types like Books, Clothing, and Gadgets. Each product type has a specific price range and category.
Hints:
	Define a generic class Product<T> where T is restricted to a category (BookCategory, ClothingCategory, etc.).
	Implement a generic method to apply discounts dynamically (<T extends Product> void applyDiscount(T product, double percentage)).
	Ensure type safety while allowing multiple product categories to exist in the same catalog.

*/

package com.generics.onlinemarketplace;

public class OnlineMarketplaceApp {

	public static void main(String[] args) {
		Catalog catalog = new Catalog();

		// Create different product types
		Product book1 = new Book("Java Programming", 49.99);
		Product book2 = new Book("Science Fiction Novel", 19.99);
		Product shirt = new Clothing("Cotton Shirt", 29.99);
		Product phone = new Gadget("Smartphone Pro", 1199.99);
		Product laptop = new Gadget("Gaming Laptop", 1899.99);

		// Add mixed types to same catalog
		catalog.addProduct(book1);
		catalog.addProduct(book2);
		catalog.addProduct(shirt);
		catalog.addProduct(phone);
		catalog.addProduct(laptop);

		System.out.println("Dynamic Online Marketplace\n");
		catalog.displayCatalog();

		// Apply discount to specific product
		System.out.println("Applying 20% discount to Java book:");
		DiscountUtil.applyDiscount(book1, 20);
		System.out.println("Updated: " + book1 + "\n");

		// Site-wide discount
		System.out.println("Applying 10% site-wide discount:");
		for (Product p : catalog.getProducts()) {
			DiscountUtil.applyDiscount(p, 10);
		}

		catalog.displayCatalog();
	}
}