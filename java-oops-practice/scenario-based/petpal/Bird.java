package com.scenariobasedquestion.petpal;

// Bird class extending Pet
public class Bird extends Pet {
    
    public Bird(String name, int age) {
        super(name, "Bird", age);
    }
    
    public Bird(String name) {
        super(name, "Bird");
    }
    
    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Chirp! Chirp!");
    }
    
    // Bird specific behavior - birds eat less
    @Override
    public void feed() {
        decreaseHunger(20);  // Birds need less food
        increaseMood(15);
        System.out.println(getName() + " is eating seeds! Chirping happily!");
    }
}
