package com.scenariobasedquestion.birdsanctuary;

//duck class - can fly and swim
public class Duck extends Bird implements Flyable, Swimmable {
	
	public Duck(String name, String birdId) {
		super(name, "Duck", birdId);
	}
	
	@Override
	public void fly() {
		System.out.println(name + " the Duck is flying over the pond!");
	}
	
	@Override
	public void swim() {
		System.out.println(name + " the Duck is swimming gracefully!");
	}
	
	@Override
	public String getAbilities() {
		return "Can Fly & Swim";
	}
}
