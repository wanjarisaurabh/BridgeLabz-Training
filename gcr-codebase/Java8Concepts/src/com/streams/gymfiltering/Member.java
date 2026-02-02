package com.streams.gymfiltering;

import java.time.LocalDate;

public class Member {
    private String name;
    private LocalDate expiryDate;

    public Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean expiresWithin30Days() {
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysLater = today.plusDays(30);
        return expiryDate.isAfter(today) && expiryDate.isBefore(thirtyDaysLater.plusDays(1));
    }

    @Override
    public String toString() {
        return name + " -> expires on " + expiryDate;
    }
}