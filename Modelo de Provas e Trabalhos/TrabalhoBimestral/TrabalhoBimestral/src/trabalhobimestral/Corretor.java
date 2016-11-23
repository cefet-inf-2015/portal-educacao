/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhobimestral;

/**
 *
 * @author Aluno
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Aluno
 */
public class Corretor {
    public static double corrigirProva(Document doc, ArrayList<Object> respostasDadas) {
        double notaObtida = 0;
        ArrayList<Object> respostas = respostasDadas;
        ArrayList<Object> respostasCorretas = new ArrayList<>();
        try {
            doc.getDocumentElement().normalize();
            int valorDaProva = Integer.parseInt(doc.getElementsByTagName("valor").item(0).getTextContent());
            NodeList questao = doc.getElementsByTagName("questao");
            int[] dificuldadeQuestao = new int[questao.getLength()];
            int[] diffVFME = new int[questao.getLength()];
            ArrayList<Double> valorQuestao = new ArrayList<>();
            for (int i = 0; i < questao.getLength(); i++) {
                Node nNode = questao.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    dificuldadeQuestao[i] = Integer.parseInt(eElement.getElementsByTagName("dificuldade").item(0).getTextContent());
                }
            }
            int totalDificuldades = 0;
            for (int i = 0; i < dificuldadeQuestao.length; i++) {
                totalDificuldades += dificuldadeQuestao[i];
            }
            double notaBase = (double) valorDaProva / (double) totalDificuldades;
            for (int i = 0; i < questao.getLength(); i++) {
                Node nNode = questao.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (eElement.getAttribute("tipo").equals("ME") || eElement.getAttribute("tipo").equals("VF")) {
                        diffVFME[i] = Integer.parseInt(eElement.getElementsByTagName("dificuldade").item(0).getTextContent());
                        valorQuestao.add(notaBase * diffVFME[i]);
                    }
                    if (eElement.getAttribute("tipo").equals("ME")) {
                        for (int j = 0; j < eElement.getElementsByTagName("alternativa").getLength(); j++) {
                            if ("true".equals(eElement.getElementsByTagName("alternativa").item(j).getAttributes().item(0).getTextContent())) {
                                switch (j) {
                                    case 0:
                                        respostasCorretas.add("a");
                                        break;
                                    case 1:
                                        respostasCorretas.add("b");
                                        break;
                                    case 2:
                                        respostasCorretas.add("c");
                                        break;
                                    case 3:
                                        respostasCorretas.add("d");
                                        break;
                                    case 4:
                                        respostasCorretas.add("e");
                                        break;
                                }
                            }
                        }
                    } else if (eElement.getAttribute("tipo").equals("VF")) {
                        String[] resp = new String[eElement.getElementsByTagName("alternativa").getLength()];
                        for (int j = 0; j < eElement.getElementsByTagName("alternativa").getLength(); j++) {
                            if ("true".equals(eElement.getElementsByTagName("alternativa").item(j).getAttributes().item(0).getTextContent())) {
                                resp[j] = "v";
                            } else if ("false".equals(eElement.getElementsByTagName("alternativa").item(j).getAttributes().item(0).getTextContent())) {
                                resp[j] = "f";
                            }
                        }
                        respostasCorretas.add(resp);
                    }
                }
            }
            //compara array de corretas com array fornecido
            for (int i = 0; i < respostas.size(); i++) {
                if (respostas.get(i) instanceof String[] && respostasCorretas.get(i) instanceof String[]) {
                    Node nNode = questao.item(i);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        int VFCorretas = 0;
                        int numeroDeAlternativas = 1;
                        String[] r1 = (String[]) respostas.get(i);
                        String[] r2 = (String[]) respostasCorretas.get(i);
                        numeroDeAlternativas = eElement.getElementsByTagName("alternativa").getLength();
                        for (int j = 0; j < r1.length; j++) {
                            if (r1[j].equals(r2[j])) {
                                VFCorretas++;
                            }
                        }
                        double aumento = (double) ((double) VFCorretas * (double) valorQuestao.get(i)) / (double) numeroDeAlternativas;
                        notaObtida += aumento;
                    }
                }
                if (respostas.get(i).equals(respostasCorretas.get(i))) {
                    //acertou
                    notaObtida += (double) valorQuestao.get(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return notaObtida;
    }

    /**
     * Lê um arquivo XML contendo uma prova com uma ou mais questões múltipla
     * escolha, e conta o número de questões que a mesma possui. resposta
     * correta.
     *
     * @param file arquivo XML da prova
     * @return número de questões da prova
     */
    public int getNumeroDeQuestoes(File file) {
        int numeroDeQuestoes = 0;
        try {
            File inputFile = file;
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("questao");
            numeroDeQuestoes = nList.getLength();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numeroDeQuestoes;
    }
}
