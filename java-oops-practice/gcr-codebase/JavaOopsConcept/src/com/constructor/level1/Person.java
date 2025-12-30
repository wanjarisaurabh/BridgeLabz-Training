/*
 * Program Name : Person
 * Description  : Demonstrates copy constructor by cloning
 *                another Person object's data.
 */

package com.constructor.level1;

class Person {

    // Instance variables
    String name;
    int age;

    // Parameterized constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Person(Person otherPerson) {
        this.name = otherPerson.name;
        this.age = otherPerson.age;
    }

    // Method to display person details
    void display() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }
}
