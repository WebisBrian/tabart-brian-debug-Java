package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * A concrete implementation of {@link ISymptomWriter} that writes symptom data
 * into a text file.
 * <p>
 * Each entry in the map will be written on a separate line, following the format:
 * <pre>
 * symptom:occurrence
 * </pre>
 * For example:
 * <pre>
 * headache:3
 * rash:2
 * fever:1
 * </pre>
 * </p>
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

	private String filepath;
	
    /**
     * Constructs a new writer for symptom data.
     *
     * @param filepath the path to the file where data will be written;
     *                 if the file already exists, it will be overwritten.
     */
	public WriteSymptomDataToFile (String filepath) {
		this.filepath = filepath;
	}
	
    /**
     * Writes all symptoms and their occurrences into the output file.
     * <p>
     * Each symptom from the map will be written on a new line, in the format
     * {@code symptom:occurrence}.
     * </p>
     *
     * @param symptoms a map where:
     *                 <ul>
     *                   <li>the key is the symptom name as a {@code String}</li>
     *                   <li>the value is the number of times this symptom occurred as an {@code Integer}</li>
     *                 </ul>
     *                 If the map is empty, the output file will also be empty.
     */
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
			for (String symptom : symptoms.keySet()) {
				writer.write(symptom + ":" + symptoms.get(symptom) + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
