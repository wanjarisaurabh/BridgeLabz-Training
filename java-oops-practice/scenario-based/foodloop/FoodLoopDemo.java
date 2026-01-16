package com.scenariobasedquestion.foodloop;

import java.util.Scanner;
import java.util.ArrayList;

public class FoodLoopDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("********************************************");
        System.out.println("     WELCOME TO FOODLOOP");
        System.out.println("   Restaurant Ordering System");
        System.out.println("********************************************\n");
        
        // Create some food items
        ArrayList<FoodItem> menu = new ArrayList<>();
        
        // Add veg items
        VegItem item1 = new VegItem("Paneer Tikka", "Starter", 12.99, true, false);
        VegItem item2 = new VegItem("Veg Biryani", "Main Course", 15.99, true, true);
        VegItem item3 = new VegItem("Dal Makhani", "Main Course", 10.99, true, false);
        
        // Add non-veg items
        NonVegItem item4 = new NonVegItem("Chicken Tikka", "Starter", 14.99, true, "Chicken");
        NonVegItem item5 = new NonVegItem("Mutton Biryani", "Main Course", 18.99, true, "Mutton");
        NonVegItem item6 = new NonVegItem("Fish Curry", "Main Course", 16.99, true, "Fish");
        
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);
        menu.add(item5);
        menu.add(item6);
        
        // Display menu
        System.out.println("========== MENU ==========\n");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println("[" + (i + 1) + "]");
            menu.get(i).displayItemInfo();
            System.out.println();
        }
        
        // Create order
        Order order = new Order();
        
        System.out.println("\n********************************************");
        System.out.println("        ORDER SECTION");
        System.out.println("********************************************");
        
        boolean ordering = true;
        
        while (ordering) {
            System.out.print("\nEnter item number to add (1-" + menu.size() + "), or 0 to finish: ");
            int choice = input.nextInt();
            input.nextLine();
            
            if (choice == 0) {
                ordering = false;
            } else if (choice > 0 && choice <= menu.size()) {
                order.addItem(menu.get(choice - 1));
            } else {
                System.out.println("Invalid choice!");
            }
        }
        
        // Display order
        order.displayOrder();
        
        // Ask to place order
        System.out.print("\nDo you want to place this order? (yes/no): ");
        String confirm = input.nextLine();
        
        if (confirm.equalsIgnoreCase("yes")) {
            order.placeOrder();
            
            System.out.println("\nYour order will be delivered in 30-45 minutes!");
            
            // Ask for cancellation
            System.out.print("\nDo you want to cancel the order? (yes/no): ");
            String cancelChoice = input.nextLine();
            
            if (cancelChoice.equalsIgnoreCase("yes")) {
                order.cancelOrder();
            } else {
                System.out.println("\nThank you! Your order is being prepared.");
            }
        } else {
            System.out.println("Order not placed.");
        }
        
        // Demo combo meal constructor
        System.out.println("\n\n********************************************");
        System.out.println("     COMBO MEAL DEMO");
        System.out.println("********************************************");
        
        ArrayList<FoodItem> comboItems = new ArrayList<>();
        System.out.print("\nEnter number of items for combo meal: ");
        int comboSize = input.nextInt();
        input.nextLine();
        
        for (int i = 0; i < comboSize; i++) {
            System.out.print("Enter item number for combo item " + (i + 1) + ": ");
            int itemNum = input.nextInt();
            input.nextLine();
            
            if (itemNum > 0 && itemNum <= menu.size()) {
                comboItems.add(menu.get(itemNum - 1));
            }
        }
        
        Order comboOrder = new Order(comboItems);
        comboOrder.displayOrder();
        
        System.out.print("\nPlace combo order? (yes/no): ");
        String comboConfirm = input.nextLine();
        
        if (comboConfirm.equalsIgnoreCase("yes")) {
            comboOrder.placeOrder();
        }
        
        System.out.println("\n********************************************");
        System.out.println("   THANK YOU FOR USING FOODLOOP!");
        System.out.println("********************************************");
        
        input.close();
    }
}
