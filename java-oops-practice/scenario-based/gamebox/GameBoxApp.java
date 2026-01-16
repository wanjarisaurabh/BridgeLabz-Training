package com.scenariobasedquestion.gamebox;

import java.util.ArrayList;
import java.util.Scanner;

public class GameBoxApp {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Game> store = new ArrayList<>();
        
        // Pre-load some games in store
        ArcadeGame game1 = new ArcadeGame("Space Invaders Pro", 4.99);
        game1.setRating(4.5);
        store.add(game1);
        
        StrategyGame game2 = new StrategyGame("Empire Conquest", 9.99, 30);
        game2.setRating(4.8);
        store.add(game2);
        
        ArcadeGame game3 = new ArcadeGame("Flappy Rush", 0.0); // free game
        game3.setRating(4.0);
        store.add(game3);
        
        StrategyGame game4 = new StrategyGame("Medieval Wars", 12.99, 40);
        game4.setRating(4.6);
        store.add(game4);
        
        System.out.println("=== Welcome to GameBox ===\n");
        
        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        
        System.out.print("Enter initial wallet balance: $");
        double balance = sc.nextDouble();
        sc.nextLine();
        
        User user = new User(username, balance);
        
        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Browse Store");
            System.out.println("2. View Game Details");
            System.out.println("3. Play Game Demo");
            System.out.println("4. Purchase Game");
            System.out.println("5. View My Library");
            System.out.println("6. Add Funds to Wallet");
            System.out.println("7. Check Wallet Balance");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.println("\n=== GameBox Store ===");
                    for (int i = 0; i < store.size(); i++) {
                        Game g = store.get(i);
                        System.out.println((i + 1) + ". " + g.getTitle() + " - $" + g.getPrice() + 
                                         " [" + g.getRating() + "★]");
                    }
                    break;
                    
                case 2:
                    System.out.print("Enter game number: ");
                    int gameNum = sc.nextInt() - 1;
                    sc.nextLine();
                    
                    if (gameNum >= 0 && gameNum < store.size()) {
                        System.out.println();
                        store.get(gameNum).displayInfo();
                    } else {
                        System.out.println("Invalid game number!");
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter game number to try demo: ");
                    int demoNum = sc.nextInt() - 1;
                    sc.nextLine();
                    
                    if (demoNum >= 0 && demoNum < store.size()) {
                        store.get(demoNum).playDemo();
                    } else {
                        System.out.println("Invalid game number!");
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter game number to purchase: ");
                    int purchaseNum = sc.nextInt() - 1;
                    sc.nextLine();
                    
                    if (purchaseNum >= 0 && purchaseNum < store.size()) {
                        Game gameToBuy = store.get(purchaseNum);
                        
                        System.out.print("Apply seasonal discount? (yes/no): ");
                        String applyDiscount = sc.nextLine();
                        
                        if (applyDiscount.equalsIgnoreCase("yes")) {
                            System.out.print("Enter discount percentage: ");
                            double discount = sc.nextDouble();
                            sc.nextLine();
                            double newPrice = gameToBuy.applyDiscount(discount);
                            System.out.println("Discounted price: $" + newPrice);
                            
                            // Create temporary game with discounted price
                            Game discountedGame;
                            if (gameToBuy instanceof ArcadeGame) {
                                discountedGame = new ArcadeGame(gameToBuy.getTitle(), newPrice);
                            } else {
                                discountedGame = new StrategyGame(gameToBuy.getTitle(), newPrice, 30);
                            }
                            user.purchaseGame(discountedGame);
                        } else {
                            user.purchaseGame(gameToBuy);
                        }
                        
                        gameToBuy.download();
                    } else {
                        System.out.println("Invalid game number!");
                    }
                    break;
                    
                case 5:
                    user.viewLibrary();
                    break;
                    
                case 6:
                    System.out.print("Enter amount to add: $");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    user.addFunds(amount);
                    break;
                    
                case 7:
                    System.out.println("Current balance: $" + user.getWalletBalance());
                    break;
                    
                case 8:
                    System.out.println("Thank you for using GameBox!");
                    System.out.println("Games in library: " + user.getLibrarySize());
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
