package com.scenariobasedquestion.petpal;

// Demo class to show PetPal app functionality
public class PetPalDemo {
    
    public static void main(String[] args) {
        
        System.out.println("========== WELCOME TO PETPAL ==========\n");
        
        // Create pets with user-specified values
        Dog dog = new Dog("Buddy", 3);
        Cat cat = new Cat("Whiskers", 2);
        Bird bird = new Bird("Tweety", 1);
        
        // Create a pet with random values
        Dog randomDog = new Dog("Max");
        
        // Display initial status
        System.out.println("===== Initial Pet Status =====");
        dog.displayStatus();
        cat.displayStatus();
        bird.displayStatus();
        randomDog.displayStatus();
        
        // Interact with Dog
        System.out.println("\n===== Interacting with " + dog.getName() + " =====");
        dog.makeSound();
        dog.play();
        dog.feed();
        dog.displayStatus();
        
        // Interact with Cat
        System.out.println("\n===== Interacting with " + cat.getName() + " =====");
        cat.makeSound();
        cat.sleep();
        cat.play();
        cat.feed();
        cat.displayStatus();
        
        // Interact with Bird
        System.out.println("\n===== Interacting with " + bird.getName() + " =====");
        bird.makeSound();
        bird.feed();
        bird.play();
        bird.sleep();
        bird.displayStatus();
        
        // Demonstrate polymorphism
        System.out.println("\n===== Polymorphism Demo =====");
        Pet[] pets = {dog, cat, bird, randomDog};
        
        System.out.println("\nAll pets making sounds:");
        for (Pet pet : pets) {
            pet.makeSound();
        }
        
        System.out.println("\nFeeding all pets:");
        for (Pet pet : pets) {
            pet.feed();
        }
        
        System.out.println("\n===== Final Status =====");
        for (Pet pet : pets) {
            pet.displayStatus();
        }
    }
}
