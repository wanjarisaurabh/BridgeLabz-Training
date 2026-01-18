package com.scenariobasedquestion.birdsanctuary;

//ostrich class - cannot fly or swim
public class Ostrich extends Bird {
	
	public Ostrich(String name, String birdId) {
		super(name, "Ostrich", birdId);
	}
	
	@Override
	public String getAbilities() {
		return "Ground Bird (No Flying/Swimming)";
	}
}
