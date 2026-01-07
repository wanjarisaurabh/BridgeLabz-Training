package com.scenariobasedquestion.parkease;

/**
 * Truck class - extends Vehicle with specific charging
 */
public class Truck extends Vehicle {
    private int capacity; // in tons
    
    public Truck(String vehicleNumber, String ownerName, int capacity) {
        super(vehicleNumber, ownerName, 10.0); // $10 per hour base rate
        this.capacity = capacity;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    // Polymorphism: Truck-specific charging calculation
    @Override
    public double calculateCharges(int duration) {
        double charge = baseRate * duration;
        
        // Add capacity-based charge
        charge += capacity * 0.5 * duration; // $0.5 per ton per hour
        
        // Add penalty if parked for more than 6 hours
        if (duration > 6) {
            int overtimeHours = duration - 6;
            charge += overtimeHours * 3.0; // $3 penalty per overtime hour
        }
        
        return charge;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Vehicle Type: Truck (Capacity: " + capacity + " tons)");
    }
}
