package com.generics.mealplangenerator;

import java.util.List;

public class MealPlanGenerator {

	// Generic method: dynamically generates and validates a meal plan for any bounded type
	public static <T extends MealPlan> PersonalizedMeal<T> generatePlan(T planType, List<String> proposedMeals) {
		PersonalizedMeal<T> plan = new PersonalizedMeal<>(planType);
		for (String meal : proposedMeals) {
			plan.addMeal(meal);
		}
		return plan;
	}
}