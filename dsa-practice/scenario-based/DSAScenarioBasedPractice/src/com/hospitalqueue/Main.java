package com.hospitalqueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Scanner instatiation
		
		Scanner input=new Scanner(System.in);
		//number of patients
		System.out.println("Enter number of pateints ");
		int n=input.nextInt();
		
		//PATIENT ARRAY
		Patients[] p=new Patients[n];
		
		for(int i=0;i<n;i++) {
			System.out.println("Enter detail of pateint "+i+": ");
			System.out.println("Name:  ");
			String name=input.next();
			System.out.println("Criticality [1,10]: ");
			int criticality=input.nextInt();
			
			Patients pTemp=new Patients(name,i+1,criticality);
			p[i]=pTemp;
		}
		
		//Before sorting
		System.out.println("Before sorting: ");
		
		for(int i=0;i<n;i++) {
			System.out.println(p[i].name+" -- "+p[i].criticality);
		}
		
		//AFTER SORTING
		System.out.println("after sorting: ");
		
		ApolloHospital.sortByBubble(p);
		
		
		for(int i=0;i<n;i++) {
			System.out.println(p[i].name+" -- "+p[i].criticality);
		}
		
	}

}
