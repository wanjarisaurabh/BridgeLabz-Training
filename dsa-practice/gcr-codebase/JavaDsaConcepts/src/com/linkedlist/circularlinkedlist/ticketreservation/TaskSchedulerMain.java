package com.linkedlist.circularlinkedlist.ticketreservation;

public class TaskSchedulerMain {
    public static void main(String[] args) {

        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtEnd(1, "Design Module", 1, "2026-01-10");
        scheduler.addAtEnd(2, "Write Code", 2, "2026-01-12");
        scheduler.addAtBeginning(3, "Requirement Analysis", 1, "2026-01-05");
        scheduler.addAtPosition(2, 4, "Testing", 3, "2026-01-15");
        scheduler.displayAllTasks();
        System.out.println("\nVewing tasks circularly:");
        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();

        System.out.println("\nSearch by priority 1:");
        scheduler.searchByPriority(1);
        System.out.println("\nRemoving task with ID 2:");
        scheduler.removeByTaskId(2);
        scheduler.displayAllTasks();
    }
}
