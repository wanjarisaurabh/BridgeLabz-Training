package com.scenariobasedquestion.fittrack;

import java.util.ArrayList;

// UserProfile class manages user fitness data
public class UserProfile {
	private String name;
	private int age;
	private double weight; // Private - encapsulated health data
	private String goal; // e.g., "Lose Weight", "Build Muscle", "Stay Fit"
	private double dailyCalorieTarget;
	private ArrayList<Workout> workoutHistory;
	
	// Constructor with default goal
	public UserProfile(String name, int age, double weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.goal = "Stay Fit"; // Default goal
		this.dailyCalorieTarget = 2000; // Default target
		this.workoutHistory = new ArrayList<>();
	}
	
	// Constructor with custom goal
	public UserProfile(String name, int age, double weight, String goal, double dailyCalorieTarget) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.goal = goal;
		this.dailyCalorieTarget = dailyCalorieTarget;
		this.workoutHistory = new ArrayList<>();
	}
	
	public void addWorkout(Workout workout) {
		workoutHistory.add(workout);
	}
	
	// Calculate progress using operators
	public double calculateProgress() {
		double totalCaloriesBurned = 0.0;
		
		for (Workout workout : workoutHistory) {
			totalCaloriesBurned += workout.getCaloriesBurned();
		}
		
		double progress = dailyCalorieTarget - totalCaloriesBurned; // Using operators
		return progress;
	}
	
	public void displayProfile() {
		System.out.println("\n=== User Profile ===");
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Weight: " + weight + " kg");
		System.out.println("Goal: " + goal);
		System.out.println("Daily Calorie Target: " + dailyCalorieTarget);
		System.out.println("Workouts Completed: " + workoutHistory.size());
	}
	
	public void displayProgress() {
		double progress = calculateProgress();
		double totalBurned = 0.0;
		
		for (Workout workout : workoutHistory) {
			totalBurned += workout.getCaloriesBurned();
		}
		
		System.out.println("\n--- Fitness Progress ---");
		System.out.println("Daily Target: " + dailyCalorieTarget + " calories");
		System.out.println("Calories Burned: " + String.format("%.2f", totalBurned) + " calories");
		System.out.println("Remaining: " + String.format("%.2f", progress) + " calories");
		
		if (progress <= 0) {
			System.out.println("✓ Goal achieved!");
		} else {
			System.out.println("Keep going!");
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	// Encapsulated - weight is private health data
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String getGoal() {
		return goal;
	}
	
	public double getDailyCalorieTarget() {
		return dailyCalorieTarget;
	}
}
