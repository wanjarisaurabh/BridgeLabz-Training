package com.scenariobasedquestion.birdsanctuary;

//seagull class - can fly and swim
public class Seagull extends Bird implements Flyable, Swimmable {
	
	public Seagull(String name, String birdId) {
		super(name, "Seagull", birdId);
	}
	
	@Override
	public void fly() {
		System.out.println(name + " the Seagull is gliding over the ocean!");
	}
	
	@Override
	public void swim() {
		System.out.println(name + " the Seagull is floating on the water!");
	}
	
	@Override
	public String getAbilities() {
		return "Can Fly & Swim";
	}
}
