package com.scenariobasedquestion.bookbazaar;

import java.util.ArrayList;
import java.util.List;

/**
 * Order class to manage user orders
 */
public class Order {
    private String userName;
    private List<Book> books;
    private List<Integer> quantities;
    private String orderStatus; // Access modifier restriction
    
    public Order(String userName) {
        this.userName = userName;
        this.books = new ArrayList<>();
        this.quantities = new ArrayList<>();
        this.orderStatus = "PENDING";
    }
    
    // Add book to order
    public void addBook(Book book, int quantity) {
        if (book.getStock() >= quantity) {
            books.add(book);
            quantities.add(quantity);
            System.out.println(quantity + " x " + book.getTitle() + " added to order.");
        } else {
            System.out.println("Insufficient stock for " + book.getTitle());
        }
    }
    
    // Calculate total cost using operators: price × quantity - discount
    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            int quantity = quantities.get(i);
            double discountedPrice = book.applyDiscount();
            total += discountedPrice * quantity;
        }
        return total;
    }
    
    // Complete order and update inventory
    public boolean completeOrder() {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            int quantity = quantities.get(i);
            if (!book.reduceStock(quantity)) {
                System.out.println("Order failed: Insufficient stock for " + book.getTitle());
                return false;
            }
        }
        updateOrderStatus("COMPLETED");
        return true;
    }
    
    // Restricted method to update order status
    private void updateOrderStatus(String status) {
        this.orderStatus = status;
    }
    
    public String getOrderStatus() {
        return orderStatus;
    }
    
    public void displayOrderSummary() {
        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Customer: " + userName);
        System.out.println("Status: " + orderStatus);
        System.out.println("\nItems:");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            int quantity = quantities.get(i);
            double itemTotal = book.applyDiscount() * quantity;
            System.out.println("  " + book.getTitle() + " x " + quantity + 
                             " = $" + String.format("%.2f", itemTotal));
        }
        System.out.println("\nTotal Cost: $" + String.format("%.2f", calculateTotal()));
        System.out.println("=========================\n");
    }
}
