package com.regex.extractlinks;

import java.util.regex.*;

public class ExtractLinksApp {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org";

        /**
         * Protocol (http or https)   	- https?
         * Protocol separator        	- ://
         * One or more non-space chars	- \S+
         */
        Matcher matcher = Pattern.compile("https?://\\S+").matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
