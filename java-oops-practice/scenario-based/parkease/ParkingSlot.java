package com.scenariobasedquestion.parkease;

/**
 * ParkingSlot class with encapsulation
 */
public class ParkingSlot {
    private String slotId;
    private boolean isOccupied;
    private String vehicleTypeAllowed; // "Car", "Bike", "Truck"
    private String location;
    private Vehicle parkedVehicle;
    private long parkingStartTime; // For internal tracking
    
    // Constructor with location and vehicle type
    public ParkingSlot(String slotId, String location, String vehicleTypeAllowed) {
        this.slotId = slotId;
        this.location = location;
        this.vehicleTypeAllowed = vehicleTypeAllowed;
        this.isOccupied = false;
        this.parkedVehicle = null;
        this.parkingStartTime = 0;
    }
    
    // Getters
    public String getSlotId() {
        return slotId;
    }
    
    public boolean isOccupied() {
        return isOccupied;
    }
    
    public String getVehicleTypeAllowed() {
        return vehicleTypeAllowed;
    }
    
    public String getLocation() {
        return location;
    }
    
    // Encapsulation: Slot availability is modified only through these methods
    public boolean parkVehicle(Vehicle vehicle) {
        if (!isOccupied && isVehicleTypeAllowed(vehicle)) {
            this.parkedVehicle = vehicle;
            this.isOccupied = true;
            this.parkingStartTime = System.currentTimeMillis();
            logBooking("PARKED", vehicle.getVehicleNumber());
            return true;
        }
        return false;
    }
    
    public Vehicle removeVehicle() {
        if (isOccupied) {
            Vehicle vehicle = this.parkedVehicle;
            this.parkedVehicle = null;
            this.isOccupied = false;
            this.parkingStartTime = 0;
            logBooking("REMOVED", vehicle.getVehicleNumber());
            return vehicle;
        }
        return null;
    }
    
    // Check if vehicle type is allowed
    private boolean isVehicleTypeAllowed(Vehicle vehicle) {
        if (vehicleTypeAllowed.equalsIgnoreCase("Any")) {
            return true;
        }
        
        if (vehicle instanceof Car && vehicleTypeAllowed.equalsIgnoreCase("Car")) {
            return true;
        } else if (vehicle instanceof Bike && vehicleTypeAllowed.equalsIgnoreCase("Bike")) {
            return true;
        } else if (vehicle instanceof Truck && vehicleTypeAllowed.equalsIgnoreCase("Truck")) {
            return true;
        }
        
        return false;
    }
    
    // Private method for internal booking records
    private void logBooking(String action, String vehicleNumber) {
        System.out.println("[LOG] " + action + " - Slot: " + slotId + 
                         ", Vehicle: " + vehicleNumber + 
                         ", Time: " + System.currentTimeMillis());
    }
    
    public void displaySlotInfo() {
        System.out.println("Slot ID: " + slotId);
        System.out.println("Location: " + location);
        System.out.println("Vehicle Type: " + vehicleTypeAllowed);
        System.out.println("Status: " + (isOccupied ? "OCCUPIED" : "AVAILABLE"));
        if (isOccupied && parkedVehicle != null) {
            System.out.println("Parked Vehicle: " + parkedVehicle.getVehicleNumber());
        }
    }
}
