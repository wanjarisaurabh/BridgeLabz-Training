/*
 * Program Name : PostgraduateStudent
 * Description  : Access protected members using inheritance.
 */

package com.constructor.level1;

class PostgraduateStudent extends Student {
    PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    void display() {
        System.out.println(rollNumber + " | " + name + " | " + getCGPA());
    }
}
