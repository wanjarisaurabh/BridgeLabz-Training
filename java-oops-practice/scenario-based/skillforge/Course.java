package com.scenariobasedquestion.skillforge;

import java.util.ArrayList;

public class Course implements ICertifiable {
    private String title;
    private Instructor instructor;
    protected double rating;
    private ArrayList<String> modules;
    private String courseLevel;
    private int totalStudents;
    
    // Constructor with default modules
    public Course(String title, Instructor instructor, String courseLevel) {
        this.title = title;
        this.instructor = instructor;
        this.courseLevel = courseLevel;
        this.rating = 0.0;
        this.totalStudents = 0;
        
        // Default modules
        this.modules = new ArrayList<>();
        this.modules.add("Introduction");
        this.modules.add("Getting Started");
        this.modules.add("Final Assessment");
    }
    
    // Constructor with custom modules
    public Course(String title, Instructor instructor, String courseLevel, ArrayList<String> customModules) {
        this.title = title;
        this.instructor = instructor;
        this.courseLevel = courseLevel;
        this.rating = 0.0;
        this.totalStudents = 0;
        this.modules = customModules;
    }
    
    public String getTitle() {
        return title;
    }
    
    public Instructor getInstructor() {
        return instructor;
    }
    
    protected void updateRating(double newRating) {
        totalStudents++;
        rating = ((rating * (totalStudents - 1)) + newRating) / totalStudents;
    }
    
    public double getRating() {
        return rating;
    }
    
    public String getCourseLevel() {
        return courseLevel;
    }
    
    @Override
    public void generateCertificate() {
        System.out.println("\n========================================");
        System.out.println("       COURSE COMPLETION CERTIFICATE");
        System.out.println("========================================");
        System.out.println("Course: " + title);
        System.out.println("Instructor: " + instructor.getName());
        System.out.println("Level: " + courseLevel);
        
        if (courseLevel.equalsIgnoreCase("Beginner")) {
            System.out.println("Certificate Type: Basic Completion");
        } else if (courseLevel.equalsIgnoreCase("Intermediate")) {
            System.out.println("Certificate Type: Professional Completion");
        } else if (courseLevel.equalsIgnoreCase("Advanced")) {
            System.out.println("Certificate Type: Expert Mastery");
        }
        
        System.out.println("========================================");
    }
    
    public void displayCourseInfo() {
        System.out.println("\n========== COURSE DETAILS ==========");
        System.out.println("Title: " + title);
        System.out.println("Instructor: " + instructor.getName());
        System.out.println("Level: " + courseLevel);
        System.out.println("Rating: " + (rating > 0 ? rating + "/5.0" : "Not rated yet"));
        System.out.println("Total Students: " + totalStudents);
        System.out.println("\nModules:");
        for (int i = 0; i < modules.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + modules.get(i));
        }
        System.out.println("====================================");
    }
    
    public int calculateProgress(int completedModules) {
        if (modules.size() == 0) return 0;
        return (completedModules * 100) / modules.size();
    }
    
    public String gradeStudent(int score) {
        if (score >= 90) {
            return "A+ Excellent";
        } else if (score >= 80) {
            return "A Good";
        } else if (score >= 70) {
            return "B Average";
        } else if (score >= 60) {
            return "C Pass";
        } else {
            return "F Fail";
        }
    }
}
