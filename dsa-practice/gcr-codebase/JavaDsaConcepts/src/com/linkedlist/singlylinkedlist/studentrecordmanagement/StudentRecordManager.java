package com.linkedlist.singlylinkedlist.studentrecordmanagement;

import java.util.Scanner;

public class StudentRecordManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();
        int choice;

        while (true) {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Roll No");
            System.out.println("5. Search by Roll No");
            System.out.println("6. Update Grade");
            System.out.println("7. Display All");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Roll No: ");
                    int r1 = sc.nextInt();
                    System.out.print("Name: ");
                    String n1 = sc.next();
                    System.out.print("Age: ");
                    int a1 = sc.nextInt();
                    System.out.print("Grade: ");
                    char g1 = sc.next().charAt(0);
                    list.addAtBeginning(r1, n1, a1, g1);
                    break;

                case 2:
                    System.out.print("Roll No: ");
                    int r2 = sc.nextInt();
                    System.out.print("Name: ");
                    String n2 = sc.next();
                    System.out.print("Age: ");
                    int a2 = sc.nextInt();
                    System.out.print("Grade: ");
                    char g2 = sc.next().charAt(0);
                    list.addAtEnd(r2, n2, a2, g2);
                    break;

                case 3:
                    System.out.print("Position: ");
                    int pos = sc.nextInt();
                    System.out.print("Roll No: ");
                    int r3 = sc.nextInt();
                    System.out.print("Name: ");
                    String n3 = sc.next();
                    System.out.print("Age: ");
                    int a3 = sc.nextInt();
                    System.out.print("Grade: ");
                    char g3 = sc.next().charAt(0);
                    list.addAtPosition(pos, r3, n3, a3, g3);
                    break;

                case 4:
                    System.out.print("Enter Roll No to delete: ");
                    list.deleteByRoll(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Roll No to search: ");
                    list.search(sc.nextInt());
                    break;

                case 6:
                    System.out.print("Enter Roll No: ");
                    int r = sc.nextInt();
                    System.out.print("Enter new Grade: ");
                    char g = sc.next().charAt(0);
                    list.updateGrade(r, g);
                    break;

                case 7:
                    list.display();
                    break;

                case 8:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
