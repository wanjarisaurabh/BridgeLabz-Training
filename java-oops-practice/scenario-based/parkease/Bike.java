package com.scenariobasedquestion.parkease;

/**
 * Bike class - extends Vehicle with specific charging
 */
public class Bike extends Vehicle {
    private String bikeType; // Sport, Cruiser, etc.
    
    public Bike(String vehicleNumber, String ownerName, String bikeType) {
        super(vehicleNumber, ownerName, 2.0); // $2 per hour base rate
        this.bikeType = bikeType;
    }
    
    public String getBikeType() {
        return bikeType;
    }
    
    // Polymorphism: Bike-specific charging calculation
    @Override
    public double calculateCharges(int duration) {
        double charge = baseRate * duration;
        
        // Add penalty if parked for more than 12 hours
        if (duration > 12) {
            int overtimeHours = duration - 12;
            charge += overtimeHours * 1.0; // $1 penalty per overtime hour
        }
        
        return charge;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Vehicle Type: Bike (" + bikeType + ")");
    }
}
