package com.scenariobasedquestion.bookbazaar;

/**
 * PrintedBook class - physical books with different discount
 */
public class PrintedBook extends Book {
    private int pages;
    
    public PrintedBook(String title, String author, double price, int stock, int pages) {
        super(title, author, price, stock);
        this.pages = pages;
    }
    
    public PrintedBook(String title, String author, double price, int stock, double offerPercent, int pages) {
        super(title, author, price, stock, offerPercent);
        this.pages = pages;
    }
    
    public int getPages() {
        return pages;
    }
    
    // Polymorphism: Printed books get 10% discount
    @Override
    public double applyDiscount() {
        return getPrice() * 0.90; // 10% discount for printed books
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Printed Book");
        System.out.println("Pages: " + pages);
    }
}
