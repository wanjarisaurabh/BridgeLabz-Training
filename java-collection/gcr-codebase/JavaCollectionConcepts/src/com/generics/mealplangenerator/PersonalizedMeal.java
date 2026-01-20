package com.generics.mealplangenerator;

import java.util.ArrayList;
import java.util.List;

public class PersonalizedMeal<T extends MealPlan> {
	private T plan;
	private List<String> meals = new ArrayList<>();

	// Constructor
	public PersonalizedMeal(T plan) {
		this.plan = plan;
	}

	// Adds meal only if valid for the bounded plan type
	public void addMeal(String meal) {
		if (plan.isValidMeal(meal)) {
			meals.add(meal);
		} else {
			System.out.println("\"" + meal + "\" is invalid for " + plan.getPlanType() + " plan.");
		}
	}

	// Displays generated valid meals
	public void displayPlan() {
		System.out.println(plan.getPlanType() + " Personalized Meal Plan:");
		if (meals.isEmpty()) {
			System.out.println("  (No valid meals added)");
		} else {
			for (String m : meals) {
				System.out.println("  - " + m);
			}
		}
		System.out.println();
	}

	// good string representation
	@Override
	public String toString() {
		return plan.getPlanType() + " Plan (" + meals.size() + " valid meals)";
	}
}