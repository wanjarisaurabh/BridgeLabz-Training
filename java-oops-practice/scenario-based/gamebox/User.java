package com.scenariobasedquestion.gamebox;

import java.util.ArrayList;

public class User {
    private String username;
    private double walletBalance;
    private ArrayList<Game> ownedGames; // encapsulated - can't be modified directly
    
    public User(String username, double initialBalance) {
        this.username = username;
        this.walletBalance = initialBalance;
        this.ownedGames = new ArrayList<>();
    }
    
    public String getUsername() {
        return username;
    }
    
    public double getWalletBalance() {
        return walletBalance;
    }
    
    // Add money to wallet
    public void addFunds(double amount) {
        walletBalance += amount;
        System.out.println("$" + amount + " added to wallet. New balance: $" + walletBalance);
    }
    
    // Purchase a game
    public boolean purchaseGame(Game game) {
        if (game.isFree()) {
            ownedGames.add(game);
            System.out.println("Free game '" + game.getTitle() + "' added to library!");
            return true;
        }
        
        if (walletBalance >= game.getPrice()) {
            walletBalance -= game.getPrice();
            ownedGames.add(game);
            System.out.println("Purchased '" + game.getTitle() + "' for $" + game.getPrice());
            System.out.println("Remaining balance: $" + walletBalance);
            return true;
        } else {
            System.out.println("Insufficient funds! Need $" + (game.getPrice() - walletBalance) + " more.");
            return false;
        }
    }
    
    // View owned games (read-only access)
    public void viewLibrary() {
        System.out.println("\n=== " + username + "'s Game Library ===");
        if (ownedGames.isEmpty()) {
            System.out.println("No games owned yet!");
        } else {
            for (int i = 0; i < ownedGames.size(); i++) {
                System.out.println((i + 1) + ". " + ownedGames.get(i).getTitle() + 
                                 " (" + ownedGames.get(i).getGenre() + ")");
            }
        }
    }
    
    public boolean ownsGame(Game game) {
        return ownedGames.contains(game);
    }
    
    public int getLibrarySize() {
        return ownedGames.size();
    }
}
