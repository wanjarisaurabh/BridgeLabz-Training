package com.scenariobasedquestion.edumentor;

// Base User class
public class User {
	protected String name;
	protected String email;
	protected String userId;
	
	public User(String name, String email, String userId) {
		this.name = name;
		this.email = email;
		this.userId = userId;
	}
	
	public void displayInfo() {
		System.out.println("Name: " + name);
		System.out.println("Email: " + email);
		System.out.println("User ID: " + userId);
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getUserId() {
		return userId;
	}
}
