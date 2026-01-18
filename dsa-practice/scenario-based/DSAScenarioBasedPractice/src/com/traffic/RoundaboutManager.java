package com.traffic;

import java.util.LinkedList;
import java.util.Queue;

public class RoundaboutManager {
    
    private Vehicle head; // head of circular linked list
    private Queue<Vehicle> waitingQueue;
    private int currentVehicles;
    private int maxCapacity;
    
    public RoundaboutManager(int maxCapacity) {
        this.head = null;
        this.waitingQueue = new LinkedList<>();
        this.currentVehicles = 0;
        this.maxCapacity = maxCapacity;
    }
    
    // Add vehicle to waiting queue
    public void addToWaitingQueue(Vehicle vehicle) {
        waitingQueue.offer(vehicle);
        System.out.println(vehicle + " added to waiting queue.");
    }
    
    // Vehicle enters roundabout from queue
    public void enterRoundabout() {
        if (waitingQueue.isEmpty()) {
            System.out.println("No vehicles waiting to enter!");
            return;
        }
        
        if (currentVehicles >= maxCapacity) {
            System.out.println("Roundabout is full! Capacity: " + maxCapacity);
            return;
        }
        
        Vehicle vehicle = waitingQueue.poll();
        addVehicleToRoundabout(vehicle);
        System.out.println(vehicle + " entered the roundabout.");
    }
    
    // Add vehicle to circular linked list
    private void addVehicleToRoundabout(Vehicle vehicle) {
        if (head == null) {
            head = vehicle;
            head.next = head; // circular
        } else {
            Vehicle temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = vehicle;
            vehicle.next = head;
        }
        currentVehicles++;
    }
    
    // Remove a vehicle from roundabout (vehicle exits)
    public void exitRoundabout(String vehicleNumber) {
        if (head == null) {
            System.out.println("Roundabout is empty!");
            return;
        }
        
        Vehicle current = head;
        Vehicle prev = null;
        
        // Find the last node to get previous of head
        Vehicle last = head;
        while (last.next != head) {
            last = last.next;
        }
        
        // If head is the vehicle to remove
        if (head.vehicleNumber.equals(vehicleNumber)) {
            if (head.next == head) {
                // Only one vehicle
                head = null;
            } else {
                last.next = head.next;
                head = head.next;
            }
            currentVehicles--;
            System.out.println("Vehicle " + vehicleNumber + " exited the roundabout.");
            return;
        }
        
        // Search for vehicle in circular list
        prev = head;
        current = head.next;
        
        while (current != head) {
            if (current.vehicleNumber.equals(vehicleNumber)) {
                prev.next = current.next;
                currentVehicles--;
                System.out.println("Vehicle " + vehicleNumber + " exited the roundabout.");
                return;
            }
            prev = current;
            current = current.next;
        }
        
        System.out.println("Vehicle not found in roundabout!");
    }
    
    // Display current state of roundabout
    public void displayRoundaboutState() {
        System.out.println("\n=== Roundabout State ===");
        System.out.println("Current Vehicles: " + currentVehicles + "/" + maxCapacity);
        
        if (head == null) {
            System.out.println("Roundabout is empty!");
        } else {
            System.out.println("Vehicles in roundabout:");
            Vehicle temp = head;
            int count = 1;
            do {
                System.out.println("  " + count + ". " + temp);
                temp = temp.next;
                count++;
            } while (temp != head);
        }
        
        System.out.println("\nWaiting Queue: " + waitingQueue.size() + " vehicle(s)");
        if (!waitingQueue.isEmpty()) {
            int queueNum = 1;
            for (Vehicle v : waitingQueue) {
                System.out.println("  " + queueNum + ". " + v);
                queueNum++;
            }
        }
    }
    
    // Check if roundabout is full
    public boolean isFull() {
        return currentVehicles >= maxCapacity;
    }
    
    // Check if queue is empty
    public boolean isQueueEmpty() {
        return waitingQueue.isEmpty();
    }
}
