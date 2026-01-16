package com.scenariobasedquestion.foodloop;

public class VegItem extends FoodItem {
    private boolean isOrganic;
    
    public VegItem(String name, String category, double price, boolean availability, boolean isOrganic) {
        super(name, category, price, availability);
        this.isOrganic = isOrganic;
    }
    
    @Override
    public void displayItemInfo() {
        super.displayItemInfo();
        System.out.println("Type: Vegetarian");
        System.out.println("Organic: " + (isOrganic ? "Yes" : "No"));
    }
}
