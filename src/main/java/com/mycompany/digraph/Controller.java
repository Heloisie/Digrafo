package com.mycompany.digraph;

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
     * @param path - path to the txt file
     * */
    public static void createProgram(String path){
        ArrayList<String> pathScanned = TextConversion.readPathFile(path);
        
        for (int i = 0; i < pathScanned.size(); i++) {
            ArrayList<String> FileContent = TextConversion.readFile(pathScanned.get(i));
            
            if(!FileContent.isEmpty()){
                //create a path for the new file with the same name
                String pathCSV = pathScanned.get(i).replace(".txt", ".csv");
                TreeMap<String, String> text = FileTransform.createTreeMap(FileContent);
                FileTransform.createCSVFile(text, pathCSV);
            }
        }
    }

    /**Method that creates the frame*/
    public static void createView(){
        MyFrame frame= new MyFrame();
        frame.setVisible(true);
    }
     
}
