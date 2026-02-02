package com.jsondata.iplsanitizer;

public class IplCensorApp {

    public static void main(String[] args) {
	// checks JSON file
        IplJsonProcessor.process();

        // checks CSV file
        IplCsvProcessor.process();
    }
}
