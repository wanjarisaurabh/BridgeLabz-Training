package com.scenariobasedquestion.eventease;

// User class representing event organizer
public class User {
    
    private String userId;
    private String name;
    private String email;
    private String phone;
    
    public User(String userId, String name, String email, String phone) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    // Phone is sensitive data - encapsulated
    public String getPhone() {
        return "******" + phone.substring(Math.max(0, phone.length() - 4));
    }
    
    public String getFullPhone() {
        return phone;
    }
    
    public void displayUserInfo() {
        System.out.println("Organizer: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + getPhone());
    }
}
