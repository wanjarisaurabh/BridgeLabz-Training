package com.scenariobasedquestion.birdsanctuary;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		//add some sample birds
		setupSampleBirds();
		
		int choice;

		do {
			System.out.println("\n╔════════════════════════════════════════════════════╗");
			System.out.println("║     Welcome to EcoWing Bird Sanctuary             ║");
			System.out.println("╚════════════════════════════════════════════════════╝");
			System.out.println("1. Add Bird");
			System.out.println("2. Display All Birds");
			System.out.println("3. Display All Flying Birds");
			System.out.println("4. Display All Swimming Birds");
			System.out.println("5. Display Both Flying & Swimming Birds");
			System.out.println("6. Delete Bird by ID");
			System.out.println("7. Sanctuary Report");
			System.out.println("8. Search Bird by ID");
			System.out.println("9. Feeding Time (Demonstrate Eating)");
			System.out.println("0. Exit");
			System.out.print("Enter choice: ");

			choice = input.nextInt();

			switch (choice) {

				case 1:
					addBird(input);
					break;

				case 2:
					BirdSanctuary.displayAllBirds();
					break;

				case 3:
					BirdSanctuary.displayFlyingBirds();
					break;

				case 4:
					BirdSanctuary.displaySwimmingBirds();
					break;

				case 5:
					BirdSanctuary.displayBothAbilities();
					break;

				case 6:
					deleteBird(input);
					break;

				case 7:
					BirdSanctuary.generateReport();
					break;

				case 8:
					searchBird(input);
					break;

				case 9:
					BirdSanctuary.demonstrateEating();
					break;

				case 0:
					System.out.println("Thank you for visiting EcoWing Bird Sanctuary!");
					System.out.println("Exiting...");
					break;

				default:
					System.out.println("Invalid choice");
			}

		} while (choice != 0);

		input.close();
	}

	// -------- MENU OPERATIONS --------

	static void addBird(Scanner sc) {
		System.out.println("\n===== ADD NEW BIRD =====");
		System.out.println("Select Bird Type:");
		System.out.println("1. Eagle (Can Fly)");
		System.out.println("2. Sparrow (Can Fly)");
		System.out.println("3. Duck (Can Fly & Swim)");
		System.out.println("4. Seagull (Can Fly & Swim)");
		System.out.println("5. Penguin (Can Swim)");
		System.out.println("6. Kiwi (Ground Bird)");
		System.out.println("7. Ostrich (Ground Bird)");
		System.out.print("Enter choice: ");
		
		int birdType = sc.nextInt();
		
		System.out.print("Enter bird name: ");
		String name = sc.next();
		
		System.out.print("Enter bird ID: ");
		String birdId = sc.next();
		
		Bird bird = null;
		
		switch (birdType) {
			case 1:
				bird = new Eagle(name, birdId);
				break;
			case 2:
				bird = new Sparrow(name, birdId);
				break;
			case 3:
				bird = new Duck(name, birdId);
				break;
			case 4:
				bird = new Seagull(name, birdId);
				break;
			case 5:
				bird = new Penguin(name, birdId);
				break;
			case 6:
				bird = new Kiwi(name, birdId);
				break;
			case 7:
				bird = new Ostrich(name, birdId);
				break;
			default:
				System.out.println("Invalid bird type");
				return;
		}
		
		BirdSanctuary.addBird(bird);
	}

	static void deleteBird(Scanner sc) {
		System.out.print("Enter bird ID to delete: ");
		String birdId = sc.next();
		
		BirdSanctuary.removeBird(birdId);
	}

	static void searchBird(Scanner sc) {
		System.out.print("Enter bird ID to search: ");
		String birdId = sc.next();
		
		Bird bird = BirdSanctuary.searchBirdById(birdId);
		
		if (bird != null) {
			System.out.println("\n===== BIRD FOUND =====");
			bird.displayInfo();
			System.out.println("Abilities: " + bird.getAbilities());
			
			System.out.println("\n--- Demonstrating Behaviors ---");
			bird.eat();
			
			if (bird instanceof Flyable) {
				((Flyable) bird).fly();
			}
			
			if (bird instanceof Swimmable) {
				((Swimmable) bird).swim();
			}
		}
	}

	// -------- HELPER METHODS --------

	static void setupSampleBirds() {
		//add sample birds for demonstration
		BirdSanctuary.addBird(new Eagle("Sky", "E001"));
		BirdSanctuary.addBird(new Sparrow("Chirpy", "S001"));
		BirdSanctuary.addBird(new Duck("Quacky", "D001"));
		BirdSanctuary.addBird(new Penguin("Waddles", "P001"));
		BirdSanctuary.addBird(new Kiwi("Fuzzy", "K001"));
		
		System.out.println("✓ Sample birds added to sanctuary");
	}
}
