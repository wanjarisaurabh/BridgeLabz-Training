package com.scenariobasedquestion.foodloop;

import java.util.ArrayList;

public class Order implements IOrderable {
    private ArrayList<FoodItem> items;
    private double total;
    private double discount;
    private boolean isPlaced;
    
    public Order() {
        this.items = new ArrayList<>();
        this.total = 0.0;
        this.discount = 0.0;
        this.isPlaced = false;
    }
    
    // Constructor for combo meals
    public Order(ArrayList<FoodItem> comboItems) {
        this.items = comboItems;
        calculateTotal();
        this.discount = 0.0;
        this.isPlaced = false;
    }
    
    public void addItem(FoodItem item) {
        if (item.isAvailable()) {
            items.add(item);
            System.out.println(item.getName() + " added to order!");
        } else {
            System.out.println(item.getName() + " is not available!");
        }
    }
    
    private void calculateTotal() {
        total = 0.0;
        for (FoodItem item : items) {
            total = total + item.getPrice();
        }
    }
    
    public void applyDiscount() {
        calculateTotal();
        if (total >= 50.0) {
            discount = total * 0.15;
            System.out.println("15% discount applied! You saved $" + discount);
        } else if (total >= 30.0) {
            discount = total * 0.10;
            System.out.println("10% discount applied! You saved $" + discount);
        } else if (total >= 20.0) {
            discount = total * 0.05;
            System.out.println("5% discount applied! You saved $" + discount);
        } else {
            discount = 0.0;
            System.out.println("No discount available. Order more items to get discount!");
        }
    }
    
    public double getFinalTotal() {
        return total - discount;
    }
    
    @Override
    public void placeOrder() {
        if (items.isEmpty()) {
            System.out.println("Cannot place empty order!");
            return;
        }
        
        calculateTotal();
        applyDiscount();
        isPlaced = true;
        
        System.out.println("\n========== ORDER PLACED ==========");
        System.out.println("Total items: " + items.size());
        System.out.println("Subtotal: $" + total);
        System.out.println("Discount: -$" + discount);
        System.out.println("Final Total: $" + getFinalTotal());
        System.out.println("==================================");
    }
    
    @Override
    public void cancelOrder() {
        if (!isPlaced) {
            System.out.println("No order to cancel!");
            return;
        }
        
        System.out.println("Order cancelled successfully!");
        items.clear();
        total = 0.0;
        discount = 0.0;
        isPlaced = false;
    }
    
    public void displayOrder() {
        System.out.println("\n========== YOUR ORDER ==========");
        if (items.isEmpty()) {
            System.out.println("No items in order");
        } else {
            int count = 1;
            for (FoodItem item : items) {
                System.out.println("\nItem " + count + ":");
                item.displayItemInfo();
                count++;
            }
        }
        System.out.println("\n================================");
    }
}
