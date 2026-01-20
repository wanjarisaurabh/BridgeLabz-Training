package com.generics.mealplangenerator;

public class VegetarianPlan implements MealPlan {

	@Override
	public String getPlanType() {
		return "Vegetarian";
	}

	@Override
	public boolean isValidMeal(String meal) {
		String lower = meal.toLowerCase();
		return !(lower.contains("chicken") || lower.contains("beef") || lower.contains("fish") || lower.contains("pork")
				|| lower.contains("meat"));
	}

	// good string representation
	@Override
	public String toString() {
		return getPlanType() + " Plan";
	}
}