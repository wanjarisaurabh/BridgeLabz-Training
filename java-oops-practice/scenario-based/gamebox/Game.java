package com.scenariobasedquestion.gamebox;

public abstract class Game implements IDownloadable {
    private String title;
    private String genre;
    private double price;
    private double rating;
    private boolean isFree;
    
    public Game(String title, String genre, double price) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.rating = 0.0;
        this.isFree = (price == 0.0);
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public double getPrice() {
        return price;
    }
    
    public double getRating() {
        return rating;
    }
    
    public boolean isFree() {
        return isFree;
    }
    
    public void setRating(double rating) {
        this.rating = rating;
    }
    
    // Apply seasonal offer
    public double applyDiscount(double discountPercent) {
        double discountedPrice = price - (price * discountPercent / 100);
        return discountedPrice;
    }
    
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Price: $" + price + (isFree ? " (FREE)" : ""));
        System.out.println("Rating: " + rating + "/5.0");
    }
}
