package com.smartlibrary;

public class Book {
    private String title;
    private String author;
    private String borrowDate;
    
    public Book(String title,String author,String date){
        this.title=title;
        this.author=author;
        this.borrowDate=date;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public String getBorrowDate(){
        return borrowDate;
    }
}
