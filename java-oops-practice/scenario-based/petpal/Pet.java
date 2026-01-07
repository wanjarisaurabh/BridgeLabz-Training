package com.scenariobasedquestion.petpal;

// Base class for all pets
public abstract class Pet implements IInteractable {
    
    private String name;
    private String type;
    private int age;
    private int hunger;  // 0-100, higher means more hungry
    private int mood;    // 0-100, higher means happier
    private int energy;  // 0-100, higher means more energetic
    
    // Constructor with user-specified values
    public Pet(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.hunger = 50;
        this.mood = 50;
        this.energy = 50;
    }
    
    // Constructor with random default values
    public Pet(String name, String type) {
        this.name = name;
        this.type = type;
        this.age = (int)(Math.random() * 10) + 1;
        this.hunger = (int)(Math.random() * 50) + 25;
        this.mood = (int)(Math.random() * 50) + 25;
        this.energy = (int)(Math.random() * 50) + 25;
    }
    
    public String getName() {
        return name;
    }
    
    public String getType() {
        return type;
    }
    
    public int getAge() {
        return age;
    }
    
    // Encapsulated hunger - can only be read, modified through methods
    public int getHunger() {
        return hunger;
    }
    
    // Encapsulated mood - can only be read, modified through methods
    public int getMood() {
        return mood;
    }
    
    // Encapsulated energy - can only be read, modified through methods
    public int getEnergy() {
        return energy;
    }
    
    // Protected methods to modify internal state
    protected void increaseHunger(int amount) {
        hunger = Math.min(100, hunger + amount);
    }
    
    protected void decreaseHunger(int amount) {
        hunger = Math.max(0, hunger - amount);
    }
    
    protected void increaseMood(int amount) {
        mood = Math.min(100, mood + amount);
    }
    
    protected void decreaseMood(int amount) {
        mood = Math.max(0, mood - amount);
    }
    
    protected void increaseEnergy(int amount) {
        energy = Math.min(100, energy + amount);
    }
    
    protected void decreaseEnergy(int amount) {
        energy = Math.max(0, energy - amount);
    }
    
    @Override
    public void feed() {
        decreaseHunger(30);
        increaseMood(10);
        System.out.println(name + " has been fed! Hunger decreased.");
    }
    
    @Override
    public void play() {
        increaseMood(20);
        decreaseEnergy(15);
        increaseHunger(10);
        System.out.println(name + " is playing! Mood increased, energy decreased.");
    }
    
    @Override
    public void sleep() {
        increaseEnergy(40);
        decreaseMood(5);
        System.out.println(name + " is sleeping! Energy restored.");
    }
    
    // Abstract method for polymorphism
    public abstract void makeSound();
    
    public void displayStatus() {
        System.out.println("\n===== " + name + " Status =====");
        System.out.println("Type: " + type);
        System.out.println("Age: " + age + " years");
        System.out.println("Hunger: " + hunger + "/100");
        System.out.println("Mood: " + mood + "/100");
        System.out.println("Energy: " + energy + "/100");
        System.out.println();
    }
}
