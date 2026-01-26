package com.regex.validatehexcolor;

public class ValidateHexColorApp {

    public static void main(String[] args) {
        String color = "#FFA500";

        /**
         * Start of String 		- ^
         * First character		- #
         * Following six characters	- [0-9a-fA-F]{6}
         * End of String		- $
         */
        String regex = "^#[0-9a-fA-F]{6}$";

        System.out.println(color.matches(regex) ? "Valid" : "Invalid");
    }
}
