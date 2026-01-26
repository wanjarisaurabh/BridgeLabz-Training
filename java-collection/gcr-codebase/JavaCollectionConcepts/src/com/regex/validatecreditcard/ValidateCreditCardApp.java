package com.regex.validatecreditcard;

public class ValidateCreditCardApp {
    public static void main(String[] args) {
        String card = "4123456789012345";

        /** 
         * Start of string                - ^
         * First digit (4 or 5)           - (4|5)
         * Following fifteen digits       - \d{15}
         * End of string                  - $
         */
        String regex = "^(4|5)\\d{15}$";

        System.out.println(card.matches(regex) ? "Valid Card" : "Invalid Card");
    }
}
