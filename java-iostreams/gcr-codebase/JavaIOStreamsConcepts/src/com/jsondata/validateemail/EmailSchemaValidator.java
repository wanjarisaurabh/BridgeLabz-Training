package com.jsondata.validateemail;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class EmailSchemaValidator {
    public static void main(String[] args) {
	// sample files path
	String jsonFile = "samplefiles/validateemail/user.json";
	String schemaFile = "samplefiles/validateemail/email_schema.json";

	ObjectMapper mapper = new ObjectMapper();

	try {
	    // Read JSON data
	    JsonNode jsonNode = mapper.readTree(new File(jsonFile));

	    // Read schema definition
	    JsonNode schemaNode = mapper.readTree(new File(schemaFile));

	    JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);

	    JsonSchema schema = factory.getSchema(schemaNode);

	    // Validate JSON against schema
	    Set<ValidationMessage> errors = schema.validate(jsonNode);

	    if (errors.isEmpty()) {
		System.out.println("Email field is valid according to schema.");
	    } else {
		System.out.println("Validation errors:");

		for (ValidationMessage msg : errors) {
		    System.out.println(msg.getMessage());
		}
	    }

	} catch (IOException e) {
	    System.out.println("Error reading JSON or schema file.");
	}
    }
}
