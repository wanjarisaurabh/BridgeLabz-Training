
package com.scenariobasedquestion.loanbuddy;

// interface for approval messages and EMI calculation
public interface Approvable {
	boolean approveLoan();
	double calculateEmi();
}
