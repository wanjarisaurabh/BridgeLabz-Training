/*
 * Program Name : CarRental
 * Description  : Calculates total rental cost based on
 *                number of rental days.
 */

package com.constructor.level1;

class CarRental {

    // Rental details
    String customerName;
    String carModel;
    int rentalDays;

    // Constant rate per day
    static final double RATE_PER_DAY = 1200.0;

    // Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    // Method to calculate total rental cost
    double calculateTotalCost() {
        return rentalDays * RATE_PER_DAY;
    }

    // Method to display rental summary
    void display() {
        System.out.println("Customer Name : " + customerName);
        System.out.println("Car Model     : " + carModel);
        System.out.println("Total Cost    : ₹" + calculateTotalCost());
    }
}
