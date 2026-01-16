package com.scenariobasedquestion.budgetwise;

public class AnnualBudget extends Budget {
    private int year;
    
    public AnnualBudget(double income, double limit, int year) {
        super(income, limit);
        this.year = year;
    }
    
    @Override
    public void generateReport() {
        System.out.println("\n=== Annual Budget Report - " + year + " ===");
        System.out.println("Total Annual Income: $" + getIncome());
        System.out.println("Total Annual Expenses: $" + getTotalExpenses());
        System.out.println("Net Annual Savings: $" + calculateNetSavings());
        System.out.println("Annual Budget Limit: $" + getLimit());
        
        double savingsRate = (calculateNetSavings() / getIncome()) * 100;
        System.out.println("Savings Rate: " + String.format("%.2f", savingsRate) + "%");
        
        System.out.println("\nCategory Summary:");
        for (String category : getCategoryLimits().keySet()) {
            double spent = getCategoryExpenses(category);
            double limit = getCategoryLimit(category);
            System.out.println("  " + category + ": $" + spent + " / $" + limit);
        }
    }
    
    @Override
    public void detectOverspend() {
        System.out.println("\n=== Annual Overspending Analysis ===");
        boolean hasOverspend = false;
        
        if (getTotalExpenses() > getLimit()) {
            System.out.println("⚠ ALERT: Annual expenses exceed budget!");
            System.out.println("  Amount over budget: $" + (getTotalExpenses() - getLimit()));
            hasOverspend = true;
        }
        
        for (String category : getCategoryLimits().keySet()) {
            double spent = getCategoryExpenses(category);
            double limit = getCategoryLimit(category);
            if (spent > limit) {
                double percentage = ((spent - limit) / limit) * 100;
                System.out.println("⚠ '" + category + "' exceeded by " + 
                                 String.format("%.1f", percentage) + "%");
                hasOverspend = true;
            }
        }
        
        if (!hasOverspend) {
            System.out.println("✓ Excellent! Budget maintained throughout the year.");
        }
    }
}
