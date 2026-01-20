package com.generics.resumescreening;

import java.util.List;

public abstract class JobRole {

	// Returns role name
	public abstract String getRoleName();

	// Returns required skills
	public abstract List<String> getRequiredSkills();

	// good string representation
	@Override
	public String toString() {
		return getRoleName() + " (Required: " + getRequiredSkills() + ")";
	}
}