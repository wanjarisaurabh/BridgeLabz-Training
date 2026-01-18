package com.scenariobasedquestion.birdsanctuary;

//penguin class - can only swim
public class Penguin extends Bird implements Swimmable {
	
	public Penguin(String name, String birdId) {
		super(name, "Penguin", birdId);
	}
	
	@Override
	public void swim() {
		System.out.println(name + " the Penguin is diving deep underwater!");
	}
	
	@Override
	public String getAbilities() {
		return "Can Swim";
	}
}
