package com.jsondata.combinejson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class MergeJsonFiles {
    public static void main(String[] args) {
	// sample files paths
	String file1 = "samplefiles/combinejson/data1.json";
	String file2 = "samplefiles/combinejson/data2.json";

	ObjectMapper mapper = new ObjectMapper();

	try {
	    // Read both JSON files
	    JsonNode json1 = mapper.readTree(new File(file1));
	    JsonNode json2 = mapper.readTree(new File(file2));

	    // Create a new object to store merged data
	    ObjectNode mergedJson = mapper.createObjectNode();

	    // Add all fields from first JSON
	    mergeNodes(mergedJson, json1);

	    // Add all fields from second JSON
	    mergeNodes(mergedJson, json2);

	    // Print merged JSON
	    System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson));

	} catch (IOException e) {
	    System.out.println("Error reading JSON files.");
	}
    }

    // Copies fields from source node into target object
    private static void mergeNodes(ObjectNode target, JsonNode source) {
	
	// Loop through all key-value pairs in source JSON
	for (Map.Entry<String, JsonNode> entry : source.properties()) {

	    // Add each field into the target JSON object
	    target.set(entry.getKey(), entry.getValue());
	}
    }
}
