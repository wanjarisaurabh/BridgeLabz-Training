package com.scenariobasedquestion.payxpress;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		//add sample bills
		setupSampleBills();
		
		int choice;

		do {
			System.out.println("\n===== PAYXPRESS PAYMENT SYSTEM =====");
			System.out.println("1. Add Bill");
			System.out.println("2. Display All Bills");
			System.out.println("3. Pay Bill");
			System.out.println("4. Send Reminder");
			System.out.println("5. System Report");
			System.out.println("0. Exit");
			System.out.print("Enter choice: ");

			choice = input.nextInt();

			switch (choice) {
				case 1:
					addBill(input);
					break;
				case 2:
					PaymentSystem.displayAllBills();
					break;
				case 3:
					payBill(input);
					break;
				case 4:
					sendReminder(input);
					break;
				case 5:
					PaymentSystem.generateReport();
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

	static void addBill(Scanner sc) {
		System.out.println("\n1. Electricity  2. Water  3. Internet");
		System.out.print("Bill type: ");
		int type = sc.nextInt();
		
		System.out.print("Bill ID: ");
		String id = sc.next();
		
		System.out.print("Customer name: ");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.print("Amount: ");
		double amount = sc.nextDouble();
		
		System.out.print("Days from today: ");
		int days = sc.nextInt();
		
		Bill bill = null;
		if (type == 1) {
			bill = new ElectricityBill(id, name, (int)(amount/6.5), 6.5, days);
		} else if (type == 2) {
			bill = new WaterBill(id, name, (int)(amount/0.5), 0.5, days);
		} else if (type == 3) {
			bill = new InternetBill(id, name, "Standard", 50, amount, days);
		}
		
		if (bill != null) {
			PaymentSystem.addBill(bill);
		}
	}

	static void payBill(Scanner sc) {
		System.out.print("Enter bill ID: ");
		String id = sc.next();
		PaymentSystem.processPayment(id);
	}

	static void sendReminder(Scanner sc) {
		System.out.print("Enter bill ID: ");
		String id = sc.next();
		PaymentSystem.sendReminder(id);
	}

	// -------- HELPER METHODS --------

	static void setupSampleBills() {
		PaymentSystem.addBill(new ElectricityBill("E001", "Rajesh", 250, 6.5, 
				LocalDate.of(2026, 1, 20)));
		
		PaymentSystem.addBill(new WaterBill("W001", "Amit", 5000, 0.5, 
				LocalDate.of(2026, 1, 25)));
		
		PaymentSystem.addBill(new InternetBill("I001", "Vikram", "Premium", 
				100, 999.0, LocalDate.of(2026, 1, 30)));
		
		System.out.println("✓ Sample bills loaded");
	}
}
