package com.jsondata.filterjson;

public class Person {
    private int id;
    private String name;
    private int age;

    // Default constructor required by Jackson
    public Person() {
    }

    public Person(int id, String name, int age) {
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
