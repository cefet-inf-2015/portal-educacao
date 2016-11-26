package trabalhobimestral;

import com.toedter.calendar.JDateChooser;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigInteger;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

public class InterfaceGrafica extends JFrame {

  private JFileChooser janelaDialogo; //janela para selecionar arquivos (logotipo e brasao)
  private JDateChooser dataProva;     //data se o user selecionou prova
  private JDateChooser dataRecebimento;//data recebimento se o user selecionou trabalho
  private JDateChooser dataEntrega; //data entrega se o user selecionou trabalho
  private BufferedImage imagem;//imagem selecionada pelo user (logotipo ou brasao)
  private File arquivo;       //arquivo selecionado: logotipo
  private File arquivo2;      //arquivo selecionado: brasao
  private JLabel mostraLogotipo;//label para fornecer pre visualização do logotipo
  private JLabel mostraBrasao;//label para fornecer pre visualização do brasao
  private Upload upload;  //Classe que trata o evento de clique em Upload Logotipo e Upload Brasao
  private enviarDados submit;//Classe para enviar os dados ao banco de dados
  private JPanel painel;
  private JButton uploadLogotipo;//botao para enviar logotipo
  private JButton uploadBrasao;//botao para enviar brasao
  private JLabel[] legendas;//etiquetas: Ex.: Matricula (aqui vem o campo de inserção)
  private JTextField titulo;//campo para inserir o titulo Ex.: Prova Bimestral
  private JTextField matricula;//campo para inserir a matricula Ex.: 2015111
  private JRadioButton prova;//campo de seleção prova
  private JRadioButton trabalho;//campo de seleção trabalho
  private JRadioButton individualTurma;//campo de seleção individualTurma
  private JRadioButton individualUnico;//campo de seleção individualUnico
  private JRadioButton grupo;//campo de seleção grupo
  private JRadioButton publica;//campo de seleção escola publica
  private JRadioButton privada;//campo de seleção escola privada
  private ButtonGroup grupo1;//grupo1 de radios (prova/trabalho)
  private ButtonGroup grupo2;//grupo2 de radios (individual/grupo)
  private ButtonGroup grupo3;//grupo3 de radios (publica/privada)
  private JButton confirmar;//botao para confirmar dados e mostrar segundo menu
  //private JButton atualizar;//botao caso o user queira modificar algo do banco de dados
  private JButton enviaDados;//botao para enviar os dados ao mySQL
  private EventoGrupo1 evento;//não implementado
  private EventoFoco eventoFoco;//ao clicar em determinado text field retira-se a mensagem default dele
  private eventoConfirmar eventoConfirma;//evento acionado pelo botao confirmar
  private final int max_Label = 7;//tamanho do vetor legendas
  private final String exemplo1 = "Ex.: Prova/Trabalho Bimestral";//mensagem default
  private final String exemplo2 = "Ex.: C2015111";//mensagem default
  private String dados = "";//armazena opcao selecionada no grupo 1 de radios
  private String dados2 = "";//armazena opcao selecionada no grupo 2 de radios
  private String dados3 = "";//armazena opcao selecionada no grupo 3 de radios
  private String dadosTitulo = "";//guarda o que o user digitou no campo titulo
  private Conectar conectar;//classe para conectar ao mySQL
  private Connection conexao;//Conexao ao banco de dados
  private Atualizar a;//classe para evento do botao atualizar
  private BufferedImage imagemRedimensionada;//logotipo redimensionado
  private BufferedImage imagemRedimensionada2;//brasao redimensionado
  private ImageIcon icone;//variavel utilizada para guardar o icone da imagem enviada (logotipo/brasao)
  private String extensao = "";//extensao do logotipo Ex.: .gif
  private String extensao2 = "";//extensao do brasao Ex.: .gif
  private String tabela = "dados";//nome da tabela no banco de dados
  private String colunas = "";//variavel que sera utilizada para guardar as colunas da tabela que serão modificadas
  private JFrame framePrincipal;
  private JButton[] botao;
  private eventoPrincipal e;
  private boolean atualiza = false;
  private boolean status = false;
  private boolean[] envio;
  private String aux = "";

