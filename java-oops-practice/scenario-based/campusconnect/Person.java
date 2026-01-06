package com.scenariobasedquestion.campusconnect;

// Base class for all persons in the college system
public class Person {
	protected String name;
	protected String email;
	protected String id;
	
	public Person(String name, String email, String id) {
		this.name = name;
		this.email = email;
		this.id = id;
	}
	
	public void printDetails() {
		System.out.println("Name: " + name);
		System.out.println("Email: " + email);
		System.out.println("ID: " + id);
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getId() {
		return id;
	}
}
