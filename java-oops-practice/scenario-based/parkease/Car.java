package com.scenariobasedquestion.parkease;

/**
 * Car class - extends Vehicle with specific charging
 */
public class Car extends Vehicle {
    private String carType; // Sedan, SUV, etc.
    
    public Car(String vehicleNumber, String ownerName, String carType) {
        super(vehicleNumber, ownerName, 5.0); // $5 per hour base rate
        this.carType = carType;
    }
    
    public String getCarType() {
        return carType;
    }
    
    // Polymorphism: Car-specific charging calculation
    @Override
    public double calculateCharges(int duration) {
        double charge = baseRate * duration;
        
        // Add penalty if parked for more than 8 hours
        if (duration > 8) {
            int overtimeHours = duration - 8;
            charge += overtimeHours * 2.0; // $2 penalty per overtime hour
        }
        
        return charge;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Vehicle Type: Car (" + carType + ")");
    }
}
