package com.designprinciples.librarycasestudy;

public abstract class AbstractUser implements User {
    protected String name;

    // constructor
    public AbstractUser(String name) {
	this.name = name;
    }

    @Override
    public String getName() {
	return name;
    }
}