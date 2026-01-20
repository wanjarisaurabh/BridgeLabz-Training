package com.generics.mealplangenerator;

public class HighProteinPlan implements MealPlan {

	@Override
	public String getPlanType() {
		return "High-Protein";
	}

	@Override
	public boolean isValidMeal(String meal) {
		String lower = meal.toLowerCase();
		return lower.contains("chicken") || lower.contains("egg") || lower.contains("fish") || lower.contains("beef")
				|| lower.contains("protein") || lower.contains("paneer") || lower.contains("tofu")
				|| lower.contains("lentils");
	}

	// good string representation
	@Override
	public String toString() {
		return getPlanType() + " Plan";
	}
}