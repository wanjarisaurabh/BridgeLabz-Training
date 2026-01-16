package com.scenariobasedquestion.foodloop;

public class NonVegItem extends FoodItem {
    private String meatType;
    
    public NonVegItem(String name, String category, double price, boolean availability, String meatType) {
        super(name, category, price, availability);
        this.meatType = meatType;
    }
    
    @Override
    public void displayItemInfo() {
        super.displayItemInfo();
        System.out.println("Type: Non-Vegetarian");
        System.out.println("Meat Type: " + meatType);
    }
}
