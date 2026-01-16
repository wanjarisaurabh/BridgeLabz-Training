package com.scenariobasedquestion.homenest;

public abstract class Device implements IControllable {
    private String deviceId;
    private String status;  // "ON" or "OFF"
    private double energyUsage;
    private String owner;
    
    public Device(String deviceId, String owner) {
        this.deviceId = deviceId;
        this.owner = owner;
        this.status = "OFF";
        this.energyUsage = 0.0;
    }
    
    // Getters only - status cannot be modified externally
    public String getDeviceId() {
        return deviceId;
    }
    
    public String getStatus() {
        return status;
    }
    
    public double getEnergyUsage() {
        return energyUsage;
    }
    
    public String getOwner() {
        return owner;
    }
    
    // Protected setter so only subclasses can modify
    protected void setStatus(String status) {
        this.status = status;
    }
    
    protected void addEnergyUsage(double usage) {
        this.energyUsage += usage;
    }
    
    protected void resetEnergyUsage() {
        this.energyUsage = 0.0;
    }
    
    public void displayInfo() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Owner: " + owner);
        System.out.println("Status: " + status);
        System.out.println("Energy Usage: " + energyUsage + " kWh");
    }
}
