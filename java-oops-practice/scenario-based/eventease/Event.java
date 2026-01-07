package com.scenariobasedquestion.eventease;

// Base Event class
public abstract class Event implements ISchedulable {
    
    private final String eventId;  // Final - cannot be modified once assigned
    private String eventName;
    private String location;
    private String date;
    private int attendees;
    private User organizer;
    private boolean isScheduled;
    private boolean isCancelled;
    
    // Encapsulated pricing details
    private double venueCost;
    private double serviceCost;
    private double discount;
    private boolean hasCatering;
    private boolean hasDecoration;
    
    // Constructor without packages
    public Event(String eventId, String eventName, String location, String date, 
                 int attendees, User organizer, double venueCost) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.location = location;
        this.date = date;
        this.attendees = attendees;
        this.organizer = organizer;
        this.venueCost = venueCost;
        this.serviceCost = 0;
        this.discount = 0;
        this.hasCatering = false;
        this.hasDecoration = false;
        this.isScheduled = false;
        this.isCancelled = false;
    }
    
    // Constructor with catering and decoration packages
    public Event(String eventId, String eventName, String location, String date, 
                 int attendees, User organizer, double venueCost, 
                 boolean hasCatering, boolean hasDecoration) {
        this(eventId, eventName, location, date, attendees, organizer, venueCost);
        this.hasCatering = hasCatering;
        this.hasDecoration = hasDecoration;
        
        // Calculate service costs
        if (hasCatering) {
            serviceCost += attendees * 500;  // Rs. 500 per person
        }
        if (hasDecoration) {
            serviceCost += 15000;  // Fixed decoration cost
        }
    }
    
    // EventId is final and read-only
    public String getEventId() {
        return eventId;
    }
    
    public String getEventName() {
        return eventName;
    }
    
    public String getLocation() {
        return location;
    }
    
    public String getDate() {
        return date;
    }
    
    public int getAttendees() {
        return attendees;
    }
    
    public User getOrganizer() {
        return organizer;
    }
    
    public boolean isScheduled() {
        return isScheduled;
    }
    
    public boolean isCancelled() {
        return isCancelled;
    }
    
    // Protected setters for internal use
    protected void setScheduled(boolean scheduled) {
        isScheduled = scheduled;
    }
    
    protected void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }
    
    protected void setDate(String date) {
        this.date = date;
    }
    
    protected void setLocation(String location) {
        this.location = location;
    }
    
    // Apply discount - encapsulated pricing logic
    public void applyDiscount(double discountPercent) {
        if (discountPercent > 0 && discountPercent <= 100) {
            this.discount = discountPercent;
            System.out.println("Discount of " + discountPercent + "% applied!");
        }
    }
    
    // Calculate total cost: venue + services - discount
    public double calculateTotalCost() {
        double totalCost = venueCost + serviceCost;
        double discountAmount = totalCost * discount / 100;
        return totalCost - discountAmount;
    }
    
    // Protected method to get pricing details
    protected void displayPricing() {
        System.out.println("\n--- Pricing Breakdown ---");
        System.out.println("Venue Cost: Rs." + venueCost);
        System.out.println("Service Cost: Rs." + serviceCost);
        if (hasCatering) {
            System.out.println("  - Catering: Included");
        }
        if (hasDecoration) {
            System.out.println("  - Decoration: Included");
        }
        if (discount > 0) {
            System.out.println("Discount: " + discount + "%");
        }
        System.out.println("Total Cost: Rs." + calculateTotalCost());
    }
    
    @Override
    public void cancel() {
        if (isCancelled) {
            System.out.println("Event is already cancelled.");
            return;
        }
        isCancelled = true;
        isScheduled = false;
        System.out.println("Event " + eventName + " has been cancelled.");
    }
    
    public void displayEventDetails() {
        System.out.println("\n===== Event Details =====");
        System.out.println("Event ID: " + eventId);
        System.out.println("Event Name: " + eventName);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Attendees: " + attendees);
        System.out.println("Status: " + (isCancelled ? "Cancelled" : 
                                        (isScheduled ? "Scheduled" : "Not Scheduled")));
        organizer.displayUserInfo();
        displayPricing();
        System.out.println();
    }
}
