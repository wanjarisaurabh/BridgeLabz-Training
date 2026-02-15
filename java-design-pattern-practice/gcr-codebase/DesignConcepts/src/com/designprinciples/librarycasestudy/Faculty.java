package com.designprinciples.librarycasestudy;

public class Faculty extends AbstractUser {
    // constructor
    public Faculty(String name) {
	super(name);
    }

    @Override
    public String getRole() {
	return "Faculty";
    }

    @Override
    public void update(String notification) {
	System.out.println("[Faculty " + name + "] Notification: " + notification);
    }
}