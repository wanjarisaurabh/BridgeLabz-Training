package com.scenariobasedquestion.mediaStore;

import java.time.LocalDate;

public class Syrup extends Medicine {
    
    public Syrup(String name, double price, LocalDate expiryDate) {
        super(name, price, expiryDate);
    }
    
    public Syrup(String name, double price, LocalDate expiryDate, int quantity) {
        super(name, price, expiryDate, quantity);
    }
    
    // Liquid medicines expire 30 days before stated date
    @Override
    public boolean checkExpiry() {
        LocalDate earlyExpiry = getExpiryDate().minusDays(30);
        return LocalDate.now().isAfter(earlyExpiry);
    }
}
