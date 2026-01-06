package com.scenariobasedquestion.fittrack;

// CardioWorkout extends Workout
public class CardioWorkout extends Workout {
	private double intensity; // 1.0 to 2.0 multiplier
	
	public CardioWorkout(String type, int duration, double intensity) {
		super(type, duration);
		this.intensity = intensity;
	}
	
	@Override
	public void calculateCalories() {
		// Polymorphism: Cardio burns more calories
		double baseCalories = getDuration() * 8.0; // 8 calories per minute base
		double totalCalories = baseCalories * intensity; // Using operators
		setCaloriesBurned(totalCalories);
	}
	
	@Override
	public void displayWorkoutInfo() {
		System.out.print("Cardio - ");
		super.displayWorkoutInfo();
		System.out.println("  Intensity: " + intensity + "x");
	}
	
	public double getIntensity() {
		return intensity;
	}
}
