package com.jsondata.studentjson;

import java.util.List;

public class Student {
    private String name;
    private int age;
    private List<String> subjects;

    // constructor
    public Student(String name, int age, List<String> subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }

    // getters & setters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    // good string representation
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", subjects=" + subjects + "}";
    }
}
