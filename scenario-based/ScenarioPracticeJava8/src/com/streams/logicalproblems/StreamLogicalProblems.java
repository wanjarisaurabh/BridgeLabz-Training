package com.streams.logicalproblems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamLogicalProblems {
	// inner class
    static class Employee {
        private String name;
        private double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return name + " (Rs. " + salary + ")";
        }
    }

    public static void main(String[] args) {
    	System.out.println("===================================================");
        System.out.println("	Java 8 Stream Logical Problems Solutions");
        System.out.println("===================================================");

        // 1. Count vowels in a string
        String str1 = "programming";
        long vowelsCount = str1.chars()
                .mapToObj(ch -> String.valueOf((char) ch))
                .filter(ch -> "aeiouAEIOU".contains(ch))
                .count();
        System.out.println("1. Vowels in \"" + str1 + "\" --> " + vowelsCount);

        // 2. Count number of words in a sentence
        String sentence = "Java is very powerful";
        long wordCount = Arrays.stream(sentence.split("\\s+")).count();
        System.out.println("2. Words in \"" + sentence + "\" --> " + wordCount);

        // 3. Find even numbers from list
        List<Integer> numbers = Arrays.asList(2, 5, 7, 8, 10, 13);
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("3. Even numbers --> " + evens);

        // 4. Convert list of strings to uppercase
        List<String> words = Arrays.asList("java", "spring", "boot");
        List<String> upper = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("4. Uppercase --> " + upper);

        // 5. Find string length list
        List<String> animals = Arrays.asList("cat", "elephant", "dog");
        List<Integer> lengths = animals.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("5. Lengths --> " + lengths);

        // 6. Count strings starting with 'a'
        List<String> fruits = Arrays.asList("apple", "banana", "ant", "car");
        long countA = fruits.stream()
                .filter(s -> s.startsWith("a") || s.startsWith("A"))
                .count();
        System.out.println("6. Starts with 'a' --> " + countA);

        // 7. Remove empty strings
        List<String> listWithEmpty = Arrays.asList("java", "", "spring", "", "boot");
        List<String> nonEmpty = listWithEmpty.stream()
                .filter(s -> !s.trim().isEmpty())
                .collect(Collectors.toList());
        System.out.println("7. Without empty strings --> " + nonEmpty);

        // 8. Sum of all numbers
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println("8. Sum --> " + sum);

        // 9. Find max number
        List<Integer> maxList = Arrays.asList(10, 25, 3, 99, 45);
        int max = maxList.stream().max(Integer::compareTo).orElse(-1);
        System.out.println("9. Max --> " + max);

        // 10. Reverse each string in list
        List<String> revWords = Arrays.asList("java", "api");
        List<String> reversed = revWords.stream()
                .map(w -> new StringBuilder(w).reverse().toString())
                .collect(Collectors.toList());
        System.out.println("10. Reversed strings --> " + reversed);

        // 11. Remove duplicate elements
        List<Integer> withDup = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> unique = withDup.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("11. Unique --> " + unique);

        // 12. Sort list in descending order
        List<Integer> toSort = Arrays.asList(5, 1, 9, 3);
        List<Integer> desc = toSort.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("12. Descending --> " + desc);

        // 13. Find second highest number
        List<Integer> scores = Arrays.asList(10, 40, 30, 20);
        Optional<Integer> secondHighest = scores.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        System.out.println("13. Second highest --> " + secondHighest.orElse(-1));

        // 14. Join strings with comma
        List<String> tech = Arrays.asList("Java", "Spring", "Boot");
        String joined = String.join(",", tech);
        // or: String joined = tech.stream().collect(Collectors.joining(","));
        System.out.println("14. Joined --> " + joined);

        // 15. Frequency of each character
        String input = "banana";
        Map<Character, Long> charFreq = input.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));
        System.out.println("15. Char frequency --> " + charFreq);

        // 16. Find numbers greater than 50
        List<Integer> values = Arrays.asList(10, 55, 60, 23, 90);
        List<Integer> above50 = values.stream()
                .filter(n -> n > 50)
                .collect(Collectors.toList());
        System.out.println("16. > 50 --> " + above50);

        // 17. Group strings by length
        List<String> grp = Arrays.asList("a", "bb", "ccc", "dd");
        Map<Integer, List<String>> byLength = grp.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("17. Group by length --> " + byLength);

        // 18. First non-repeated character
        String word = "stress";
        Optional<Character> firstNonRepeated = word.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
        System.out.println("18. First non-repeated --> " + firstNonRepeated.orElse('?'));

        // 19. Convert List<Integer> to List<String>
        List<Integer> ints = Arrays.asList(1, 2, 3);
        List<String> strList = ints.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println("19. Integers to Strings --> " + strList);

        // 20. Count occurrences of each word
        String text = "java is java and java is fast";
        Map<String, Long> wordFreq = Arrays.stream(text.split("\\s+"))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println("20. Word frequency --> " + wordFreq);

        // 21. Partition numbers into even and odd
        List<Integer> mix = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> partitioned = mix.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("21. Even/Odd partition --> even=" + partitioned.get(true) +
                ", odd=" + partitioned.get(false));

        // 22. Find duplicate elements only
        List<Integer> dupList = Arrays.asList(1, 2, 3, 2, 4, 5, 1);
        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicates = dupList.stream()
                .filter(n -> !seen.add(n))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("22. Duplicates --> " + duplicates);

        // 23. Find longest string
        List<String> strs = Arrays.asList("java", "microservices", "api");
        Optional<String> longest = strs.stream()
                .max(Comparator.comparingInt(String::length));
        System.out.println("23. Longest string --> " + longest.orElse(""));

        // 24. Find top 3 highest numbers
        List<Integer> highNums = Arrays.asList(10, 90, 30, 70, 50);
        List<Integer> top3 = highNums.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("24. Top 3 highest --> " + top3);

        // 25. Flatten list of lists
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5)
        );
        List<Integer> flat = nested.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("25. Flattened --> " + flat);

        // 26. Sum of squares of even numbers
        List<Integer> sqList = Arrays.asList(1, 2, 3, 4, 5);
        int sumSquaresEven = sqList.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n * n)
                .sum();
        System.out.println("26. Sum of squares of evens --> " + sumSquaresEven);

        // 27. Sort map by value
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 3);
        map.put("B", 1);
        map.put("C", 2);

        Map<String, Integer> sortedByValue = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new
                ));
        System.out.println("27. Map sorted by value --> " + sortedByValue);

        // 28. Find employee with highest salary
        List<Employee> employees = Arrays.asList(
                new Employee("Rohan", 45000),
                new Employee("Priya", 72000),
                new Employee("Amit", 62000)
        );

        Optional<Employee> highestPaid = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("28. Highest paid employee --> " + highestPaid.orElse(null));

        // 29. Find common elements between two lists
        List<Integer> listA = Arrays.asList(1, 2, 3, 4);
        List<Integer> listB = Arrays.asList(3, 4, 5, 6);

        List<Integer> common = listA.stream()
                .filter(listB::contains)
                .collect(Collectors.toList());
        System.out.println("29. Common elements --> " + common);

        // 30. Find kth smallest element
        List<Integer> kList = Arrays.asList(9, 1, 5, 3, 7);
        int k = 2;
        Optional<Integer> kthSmallest = kList.stream()
                .sorted()
                .skip(k - 1)
                .findFirst();
        System.out.println("30. k=" + k + ", kth smallest --> " + kthSmallest.orElse(-1));
    }
}