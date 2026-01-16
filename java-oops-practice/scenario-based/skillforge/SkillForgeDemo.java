package com.scenariobasedquestion.skillforge;

import java.util.Scanner;
import java.util.ArrayList;

public class SkillForgeDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("********************************************");
        System.out.println("     WELCOME TO SKILLFORGE");
        System.out.println("    Online Learning Portal");
        System.out.println("********************************************\n");
        
        // Create instructor
        System.out.println("--- Instructor Registration ---");
        System.out.print("Enter instructor name: ");
        String instructorName = input.nextLine();
        
        System.out.print("Enter instructor email: ");
        String instructorEmail = input.nextLine();
        
        System.out.print("Enter instructor ID: ");
        int instructorId = input.nextInt();
        input.nextLine();
        
        System.out.print("Enter area of expertise: ");
        String expertise = input.nextLine();
        
        Instructor instructor = new Instructor(instructorName, instructorEmail, instructorId, expertise);
        instructor.displayUserInfo();
        
        // Create courses
        System.out.println("\n\n--- Course Creation ---");
        
        // Course with default modules
        System.out.print("\nEnter course 1 title: ");
        String course1Title = input.nextLine();
        
        System.out.print("Enter course level (Beginner/Intermediate/Advanced): ");
        String level1 = input.nextLine();
        
        Course course1 = new Course(course1Title, instructor, level1);
        instructor.createCourse(course1);
        
        // Course with custom modules
        System.out.print("\nEnter course 2 title: ");
        String course2Title = input.nextLine();
        
        System.out.print("Enter course level (Beginner/Intermediate/Advanced): ");
        String level2 = input.nextLine();
        
        System.out.print("Enter number of custom modules: ");
        int numModules = input.nextInt();
        input.nextLine();
        
        ArrayList<String> customModules = new ArrayList<>();
        for (int i = 0; i < numModules; i++) {
            System.out.print("Enter module " + (i + 1) + " name: ");
            String moduleName = input.nextLine();
            customModules.add(moduleName);
        }
        
        Course course2 = new Course(course2Title, instructor, level2, customModules);
        instructor.createCourse(course2);
        
        // Display instructor courses
        instructor.displayCreatedCourses();
        
        // Create student
        System.out.println("\n\n--- Student Registration ---");
        System.out.print("Enter student name: ");
        String studentName = input.nextLine();
        
        System.out.print("Enter student email: ");
        String studentEmail = input.nextLine();
        
        System.out.print("Enter student ID: ");
        int studentId = input.nextInt();
        input.nextLine();
        
        Student student = new Student(studentName, studentEmail, studentId);
        student.displayUserInfo();
        
        // Display available courses
        System.out.println("\n\n********************************************");
        System.out.println("        AVAILABLE COURSES");
        System.out.println("********************************************");
        
        System.out.println("\n[1] Course 1:");
        course1.displayCourseInfo();
        
        System.out.println("\n[2] Course 2:");
        course2.displayCourseInfo();
        
        // Enroll student
        System.out.println("\n\n--- Course Enrollment ---");
        System.out.print("Which course do you want to enroll in? (1 or 2): ");
        int courseChoice = input.nextInt();
        input.nextLine();
        
        Course selectedCourse;
        if (courseChoice == 1) {
            student.enrollCourse(course1);
            selectedCourse = course1;
        } else {
            student.enrollCourse(course2);
            selectedCourse = course2;
        }
        
        student.displayEnrolledCourses();
        
        // Track progress
        System.out.println("\n\n--- Course Progress ---");
        System.out.print("How many modules have you completed? ");
        int completedModules = input.nextInt();
        input.nextLine();
        
        int progress = selectedCourse.calculateProgress(completedModules);
        System.out.println("Course Progress: " + progress + "%");
        
        // Grade student
        System.out.print("\nEnter your final score (0-100): ");
        int score = input.nextInt();
        input.nextLine();
        
        String grade = selectedCourse.gradeStudent(score);
        System.out.println("Your Grade: " + grade);
        
        // Complete course and generate certificate
        if (score >= 60) {
            System.out.println("\nCongratulations! You passed the course!");
            student.completeCourse(selectedCourse);
            
            // Rate the course
            System.out.print("\nRate this course (1-5): ");
            double rating = input.nextDouble();
            input.nextLine();
            
            selectedCourse.updateRating(rating);
            
            // Generate certificate
            System.out.println("\nGenerating your certificate...");
            selectedCourse.generateCertificate();
        } else {
            System.out.println("\nUnfortunately, you did not pass. Please try again.");
        }
        
        // Display final student info
        student.displayUserInfo();
        
        // Display final course info
        System.out.println("\n--- Updated Course Info ---");
        selectedCourse.displayCourseInfo();
        
        System.out.println("\n********************************************");
        System.out.println("   THANK YOU FOR USING SKILLFORGE!");
        System.out.println("********************************************");
        
        input.close();
    }
}
