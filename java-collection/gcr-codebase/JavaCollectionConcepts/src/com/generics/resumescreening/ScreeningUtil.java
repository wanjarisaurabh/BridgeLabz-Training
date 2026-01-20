package com.generics.resumescreening;

import java.util.List;

public class ScreeningUtil {

	// Generic method: evaluates screening decision for any bounded resume
	public static <T extends JobRole> String getScreeningDecision(Resume<T> resume) {
		double score = resume.calculateMatchScore();
		if (score >= 80.0) {
			return "Strong Match - Advance";
		} else if (score >= 60.0) {
			return "Potential Fit - Review";
		} else {
			return "Not Suitable";
		}
	}

	// Wildcard method: displays required skills across mixed job roles
	public static void displayPipelineRoles(List<? extends JobRole> roles) {
		System.out.println("Screening Pipeline - Active Job Roles:");
		for (JobRole role : roles) {
			System.out.println("  * " + role);
		}
		System.out.println();
	}
}