package com.smartshelf;

import java.util.ArrayList;

//class for Books shelf
public class BookShelf {
	private static ArrayList<String> bookList=new ArrayList<>();
	
	public static void addBook(String Book) {
		bookList.add(Book);
		String pivot=bookList.get(bookList.size()-1);
		int j=bookList.size()-1;
		
		//loop for updatin the system;
		
		while(j>=1 && bookList.get(j-1).compareTo(pivot)>0) {
			
				bookList.set(j,bookList.get(j-1));
				
			
			j--;
			
			
		}
		bookList.set(j, pivot);
		
		
		
	}
	
	public static void printShelf() {
		System.out.print("[ ");
		for(int i=0;i<bookList.size();i++) {
			
			System.out.print(bookList.get(i)+ " ");
		}
		System.out.println(" ]");
	}
}
