package com.scenariobasedquestion.mediaStore;

import java.time.LocalDate;

public class Tablet extends Medicine {
    
    public Tablet(String name, double price, LocalDate expiryDate) {
        super(name, price, expiryDate);
    }
    
    public Tablet(String name, double price, LocalDate expiryDate, int quantity) {
        super(name, price, expiryDate, quantity);
    }
    
    // Tablets have longer shelf life
    @Override
    public boolean checkExpiry() {
        return LocalDate.now().isAfter(getExpiryDate());
    }
}
