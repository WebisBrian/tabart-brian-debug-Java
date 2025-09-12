package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(new ReadSymptomDataFromFile("symptoms.txt"), new WriteSymptomDataToFile("result.out"));
		
		List<String> symptoms = analyticsCounter.getSymptoms();
		
		Map<String, Integer> unsortedSymptoms = analyticsCounter.countSymptoms(symptoms);
		
		Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(unsortedSymptoms);
		
		analyticsCounter.writeSymptoms(sortedSymptoms);
	}

}
