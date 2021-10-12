package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.Map;

public class Principale {
    public static void main(String[] args){
        ISymptomReader isr = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
        IWriteResult iwr = new WriteResult();
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(isr,iwr);
        Map<String, Integer> myMap = analyticsCounter.calculSymptoms(analyticsCounter.getSymptomsList());
        System.out.println(myMap);
        myMap = analyticsCounter.getInOrder(myMap);
        analyticsCounter.writeINResult(myMap);
        /*AnalyticsCounter analyticsCounter = new AnalyticsCounter();
        Map<String, Integer> myMap = analyticsCounter.calculSymptoms(analyticsCounter.getSymptomsList());
        System.out.println(myMap);
        myMap = analyticsCounter.getInOrder(myMap);
        System.out.println(myMap);
        analyticsCounter.writeINResult(myMap);*/
    }
}
