package com.mycompany.digraph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;

/**Class to the conversion of the text in the file
* @author Iara
* @author Brenda
* @version 1.0
*/

public class TextConversion {
    /**Methods*/
    
    /**Empty Constructor*/
    public TextConversion() {}
    
    /**Method that read the path to the file that is going to convert and return it
    * @return String - pathScanned
    */
    public static ArrayList<String> readPathFile() {
        System.out.println("Enter the files separated by ',': ");
        /**Using Scanner for Getting Input from User*/
        Scanner in = new Scanner(System.in);
        ArrayList<String> pathScanned = new ArrayList<>();
        String[] list;
        
        String text = in.next();
        list = text.split(",");      
        for (int i = 0; i < list.length; i++) {
			pathScanned.add(list[i]);
		}
        return pathScanned;
    }
    
    /**Method that format the String parameter
    * @param value String - sting to be formated
    * @return String - StringWords
    */
    public static String[] textFormat(String value) {
        value = value.toLowerCase(); /**transform all string in lower case*/
        value = value.replaceAll("\\p{Punct}", ""); /**remove all punctuation*/
        
        /**split by spaces*/
        String[] StringWords = value.split("\\s");
        return StringWords;
    }
    
    /**Method that read a file and return an ArrayList with all the formated words
    * @return String - FileWords
    * @throws java.io.IOException
    */
    public static ArrayList<String> readFile(String pathFileS) throws IOException {
        ArrayList<String> FileWords = new ArrayList<>();
        try (BufferedReader buffRead = new BufferedReader(new InputStreamReader(new FileInputStream(pathFileS), "UTF-8"))) {
            String linha = "";
            while (true) {
                if (linha != null) {
                    String formatedLine[] = textFormat(linha);
                    for (String formatedLine1 : formatedLine) {
                        if (!formatedLine1.equals("")) {
                            FileWords.add(formatedLine1);
                        }
                    }
                } else
                    break;
                linha = buffRead.readLine();
            }
            System.out.println(FileWords);
        }
        return FileWords;
    }
}
