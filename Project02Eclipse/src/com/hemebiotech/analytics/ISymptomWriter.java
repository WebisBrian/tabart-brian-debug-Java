package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptom data to a destination.
 * <p>
 * The important part is the input value: a {@code Map<String, Integer>} that
 * associates each symptom with the number of occurrences. The implementation
 * of this interface defines where and how the data will be written 
 * (e.g. in a file, database, console, etc.).
 * </p>
 */
public interface ISymptomWriter {
	
    /**
     * Writes all symptoms and their occurrences to a chosen destination.
     * <p>
     * Each entry of the map corresponds to:
     * <ul>
     *   <li>the key: the symptom name as a {@code String}</li>
     *   <li>the value: the number of times this symptom occurred as an {@code Integer}</li>
     * </ul>
     * </p>
     *
     * @param symptoms a {@code Map<String, Integer>} where the key is a symptom name
     *                 and the value is its number of occurrences; cannot be {@code null}.
     */
	public void writeSymptoms(Map<String, Integer> symptoms);

}
