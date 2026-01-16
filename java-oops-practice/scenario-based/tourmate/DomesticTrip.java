package com.scenariobasedquestion.tourmate;

public class DomesticTrip extends Trip {
    
    public DomesticTrip(String destination, double budget, int duration) {
        super(destination, budget, duration);
    }
    
    @Override
    public void book() {
        if (isBooked()) {
            System.out.println("Trip already booked!");
            return;
        }
        
        double totalCost = calculateTotalCost();
        if (totalCost > getBudget()) {
            System.out.println("Cannot book! Total cost exceeds budget.");
            System.out.println("Budget: Rs. " + getBudget() + " | Required: Rs. " + totalCost);
            return;
        }
        
        // Simple booking for domestic trips
        if (getTransport() != null) {
            getTransport().setBooked(true);
        }
        if (getHotel() != null) {
            getHotel().setBooked(true);
        }
        for (Activity activity : getActivities()) {
            activity.setBooked(true);
        }
        
        setBooked(true);
        System.out.println("Domestic trip booked successfully!");
        System.out.println("Total amount: Rs. " + totalCost);
    }
    
    @Override
    public void cancel() {
        if (!isBooked()) {
            System.out.println("No booking found to cancel!");
            return;
        }
        
        // Cancel all bookings
        if (getTransport() != null) {
            getTransport().setBooked(false);
        }
        if (getHotel() != null) {
            getHotel().setBooked(false);
        }
        for (Activity activity : getActivities()) {
            activity.setBooked(false);
        }
        
        setBooked(false);
        System.out.println("Domestic trip cancelled successfully!");
    }
}
