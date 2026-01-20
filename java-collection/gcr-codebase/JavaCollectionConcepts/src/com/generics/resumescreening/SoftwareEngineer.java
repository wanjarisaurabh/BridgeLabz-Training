package com.generics.resumescreening;

import java.util.List;

public class SoftwareEngineer extends JobRole {

	@Override
	public String getRoleName() {
		return "Software Engineer";
	}

	@Override
	public List<String> getRequiredSkills() {
		return List.of("Java", "OOP", "Data Structures", "Algorithms", "Spring Boot");
	}
}