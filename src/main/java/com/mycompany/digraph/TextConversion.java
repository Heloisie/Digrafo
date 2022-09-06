package com.mycompany.digraph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;

/**Class to the conversion of the text in the file
* @author Iara
* @version 1.0
*/

public class TextConversion {
    /**Atributes*/
    private String pathFile;

    /**Methods*/
    
    /**Get Method
    * @return String - pathFile*/
    public String getPathFile() {
        return pathFile;
    }

    /**Set Method
    * @param pathFile String - path of the choosen file*/
    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }
    
    /**Constructor
    * @param pathFile String - path of the choosen file*/
    public TextConversion(String pathFile) {
        this.pathFile = pathFile;
    }
    
    /**Empty Constructor*/
    public TextConversion() {
    }
    
    /**Method that read the path to the file that is going to convert and return it
    * @return String - pathScanned*/
    public String readPathFile() {
        System.out.println("Digite o caminho: ");
        /**Using Scanner for Getting Input from User*/
        Scanner in = new Scanner(System.in);
 
        String pathScanned = in.nextLine();
        return pathScanned;
    }
    
    /**Method that format the String parameter
    * @param value String - sting to be formated
    * @return String - StringWords*/
    public String[] textFormat(String value) {
        value = value.toLowerCase(); /**transform all string in lower case*/
        value = value.replaceAll("\\p{Punct}", ""); /**remove all punctuation*/
        
        /**remove all accent*/
        value = Normalizer.normalize(value, Normalizer.Form.NFD); 
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        value = pattern.matcher(value).replaceAll("");
        String[] StringWords = value.split("\\s");
        return StringWords;
    }
    
    /**Method that read a file and return an ArrayList with all the formated words
    * @return String - FileWords
    * @throws java.io.IOException*/
    public ArrayList<String> readFile() throws IOException {
        ArrayList<String> FileWords = new ArrayList<>();
        try (BufferedReader buffRead = new BufferedReader(new FileReader(this.pathFile))) {
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
