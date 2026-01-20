/*
	5. AI-Driven Resume Screening System
	Concepts: Generic Classes, Generic Methods, Bounded Type Parameters, Wildcards
	Problem Statement:
		Develop an AI-Driven Resume Screening System that can process resumes for different job roles like Software Engineer, Data Scientist, and Product Manager while ensuring type safety.
	Hints:
		Create an abstract class JobRole (SoftwareEngineer, DataScientist, ProductManager).
		Implement a generic class Resume<T extends JobRole> to process resumes dynamically.
		Use a wildcard method (List<? extends JobRole>) to handle multiple job roles in the screening pipeline.
*/

package com.generics.resumescreening;

import java.util.ArrayList;
import java.util.List;

public class ResumeScreeningApp {
	public static void main(String[] args) {
		System.out.println("AI-Driven Resume Screening System\n");

		SoftwareEngineer se = new SoftwareEngineer();
		DataScientist ds = new DataScientist();
		ProductManager pm = new ProductManager();

		// Mixed roles collection for pipeline
		List<JobRole> pipelineRoles = new ArrayList<>();
		pipelineRoles.add(se);
		pipelineRoles.add(ds);
		pipelineRoles.add(pm);

		// Display using wildcard method
		ScreeningUtil.displayPipelineRoles(pipelineRoles);

		// Sample resumes
		Resume<SoftwareEngineer> r1 = new Resume<>("Alice Sharma",
				List.of("Java", "OOP", "Data Structures", "Algorithms", "Spring Boot", "Git"), se);

		Resume<DataScientist> r2 = new Resume<>("Bob Patel", List.of("Python", "SQL", "Statistics"), ds);

		Resume<ProductManager> r3 = new Resume<>("Carol Singh",
				List.of("Agile", "Product Roadmap", "Stakeholder Management", "Market Analysis", "UX Design"), pm);

		Resume<SoftwareEngineer> r4 = new Resume<>("David Kumar", List.of("Python", "Agile", "SQL"), se);

		// AI screening using generic method
		System.out.println("Resume Screening Results:");
		System.out.println(r1 + " -> " + ScreeningUtil.getScreeningDecision(r1));
		System.out.println(r2 + " -> " + ScreeningUtil.getScreeningDecision(r2));
		System.out.println(r3 + " -> " + ScreeningUtil.getScreeningDecision(r3));
		System.out.println(r4 + " -> " + ScreeningUtil.getScreeningDecision(r4));
	}
}