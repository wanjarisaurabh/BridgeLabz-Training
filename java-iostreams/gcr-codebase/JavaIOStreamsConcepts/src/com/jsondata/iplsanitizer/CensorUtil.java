package com.jsondata.iplsanitizer;

public class CensorUtil {
    // Masks second word in team name
    public static String maskTeamName(String team) {
	String[] parts = team.split(" ");

	if (parts.length > 1) {
	    return parts[0] + " ***";
	}

	return team;
    }

    // Replaces player name
    public static String redactPlayer() {
	return "REDACTED";
    }
}
