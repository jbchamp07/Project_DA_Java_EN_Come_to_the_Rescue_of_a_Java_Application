package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	private static BufferedReader reader;
	private static FileReader freader;
	
	public static void main(String args[]){
		//BufferedReader reader = null;
		try {
			freader = new FileReader("D:\\ide\\projet formation\\Project02Eclipse\\symptoms.txt");
			reader = new BufferedReader(freader);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		String line = null;



		Map<String, Integer> myMap = new HashMap<String, Integer>();
			try {
				do{
					line = reader.readLine();
					if(myMap.get(line) != null){
						int nb = myMap.get(line) + 1;
						myMap.put(line,nb);
					}else{
						myMap.put(line,1);
					}
				}while(line != null);
			} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}

		List<Map.Entry<Integer, Integer>> list = new ArrayList(myMap.entrySet());
		list.sort(Map.Entry.comparingByValue());
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
            //line = reader.readLine();	// get another symptom
            reader.close();
			freader.close();
            // next generate output
            FileWriter writer = null;
			writer = new FileWriter("result.out");
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dialated pupils: " + pupilCount + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
