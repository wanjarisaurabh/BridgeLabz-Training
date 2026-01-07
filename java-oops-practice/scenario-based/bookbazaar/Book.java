package com.scenariobasedquestion.bookbazaar;

/**
 * Base Book class with encapsulation
 */
public class Book implements IDiscountable {
    private String title;
    private String author;
    private double price;
    private int stock;
    
    // Constructor without offer
    public Book(String title, String author, double price, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }
    
    // Constructor with optional offer (discount percentage)
    public Book(String title, String author, double price, int stock, double offerPercent) {
        this.title = title;
        this.author = author;
        this.price = price - (price * offerPercent / 100);
        this.stock = stock;
    }
    
    // Getters
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getStock() {
        return stock;
    }
    
    // Encapsulated method to update stock
    public boolean reduceStock(int quantity) {
        if (stock >= quantity) {
            stock -= quantity;
            return true;
        }
        return false;
    }
    
    public void addStock(int quantity) {
        stock += quantity;
    }
    
    // Default discount implementation
    @Override
    public double applyDiscount() {
        return price * 0.95; // 5% default discount
    }
    
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + String.format("%.2f", price));
        System.out.println("Stock: " + stock);
    }
}
