package com.generics.onlinemarketplace;

public class DiscountUtil {

	// Generic method with bounded type parameter
	public static <T extends Product> void applyDiscount(T product, double percentage) {
		if (percentage < 0 || percentage > 100) {
			System.out.println("Invalid percentage.");
			return;
		}
		double newPrice = product.getPrice() * (1 - percentage / 100.0);
		product.setPrice(newPrice);
	}
}