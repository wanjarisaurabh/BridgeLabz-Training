package com.scenariobasedquestion.bagandball;

/**
 * Represents a Ball with ID, color, and size
 * Implements Storable interface
 */
public class Ball implements Storable {
    
    // Enum for ball sizes
    public enum Size {
        SMALL, MEDIUM, LARGE
    }
    
    // Private fields for encapsulation
    private String id;
    private String color;
    private Size size;
    
    /**
     * Constructor to initialize a Ball
     * @param id Unique identifier
     * @param color Color of the ball
     * @param size Size of the ball (SMALL/MEDIUM/LARGE)
     */
    public Ball(String id, String color, Size size) {
        this.id = id;
        this.color = color;
        this.size = size;
    }
    
    // Getters
    @Override
    public String getId() {
        return id;
    }
    
    @Override
    public String getColor() {
        return color;
    }
    
    public Size getSize() {
        return size;
    }
    
    // Setters
    public void setColor(String color) {
        this.color = color;
    }
    
    public void setSize(Size size) {
        this.size = size;
    }
    
    @Override
    public void displayInfo() {
        System.out.printf("   Ball[ID: %s, Color: %s, Size: %s]%n", 
                         id, color, size);
    }
    
    @Override
    public String toString() {
        return String.format("Ball[ID: %s, Color: %s, Size: %s]", 
                            id, color, size);
    }
}
