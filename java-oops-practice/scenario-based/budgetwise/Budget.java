package com.scenariobasedquestion.budgetwise;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Budget implements IAnalyzable {
    private double income;
    private double limit;
    private HashMap<String, Double> categoryLimits;
    private ArrayList<Transaction> transactions;
    
    public Budget(double income, double limit) {
        this.income = income;
        this.limit = limit;
        this.categoryLimits = new HashMap<>();
        this.transactions = new ArrayList<>();
    }
    
    public double getIncome() {
        return income;
    }
    
    public double getLimit() {
        return limit;
    }
    
    // Adding transaction - expenses cannot be directly edited
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
    
    public void setCategoryLimit(String category, double limit) {
        categoryLimits.put(category, limit);
    }
    
    public double getCategoryLimit(String category) {
        return categoryLimits.getOrDefault(category, 0.0);
    }
    
    protected ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    
    protected HashMap<String, Double> getCategoryLimits() {
        return categoryLimits;
    }
    
    // Calculate total expenses
    public double getTotalExpenses() {
        double total = 0;
        for (Transaction t : transactions) {
            if (t.getType().equals("EXPENSE")) {
                total += t.getAmount();
            }
        }
        return total;
    }
    
    // Calculate net savings: income - totalExpenses
    public double calculateNetSavings() {
        return income - getTotalExpenses();
    }
    
    // Get expenses by category
    public double getCategoryExpenses(String category) {
        double total = 0;
        for (Transaction t : transactions) {
            if (t.getType().equals("EXPENSE") && t.getCategory().equals(category)) {
                total += t.getAmount();
            }
        }
        return total;
    }
}
