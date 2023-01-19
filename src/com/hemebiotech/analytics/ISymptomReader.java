package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	/**
	 * add symptoms in a list from a file
	 *
	 * @param fileName
	 *
	 * @return  a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 *
	 * @author AKONE
	 */
	List<String> GetSymptoms(String fileName);

	/**
	 * Count occurrences of symptoms from a list of symptoms
	 *
	 * @param symptoms
	 *
	 * @return map of iteration of symptoms with their number of symptoms
	 *
	 * @author AKONE
	 */
	public Map<String, Integer> getOccurrences(List<String> symptoms);

	/**
	 * write result to the output file,  from a map of symptoms
	 *
	 * @param mapSymptomsOccurrences and resultOutFile
	 *
	 * @return file with number of iteration of each symptom from the map in param
	 *
	 * @author AKONE
	 */
	void writeToFile(Map<String, Integer> mapSymptomsOccurrences, String resultOutFile) throws IOException;



	;
}
