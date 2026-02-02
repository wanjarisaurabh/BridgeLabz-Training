package com.jsondata.readfields;

public class User {
    private String name;
    private String email;

    // constructor
    public User() {
    }

    // getters & setters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // good string representation
    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "'}";
    }
}
