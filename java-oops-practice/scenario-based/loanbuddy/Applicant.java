package com.scenariobasedquestion.loanbuddy;

//applicant class
public class Applicant {
	private String name;
	private int creditScore;;
	private double income;
	private double loanAmount;

	public Applicant(String name, int creditScore, double income, double loanAmount) {
		this.name = name;
		this.creditScore = creditScore;
		this.income = income;

		this.loanAmount = loanAmount;

	}
	
	//required getters

	public String getName() {
		return this.name;
	}

	public double getIncome() {
		return this.income;
	}

	public double getCredit() {
		return this.creditScore;
	}

	public double getloanAmount() {
		return this.loanAmount;
	}

}
