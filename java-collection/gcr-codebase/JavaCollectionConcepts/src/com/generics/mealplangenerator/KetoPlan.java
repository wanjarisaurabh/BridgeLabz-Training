package com.generics.mealplangenerator;

public class KetoPlan implements MealPlan {

	@Override
	public String getPlanType() {
		return "Keto";
	}

	@Override
	public boolean isValidMeal(String meal) {
		String lower = meal.toLowerCase();
		return !(lower.contains("rice") || lower.contains("bread") || lower.contains("pasta")
				|| lower.contains("potato") || lower.contains("sugar") || lower.contains("candy")
				|| lower.contains("flour"));
	}

	// good string representation
	@Override
	public String toString() {
		return getPlanType() + " Plan";
	}
}