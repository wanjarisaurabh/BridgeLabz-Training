package com.jsondata.jsontoxml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class JsonToXmlConverter {
    public static void main(String[] args) {
	// sample files path
	String jsonFile = "samplefiles/jsontoxml/data.json";
	String xmlFile = "samplefiles/jsontoxml/data.xml";

	ObjectMapper jsonMapper = new ObjectMapper();
	XmlMapper xmlMapper = new XmlMapper();

	try {
	    // Read JSON file into tree structure
	    JsonNode jsonNode = jsonMapper.readTree(new File(jsonFile));

	    // Convert JSON tree into XML and write to file
	    xmlMapper.writerWithDefaultPrettyPrinter().writeValue(new File(xmlFile), jsonNode);

	    System.out.println("JSON converted to XML successfully.");

	} catch (IOException e) {
	    System.out.println("Error converting JSON to XML.");
	    System.out.println(e.getMessage());
	}
    }
}
