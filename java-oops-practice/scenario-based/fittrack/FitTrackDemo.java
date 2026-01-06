package com.scenariobasedquestion.fittrack;

public class FitTrackDemo {
	public static void main(String[] args) {
		System.out.println("=== FitTrack - Personal Fitness Tracker ===\n");
		
		// Create user with default goal
		UserProfile user1 = new UserProfile("Mike Johnson", 28, 75.5);
		user1.displayProfile();
		
		// Create user with custom goal
		UserProfile user2 = new UserProfile("Emma Davis", 25, 62.0, "Lose Weight", 2500);
		user2.displayProfile();
		
		// Create different types of workouts
		System.out.println("\n--- Creating Workouts ---");
		CardioWorkout running = new CardioWorkout("Running", 30, 1.5);
		CardioWorkout cycling = new CardioWorkout("Cycling", 45, 1.2);
		StrengthWorkout pushups = new StrengthWorkout("Push-ups", 15, 20, 3);
		StrengthWorkout squats = new StrengthWorkout("Squats", 20, 15, 4);
		Workout yoga = new Workout("Yoga", 40);
		
		// User1 performs workouts
		System.out.println("\n--- User 1 Workout Session ---");
		running.startWorkout();
		try {
			Thread.sleep(1000); // Simulate workout time
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		running.stopWorkout();
		user1.addWorkout(running);
		
		pushups.startWorkout();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pushups.stopWorkout();
		user1.addWorkout(pushups);
		
		yoga.startWorkout();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		yoga.stopWorkout();
		user1.addWorkout(yoga);
		
		// Display user1 progress
		user1.displayProgress();
		
		// User2 performs workouts
		System.out.println("\n--- User 2 Workout Session ---");
		cycling.startWorkout();
		cycling.stopWorkout();
		user2.addWorkout(cycling);
		
		squats.startWorkout();
		squats.stopWorkout();
		user2.addWorkout(squats);
		
		// Display user2 progress
		user2.displayProgress();
		
		// Display all workout info (Polymorphism in action)
		System.out.println("\n--- Workout Summary ---");
		running.displayWorkoutInfo();
		cycling.displayWorkoutInfo();
		pushups.displayWorkoutInfo();
		squats.displayWorkoutInfo();
		yoga.displayWorkoutInfo();
	}
}
