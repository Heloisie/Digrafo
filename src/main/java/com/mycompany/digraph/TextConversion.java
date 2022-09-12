package com.mycompany.digraph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

import java.util.ArrayList;

/**
 * Class to the conversion of the text in the file
 * 
 * @author Iara
 * @author Brenda
 * @version 1.0
 */

public class TextConversion {
    /** Methods */

    /** Empty Constructor */
    public TextConversion() {
    }

    /**
     * Method that read the path to the files that is going to convert and return it
     * @param path String - path to the txt file
     * @return String - pathScanned
     */
    public static ArrayList<String> readPathFile(String path) {
        ArrayList<String> pathScanned = new ArrayList<>();
        String[] list;

        list = path.split(",");
        for (int i = 0; i < list.length; i++) {
            pathScanned.add(list[i]);
        }
        return pathScanned;
    }

    /**
     * Method that format the String parameter
     * @param value String - sting to be formated
     * @return String - StringWords
     */
    public static String[] textFormat(String value) {
        value = value.toLowerCase(); /** transform all string in lower case */
        value = value.replaceAll("\\p{Punct}", ""); /** remove all punctuation */

        /** split by spaces */
        String[] StringWords = value.split("\\s");
        return StringWords;
    }

    /**
     * Method that read a file and return an ArrayList with all the formated words
     * @param pathFileS String - txt file path
     * @return String - FileWords
     */
    public static ArrayList<String> readFile(String pathFileS){
        ArrayList<String> FileWords = new ArrayList<>();
        try (BufferedReader buffRead = new BufferedReader(
                new InputStreamReader(new FileInputStream(pathFileS), "UTF-8"))) {
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
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "O programa não foi capaz de encontrar o arquivo " + pathFileS + "\nOBS. Seu arquivo CSV não foi criado!",
            "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return FileWords;
    }
}
