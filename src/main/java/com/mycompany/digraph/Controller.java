package com.mycompany.digraph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

/**Controller Class
* @author Iara
* @author Brenda
* @version 1.0
*/
public class Controller {
    
    /**Methods*/
    
    /**Empty Constructor*/
    public Controller() {}
    
    /**Method that calls TextConversion object and its method
     * @throws java.io.IOException
     * */
    public static void createTextConversion(String path){
        ArrayList<String> pathScanned = TextConversion.readPathFile(path);
        
        for (int i = 0; i < pathScanned.size(); i++) {
            //create a path for the new file with the same name
            String pathCSV = pathScanned.get(i).replace(".txt", ".csv");
            
            TreeMap<String, String> text = FileTransform.createTreeMap(
                TextConversion.readFile(pathScanned.get(i)));
            FileTransform.createCSVFile(text, pathCSV);
        }
    }

    public static void createView(){
        MyFrame frame= new MyFrame();
        frame.setVisible(true);
    }
     
}
