package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	// Initialize each symptom
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int pupilCount = 0;		
	
	public static void main(String args[]) throws Exception {
		// Read the file "symptoms.txt
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

			
		// Calculate the sum of each symptom using a loop.
		int i = 0;
		while (line != null) {
		    i++;
		    switch (line) {
		        case "headache":
		            headacheCount++;
		            break;
		        case "rash":
		            rashCount++;
		            break;
		        case "dialated pupils":
		            pupilCount++;
		            break;
		        default:
		            break;
		    }
		    // Get another symptom
		    line = reader.readLine();
		}
		
		System.out.println("Symptoms inventory :\n");
		System.out.println("Headache : " + headacheCount);
		System.out.println("Rash : " + rashCount);
		System.out.println("Dialated pupils : " + pupilCount);
		
		// Generate a file summarizing the number of occurrences for each symptom.
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
