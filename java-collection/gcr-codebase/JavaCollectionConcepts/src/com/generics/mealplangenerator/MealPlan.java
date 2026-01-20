package com.generics.mealplangenerator;

public interface MealPlan {

    // Returns the plan type name
    String getPlanType();

    // Validates if the meal is allowed in this plan
    boolean isValidMeal(String meal);
}