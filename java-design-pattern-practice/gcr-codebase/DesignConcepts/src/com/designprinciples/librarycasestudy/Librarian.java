package com.designprinciples.librarycasestudy;

public class Librarian extends AbstractUser {
    // constructor
    public Librarian(String name) {
	super(name);
    }

    @Override
    public String getRole() {
	return "Librarian";
    }

    @Override
    public void update(String notification) {
	System.out.println("[Librarian " + name + "] Notification: " + notification);
    }
}