package com.practice;

public class App {

    // S2068: hardcoded credentials (Vulnerability, Blocker)
    private static final String PASSWORD = "sonarqube:D";

    public static void main(String[] args) {
        // S106: standard output should not be used for logging
        System.out.println("Practice application is running with password: " + PASSWORD);

        int unused = 5; // S1481: unused local variable

        System.out.println(length(null));
    }

    // S2259: null is dereferenced -> NullPointerException (Bug, Major)
    private static int length(String text) {
        if (text == null) {
            // S108: empty block, the null case is not handled
        }
        return text.length();
    }
}
