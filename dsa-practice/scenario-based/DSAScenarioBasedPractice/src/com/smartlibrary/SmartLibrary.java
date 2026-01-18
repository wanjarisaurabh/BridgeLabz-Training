package com.smartlibrary;

import java.util.ArrayList;
import java.util.Scanner;

public class SmartLibrary {
    
    private ArrayList<Book> borrowedBooks;
    
    public SmartLibrary(){
        borrowedBooks=new ArrayList<>();
    }
    
    public void insertBook(Book newBook){
        borrowedBooks.add(newBook);
        
        //insertion sort
        int i=borrowedBooks.size()-1;
        while(i>0 && borrowedBooks.get(i-1).getTitle().compareToIgnoreCase(borrowedBooks.get(i).getTitle())>0){
            Book temp=borrowedBooks.get(i);
            borrowedBooks.set(i,borrowedBooks.get(i-1));
            borrowedBooks.set(i-1,temp);
            i--;
        }
    }
    
    public void displayBooks(){
        if(borrowedBooks.isEmpty()){
            System.out.println("No books borrowed yet");
            return;
        }
        System.out.println("\n=== Borrowed Books (Alphabetically) ===");
        for(int i=0;i<borrowedBooks.size();i++){
            Book b=borrowedBooks.get(i);
            System.out.println((i+1)+". "+b.getTitle()+" by "+b.getAuthor()+" (Borrowed: "+b.getBorrowDate()+")");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        SmartLibrary library=new SmartLibrary();
        
        while(true){
            System.out.println("\n--- Smart Library Kiosk ---");
            System.out.println("1. Borrow a Book");
            System.out.println("2. View My Books");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            
            int choice=sc.nextInt();
            sc.nextLine();
            
            if(choice==1){
                System.out.print("Book title: ");
                String title=sc.nextLine();
                System.out.print("Author: ");
                String author=sc.nextLine();
                System.out.print("Borrow date (dd/mm/yyyy): ");
                String date=sc.nextLine();
                
                Book book=new Book(title,author,date);
                library.insertBook(book);
                System.out.println("Book borrowed and added to your list!");
            }
            else if(choice==2){
                library.displayBooks();
            }
            else if(choice==3){
                System.out.println("Thank you for using Smart Library!");
                break;
            }
            else{
                System.out.println("Invalid choice");
            }
        }
        
        sc.close();
    }
}
