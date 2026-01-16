package com.scenariobasedquestion.tourmate;

import java.util.ArrayList;
import java.util.Scanner;

public class TourMateApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Trip> trips = new ArrayList<>();
        
        while (true) {
            System.out.println("\n=== TourMate Travel Planner ===");
            System.out.println("1. Create Domestic Trip");
            System.out.println("2. Create International Trip");
            System.out.println("3. View All Trips");
            System.out.println("4. Book a Trip");
            System.out.println("5. Cancel a Trip");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    // Create domestic trip
                    System.out.println("\n--- Create Domestic Trip ---");
                    System.out.print("Enter destination: ");
                    String dest1 = sc.nextLine();
                    System.out.print("Enter budget: ");
                    double budget1 = sc.nextDouble();
                    System.out.print("Enter duration (days): ");
                    int duration1 = sc.nextInt();
                    sc.nextLine();
                    
                    DomesticTrip domesticTrip = new DomesticTrip(dest1, budget1, duration1);
                    
                    // Add transport
                    System.out.print("Enter transport type (Train/Bus/Flight): ");
                    String transportType1 = sc.nextLine();
                    System.out.print("Enter transport cost: ");
                    double transportCost1 = sc.nextDouble();
                    domesticTrip.setTransport(new Transport(transportType1, transportCost1));
                    sc.nextLine();
                    
                    // Add hotel
                    System.out.print("Enter hotel name: ");
                    String hotelName1 = sc.nextLine();
                    System.out.print("Enter cost per night: ");
                    double hotelCost1 = sc.nextDouble();
                    domesticTrip.setHotel(new Hotel(hotelName1, hotelCost1, duration1));
                    sc.nextLine();
                    
                    // Add activities
                    System.out.print("How many activities to add? ");
                    int actCount1 = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < actCount1; i++) {
                        System.out.print("Activity " + (i + 1) + " name: ");
                        String actName = sc.nextLine();
                        System.out.print("Activity " + (i + 1) + " cost: ");
                        double actCost = sc.nextDouble();
                        sc.nextLine();
                        domesticTrip.addActivity(new Activity(actName, actCost));
                    }
                    
                    trips.add(domesticTrip);
                    System.out.println("Domestic trip created successfully!");
                    break;
                    
                case 2:
                    // Create international trip
                    System.out.println("\n--- Create International Trip ---");
                    System.out.print("Enter destination: ");
                    String dest2 = sc.nextLine();
                    System.out.print("Enter budget: ");
                    double budget2 = sc.nextDouble();
                    System.out.print("Enter duration (days): ");
                    int duration2 = sc.nextInt();
                    System.out.print("Is visa required? (true/false): ");
                    boolean visa = sc.nextBoolean();
                    sc.nextLine();
                    
                    InternationalTrip intTrip = new InternationalTrip(dest2, budget2, duration2, visa);
                    
                    // Add transport
                    System.out.print("Enter transport type (Flight): ");
                    String transportType2 = sc.nextLine();
                    System.out.print("Enter transport cost: ");
                    double transportCost2 = sc.nextDouble();
                    intTrip.setTransport(new Transport(transportType2, transportCost2));
                    sc.nextLine();
                    
                    // Add hotel
                    System.out.print("Enter hotel name: ");
                    String hotelName2 = sc.nextLine();
                    System.out.print("Enter cost per night: ");
                    double hotelCost2 = sc.nextDouble();
                    intTrip.setHotel(new Hotel(hotelName2, hotelCost2, duration2));
                    sc.nextLine();
                    
                    // Add activities
                    System.out.print("How many activities to add? ");
                    int actCount2 = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < actCount2; i++) {
                        System.out.print("Activity " + (i + 1) + " name: ");
                        String actName = sc.nextLine();
                        System.out.print("Activity " + (i + 1) + " cost: ");
                        double actCost = sc.nextDouble();
                        sc.nextLine();
                        intTrip.addActivity(new Activity(actName, actCost));
                    }
                    
                    trips.add(intTrip);
                    System.out.println("International trip created successfully!");
                    break;
                    
                case 3:
                    // View all trips
                    if (trips.isEmpty()) {
                        System.out.println("No trips created yet!");
                    } else {
                        for (int i = 0; i < trips.size(); i++) {
                            System.out.println("\n[Trip " + (i + 1) + "]");
                            trips.get(i).displayTripDetails();
                        }
                    }
                    break;
                    
                case 4:
                    // Book a trip
                    if (trips.isEmpty()) {
                        System.out.println("No trips available to book!");
                    } else {
                        System.out.print("Enter trip number to book (1-" + trips.size() + "): ");
                        int tripNum = sc.nextInt();
                        if (tripNum > 0 && tripNum <= trips.size()) {
                            trips.get(tripNum - 1).book();
                        } else {
                            System.out.println("Invalid trip number!");
                        }
                    }
                    break;
                    
                case 5:
                    // Cancel a trip
                    if (trips.isEmpty()) {
                        System.out.println("No trips available to cancel!");
                    } else {
                        System.out.print("Enter trip number to cancel (1-" + trips.size() + "): ");
                        int cancelNum = sc.nextInt();
                        if (cancelNum > 0 && cancelNum <= trips.size()) {
                            trips.get(cancelNum - 1).cancel();
                        } else {
                            System.out.println("Invalid trip number!");
                        }
                    }
                    break;
                    
                case 6:
                    System.out.println("Thank you for using TourMate!");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
