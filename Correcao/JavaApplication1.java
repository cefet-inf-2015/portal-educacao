/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.File;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 *
 * @author Aluno
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File inputFile = new File
        ("C:\\Users\\Aluno\\Documents\\NetBeansProjects\\JavaApplication1\\test\\input.xml");
        String respostaDada = JOptionPane.showInputDialog(null, "Insira sua alternativa:").toLowerCase();
        lerXML(inputFile, respostaDada);
    }

    /**
     * Lê um arquivo XML contendo uma questão, e compara a resposta dada com a
     * resposta correta.
     *
     * @param file arquivo XML
     * @param respostaDada resposta dada pelo aluno
     */
    public static void lerXML(File file, String respostaDada) {
        try {
            File inputFile = file;
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            /*System.out.println("Root element :" 
            + doc.getDocumentElement().getNodeName());*/
            NodeList nList = doc.getElementsByTagName("questao");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                //System.out.println("\nCurrent Element :" 
                //   + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    /*for (int i=0; i<eElement.getElementsByTagName("alt").getLength(); i++){
                  System.out.println("Alternativa : " 
                  + eElement
                  .getElementsByTagName("alt")
                  .item(i)
                  .getTextContent()); 
               }
                     */
                    String altCorretaCompleta = "";
                    for (int i = 0; i < eElement.getElementsByTagName("alt").getLength(); i++) {
                        if ("true".equals(eElement.getElementsByTagName("alt").item(i).getAttributes().item(0).getTextContent())) {
                            altCorretaCompleta = eElement.getElementsByTagName("alt").item(i).getTextContent();
                        }
                    }
                    String altCorreta = altCorretaCompleta.substring(0, 2).toLowerCase();
                    System.out.println(altCorreta);
                    String x = respostaDada;
                    if (x.equals(altCorreta)) {
                        JOptionPane.showMessageDialog(null, "Resposta correta!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Respota errada");
                    }
                    /* eElement
               .getElementsByTagName("alt")
               .item(i).getAttributes().item(0);
                     */
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
