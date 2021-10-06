package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.Map;

public class Principale {
    public static void main(String args[]){
        AnalyticsCounter analyticsCounter = new AnalyticsCounter();
        Map<String, Integer> myMap = analyticsCounter.calculSymptoms(analyticsCounter.getSymptomsList());
        System.out.println(myMap);
        myMap = analyticsCounter.getInOrder(myMap);
        System.out.println(myMap);
        WriteResult writeResult = new WriteResult();
        writeResult.writeData(myMap);
    }
}
