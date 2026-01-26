package com.regex.extractdates;

import java.util.regex.*;

public class ExtractDatesApp {
    public static void main(String[] args) {
        String text = "Events on 12/05/2023, 15/08/2024 and 29/02/2020";

        /**
         * Word boundary (start)      - \b
         * Two digit day              - \d{2}
         * Date separator             - /
         * Two digit month            - \d{2}
         * Date separator             - /
         * Four digit year            - \d{4}
         * Word boundary (end)        - \b
         */
        Matcher matcher = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b").matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
