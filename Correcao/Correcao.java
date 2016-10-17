package correcao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Correcao {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFileChooser seletor = new JFileChooser();
        String respostasConcatenadas = null;
        String respostas[] = null;
        FileNameExtensionFilter filtroXML = 
                new FileNameExtensionFilter("Extensible Markup Language", "xml");
        seletor.setFileFilter(filtroXML);
        seletor.showOpenDialog(seletor);
        File arquivoProva = 
        seletor.getSelectedFile();
        FileNameExtensionFilter filtroTXT = 
                new FileNameExtensionFilter("Arquivo de texto", "txt");
        seletor.setFileFilter(filtroTXT);
        seletor.showOpenDialog(seletor);
        File arquivoGabarito = seletor.getSelectedFile();
        try {
            respostasConcatenadas = readFile(arquivoGabarito);
            respostas = respostasConcatenadas.split("\n");
            for (int i=0; i<respostas.length; i++) {
                respostas[i]=respostas[i].substring(3);
            }
        } catch (IOException ex) {
            Logger.getLogger(Correcao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(corrigirProva(arquivoProva, respostas));
    }

    public static String readFile(File gabarito) throws IOException {
        String content = null;
        File file = gabarito;
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return content;
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
                            /*System.out.println(x[temp]);
                            System.out.println(altCorretaCompleta);
                            System.out.println("debug");*/
                            //bug na comparação
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