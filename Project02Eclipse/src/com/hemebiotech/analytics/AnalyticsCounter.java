package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;

public class AnalyticsCounter {
	private static BufferedReader reader;
	private static FileReader freader;
	private final static String filepath = "D:\\ide\\projet formation\\Project02Eclipse\\symptoms.txt";

	public static void main(String args[]){
		//BufferedReader reader = null;
		try {
			freader = new FileReader(filepath);
			reader = new BufferedReader(freader);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}



		Map<String, Integer> myMap = new HashMap<String, Integer>();
		myMap = getSymptoms(myMap);

		List<Map.Entry<Integer, Integer>> list = new ArrayList(myMap.entrySet());
		list = getInOrder(list);
		list.forEach(System.out::println);




		/*ArrayList<Tableau> array = new ArrayList<>();
		line = reader.readLine();
		array.add(0,new Tableau(line,1));
		for(int i = 0; line != null; i++){
			line = reader.readLine();
			if(array.contains(new Tableau(line))){
				array.set(array.indexOf(new Tableau(line)),new Tableau(line,2));
			}else{
				array.add(new Tableau(line,1));
			}
		}
		System.out.println(array.get(0).name + " : " + (array.get(0).nb));
		System.out.println(array.get(1).name + " : " + (array.get(1).nb));*/
		try {
			reader.close();
			freader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		writeResult(list);

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
	}

}
