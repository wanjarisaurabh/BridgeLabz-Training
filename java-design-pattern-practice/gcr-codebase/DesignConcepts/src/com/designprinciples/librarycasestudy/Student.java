package com.designprinciples.librarycasestudy;

public class Student extends AbstractUser {
    // constructor
    public Student(String name) {
        super(name);
    }

    @Override
    public String getRole() {
        return "Student";
    }

    @Override
    public void update(String notification) {
        System.out.println("[Student " + name + "] Notification: " + notification);
    }
}