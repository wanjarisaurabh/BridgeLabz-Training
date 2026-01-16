package com.zipzipmart;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		
		//Instantiating the Scanner
		Scanner input=new Scanner(System.in);
		
		
		System.out.println("Enter the size of the Sales Record");
		int size=input.nextInt();
		
		//making the array
		Sales[] report=new Sales[size];
		
		
		for(int i=0;i<size;i++) {
			System.out.println("Enter name of product: ");
			String productName=input.next();
			
			System.out.println("Enter the amount");
			double amount=input.nextDouble();
			
			System.out.println("Enter date of this sale");
			LocalDate date=LocalDate.parse(input.next(),DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			
			Sales sale=new Sales(productName,date,amount);
			report[i]=sale;
			
		}
		
		Sales.makeReport(report);
		
		for(Sales sale:report) {
			System.out.printf("%-20s %-10s %-10.2f",sale.product,sale.saleDate.toString(),sale.amount);
			System.err.println();
		}
		
		input.close();
		

	}

}
