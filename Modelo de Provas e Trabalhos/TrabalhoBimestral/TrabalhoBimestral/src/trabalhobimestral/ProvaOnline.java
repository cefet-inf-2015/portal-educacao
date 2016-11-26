/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhobimestral;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author GVGX_TECNOLOGIA
 */
public class ProvaOnline extends javax.swing.JFrame {

    private ArrayList enunciado;
    private ArrayList tipoQuestao;
    private ArrayList[] Questao;
    private ArrayList alternativa;
    private  ArrayList respostas;
    private ArrayList respVF;
    private JButton finalizar;
    private Final finaliza;
    private File file;
   // private JCheckBox[] selecao;
    private JRadioButton[] radioME;
    private JRadioButton[] radioV;
    private JRadioButton[] radioF;
    private Corretor c;
    private Document doc;

    /**
     * Creates new form ProvaOnline
     */
    public ProvaOnline() {
        initComponents();
        rolagem.getVerticalScrollBar().setUnitIncrement(16);
        respostas = new ArrayList();
        respVF = new ArrayList();
        enunciado = new ArrayList();
        alternativa = new ArrayList();
        Questao = null;
        tipoQuestao = new ArrayList();
        finaliza = new Final();
        finalizar = new JButton("Finalizar Prova");
        finalizar.addActionListener(finaliza);
        gerarProvaOnline();

    }

