package com.smartshelf;


import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		
		System.out.println("Enter 1 to  add a book\t\tEnter 0 to exit");
		int choice=input.nextInt();
		
		while(true) {
			if(choice==0) {
				break;
			}
			System.out.println("Enter book name");
			String myBook=input.next();
			BookShelf.addBook(myBook);
			System.out.print("Current Shelf ");
			BookShelf.printShelf();
			
			System.out.println("Enter 1 to  add a book\t\tEnter 0 to exit");
			choice=input.nextInt();
			
		}
		
		input.close();
		
		System.out.println("Your final Self: ");
		BookShelf.printShelf();

	}

}
