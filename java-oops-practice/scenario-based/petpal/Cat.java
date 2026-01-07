package com.scenariobasedquestion.petpal;

// Cat class extending Pet
public class Cat extends Pet {
    
    public Cat(String name, int age) {
        super(name, "Cat", age);
    }
    
    public Cat(String name) {
        super(name, "Cat");
    }
    
    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Meow! Meow!");
    }
    
    // Cat specific behavior - cats love to sleep more
    @Override
    public void sleep() {
        increaseEnergy(50);  // Cats restore more energy when sleeping
        decreaseMood(2);
        System.out.println(getName() + " is napping peacefully! Purring...");
    }
}
