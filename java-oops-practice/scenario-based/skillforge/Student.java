package com.scenariobasedquestion.skillforge;

import java.util.ArrayList;

public class Student extends User {
    private ArrayList<Course> enrolledCourses;
    private int certificatesEarned;
    
    public Student(String name, String email, int userId) {
        super(name, email, userId);
        this.enrolledCourses = new ArrayList<>();
        this.certificatesEarned = 0;
    }
    
    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        System.out.println(getName() + " enrolled in: " + course.getTitle());
    }
    
    public void completeCourse(Course course) {
        if (enrolledCourses.contains(course)) {
            System.out.println(getName() + " completed: " + course.getTitle());
            certificatesEarned++;
        } else {
            System.out.println("You are not enrolled in this course!");
        }
    }
    
    public int getCertificatesEarned() {
        return certificatesEarned;
    }
    
    @Override
    public void displayUserInfo() {
        System.out.println("\n===== STUDENT PROFILE =====");
        super.displayUserInfo();
        System.out.println("Role: Student");
        System.out.println("Enrolled Courses: " + enrolledCourses.size());
        System.out.println("Certificates Earned: " + certificatesEarned);
        System.out.println("===========================");
    }
    
    public void displayEnrolledCourses() {
        System.out.println("\n--- Enrolled Courses ---");
        if (enrolledCourses.isEmpty()) {
            System.out.println("No courses enrolled yet");
        } else {
            for (int i = 0; i < enrolledCourses.size(); i++) {
                System.out.println((i + 1) + ". " + enrolledCourses.get(i).getTitle());
            }
        }
    }
}
