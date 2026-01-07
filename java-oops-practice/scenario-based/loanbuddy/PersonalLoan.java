package com.scenariobasedquestion.loanbuddy;

public class PersonalLoan extends LoanApplication {
	
	
	public PersonalLoan(Applicant applicant,double term,double interestRate) {
		super(applicant,"Home",term,interestRate);
	}
	
	public boolean approveLoan() {
		// approval conditions creditScore ≥ 720 income ≥ 40,000 emi<=30% of income
		if(this.applicant.getCredit()>=720 && this.applicant.getIncome()>=40000
				&& (0.30*this.applicant.getIncome()>=calculateEmi())) {
			return true;
		}
		return false;

	}
	
	public double calculateEmi() {
		double emi = (this.applicant.getloanAmount() * this.interestRate * Math.pow(1 + this.interestRate, this.term)) /
	             (Math.pow(1 + this.interestRate, this.term) - 1);
		return emi;
	}
	
	
	
}