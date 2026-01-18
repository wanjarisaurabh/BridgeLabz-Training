package com.scenariobasedquestion.birdsanctuary;

//kiwi class - cannot fly or swim
public class Kiwi extends Bird {
	
	public Kiwi(String name, String birdId) {
		super(name, "Kiwi", birdId);
	}
	
	@Override
	public String getAbilities() {
		return "Ground Bird (No Flying/Swimming)";
	}
}
