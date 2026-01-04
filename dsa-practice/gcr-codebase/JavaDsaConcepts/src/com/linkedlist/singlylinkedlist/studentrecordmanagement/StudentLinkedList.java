package com.linkedlist.singlylinkedlist.studentrecordmanagement;

class StudentLinkedList {
    private Student head;

    // Add at beginning
    public void addAtBeginning(int roll, String name, int age, char grade) {
        Student newNode = new Student(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
        System.out.println("Student added at beginning.");
    }

    // Add at end
    public void addAtEnd(int roll, String name, int age, char grade) {
        Student newNode = new Student(roll, name, age, grade);
        if (head == null) {
            head = newNode;
            System.out.println("Student added at end.");
            return;
        }
        Student temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
        System.out.println("Student added at end.");
    }

    // Add at specific position
    public void addAtPosition(int pos, int roll, String name, int age, char grade) {
        if (pos <= 1) {
            addAtBeginning(roll, name, age, grade);
            return;
        }
        Student newNode = new Student(roll, name, age, grade);
        Student temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid position.");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Student added at position " + pos + ".");
    }

    // Delete by roll number
    public void deleteByRoll(int roll) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNo == roll) {
            head = head.next;
            System.out.println("Student record deleted.");
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNo != roll)
            temp = temp.next;

        if (temp.next == null) {
            System.out.println("Student not found.");
            return;
        }
        temp.next = temp.next.next;
        System.out.println("Student record deleted.");
    }

    // Search by roll number
    public void search(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == roll) {
                System.out.println("\nStudent Found:");
                System.out.println("Roll No: " + temp.rollNo);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                System.out.println("Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Update grade
    public void updateGrade(int roll, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Display all students
    public void display() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        Student temp = head;
        System.out.println("\nStudent Records:");
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNo +
                    " | Name: " + temp.name +
                    " | Age: " + temp.age +
                    " | Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}
