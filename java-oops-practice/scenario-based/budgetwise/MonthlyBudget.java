package com.scenariobasedquestion.budgetwise;

public class MonthlyBudget extends Budget {
    private String month;
    
    public MonthlyBudget(double income, double limit, String month) {
        super(income, limit);
        this.month = month;
    }
    
    @Override
    public void generateReport() {
        System.out.println("\n=== Monthly Budget Report - " + month + " ===");
        System.out.println("Income: $" + getIncome());
        System.out.println("Total Expenses: $" + getTotalExpenses());
        System.out.println("Net Savings: $" + calculateNetSavings());
        System.out.println("Budget Limit: $" + getLimit());
        
        System.out.println("\nCategory-wise Expenses:");
        for (String category : getCategoryLimits().keySet()) {
            double spent = getCategoryExpenses(category);
            double limit = getCategoryLimit(category);
            System.out.println("  " + category + ": $" + spent + " / $" + limit);
        }
        
        System.out.println("\nAll Transactions:");
        for (Transaction t : getTransactions()) {
            System.out.println("  " + t);
        }
    }
    
    @Override
    public void detectOverspend() {
        System.out.println("\n=== Overspending Alert ===");
        boolean hasOverspend = false;
        
        // Check overall budget
        if (getTotalExpenses() > getLimit()) {
            System.out.println("⚠ WARNING: Total expenses exceed budget limit!");
            System.out.println("  Exceeded by: $" + (getTotalExpenses() - getLimit()));
            hasOverspend = true;
        }
        
        // Check category limits
        for (String category : getCategoryLimits().keySet()) {
            double spent = getCategoryExpenses(category);
            double limit = getCategoryLimit(category);
            if (spent > limit) {
                System.out.println("⚠ Category '" + category + "' over budget by $" + (spent - limit));
                hasOverspend = true;
            }
        }
        
        if (!hasOverspend) {
            System.out.println("✓ All good! No overspending detected.");
        }
    }
}
