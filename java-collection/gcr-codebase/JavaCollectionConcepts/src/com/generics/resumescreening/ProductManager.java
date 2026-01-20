package com.generics.resumescreening;

import java.util.List;

public class ProductManager extends JobRole {

	@Override
	public String getRoleName() {
		return "Product Manager";
	}

	@Override
	public List<String> getRequiredSkills() {
		return List.of("Agile", "Product Roadmap", "Stakeholder Management", "Market Analysis", "UX Design");
	}
}