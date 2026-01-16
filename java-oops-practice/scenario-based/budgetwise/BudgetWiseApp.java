package com.scenariobasedquestion.budgetwise;

import java.util.Scanner;

public class BudgetWiseApp {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Welcome to BudgetWise ===\n");
        
        System.out.println("Choose Budget Type:");
        System.out.println("1. Monthly Budget");
        System.out.println("2. Annual Budget");
        System.out.print("Enter choice: ");
        int budgetType = sc.nextInt();
        sc.nextLine();
        
        Budget budget = null;
        
        if (budgetType == 1) {
            System.out.print("Enter month (e.g., January 2026): ");
            String month = sc.nextLine();
            System.out.print("Enter monthly income: $");
            double income = sc.nextDouble();
            System.out.print("Enter spending limit: $");
            double limit = sc.nextDouble();
            sc.nextLine();
            
            budget = new MonthlyBudget(income, limit, month);
        } else {
            System.out.print("Enter year: ");
            int year = sc.nextInt();
            System.out.print("Enter annual income: $");
            double income = sc.nextDouble();
            System.out.print("Enter spending limit: $");
            double limit = sc.nextDouble();
            sc.nextLine();
            
            budget = new AnnualBudget(income, limit, year);
        }
        
        // Setup categories
        System.out.print("\nHow many expense categories to track? ");
        int numCategories = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < numCategories; i++) {
            System.out.print("Category name: ");
            String category = sc.nextLine();
            System.out.print("Budget limit for " + category + ": $");
            double catLimit = sc.nextDouble();
            sc.nextLine();
            budget.setCategoryLimit(category, catLimit);
        }
        
        // Main menu
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Transaction");
            System.out.println("2. Generate Report");
            System.out.println("3. Check Overspending");
            System.out.println("4. View Net Savings");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.println("\nTransaction Type:");
                    System.out.println("1. Income");
                    System.out.println("2. Expense");
                    System.out.print("Choose: ");
                    int type = sc.nextInt();
                    sc.nextLine();
                    
                    String transType = (type == 1) ? "INCOME" : "EXPENSE";
                    
                    System.out.print("Enter amount: $");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    
                    System.out.print("Enter date (DD-MM-YYYY): ");
                    String date = sc.nextLine();
                    
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();
                    
                    Transaction transaction = new Transaction(amount, transType, date, category);
                    budget.addTransaction(transaction);
                    System.out.println("Transaction added!");
                    break;
                    
                case 2:
                    budget.generateReport();
                    break;
                    
                case 3:
                    budget.detectOverspend();
                    break;
                    
                case 4:
                    double savings = budget.calculateNetSavings();
                    System.out.println("\nNet Savings: $" + savings);
                    if (savings > 0) {
                        System.out.println("Great job! You're saving money.");
                    } else {
                        System.out.println("Warning: You're spending more than you earn!");
                    }
                    break;
                    
                case 5:
                    System.out.println("Thank you for using BudgetWise!");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
