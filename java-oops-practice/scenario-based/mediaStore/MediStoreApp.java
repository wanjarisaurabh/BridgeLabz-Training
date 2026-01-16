package com.scenariobasedquestion.mediaStore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MediStoreApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Medicine> inventory = new ArrayList<>();
        
        // Add some sample medicines
        inventory.add(new Tablet("Paracetamol", 50.0, LocalDate.of(2026, 12, 31), 200));
        inventory.add(new Syrup("Cough Syrup", 120.0, LocalDate.of(2026, 3, 15), 50));
        inventory.add(new Injection("Insulin", 300.0, LocalDate.of(2026, 6, 20), 30));
        
        while (true) {
            System.out.println("\n=== MediStore Pharmacy System ===");
            System.out.println("1. View All Medicines");
            System.out.println("2. Sell Medicine");
            System.out.println("3. Add New Medicine");
            System.out.println("4. Check Expired Medicines");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    // Display all medicines
                    System.out.println("\n--- Current Inventory ---");
                    for (int i = 0; i < inventory.size(); i++) {
                        System.out.println("\n[" + (i + 1) + "]");
                        inventory.get(i).displayInfo();
                    }
                    break;
                    
                case 2:
                    // Sell medicine
                    System.out.println("\n--- Available Medicines ---");
                    for (int i = 0; i < inventory.size(); i++) {
                        System.out.println((i + 1) + ". " + inventory.get(i).getName());
                    }
                    System.out.print("Select medicine number: ");
                    int medNum = sc.nextInt();
                    
                    if (medNum > 0 && medNum <= inventory.size()) {
                        System.out.print("Enter quantity to sell: ");
                        int qty = sc.nextInt();
                        inventory.get(medNum - 1).sell(qty);
                    } else {
                        System.out.println("Invalid selection!");
                    }
                    break;
                    
                case 3:
                    // Add new medicine
                    System.out.println("\n--- Add New Medicine ---");
                    System.out.println("1. Tablet");
                    System.out.println("2. Syrup");
                    System.out.println("3. Injection");
                    System.out.print("Select type: ");
                    int type = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();
                    System.out.print("Enter expiry year: ");
                    int year = sc.nextInt();
                    System.out.print("Enter expiry month: ");
                    int month = sc.nextInt();
                    System.out.print("Enter expiry day: ");
                    int day = sc.nextInt();
                    
                    LocalDate expiry = LocalDate.of(year, month, day);
                    
                    if (type == 1) {
                        inventory.add(new Tablet(name, price, expiry, quantity));
                    } else if (type == 2) {
                        inventory.add(new Syrup(name, price, expiry, quantity));
                    } else if (type == 3) {
                        inventory.add(new Injection(name, price, expiry, quantity));
                    }
                    System.out.println("Medicine added successfully!");
                    break;
                    
                case 4:
                    // Check expired medicines
                    System.out.println("\n--- Expired Medicines ---");
                    boolean foundExpired = false;
                    for (Medicine med : inventory) {
                        if (med.checkExpiry()) {
                            System.out.println("- " + med.getName() + " (Expiry: " + med.getExpiryDate() + ")");
                            foundExpired = true;
                        }
                    }
                    if (!foundExpired) {
                        System.out.println("No expired medicines found.");
                    }
                    break;
                    
                case 5:
                    System.out.println("Thank you for using MediStore!");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
