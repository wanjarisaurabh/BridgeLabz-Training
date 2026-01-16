package com.scenariobasedquestion.artify;

import java.util.Scanner;

public class ArtifyDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("********************************************");
        System.out.println("     WELCOME TO ARTIFY MARKETPLACE");
        System.out.println("********************************************\n");
        
        // Create user
        System.out.print("Enter your name: ");
        String userName = input.nextLine();
        
        System.out.print("Enter your wallet balance: $");
        double balance = input.nextDouble();
        input.nextLine();
        
        User user = new User(userName, balance);
        user.displayUserInfo();
        
        // Create digital art
        System.out.println("\n--- Creating Digital Art ---");
        System.out.print("Enter artwork title: ");
        String title1 = input.nextLine();
        
        System.out.print("Enter artist name: ");
        String artist1 = input.nextLine();
        
        System.out.print("Enter price: $");
        double price1 = input.nextDouble();
        input.nextLine();
        
        System.out.print("Enter license type (Personal/Commercial): ");
        String license1 = input.nextLine();
        
        System.out.print("Enter file format (PNG/JPG/SVG): ");
        String format = input.nextLine();
        
        System.out.print("Enter resolution (e.g., 1080, 4096): ");
        int resolution = input.nextInt();
        input.nextLine();
        
        DigitalArt digitalArt = new DigitalArt(title1, artist1, price1, license1, true, format, resolution);
        
        // Create print art
        System.out.println("\n--- Creating Print Art ---");
        System.out.print("Enter artwork title: ");
        String title2 = input.nextLine();
        
        System.out.print("Enter artist name: ");
        String artist2 = input.nextLine();
        
        System.out.print("Enter price: $");
        double price2 = input.nextDouble();
        input.nextLine();
        
        System.out.print("Enter license type (Limited/Unlimited): ");
        String license2 = input.nextLine();
        
        System.out.print("Enter paper type (Canvas/Glossy/Matte): ");
        String paperType = input.nextLine();
        
        System.out.print("Enter dimensions (e.g., 24x36 inches): ");
        String dimensions = input.nextLine();
        
        PrintArt printArt = new PrintArt(title2, artist2, price2, license2, paperType, dimensions);
        
        // Display available artworks
        System.out.println("\n\n********************************************");
        System.out.println("        AVAILABLE ARTWORKS");
        System.out.println("********************************************");
        
        System.out.println("\n[1] Digital Art:");
        digitalArt.displayInfo();
        
        System.out.println("\n[2] Print Art:");
        printArt.displayInfo();
        
        // Purchase menu
        System.out.println("\n\n********************************************");
        System.out.println("        PURCHASE SECTION");
        System.out.println("********************************************");
        
        System.out.print("\nWhich artwork do you want to purchase? (1 for Digital, 2 for Print): ");
        int choice = input.nextInt();
        input.nextLine();
        
        if (choice == 1) {
            System.out.println("\nYou selected: " + digitalArt.getTitle());
            System.out.println("Price: $" + digitalArt.getPrice());
            
            if (user.deductBalance(digitalArt.getPrice())) {
                digitalArt.purchase();
                System.out.println("Amount deducted: $" + digitalArt.getPrice());
                System.out.println("Remaining balance: $" + user.getWalletBalance());
                
                System.out.println("\n--- License Information ---");
                digitalArt.license();
            } else {
                System.out.println("Insufficient balance! Please add funds to your wallet.");
            }
        } else if (choice == 2) {
            System.out.println("\nYou selected: " + printArt.getTitle());
            System.out.println("Price: $" + printArt.getPrice());
            
            if (user.deductBalance(printArt.getPrice())) {
                printArt.purchase();
                System.out.println("Amount deducted: $" + printArt.getPrice());
                System.out.println("Remaining balance: $" + user.getWalletBalance());
                
                System.out.println("\n--- License Information ---");
                printArt.license();
            } else {
                System.out.println("Insufficient balance! Please add funds to your wallet.");
            }
        } else {
            System.out.println("Invalid choice!");
        }
        
        // Display final user info
        user.displayUserInfo();
        
        System.out.println("\n********************************************");
        System.out.println("   THANK YOU FOR USING ARTIFY!");
        System.out.println("********************************************");
        
        input.close();
    }
}
