package com.generics.onlinemarketplace;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
	private List<Product> products = new ArrayList<>();

	// Adds any product type
	public void addProduct(Product product) {
		products.add(product);
	}

	// Displays all products (mixed types)
	public void displayCatalog() {
		if (products.isEmpty()) {
			System.out.println("Catalog is empty.\n");
			return;
		}
		System.out.println("--- Product Catalog ---");
		for (Product product : products) {
			System.out.println(product);
		}
		System.out.println();
	}

	// Returns product list
	public List<Product> getProducts() {
		return products;
	}
}	