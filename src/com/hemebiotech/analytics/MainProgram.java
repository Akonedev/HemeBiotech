package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;


public class MainProgram {

    public static void main(String args[]) throws Exception {


        /**
         * 1 - Declare input and output files
         * 2 - Create new instance of analytics counter
         * 3 - Read the input file to store it into a list
         * 4 - Get occurrences From the list and store into a Map
         * 5 - rite the Result tinto the output file
         * @author AKONE
         */

        final String file = "symptoms.txt";
        final String resultOut = "result.out";

        AnalyticsCounter analyticsCounter = new AnalyticsCounter();
        List<String> symptoms = analyticsCounter.readFile(file);
        Map<String, Integer> mapSymptomsOccurences = analyticsCounter.countOccurrence(symptoms);
        analyticsCounter.writeResultToFile(mapSymptomsOccurences, resultOut);

        //For Testing : Console print out
        System.out.println("Symptoms --- Compte  " );
        for (Map.Entry<String, Integer> entry : mapSymptomsOccurences.entrySet())
            System.out.println(entry.getKey()  + " = " + entry.getValue());
    }
}


