package com.smartcheckout;

import java.util.Scanner;

public class Main {

    static Counter[] counters;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Initial store data
        Store.addOrIncreaseItem(101, "Milk", 40, 50);
        Store.addOrIncreaseItem(102, "Bread", 30, 40);
        Store.addOrIncreaseItem(103, "Eggs", 6, 100);
       

        // Initial store data
     
        System.out.print("Enter number of counters: ");
        int n = input.nextInt();
        counters = new Counter[n];

        for (int i = 0; i < n; i++) {
            counters[i] = new Counter(i + 1);
        }

        int choice;

        do {
            System.out.println("\n===== SMART CHECKOUT =====");
            System.out.println("1. Show store items");
            System.out.println("2. Add customer to counter");
            System.out.println("3. Process customer");
            System.out.println("4. Show counters status");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    Store.showItems();
                    break;

                case 2:
                    addCustomer(input);
                    break;

                case 3:
                    processCustomer(input);
                    break;

                case 4:
                    showCounters();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        input.close();
    }

    // -------- MENU OPERATIONS --------

    static void addCustomer(Scanner input) {
        System.out.print("Enter customer name: ");
        String name = input.next();

        Customer customer = new Customer(name);

        int more;
        do {
            Store.showItems();
            System.out.print("Enter item id: ");
            int id = input.nextInt();
            System.out.print("Enter quantity: ");
            int qty = input.nextInt();

            customer.getItem(id, qty);

            System.out.print("Add more items? (1=yes / 0=no): ");
            more = input.nextInt();

        } while (more == 1);

        System.out.print("Enter counter number: ");
        int c = input.nextInt();

        counters[c - 1].addCustomer(customer);
        showCounters();
    }

    static void processCustomer(Scanner input) {
        System.out.print("Enter counter number: ");
        int c = input.nextInt();

        counters[c - 1].removeCustomer();
        showCounters();
    }

    static void showCounters() {
        System.out.println("\n===== COUNTERS STATUS =====");

        for (Counter counter : counters) {
            System.out.print("Counter " + counter.counterNumber + ": ");

            if (counter.queue.isEmpty()) {
                System.out.println("[ EMPTY ]");
            } else {
                for (Customer cust : counter.queue) {
                    System.out.print("[ " + cust.name + " ] ");
                }
                System.out.println();
            }
        }
    }
}
