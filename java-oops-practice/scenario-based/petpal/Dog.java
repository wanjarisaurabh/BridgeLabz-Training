package com.scenariobasedquestion.petpal;

// Dog class extending Pet
public class Dog extends Pet {
    
    public Dog(String name, int age) {
        super(name, "Dog", age);
    }
    
    public Dog(String name) {
        super(name, "Dog");
    }
    
    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof! Woof!");
    }
    
    // Dog specific behavior - dogs love to play more
    @Override
    public void play() {
        increaseMood(30);  // Dogs get happier when playing
        decreaseEnergy(20);
        increaseHunger(15);
        System.out.println(getName() + " is playing fetch! Tail wagging!");
    }
}
