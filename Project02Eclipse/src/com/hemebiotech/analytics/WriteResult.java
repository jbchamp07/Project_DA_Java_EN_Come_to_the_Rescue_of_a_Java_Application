package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * The type Write result.
 */
public class WriteResult implements IWriteResult{

    @Override
    public void writeData (Map<String, Integer> map){
        FileWriter writer = null;
        try {
            writer = new FileWriter("result.out");
            String liste = map.toString();
            liste = liste.replaceAll(", ","\n");
            liste = liste.replace("{","");
            liste = liste.replace("}","");
            writer.write(liste);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
