package com.scenariobasedquestion.loanbuddy;



//class for loan application, it will be base class for this
//● LoanApplication class with loan type, term, and interest rate.
public abstract class LoanApplication implements Approvable{
	protected Applicant applicant;
	protected String loanType;
	protected double term;
	protected double interestRate;
	
	public LoanApplication(Applicant applicant, String loanType,double term, double interestRate) {
		this.loanType=loanType;
		this.term=term;
		this.interestRate=interestRate;
		this.applicant=applicant;
	}
}
