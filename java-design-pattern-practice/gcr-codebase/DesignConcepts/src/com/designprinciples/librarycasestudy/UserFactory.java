package com.designprinciples.librarycasestudy;

public class UserFactory {
    // Creates new User: Student / Faculty / Librarian
    public static User createUser(String name, String role) {
	return switch (role.toLowerCase()) {
	case "student" -> new Student(name);
	case "faculty" -> new Faculty(name);
	case "librarian" -> new Librarian(name);
	default -> throw new IllegalArgumentException("Unknown role: " + role);
	};
    }
}