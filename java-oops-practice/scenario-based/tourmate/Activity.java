package com.scenariobasedquestion.tourmate;

public class Activity {
    private String name;
    private double cost;
    private boolean isBooked;
    
    public Activity(String name, double cost) {
        this.name = name;
        this.cost = cost;
        this.isBooked = false;
    }
    
    public String getName() {
        return name;
    }
    
    public double getCost() {
        return cost;
    }
    
    public boolean isBooked() {
        return isBooked;
    }
    
    public void setBooked(boolean booked) {
        this.isBooked = booked;
    }
    
    public void displayInfo() {
        System.out.println("Activity: " + name + " | Cost: Rs. " + cost);
    }
}
