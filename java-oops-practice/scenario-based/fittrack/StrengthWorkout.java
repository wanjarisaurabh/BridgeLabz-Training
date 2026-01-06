package com.scenariobasedquestion.fittrack;

// StrengthWorkout extends Workout
public class StrengthWorkout extends Workout {
	private int repetitions;
	private int sets;
	
	public StrengthWorkout(String type, int duration, int repetitions, int sets) {
		super(type, duration);
		this.repetitions = repetitions;
		this.sets = sets;
	}
	
	@Override
	public void calculateCalories() {
		// Polymorphism: Strength training calculation
		double baseCalories = getDuration() * 6.0; // 6 calories per minute
		double bonusCalories = (repetitions * sets) * 0.5; // Bonus for reps and sets
		double totalCalories = baseCalories + bonusCalories; // Using operators
		setCaloriesBurned(totalCalories);
	}
	
	@Override
	public void displayWorkoutInfo() {
		System.out.print("Strength - ");
		super.displayWorkoutInfo();
		System.out.println("  Sets: " + sets + " | Reps: " + repetitions);
	}
	
	public int getRepetitions() {
		return repetitions;
	}
	
	public int getSets() {
		return sets;
	}
}
