package com.jsondata.studentjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;

public class CreateStudentJson {
    public static void main(String[] args) {
	try {
	    ObjectMapper mapper = new ObjectMapper();

	    Student student = new Student("Rahul", 21, Arrays.asList("Java", "DBMS", "OS"));

	    // convert object to JSON string
	    String json = mapper.writeValueAsString(student);

	    System.out.println("Generated JSON:");
	    System.out.println(json);

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
