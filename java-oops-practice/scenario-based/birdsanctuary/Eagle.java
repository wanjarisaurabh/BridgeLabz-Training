package com.scenariobasedquestion.birdsanctuary;

//eagle class - can only fly
public class Eagle extends Bird implements Flyable {
	
	public Eagle(String name, String birdId) {
		super(name, "Eagle", birdId);
	}
	
	@Override
	public void fly() {
		System.out.println(name + " the Eagle is soaring high in the sky!");
	}
	
	@Override
	public String getAbilities() {
		return "Can Fly";
	}
}
