package com.scenariobasedquestion.parkease;

/**
 * Base Vehicle class
 */
public class Vehicle implements IPayable {
    protected String vehicleNumber;
    protected String ownerName;
    protected double baseRate;
    
    public Vehicle(String vehicleNumber, String ownerName, double baseRate) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.baseRate = baseRate;
    }
    
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
    public String getOwnerName() {
        return ownerName;
    }
    
    public double getBaseRate() {
        return baseRate;
    }
    
    // Default implementation
    @Override
    public double calculateCharges(int duration) {
        return baseRate * duration;
    }
    
    public void displayInfo() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Owner: " + ownerName);
        System.out.println("Base Rate: $" + baseRate + "/hour");
    }
}
