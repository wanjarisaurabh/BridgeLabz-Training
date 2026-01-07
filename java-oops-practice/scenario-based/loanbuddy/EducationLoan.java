package com.scenariobasedquestion.loanbuddy;

public class EducationLoan extends LoanApplication {
	
	
	public EducationLoan(Applicant applicant,double term,double interestRate) {
		super(applicant,"Education",term,interestRate);
	}
	
	public boolean approveLoan() {
		// approval conditions creditScore ≥ 600 income ≥ 25,000 emi<=45% of income
		if(this.applicant.getCredit()>=600 && this.applicant.getIncome()>=25000
				&& (0.45*this.applicant.getIncome()>=calculateEmi())) {
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
