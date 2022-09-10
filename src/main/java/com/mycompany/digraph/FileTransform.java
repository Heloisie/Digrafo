/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digraph;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**Class to create the CSV file using a Tree Map
 * @author Brenda
 * @author Yuri
 * @version 1.0
 */
public class FileTransform {
    /**Methods*/
    /**Sorts the value (String) of an element in a Tree Map.
     * @param treeMap Tree Map to be sorted.
     * @param key Key of the value to be sorted.
     */
    public static void sortTreeMapValues(TreeMap<String, String> treeMap, String key){
        String[] sortedValue = treeMap.get(key).split(",");
        Arrays.sort(sortedValue);
        treeMap.replace(key, Arrays.toString(sortedValue)
                .replace("[", "")
                .replace("]", ""));
    }
    
    /**Creates a Tree Map from a Array List of Strings.
     * Each element of the Array List is set as a key and points to the next node.
     * A key contain one or more unique elements.
     * @param fileWords The Array List to be used.
     * @return TreeMap - digraphs
     */
    public static TreeMap<String, String> createTreeMap(ArrayList<String> fileWords) {
        
        if (fileWords.size() == 1) {
            return null;
        } else {
            TreeMap<String, String> digraphs = new TreeMap<>();

            for (int i = 0; i < fileWords.size() - 1; i++) {
                // If there is no key with this word yet
                if (!digraphs.containsKey(fileWords.get(i))) {
                    digraphs.put(fileWords.get(i), fileWords.get(i + 1));                
                } else {                    
                    /* A word is added to a node only if it is not already
                    linked to that particular node */
                    if (!digraphs.get(fileWords.get(i)).contains(fileWords.get(i+1))){
                        digraphs.replace(fileWords.get(i), digraphs.get(
                                fileWords.get(i)) + "," + fileWords.get(i + 1));
                        
                        sortTreeMapValues(digraphs, fileWords.get(i));
                    }
                }
            }
            
            System.out.println(digraphs);
            return digraphs;
        }
    }
    /**Creates the CSV file and writes on it
     * @param fileWords The Array List to be used.
     * @param pathCSVfile the path to the file the would be writed
     * @return void
     */
    public static void createCSVFile(TreeMap<String, String> text, String pathCSVfile){
        try {
            FileWriter writer = new FileWriter(pathCSVfile);
            for(Map.Entry<String, String> entry : text.entrySet()) {
                writer.write(entry.getKey() + ", " + entry.getValue() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error occured in CSV File creation");
            e.printStackTrace();
        }
    }
}
