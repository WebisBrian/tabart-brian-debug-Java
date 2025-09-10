package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int dialatedPupilsCount = 0;		
	
	public static void main(String args[]) throws Exception {
		// Configure the read of symptoms.txt
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;	
		
		while (line != null) {
			// Increment to get the next line
			i++;
			System.out.println("symptom from file: " + line);
			
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("-> number of headaches: " + headacheCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
				System.out.println("-> number of rash: " + rashCount);
			}
			else if (line.contains("dialated pupils")) {
				dialatedPupilsCount++;
				System.out.println("-> number of dialated pupils: " + dialatedPupilsCount);
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + dialatedPupilsCount + "\n");
		writer.close();
	}
}
