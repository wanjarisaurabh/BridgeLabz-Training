package com.generics.onlinemarketplace;

public class Book extends Product {

	// Constructor with price validation
	public Book(String name, double price) {
		super(name, price);
		if (price < 5.0 || price > 200.0) {
			throw new IllegalArgumentException("Book price must be between $5 and $200");
		}
	}

	@Override
	public String getCategory() {
		return "Book";
	}
}