    private class Final implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int contador = 0;
            int contadorVF = 0;
            for (int i = 0; i < Questao.length; i++) {
                if (Questao[i].get(0).equals("ME")) {
                    ArrayList aux = (ArrayList) Questao[i].get(2);
                    for (int j = 0; j < aux.size(); j++) {
                        if(radioME[contador].isSelected()){
    
                            respostas.add(radioME[contador].getName());
                        }
                        contador++;
                    }
                }else{
                    if(Questao[i].get(0).equals("VF")){
                        ArrayList aux = (ArrayList) Questao[i].get(2);
                        String[] respostaVF = new String[aux.size()];
                        for (int j=0; j< aux.size(); j++){
                            if (radioV[contadorVF].isSelected()){
                                //System.out.println(radioV[contadorVF].getName());
                                respostaVF[j] = radioV[contadorVF].getName();
                            } else {
                                //System.out.println(radioF[contadorVF].getName());
                                respostaVF[j] = radioF[contadorVF].getName();
                            }
                            contadorVF++;
                        }
                        respostas.add(respostaVF);
                    }
                }
            }
        c = new Corretor();
        double notaObtida = c.corrigirProva(doc, respostas);
        JOptionPane.showMessageDialog(null, "Questões objetivas corrigidas com sucesso. Nota obtida: "+notaObtida+"\n+GABRIGOL: Implementar interface para mostrar isso ao usuário");
        }
    }

    public void areaTexto(String texto, int X, int Y, int largura) {
        if (largura == 800) {
            largura = 900;
        }
        JTextArea textArea = new JTextArea();
        int altura = 0;
        textArea.setBackground(painel.getBackground());
        painel.setPreferredSize(new Dimension(1024, 2000));
        textArea.setText(texto);
        altura = (texto.length() / 167) * 30;

        if (altura < 1) {
            altura = 15;
        }
        if (texto.length() > 167 && altura == 30) {
            altura = 30;

        }
        String[] aux = texto.split("\\n");
        if (aux.length >= 1) {
            altura += aux.length * 15;
        }
        textArea.setBounds(X, Y, largura, altura);
        textArea.setLineWrap(true);
        painel.add(textArea);

        //    painel.setPreferredSize(new Dimension(1024, 516));
    }

    public void informacoesProva(Document doc) {

        Node prova = doc.getElementsByTagName("prova").item(0);
        Node valor = prova.getChildNodes().item(1);
        valor.setTextContent("Teste");
        TransformerFactory t = TransformerFactory.newInstance();
        try {
            Transformer t2 = t.newTransformer();
        DOMSource s = new DOMSource(doc);
        StreamResult c2 = new StreamResult(new File("XML.xml"));
        t2.transform(s, c2);
        } catch (TransformerConfigurationException ex) {
            System.out.println(ex.getMessage());
        } catch (TransformerException ex) {
            System.out.println(ex.getMessage());
        }
   //     NamedNodeMap attr2 = prova.getAttributes();
       // Node node = attr2.getNamedItem("nQuestoes");
     //   NamedNodeMap attr = prova.getAttributes();
       // Node nodeAttr = attr.getNamedItem("valor");
     //   nodeAttr.setTextContent("2");
        int numeroQuestoes = 0;
        NodeList Questao = prova.getChildNodes();
        for (int i = 0; i < Questao.getLength(); i++) {

            if (Questao.item(i).getNodeName().equals("questao")) {
                numeroQuestoes++;
            }
        }
 //       node.setTextContent(String.format("%s", numeroQuestoes));

        this.Questao = new ArrayList[numeroQuestoes];
        for (int i = 0; i < numeroQuestoes; i++) {
            this.Questao[i] = new ArrayList();
        }
        String tipo = "";
        String enunciado = "";
        int nQuestao = 0;
        for (int i = 0; i < Questao.getLength(); i++) {
            if (Questao.item(i).getNodeName().equals("questao")) {
                int l = 0;
                while (Questao.item(i).getAttributes().item(l).getNodeValue().equals("true") && l < Questao.item(i).getAttributes().getLength()) {
                    l++;
                }
                if (!Questao.item(i).getAttributes().item(l).getNodeValue().equals("true")) {
                    tipo = Questao.item(i).getAttributes().item(l).getNodeValue();
                }

                for (int k = 0; k < Questao.item(i).getChildNodes().getLength(); k++) {
                    if (Questao.item(i).getChildNodes().item(k).getNodeName().equals("enunciado")) {
                        enunciado = Questao.item(i).getChildNodes().item(k).getTextContent();
                    }
                    if (Questao.item(i).getChildNodes().item(k).getNodeName().equals("alternativa")) {
                        alternativa.add(Questao.item(i).getChildNodes().item(k).getTextContent());

                    }
                }
                this.Questao[nQuestao].add(0, tipo);

                this.Questao[nQuestao].add(1, enunciado);
                if (!alternativa.isEmpty()) {
                    this.Questao[nQuestao].add(2, new ArrayList(alternativa));
                }
                enunciado = "";
                alternativa.clear();
                nQuestao++;
            }
        }
    }

    private Component alinha(JPanel panel) {
        Box b = Box.createHorizontalBox();
        b.add(panel);
        b.add(Box.createHorizontalGlue());
        // (Note that you could throw a lot more components
        // and struts and glue in here.)
        return b;
    }

    public void gerarProvaOnline() {
        try {
            String filepath = "XMLq.xml";
            file = new File(filepath);
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(filepath);

            informacoesProva(doc);

            BoxLayout layoutPainel = new BoxLayout(painel, BoxLayout.Y_AXIS);
            painel.setLayout(layoutPainel);

         //   int nCheck = 0;
            int nRadio = 0;
            int nRadio2 = 0;
            for (int i = 0; i < Questao.length; i++) {
                if (Questao[i].get(0).equals("VF")) {
                    nRadio2 += ((ArrayList) Questao[i].get(2)).size();
                }
                if (Questao[i].get(0).equals("ME")) {
                    nRadio += ((ArrayList) Questao[i].get(2)).size();
                }
            }
            radioV = new JRadioButton[nRadio2];
            radioF = new JRadioButton[nRadio2];
            radioME = new JRadioButton[nRadio];
            int constante = 0;
            int k =0;
            for (int i = 0; i < Questao.length; i++) {
                JTextArea enunciado = new JTextArea();
                enunciado.setEditable(false);
                enunciado.setBackground(painel.getBackground());
                enunciado.setLineWrap(true);
                enunciado.setText((String) Questao[i].get(1));
                JPanel p = new JPanel();
                BoxLayout layout = new BoxLayout(p, BoxLayout.Y_AXIS);
                JPanel pAux = new JPanel();
                BoxLayout layout2 = new BoxLayout(pAux, BoxLayout.Y_AXIS);
                pAux.setLayout(layout2);
                p.setLayout(layout);
                p.add(enunciado);
                if (Questao[i].get(0).equals("ME")) {

                    ArrayList opcoes = (ArrayList) Questao[i].get(2);
                    ButtonGroup grupo = new ButtonGroup();
                    char letra = 'a';
                    for (int j = 0; j < opcoes.size(); j++) {
                        JRadioButton opcao = new JRadioButton((String) opcoes.get(j));
                        opcao.setBackground(painel.getBackground());
                        radioME[k] = opcao;
                        radioME[k].setName(String.format("%s",letra));
                        letra++;
                        k++;
                        grupo.add(opcao);
                        pAux.add(opcao);
                    }

                    p.add(pAux);
                } else if (Questao[i].get(0).equals("VF")) {
                    ArrayList op2 = (ArrayList) Questao[i].get(2);
                    for (int j = 0; j < op2.size(); j++) {
                        JTextArea enunciadoAlternativa = new JTextArea();
                        enunciadoAlternativa.setEditable(false);
                        enunciadoAlternativa.setText((String) op2.get(j));
                        enunciadoAlternativa.setBackground(painel.getBackground());
                        ButtonGroup grupo = new ButtonGroup();
                        
                        radioV[constante] = new JRadioButton("Verdadeiro");
                        radioV[constante].setName("v");
                        radioF[constante] = new JRadioButton("Falso");
                        radioF[constante].setName("f");
                        radioF[constante].doClick();
                      //  selecao[constante] = new JCheckBox();
                      //  selecao[constante].setText("Verdadeiro");
                      radioV[constante].setBackground(painel.getBackground());
                      radioF[constante].setBackground(painel.getBackground());
                      grupo.add(radioV[constante]);
                      grupo.add(radioF[constante]);
                        pAux.add(enunciadoAlternativa);
                        pAux.add(radioV[constante]);
                        pAux.add(radioF[constante]);
                        constante++;

                    }
                    // pAux.add(new JLabel("______________________________________________________________________________________________"));
                    pAux.setBackground(painel.getBackground());
                    p.add(pAux);

                } else {
                    if (Questao[i].get(0).equals("aberta")) {
                        JTextArea area = new JTextArea();
                        area.setBackground(new Color(245,245,245));
                        area.setLineWrap(true);
                        pAux.add(area);
                    }
                    pAux.setBackground(painel.getBackground());
                    p.add(pAux);
                }
                p.setBackground(painel.getBackground());
                pAux.setBackground(painel.getBackground());
                painel.add(p);
                painel.add(alinha(pAux));
            }
            painel.add(finalizar);
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(ProvaOnline.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rolagem = new javax.swing.JScrollPane();
        painel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1022, Short.MAX_VALUE)
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
        );

        rolagem.setViewportView(painel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rolagem)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rolagem)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProvaOnline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProvaOnline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProvaOnline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProvaOnline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProvaOnline().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel painel;
    private javax.swing.JScrollPane rolagem;
    // End of variables declaration//GEN-END:variables
}
