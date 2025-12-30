/*
 * Program Name : Course
 * Description  : Online Course Management using static members.
 */

package com.constructor.level1;

class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "CodInClub";

    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    void displayCourseDetails() {
        System.out.println(courseName + " | " + duration + " | " + fee + " | " + instituteName);
    }

    static void updateInstituteName(String name) {
        instituteName = name;
    }
}
