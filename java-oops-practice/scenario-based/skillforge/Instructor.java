package com.scenariobasedquestion.skillforge;

import java.util.ArrayList;

public class Instructor extends User {
    private ArrayList<Course> coursesCreated;
    private String expertise;
    
    public Instructor(String name, String email, int userId, String expertise) {
        super(name, email, userId);
        this.coursesCreated = new ArrayList<>();
        this.expertise = expertise;
    }
    
    public void createCourse(Course course) {
        coursesCreated.add(course);
        System.out.println("Course '" + course.getTitle() + "' created by " + getName());
    }
    
    public String getExpertise() {
        return expertise;
    }
    
    @Override
    public void displayUserInfo() {
        System.out.println("\n===== INSTRUCTOR PROFILE =====");
        super.displayUserInfo();
        System.out.println("Role: Instructor");
        System.out.println("Expertise: " + expertise);
        System.out.println("Courses Created: " + coursesCreated.size());
        System.out.println("==============================");
    }
    
    public void displayCreatedCourses() {
        System.out.println("\n--- Created Courses ---");
        if (coursesCreated.isEmpty()) {
            System.out.println("No courses created yet");
        } else {
            for (int i = 0; i < coursesCreated.size(); i++) {
                System.out.println((i + 1) + ". " + coursesCreated.get(i).getTitle());
            }
        }
    }
}
