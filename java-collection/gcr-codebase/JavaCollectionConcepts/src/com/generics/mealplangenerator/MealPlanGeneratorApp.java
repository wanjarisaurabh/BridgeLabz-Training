/*
4. Personalized Meal Plan Generator
Concepts: Generic Methods, Type Parameters, Bounded Type Parameters
Problem Statement:
	Design a Personalized Meal Plan Generator where users can choose different meal categories like Vegetarian, Vegan, Keto, or High-Protein. The system should ensure only valid meal plans are generated.
Hints:
	Define an interface MealPlan with subtypes (VegetarianMeal, VeganMeal, etc.).
	Implement a generic class Meal<T extends MealPlan> to handle different meal plans.
	Use a generic method to validate and generate a personalized meal plan dynamically.

*/

package com.generics.mealplangenerator;

import java.util.List;

public class MealPlanGeneratorApp {
	public static void main(String[] args) {
		System.out.println("Personalized Meal Plan Generator\n");

		List<String> proposedMeals = List.of("Grilled Chicken Salad", "Vegan Buddha Bowl", "Keto Avocado Eggs",
				"Pasta with Tomato Sauce", "Cheese Omelette", "Protein Shake with Whey", "Lentil Soup", "Beef Steak");

		// Generate different plans using generic method
		PersonalizedMeal<VegetarianPlan> vegetarianPlan = MealPlanGenerator.generatePlan(new VegetarianPlan(),
				proposedMeals);
		vegetarianPlan.displayPlan();

		PersonalizedMeal<VeganPlan> veganPlan = MealPlanGenerator.generatePlan(new VeganPlan(), proposedMeals);
		veganPlan.displayPlan();

		PersonalizedMeal<KetoPlan> ketoPlan = MealPlanGenerator.generatePlan(new KetoPlan(), proposedMeals);
		ketoPlan.displayPlan();

		PersonalizedMeal<HighProteinPlan> proteinPlan = MealPlanGenerator.generatePlan(new HighProteinPlan(),
				proposedMeals);
		proteinPlan.displayPlan();
	}
}