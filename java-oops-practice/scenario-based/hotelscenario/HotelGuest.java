package com.scenariobasedquestion.hotelscenario;

// HotelGuest class
public class HotelGuest {
    // guest name
    String guestName;
    // guest id
    int guestId;

    // constructor
    public HotelGuest(String guestName, int guestId) {
        this.guestName = guestName;
        this.guestId = guestId;
    }

    // method to display guest
    public void displayGuest() {
        System.out.println("Guest: " + guestName + " ID: " + guestId);
    }
}