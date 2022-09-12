package com.mycompany.digraph;

import java.io.IOException;

/**
 * Initialization Class
 * @author Iara
 * @author Heloisie
 */
public class InitProgram {
    
    /**Default Constructor*/
    public InitProgram() {
    }
    
    /** Method main
     * @param args - main param
     * @throws java.io.IOException - Exception control*/
    public static void main(String[] args) throws IOException {
        Controller.createView();
    }
}
