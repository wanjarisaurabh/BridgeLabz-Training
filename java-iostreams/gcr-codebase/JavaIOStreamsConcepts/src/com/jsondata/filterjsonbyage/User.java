package com.jsondata.filterjsonbyage;

public class User {
    private int id;
    private String name;
    private int age;

    // Default constructor required by Jackson
    public User() {
    }

    // Constructor
    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getter methods used during parsing
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
