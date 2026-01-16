package com.scenariobasedquestion.artify;

public class DigitalArt extends Artwork {
    private String fileFormat;
    private int resolution;
    
    public DigitalArt(String title, String artist, double price, String licenseType, String fileFormat, int resolution) {
        super(title, artist, price, licenseType);
        this.fileFormat = fileFormat;
        this.resolution = resolution;
    }
    
    public DigitalArt(String title, String artist, double price, String licenseType, boolean hasPreview, String fileFormat, int resolution) {
        super(title, artist, price, licenseType, hasPreview);
        this.fileFormat = fileFormat;
        this.resolution = resolution;
    }
    
    @Override
    public void license() {
        System.out.println("Digital Art License:");
        System.out.println("- License Type: " + licenseType);
        System.out.println("- Usage: Can be used on digital platforms only");
        System.out.println("- Format: " + fileFormat);
        System.out.println("- Resolution: " + resolution + "p");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Digital Art");
        System.out.println("File Format: " + fileFormat);
        System.out.println("Resolution: " + resolution + "p");
    }
}
