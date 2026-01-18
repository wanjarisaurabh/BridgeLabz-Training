package com.scenariobasedquestion.birdsanctuary;

//base class for all birds
public abstract class Bird {
	//bird details
	protected String name;
	protected String species;
	protected String birdId;
	
	public Bird(String name, String species, String birdId) {
		this.name = name;
		this.species = species;
		this.birdId = birdId;
	}
	
	//common method for all birds
	public void eat() {
		System.out.println(name + " the " + species + " is eating.");
	}
	
	//getters
	public String getName() {
		return name;
	}
	
	public String getSpecies() {
		return species;
	}
	
	public String getBirdId() {
		return birdId;
	}
	
	//method to display bird info
	public void displayInfo() {
		System.out.println("ID: " + birdId + " | Name: " + name + " | Species: " + species);
	}
	
	//abstract method to get abilities
	public abstract String getAbilities();
}
