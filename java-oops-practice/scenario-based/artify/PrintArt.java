package com.scenariobasedquestion.artify;

public class PrintArt extends Artwork {
    private String paperType;
    private String dimensions;
    
    public PrintArt(String title, String artist, double price, String licenseType, String paperType, String dimensions) {
        super(title, artist, price, licenseType);
        this.paperType = paperType;
        this.dimensions = dimensions;
    }
    
    public PrintArt(String title, String artist, double price, String licenseType, boolean hasPreview, String paperType, String dimensions) {
        super(title, artist, price, licenseType, hasPreview);
        this.paperType = paperType;
        this.dimensions = dimensions;
    }
    
    @Override
    public void license() {
        System.out.println("Print Art License:");
        System.out.println("- License Type: " + licenseType);
        System.out.println("- Usage: Physical print only, no digital reproduction");
        System.out.println("- Paper Type: " + paperType);
        System.out.println("- Dimensions: " + dimensions);
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Print Art");
        System.out.println("Paper Type: " + paperType);
        System.out.println("Dimensions: " + dimensions);
    }
}
