package com.scenariobasedquestion.parkease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main demo class for ParkEase system with user input
 */
public class ParkEaseDemo {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<ParkingSlot> parkingSlots = new ArrayList<>();
        
        // Initialize parking slots
        parkingSlots.add(new ParkingSlot("A1", "Ground Floor", "Car"));
        parkingSlots.add(new ParkingSlot("A2", "Ground Floor", "Car"));
        parkingSlots.add(new ParkingSlot("B1", "Ground Floor", "Bike"));
        parkingSlots.add(new ParkingSlot("B2", "Ground Floor", "Bike"));
        parkingSlots.add(new ParkingSlot("T1", "Ground Floor", "Truck"));
        parkingSlots.add(new ParkingSlot("M1", "First Floor", "Any"));
        
        System.out.println("========================================");
        System.out.println("  Welcome to ParkEase Parking System!");
        System.out.println("========================================\n");
        
        boolean running = true;
        
        while (running) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. View Available Slots");
            System.out.println("2. Park Vehicle");
            System.out.println("3. Remove Vehicle & Calculate Charges");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    displayAvailableSlots(parkingSlots);
                    break;
                    
                case 2:
                    parkVehicle(scanner, parkingSlots);
                    break;
                    
                case 3:
                    removeVehicleAndCalculateCharges(scanner, parkingSlots);
                    break;
                    
                case 4:
                    running = false;
                    System.out.println("\nThank you for using ParkEase!");
                    break;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
        
        scanner.close();
    }
    
    private static void displayAvailableSlots(List<ParkingSlot> slots) {
        System.out.println("\n===== PARKING SLOTS STATUS =====");
        for (ParkingSlot slot : slots) {
            slot.displaySlotInfo();
            System.out.println("---");
        }
    }
    
    private static void parkVehicle(Scanner scanner, List<ParkingSlot> slots) {
        System.out.println("\n===== PARK VEHICLE =====");
        System.out.println("Select Vehicle Type:");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.println("3. Truck");
        System.out.print("Enter choice: ");
        int vehicleType = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter Vehicle Number: ");
        String vehicleNumber = scanner.nextLine();
        
        System.out.print("Enter Owner Name: ");
        String ownerName = scanner.nextLine();
        
        Vehicle vehicle = null;
        
        switch (vehicleType) {
            case 1:
                System.out.print("Enter Car Type (Sedan/SUV/Hatchback): ");
                String carType = scanner.nextLine();
                vehicle = new Car(vehicleNumber, ownerName, carType);
                break;
                
            case 2:
                System.out.print("Enter Bike Type (Sport/Cruiser/Commuter): ");
                String bikeType = scanner.nextLine();
                vehicle = new Bike(vehicleNumber, ownerName, bikeType);
                break;
                
            case 3:
                System.out.print("Enter Truck Capacity (in tons): ");
                int capacity = scanner.nextInt();
                vehicle = new Truck(vehicleNumber, ownerName, capacity);
                break;
                
            default:
                System.out.println("Invalid vehicle type!");
                return;
        }
        
        // Find available slot
        boolean parked = false;
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied() && slot.parkVehicle(vehicle)) {
                System.out.println("\n✓ Vehicle parked successfully!");
                System.out.println("Slot: " + slot.getSlotId());
                System.out.println("Location: " + slot.getLocation());
                parked = true;
                break;
            }
        }
        
        if (!parked) {
            System.out.println("\n✗ No available slot for this vehicle type!");
        }
    }
    
    private static void removeVehicleAndCalculateCharges(Scanner scanner, List<ParkingSlot> slots) {
        System.out.println("\n===== REMOVE VEHICLE =====");
        System.out.print("Enter Slot ID: ");
        String slotId = scanner.nextLine();
        
        ParkingSlot slot = null;
        for (ParkingSlot s : slots) {
            if (s.getSlotId().equalsIgnoreCase(slotId)) {
                slot = s;
                break;
            }
        }
        
        if (slot == null) {
            System.out.println("Invalid slot ID!");
            return;
        }
        
        if (!slot.isOccupied()) {
            System.out.println("Slot is already empty!");
            return;
        }
        
        Vehicle vehicle = slot.removeVehicle();
        
        if (vehicle != null) {
            System.out.print("Enter parking duration (in hours): ");
            int duration = scanner.nextInt();
            
            // Calculate charges using polymorphism
            double charges = vehicle.calculateCharges(duration);
            
            System.out.println("\n===== PARKING RECEIPT =====");
            vehicle.displayInfo();
            System.out.println("Duration: " + duration + " hours");
            System.out.println("Total Charges: $" + String.format("%.2f", charges));
            System.out.println("===========================");
            System.out.println("\n✓ Vehicle removed successfully!");
        }
    }
}
