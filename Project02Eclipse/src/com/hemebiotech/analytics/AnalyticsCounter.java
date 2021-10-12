package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;

public class AnalyticsCounter {
	/*private static BufferedReader reader;
	private static FileReader freader;*/
	private static String filepath;

	private final ISymptomReader iSymptomReader;
	private final IWriteResult iWriteResult;

	public AnalyticsCounter(ISymptomReader isr, IWriteResult iwr) {
		this.iSymptomReader = isr;
		this.iWriteResult = iwr;
	}

	public List<String> getSymptomsList(){
		//ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(filepath);
		List<String> list = this.iSymptomReader.GetSymptoms();
		return list;


	}

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

	public Map<String, Integer> getInOrder(Map<String, Integer> map){
        map = new TreeMap<String, Integer>(map);
		return map;
	}

	public void writeINResult(Map<String, Integer> myMap){
		WriteResult writeResult = new WriteResult();
		writeResult.writeData(myMap);
	}

	// pour write => creer classe avec implementation avec son interface

	/*public static void ouvertureRessources(){
		try {
			freader = new FileReader(filepath);
			reader = new BufferedReader(freader);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void fermetureRessources(){
		try {
			reader.close();
			freader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeResult(List<Map.Entry<Integer, Integer>> list){
		try {
			//line = reader.readLine();	// get another symptom
			// next generate output
			FileWriter writer = new FileWriter("result.out");
			for(int i = 0; i < list.size(); i++){
				writer.write(list.get(i).getKey() + " : " + list.get(i).getValue() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Map<String, Integer> getSymptoms(Map<String, Integer> myMap){
		String line = null;
		try {
			do{
				line = reader.readLine();
				if(line != null){
					if(myMap.get(line) != null){
						int nb = myMap.get(line) + 1;
						myMap.put(line,nb);
					}else{
						myMap.put(line,1);
					}
				}

			}while(line != null);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return myMap;
	}

	public static List<Map.Entry<Integer, Integer>> getInOrder(List<Map.Entry<Integer, Integer>> list){
		list.sort(Map.Entry.comparingByValue());
		return list;
	}*/

}
