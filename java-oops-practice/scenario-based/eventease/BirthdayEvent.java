package com.scenariobasedquestion.eventease;

// Birthday Event class with specific scheduling behavior
public class BirthdayEvent extends Event {
    
    private String birthdayPersonName;
    private int age;
    
    public BirthdayEvent(String eventId, String eventName, String location, String date,
                        int attendees, User organizer, double venueCost,
                        String birthdayPersonName, int age) {
        super(eventId, eventName, location, date, attendees, organizer, venueCost);
        this.birthdayPersonName = birthdayPersonName;
        this.age = age;
    }
    
    public BirthdayEvent(String eventId, String eventName, String location, String date,
                        int attendees, User organizer, double venueCost,
                        boolean hasCatering, boolean hasDecoration,
                        String birthdayPersonName, int age) {
        super(eventId, eventName, location, date, attendees, organizer, venueCost,
              hasCatering, hasDecoration);
        this.birthdayPersonName = birthdayPersonName;
        this.age = age;
    }
    
    @Override
    public void schedule() {
        if (isScheduled()) {
            System.out.println("Birthday party is already scheduled!");
            return;
        }
        setScheduled(true);
        System.out.println("\n===== Birthday Party Scheduled =====");
        System.out.println("Celebrating " + birthdayPersonName + "'s " + age + "th birthday!");
        System.out.println("Date: " + getDate());
        System.out.println("Venue: " + getLocation());
        System.out.println("Guests: " + getAttendees());
        System.out.println("Birthday cake and decorations arranged!");
    }
    
    @Override
    public void reschedule(String newDate, String newLocation) {
        if (!isScheduled()) {
            System.out.println("Cannot reschedule - event not scheduled yet.");
            return;
        }
        System.out.println("\nRescheduling birthday party...");
        System.out.println("New Date: " + newDate);
        System.out.println("New Location: " + newLocation);
        setDate(newDate);
        setLocation(newLocation);
        System.out.println("Birthday party rescheduled successfully!");
    }
}
