package com.scenariobasedquestion.hotelscenario;

// HotelBooking class
public class HotelBooking {
    // booking id
    int bookingId;
    // guest
    HotelGuest guest;
    // room
    HotelRoom room;
    // check in date
    String checkInDate;

    // constructor
    public HotelBooking(int bookingId, HotelGuest guest, HotelRoom room, String checkInDate) {
        this.bookingId = bookingId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        room.bookRoom(); // book the room
    }

    // display booking
    public void displayBooking() {
        System.out.println("Booking ID: " + bookingId + " Check-in: " + checkInDate);
        guest.displayGuest();
        room.displayRoom();
    }
}