  public InterfaceGrafica() {
    try {
      geraWord();
    } catch (IOException ex) {
      Logger.getLogger(InterfaceGrafica.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(InterfaceGrafica.class.getName()).log(Level.SEVERE, null, ex);
    }
    envio = new boolean[2];
    envio[0] = false;
    envio[1] = false;
    botao = new JButton[3];
    botao[0] = new JButton();
    botao[1] = new JButton();
    botao[2] = new JButton();
    e = new eventoPrincipal();
    framePrincipal = new JFrame();
    a = new Atualizar();
    botao[1].addActionListener(a);
    conectar = new Conectar();
    conexao = conectar.conexao();
    submit = new enviarDados();
    enviaDados = new JButton("Submit");
    dataProva = new JDateChooser();
    dataRecebimento = new JDateChooser();
    dataEntrega = new JDateChooser();
    mostraBrasao = new JLabel();
    upload = new Upload();
    janelaDialogo = new JFileChooser();
    mostraLogotipo = new JLabel();
    uploadLogotipo = new JButton("Enviar Logotipo");
    uploadBrasao = new JButton("Enviar Brasão");
    eventoConfirma = new eventoConfirmar();
    confirmar = new JButton("Confirmar Dados");
    evento = new EventoGrupo1();
    eventoFoco = new EventoFoco();
    legendas = new JLabel[max_Label];
    painel = new JPanel(null);
    titulo = new JTextField();
    matricula = new JTextField();

    grupo1 = new ButtonGroup();
    grupo2 = new ButtonGroup();
    grupo3 = new ButtonGroup();

    prova = new JRadioButton("Prova", false);
    trabalho = new JRadioButton("Trabalho", false);
    individualUnico = new JRadioButton("Individual (Específico)");
    individualTurma = new JRadioButton("Individual (para a turma)");
    publica = new JRadioButton("Pública");
    privada = new JRadioButton("Privada");
    grupo = new JRadioButton("Grupo");
    grupo3.add(publica);
    grupo3.add(privada);
    legendas[0] = new JLabel("Título: ");
    legendas[1] = new JLabel("Modalidade: ");
    legendas[2] = new JLabel("Escola: ");
    legendas[3] = new JLabel("Matrícula: ");
    legendas[4] = new JLabel("Data: ");
    legendas[5] = new JLabel("Data de Recebimento: ");
    legendas[6] = new JLabel("Data de Entrega: ");

    dataRecebimento.setDateFormatString("dd/MM/yyyy");

    enviaDados.addActionListener(submit);
    prova.addItemListener(evento);
    trabalho.addItemListener(evento);
    titulo.addFocusListener(eventoFoco);
    matricula.addFocusListener(eventoFoco);
    confirmar.addActionListener(eventoConfirma);
    uploadLogotipo.addActionListener(upload);
    uploadBrasao.addActionListener(upload);
    botao[0].addActionListener(e);
    botao[1].addActionListener(e);
    botao[2].addActionListener(e);
    add(painel);
    menuPrincipal();
  }

  public void geraWord() throws IOException, SQLException {
    //  Statement s = conexao.createStatement();
    // ResultSet resultado = s.executeQuery("SELECT * FROM dados WHERE titulo='" + titulo.getText() + "'");
    String matricula2 = JOptionPane.showInputDialog("Matricula: ");
    String escola = JOptionPane.showInputDialog("Escola: ");
    String titulo2 = JOptionPane.showInputDialog("Titulo: ");
    String prof = JOptionPane.showInputDialog("Professor: ");
    String turma = JOptionPane.showInputDialog("Turma: ");
    String nomeAluno = JOptionPane.showInputDialog("Nome: ");
    String data = JOptionPane.showInputDialog("Data: ");
    String valor = JOptionPane.showInputDialog("Valor: ");
    XWPFDocument document = new XWPFDocument();
    CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
    CTPageMar pageMar = sectPr.addNewPgMar();
    pageMar.setLeft(BigInteger.valueOf(500));
    pageMar.setTop(BigInteger.valueOf(100));
    pageMar.setRight(BigInteger.valueOf(500));
    pageMar.setBottom(BigInteger.valueOf(100));
    File f = new File("ALICE_COSTA 201511130024.jpg");
    BufferedImage i = ImageIO.read(f);
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    ImageIO.write(i, "jpg", os);
    InputStream is = new ByteArrayInputStream(os.toByteArray());

    File f2 = new File("brasao.gif");
    BufferedImage i2 = ImageIO.read(f2);
    ByteArrayOutputStream os2 = new ByteArrayOutputStream();
    ImageIO.write(i2, "gif", os2);
    InputStream is2 = new ByteArrayInputStream(os2.toByteArray());

    File f3 = new File("logo.gif");
    BufferedImage i3 = ImageIO.read(f3);
    ByteArrayOutputStream os3 = new ByteArrayOutputStream();
    ImageIO.write(i3, "gif", os3);
    InputStream is3 = new ByteArrayInputStream(os3.toByteArray());

    try {

      XWPFParagraph paragrafo = document.createParagraph();
      paragrafo.setAlignment(ParagraphAlignment.DISTRIBUTE);
      paragrafo.setSpacingAfter(200);
      // XWPFHeaderFooterPolicy policy = document.getHeaderFooterPolicy();
      XWPFRun p = paragrafo.createRun();
      p.setText("    ");
      p.addPicture(is, Document.PICTURE_TYPE_JPEG, "ALICE_COSTA 201511130024.jpg", Units.toEMU(60), Units.toEMU(60));
      p.addTab();
      p.addTab();
      p.addTab();
      p.addTab();
      p.addTab();
      p.addTab();
      p.setText("    ");

      p.addPicture(is2, Document.PICTURE_TYPE_GIF, "brasao.gif", Units.toEMU(60), Units.toEMU(60));
      p.addTab();
      p.addTab();
      p.addTab();
      p.addTab();
      p.addTab();
      p.addTab();
      p.addPicture(is3, Document.PICTURE_TYPE_GIF, "logo.gif", Units.toEMU(60), Units.toEMU(60));

    } catch (InvalidFormatException e1) {
      System.out.println(e1.getMessage());
    }

    XWPFParagraph matricula = document.createParagraph();
    matricula.setFirstLineIndent(100);
    matricula.setIndentFromRight(9500);
    matricula.setAlignment(ParagraphAlignment.CENTER);

    XWPFRun matriculaR = matricula.createRun();
    matriculaR.setFontFamily("Arial");
    matriculaR.setText(matricula2);
    matriculaR.setFontSize(12);
    matriculaR.setColor("000000");

    XWPFParagraph titulo = document.createParagraph();
    titulo.setAlignment(ParagraphAlignment.CENTER);
    XWPFRun tituloR = titulo.createRun();
    tituloR.setFontSize(12);
    tituloR.setFontFamily("Arial");
    tituloR.setColor("000000");
    titulo.setSpacingAfterLines(100);

    tituloR.setText(escola);
    tituloR.addBreak();
    tituloR.setText(titulo2);
    tituloR.addBreak();

    XWPFParagraph paragraphThree = document.createParagraph();
    paragraphThree.setAlignment(ParagraphAlignment.NUM_TAB);
    XWPFRun paragraphThreeRunOne = paragraphThree.createRun();
    paragraphThreeRunOne.setFontSize(12);
    paragraphThreeRunOne.setFontFamily("Arial");
    paragraphThreeRunOne.setColor("000000");
    paragraphThreeRunOne.setText("Professor (A): ");
    paragraphThreeRunOne.setText(prof);
    int aux = prof.length() / 6;
    int aux2 = nomeAluno.length() / 6;
    int primeiroTab = 10;
    int segundoTab = 11;
    if (prof.length() % 6 == prof.length()) {
      aux = 1;
      if (prof.length() <= 5) {
        aux--;
      }
    }
    if (nomeAluno.length() % 6 == nomeAluno.length()) {
      aux2 = 1;
      if (nomeAluno.length() <= 5) {
        //aux2+=2;
      }
    }
    aux = primeiroTab - aux;
    aux2 = segundoTab - aux2;
    for (int j = 0; j <= aux; j++) {
      System.out.println(j);
      paragraphThreeRunOne.addTab();
    }
    paragraphThreeRunOne.setText("Turma: ");
    paragraphThreeRunOne.setText(turma);

    XWPFParagraph paragrafo2 = document.createParagraph();
    paragrafo2.setAlignment(ParagraphAlignment.LEFT);

    XWPFRun paragrafo2R = paragrafo2.createRun();
    paragrafo2R.setFontFamily("Arial");
    paragrafo2R.setFontSize(12);
    paragrafo2R.setText("Aluno (a): ");
    paragrafo2R.setText(nomeAluno);
    for (int j = 0; j <= aux2; j++) {
      System.out.println(j);
      paragrafo2R.addTab();
    }
    paragrafo2R.setText("Data: ");
    paragrafo2R.setText(data);
    XWPFParagraph paragrafo3 = document.createParagraph();
    paragrafo2.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun paragrafo3R = paragrafo3.createRun();
    paragrafo3R.setFontFamily("Arial");
    paragrafo3R.setFontSize(12);
    for (int j = 0; j < 13; j++) {//System.out.println(j);
      paragrafo3R.addTab();
    }
    paragrafo3R.setText("Valor: ");
    paragrafo3R.setText(valor);

    FileOutputStream outStream = null;
    try {
      outStream = new FileOutputStream("teste.docx");
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
    try {
      document.write(outStream);
      outStream.close();
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public void menuPrincipal() {

    repaint();
    revalidate();
    Icon[] icone = new ImageIcon[3];
    icone[0] = new ImageIcon("add2.png");
    icone[1] = new ImageIcon("alterar2.png");
    icone[2] = new ImageIcon("consulta2.png");
    framePrincipal.setLayout(new GridLayout());
    for (int i = 0; i < botao.length; i++) {
      botao[i].setIcon(icone[i]);
      framePrincipal.add(botao[i]);
    }
    botao[0].setToolTipText("Novo Cabeçalho");
    botao[1].setToolTipText("Alterar Cabeçalho");
    botao[2].setToolTipText("Consultar Cabeçalho");
    framePrincipal.setVisible(true);
    framePrincipal.setSize(500, 200);
    framePrincipal.setLocationRelativeTo(null);
    framePrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  public void configuraFrame() {
    painel.removeAll();
    repaint();
    revalidate();
    setSize(500, 450);
    setVisible(true);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private class eventoPrincipal implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      mostraLogotipo.setIcon(null);
      mostraBrasao.setIcon(null);
      arquivo = null;
      arquivo2 = null;
      envio[0] = false;
      envio[1] = false;
      if (e.getSource() == botao[0]) {
        try {
          painel.removeAll();
          grupo1.clearSelection();
          grupo2.clearSelection();
          grupo3.clearSelection();
          matricula.setText(exemplo2);
          dataProva.setDate(null);
          dataRecebimento.setDate(null);
          dataEntrega.setDate(null);

          configuraFrame();
          primeiroMenu();
          framePrincipal.dispose();
        } catch (SQLException ex) {
          Logger.getLogger(InterfaceGrafica.class.getName()).log(Level.SEVERE, null, ex);
        }
      } else {
        if (e.getSource() == botao[1]) {
          atualiza = true;
          try {

            preencheFormulario();
          } catch (SQLException ex) {
            Logger.getLogger(InterfaceGrafica.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ParseException ex) {
            Logger.getLogger(InterfaceGrafica.class.getName()).log(Level.SEVERE, null, ex);
          }
        } else {//EH AKI JOW
          if (e.getSource() == botao[2]) {

            /*String cabecalho = JOptionPane.showInputDialog(null,"Titulo do cabeçalho: ");
            try {
              Statement s = conexao.createStatement();
              ResultSet resultado = s.executeQuery("SELECT * FROM dados WHERE titulo='"+cabecalho+"'");
              while(resultado.next()){
                p.setNomeProvaOuTrabalho(resultado.getString(1));
                String aux = resultado.getString(2);
                p.setTipo(aux);
                if(aux.equals(trabalho.getText())){
                  
                }
              
                
                  
                
              }
            } catch (SQLException ex) {
              Logger.getLogger(InterfaceGrafica.class.getName()).log(Level.SEVERE, null, ex);
            }*/
          }
        }
      }
    }
  }

  private class EventoGrupo1 implements ItemListener {

    @Override
    public void itemStateChanged(ItemEvent e) {
      if (prova.isSelected()) {

      } else {
        if (trabalho.isSelected()) {

        }
      }
    }
  }

  private class EventoFoco implements FocusListener {

    @Override
    public void focusGained(FocusEvent fe) {
      if (fe.getSource() == titulo) {
        if (titulo.getText().equals(exemplo1)) {//se campo titulo foi clicado e possui mensagem default, ela eh apagada
          titulo.setText("");
        }
      } else {
        if (fe.getSource() == matricula) {//se campo matricula foi clicado e possui mensagem default, ela eh apagada
          if (matricula.getText().equals(exemplo2)) {
            matricula.setText("");
          }
        }
      }
    }

    @Override
    public void focusLost(FocusEvent fe) {
      if (fe.getSource() == titulo) {//se campo titulo perdeu o foco e esta vazio, ele recebe a mensagem default
        if (titulo.getText().equals("")) {
          titulo.setText(exemplo1);
        }
      } else {
        if (fe.getSource() == matricula) {//se campo matricula perdeu o foco e esta vazio, ele recebe a mensagem default
          if (matricula.getText().equals("")) {
            matricula.setText(exemplo2);
          }
        }
      }
    }
  }

  /**
   * Metodo para ler logotipo e brasao do banco de dados, correspondente ao titulo especificado
   *
   * @param titulo
   * @throws SQLException
   */
  public void mostraImagemBD(String titulo) throws SQLException {
    PreparedStatement s = conexao.prepareStatement("SELECT * FROM dados WHERE titulo='" + titulo + "'");
    ImageIcon imageIcon = null;
    ImageIcon imageIcon2 = null;
    ResultSet resultado = s.executeQuery();
    if (resultado.next()) {
      String q = resultado.getString(9);
      //   System.out.println(q);
      Blob blob = resultado.getBlob(10);
      imageIcon = new ImageIcon(blob.getBytes(1, (int) blob.length()));
    }
    resultado = s.executeQuery();
    if (resultado.next()) {
      //  System.out.println("OI");
      String q = resultado.getString(11);
      //    System.out.println(q);
      Blob blob = resultado.getBlob(12);
      imageIcon2 = new ImageIcon(blob.getBytes(1, (int) blob.length()));
    }

    JFrame j = new JFrame();
    JPanel p = new JPanel(null);
    JLabel l = new JLabel(imageIcon);
    JLabel l2 = new JLabel(imageIcon2);
    l.setBounds(100, 100, 100, 100);
    l2.setBounds(250, 100, 100, 100);
    p.add(l);
    p.add(l2);
    p.revalidate();
    p.repaint();
    j.add(p);
    j.setVisible(true);
    j.setSize(500, 500);
    j.setLocationRelativeTo(null);
    j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //  try {
    //   Thread.sleep(2000);
    // } catch (InterruptedException ex) {
    //   Logger.getLogger(InterfaceGrafica.class.getName()).log(Level.SEVERE, null, ex);
    //  }
    // j.dispose();
  }

  /**
   * Metodo para gerar primeira parte do formulario (primeiro menu)
   *
   * @throws SQLException
   */
  public void primeiroMenu() throws SQLException {

    configuraFrame();
    // String valor = JOptionPane.showInputDialog("Titulo para consulta: ");
    // mostraImagemBD(valor);
    legendas[0].setBounds(80, 10, 50, 20);
    titulo.setBounds(130, 10, 250, 20);
    if (!atualiza) {
      titulo.setText(exemplo1);
    }
    titulo.setToolTipText(exemplo1);
    prova.setBounds(150, 40, 90, 40);
    trabalho.setBounds(240, 40, 90, 40);

    grupo1.add(prova);
    grupo1.add(trabalho);

    individualUnico.setBounds(170, 90, 250, 20);
    individualTurma.setBounds(170, 110, 250, 20);
    grupo.setBounds(170, 130, 250, 20);
    legendas[1].setBounds(legendas[0].getX(), individualTurma.getY(), 100, 20);
    legendas[2].setBounds(legendas[0].getX(), grupo.getY() + grupo.getHeight() + 20, 50, 20);
    publica.setBounds(grupo.getX(), legendas[2].getY() + 10, 80, 20);
    privada.setBounds(grupo.getX(), publica.getY() + publica.getHeight(), 80, 20);
    confirmar.setBounds(150, 250, 200, 20);
    grupo2.add(individualUnico);
    grupo2.add(individualTurma);
    grupo2.add(grupo);

    painel.add(publica);
    painel.add(privada);
    painel.add(legendas[0]);
    painel.add(legendas[1]);
    painel.add(legendas[2]);
    painel.add(titulo);
    painel.add(prova);
    painel.add(trabalho);
    painel.add(individualUnico);
    painel.add(individualTurma);
    painel.add(grupo);
    painel.add(confirmar);

  }

  /**
   * Metodo para consultar o banco de dados
   *
   * @param valor
   * @throws SQLException
   */
  public void alteraDadosMySQL() throws SQLException, IOException {
    byte[] logo = null;
    byte[] brasao = null;
    if (imagemRedimensionada != null) {
      ByteArrayOutputStream bytesImg = new ByteArrayOutputStream();
      ImageIO.write((BufferedImage) imagemRedimensionada, extensao, bytesImg);
      bytesImg.flush();
      logo = bytesImg.toByteArray();
      bytesImg.close();
    }

    if (imagemRedimensionada2 != null) {
      ByteArrayOutputStream bytesImg2 = new ByteArrayOutputStream();
      ImageIO.write((BufferedImage) imagemRedimensionada2, extensao2, bytesImg2);
      bytesImg2.flush();
      brasao = bytesImg2.toByteArray();
      bytesImg2.close();
    }

    if (dados.equals(prova.getText())) {
      if (dados2.equals(individualUnico.getText())) {
        //    System.out.println("1");
        PreparedStatement p = conexao.prepareStatement("UPDATE dados SET titulo='" + titulo.getText() + "'"
                + ", tipo='" + dados + "'"
                + ", modalidade='" + dados2 + "'"
                + ", escola='" + dados3 + "'"
                + ", matricula='" + matricula.getText() + "'"
                + ", dataProva=?"
                + ", dataRecebimento=?"
                + ", dataEntrega=?"
                + " WHERE titulo='" + aux + "'"
        );
        p.clearParameters();
        p.setDate(1, new java.sql.Date(dataProva.getDate().getTime()));
        p.setDate(2, null);
        p.setDate(3, null);
        p.executeUpdate();
      } else {
        if (dados2.equals(individualTurma.getText()) || dados2.equals(grupo.getText())) {
          System.out.println("OK");
          //    System.out.println("2");
          PreparedStatement p = conexao.prepareStatement("UPDATE dados SET titulo='" + titulo.getText() + "'"
                  + ", tipo='" + dados + "'"
                  + ", modalidade='" + dados2 + "'"
                  + ", escola='" + dados3 + "'"
                  + ", matricula=?"
                  + ", dataProva=?"
                  + ", dataRecebimento=?"
                  + ", dataEntrega=?"
                  + " WHERE titulo='" + aux + "'"
          );
          p.clearParameters();
          p.setString(1, null);
          p.setDate(2, new java.sql.Date(dataProva.getDate().getTime()));
          p.setDate(3, null);
          p.setDate(4, null);
          p.executeUpdate();
        }
      }
    } else {
      if (dados.equals(trabalho.getText())) {
        if (dados2.equals(individualUnico.getText())) {

          PreparedStatement p = conexao.prepareStatement("UPDATE dados SET titulo='" + titulo.getText() + "'"
                  + ", tipo='" + dados + "'"
                  + ", modalidade='" + dados2 + "'"
                  + ", escola='" + dados3 + "'"
                  + ", matricula='" + matricula.getText() + "'"
                  + ", dataProva=?"
                  + ", dataRecebimento=?"
                  + ", dataEntrega=?"
                  + " WHERE titulo='" + aux + "'"
          );
          p.clearParameters();

          p.setDate(1, null);
          p.setDate(2, new java.sql.Date(dataRecebimento.getDate().getTime()));
          p.setDate(3, new java.sql.Date(dataEntrega.getDate().getTime()));
          p.executeUpdate();
        } else {
          if (dados2.equals(individualTurma.getText()) || dados2.equals(grupo.getText())) {
            //    System.out.println("4");
            PreparedStatement p = conexao.prepareStatement("UPDATE dados SET titulo='" + titulo.getText() + "'"
                    + ", tipo='" + dados + "'"
                    + ", modalidade='" + dados2 + "'"
                    + ", escola='" + dados3 + "'"
                    + ", matricula=?"
                    + ", dataProva=?"
                    + ", dataRecebimento=?"
                    + ", dataEntrega=?"
                    + " WHERE titulo='" + aux + "'"
            );
            p.clearParameters();
            p.setString(1, null);
            p.setDate(2, null);
            p.setDate(3, new java.sql.Date(dataRecebimento.getDate().getTime()));
            p.setDate(4, new java.sql.Date(dataEntrega.getDate().getTime()));
            p.executeUpdate();
          }
        }
      }
    }
    if (envio[0]) {
      if (envio[1]) {
        System.out.println(envio[1]);
        PreparedStatement s = conexao.prepareStatement("UPDATE dados SET logotipo= ? , brasao= ?, nomeLogotipo=?, nomeBrasao=? WHERE titulo='" + titulo.getText() + "'");//conexao.createStatement();
        s.clearParameters();
        s.setBytes(1, logo);
        s.setBytes(2, brasao);
        s.setString(3, arquivo.getName());
        s.setString(4, arquivo2.getName());
        s.executeUpdate();
      } else {
        PreparedStatement s = conexao.prepareStatement("UPDATE dados SET logotipo= ?, brasao=? , nomeLogotipo=?, nomeBrasao=? WHERE titulo='" + titulo.getText() + "'");
        s.clearParameters();
        s.setBytes(1, logo);
        s.setBytes(2, null);
        s.setString(3, arquivo.getName());
        s.setString(4, null);
        s.executeUpdate();
      }
    }
    if (dados3.equals(privada.getText())) {
      PreparedStatement s = conexao.prepareStatement("UPDATE dados SET brasao=?, nomeBrasao=? WHERE titulo='" + dadosTitulo + "'");
      s.setBytes(1, null);
      s.setString(2, null);
      s.executeUpdate();
    }
    dispose();
    framePrincipal.setVisible(true);
  }

  public void preencheFormulario() throws SQLException, ParseException {

    framePrincipal.dispose();
    aux = JOptionPane.showInputDialog("Titulo para alterar:");
    Statement s = conexao.createStatement();
    ResultSet resultado = s.executeQuery("SELECT * FROM dados WHERE titulo='" + aux + "'");
    ArrayList<String> dados = new ArrayList<>();
    ArrayList<Date> data = new ArrayList<>();
    while (resultado.next()) {
      dados.add(resultado.getString(1));
      dados.add(resultado.getString(2));
      dados.add(resultado.getString(3));
      dados.add(resultado.getString(4));
      dados.add(resultado.getString(5));

      data.add(resultado.getDate(6));
      data.add(resultado.getDate(7));
      data.add(resultado.getDate(8));
    }
    titulo.setText(dados.get(0));
    if (dados.get(1).equals(prova.getText())) {
      prova.setSelected(true);
    } else {
      if (dados.get(1).equals(trabalho.getText())) {
        trabalho.setSelected(true);
      }
    }
    if (dados.get(2).equals(individualUnico.getText())) {
      individualUnico.setSelected(true);
    } else {
      if (dados.get(2).equals(individualTurma.getText())) {
        individualTurma.setSelected(true);
      } else {
        if (dados.get(2).equals(grupo.getText())) {
          grupo.setSelected(true);
        }
      }
    }
    if (dados.get(3).equals(publica.getText())) {
      publica.setSelected(true);
    } else {
      if (dados.get(3).equals(privada.getText())) {
        privada.setSelected(true);
      }
    }

    if (dados.get(4) != null) {
      matricula.setText(dados.get(4));
    }
    SimpleDateFormat dataSimples = new SimpleDateFormat("dd/MM/yyyy");
    if (data.get(0) == null) {
      String d = dataSimples.format(data.get(1));
      dataRecebimento.setDate(dataSimples.parse(d));
      d = dataSimples.format(data.get(2));
      dataEntrega.setDate(dataSimples.parse(d));
    } else {
      String d = dataSimples.format(data.get(0));
      dataProva.setDate(dataSimples.parse(d));
    }
    dadosTitulo = titulo.getText();
    //   System.out.println(titulo.getText());
    PreparedStatement s1 = conexao.prepareStatement("SELECT * FROM dados WHERE titulo='" + titulo.getText() + "'");
    ImageIcon imageIcon = null;
    ImageIcon imageIcon2 = null;
    ResultSet resultado1 = s1.executeQuery();
    if (resultado1.next()) {
      String q = resultado1.getString(9);
      //    System.out.println(q);
      Blob blob = resultado1.getBlob(10);
      imageIcon = new ImageIcon(blob.getBytes(1, (int) blob.length()));
    }
    resultado1 = s1.executeQuery();
    if (resultado1.next()) {

      Blob blob = resultado1.getBlob(12);
      if (blob != null) {
        imageIcon2 = new ImageIcon(blob.getBytes(1, (int) blob.length()));
      }
    }
    if (imageIcon != null) {
      mostraLogotipo.setIcon(imageIcon);
      if (imageIcon2 != null) {
        mostraBrasao.setIcon(imageIcon2);
      }
    }

    primeiroMenu();
  }

  public void mostraDadosMySQL(String valor) throws SQLException {
    String sql = "";
    if (valor.equals("")) {
      sql = "SELECT * FROM dados";
    } else {
      sql = "SELECT * FROM dados WHERE titulo='" + valor + "'";
    }
    Statement s = conexao.createStatement();

    ResultSet resultado = s.executeQuery(sql);
    String[] dados = new String[8];
    while (resultado.next()) {
      dados[0] = resultado.getString(1);
      dados[1] = resultado.getString(2);
      dados[2] = resultado.getString(3);
      dados[3] = resultado.getString(4);
      dados[4] = resultado.getString(5);
      dados[5] = resultado.getString(6);
      dados[6] = resultado.getString(7);
      dados[7] = resultado.getString(8);

      System.out.println("Titulo: " + dados[0] + "\nTipo: " + dados[1] + "\nModalidade: " + dados[2] + "\nEscola: " + dados[3] + "\nMatricula: " + dados[4] + "\nData Prova: " + dados[5] + "\nData Recebimento: " + dados[6] + "\nData Entrega: " + dados[7] + "\n\n");
    }
  }

  /**
   * Metodo que gera a segunda parte do formulário (segundo menu)
   *
   * @throws ParseException
   */
  public void segundoMenu() throws ParseException {
    if (dados3.equals(publica.getText())) {
      mostraLogotipo.setBounds(115, 200, 100, 100);
      mostraBrasao.setBounds(275, 200, 100, 100);
      painel.add(mostraBrasao);
    } else {
      mostraLogotipo.setBounds(200, 200, 100, 100);
    }

    painel.add(mostraLogotipo);
    enviaDados.setBounds(200, 340, 100, 50);
    painel.add(enviaDados);
    if (dados.equals(prova.getText())) {
      legendas[4].setBounds(80, 50, 40, 20);
      if (dados2.equals(individualUnico.getText())) {
        legendas[3].setBounds(80, 10, 80, 20);
        matricula.setBounds((legendas[3].getX() + legendas[3].getWidth()), legendas[3].getY(), titulo.getWidth(), titulo.getHeight());
        dataProva.setBounds(matricula.getX(), 50, 100, 20);
        if (!atualiza) {
          matricula.setText(exemplo2);
        }
        painel.add(matricula);
        painel.add(legendas[3]);
        painel.add(dataProva);
      } else {
        if (dados2.equals(individualTurma.getText())) {
          legendas[4].setBounds(150, 50, 40, 20);
          dataProva.setBounds(legendas[4].getX() + legendas[4].getWidth(), legendas[4].getY(), 100, 20);
        } else {
          if (dados2.equals(grupo.getText())) {
            legendas[4].setBounds(150, 50, 40, 20);
            dataProva.setBounds(legendas[4].getX() + legendas[4].getWidth(), legendas[4].getY(), 100, 20);
          }
        }
      }
      painel.add(legendas[4]);
      painel.add(dataProva);
    } else {
      if (dados.equals(trabalho.getText())) {
        if (dados2.equals(individualUnico.getText())) {
          if (!atualiza) {
            matricula.setText(exemplo2);
          }
          legendas[3].setBounds(80, 10, 80, 20);
          matricula.setBounds((legendas[3].getX() + legendas[3].getWidth()), legendas[3].getY(), 250, 20);
          legendas[5].setBounds(80, 40, 130, 20);
          dataRecebimento.setBounds(210, 40, 100, 20);
          legendas[6].setBounds(80, 70, 130, 20);
          dataEntrega.setBounds(210, 70, 100, 20);
          painel.add(legendas[6]);
          painel.add(dataEntrega);
          painel.add(dataRecebimento);
          painel.add(legendas[5]);
          painel.add(legendas[3]);
          painel.add(matricula);
        } else {
          legendas[5].setBounds(100, 20, 130, 20);
          legendas[6].setBounds(legendas[5].getX(), 50, 100, 20);
          dataRecebimento.setBounds(legendas[5].getX() + legendas[5].getWidth() + 10, 50, 100, 20);
          dataEntrega.setBounds(legendas[5].getX() + legendas[5].getWidth() + 10, 20, 100, 20);
          painel.add(legendas[5]);
          painel.add(legendas[6]);
          painel.add(dataEntrega);
        }
      }
    }

    if (dados3.equals(publica.getText())) {
      uploadLogotipo.setBounds(100, 100, 130, 50);
      uploadBrasao.setBounds((uploadLogotipo.getX() + uploadLogotipo.getWidth() + 30), 100, 130, 50);
      painel.add(uploadLogotipo);
      painel.add(uploadBrasao);
    } else {
      uploadLogotipo.setBounds(185, 100, 130, 50);
      painel.add(uploadLogotipo);
    }

    painel.add(dataRecebimento);
    add(painel);
  }

  /**
   * Metodo para inserir os dados no banco de dados
   *
   * @param tabela
   * @param colunas
   * @param matricula indica se sera gravado no bd uma matricula
   * @param data if true, significa que eh a data de uma prova, false significa datas do trabalho
   * @param brasao2 indica se sera gravado brasao no banco de dados
   * @throws IOException
   */
  public void insereDadosMySQL(String tabela, String colunas, boolean matricula, boolean data, boolean brasao2) throws IOException {
    status = true;
    ByteArrayOutputStream bytesImg = new ByteArrayOutputStream();
    ImageIO.write((BufferedImage) imagemRedimensionada, extensao, bytesImg);
    bytesImg.flush();
    byte[] logo = bytesImg.toByteArray();
    bytesImg.close();
    /**
     * Transforma a imagem do logotipo e brasao em um array de bytes para enviar ao banco de dados
     */
    byte[] brasao = null;
    if (brasao2) {
      ByteArrayOutputStream bytesImg2 = new ByteArrayOutputStream();
      ImageIO.write((BufferedImage) imagemRedimensionada2, extensao2, bytesImg2);
      bytesImg2.flush();
      brasao = bytesImg2.toByteArray();
      bytesImg2.close();
    }

    String[] aux = colunas.split(",");
    String values = "?";
    for (int i = 0; i < aux.length - 1; i++) {
      values += ",?";
    }
    try {
      PreparedStatement p = conexao.prepareStatement("INSERT INTO " + tabela + "(" + colunas + ") VALUES (" + values + ")");
      //     System.out.println("INSERT INTO " + tabela + "(" + colunas + ") VALUES (" + values + ")");
      p.setString(1, dadosTitulo);
      p.setString(2, dados);
      p.setString(3, dados2);
      p.setString(4, dados3);
      if (matricula) {
        p.setString(5, this.matricula.getText());
        if (data) {
          p.setDate(6, new java.sql.Date(dataProva.getDate().getTime()));
          p.setString(7, arquivo.getName());
          p.setBytes(8, logo);
          if (brasao2) {
            p.setString(9, arquivo2.getName());
            p.setBytes(10, brasao);
          }
        } else {
          p.setDate(6, new java.sql.Date(dataRecebimento.getDate().getTime()));
          p.setDate(7, new java.sql.Date(dataEntrega.getDate().getTime()));
          p.setString(8, arquivo.getName());
          p.setBytes(9, logo);
          if (brasao2) {
            p.setString(10, arquivo2.getName());
            p.setBytes(11, brasao);
          }
        }
      } else {
        if (data) {
          p.setDate(5, new java.sql.Date(dataProva.getDate().getTime()));
          p.setString(6, arquivo.getName());
          p.setBytes(7, logo);
          if (brasao2) {
            p.setString(8, arquivo2.getName());
            p.setBytes(9, brasao);
          }
        } else {
          p.setDate(5, new java.sql.Date(dataRecebimento.getDate().getTime()));
          p.setDate(6, new java.sql.Date(dataEntrega.getDate().getTime()));
          p.setString(7, arquivo.getName());
          p.setBytes(8, logo);
          if (brasao != null) {
            p.setString(9, arquivo2.getName());
            p.setBytes(10, brasao);
          }
        }
      }
      p.executeUpdate();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      //   System.out.println("catch 2");
    }
  }

  private class Atualizar implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

    }
  }

  private class eventoConfirmar implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      if (!titulo.getText().equals("") && !titulo.getText().equals(exemplo1)) {
        if (grupo1.getSelection() != null) {
          if (grupo2.getSelection() != null) {
            if (grupo3.getSelection() != null) {

              if (prova.isSelected()) {
                dados = prova.getText();

              } else {
                dados = trabalho.getText();
              }
              if (individualUnico.isSelected()) {
                dados2 = individualUnico.getText();
              } else {
                if (individualTurma.isSelected()) {
                  dados2 = individualTurma.getText();
                } else {
                  dados2 = grupo.getText();
                }
              }
              if (publica.isSelected()) {
                dados3 = publica.getText();
              } else {
                dados3 = privada.getText();
              }
              dadosTitulo = titulo.getText();
              painel.removeAll();
              painel.repaint();
              painel.revalidate();
              try {
                segundoMenu();
              } catch (ParseException ex) {
                System.out.println(ex.getMessage());
                System.out.println("catch 4");
              }
            } else {
              JOptionPane.showMessageDialog(null, "Selecione uma Escola!");
            }
          } else {
            JOptionPane.showMessageDialog(null, "Selecione uma Modalidade!");
          }
        } else {
          JOptionPane.showMessageDialog(null, "Selecione Prova ou Trabalho!");
        }
      } else {
        JOptionPane.showMessageDialog(null, "Digite um título!");
      }
    }
  }

  /**
   * Metodo para exibir na tela uma imagem (utilizado apenas para testes)
   *
   * @param i
   */
  public void mostraImagem(BufferedImage i) {
    ImageIcon imagem = new ImageIcon(i);
    JFrame j = new JFrame();
    JLabel l = new JLabel(imagem);
    j.setSize(300, 300);
    j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    j.setLocationRelativeTo(null);
    j.setVisible(true);

    j.add(l);
  }

  private class Upload implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      File arq = null;
      if (e.getSource() == uploadLogotipo || e.getSource() == uploadBrasao) {
        janelaDialogo.showOpenDialog(null);
        if (e.getSource() == uploadLogotipo) {
          arquivo = janelaDialogo.getSelectedFile();
          arq = arquivo;
        } else {
          if (e.getSource() == uploadBrasao) {
            arquivo2 = janelaDialogo.getSelectedFile();
            arq = arquivo2;
          }
        }
        if (arq.length() > 16777216) {
          JOptionPane.showMessageDialog(null, "Tamanho Maximo: 16MB");
          return;
        }

        try {
          imagem = ImageIO.read(arq);

          if (e.getSource() == uploadLogotipo) {
            envio[0] = true;
            extensao = arq.getName().substring(arq.getName().lastIndexOf("."), arq.getName().length());
            extensao = extensao.replace(".", "");
          } else {
            if (e.getSource() == uploadBrasao) {
              System.out.println("OLA FDP");
              envio[1] = true;
              extensao2 = arq.getName().substring(arq.getName().lastIndexOf("."), arq.getName().length());
              extensao2 = extensao2.replace(".", "");
            }
          }
          // System.out.println(extensao);
          if (e.getSource() == uploadLogotipo) {
            imagemRedimensionada = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = imagemRedimensionada.createGraphics();
            g.drawImage(imagem, 0, 0, 100, 100, null);
            g.dispose();

            icone = new ImageIcon(imagemRedimensionada);
          } else {
            if (e.getSource() == uploadBrasao) {
              imagemRedimensionada2 = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
              Graphics2D g = imagemRedimensionada2.createGraphics();
              g.drawImage(imagem, 0, 0, 100, 100, null);
              g.dispose();
              /**
               * "Desenha a imagem novamente" porem no tamanho de 100x100
               */
              icone = new ImageIcon(imagemRedimensionada2);
            }
          }
          if (e.getSource() == uploadBrasao) {
            mostraBrasao.setIcon(icone);
            mostraBrasao.setBounds(275, 200, 100, 100);
            painel.add(mostraBrasao);
          } else {
            mostraLogotipo.setIcon(icone);
            if (dados3.equals(publica.getText())) {
              mostraLogotipo.setBounds(115, 200, 100, 100);
            } else {
              mostraLogotipo.setBounds(200, 200, 100, 100);
            }
            painel.add(mostraLogotipo);
          }
          painel.repaint();
          painel.revalidate();
        } catch (IOException e1) {
          System.out.println(e1.getMessage());
          System.out.println("catch 5");
        }
      }
    }
  }

  private class enviarDados implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == enviaDados && !atualiza) {
        if (dados2.equals(individualUnico.getText())) {
          if (matricula.getText().equals("") || matricula.getText().equals(exemplo2)) {
            JOptionPane.showMessageDialog(null, "Insira a matrícula!");
          } else {
            if (dados.equals(prova.getText())) {
              if (dataProva.getDate() != null) {
                if (mostraLogotipo.getIcon() != null) {
                  if (mostraBrasao.getIcon() != null) {
                    try {

                      colunas = "titulo,tipo,modalidade,escola,matricula,dataProva,nomeLogotipo,logotipo,nomeBrasao,brasao";

                      insereDadosMySQL(tabela, colunas, true, true, true);

                    } catch (FileNotFoundException ex2) {
                      System.out.println(ex2.getMessage());
                      System.out.println("catch 6");
                    } catch (IOException ex) {
                      System.out.println(ex.getMessage());
                      System.out.println("catch 7");
                    }
                  } else {
                    try {
                      colunas = "titulo,tipo,modalidade,escola,matricula,dataProva,nomeLogotipo,logotipo";
                      insereDadosMySQL(tabela, colunas, true, true, false);

                    } catch (FileNotFoundException ex2) {
                      System.out.println(ex2.getMessage());
                      System.out.println("catch 8");
                    } catch (IOException ex) {
                      System.out.println(ex.getMessage());
                    }
                  }
                } else {
                  JOptionPane.showMessageDialog(null, "Envie o Logotipo");
                }
              } else {
                JOptionPane.showMessageDialog(null, "Insira uma data válida!");
              }

            } else {
              if (dados.equals(trabalho.getText())) {

                if (dataRecebimento.getDate() != null) {
                  if (dataEntrega.getDate() != null) {
                    if (mostraLogotipo.getIcon() != null) {
                      if (mostraBrasao.getIcon() != null) {
                        try {
                          colunas = "titulo,tipo,modalidade,escola,matricula,dataRecebimento,dataEntrega,nomeLogotipo,logotipo,nomeBrasao,brasao";
                          insereDadosMySQL(tabela, colunas, true, false, true);

                        } catch (FileNotFoundException ex) {
                          System.out.println(ex.getMessage());
                          System.out.println("catch 9");
                        } catch (IOException ex) {
                          System.out.println(ex.getMessage());
                          System.out.println("catch 10");
                        }
                      } else {
                        try {

                          colunas = "titulo,tipo,modalidade,escola,matricula,dataRecebimento,dataEntrega,nomeLogotipo,logotipo";
                          insereDadosMySQL(tabela, colunas, true, false, false);

                        } catch (FileNotFoundException ex) {
                          System.out.println(ex.getMessage());
                          System.out.println("catch 11");
                        } catch (IOException ex) {
                          System.out.println(ex.getMessage());
                          System.out.println("catch 12");
                        }
                      }
                    } else {
                      JOptionPane.showMessageDialog(null, "Envie o Logotipo!");
                    }
                  } else {
                    JOptionPane.showMessageDialog(null, "Insira uma data de entrega valida!");
                  }
                } else {
                  JOptionPane.showMessageDialog(null, "Insira uma data de recebimento valida!");
                }

              }
            }
          }
        } else {
          if (dados2.equals(individualTurma.getText())) {
            if (dados.equals(prova.getText())) {
              if (dataProva.getDate() != null) {
                if (mostraLogotipo.getIcon() != null) {
                  if (mostraBrasao.getIcon() != null) {
                    try {
                      colunas = "titulo,tipo,modalidade,escola,dataProva,nomeLogotipo,logotipo,nomeBrasao,brasao";
                      insereDadosMySQL(tabela, colunas, false, true, true);
                    } catch (FileNotFoundException ex) {
                      System.out.println(ex.getMessage());
                      System.out.println("catch 13");
                    } catch (IOException ex) {
                      System.out.println(ex.getMessage());
                      System.out.println("catch 14");
                    }
                  } else {
                    try {
                      colunas = "titulo,tipo,modalidade,escola,dataProva,nomeLogotipo,logotipo";
                      insereDadosMySQL(tabela, colunas, false, true, false);
                    } catch (FileNotFoundException ex) {
                      System.out.println(ex.getMessage());
                      System.out.println("catch 15");
                    } catch (IOException ex) {
                      System.out.println(ex.getMessage());
                      System.out.println("catch 16");
                    }
                  }
                } else {
                  JOptionPane.showMessageDialog(null, "Envie o Logotipo");
                }
              } else {
                JOptionPane.showMessageDialog(null, "Insira um data válida!");

              }
            } else {
              if (dados.equals(trabalho.getText())) {
                if (dataRecebimento.getDate() != null) {
                  if (dataEntrega.getDate() != null) {
                    if (mostraLogotipo.getIcon() != null) {
                      if (mostraBrasao.getIcon() != null) {
                        try {

                          colunas = "titulo,tipo,modalidade,escola,dataRecebimento,dataEntrega,nomeLogotipo,logotipo,nomeBrasao,brasao";
                          insereDadosMySQL(tabela, colunas, false, false, true);
                        } catch (FileNotFoundException ex) {
                          System.out.println(ex.getMessage());
                          System.out.println("catch 17");
                        } catch (IOException ex) {
                          System.out.println(ex.getMessage());
                          System.out.println("catch 18");
                        }
                      } else {
                        colunas = "titulo,tipo,modalidade,escola,dataRecebimento,dataEntrega,nomeLogotipo,logotipo";
                        try {
                          insereDadosMySQL(tabela, colunas, false, false, false);
                        } catch (IOException ex) {
                          System.out.println(ex.getMessage());
                          System.out.println("catch 19");
                        }
                      }
                    }
                  }
                }
              }
            }

          } else {
            if (dados2.equals(grupo.getText())) {
              if (dados.equals(prova.getText())) {
                if (dataProva.getDate() != null) {
                  if (mostraLogotipo.getIcon() != null) {
                    if (mostraBrasao.getIcon() != null) {
                      try {
                        colunas = "titulo,tipo,modalidade,escola,dataProva,nomeLogotipo,logotipo,nomeBrasao,brasao";
                        insereDadosMySQL(tabela, colunas, false, true, true);
                      } catch (FileNotFoundException ex) {
                        System.out.println(ex.getMessage());
                        System.out.println("catch 20");
                      } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                        System.out.println("catch 21");
                      }
                    } else {
                      try {
                        colunas = "titulo,tipo,modalidade,escola,dataProva,nomeLogotipo,logotipo";
                        insereDadosMySQL(tabela, colunas, false, true, false);
                      } catch (FileNotFoundException ex) {
                        System.out.println(ex.getMessage());
                        System.out.println("catch 22");
                      } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                        System.out.println("catch 23");
                      }
                    }
                  } else {
                    JOptionPane.showMessageDialog(null, "Envie o Logotipo");
                  }
                } else {
                  JOptionPane.showMessageDialog(null, "Insira um data válida!");

                }
              } else {
                if (dados.equals(trabalho.getText())) {
                  if (dataRecebimento.getDate() != null) {
                    if (dataEntrega.getDate() != null) {
                      if (mostraLogotipo.getIcon() != null) {
                        if (mostraBrasao.getIcon() != null) {
                          try {
                            colunas = "titulo,tipo,modalidade,escola,dataRecebimento,dataEntrega,nomeLogotipo,logotipo,nomeBrasao,brasao";
                            insereDadosMySQL(tabela, colunas, false, false, true);
                          } catch (FileNotFoundException ex) {
                            System.out.println(ex.getMessage());
                            System.out.println("catch 24");
                          } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                            System.out.println("catch 25");
                          }
                        } else {
                          try {
                            colunas = "titulo,tipo,modalidade,escola,dataRecebimento,dataEntrega,nomeLogotipo,logotipo";
                            insereDadosMySQL(tabela, colunas, false, false, false);
                          } catch (FileNotFoundException ex) {
                            System.out.println(ex.getMessage());
                            System.out.println("catch 26");
                          } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                            System.out.println("catch 27");
                          }
                        }
                      } else {
                        JOptionPane.showMessageDialog(null, "Envie o Logotipo!");
                      }
                    } else {
                      JOptionPane.showMessageDialog(null, "Insira uma data de entrega valida!");
                    }
                  } else {
                    JOptionPane.showMessageDialog(null, "Insira uma data de recebimento valida!");
                  }
                }
              }
            }
          }
        }
        if (status) {
          dispose();
          menuPrincipal();
          status = false;
        }
      } else {
        if (e.getSource() == enviaDados && atualiza) {

          try {
            if (dados.equals(prova.getText())) {
              if (dataProva.getDate() != null) {
                if (dados2.equals(individualUnico.getText())) {
                  if (!matricula.getText().equals(exemplo2) || !matricula.getText().equals("")) {
                    alteraDadosMySQL();
                    dispose();
                    atualiza = false;
                  } else {
                    JOptionPane.showMessageDialog(null, "Insira uma matrícula valida!");
                  }
                }
              } else {
                JOptionPane.showMessageDialog(null, "Insira uma data valida!");
              }
            } else {
              if (dados.equals(trabalho.getText())) {

                if (dataRecebimento.getDate() != null) {
                  if (dataEntrega.getDate() != null) {
                    alteraDadosMySQL();
                    dispose();
                    atualiza = false;
                  } else {
                    JOptionPane.showMessageDialog(null, "Insira uma data de recebimento valida!");
                  }
                } else {
                  JOptionPane.showMessageDialog(null, "Insira uma data de entrega valida!");
                }
              }
            }

          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("catch 3");
          } catch (IOException ex) {
            Logger.getLogger(InterfaceGrafica.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
      }
    }
  }
}