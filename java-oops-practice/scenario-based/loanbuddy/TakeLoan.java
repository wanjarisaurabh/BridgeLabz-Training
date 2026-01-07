package com.scenariobasedquestion.loanbuddy;

import java.util.Scanner;

public class TakeLoan {
	   public static final String RESET = "\u001B[0m";

	    // Regular Colors
	    
	    public static final String RED    = "\u001B[31m";
	    public static final String GREEN  = "\u001B[32m";
	    public static final String YELLOW = "\u001B[33m";
	    public static final String BLUE   = "\u001B[34m";
	    public static final String PURPLE = "\u001B[35m";
	    public static final String CYAN   = "\u001B[36m";
	    public static final String WHITE  = "\u001B[37m";

	    // Bold Colors
	    public static final String BOLD_RED    = "\u001B[1;31m";
	    public static final String BOLD_GREEN  = "\u001B[1;32m";
	    public static final String BOLD_YELLOW = "\u001B[1;33m";
	    public static final String BOLD_BLUE   = "\u001B[1;34m";

	    // Background Colors
	    public static final String BG_RED    = "\u001B[41m";
	    public static final String BG_GREEN  = "\u001B[42m";
	    public static final String BG_YELLOW = "\u001B[43m";
	    public static final String BG_BLUE   = "\u001B[44m";

