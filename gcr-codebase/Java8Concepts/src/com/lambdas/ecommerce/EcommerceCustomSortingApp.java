package com.lambdas.ecommerce;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EcommerceCustomSortingApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // sample products (as if from online shop database)
        List<Product> products = new ArrayList<>();
        products.add(new Product("Wireless Earbuds", 2499.00, 4.3, 15));
        products.add(new Product("Smart Watch", 5999.00, 4.7, 20));
        products.add(new Product("Bluetooth Speaker", 1799.00, 4.1, 10));
        products.add(new Product("Gaming Mouse", 1299.00, 4.5, 25));
        products.add(new Product("Portable Charger", 899.00, 4.0, 5));

        System.out.println("E-Commerce Custom Sorting Demo");
        System.out.println("Available sorting options for current campaign:");
        System.out.println("1 - Sort by Price (Low to High)");
        System.out.println("2 - Sort by Rating (High to Low)");
        System.out.println("3 - Sort by Discount % (High to Low)");
        System.out.print("Choose sorting criteria (1-3): ");

        int choice = input.nextInt();
        input.nextLine(); // consume newline

        // define different Comparator behaviors using lambda expressions
        Comparator<Product> comparator;

        switch (choice) {
            case 1:
                // sort by price ascending
                comparator = (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice());
                break;

            case 2:
                // sort by rating descending
                comparator = (p1, p2) -> Double.compare(p2.getRating(), p1.getRating());
                break;

            case 3:
                // sort by discount percentage descending
                comparator = (p1, p2) -> Integer.compare(p2.getDiscountPercent(), p1.getDiscountPercent());
                break;

            default:
                System.out.println("Invalid choice. Showing products in original order.");
                comparator = (_, _) -> 0; // no sorting
                break;
        }

        // sort the list using the dynamically chosen comparator (lambda)
        products.sort(comparator);

        System.out.println("\nProducts after sorting:");
        System.out.println("-------------------------------------------------------------");
        for (Product p : products) {
            System.out.println(p);
        }
        System.out.println("-------------------------------------------------------------");

        input.close();
    }
}