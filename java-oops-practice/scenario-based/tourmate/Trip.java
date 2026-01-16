package com.scenariobasedquestion.tourmate;

import java.util.ArrayList;

public abstract class Trip implements IBookable {
    private String destination;
    private double budget;
    private int duration;
    private Transport transport;
    private Hotel hotel;
    private ArrayList<Activity> activities;
    private boolean isBooked;
    
    public Trip(String destination, double budget, int duration) {
        this.destination = destination;
        this.budget = budget;
        this.duration = duration;
        this.activities = new ArrayList<>();
        this.isBooked = false;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public double getBudget() {
        return budget;
    }
    
    public int getDuration() {
        return duration;
    }
    
    public void setTransport(Transport transport) {
        this.transport = transport;
    }
    
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    public void addActivity(Activity activity) {
        activities.add(activity);
    }
    
    // Calculate total trip cost
    public double calculateTotalCost() {
        double total = 0;
        if (transport != null) {
            total += transport.getCost();
        }
        if (hotel != null) {
            total += hotel.getTotalCost();
        }
        for (Activity activity : activities) {
            total += activity.getCost();
        }
        return total;
    }
    
    public boolean isBooked() {
        return isBooked;
    }
    
    protected void setBooked(boolean booked) {
        this.isBooked = booked;
    }
    
    protected Transport getTransport() {
        return transport;
    }
    
    protected Hotel getHotel() {
        return hotel;
    }
    
    protected ArrayList<Activity> getActivities() {
        return activities;
    }
    
    public void displayTripDetails() {
        System.out.println("\n--- Trip Details ---");
        System.out.println("Destination: " + destination);
        System.out.println("Duration: " + duration + " days");
        System.out.println("Budget: Rs. " + budget);
        
        if (transport != null) {
            transport.displayInfo();
        }
        if (hotel != null) {
            hotel.displayInfo();
        }
        if (!activities.isEmpty()) {
            System.out.println("Activities:");
            for (Activity activity : activities) {
                activity.displayInfo();
            }
        }
        
        System.out.println("Total Cost: Rs. " + calculateTotalCost());
        System.out.println("Status: " + (isBooked ? "BOOKED" : "NOT BOOKED"));
    }
    
    @Override
    public abstract void book();
    
    @Override
    public abstract void cancel();
}
