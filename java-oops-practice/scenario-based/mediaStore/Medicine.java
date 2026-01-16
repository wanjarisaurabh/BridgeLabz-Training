package com.scenariobasedquestion.mediaStore;

import java.time.LocalDate;

public abstract class Medicine implements ISellable {
    private String name;
    private double price;
    private LocalDate expiryDate;
    private int quantity;
    
    // Constructor with default quantity
    public Medicine(String name, double price, LocalDate expiryDate) {
        this.name = name;
        this.price = price;
        this.expiryDate = expiryDate;
        this.quantity = 100; // default quantity
    }
    
    public Medicine(String name, double price, LocalDate expiryDate, int quantity) {
        this.name = name;
        this.price = price;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    // Sell medicine and update stock
    @Override
    public void sell(int qty) {
        if (checkExpiry()) {
            System.out.println("Cannot sell expired medicine!");
            return;
        }
        if (quantity >= qty) {
            quantity -= qty;
            double total = calculateTotal(qty, 0);
            System.out.println("Sold " + qty + " units of " + name);
            System.out.println("Total amount: Rs. " + total);
            System.out.println("Remaining stock: " + quantity);
        } else {
            System.out.println("Insufficient stock! Available: " + quantity);
        }
    }
    
    // Calculate total with discount
    protected double calculateTotal(int qty, double discount) {
        double total = price * qty;
        return total - (total * discount / 100);
    }
    
    // Check if medicine is expired
    @Override
    public abstract boolean checkExpiry();
    
    public void displayInfo() {
        System.out.println("Medicine: " + name);
        System.out.println("Price: Rs. " + price);
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Stock: " + quantity);
        System.out.println("Status: " + (checkExpiry() ? "EXPIRED" : "VALID"));
    }
}
