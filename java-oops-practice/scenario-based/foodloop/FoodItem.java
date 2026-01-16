package com.scenariobasedquestion.foodloop;

public class FoodItem {
    private String name;
    private String category;
    private double price;
    private boolean availability;
    private int stockLevel;
    
    public FoodItem(String name, String category, double price, boolean availability) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.availability = availability;
        this.stockLevel = 10;
    }
    
    public String getName() {
        return name;
    }
    
    public String getCategory() {
        return category;
    }
    
    public double getPrice() {
        return price;
    }
    
    public boolean isAvailable() {
        return availability;
    }
    
    protected int getStockLevel() {
        return stockLevel;
    }
    
    protected void decreaseStock() {
        if (stockLevel > 0) {
            stockLevel--;
        }
        if (stockLevel == 0) {
            availability = false;
        }
    }
    
    public void displayItemInfo() {
        System.out.println("Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("Price: $" + price);
        System.out.println("Availability: " + (availability ? "Available" : "Out of Stock"));
    }
}
