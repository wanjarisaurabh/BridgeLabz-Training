package com.lambdas.student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StudentLambdas {
    static class Student {
        String name;
        int age;
        int marks;
        int rank;

        public Student(String name, int age, int marks, int rank) {
            this.name = name;
            this.age = age;
            this.marks = marks;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + ", marks=" + marks + ", rank=" + rank + "}";
        }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Priya", 17, 78, 12),
                new Student("Aman", 19, 92, 3),
                new Student("Sneha", 16, 45, 89),
                new Student("Rahul", 20, 88, 7),
                new Student("Kavya", 18, 65, 34)
        );

        // 1. Welcome message using lambda
        Consumer<Student> welcome = s -> System.out.println("Welcome " + s.name + "! Great to see you.");
        System.out.println("1. Welcome messages:");
        students.forEach(welcome);

        // 2. Pass/Fail using lambda
        Predicate<Student> isPass = s -> s.marks >= 50;
        System.out.println("\n2. Pass/Fail status:");
        students.forEach(s -> System.out.println(s.name + " ==> " + (isPass.test(s) ? "Pass" : "Fail")));

        // 3. Sort by name
        System.out.println("\n3. Sorted by name:");
        students.stream()
                .sorted(Comparator.comparing(s -> s.name))
                .forEach(System.out::println);

        // 4. Sort by rank
        System.out.println("\n4. Sorted by rank:");
        students.stream()
                .sorted(Comparator.comparingInt(s -> s.rank))
                .forEach(System.out::println);

        // 5. Age > 18
        System.out.println("\n5. Students above 18 years:");
        students.stream()
                .filter(s -> s.age > 18)
                .forEach(System.out::println);
    }
}