package com.scenariobasedquestion.hotelscenario;

// HotelDemo class
public class HotelDemo {
    public static void main(String[] args) {
        // create guest
        HotelGuest guest = new HotelGuest("Alice", 456);
        // create room
        HotelRoom room = new HotelRoom(101, "Deluxe");
        // create booking
        HotelBooking booking = new HotelBooking(1, guest, room, "2023-10-01");

        // display booking
        booking.displayBooking();

        // check out
        room.checkOut();
        // display room again
        room.displayRoom();
    }
}