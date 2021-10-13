package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;

/**
 * The type Analytics counter.
 */
public class AnalyticsCounter {
	/*private static BufferedReader reader;
	private static FileReader freader;*/
	private static String filepath;

	private final ISymptomReader iSymptomReader;
	private final IWriteResult iWriteResult;

	/**
	 * Instantiates a new Analytics counter.
	 *
	 * @param isr the isr
	 * @param iwr the iwr
	 */
	public AnalyticsCounter(ISymptomReader isr, IWriteResult iwr) {
		this.iSymptomReader = isr;
		this.iWriteResult = iwr;
	}

	/**
	 * Get symptoms list list.
	 *
	 * @return the list
	 */
	public List<String> getSymptomsList(){
		List<String> list = this.iSymptomReader.GetSymptoms();
		return list;


	}

	/**
	 * Calcul symptoms map.
	 *
	 * @param liste the liste
	 * @return the map
	 */
	public Map<String, Integer> calculSymptoms(List<String> liste){
		Map<String, Integer> myMap = new HashMap<String, Integer>();
		for(String l : liste){
			if(myMap.get(l) != null){
				int nb = myMap.get(l) + 1;
				myMap.put(l,nb);
			}else{
				myMap.put(l,1);
			}
		}
		return myMap;
	}

	/**
	 * Get in order map.
	 *
	 * @param map the map
	 * @return the map
	 */
	public Map<String, Integer> getInOrder(Map<String, Integer> map){
        map = new TreeMap<String, Integer>(map);
		return map;
	}

	/**
	 * Write result.
	 *
	 * @param myMap the my map
	 */
	public void writeResult(Map<String, Integer> myMap){
		this.iWriteResult.writeData(myMap);
	}

}
