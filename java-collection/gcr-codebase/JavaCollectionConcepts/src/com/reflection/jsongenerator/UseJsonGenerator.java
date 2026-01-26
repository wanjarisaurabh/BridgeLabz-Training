package com.reflection.jsongenerator;

public class UseJsonGenerator {
    public static void main(String[] args) {
	User user = new User("Rahul", 24);
	
	String json = JsonUtil.toJson(user);
	System.out.println(json);
    }
}
