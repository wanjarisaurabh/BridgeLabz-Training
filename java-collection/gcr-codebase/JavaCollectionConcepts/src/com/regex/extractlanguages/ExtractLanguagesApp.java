package com.regex.extractlanguages;

import java.util.regex.*;

public class ExtractLanguagesApp {
    public static void main(String[] args) {
        String text = "I love Java, Python, JavaScript, and Go";

        /**
         * Word boundary (start)           - \b
         * Allowed language names          - (Java|Python|JavaScript|Go)
         * Word boundary (end)             - \b
         */
        Matcher matcher = Pattern.compile("\\b(Java|Python|JavaScript|Go)\\b").matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
