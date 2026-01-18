package com.scenariobasedquestion.bagandball;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Bag that can hold balls
 * Demonstrates composition (Bag "has-a" list of Balls)
 * Implements Storable interface
 */
public class Bag implements Storable {
    
    // Private fields for encapsulation
    private String id;
    private String color;
    private int capacity;
    private List<Ball> balls; // Composition: Bag has-a list of Balls
    
    /**
     * Constructor to initialize a Bag
     * @param id Unique identifier
     * @param color Color of the bag
     * @param capacity Maximum number of balls it can hold
     */
    public Bag(String id, String color, int capacity) {
        this.id = id;
        this.color = color;
        this.capacity = capacity;
        this.balls = new ArrayList<>();
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
    
    public int getCapacity() {
        return capacity;
    }
    
    public int getCurrentBallCount() {
        return balls.size();
    }
    
    public List<Ball> getBalls() {
        return new ArrayList<>(balls); // Return copy to maintain encapsulation
    }
    
    // Setters
    public void setColor(String color) {
        this.color = color;
    }
    
    /**
     * Adds a ball to the bag if capacity allows
     * @param ball Ball to add
     * @return true if added successfully, false if bag is full
     */
    public boolean addBall(Ball ball) {
        if (balls.size() >= capacity) {
            System.out.println("⚠ Bag " + id + " is full! Cannot add more balls.");
            return false;
        }
        
        balls.add(ball);
        System.out.println("✓ Ball " + ball.getId() + " added to Bag " + id);
        return true;
    }
    
    /**
     * Removes a ball from the bag by ID
     * @param ballId ID of the ball to remove
     * @return true if removed successfully, false if not found
     */
    public boolean removeBall(String ballId) {
        for (int i = 0; i < balls.size(); i++) {
            if (balls.get(i).getId().equals(ballId)) {
                Ball removedBall = balls.remove(i);
                System.out.println("✓ Ball " + removedBall.getId() + " removed from Bag " + id);
                return true;
            }
        }
        System.out.println("⚠ Ball " + ballId + " not found in Bag " + id);
        return false;
    }
    
    /**
     * Displays all balls in the bag
     */
    public void displayBalls() {
        if (balls.isEmpty()) {
            System.out.println("   (Empty)");
        } else {
            for (Ball ball : balls) {
                ball.displayInfo();
            }
        }
    }
    
    /**
     * Checks if bag is full
     * @return true if full, false otherwise
     */
    public boolean isFull() {
        return balls.size() >= capacity;
    }
    
    /**
     * Checks if bag is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return balls.isEmpty();
    }
    
    @Override
    public void displayInfo() {
        System.out.printf("Bag[ID: %s, Color: %s, Capacity: %d, Current: %d/%d]%n", 
                         id, color, capacity, balls.size(), capacity);
        displayBalls();
    }
    
    @Override
    public String toString() {
        return String.format("Bag[ID: %s, Color: %s, Balls: %d/%d]", 
                            id, color, balls.size(), capacity);
    }
}
