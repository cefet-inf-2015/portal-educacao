package correcao;

import java.io.File;
import javax.swing.JFileChooser;
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
public class Correcao {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFileChooser seletor = new JFileChooser();
        seletor.showOpenDialog(seletor);
        File inputFile = 
        seletor.getSelectedFile();
        System.out.println(seletor.getSelectedFile().getName());
    }

    /**
     * Lê um arquivo XML contendo uma única questão, e compara a resposta dada com a
     * resposta correta.
     *
     * @param file arquivo XML da questão
     * @param respostaDada resposta dada pelo aluno
     * @return Se a resposta dada for certa, retorna "true", caso contrário,
     * retorna "false"
     */
    public static boolean corrigirQuestao(File file, String respostaDada) {
        boolean correta=false;
        try {
            File inputFile = file;
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("questao");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String altCorretaCompleta = "";
                    String x = respostaDada;
                    for (int i = 0; i < eElement.getElementsByTagName("alternativa").getLength(); i++) {
                        if ("true".equals(eElement.getElementsByTagName("alternativa").item(i).getAttributes().item(0).getTextContent())) {
                            altCorretaCompleta = eElement.getElementsByTagName("alternativa").item(i).getTextContent();
                            if (x.equals(altCorretaCompleta)){
                                correta = true;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return correta;
    }
    
    
    /**
     * Lê um arquivo XML contendo uma prova com uma ou mais questões múltipla 
     * escolha, e compara a resposta dada com a
     * resposta correta.
     *
     * @param file arquivo XML da prova
     * @param respostaDada respostas dadas pelo aluno
     * @return número de questões acertadas
     */
    public static int corrigirProva(File file, String[] respostaDada){
        int respostasCorretas = 0;
        try {
            File inputFile = file;
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("questao");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String altCorretaCompleta = "";
                    String x[] = respostaDada;
                    for (int i = 0; i < eElement.getElementsByTagName("alternativa").getLength(); i++) {
                        if ("true".equals(eElement.getElementsByTagName("alternativa").item(i).getAttributes().item(0).getTextContent())) {
                            altCorretaCompleta = eElement.getElementsByTagName("alternativa").item(i).getTextContent();
                            if (x[temp].equals(altCorretaCompleta)){
                                respostasCorretas++;
                            }
                        }
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return respostasCorretas;
    }
    
    /**
     * Lê um arquivo XML contendo uma prova com uma ou mais questões múltipla 
     * escolha, e conta o número de questões que a mesma possui.
     * resposta correta.
     *
     * @param file arquivo XML da prova
     * @return número de questões da prova
     */
    public static int getNumeroDeQuestoes(File file){
        int numeroDeQuestoes=0;
        try {
            File inputFile = file;
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("questao");
            numeroDeQuestoes = nList.getLength();
        } catch (Exception e){
            e.printStackTrace();
        }
        return numeroDeQuestoes;
    }
}