/*
 * Program Name : Circle
 * Description  : Uses constructor chaining to initialize radius
 *                with default and user-provided values.
 */

package com.constructor.level1;

class Circle {

    // Variable to store radius of the circle
    double radius;

    // Default constructor
    Circle() {
        // Calling parameterized constructor using this()
        this(1.0);
    }

    // Parameterized constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate and return area of the circle
    double getArea() {
        return Math.PI * radius * radius;
    }
}
