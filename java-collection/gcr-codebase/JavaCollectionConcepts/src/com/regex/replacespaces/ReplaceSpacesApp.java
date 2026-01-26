package com.regex.replacespaces;

public class ReplaceSpacesApp {
    public static void main(String[] args) {
        String text = "This   is   an    example";

        // replace multiple whitespaces with single one
        String result = text.replaceAll("\\s+", " ");
        
        System.out.println(result);
    }
}
