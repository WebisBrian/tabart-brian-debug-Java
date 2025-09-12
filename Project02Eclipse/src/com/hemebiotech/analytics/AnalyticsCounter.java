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
	
	private ISymptomReader reader;
	private ISymptomWriter writer;
	
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
		return reader.GetSymptoms();
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
		HashMap<String, Integer> countSymptoms = new HashMap<String, Integer>();
		
		for (String symptom : symptoms) {
			if (!countSymptoms.containsKey(symptom)) {
				countSymptoms.put(symptom, 1);
			} else {
				int oldValue = countSymptoms.get(symptom);
				int newValue = ++oldValue;
				countSymptoms.replace(symptom, newValue);
			}
		}
		return countSymptoms;
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
