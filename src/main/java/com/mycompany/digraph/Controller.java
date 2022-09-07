package com.mycompany.digraph;

import java.io.IOException;

/**Controller Class
* @author Iara
* @version 1.0
*/
public class Controller {
    
    /**Methods*/
    
    /**Empty Constructor*/
    public Controller() {
    }
    
    /**Method that calls TextConversion object and its method
     * @throws java.io.IOException*/
    public void createTextConversion() throws IOException{
        TextConversion textConversion1;
        textConversion1 = new TextConversion();
        String pathScanned = textConversion1.readPathFile();
        textConversion1.setPathFile(pathScanned);
        
        // **TEMPORÁRIO** ATÉ FINALIZAÇÃO DA CLASSE FileTransform
        FileTransform.createTreeMap(textConversion1.readFile());
        //textConversion1.readFile();
    }
     
}
