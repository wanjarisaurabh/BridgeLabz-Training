package com.scenariobasedquestion.tourmate;

public class Transport {
    private String type;
    private double cost;
    private boolean isBooked;
    
    public Transport(String type, double cost) {
        this.type = type;
        this.cost = cost;
        this.isBooked = false;
    }
    
    public String getType() {
        return type;
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
        System.out.println("Transport: " + type + " | Cost: Rs. " + cost);
    }
}
