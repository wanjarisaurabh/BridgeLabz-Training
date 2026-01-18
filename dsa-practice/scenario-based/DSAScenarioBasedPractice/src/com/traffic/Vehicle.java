package com.traffic;

public class Vehicle {
    String vehicleNumber;
    String type; // car, bike, truck, etc
    Vehicle next;
    
    public Vehicle(String vehicleNumber, String type) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.next = null;
    }
    
    @Override
    public String toString() {
        return type + " - " + vehicleNumber;
    }
}
