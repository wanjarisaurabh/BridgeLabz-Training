package com.scenariobasedquestion.artify;

public class Artwork implements IPurchasable {
    private String title;
    private String artist;
    private double price;
    protected String licenseType;
    private boolean hasPreview;
    
    // Constructor without preview
    public Artwork(String title, String artist, double price, String licenseType) {
        this.title = title;
        this.artist = artist;
        this.price = price;
        this.licenseType = licenseType;
        this.hasPreview = false;
    }
    
    // Constructor with preview
    public Artwork(String title, String artist, double price, String licenseType, boolean hasPreview) {
        this.title = title;
        this.artist = artist;
        this.price = price;
        this.licenseType = licenseType;
        this.hasPreview = hasPreview;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getArtist() {
        return artist;
    }
    
    public double getPrice() {
        return price;
    }
    
    protected String getLicenseType() {
        return licenseType;
    }
    
    public boolean hasPreview() {
        return hasPreview;
    }
    
    @Override
    public void purchase() {
        System.out.println("Artwork '" + title + "' purchased successfully!");
    }
    
    @Override
    public void license() {
        System.out.println("License Type: " + licenseType);
    }
    
    public void displayInfo() {
        System.out.println("\n========== ARTWORK DETAILS ==========");
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Price: $" + price);
        System.out.println("License Type: " + licenseType);
        System.out.println("Preview Available: " + (hasPreview ? "Yes" : "No"));
        System.out.println("=====================================");
    }
}
