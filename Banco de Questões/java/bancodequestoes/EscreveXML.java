/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodequestoes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;



/**
 *Escreve o XML na pastaa
 * @author Thales
 */
public class EscreveXML {
    File path = new File("Temp");
    String XML;
    
    /**
     * recebe o XML e escreve ele num Arquivo.
     * @param XML
     * @throws FileNotFoundException 
     */
    public EscreveXML(String XML) throws FileNotFoundException {
        this.XML = XML;
        path.mkdir();
        try(  PrintWriter out = new PrintWriter( path.getAbsolutePath() + "XMLq.xml" )  ){
    out.println( XML );
}
    }
    
    
    
    
    
}
