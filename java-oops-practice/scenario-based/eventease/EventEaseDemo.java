package com.scenariobasedquestion.eventease;

// Demo class to show EventEase platform functionality
public class EventEaseDemo {
    
    public static void main(String[] args) {
        
        System.out.println("========== WELCOME TO EVENTEASE ==========\n");
        
        // Create users (organizers)
        User user1 = new User("U001", "Priya Sharma", "priya@email.com", "9876543210");
        User user2 = new User("U002", "Rajesh Kumar", "rajesh@email.com", "9988776655");
        
        // Create Birthday Event without packages
        BirthdayEvent birthday1 = new BirthdayEvent(
            "EV001",
            "Aarav's 10th Birthday",
            "Green Park Resort",
            "2026-02-15",
            50,
            user1,
            25000,
            "Aarav",
            10
        );
        
        // Create Birthday Event with catering and decoration
        BirthdayEvent birthday2 = new BirthdayEvent(
            "EV002",
            "Neha's Sweet 16",
            "Royal Banquet Hall",
            "2026-03-20",
            100,
            user1,
            40000,
            true,   // has catering
            true,   // has decoration
            "Neha",
            16
        );
        
        // Create Conference Event with packages
        ConferenceEvent conference = new ConferenceEvent(
            "EV003",
            "Tech Summit 2026",
            "Convention Center",
            "2026-04-10",
            300,
            user2,
            100000,
            true,   // has catering
            true,   // has decoration
            "AI and Future Technologies",
            8
        );
        
        // Display initial event details
        System.out.println("===== Initial Event Setup =====");
        birthday1.displayEventDetails();
        birthday2.displayEventDetails();
        conference.displayEventDetails();
        
        // Schedule events - demonstrating polymorphism
        System.out.println("\n\n===== Scheduling Events =====");
        birthday1.schedule();
        birthday2.schedule();
        conference.schedule();
        
        // Apply discounts
        System.out.println("\n\n===== Applying Discounts =====");
        birthday2.applyDiscount(10);  // 10% early bird discount
        conference.applyDiscount(15); // 15% corporate discount
        
        // Display updated costs
        System.out.println("\n===== Updated Event Costs =====");
        System.out.println(birthday2.getEventName() + " - Total: Rs." + birthday2.calculateTotalCost());
        System.out.println(conference.getEventName() + " - Total: Rs." + conference.calculateTotalCost());
        
        // Reschedule an event
        System.out.println("\n\n===== Rescheduling Events =====");
        birthday1.reschedule("2026-02-22", "Sunset Garden");
        conference.reschedule("2026-04-15", "Grand Convention Hall");
        
        // Try to cancel an event
        System.out.println("\n\n===== Cancelling Event =====");
        birthday1.cancel();
        
        // Display final status
        System.out.println("\n\n===== Final Event Status =====");
        birthday1.displayEventDetails();
        birthday2.displayEventDetails();
        conference.displayEventDetails();
        
        // Demonstrate polymorphism with array
        System.out.println("\n\n===== Polymorphism Demo =====");
        Event[] events = {birthday1, birthday2, conference};
        
        System.out.println("\nAll event costs:");
        for (Event event : events) {
            if (!event.isCancelled()) {
                System.out.println(event.getEventName() + ": Rs." + event.calculateTotalCost());
            }
        }
    }
}
