package com.scenariobasedquestion.skillforge;

public class User {
    private String name;
    private String email;
    private int userId;
    
    public User(String name, String email, int userId) {
        this.name = name;
        this.email = email;
        this.userId = userId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void displayUserInfo() {
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}
