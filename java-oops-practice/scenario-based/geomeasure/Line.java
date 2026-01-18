package com.scenariobasedquestion.geomeasure;

/**
 * Represents a line segment with two endpoints in 2D space.
 * Uses encapsulation to hide internal coordinates.
 */
public class Line {
    // Private fields for encapsulation
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private String lineName;
    
    /**
     * Constructor to initialize a line with coordinates
     * @param x1 X-coordinate of first point
     * @param y1 Y-coordinate of first point
     * @param x2 X-coordinate of second point
     * @param y2 Y-coordinate of second point
     * @param lineName Name/identifier for the line
     */
    public Line(double x1, double y1, double x2, double y2, String lineName) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.lineName = lineName;
    }
    
    /**
     * Calculates the length of the line using distance formula
     * Length = sqrt((x2-x1)² + (y2-y1)²)
     * @return Length of the line
     */
    public double calculateLength() {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }
    
    // Getters for encapsulated fields
    public double getX1() {
        return x1;
    }
    
    public double getY1() {
        return y1;
    }
    
    public double getX2() {
        return x2;
    }
    
    public double getY2() {
        return y2;
    }
    
    public String getLineName() {
        return lineName;
    }
    
    /**
     * Compares this line with another line
     * @param otherLine Line to compare with
     * @return Comparison result message
     */
    public String compareTo(Line otherLine) {
        double thisLength = this.calculateLength();
        double otherLength = otherLine.calculateLength();
        double epsilon = 0.0001; // For floating-point comparison
        
        if (Math.abs(thisLength - otherLength) < epsilon) {
            return String.format("%s and %s are equal in length (%.2f units)", 
                                this.lineName, otherLine.getLineName(), thisLength);
        } else if (thisLength > otherLength) {
            return String.format("%s (%.2f units) is longer than %s (%.2f units)", 
                                this.lineName, thisLength, otherLine.getLineName(), otherLength);
        } else {
            return String.format("%s (%.2f units) is shorter than %s (%.2f units)", 
                                this.lineName, thisLength, otherLine.getLineName(), otherLength);
        }
    }
    
    @Override
    public String toString() {
        return String.format("%s: (%.2f, %.2f) to (%.2f, %.2f) | Length: %.2f units", 
                            lineName, x1, y1, x2, y2, calculateLength());
    }
}
