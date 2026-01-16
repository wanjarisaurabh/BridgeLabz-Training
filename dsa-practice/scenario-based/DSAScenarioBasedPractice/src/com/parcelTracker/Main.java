package com.parcelTracker;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n===== PARCEL TRACKER =====");
			System.out.println("1. Register new parcel");
			System.out.println("2. Update parcel stage");
			System.out.println("3. Add custom checkpoint");
			System.out.println("4. Track parcel");
			System.out.println("5. Report lost/missing parcel");
			System.out.println("6. Show all parcels");
			System.out.println("0. Exit");
			System.out.print("Enter choice: ");

			choice = input.nextInt();

			switch (choice) {

				case 1:
					registerNewParcel(input);
					break;

				case 2:
					updateParcelStage(input);
					break;

				case 3:
					addCustomCheckpoint(input);
					break;

				case 4:
					trackParcel(input);
					break;

				case 5:
					reportLostParcel(input);
					break;

				case 6:
					CourierCompany.showAllParcels();
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

	static void registerNewParcel(Scanner sc) {
		System.out.print("Enter parcel ID: ");
		String parcelId = sc.next();

		System.out.print("Enter customer name: ");
		sc.nextLine(); //consume newline
		String customerName = sc.nextLine();

		System.out.print("Enter destination: ");
		String destination = sc.nextLine();

		CourierCompany.registerParcel(parcelId, customerName, destination);
	}

	static void updateParcelStage(Scanner sc) {
		System.out.print("Enter parcel ID: ");
		String parcelId = sc.next();

		System.out.println("\nCommon Stages:");
		System.out.println("- Packed");
		System.out.println("- Shipped");
		System.out.println("- In Transit");
		System.out.println("- Out for Delivery");
		System.out.println("- Delivered");

		System.out.print("\nEnter stage name: ");
		sc.nextLine(); //consume newline
		String stageName = sc.nextLine();

		System.out.print("Enter location: ");
		String location = sc.nextLine();

		CourierCompany.updateStage(parcelId, stageName, location);
	}

	static void addCustomCheckpoint(Scanner sc) {
		System.out.print("Enter parcel ID: ");
		String parcelId = sc.next();

		System.out.print("Enter checkpoint name: ");
		sc.nextLine(); //consume newline
		String checkpointName = sc.nextLine();

		System.out.print("Enter location: ");
		String location = sc.nextLine();

		CourierCompany.addCheckpoint(parcelId, checkpointName, location);
	}

	static void trackParcel(Scanner sc) {
		System.out.print("Enter parcel ID: ");
		String parcelId = sc.next();

		CourierCompany.trackParcel(parcelId);
	}

	static void reportLostParcel(Scanner sc) {
		System.out.print("Enter parcel ID: ");
		String parcelId = sc.next();

		System.out.print("Enter reason: ");
		sc.nextLine(); //consume newline
		String reason = sc.nextLine();

		CourierCompany.reportLostParcel(parcelId, reason);
	}
}
