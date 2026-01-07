package com.scenariobasedquestion.eventease;

// Interface for event scheduling operations
public interface ISchedulable {
    void schedule();
    void reschedule(String newDate, String newLocation);
    void cancel();
}
