package com.scenariobasedquestion.tourmate;

public class Hotel {
    private String name;
    private double costPerNight;
    private int nights;
    private boolean isBooked;
    
    public Hotel(String name, double costPerNight, int nights) {
        this.name = name;
        this.costPerNight = costPerNight;
        this.nights = nights;
        this.isBooked = false;
    }
    
    public String getName() {
        return name;
    }
    
    public double getTotalCost() {
        return costPerNight * nights;
    }
    
    public boolean isBooked() {
        return isBooked;
    }
    
    public void setBooked(boolean booked) {
        this.isBooked = booked;
    }
    
    public void displayInfo() {
        System.out.println("Hotel: " + name + " | Cost/Night: Rs. " + costPerNight + " | Total: Rs. " + getTotalCost());
    }
}
