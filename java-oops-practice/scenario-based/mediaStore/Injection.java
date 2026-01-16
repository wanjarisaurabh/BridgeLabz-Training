package com.scenariobasedquestion.mediaStore;

import java.time.LocalDate;

public class Injection extends Medicine {
    
    public Injection(String name, double price, LocalDate expiryDate) {
        super(name, price, expiryDate);
    }
    
    public Injection(String name, double price, LocalDate expiryDate, int quantity) {
        super(name, price, expiryDate, quantity);
    }
    
    // Injections expire 15 days before stated date
    @Override
    public boolean checkExpiry() {
        LocalDate earlyExpiry = getExpiryDate().minusDays(15);
        return LocalDate.now().isAfter(earlyExpiry);
    }
}
