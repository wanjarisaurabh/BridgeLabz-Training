package com.generics.resumescreening;

import java.util.List;

public class DataScientist extends JobRole {

	@Override
	public String getRoleName() {
		return "Data Scientist";
	}

	@Override
	public List<String> getRequiredSkills() {
		return List.of("Python", "Machine Learning", "SQL", "Statistics", "TensorFlow");
	}
}