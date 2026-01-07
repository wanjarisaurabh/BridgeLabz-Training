package com.scenariobasedquestion.hotelscenario;

// HotelRoom class
public class HotelRoom {
    // room number
    int roomNumber;
    // room type
    String roomType;
    // is available
    boolean isAvailable;

    // constructor
    public HotelRoom(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isAvailable = true;
    }

    // method to book room
    public void bookRoom() {
        if (isAvailable) {
            isAvailable = false;
        }
    }

    // method to check out
    public void checkOut() {
        isAvailable = true;
    }

    // display room
    public void displayRoom() {
        System.out.println("Room " + roomNumber + " Type: " + roomType + " Available: " + isAvailable);
    }
}