package com.generics.mealplangenerator;

public class VeganPlan implements MealPlan {

	@Override
	public String getPlanType() {
		return "Vegan";
	}

	@Override
	public boolean isValidMeal(String meal) {
		String lower = meal.toLowerCase();
		if (lower.contains("chicken") || lower.contains("beef") || lower.contains("fish") || lower.contains("pork")
				|| lower.contains("meat")) {
			return false;
		}
		return !(lower.contains("milk") || lower.contains("egg") || lower.contains("cheese") || lower.contains("butter")
				|| lower.contains("honey") || lower.contains("whey"));
	}

	// good string representation
	@Override
	public String toString() {
		return getPlanType() + " Plan";
	}
}