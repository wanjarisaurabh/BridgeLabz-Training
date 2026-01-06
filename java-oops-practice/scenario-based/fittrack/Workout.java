package com.scenariobasedquestion.fittrack;

// Base Workout class
public class Workout implements ITrackable {
	private String type;
	private int duration; // in minutes
	private double caloriesBurned;
	private boolean isActive;
	private long startTime;
	
	public Workout(String type, int duration) {
		this.type = type;
		this.duration = duration;
		this.caloriesBurned = 0.0;
		this.isActive = false;
	}
	
	@Override
	public void startWorkout() {
		isActive = true;
		startTime = System.currentTimeMillis();
		System.out.println("Started " + type + " workout");
	}
	
	@Override
	public void stopWorkout() {
		if (isActive) {
			isActive = false;
			calculateCalories();
			System.out.println("Stopped " + type + " workout");
			System.out.println("Calories burned: " + String.format("%.2f", caloriesBurned));
		}
	}
	
	// Polymorphic method - can be overridden
	public void calculateCalories() {
		caloriesBurned = duration * 5.0; // Default: 5 calories per minute
	}
	
	public void displayWorkoutInfo() {
		System.out.println("Type: " + type + " | Duration: " + duration + " min | Calories: " + 
				String.format("%.2f", caloriesBurned));
	}
	
	public String getType() {
		return type;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public double getCaloriesBurned() {
		return caloriesBurned;
	}
	
	protected void setCaloriesBurned(double calories) {
		this.caloriesBurned = calories;
	}
}
