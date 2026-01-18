package com.scenariobasedquestion.birdsanctuary;

//sparrow class - can only fly
public class Sparrow extends Bird implements Flyable {
	
	public Sparrow(String name, String birdId) {
		super(name, "Sparrow", birdId);
	}
	
	@Override
	public void fly() {
		System.out.println(name + " the Sparrow is flying swiftly!");
	}
	
	@Override
	public String getAbilities() {
		return "Can Fly";
	}
}
