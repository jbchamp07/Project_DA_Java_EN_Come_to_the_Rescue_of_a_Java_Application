package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Principale.
 */
public class Principale {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        ISymptomReader isr = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
        IWriteResult iwr = new WriteResult();
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(isr,iwr);
        Map<String, Integer> myMap = analyticsCounter.calculSymptoms(analyticsCounter.getSymptomsList());
        System.out.println(myMap);
        myMap = analyticsCounter.getInOrder(myMap);
        analyticsCounter.writeResult(myMap);
    }
}
