package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;


public class AnalyticsCounter {

	ReadSymptomDataFromFile readFromFile = new ReadSymptomDataFromFile();
	/**
	 * 1 - read symptoms from a file
	 * 2 - create a list of symptoms
	 * 3- Returns a List of symptoms
	 *
	 * @param file
	 *
	 * @return list of symptoms
	 *
	 * @author AKONE
	 */
	public List<String> readFile(String file) {
		return readFromFile.GetSymptoms(file);
	}
	/**
	 * 1 - Count occurrences of symptoms in a list
	 * 2 - Count create a map of symptoms
	 * 3 - Return a Map of symptoms
	 *
	 * @param symptoms
	 *
	 * @return map of iteration of symptoms with their occurrences
	 *
	 * @author AKONE
	 */
	public Map<String, Integer> countOccurrence(List<String> symptoms){
		return readFromFile.getOccurrences(symptoms);
	}

	/**
	 * Save the result to the output file , from a map of symptoms
	 *
	 * @param mapOccurrences  :  symptoms and their occurrences
	 *
	 * @return file with number of iteration of each symptom from the map in param
	 *
	 * @author A.KONE
	 */
	public void writeResultToFile(Map<String, Integer> mapOccurrences, String resultOutFile) throws Exception {
		readFromFile.writeToFile(mapOccurrences, resultOutFile);
	}

}