	public static void main(String[] args) {
		
		
		System.out.println(BOLD_YELLOW+"╔════════════════════════════════╗");
		System.out.println("║                                ║");
		System.out.println("║          LOAN BUDDY            ║");
		System.out.println("║                                ║");
		System.out.println("╚════════════════════════════════╝"+RESET);
		
		Scanner input=new Scanner(System.in);
		
		//taking choice for loan type
		System.out.println(YELLOW+"Which loan do you need: "+RESET);
		System.out.println("ENTER: ");
		System.out.println(BLUE+"1\t"+RESET+GREEN+"Home Loan"+RESET);
		System.out.println(BLUE+"2\t"+RESET+GREEN+"Personal Loan"+RESET);
		System.out.println(BLUE+"3\t"+RESET+GREEN+"Education Loan"+RESET);
		System.out.println(BLUE+"0\t"+RESET+GREEN+"Exit"+RESET);
		//taking input
		System.out.println("Enter here 1/2/3/0: ");
		int choice=input.nextInt();
		
		//logic for loan
		if(choice==0) {
			System.out.println(BG_BLUE+"Exiting the program..."+RESET);
			
		}
		else {
			//Taking Proper details
			System.out.println("Enter your name: ");
			String name=input.next();
			System.out.println("Enter your income: ");
			double income=input.nextDouble();
			System.out.println("Enter your credit score: ");
			int creditScore=input.nextInt();
			System.out.println("Enter your loan amount: ");
			double loanAmount=input.nextDouble();
			
			
			// For home loan
			if(choice==1) {
				//creating applicant
				Applicant person1=new Applicant(name,creditScore,income,loanAmount);
				System.out.println("Term of the loan: ");
				double term=input.nextDouble();
				double interestRate=8.7;
				
				
				//home loan objects
				HomeLoan hl1=new HomeLoan(person1,term,interestRate);
				if(hl1.approveLoan()==true) {
					System.out.println(GREEN+"Your loan has been approved"+RESET);
					System.out.println();
					System.out.println(PURPLE+"╔═════════════════════════════════════════════════════╗");
					System.out.printf("║ %-20s %-30s ║","Name", hl1.applicant.getName());
					System.out.println();
					System.out.printf("║ %-20s %-30s ║","Loan-Type" , hl1.loanType);
						System.out.println(); 
					System.out.printf("║ %-20s %-30f ║","Income", hl1.applicant.getIncome());
					System.out.println();
					System.out.printf("║ %-20s %-30f ║","Loan Amount", hl1.applicant.getloanAmount());
					System.out.println();
					System.out.printf("║ %-20s %-30B ║","Approval Status", hl1.approveLoan());
					System.out.println();
					System.out.printf("║ %-20s %-30f ║","EMI", hl1.calculateEmi());
					System.out.println();
					System.out.println("╚═════════════════════════════════════════════════════╝"+RESET);
				}
				else{
					//homeloan did not get approved
					System.out.println(RED+"We Regret that your loan has been Rejected"+RESET);
					System.out.println();
					System.out.println(PURPLE+"╔═════════════════════════════════════════════════════╗");
					System.out.printf("║ %-20s %-30s ║","Name", hl1.applicant.getName());
					System.out.println();
					System.out.printf("║ %-20s %-30s ║","Loan-Type" , hl1.loanType);
						System.out.println(); 
					System.out.printf("║ %-20s %-30f ║","Income", hl1.applicant.getIncome());
					System.out.println();
					System.out.printf("║ %-20s %-30f ║","Loan Amount", hl1.applicant.getloanAmount());
					System.out.println();
					System.out.printf("║ %-20s %-30B ║","Approval Status", hl1.approveLoan());
					System.out.println();
					System.out.printf("║ %-20s %-30s ║","EMI","----");
					System.out.println();
					System.out.println("╚═════════════════════════════════════════════════════╝"+RESET);
				}
			}
			
			// personl loan
			if(choice==2) {
				Applicant person1=new Applicant(name,creditScore,income,loanAmount);
				System.out.println("Term of the loan: ");
				double term=input.nextDouble();
				double interestRate=8.6;
				
				//creating personal loan
				PersonalLoan hl1=new PersonalLoan(person1,term,interestRate);
				
				//checking of the loan was approved
				if(hl1.approveLoan()==true) {
					System.out.println(GREEN+"Your loan has been approved"+RESET);
					System.out.println();
					System.out.println(PURPLE+"╔═════════════════════════════════════════════════════╗");
					System.out.printf("║ %-20s %-30s ║","Name", hl1.applicant.getName());
					System.out.println();
					System.out.printf("║ %-20s %-30s ║","Loan-Type" , hl1.loanType);
					System.out.println(); 
					System.out.printf("║ %-20s %-30f ║","Income", hl1.applicant.getIncome());
					System.out.println();
					System.out.printf("║ %-20s %-30f ║","Loan Amount", hl1.applicant.getloanAmount());
					System.out.println();
					System.out.printf("║ %-20s %-30B ║","Approval Status", hl1.approveLoan());
					System.out.println();
					System.out.printf("║ %-20s %-30f ║","EMI", hl1.calculateEmi());
					System.out.println();
					System.out.println("╚═════════════════════════════════════════════════════╝"+RESET);
				}
				else{
					System.out.println(RED+"We Regret that your loan has been Rejected"+RESET);
					System.out.println();
					System.out.println(PURPLE+"╔═════════════════════════════════════════════════════╗");
					System.out.printf("║ %-20s %-30s ║","Name", hl1.applicant.getName());
					System.out.println();
					System.out.printf("║ %-20s %-30s ║","Loan-Type" , hl1.loanType);
						System.out.println(); 
					System.out.printf("║ %-20s %-30f ║","Income", hl1.applicant.getIncome());
					System.out.println();
					System.out.printf("║ %-20s %-30f ║","Loan Amount", hl1.applicant.getloanAmount());
					System.out.println();
					System.out.printf("║ %-20s %-30B ║","Approval Status", hl1.approveLoan());
					System.out.println();
					System.out.printf("║ %-20s %-30s ║","EMI", "----");
					System.out.println();
					System.out.println("╚═════════════════════════════════════════════════════╝"+RESET);
				}
			}
			
			
			// education loan
						if(choice==3) {
							Applicant person1=new Applicant(name,creditScore,income,loanAmount);
							System.out.println("Term of the loan: ");
							double term=input.nextDouble();
							double interestRate=8.5;
							
							//creating education loan
							PersonalLoan hl1=new PersonalLoan(person1,term,interestRate);
							
							//checking of the loan was approved
							if(hl1.approveLoan()==true) {
								System.out.println(GREEN+"Your loan has been approved"+RESET);
								System.out.println();
								System.out.println(PURPLE+"╔═════════════════════════════════════════════════════╗");
								System.out.printf("║ %-20s %-30s ║","Name", hl1.applicant.getName());
								System.out.println();
								System.out.printf("║ %-20s %-30s ║","Loan-Type" , hl1.loanType);
								System.out.println(); 
								System.out.printf("║ %-20s %-30f ║","Income", hl1.applicant.getIncome());
								System.out.println();
								System.out.printf("║ %-20s %-30f ║","Loan Amount", hl1.applicant.getloanAmount());
								System.out.println();
								System.out.printf("║ %-20s %-30B ║","Approval Status", hl1.approveLoan());
								System.out.println();
								System.out.printf("║ %-20s %-30f ║","EMI", hl1.calculateEmi());
								System.out.println();
								System.out.println("╚═════════════════════════════════════════════════════╝"+RESET);
							}
							else{
								System.out.println(RED+"We Regret that your loan has been Rejected"+RESET);
								System.out.println();
								System.out.println(PURPLE+"╔═════════════════════════════════════════════════════╗");
								System.out.printf("║ %-20s %-30s ║","Name", hl1.applicant.getName());
								System.out.println();
								System.out.printf("║ %-20s %-30s ║","Loan-Type" , hl1.loanType);
								System.out.println(); 
								System.out.printf("║ %-20s %-30f ║","Income", hl1.applicant.getIncome());
								System.out.println();
								System.out.printf("║ %-20s %-30f ║","Loan Amount", hl1.applicant.getloanAmount());
								System.out.println();
								System.out.printf("║ %-20s %-30B ║","Approval Status", hl1.approveLoan());
								System.out.println();
								System.out.printf("║ %-20s %-30s ║","EMI","----");
								System.out.println();
								System.out.println("╚═════════════════════════════════════════════════════╝"+RESET);
							}
						}
						else {
							System.out.println("Invalid Input");
						}
			
			
		}
		input.close();
	}
	
	
	
	
	
	

}
