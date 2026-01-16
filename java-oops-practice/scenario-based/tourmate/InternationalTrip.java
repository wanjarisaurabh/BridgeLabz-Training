package com.scenariobasedquestion.tourmate;

public class InternationalTrip extends Trip {
    private boolean visaRequired;
    
    public InternationalTrip(String destination, double budget, int duration, boolean visaRequired) {
        super(destination, budget, duration);
        this.visaRequired = visaRequired;
    }
    
    @Override
    public void book() {
        if (isBooked()) {
            System.out.println("Trip already booked!");
            return;
        }
        
        double totalCost = calculateTotalCost();
        
        // Add visa charges for international trips
        if (visaRequired) {
            totalCost += 5000;
            System.out.println("Visa charges: Rs. 5000 added");
        }
        
        if (totalCost > getBudget()) {
            System.out.println("Cannot book! Total cost exceeds budget.");
            System.out.println("Budget: Rs. " + getBudget() + " | Required: Rs. " + totalCost);
            return;
        }
        
        // Book all services
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
        System.out.println("International trip booked successfully!");
        System.out.println("Total amount: Rs. " + totalCost);
        if (visaRequired) {
            System.out.println("Note: Please complete visa formalities before travel.");
        }
    }
    
    @Override
    public void cancel() {
        if (!isBooked()) {
            System.out.println("No booking found to cancel!");
            return;
        }
        
        // International trips have cancellation charges
        double cancellationFee = calculateTotalCost() * 0.2;
        
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
        System.out.println("International trip cancelled!");
        System.out.println("Cancellation charges: Rs. " + cancellationFee);
    }
}
