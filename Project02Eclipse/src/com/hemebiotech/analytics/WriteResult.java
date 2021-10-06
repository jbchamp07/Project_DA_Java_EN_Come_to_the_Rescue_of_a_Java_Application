package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class WriteResult implements IWriteResult{

    @Override
    public void writeData (Map<String, Integer> map){
        FileWriter writer = null;
        try {
            writer = new FileWriter("result.out");
            writer.write("test");
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
