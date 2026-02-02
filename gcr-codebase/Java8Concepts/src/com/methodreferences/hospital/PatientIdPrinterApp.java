package com.methodreferences.hospital;

import java.util.ArrayList;
import java.util.List;

public class PatientIdPrinterApp {
    public static void main(String[] args) {
	// sample patient list (as if from hospital database)
	List<Patient> patients = new ArrayList<>();
	patients.add(new Patient("P1001", "Aarav Sharma", 34));
	patients.add(new Patient("P1002", "Priya Patel", 28));
	patients.add(new Patient("P1003", "Rahul Verma", 45));
	patients.add(new Patient("P1004", "Sneha Gupta", 19));
	patients.add(new Patient("P1005", "Vikram Singh", 62));

	System.out.println("Hospital Admin - Patient ID Verification List");
	System.out.println("Printing all Patient IDs using Method Reference:");
	System.out.println("-----------------------------------------------");

	// Using method reference: Patient::getPatientId -> String reference
	// then System.out::println to print each ID
	patients.stream()
		.map(Patient::getPatientId) // method reference to getter
		.forEach(System.out::println); // method reference to println

	System.out.println("-----------------------------------------------");
	System.out.println("Total patients verified: " + patients.size());
    }
}