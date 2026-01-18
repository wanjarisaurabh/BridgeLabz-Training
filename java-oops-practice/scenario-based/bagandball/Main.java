package com.scenariobasedquestion.bagandball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TinyTown Play School - Bag-n-Ball Organizer
 * Main class with user input functionality
 */
public class Main {
    
    private static List<Bag> bags = new ArrayList<>();
    private static List<Ball> allBalls = new ArrayList<>(); // Track all balls (in and out of bags)
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║  TinyTown Play School - Bag-n-Ball Organizer    ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        
        boolean continueProgram = true;
        
        while (continueProgram) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    createBag();
                    break;
                case 2:
                    createBall();
                    break;
                case 3:
                    addBallToBag();
                    break;
                case 4:
                    removeBallFromBag();
                    break;
                case 5:
                    displayAllBallsInBag();
                    break;
                case 6:
                    displayAllBags();
                    break;
                case 7:
                    displayAllBalls();
                    break;
                case 8:
                    displayStatistics();
                    break;
                case 9:
                    continueProgram = false;
                    System.out.println("\n👋 Thank you for using Bag-n-Ball Organizer!");
                    break;
                default:
                    System.out.println("⚠ Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\n╔════════════════ MENU ════════════════╗");
        System.out.println("║ 1. Create a new bag                 ║");
        System.out.println("║ 2. Create a new ball                ║");
        System.out.println("║ 3. Add ball to a bag                ║");
        System.out.println("║ 4. Remove ball from a bag           ║");
        System.out.println("║ 5. Display all balls in a bag       ║");
        System.out.println("║ 6. Display all bags                 ║");
        System.out.println("║ 7. Display all balls                ║");
        System.out.println("║ 8. Display statistics               ║");
        System.out.println("║ 9. Exit                             ║");
        System.out.println("╚══════════════════════════════════════╝");
    }
    
    /**
     * Creates a new bag
     */
    private static void createBag() {
        System.out.println("\n--- Create New Bag ---");
        
        System.out.print("Enter bag ID: ");
        String id = scanner.nextLine();
        
        // Check for duplicate ID
        if (findBagById(id) != null) {
            System.out.println("⚠ Bag with ID " + id + " already exists!");
            return;
        }
        
        System.out.print("Enter bag color: ");
        String color = scanner.nextLine();
        
        int capacity = getIntInput("Enter bag capacity (max balls): ");
        
        if (capacity <= 0) {
            System.out.println("⚠ Capacity must be positive!");
            return;
        }
        
        Bag bag = new Bag(id, color, capacity);
        bags.add(bag);
        
        System.out.println("\n✓ Bag created successfully!");
        bag.displayInfo();
    }
    
    /**
     * Creates a new ball
     */
    private static void createBall() {
        System.out.println("\n--- Create New Ball ---");
        
        System.out.print("Enter ball ID: ");
        String id = scanner.nextLine();
        
        // Check for duplicate ID
        if (findBallById(id) != null) {
            System.out.println("⚠ Ball with ID " + id + " already exists!");
            return;
        }
        
        System.out.print("Enter ball color: ");
        String color = scanner.nextLine();
        
        System.out.println("Select ball size:");
        System.out.println("1. SMALL");
        System.out.println("2. MEDIUM");
        System.out.println("3. LARGE");
        int sizeChoice = getIntInput("Enter choice (1-3): ");
        
        Ball.Size size;
        switch (sizeChoice) {
            case 1:
                size = Ball.Size.SMALL;
                break;
            case 2:
                size = Ball.Size.MEDIUM;
                break;
            case 3:
                size = Ball.Size.LARGE;
                break;
            default:
                System.out.println("⚠ Invalid choice. Defaulting to MEDIUM.");
                size = Ball.Size.MEDIUM;
        }
        
        Ball ball = new Ball(id, color, size);
        allBalls.add(ball);
        
        System.out.println("\n✓ Ball created successfully!");
        ball.displayInfo();
    }
    
    /**
     * Adds a ball to a bag
     */
    private static void addBallToBag() {
        if (bags.isEmpty()) {
            System.out.println("\n⚠ No bags available. Create a bag first.");
            return;
        }
        
        if (allBalls.isEmpty()) {
            System.out.println("\n⚠ No balls available. Create a ball first.");
            return;
        }
        
        System.out.println("\n--- Add Ball to Bag ---");
        
        // Display available balls (not in any bag)
        List<Ball> availableBalls = getAvailableBalls();
        if (availableBalls.isEmpty()) {
            System.out.println("⚠ No available balls. All balls are already in bags.");
            return;
        }
        
        System.out.println("\nAvailable Balls:");
        for (int i = 0; i < availableBalls.size(); i++) {
            System.out.print((i + 1) + ". ");
            availableBalls.get(i).displayInfo();
        }
        
        int ballChoice = getIntInput("\nSelect ball number (1-" + availableBalls.size() + "): ");
        if (ballChoice < 1 || ballChoice > availableBalls.size()) {
            System.out.println("⚠ Invalid selection.");
            return;
        }
        Ball selectedBall = availableBalls.get(ballChoice - 1);
        
        // Display available bags
        System.out.println("\nAvailable Bags:");
        for (int i = 0; i < bags.size(); i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(bags.get(i));
        }
        
        int bagChoice = getIntInput("\nSelect bag number (1-" + bags.size() + "): ");
        if (bagChoice < 1 || bagChoice > bags.size()) {
            System.out.println("⚠ Invalid selection.");
            return;
        }
        Bag selectedBag = bags.get(bagChoice - 1);
        
        // Try to add ball to bag
        selectedBag.addBall(selectedBall);
    }
    
    /**
     * Removes a ball from a bag
     */
    private static void removeBallFromBag() {
        if (bags.isEmpty()) {
            System.out.println("\n⚠ No bags available.");
            return;
        }
        
        System.out.println("\n--- Remove Ball from Bag ---");
        
        // Display bags with balls
        List<Bag> nonEmptyBags = new ArrayList<>();
        for (Bag bag : bags) {
            if (!bag.isEmpty()) {
                nonEmptyBags.add(bag);
            }
        }
        
        if (nonEmptyBags.isEmpty()) {
            System.out.println("⚠ All bags are empty.");
            return;
        }
        
        System.out.println("\nBags with balls:");
        for (int i = 0; i < nonEmptyBags.size(); i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(nonEmptyBags.get(i));
        }
        
        int bagChoice = getIntInput("\nSelect bag number (1-" + nonEmptyBags.size() + "): ");
        if (bagChoice < 1 || bagChoice > nonEmptyBags.size()) {
            System.out.println("⚠ Invalid selection.");
            return;
        }
        Bag selectedBag = nonEmptyBags.get(bagChoice - 1);
        
        // Display balls in the bag
        System.out.println("\nBalls in " + selectedBag.getId() + ":");
        List<Ball> ballsInBag = selectedBag.getBalls();
        for (int i = 0; i < ballsInBag.size(); i++) {
            System.out.print((i + 1) + ". ");
            ballsInBag.get(i).displayInfo();
        }
        
        int ballChoice = getIntInput("\nSelect ball number to remove (1-" + ballsInBag.size() + "): ");
        if (ballChoice < 1 || ballChoice > ballsInBag.size()) {
            System.out.println("⚠ Invalid selection.");
            return;
        }
        
        String ballId = ballsInBag.get(ballChoice - 1).getId();
        selectedBag.removeBall(ballId);
    }
    
    /**
     * Displays all balls in a specific bag
     */
    private static void displayAllBallsInBag() {
        if (bags.isEmpty()) {
            System.out.println("\n⚠ No bags available.");
            return;
        }
        
        System.out.println("\n--- Display Balls in Bag ---");
        
        System.out.println("\nAvailable Bags:");
        for (int i = 0; i < bags.size(); i++) {
            System.out.println((i + 1) + ". " + bags.get(i));
        }
        
        int choice = getIntInput("\nSelect bag number (1-" + bags.size() + "): ");
        if (choice < 1 || choice > bags.size()) {
            System.out.println("⚠ Invalid selection.");
            return;
        }
        
        Bag selectedBag = bags.get(choice - 1);
        System.out.println("\n--- Balls in " + selectedBag.getId() + " ---");
        selectedBag.displayBalls();
    }
    
    /**
     * Displays all bags and their ball counts
     */
    private static void displayAllBags() {
        if (bags.isEmpty()) {
            System.out.println("\n⚠ No bags available.");
            return;
        }
        
        System.out.println("\n╔════════════════ ALL BAGS ════════════════╗");
        for (int i = 0; i < bags.size(); i++) {
            System.out.println("\n" + (i + 1) + ". ");
            bags.get(i).displayInfo();
        }
        System.out.println("╚══════════════════════════════════════════╝");
    }
    
    /**
     * Displays all balls (both in and out of bags)
     */
    private static void displayAllBalls() {
        if (allBalls.isEmpty()) {
            System.out.println("\n⚠ No balls available.");
            return;
        }
        
        System.out.println("\n╔════════════════ ALL BALLS ════════════════╗");
        for (int i = 0; i < allBalls.size(); i++) {
            System.out.print((i + 1) + ". ");
            allBalls.get(i).displayInfo();
            
            // Show which bag it's in, if any
            String location = findBallLocation(allBalls.get(i).getId());
            if (location != null) {
                System.out.println("       └─ Location: " + location);
            } else {
                System.out.println("       └─ Location: Not in any bag");
            }
        }
        System.out.println("╚═══════════════════════════════════════════╝");
    }
    
    /**
     * Displays statistics
     */
    private static void displayStatistics() {
        System.out.println("\n╔══════════════ STATISTICS ═══════════════╗");
        System.out.println("Total Bags: " + bags.size());
        System.out.println("Total Balls: " + allBalls.size());
        
        int totalCapacity = 0;
        int totalOccupied = 0;
        int fullBags = 0;
        int emptyBags = 0;
        
        for (Bag bag : bags) {
            totalCapacity += bag.getCapacity();
            totalOccupied += bag.getCurrentBallCount();
            if (bag.isFull()) fullBags++;
            if (bag.isEmpty()) emptyBags++;
        }
        
        System.out.println("Total Bag Capacity: " + totalCapacity);
        System.out.println("Total Balls in Bags: " + totalOccupied);
        System.out.println("Available Space: " + (totalCapacity - totalOccupied));
        System.out.println("Full Bags: " + fullBags);
        System.out.println("Empty Bags: " + emptyBags);
        System.out.println("Balls not in any bag: " + getAvailableBalls().size());
        System.out.println("╚═════════════════════════════════════════╝");
    }
    
    // Helper methods
    
    private static Bag findBagById(String id) {
        for (Bag bag : bags) {
            if (bag.getId().equals(id)) {
                return bag;
            }
        }
        return null;
    }
    
    private static Ball findBallById(String id) {
        for (Ball ball : allBalls) {
            if (ball.getId().equals(id)) {
                return ball;
            }
        }
        return null;
    }
    
    private static List<Ball> getAvailableBalls() {
        List<Ball> available = new ArrayList<>();
        for (Ball ball : allBalls) {
            boolean inBag = false;
            for (Bag bag : bags) {
                for (Ball b : bag.getBalls()) {
                    if (b.getId().equals(ball.getId())) {
                        inBag = true;
                        break;
                    }
                }
                if (inBag) break;
            }
            if (!inBag) {
                available.add(ball);
            }
        }
        return available;
    }
    
    private static String findBallLocation(String ballId) {
        for (Bag bag : bags) {
            for (Ball ball : bag.getBalls()) {
                if (ball.getId().equals(ballId)) {
                    return "Bag " + bag.getId();
                }
            }
        }
        return null;
    }
    
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("⚠ Please enter a valid number: ");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return input;
    }
}
