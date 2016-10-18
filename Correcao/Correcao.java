package correcao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        JFileChooser seletor = new JFileChooser();
        String respostasConcatenadas=null;
        FileNameExtensionFilter filtroXML = 
                new FileNameExtensionFilter("Extensible Markup Language", "xml");
        seletor.setFileFilter(filtroXML);
        JOptionPane.showMessageDialog(null, "Insira o arquivo da PROVA XML");
        seletor.showOpenDialog(seletor);
        File arquivoProva = 
        seletor.getSelectedFile();
        if (validarExtensão(arquivoProva.getName(), "xml")==false){
           throw new Exception("Erro na extensão do arquivo");
        }
        FileNameExtensionFilter filtroTXT = 
                new FileNameExtensionFilter("Arquivo de texto", "txt");
        seletor.setFileFilter(filtroTXT);
        JOptionPane.showMessageDialog(null, "Insira o arquivo do GABARITO TXT");
        seletor.showOpenDialog(seletor);
        File arquivoGabarito = seletor.getSelectedFile();
        if (validarExtensão(arquivoGabarito.getName(), "txt")==false){
           throw new Exception("Erro na extensão do arquivo");
        }
        try {
            respostasConcatenadas = readFile(arquivoGabarito);
        } catch (IOException ex) {
            Logger.getLogger(Correcao.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Questões acertadas: "+
            corrigirProva(arquivoProva, formatarRespostas(respostasConcatenadas)));
    }
    /**
    * Recebe uma string lida de um arquivo TXT de gabarito e a formata 
    * alocando-a em um vetor de strings.
    * @param respostasConcatenadas string lida do arquivo TXT
    * @return vetor de string das respostas
    */
    public static String[] formatarRespostas (String respostasConcatenadas) {
        String respostas[]=null;
        respostas = respostasConcatenadas.split("\n");
        for (int i=0; i<respostas.length; i++) {
            if (i!=respostas.length-1){
               respostas[i]=respostas[i].substring(3, respostas[i].length()-1);
               //remove caracter indesejado ocorrente em todas as linhas, em exceção da última.
            } else {
               respostas[i]=respostas[i].substring(3);
            }
        }
        return respostas;
    }
    /**
     * Compara a extensão de um arquivo com a extensão válida requerida, e 
     * retorna true caso a extensão do arquivo for válida
     * @param nomeDoArquivo nome do arquivo a ser validado
     * @param extensãoVálida extensão na qual o arquivo deve ser
     * @return true caso o arquivo seja da extensão válida, false caso contrário
     */
    public static boolean validarExtensão (String nomeDoArquivo, String extensãoVálida){
        String extArquivo = nomeDoArquivo.substring(nomeDoArquivo.lastIndexOf(".")+1, nomeDoArquivo.length());
        String extVálida = extensãoVálida;
        return extVálida.equals(extArquivo);
        
    }
    /**
     * Lê um arquivo texto de um gabarito e passa as respostas para uma única 
     * string.
     * @param gabarito Arquivo do gabarito
     * @return String com todas as respostas concatenadas.
     * @throws IOException 
     */
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