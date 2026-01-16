package com.scenariobasedquestion.artify;

public class User {
    private String name;
    private double walletBalance;
    
    public User(String name, double walletBalance) {
        this.name = name;
        this.walletBalance = walletBalance;
    }
    
    public String getName() {
        return name;
    }
    
    public double getWalletBalance() {
        return walletBalance;
    }
    
    public boolean deductBalance(double amount) {
        if (walletBalance >= amount) {
            walletBalance = walletBalance - amount;
            return true;
        }
        return false;
    }
    
    public void addBalance(double amount) {
        walletBalance = walletBalance + amount;
    }
    
    public void displayUserInfo() {
        System.out.println("\n===== USER INFORMATION =====");
        System.out.println("Name: " + name);
        System.out.println("Wallet Balance: $" + walletBalance);
        System.out.println("============================");
    }
}
