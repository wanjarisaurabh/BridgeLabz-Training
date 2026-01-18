package com.scenariobasedquestion.birdsanctuary;

import java.util.HashMap;
import java.util.ArrayList;

//class to manage bird sanctuary
public class BirdSanctuary {
	//hashmap to store all birds
	private static HashMap<String, Bird> birds = new HashMap<>();
	
	//method to add bird to sanctuary
	public static boolean addBird(Bird bird) {
		if (birds.containsKey(bird.getBirdId())) {
			System.out.println("Bird with ID " + bird.getBirdId() + " already exists");
			return false;
		}
		
		birds.put(bird.getBirdId(), bird);
		System.out.println("✓ " + bird.getName() + " the " + bird.getSpecies() + " added successfully");
		return true;
	}
	
	//method to remove bird by ID
	public static boolean removeBird(String birdId) {
		if (!birds.containsKey(birdId)) {
			System.out.println("Bird with ID " + birdId + " not found");
			return false;
		}
		
		Bird bird = birds.get(birdId);
		birds.remove(birdId);
		System.out.println("✓ " + bird.getName() + " the " + bird.getSpecies() + " removed from sanctuary");
		return true;
	}
	
	//method to display all birds
	public static void displayAllBirds() {
		if (birds.isEmpty()) {
			System.out.println("No birds in sanctuary");
			return;
		}
		
		System.out.println("\n╔════════════════════════════════════════════════════╗");
		System.out.println("║           ALL BIRDS IN SANCTUARY                  ║");
		System.out.println("╠════════════════════════════════════════════════════╣");
		
		for (Bird bird : birds.values()) {
			System.out.print("║ ");
			bird.displayInfo();
			System.out.println("║   Abilities: " + bird.getAbilities());
			System.out.println("╠════════════════════════════════════════════════════╣");
		}
		
		System.out.println("Total Birds: " + birds.size());
	}
	
	//method to display all flying birds using polymorphism
	public static void displayFlyingBirds() {
		System.out.println("\n===== FLYING BIRDS =====");
		
		int count = 0;
		for (Bird bird : birds.values()) {
			if (bird instanceof Flyable) {
				bird.displayInfo();
				((Flyable) bird).fly();
				System.out.println();
				count++;
			}
		}
		
		if (count == 0) {
			System.out.println("No flying birds in sanctuary");
		} else {
			System.out.println("Total Flying Birds: " + count);
		}
	}
	
	//method to display all swimming birds using polymorphism
	public static void displaySwimmingBirds() {
		System.out.println("\n===== SWIMMING BIRDS =====");
		
		int count = 0;
		for (Bird bird : birds.values()) {
			if (bird instanceof Swimmable) {
				bird.displayInfo();
				((Swimmable) bird).swim();
				System.out.println();
				count++;
			}
		}
		
		if (count == 0) {
			System.out.println("No swimming birds in sanctuary");
		} else {
			System.out.println("Total Swimming Birds: " + count);
		}
	}
	
	//method to display birds that can both fly and swim
	public static void displayBothAbilities() {
		System.out.println("\n===== BIRDS WITH BOTH ABILITIES =====");
		
		int count = 0;
		for (Bird bird : birds.values()) {
			if (bird instanceof Flyable && bird instanceof Swimmable) {
				bird.displayInfo();
				System.out.println("  - Can fly and swim");
				((Flyable) bird).fly();
				((Swimmable) bird).swim();
				System.out.println();
				count++;
			}
		}
		
		if (count == 0) {
			System.out.println("No birds with both abilities");
		} else {
			System.out.println("Total Birds with Both Abilities: " + count);
		}
	}
	
	//method to generate sanctuary report
	public static void generateReport() {
		int flyableCount = 0;
		int swimmableCount = 0;
		int bothCount = 0;
		int neitherCount = 0;
		
		for (Bird bird : birds.values()) {
			boolean canFly = bird instanceof Flyable;
			boolean canSwim = bird instanceof Swimmable;
			
			if (canFly && canSwim) {
				bothCount++;
			} else if (canFly) {
				flyableCount++;
			} else if (canSwim) {
				swimmableCount++;
			} else {
				neitherCount++;
			}
		}
		
		System.out.println("\n╔════════════════════════════════════════════════════╗");
		System.out.println("║           SANCTUARY REPORT                         ║");
		System.out.println("╠════════════════════════════════════════════════════╣");
		System.out.println("║ Total Birds: " + String.format("%-37d", birds.size()) + "║");
		System.out.println("╠════════════════════════════════════════════════════╣");
		System.out.println("║ Can Fly Only: " + String.format("%-36d", flyableCount) + "║");
		System.out.println("║ Can Swim Only: " + String.format("%-35d", swimmableCount) + "║");
		System.out.println("║ Can Fly & Swim: " + String.format("%-34d", bothCount) + "║");
		System.out.println("║ Cannot Fly/Swim: " + String.format("%-33d", neitherCount) + "║");
		System.out.println("╚════════════════════════════════════════════════════╝");
	}
	
	//method to demonstrate eating using polymorphism
	public static void demonstrateEating() {
		if (birds.isEmpty()) {
			System.out.println("No birds in sanctuary");
			return;
		}
		
		System.out.println("\n===== FEEDING TIME =====");
		for (Bird bird : birds.values()) {
			bird.eat();
		}
	}
	
	//method to search bird by ID
	public static Bird searchBirdById(String birdId) {
		if (!birds.containsKey(birdId)) {
			System.out.println("Bird with ID " + birdId + " not found");
			return null;
		}
		
		return birds.get(birdId);
	}
}
