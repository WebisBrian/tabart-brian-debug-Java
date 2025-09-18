package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
        try {
            AnalyticsCounter analyticsCounter = new AnalyticsCounter(
                    new ReadSymptomDataFromFile("symptoms.txt"),
                    new WriteSymptomDataToFile("result.out")
            );

            List<String> symptoms = analyticsCounter.getSymptoms();
            Map<String, Integer> unsorted = analyticsCounter.countSymptoms(symptoms);
            Map<String, Integer> sorted = analyticsCounter.sortSymptoms(unsorted);
            analyticsCounter.writeSymptoms(sorted);

            System.exit(0);
        } catch (Exception e) {
            System.err.println("[ERROR] " + e.getMessage());
            System.exit(1);
        }
    }
}
