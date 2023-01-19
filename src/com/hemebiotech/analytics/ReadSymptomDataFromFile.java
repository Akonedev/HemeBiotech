package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class That Implements then Interface ISymptomReader
 *@author AKONE
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	/**
	 * add symptoms in a list from a file
	 *
	 * @param fileName
	 *
	 * @return list of symptoms
	 *
	 * @author AKONE
	 */
	
	@Override
	public List<String> GetSymptoms(String fileName) {
		ArrayList<String> result = new ArrayList<String>();
		
		if (fileName != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(fileName));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	/**
	 * Count occurrences of symptoms from a list of symptoms
	 *
	 * @param symptoms
	 *
	 * @return map of iteration of symptoms with their number of symptoms
	 *
	 * @author AKONE
	 */
	@Override
	public Map<String, Integer> getOccurrences(List<String> symptoms) {

		Map<String, Integer> map = new TreeMap<>();

		if (symptoms != null && !symptoms.isEmpty()) {
			Collections.sort(symptoms);

			for (String symptom : symptoms) {
				map.put(symptom, map.containsKey(symptom) ? map.get(symptom) + 1 : 1);
			}

		}
		return map;

	}

	/**
	 * write result to the output file,  from a map of symptoms
	 *
	 * @param mapSymptomsOccurrences and resultOutFile
	 *
	 * @return file with number of iteration of each symptom from the map in param
	 *
	 * @author AKONE
	 */
	@Override
	public void writeToFile(Map<String, Integer> mapSymptomsOccurrences, String resultOutFile) throws IOException {

		FileWriter writer = new FileWriter(resultOutFile);
		if (mapSymptomsOccurrences != null && !mapSymptomsOccurrences.isEmpty()) {
			mapSymptomsOccurrences.forEach((k, v) -> {
				try {
					writer.write(k + "=" + v);
					writer.write(System.getProperty("line.separator"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

			writer.close();

		} else {
			writer.write("aucun symptome n'a été trouvé");
			writer.close();
		}
		System.out.println("le fichier de sortie se trouve: " + resultOutFile);
	}


}
