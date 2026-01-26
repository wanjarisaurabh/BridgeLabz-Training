package com.annotations.taskinfo;

public class TaskManager {
    // Method annotated with TaskInfo
    @TaskInfo(priority = "HIGH", assignedTo = "AP")
    public void completeTask() {
        System.out.println("Task is being completed.");
    }
}
