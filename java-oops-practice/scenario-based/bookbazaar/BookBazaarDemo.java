package com.scenariobasedquestion.bookbazaar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main demo class for BookBazaar system with user input
 */
public class BookBazaarDemo {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> inventory = new ArrayList<>();
        
        // Initialize some books in inventory
        inventory.add(new EBook("Java Programming", "John Doe", 25.99, 50, 15.5));
        inventory.add(new PrintedBook("Data Structures", "Jane Smith", 35.50, 30, 450));
        inventory.add(new EBook("Python Basics", "Mike Johnson", 20.00, 100, 10.2));
        inventory.add(new PrintedBook("Algorithm Design", "Sarah Williams", 45.00, 20, 600));
        
        System.out.println("======================================");
        System.out.println("  Welcome to BookBazaar Bookstore!");
        System.out.println("======================================\n");
        
        // Get customer name
        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();
        
        // Create order
        Order order = new Order(customerName);
        
        boolean shopping = true;
        
        while (shopping) {
            // Display available books
            System.out.println("\n===== Available Books =====");
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println("\n[" + (i + 1) + "]");
                inventory.get(i).displayInfo();
                System.out.println("Discounted Price: $" + 
                    String.format("%.2f", inventory.get(i).applyDiscount()));
                System.out.println("---");
            }
            
            // Get user choice
            System.out.print("\nEnter book number to add to cart (0 to checkout): ");
            int choice = scanner.nextInt();
            
            if (choice == 0) {
                shopping = false;
            } else if (choice > 0 && choice <= inventory.size()) {
                Book selectedBook = inventory.get(choice - 1);
                
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                
                if (quantity > 0) {
                    order.addBook(selectedBook, quantity);
                } else {
                    System.out.println("Invalid quantity!");
                }
            } else {
                System.out.println("Invalid choice!");
            }
        }
        
        // Display order summary
        order.displayOrderSummary();
        
        // Confirm order
        System.out.print("Confirm order? (yes/no): ");
        scanner.nextLine(); // consume newline
        String confirm = scanner.nextLine();
        
        if (confirm.equalsIgnoreCase("yes")) {
            if (order.completeOrder()) {
                System.out.println("\n✓ Order placed successfully!");
                System.out.println("Total Amount: $" + String.format("%.2f", order.calculateTotal()));
                System.out.println("Order Status: " + order.getOrderStatus());
            } else {
                System.out.println("\n✗ Order failed!");
            }
        } else {
            System.out.println("\nOrder cancelled.");
        }
        
        System.out.println("\nThank you for shopping at BookBazaar!");
        scanner.close();
    }
}
