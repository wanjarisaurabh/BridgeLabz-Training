package com.jsondata.iplsanitizer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.Map;

public class IplJsonProcessor {
    // Reads JSON, applies censorship, writes JSON
    public static void process() {
	// sample files paths
	String inputFile = "samplefiles/iplsanitizer/ipl.json";
	String outputFile = "samplefiles/iplsanitizer/ipl-censored.json";

	ObjectMapper mapper = new ObjectMapper();
	try {
	    List<IplMatch> matches = mapper.readValue(new File(inputFile), new TypeReference<List<IplMatch>>() {
	    });

	    for (IplMatch match : matches) {
		match.setTeam1(CensorUtil.maskTeamName(match.getTeam1()));
		match.setTeam2(CensorUtil.maskTeamName(match.getTeam2()));
		match.setWinner(CensorUtil.maskTeamName(match.getWinner()));
		match.setPlayer_of_match(CensorUtil.redactPlayer());

		Map<String, Integer> newScore = match.getScore();
		match.setScore(newScore);
	    }

	    mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), matches);
	    System.out.println("Censored JSON file generated.");

	} catch (Exception e) {
	    System.out.println("Error processing JSON file.");
	    System.out.println(e.getMessage());
	}
    }
}
