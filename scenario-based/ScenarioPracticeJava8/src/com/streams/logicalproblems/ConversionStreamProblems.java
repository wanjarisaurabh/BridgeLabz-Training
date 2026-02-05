package com.streams.logicalproblems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConversionStreamProblems {
    // Inner class for Employee
    static class Employee {
        private int id;
        private String name;
        private String dept;
        private double salary;

        public Employee(int id, String name, String dept, double salary) {
            this.id = id;
            this.name = name;
            this.dept = dept;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDept() {
            return dept;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return name + " (" + dept + ", Rs. " + salary + ")";
        }
    }

    public static void main(String[] args) {
        // Sample data used in many examples
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "apple", "date");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 6);

        List<Employee> employees = Arrays.asList(
                new Employee(101, "Amit", "IT", 65000),
                new Employee(102, "Priya", "HR", 48000),
                new Employee(103, "Rahul", "IT", 72000),
                new Employee(104, "Sneha", "Sales", 55000),
                new Employee(105, "Vikram", "HR", 51000)
        );
        
        System.out.println("===================================================");
        System.out.println("  Java 8 Stream Conversion Problems Solutions");
        System.out.println("===================================================");


        // =================================================================
        System.out.println("\n====== List --> Map Conversions ======\n");
        // =================================================================

        // 1. List<String> --> Map<String, Integer> (word --> length)
        Map<String, Integer> strToLen = fruits.stream()
                .collect(Collectors.toMap(
                        s -> s,
                        String::length,
                        (v1, v2) -> v1   // keep first
                ));
        System.out.println("1. String --> length map:      " + strToLen);

        // 2. List<Integer> --> Map<Integer, Integer> (number --> square)
        Map<Integer, Integer> numToSquare = numbers.stream()
                .collect(Collectors.toMap(
                        n -> n,
                        n -> n * n,
                        (v1, v2) -> v1
                ));
        System.out.println("2. Number --> square:          " + numToSquare);

        // 3. List<Employee> --> Map<Integer, String> (id --> name)
        Map<Integer, String> idToName = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        Employee::getName
                ));
        System.out.println("3. ID --> Name map:            " + idToName);

        // 4. List<String> --> Map<String, Long> (word --> frequency)
        Map<String, Long> wordFreq = fruits.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println("4. Word frequency:             " + wordFreq);

        // 5. List --> Map with index as key
        Map<Integer, String> indexToValue = IntStream.range(0, fruits.size())
                .boxed()
                .collect(Collectors.toMap(
                        i -> i,
                        fruits::get
                ));
        System.out.println("5. Index --> value:            " + indexToValue);

        // 6. Custom key field (name --> employee)
        Map<String, Employee> nameToEmp = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        e -> e,
                        (e1, e2) -> e1   // keep first
                ));
        System.out.println("6. Name --> Employee:          " + nameToEmp);

        // 7. Duplicate keys - keep first
        Map<String, Integer> dupMergeFirst = fruits.stream()
                .collect(Collectors.toMap(
                        s -> s,
                        String::length,
                        (old, newV) -> old
                ));
        System.out.println("7. Duplicate keys (first):     " + dupMergeFirst);

        // 8. Duplicate keys - keep last
        Map<String, Integer> dupMergeLast = fruits.stream()
                .collect(Collectors.toMap(
                        s -> s,
                        String::length,
                        (old, newV) -> newV
                ));
        System.out.println("8. Duplicate keys (last):      " + dupMergeLast);

        // 10. Group by length
        Map<Integer, List<String>> byLength = fruits.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("10. Group by length:           " + byLength);


        // =================================================================
        System.out.println("\n====== Map --> List Conversions ======\n");
        // =================================================================

        Map<String, Integer> sampleMap = new HashMap<>();
        sampleMap.put("A", 10);
        sampleMap.put("B", 25);
        sampleMap.put("C", 15);
        sampleMap.put("D", 8);

        // 1. Keys to List
        List<String> keys = new ArrayList<>(sampleMap.keySet());
        System.out.println("1. Map keys --> List:          " + keys);

        // 2. Values to List
        List<Integer> values = new ArrayList<>(sampleMap.values());
        System.out.println("2. Map values --> List:        " + values);

        // 3. Entries to List
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(sampleMap.entrySet());
        System.out.println("3. Entries --> List:           " + entries);

        // 4. List of "key=value" strings
        List<String> keyValueStr = sampleMap.entrySet().stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.toList());
        System.out.println("4. key=value strings:          " + keyValueStr);

        // 6. Sorted by key
        List<String> sortedKeys = sampleMap.keySet().stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("6. Keys sorted:                " + sortedKeys);

        // 7. Sorted by value (keys)
        List<String> sortedByValue = sampleMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("7. Keys sorted by value:       " + sortedByValue);

        // 8. Filter value > 12
        List<String> highValueKeys = sampleMap.entrySet().stream()
                .filter(e -> e.getValue() > 12)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("8. Keys where value > 12:      " + highValueKeys);


        // =================================================================
        System.out.println("\n====== List --> Set Conversions ======\n");
        // =================================================================

        // 1. List to Set (remove duplicates)
        Set<Integer> uniqueNums = numbers.stream()
        		.collect(Collectors.toSet());
        System.out.println("1. List --> Set:               " + uniqueNums);

        // 2. LinkedHashSet (preserve insertion order)
        Set<Integer> orderedSet = numbers.stream()
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println("2. LinkedHashSet:              " + orderedSet);

        // 3. TreeSet (sorted)
        Set<Integer> sortedSet = numbers.stream()
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("3. TreeSet (sorted):           " + sortedSet);

        // 6. Set of departments from employees
        Set<String> depts = employees.stream()
                .map(Employee::getDept)
                .collect(Collectors.toSet());
        System.out.println("6. Set of departments:         " + depts);


        // =================================================================
        System.out.println("\n====== Array <--> Collection Conversions ======\n");
        // =================================================================

        String[] arr = {"red", "green", "blue", "green"};

        // 1. Array --> List
        List<String> fromArray = Arrays.stream(arr).collect(Collectors.toList());
        System.out.println("1. Array --> List:             " + fromArray);

        // 3. List --> Array
        String[] backToArray = fromArray.toArray(String[]::new);
        System.out.println("3. List --> Array:             " + Arrays.toString(backToArray));

        // 5. int[] --> List<Integer>
        int[] intArr = {10, 20, 30, 20};
        List<Integer> intList = Arrays.stream(intArr)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("5. int[] --> List:             " + intList);


        // =================================================================
        System.out.println("\n====== Object Collection Conversions ======\n");
        // =================================================================

        // 1. List<Employee> --> Map<id, Employee>
        Map<Integer, Employee> idToEmployee = employees.stream()
                .collect(Collectors.toMap(Employee::getId, e -> e));
        System.out.println("1. id --> Employee:            " + idToEmployee);

        // 2. Map<Dept, List<Employee>>
        Map<String, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept));
        System.out.println("2. Dept --> Employees:         " + byDept);

        // 3. Set of departments
        Set<String> uniqueDepts = employees.stream()
                .map(Employee::getDept)
                .collect(Collectors.toSet());
        System.out.println("3. Unique departments:         " + uniqueDepts);


        // =================================================================
        System.out.println("\n====== Other Useful Conversions ======\n");
        // =================================================================

        // 5. List to comma-separated String
        String csv = fruits.stream().collect(Collectors.joining(", "));
        System.out.println("5. Comma-separated:            " + csv);

        // 7. Map to comma-separated string (key=value)
        String mapAsString = sampleMap.entrySet().stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining(", "));
        System.out.println("7. Map as string:              " + mapAsString);

        // 8. Grouped map --> back to flat list
        List<String> flatFromGroups = byLength.entrySet().stream()
                .flatMap(e -> e.getValue().stream())
                .collect(Collectors.toList());
        System.out.println("8. Flat from grouped:          " + flatFromGroups);
    }
}