package com.scenariobasedquestion.homenest;

import java.util.ArrayList;
import java.util.Scanner;

public class HomeNestApp {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Device> devices = new ArrayList<>();
        
        System.out.println("=== Welcome to HomeNest Smart Home System ===\n");
        
        System.out.print("Enter your name: ");
        String owner = sc.nextLine();
        
        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add New Device");
            System.out.println("2. Control Device");
            System.out.println("3. View All Devices");
            System.out.println("4. Calculate Total Energy Usage");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.println("\nAdd Device:");
                    System.out.println("1. Light");
                    System.out.println("2. Camera");
                    System.out.println("3. Thermostat");
                    System.out.println("4. Lock");
                    System.out.print("Choose device type: ");
                    int type = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("Enter device ID: ");
                    String id = sc.nextLine();
                    
                    Device device = null;
                    switch (type) {
                        case 1:
                            device = new Light(id, owner);
                            break;
                        case 2:
                            device = new Camera(id, owner);
                            break;
                        case 3:
                            device = new Thermostat(id, owner);
                            break;
                        case 4:
                            device = new Lock(id, owner);
                            break;
                        default:
                            System.out.println("Invalid type!");
                            continue;
                    }
                    devices.add(device);
                    System.out.println("Device added successfully!");
                    break;
                    
                case 2:
                    if (devices.isEmpty()) {
                        System.out.println("No devices registered!");
                        break;
                    }
                    
                    System.out.println("\nYour Devices:");
                    for (int i = 0; i < devices.size(); i++) {
                        System.out.println((i + 1) + ". " + devices.get(i).getDeviceId() + 
                                         " (" + devices.get(i).getClass().getSimpleName() + ")");
                    }
                    System.out.print("Select device number: ");
                    int deviceNum = sc.nextInt() - 1;
                    sc.nextLine();
                    
                    if (deviceNum < 0 || deviceNum >= devices.size()) {
                        System.out.println("Invalid device!");
                        break;
                    }
                    
                    Device selected = devices.get(deviceNum);
                    System.out.println("\n1. Turn ON");
                    System.out.println("2. Turn OFF");
                    System.out.println("3. Reset");
                    System.out.println("4. View Info");
                    System.out.print("Choose action: ");
                    int action = sc.nextInt();
                    sc.nextLine();
                    
                    switch (action) {
                        case 1:
                            selected.turnOn();
                            break;
                        case 2:
                            selected.turnOff();
                            break;
                        case 3:
                            selected.reset();
                            break;
                        case 4:
                            selected.displayInfo();
                            break;
                    }
                    break;
                    
                case 3:
                    System.out.println("\n=== All Devices ===");
                    if (devices.isEmpty()) {
                        System.out.println("No devices registered!");
                    } else {
                        for (Device d : devices) {
                            System.out.println("\n---");
                            d.displayInfo();
                        }
                    }
                    break;
                    
                case 4:
                    double totalEnergy = 0;
                    for (Device d : devices) {
                        totalEnergy += d.getEnergyUsage();
                    }
                    System.out.println("\nTotal Energy Usage: " + totalEnergy + " kWh");
                    System.out.println("Estimated Cost: $" + (totalEnergy * 0.12)); // $0.12 per kWh
                    break;
                    
                case 5:
                    System.out.println("Thank you for using HomeNest!");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
