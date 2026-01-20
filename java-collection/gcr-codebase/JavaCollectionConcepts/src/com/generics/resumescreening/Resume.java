package com.generics.resumescreening;

import java.util.List;

public class Resume<T extends JobRole> {
	private String candidateName;
	private List<String> candidateSkills;
	private T jobRole;

	// Constructor
	public Resume(String candidateName, List<String> candidateSkills, T jobRole) {
		this.candidateName = candidateName;
		this.candidateSkills = candidateSkills;
		this.jobRole = jobRole;
	}

	// AI-driven match score calculation (percentage)
	public double calculateMatchScore() {
		List<String> required = jobRole.getRequiredSkills();
		if (required.isEmpty())
			return 100.0;
		long matched = required.stream()
				.filter(req -> candidateSkills.stream().anyMatch(skill -> skill.equalsIgnoreCase(req))).count();
		return (double) matched / required.size() * 100.0;
	}

	// Returns associated job role
	public T getJobRole() {
		return jobRole;
	}

	// good string representation
	@Override
	public String toString() {
		return candidateName + " -> " + jobRole.getRoleName() + " (AI Score: "
				+ String.format("%.2f%%", calculateMatchScore()) + ")";
	}
}