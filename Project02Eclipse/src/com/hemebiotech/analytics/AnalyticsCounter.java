package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Central class that orchestrates the analysis of symptoms.
 * <p>
 * It uses an {@link ISymptomReader} to read the raw data, 
 * processes it to count and sort symptoms, and finally 
 * delegates the writing of results to an {@link ISymptomWriter}.
 * </p>
 */
public class AnalyticsCounter {
	
	private final ISymptomReader reader;
	private final ISymptomWriter writer;
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	
    /**
     * Reads all symptoms from the configured data source.
     *
     * @return a list of symptom names, possibly containing duplicates;
     *         never {@code null}, but can be empty if no data is available.
     */
	public List<String> getSymptoms() {		
		return reader.getSymptoms();
	}
	
    /**
     * Counts the occurrences of each symptom from a list.
     *
     * @param symptoms a list of raw symptom names; 
     *                 may contain duplicates; must not be {@code null}.
     * @return a map where:
     *         <ul>
     *           <li>the key is the symptom name as a {@code String}</li>
     *           <li>the value is the number of times it appears in the list</li>
     *         </ul>
     *         If the list is empty, the returned map will also be empty.
     */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> counts = new HashMap<String, Integer>();

		for (String s : symptoms) {
			if (s == null || s.isBlank()) continue;
            counts.put(s, counts.getOrDefault(s, 0) +1);
		}
		return counts;
	}
	
	/**
     * Sorts symptoms in alphabetical order of their names.
     *
     * @param symptoms a map of symptom names and their occurrences;
     *                 must not be {@code null}.
     * @return a {@link TreeMap} with the same entries sorted by key (symptom name).
     */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		TreeMap<String, Integer> sorted = new TreeMap<String, Integer>(symptoms);
		return sorted;
	}
	
    /**
     * Writes the given symptoms and their occurrences to the configured output.
     *
     * @param symptoms a map of symptom names and their occurrences;
     *                 must not be {@code null}. If empty, the output will also be empty.
     */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}
