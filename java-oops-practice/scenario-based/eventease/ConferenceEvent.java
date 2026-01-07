package com.scenariobasedquestion.eventease;

// Conference Event class with specific scheduling behavior
public class ConferenceEvent extends Event {
    
    private String conferenceTheme;
    private int numberOfSessions;
    
    public ConferenceEvent(String eventId, String eventName, String location, String date,
                          int attendees, User organizer, double venueCost,
                          String conferenceTheme, int numberOfSessions) {
        super(eventId, eventName, location, date, attendees, organizer, venueCost);
        this.conferenceTheme = conferenceTheme;
        this.numberOfSessions = numberOfSessions;
    }
    
    public ConferenceEvent(String eventId, String eventName, String location, String date,
                          int attendees, User organizer, double venueCost,
                          boolean hasCatering, boolean hasDecoration,
                          String conferenceTheme, int numberOfSessions) {
        super(eventId, eventName, location, date, attendees, organizer, venueCost,
              hasCatering, hasDecoration);
        this.conferenceTheme = conferenceTheme;
        this.numberOfSessions = numberOfSessions;
    }
    
    @Override
    public void schedule() {
        if (isScheduled()) {
            System.out.println("Conference is already scheduled!");
            return;
        }
        setScheduled(true);
        System.out.println("\n===== Conference Scheduled =====");
        System.out.println("Theme: " + conferenceTheme);
        System.out.println("Date: " + getDate());
        System.out.println("Venue: " + getLocation());
        System.out.println("Expected Attendees: " + getAttendees());
        System.out.println("Sessions: " + numberOfSessions);
        System.out.println("Audio-visual equipment and seating arranged!");
    }
    
    @Override
    public void reschedule(String newDate, String newLocation) {
        if (!isScheduled()) {
            System.out.println("Cannot reschedule - conference not scheduled yet.");
            return;
        }
        System.out.println("\nRescheduling conference...");
        System.out.println("Notifying all " + getAttendees() + " attendees...");
        System.out.println("New Date: " + newDate);
        System.out.println("New Location: " + newLocation);
        setDate(newDate);
        setLocation(newLocation);
        System.out.println("Conference rescheduled successfully!");
        System.out.println("Email notifications sent to all participants.");
    }
}
