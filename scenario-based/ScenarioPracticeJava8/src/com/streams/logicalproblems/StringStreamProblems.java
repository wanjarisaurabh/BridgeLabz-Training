package com.streams.logicalproblems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringStreamProblems {
    public static void main(String[] args) {
    	System.out.println("===================================================");
        System.out.println("	Strings Stream Logical Problems Solutions");
        System.out.println("===================================================");


        // 1. Character Frequency Count
        String input1 = "banana";
        Map<Character, Long> freq1 = input1.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new, // preserves insertion order
                        Collectors.counting()
                ));

        System.out.println("1. Character frequency --> " + freq1);


        // 2. Word Frequency Count
        String input2 = "java is java and java is fast";
        Map<String, Long> wordFreq = Arrays.stream(input2.split("\\s+"))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        System.out.println("2. Word frequency --> " + wordFreq);


        // 3. First Non-Repeating Character
        String input3 = "stress";
        Optional<Character> firstNonRepeat = input3.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

        System.out.println("3. First non-repeating char --> " + 
                firstNonRepeat.map(String::valueOf).orElse("None"));


        // 4. All Non-Repeating Characters
        String input4 = "programming";
        String nonRepeating = input4.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> String.valueOf(e.getKey()))
                .collect(Collectors.joining(" "));

        System.out.println("4. All non-repeating chars --> " + 
                (nonRepeating.isEmpty() ? "None" : nonRepeating));


        // 5. Remove Duplicate Characters (keep first occurrence)
        String input5 = "banana";
        String uniqueChars = input5.chars()
                .mapToObj(ch -> String.valueOf((char) ch))
                .distinct()
                .collect(Collectors.joining(""));

        System.out.println("5. After removing duplicates --> " + uniqueChars);


        // 6. Remove Repeating Characters (keep only those that appear exactly once)
        String input6 = "aabbccdde";
        String onlySingles = input6.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> String.valueOf(e.getKey()))
                .collect(Collectors.joining(""));

        System.out.println("6. Characters that appear only once --> " + 
                (onlySingles.isEmpty() ? "None" : onlySingles));


        // 7. Remove Non-Alphanumeric Characters
        String input7 = "ja@va#8!!";
        String alphanumeric = input7.chars()
                .filter(ch -> Character.isLetterOrDigit(ch))
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining(""));

        System.out.println("7. Only alphanumeric --> " + alphanumeric);


        // 8. Keep Only Alphabets
        String input8 = "java8stream2025";
        String onlyLetters = input8.chars()
                .filter(Character::isLetter)
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining(""));

        System.out.println("8. Only alphabets --> " + onlyLetters);


        // 9. Keep Only Digits
        String input9 = "orderId=AB123XZ9";
        String onlyDigits = input9.chars()
                .filter(Character::isDigit)
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining(""));

        System.out.println("9. Only digits --> " + onlyDigits);


        // 10. Count Each Character Except Spaces
        String input10 = "java stream";
        Map<Character, Long> freqNoSpace = input10.chars()
                .filter(ch -> !Character.isWhitespace(ch))
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        System.out.println("10. Frequency (ignoring spaces) --> " + freqNoSpace);
    }
}