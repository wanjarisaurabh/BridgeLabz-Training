package com.traffic;

import java.util.Scanner;

public class TrafficApp {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Smart City Roundabout Manager ===\n");
        System.out.print("Enter maximum capacity of roundabout: ");
        int capacity = sc.nextInt();
        sc.nextLine();
        
        RoundaboutManager manager = new RoundaboutManager(capacity);
        
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Vehicle to Waiting Queue");
            System.out.println("2. Enter Roundabout");
            System.out.println("3. Exit Roundabout");
            System.out.println("4. Display Roundabout State");
            System.out.println("5. Exit Program");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle number: ");
                    String vehicleNum = sc.nextLine();
                    System.out.print("Enter vehicle type (car/bike/truck/bus): ");
                    String type = sc.nextLine();
                    
                    Vehicle vehicle = new Vehicle(vehicleNum, type);
                    manager.addToWaitingQueue(vehicle);
                    break;
                    
                case 2:
                    manager.enterRoundabout();
                    break;
                    
                case 3:
                    System.out.print("Enter vehicle number to exit: ");
                    String exitNum = sc.nextLine();
                    manager.exitRoundabout(exitNum);
                    break;
                    
                case 4:
                    manager.displayRoundaboutState();
                    break;
                    
                case 5:
                    System.out.println("Thank you for using Roundabout Manager!");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
