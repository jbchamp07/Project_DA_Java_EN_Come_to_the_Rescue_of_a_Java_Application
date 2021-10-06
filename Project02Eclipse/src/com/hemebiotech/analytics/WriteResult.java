package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class WriteResult implements IWriteResult{

    @Override
    public void writeData (Map<String, Integer> map){
        FileWriter writer = null;
        try {
            writer = new FileWriter("result.out");
            String liste = map.toString();
            liste = liste.replaceAll(", ","\n");
            writer.write(liste);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*try {
            for(int i = 0; i < map.size(); i++){
                writer.write(map. + " : " + map.get(i).getValue() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}
