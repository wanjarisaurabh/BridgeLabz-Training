package com.scenariobasedquestion.bookbazaar;

/**
 * EBook class - electronic books with different discount
 */
public class EBook extends Book {
    private double fileSize; // in MB
    
    public EBook(String title, String author, double price, int stock, double fileSize) {
        super(title, author, price, stock);
        this.fileSize = fileSize;
    }
    
    public EBook(String title, String author, double price, int stock, double offerPercent, double fileSize) {
        super(title, author, price, stock, offerPercent);
        this.fileSize = fileSize;
    }
    
    public double getFileSize() {
        return fileSize;
    }
    
    // Polymorphism: EBooks get 15% discount
    @Override
    public double applyDiscount() {
        return getPrice() * 0.85; // 15% discount for ebooks
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: EBook");
        System.out.println("File Size: " + fileSize + " MB");
    }
}
