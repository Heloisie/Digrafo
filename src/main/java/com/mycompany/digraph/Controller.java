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
        //Calling interface
         MyFrame frame = new MyFrame();
         frame.setVisible(true);
    
    }
     
}
