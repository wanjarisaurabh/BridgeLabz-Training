package com.jsondata.printkeysvalues;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class PrintJsonKeysAndValues {
    public static void main(String[] args) {
	// sample file path
	String filePath = "samplefiles/printkeysvalues/data.json";

	ObjectMapper mapper = new ObjectMapper();
	try {
	    // Read JSON file into tree structure
	    JsonNode rootNode = mapper.readTree(new File(filePath));

	    // Print all keys and values
	    printNode(rootNode);

	} catch (IOException e) {
	    System.out.println("Error reading JSON file.");
	}
    }

    // Recursively prints keys and values from JSON
    private static void printNode(JsonNode node) {
	// Traverse JSON object fields
	if (node.isObject()) {

	    for (Map.Entry<String, JsonNode> entry : node.properties()) {
		System.out.println(entry.getKey() + " -> " + entry.getValue());
		printNode(entry.getValue());
	    }

	}

	// Traverse JSON arrays
	if (node.isArray()) {
	    for (JsonNode element : node) {
		printNode(element);
	    }
	}
    }
}
