/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodequestoes;
 
import java.io.IOException;

import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import projeto.FormInicial;

/**
 *
 * @author Thales
 */
public class BancoDeQuestoes {
    
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws org.xml.sax.SAXException
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws java.io.IOException

     */
    public static void main(String[] args) throws SQLException, SAXException, ParserConfigurationException, IOException {
        FormInicial inicio = new FormInicial();
        
        inicio.setVisible(true);
        
       
    }
    
    
}
