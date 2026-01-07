package com.scenariobasedquestion.loanbuddy;

public class HomeLoan extends LoanApplication {
	
	
	public HomeLoan(Applicant applicant,double term,double interestRate) {
		super(applicant,"Home",term,interestRate);
	}
	
	public boolean approveLoan() {
		// approval conditions creditScore ≥ 700 income ≥ 50,000 and emi<=40% of income
		if(this.applicant.getCredit()>=600 && this.applicant.getIncome()>=25000) {
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
