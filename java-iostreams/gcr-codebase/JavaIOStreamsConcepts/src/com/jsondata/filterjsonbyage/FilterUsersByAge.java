package com.jsondata.filterjsonbyage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FilterUsersByAge {
    public static void main(String[] args) {
	// sample file path
	String filePath = "samplefiles/filterjsonbyage/users.json";
	ObjectMapper mapper = new ObjectMapper();

	try {
	    // Read JSON array into list of users
	    List<User> users = mapper.readValue(new File(filePath), new TypeReference<List<User>>() {
	    });

	    // Print users with age > 25
	    System.out.println("Users older than 25:");

	    for (User user : users) {
		if (user.getAge() > 25) {
		    System.out.println("ID: " + user.getId() + ", Name: " + user.getName() + ", Age: " + user.getAge());
		}
	    }

	} catch (IOException e) {
	    System.out.println("Error reading JSON file.");
	    System.out.println(e.getMessage());
	}
    }
}
