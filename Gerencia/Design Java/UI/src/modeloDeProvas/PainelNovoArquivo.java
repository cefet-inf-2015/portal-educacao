package modeloDeProvas;

import BancoDeDados.Conexao;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

public class PainelNovoArquivo extends javax.swing.JPanel {

    EscolheAluno SelectAluno = new EscolheAluno();
    PainelGerado painelGerado = new PainelGerado();

    private JFileChooser janelaDialogo; //janela para selecionar arquivos (logotipo e brasao)
///////  private JDateChooser dataProva;     //data se o user selecionou prova
////  private JDateChooser dataRecebimento;//data recebimento se o user selecionou trabalho
    // private JDateChooser dataEntrega; //data entrega se o user selecionou trabalho
    private BufferedImage imagem;//imagem selecionada pelo user (logotipo ou brasao)
    private File arquivo;       //arquivo selecionado: logotipo
    private File arquivo2;      //arquivo selecionado: brasao
    private JLabel mostraLogotipo;//label para fornecer pre visualização do logotipo
    private JLabel mostraBrasao;//label para fornecer pre visualização do brasao
    private Upload upload;  //Classe que trata o evento de clique em Upload Logotipo e Upload Brasao
    private enviarDados submit;//Classe para enviar os dados ao banco de dados
    private JPanel painel;
    private int contadorLogo = 0;
    private int contadorBrasao = 0;
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
    // private EventoGrupo1 evento;//não implementado
    // private EventoFoco eventoFoco;//ao clicar em determinado text field retira-se a mensagem default dele
    // private eventoConfirmar eventoConfirma;//evento acionado pelo botao confirmar
    private final int max_Label = 7;//tamanho do vetor legendas
    private final String exemplo1 = "Ex.: Prova/Trabalho Bimestral";//mensagem default
    private final String exemplo2 = "Ex.: C2015111";//mensagem default
    private String dados = "";//armazena opcao selecionada no grupo 1 de radios
    private String dados2 = "";//armazena opcao selecionada no grupo 2 de radios
    private String dados3 = "";//armazena opcao selecionada no grupo 3 de radios
    private String dadosTitulo = "";//guarda o que o user digitou no campo titulo
    private Conectar conectar;//classe para conectar ao mySQL
    private Connection conexao;//Conexao ao banco de dados
    // private InterfaceGrafica.Atualizar a;//classe para evento do botao atualizar
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
    private ImageIcon auxImagemSelecionada = new ImageIcon();
    private File file;
    private File file2;
    String tipo;
    PreVisualizaCabecalho preVisuCabecalho = new PreVisualizaCabecalho();

    public PainelNovoArquivo() {

        initComponents();
        DefineElaborador.setText("José Wilson da Costa");
        BotaoEnviaBrasao.setVisible(false);
        BotaoEnviaLogo.setVisible(false);
        LabelDataDaProva.setVisible(false);
        LabelDataDeRecebimento.setVisible(false);
        LabelDataDeEntrega.setVisible(false);
        jDateChooser1.setVisible(false);
        jDateChooser2.setVisible(false);
        jDateChooser3.setVisible(false);

        LabelMatricula.setVisible(false);
        DefineMatricula.setVisible(false);
        BotaoEnviaCarometro.setVisible(false);

        RadioPublica.setSelected(true);
        BotaoEnviaLogo.setVisible(true);
        BotaoEnviaBrasao.setVisible(true);

    }

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
                p.setDate(1, new java.sql.Date(jDateChooser1.getDate().getTime()));
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
                    p.setDate(2, new java.sql.Date(jDateChooser1.getDate().getTime()));
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
                    p.setDate(2, new java.sql.Date(jDateChooser2.getDate().getTime()));
                    p.setDate(3, new java.sql.Date(jDateChooser3.getDate().getTime()));
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
                        p.setDate(3, new java.sql.Date(jDateChooser2.getDate().getTime()));
                        p.setDate(4, new java.sql.Date(jDateChooser3.getDate().getTime()));
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
        //  dispose();
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
            jDateChooser2.setDate(dataSimples.parse(d));
            d = dataSimples.format(data.get(2));
            jDateChooser3.setDate(dataSimples.parse(d));
        } else {
            String d = dataSimples.format(data.get(0));
            jDateChooser1.setDate(dataSimples.parse(d));
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

    }

    public void insereDadosMySQL(String tabela, String colunas, boolean matricula, boolean data, boolean brasao2) throws IOException {
        status = true;
        ByteArrayOutputStream bytesImg = new ByteArrayOutputStream();
        ImageIO.write((BufferedImage) imagemRedimensionada, extensao, bytesImg);
        bytesImg.flush();
        byte[] logo = bytesImg.toByteArray();
        bytesImg.close();
        /**
         * Transforma a imagem do logotipo e brasao em um array de bytes para
         * enviar ao banco de dados
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
                    p.setDate(6, new java.sql.Date(jDateChooser1.getDate().getTime()));
                    p.setString(7, arquivo.getName());
                    p.setBytes(8, logo);
                    if (brasao2) {
                        p.setString(9, arquivo2.getName());
                        p.setBytes(10, brasao);
                    }
                } else {
                    p.setDate(6, new java.sql.Date(jDateChooser2.getDate().getTime()));
                    p.setDate(7, new java.sql.Date(jDateChooser3.getDate().getTime()));
                    p.setString(8, arquivo.getName());
                    p.setBytes(9, logo);
                    if (brasao2) {
                        p.setString(10, arquivo2.getName());
                        p.setBytes(11, brasao);
                    }
                }
            } else {
                if (data) {
                    p.setDate(5, new java.sql.Date(jDateChooser1.getDate().getTime()));
                    p.setString(6, arquivo.getName());
                    p.setBytes(7, logo);
                    if (brasao2) {
                        p.setString(8, arquivo2.getName());
                        p.setBytes(9, brasao);
                    }
                } else {
                    p.setDate(5, new java.sql.Date(jDateChooser2.getDate().getTime()));
                    p.setDate(6, new java.sql.Date(jDateChooser3.getDate().getTime()));
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

    public void geraWord() throws IOException, SQLException, InvalidFormatException {
        String titulo2 = JOptionPane.showInputDialog("Titulo: ");
        String matricula2 = JOptionPane.showInputDialog("Matricula: ");
        Statement teste = conexao.createStatement();

        ResultSet resultado = teste.executeQuery("SELECT * FROM dados WHERE titulo='" + titulo2 + "'");
        System.out.println(titulo2);
        String[] dados = new String[11];
        Blob foto = null;
        if (resultado.next()) {
            dados[11] = resultado.getString(1);
            dados[0] = resultado.getString(4);
            dados[1] = resultado.getString(5);
            dados[2] = String.format("%s", resultado.getDate(6));
            dados[3] = String.format("%s", resultado.getDate(7));
            dados[4] = String.format("%s", resultado.getDate(8));
            dados[5] = resultado.getString(13);
            dados[6] = resultado.getString(14);
            dados[7] = resultado.getString(15);
            dados[8] = resultado.getString(16);
            dados[9] = resultado.getString(17);
            dados[10] = resultado.getString(18);
        }
        Statement s2 = conexao.createStatement();
        ResultSet resultado2 = s2.executeQuery("SELECT * FROM fotos WHERE matricula='" + matricula2 + "'");
        ImageIcon imageIcon = null;
        String nomeArquivo = "";
        if (resultado2.next()) {
            nomeArquivo = resultado2.getString(1);
            foto = resultado2.getBlob(2);
            imageIcon = new ImageIcon(foto.getBytes(1, (int) foto.length()));
        }
        //  BufferedImage foto2 = new BufferedImage(imageIcon);
        BufferedImage foto2 = new BufferedImage(
                imageIcon.getIconWidth(),
                imageIcon.getIconHeight(),
                BufferedImage.TYPE_INT_RGB);
        Graphics g = foto2.createGraphics();
// paint the Icon to the BufferedImage.
        imageIcon.paintIcon(null, g, 0, 0);
        g.dispose();

        XWPFDocument document = new XWPFDocument();
        CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
        CTPageMar pageMar = sectPr.addNewPgMar();
        pageMar.setLeft(BigInteger.valueOf(500));
        pageMar.setTop(BigInteger.valueOf(100));
        pageMar.setRight(BigInteger.valueOf(500));
        pageMar.setBottom(BigInteger.valueOf(100));
        //   File f = new File("ALICE_COSTA 201511130024.jpg");
        //  BufferedImage i = ImageIO.read(f);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(foto2, "jpg", os);
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
            p.addPicture(is, Document.PICTURE_TYPE_JPEG, nomeArquivo, Units.toEMU(60), Units.toEMU(60));
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
        matriculaR.setText(dados[1]);
        matriculaR.setFontSize(12);
        matriculaR.setColor("000000");

        XWPFParagraph titulo = document.createParagraph();
        titulo.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun tituloR = titulo.createRun();
        tituloR.setFontSize(12);
        tituloR.setFontFamily("Arial");
        tituloR.setColor("000000");
        titulo.setSpacingAfterLines(100);

        tituloR.setText(dados[0]);
        tituloR.addBreak();
        tituloR.setText(dados[11]);
        tituloR.addBreak();

        XWPFParagraph paragraphThree = document.createParagraph();
        paragraphThree.setAlignment(ParagraphAlignment.NUM_TAB);
        XWPFRun paragraphThreeRunOne = paragraphThree.createRun();
        paragraphThreeRunOne.setFontSize(12);
        paragraphThreeRunOne.setFontFamily("Arial");
        paragraphThreeRunOne.setColor("000000");
        paragraphThreeRunOne.setText("Professor (A): ");
        paragraphThreeRunOne.setText(dados[6]);
        int aux = dados[6].length() / 6;//prof
        int aux2 = dados[5].length() / 6;//aluno
        int primeiroTab = 10;
        int segundoTab = 11;
        if (dados[6].length() % 6 == dados[6].length()) {
            aux = 1;
            if (dados[6].length() <= 5) {
                aux--;
            }
        }
        if (dados[5].length() % 6 == dados[5].length()) {
            aux2 = 1;
            if (dados[5].length() <= 5) {
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
        paragraphThreeRunOne.setText(dados[9]);

        XWPFParagraph paragrafo2 = document.createParagraph();
        paragrafo2.setAlignment(ParagraphAlignment.LEFT);

        XWPFRun paragrafo2R = paragrafo2.createRun();
        paragrafo2R.setFontFamily("Arial");
        paragrafo2R.setFontSize(12);
        paragrafo2R.setText("Aluno (a): ");
        paragrafo2R.setText(dados[5]);
        for (int j = 0; j <= aux2; j++) {
            System.out.println(j);
            paragrafo2R.addTab();
        }
        paragrafo2R.setText("Data: ");
        paragrafo2R.setText(dados[2]);
        XWPFParagraph paragrafo3 = document.createParagraph();
        paragrafo2.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun paragrafo3R = paragrafo3.createRun();
        paragrafo3R.setFontFamily("Arial");
        paragrafo3R.setFontSize(12);
        for (int j = 0; j < 13; j++) {//System.out.println(j);
            paragrafo3R.addTab();
        }
        paragrafo3R.setText("Valor: ");
        paragrafo3R.setText(dados[8]);

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        LabelQuantidadeDeAlunos = new javax.swing.JLabel();
        RadioIndividual = new javax.swing.JRadioButton();
        RadioTurma = new javax.swing.JRadioButton();
        RadioGrupo = new javax.swing.JRadioButton();
        LabelTipoDeTeste = new javax.swing.JLabel();
        RadioProva = new javax.swing.JRadioButton();
        RadioTrabalho = new javax.swing.JRadioButton();
        Labelvalor = new javax.swing.JLabel();
        DefineValorProva = new javax.swing.JSpinner();
        LabelTitulo = new javax.swing.JLabel();
        DefineTitulo = new javax.swing.JTextField();
        LabelFormularioDeInformacoes = new javax.swing.JLabel();
        LabelNumDeQuestoes = new javax.swing.JLabel();
        DefineNumDeQuestoes = new javax.swing.JSpinner();
        LabelTurno = new javax.swing.JLabel();
        DefineTurno = new javax.swing.JComboBox<>();
        LabelTurmas = new javax.swing.JLabel();
        DefineTurmas = new javax.swing.JTextField();
        LabelElaborador = new javax.swing.JLabel();
        DefineInstituicao = new javax.swing.JTextField();
        LabelInstituicao = new javax.swing.JLabel();
        DefineElaborador = new javax.swing.JTextField();
        LabelTipoDeInstituicao = new javax.swing.JLabel();
        RadioPublica = new javax.swing.JRadioButton();
        RadioPrivada = new javax.swing.JRadioButton();
        BotaoEnvia = new javax.swing.JButton();
        PainelDatas = new javax.swing.JPanel();
        LabelDataDaProva = new javax.swing.JLabel();
        LabelDataDeRecebimento = new javax.swing.JLabel();
        LabelDataDeEntrega = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        LabelMatricula = new javax.swing.JLabel();
        DefineMatricula = new javax.swing.JTextField();
        BotaoEnviaCarometro = new javax.swing.JButton();
        BotaoEnviaLogo = new javax.swing.JButton();
        BotaoEnviaBrasao = new javax.swing.JButton();
        LabelMostraLogo = new javax.swing.JLabel();
        LabelMostraBrasao = new javax.swing.JLabel();
        LabelMostraCarometro = new javax.swing.JLabel();
        DefineDuracao = new javax.swing.JSpinner();
        LabelDuracao = new javax.swing.JLabel();
        LabelMinutos = new javax.swing.JLabel();
        LabelPontos = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1024, 516));
        setMinimumSize(new java.awt.Dimension(1024, 516));
        setPreferredSize(new java.awt.Dimension(1024, 516));
        setLayout(null);

        LabelQuantidadeDeAlunos.setForeground(new java.awt.Color(102, 102, 102));
        LabelQuantidadeDeAlunos.setText("Quantidade de alunos:");
        add(LabelQuantidadeDeAlunos);
        LabelQuantidadeDeAlunos.setBounds(10, 67, 109, 14);

        RadioIndividual.setBackground(new java.awt.Color(255, 255, 255));
        RadioIndividual.setText("Individual");
        RadioIndividual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioIndividualActionPerformed(evt);
            }
        });
        add(RadioIndividual);
        RadioIndividual.setBounds(10, 83, 71, 23);

        RadioTurma.setBackground(new java.awt.Color(255, 255, 255));
        RadioTurma.setText("Turma");
        RadioTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioTurmaActionPerformed(evt);
            }
        });
        add(RadioTurma);
        RadioTurma.setBounds(83, 83, 55, 23);

        RadioGrupo.setBackground(new java.awt.Color(255, 255, 255));
        RadioGrupo.setText("Grupo");
        RadioGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioGrupoActionPerformed(evt);
            }
        });
        add(RadioGrupo);
        RadioGrupo.setBounds(140, 83, 55, 23);

        LabelTipoDeTeste.setForeground(new java.awt.Color(102, 102, 102));
        LabelTipoDeTeste.setText("Tipo:");
        add(LabelTipoDeTeste);
        LabelTipoDeTeste.setBounds(10, 113, 24, 14);

        RadioProva.setBackground(new java.awt.Color(255, 255, 255));
        RadioProva.setText("Prova");
        RadioProva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioProvaActionPerformed(evt);
            }
        });
        add(RadioProva);
        RadioProva.setBounds(10, 133, 53, 23);

        RadioTrabalho.setBackground(new java.awt.Color(255, 255, 255));
        RadioTrabalho.setText("Trabalho");
        RadioTrabalho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioTrabalhoActionPerformed(evt);
            }
        });
        add(RadioTrabalho);
        RadioTrabalho.setBounds(65, 133, 67, 23);

        Labelvalor.setForeground(new java.awt.Color(102, 102, 102));
        Labelvalor.setText("Valor:");
        add(Labelvalor);
        Labelvalor.setBounds(10, 182, 28, 14);
        add(DefineValorProva);
        DefineValorProva.setBounds(10, 208, 42, 28);

        LabelTitulo.setForeground(new java.awt.Color(102, 102, 102));
        LabelTitulo.setText("Título:");
        add(LabelTitulo);
        LabelTitulo.setBounds(10, 246, 30, 14);

        DefineTitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add(DefineTitulo);
        DefineTitulo.setBounds(10, 266, 403, 38);

        LabelFormularioDeInformacoes.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LabelFormularioDeInformacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelFormularioDeInformacoes.setText("Formulário de informações");
        add(LabelFormularioDeInformacoes);
        LabelFormularioDeInformacoes.setBounds(0, 20, 856, 29);

        LabelNumDeQuestoes.setForeground(new java.awt.Color(102, 102, 102));
        LabelNumDeQuestoes.setText("Nº de questões:");
        add(LabelNumDeQuestoes);
        LabelNumDeQuestoes.setBounds(10, 320, 78, 14);
        add(DefineNumDeQuestoes);
        DefineNumDeQuestoes.setBounds(10, 340, 42, 28);

        LabelTurno.setForeground(new java.awt.Color(102, 102, 102));
        LabelTurno.setText("Turno:");
        add(LabelTurno);
        LabelTurno.setBounds(10, 381, 32, 14);

        DefineTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manhã", "Tarde", "Noite" }));
        add(DefineTurno);
        DefineTurno.setBounds(10, 401, 57, 20);

        LabelTurmas.setForeground(new java.awt.Color(102, 102, 102));
        LabelTurmas.setText("Turmas:");
        add(LabelTurmas);
        LabelTurmas.setBounds(10, 433, 39, 14);

        DefineTurmas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add(DefineTurmas);
        DefineTurmas.setBounds(10, 454, 403, 38);

        LabelElaborador.setForeground(new java.awt.Color(102, 102, 102));
        LabelElaborador.setText("Elaborador:");
        add(LabelElaborador);
        LabelElaborador.setBounds(430, 70, 56, 14);

        DefineInstituicao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add(DefineInstituicao);
        DefineInstituicao.setBounds(430, 160, 403, 38);

        LabelInstituicao.setForeground(new java.awt.Color(102, 102, 102));
        LabelInstituicao.setText("Nome da instituição:");
        add(LabelInstituicao);
        LabelInstituicao.setBounds(430, 140, 97, 14);

        DefineElaborador.setEditable(false);
        DefineElaborador.setBackground(new java.awt.Color(255, 255, 255));
        DefineElaborador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add(DefineElaborador);
        DefineElaborador.setBounds(430, 90, 403, 38);

        LabelTipoDeInstituicao.setForeground(new java.awt.Color(102, 102, 102));
        LabelTipoDeInstituicao.setText("Tipo de instituição:");
        add(LabelTipoDeInstituicao);
        LabelTipoDeInstituicao.setBounds(430, 210, 90, 14);

        RadioPublica.setBackground(new java.awt.Color(255, 255, 255));
        RadioPublica.setText("Pública");
        RadioPublica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioPublicaActionPerformed(evt);
            }
        });
        add(RadioPublica);
        RadioPublica.setBounds(430, 230, 59, 23);

        RadioPrivada.setBackground(new java.awt.Color(255, 255, 255));
        RadioPrivada.setText("Privada");
        RadioPrivada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioPrivadaActionPerformed(evt);
            }
        });
        add(RadioPrivada);
        RadioPrivada.setBounds(490, 230, 61, 23);

        BotaoEnvia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modeloDeProvas/Envia.PNG"))); // NOI18N
        BotaoEnvia.setBorderPainted(false);
        BotaoEnvia.setContentAreaFilled(false);
        BotaoEnvia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEnviaActionPerformed(evt);
            }
        });
        add(BotaoEnvia);
        BotaoEnvia.setBounds(690, 470, 150, 40);

        PainelDatas.setBackground(new java.awt.Color(255, 255, 255));
        PainelDatas.setLayout(null);

        LabelDataDaProva.setForeground(new java.awt.Color(102, 102, 102));
        LabelDataDaProva.setText("Data da prova:");
        PainelDatas.add(LabelDataDaProva);
        LabelDataDaProva.setBounds(40, 10, 80, 20);

        LabelDataDeRecebimento.setForeground(new java.awt.Color(102, 102, 102));
        LabelDataDeRecebimento.setText("Data de recebimento do trabalho:");
        PainelDatas.add(LabelDataDeRecebimento);
        LabelDataDeRecebimento.setBounds(10, 10, 170, 14);

        LabelDataDeEntrega.setForeground(new java.awt.Color(102, 102, 102));
        LabelDataDeEntrega.setText("Data de entrega do trabalho:");
        PainelDatas.add(LabelDataDeEntrega);
        LabelDataDeEntrega.setBounds(10, 70, 170, 14);
        PainelDatas.add(jDateChooser1);
        jDateChooser1.setBounds(40, 30, 87, 20);
        PainelDatas.add(jDateChooser2);
        jDateChooser2.setBounds(40, 30, 87, 20);
        PainelDatas.add(jDateChooser3);
        jDateChooser3.setBounds(40, 90, 87, 20);

        add(PainelDatas);
        PainelDatas.setBounds(138, 113, 275, 127);

        LabelMatricula.setForeground(new java.awt.Color(102, 102, 102));
        LabelMatricula.setText("Matrícula:");
        add(LabelMatricula);
        LabelMatricula.setBounds(440, 400, 60, 20);

        DefineMatricula.setEditable(false);
        DefineMatricula.setBackground(new java.awt.Color(255, 255, 255));
        DefineMatricula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add(DefineMatricula);
        DefineMatricula.setBounds(440, 420, 403, 38);

        BotaoEnviaCarometro.setText("Envia Foto do aluno");
        BotaoEnviaCarometro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEnviaCarometroActionPerformed(evt);
            }
        });
        add(BotaoEnviaCarometro);
        BotaoEnviaCarometro.setBounds(720, 270, 140, 23);

        BotaoEnviaLogo.setText("Envia logo");
        BotaoEnviaLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEnviaLogoActionPerformed(evt);
            }
        });
        add(BotaoEnviaLogo);
        BotaoEnviaLogo.setBounds(430, 270, 115, 23);

        BotaoEnviaBrasao.setText("Envia Brasão");
        BotaoEnviaBrasao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEnviaBrasaoActionPerformed(evt);
            }
        });
        add(BotaoEnviaBrasao);
        BotaoEnviaBrasao.setBounds(570, 270, 115, 23);
        add(LabelMostraLogo);
        LabelMostraLogo.setBounds(440, 300, 100, 90);
        add(LabelMostraBrasao);
        LabelMostraBrasao.setBounds(580, 300, 100, 90);
        add(LabelMostraCarometro);
        LabelMostraCarometro.setBounds(740, 300, 100, 90);
        add(DefineDuracao);
        DefineDuracao.setBounds(140, 340, 42, 28);

        LabelDuracao.setForeground(new java.awt.Color(102, 102, 102));
        LabelDuracao.setText("Duração:");
        add(LabelDuracao);
        LabelDuracao.setBounds(140, 320, 50, 10);

        LabelMinutos.setForeground(new java.awt.Color(102, 102, 102));
        LabelMinutos.setText("minutos");
        add(LabelMinutos);
        LabelMinutos.setBounds(190, 350, 78, 14);

        LabelPontos.setForeground(new java.awt.Color(102, 102, 102));
        LabelPontos.setText("pontos");
        add(LabelPontos);
        LabelPontos.setBounds(60, 220, 33, 14);
    }// </editor-fold>//GEN-END:initComponents

    private void RadioIndividualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioIndividualActionPerformed
        RadioTurma.setSelected(false);
        RadioGrupo.setSelected(false);

        LabelMatricula.setVisible(true);
        DefineMatricula.setVisible(true);
        BotaoEnviaCarometro.setVisible(true);
        LabelMostraCarometro.setVisible(true);
    }//GEN-LAST:event_RadioIndividualActionPerformed

    private void BotaoEnviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEnviaActionPerformed
        Documento d = new Documento();
        String[] dados = new String[9];
        dados[1] = DefineElaborador.getText();
        dados[2] = DefineTurmas.getText();
        dados[3] = (String) DefineTurno.getSelectedItem();
        dados[4] = DefineInstituicao.getText();
        SimpleDateFormat dataSimples2 = new SimpleDateFormat("dd/MM/yyyy");
        String data2 = dataSimples2.format(jDateChooser1.getDate());
        dados[5] = data2;
        dados[6] = String.format("%s", (int) DefineValorProva.getValue());
        dados[7] = String.format("%s", (int) DefineNumDeQuestoes.getValue());
        dados[8] = String.format("%s", (int) DefineDuracao.getValue());
        String nome = "";
        ImageIcon foto = null;
        if (RadioIndividual.isSelected() == true) {
            preVisuCabecalho.setMatricula(DefineMatricula.getText());

            for (int i = 0; i < SelectAluno.aluno.length; i++) {
                if (SelectAluno.aluno[i].getAuxEscolhido() > 0) {
                    preVisuCabecalho.setCarometro(SelectAluno.aluno[i].getFoto());
                    preVisuCabecalho.setNomeAluno(SelectAluno.aluno[i].getNome().replace("_", " "));
                    dados[0] = SelectAluno.aluno[i].getNome().replace("_", " ");
                    nome = SelectAluno.aluno[i].getNome() + " " + DefineMatricula.getText();
                    foto = SelectAluno.aluno[i].getFoto();
                }
            }
        } else {
            preVisuCabecalho.setCarometro(new ImageIcon("avatar.jpg"));
            preVisuCabecalho.setMatricula("201511130202");
            preVisuCabecalho.setNomeAluno("\"Nome do aluno\"");
        }

        if (tipo.equals("Prova")) {
            SimpleDateFormat dataSimples = new SimpleDateFormat("dd/MM/yyyy");
            String data = dataSimples.format(jDateChooser1.getDate());
            preVisuCabecalho.setDataProva(data);
        } else {
            SimpleDateFormat dataSimples = new SimpleDateFormat("dd/MM/yyyy");
            String data = dataSimples.format(jDateChooser2.getDate());
            preVisuCabecalho.setDataRecebimento(data);

            data = dataSimples.format(jDateChooser3.getDate());
            preVisuCabecalho.setDataEntrega(data);
        }

        preVisuCabecalho.setNomeProvaOuTrabalho(DefineTitulo.getText());
        preVisuCabecalho.setValor(DefineValorProva.getValue().toString());
        preVisuCabecalho.setTurma(DefineTurmas.getText());
        preVisuCabecalho.setNomeProfessor(DefineElaborador.getText());
        preVisuCabecalho.setTurno(DefineTurno.getSelectedItem().toString());
        preVisuCabecalho.setNomeInstituicao(DefineInstituicao.getText());
        preVisuCabecalho.setNumeroDeQuestoes(DefineNumDeQuestoes.getValue().toString());
        preVisuCabecalho.setNomeProfessor("José Wilson");
        preVisuCabecalho.setDuracao(DefineDuracao.getValue().toString());
        contadorBrasao--;
        preVisuCabecalho.setBrasao(new ImageIcon("Brasao" + contadorBrasao + ".jpg"));
        contadorLogo--;
        preVisuCabecalho.setLogo(new ImageIcon("Logo" + contadorLogo + ".jpg"));
        try {
            //   ImageIcon logo = new ImageIcon("Logo" + contadorLogo + ".jpg");
            //     ImageIcon brasao = new ImageIcon("Brasao" + contadorBrasao + ".jpg");
            d.gerarCabecalhoProva(DefineTitulo.getText(), dados, foto, file, file2, nome);
            /*BancoDeDados.Conexao bd;
            bd = new Conexao();
            bd.conectar("cefet-inf-2015.ddns.net:43306", "modelo", "inf2015", "Modelos");
            String colunas2 = "titulo,tipo,modalidade,escola,dataProva,nomeLogotipo,nomeBrasao"
                    + ",nomeAluno,nomeProfessor,numeroQuestoes,valor,turma,turno,nomeEscola,duracao";
            System.out.println("INSERT INTO dados (" + colunas2 + ") VALUES (\'" + DefineTitulo.getText() + "',\'" + "Prova" + "',\'" + "Individual" + "',\'" + "Publica" + "',\'"
                    + new java.sql.Date(jDateChooser1.getDate().getTime()) + "',\'" + file.getName()
                    + "',\'" + file2.getName() + "',\'" + nome.split(" ")[0] + "',\'"
                    + dados[1] + "',\'" + dados[8] + "',\'" + dados[7] + "',\'" + dados[2] + "',\'" + dados[3] + "',\'" + dados[4] + "',\'" + dados[6]
                    + "')");
            System.out.println("oi");
            bd.enviarQuery("INSERT INTO dados (" + colunas2 + ") VALUES (\'" + DefineTitulo.getText() + "',\'" + "Prova" + "',\'" + "Individual" + "',\'" + "Publica" + "',\'"
                    + new java.sql.Date(jDateChooser1.getDate().getTime()) + "',\'" + file.getName()
                    + "',\'" + file2.getName() + "',\'" + nome.split(" ")[0] + "',\'"
                    + dados[1] + "',\'" + dados[8] + "',\'" + dados[7] + "',\'" + dados[2] + "',\'" + dados[3] + "',\'" + dados[4] + "',\'" + dados[6]
                    + "')");
*/
        } catch (InvalidFormatException | IOException | SQLException ex) {
            Logger.getLogger(PainelNovoArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
//        d.gerarProva(DefineTitulo.getText(), dados,foto,file,file2);
        preVisuCabecalho.desenha();

        EscondeOuMostraComponentes(false);

        painelGerado.setBounds(getBounds());
        preVisuCabecalho.setBounds(0, 0, painelGerado.PainelPrevisu.getWidth(), painelGerado.PainelPrevisu.getHeight());
        painelGerado.PainelPrevisu.add(preVisuCabecalho);
        painelGerado.PainelPrevisu.repaint();
        painelGerado.PainelPrevisu.revalidate();
        painelGerado.revalidate();
        painelGerado.repaint();
        add(painelGerado);
        revalidate();
        repaint();
    }//GEN-LAST:event_BotaoEnviaActionPerformed

    private void RadioPublicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioPublicaActionPerformed
        BotaoEnviaBrasao.setVisible(true);
        BotaoEnviaLogo.setVisible(true);
        RadioPrivada.setSelected(false);
    }//GEN-LAST:event_RadioPublicaActionPerformed

    private void RadioPrivadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioPrivadaActionPerformed
        BotaoEnviaLogo.setVisible(true);
        BotaoEnviaBrasao.setVisible(false);
        RadioPublica.setSelected(false);
    }//GEN-LAST:event_RadioPrivadaActionPerformed

    private void RadioProvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioProvaActionPerformed
        LabelDataDeRecebimento.setVisible(false);
        LabelDataDeEntrega.setVisible(false);
        jDateChooser2.setVisible(false);
        jDateChooser3.setVisible(false);
        RadioTrabalho.setSelected(false);
        LabelDataDaProva.setVisible(true);
        jDateChooser1.setVisible(true);

        tipo = "Prova";
        preVisuCabecalho.setTipo(tipo);
    }//GEN-LAST:event_RadioProvaActionPerformed

    private void RadioTrabalhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioTrabalhoActionPerformed
        LabelDataDeRecebimento.setVisible(true);
        LabelDataDeEntrega.setVisible(true);
        jDateChooser2.setVisible(true);
        jDateChooser3.setVisible(true);
        RadioProva.setSelected(false);
        LabelDataDaProva.setVisible(false);
        jDateChooser1.setVisible(false);

        tipo = "Trabalho";
        preVisuCabecalho.setTipo(tipo);
    }//GEN-LAST:event_RadioTrabalhoActionPerformed

    private void RadioTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioTurmaActionPerformed
        RadioIndividual.setSelected(false);
        RadioGrupo.setSelected(false);

        LabelMatricula.setVisible(false);
        DefineMatricula.setVisible(false);
        BotaoEnviaCarometro.setVisible(false);
        LabelMostraCarometro.setVisible(false);
    }//GEN-LAST:event_RadioTurmaActionPerformed

    private void RadioGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioGrupoActionPerformed
        RadioIndividual.setSelected(false);
        RadioTurma.setSelected(false);

        LabelMatricula.setVisible(false);
        DefineMatricula.setVisible(false);
        BotaoEnviaCarometro.setVisible(false);
        LabelMostraCarometro.setVisible(false);
    }//GEN-LAST:event_RadioGrupoActionPerformed

    private void BotaoEnviaCarometroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEnviaCarometroActionPerformed

        EscondeOuMostraComponentes(false);

        SelectAluno.setBounds(getBounds());
        add(SelectAluno);
        revalidate();
        SelectAluno.EscondeOuMostraComponentes(true);
        revalidate();
        repaint();

        for (int i = 0; i < SelectAluno.aluno.length; i++) {
            SelectAluno.aluno[i].addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    alunoSelecionado(evt);
                }
            });

            SelectAluno.aluno[i].LabelFoto.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    alunoSelecionado(evt);
                }
            });

            SelectAluno.aluno[i].setAuxEscolhido(0);

            SelectAluno.aluno[i].setBackground(new java.awt.Color(240, 240, 240));
        }
    }//GEN-LAST:event_BotaoEnviaCarometroActionPerformed

    private void BotaoEnviaLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEnviaLogoActionPerformed
        String caminho = null;
        String auxCaminho = null;
        LabelMostraLogo.setIcon(null);

        try {
            JFileChooser jFileChooser = new JFileChooser();
            int ok = jFileChooser.showOpenDialog(null);
            if (ok == JFileChooser.APPROVE_OPTION) {
                file = jFileChooser.getSelectedFile();
                auxCaminho = jFileChooser.getCurrentDirectory().getPath() + '/' + jFileChooser.getSelectedFile().getName(); // caminho do arquivo
                caminho = auxCaminho.replace('\\', '/');
            } else {
                jFileChooser.cancelSelection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        BufferedImage imagem = null;
        try {
            imagem = ImageIO.read(new File(caminho));
        } catch (IOException ex) {
            //Logger.getLogger(ImagePanel2.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedImage new_img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = new_img.createGraphics();
        g2.drawImage(imagem, 0, 0, 100, 100, null);
        try {
            ImageIO.write(new_img, "JPG", new File("Logo" + contadorLogo + ".jpg"));

        } catch (IOException ex) {
            Logger.getLogger(PainelNovoArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

        LabelMostraLogo.setIcon(new ImageIcon("Logo" + contadorLogo + ".jpg"));

        if (contadorLogo > 0) {
            contadorLogo--;
        }

        new File("Logo" + contadorLogo + ".jpg").delete();
        contadorLogo++;
    }//GEN-LAST:event_BotaoEnviaLogoActionPerformed

    private void BotaoEnviaBrasaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEnviaBrasaoActionPerformed
        String caminho = null;
        String auxCaminho = null;
        LabelMostraBrasao.setIcon(null);

        try {
            JFileChooser jFileChooser = new JFileChooser();
            int ok = jFileChooser.showOpenDialog(null);
            if (ok == JFileChooser.APPROVE_OPTION) {
                file2 = jFileChooser.getSelectedFile();
                auxCaminho = jFileChooser.getCurrentDirectory().getPath() + '/' + jFileChooser.getSelectedFile().getName(); // caminho do arquivo
                caminho = auxCaminho.replace('\\', '/');
            } else {
                jFileChooser.cancelSelection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        BufferedImage imagem = null;
        try {
            imagem = ImageIO.read(new File(caminho));
        } catch (IOException ex) {
            //Logger.getLogger(ImagePanel2.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedImage new_img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = new_img.createGraphics();
        g2.drawImage(imagem, 0, 0, 100, 100, null);
        try {
            ImageIO.write(new_img, "JPG", new File("Brasao" + contadorBrasao + ".jpg"));

        } catch (IOException ex) {
            Logger.getLogger(PainelNovoArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

        LabelMostraBrasao.setIcon(new ImageIcon("Brasao" + contadorBrasao + ".jpg"));

        if (contadorBrasao > 0) {
            contadorBrasao--;
        }

        new File("Brasao" + contadorBrasao + ".jpg").delete();
        contadorBrasao++;
    }//GEN-LAST:event_BotaoEnviaBrasaoActionPerformed

    public void alunoSelecionado(java.awt.event.MouseEvent evt) {
        remove(SelectAluno);
        revalidate();
        EscondeOuMostraComponentes(true);

        for (int i = 0; i < SelectAluno.aluno.length; i++) {
            if (SelectAluno.aluno[i].getAuxEscolhido() > 0) {
                DefineMatricula.setText(SelectAluno.aluno[i].getMatricula());
                LabelMostraCarometro.setIcon(SelectAluno.aluno[i].getFoto());
            }
        }

        revalidate();
        repaint();
    }

    public void EscondeOuMostraComponentes(boolean define) {
        LabelFormularioDeInformacoes.setVisible(define);
        LabelQuantidadeDeAlunos.setVisible(define);
        RadioIndividual.setVisible(define);
        RadioTurma.setVisible(define);
        RadioGrupo.setVisible(define);
        LabelTipoDeTeste.setVisible(define);
        RadioProva.setVisible(define);
        RadioTrabalho.setVisible(define);
        if (RadioProva.isSelected()) {
            LabelDataDaProva.setVisible(define);
        }
        if (RadioTrabalho.isSelected()) {
            LabelDataDeRecebimento.setVisible(define);
        }
        if (RadioProva.isSelected() || RadioTrabalho.isSelected()) {
            jDateChooser1.setVisible(define);
        }
        if (RadioTrabalho.isSelected()) {
            jDateChooser3.setVisible(define);
        }
        if (RadioTrabalho.isSelected()) {
            LabelDataDeEntrega.setVisible(define);
        }
        PainelDatas.setVisible(define);
        Labelvalor.setVisible(define);
        DefineValorProva.setVisible(define);
        LabelTitulo.setVisible(define);
        DefineTitulo.setVisible(define);
        LabelNumDeQuestoes.setVisible(define);
        DefineNumDeQuestoes.setVisible(define);
        LabelTurno.setVisible(define);
        DefineTurno.setVisible(define);
        LabelTurmas.setVisible(define);
        DefineTurmas.setVisible(define);
        LabelElaborador.setVisible(define);
        DefineElaborador.setVisible(define);
        LabelInstituicao.setVisible(define);
        DefineInstituicao.setVisible(define);
        LabelTipoDeInstituicao.setVisible(define);
        RadioPublica.setVisible(define);
        RadioPrivada.setVisible(define);
        BotaoEnviaLogo.setVisible(define);
        BotaoEnviaBrasao.setVisible(define);
        BotaoEnviaCarometro.setVisible(define);
        LabelMostraLogo.setVisible(define);
        LabelMostraBrasao.setVisible(define);
        LabelMostraCarometro.setVisible(define);
        LabelMatricula.setVisible(define);
        DefineMatricula.setVisible(define);
        BotaoEnvia.setVisible(define);
        DefineDuracao.setVisible(define);
        LabelDuracao.setVisible(define);
        LabelMinutos.setVisible(define);
        LabelPontos.setVisible(define);
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
                painel.removeAll();
                grupo1.clearSelection();
                grupo2.clearSelection();
                grupo3.clearSelection();
                matricula.setText(exemplo2);
                jDateChooser1.setDate(null);
                jDateChooser2.setDate(null);
                jDateChooser3.setDate(null);
                framePrincipal.dispose();
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
                } else {
                    if (e.getSource() == botao[2]) {

                    }
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
                            if (jDateChooser1.getDate() != null) {
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

                                if (jDateChooser2.getDate() != null) {
                                    if (jDateChooser3.getDate() != null) {
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
                            if (jDateChooser1.getDate() != null) {
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
                                if (jDateChooser2.getDate() != null) {
                                    if (jDateChooser3.getDate() != null) {
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
                                if (jDateChooser1.getDate() != null) {
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
                                    if (jDateChooser2.getDate() != null) {
                                        if (jDateChooser3.getDate() != null) {
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

                    status = false;
                }
            } else {
                if (e.getSource() == enviaDados && atualiza) {

                    try {
                        if (dados.equals(prova.getText())) {
                            if (jDateChooser1.getDate() != null) {
                                if (dados2.equals(individualUnico.getText())) {
                                    if (!matricula.getText().equals(exemplo2) || !matricula.getText().equals("")) {
                                        alteraDadosMySQL();

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

                                if (jDateChooser2.getDate() != null) {
                                    if (jDateChooser3.getDate() != null) {
                                        alteraDadosMySQL();

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

    private class Upload implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            File arq = null;
            if (e.getSource() == BotaoEnviaLogo || e.getSource() == BotaoEnviaBrasao) {

                jFileChooser1.showOpenDialog(null);
                if (e.getSource() == BotaoEnviaLogo) {
                    arquivo = jFileChooser1.getSelectedFile();
                    arq = arquivo;
                } else {
                    if (e.getSource() == BotaoEnviaBrasao) {
                        arquivo2 = jFileChooser1.getSelectedFile();
                        arq = arquivo2;
                    }
                }
                if (arq.length() > 16777216) {
                    JOptionPane.showMessageDialog(null, "Tamanho Maximo: 16MB");
                    return;
                }

                try {
                    imagem = ImageIO.read(arq);

                    if (e.getSource() == BotaoEnviaLogo) {
                        envio[0] = true;
                        extensao = arq.getName().substring(arq.getName().lastIndexOf("."), arq.getName().length());
                        extensao = extensao.replace(".", "");
                    } else {
                        if (e.getSource() == BotaoEnviaBrasao) {
                            System.out.println("OLA FDP");
                            envio[1] = true;
                            extensao2 = arq.getName().substring(arq.getName().lastIndexOf("."), arq.getName().length());
                            extensao2 = extensao2.replace(".", "");
                        }
                    }
                    // System.out.println(extensao);
                    if (e.getSource() == BotaoEnviaLogo) {
                        imagemRedimensionada = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
                        Graphics2D g = imagemRedimensionada.createGraphics();
                        g.drawImage(imagem, 0, 0, 100, 100, null);
                        g.dispose();

                        icone = new ImageIcon(imagemRedimensionada);
                    } else {
                        if (e.getSource() == BotaoEnviaBrasao) {
                            imagemRedimensionada2 = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
                            Graphics2D g = imagemRedimensionada2.createGraphics();
                            g.drawImage(imagem, 0, 0, 100, 100, null);
                            g.dispose();
                            /**
                             * "Desenha a imagem novamente" porem no tamanho de
                             * 100x100
                             */
                            icone = new ImageIcon(imagemRedimensionada2);
                        }
                    }
                    if (e.getSource() == BotaoEnviaBrasao) {
                        LabelMostraBrasao.setIcon(icone);
                        painel.add(LabelMostraBrasao);
                    } else {
                        LabelMostraLogo.setIcon(icone);
                    }
                    repaint();
                    revalidate();
                } catch (IOException e1) {
                    System.out.println(e1.getMessage());
                    System.out.println("catch 5");
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoEnvia;
    private javax.swing.JButton BotaoEnviaBrasao;
    private javax.swing.JButton BotaoEnviaCarometro;
    private javax.swing.JButton BotaoEnviaLogo;
    private javax.swing.JSpinner DefineDuracao;
    private javax.swing.JTextField DefineElaborador;
    private javax.swing.JTextField DefineInstituicao;
    private javax.swing.JTextField DefineMatricula;
    private javax.swing.JSpinner DefineNumDeQuestoes;
    private javax.swing.JTextField DefineTitulo;
    private javax.swing.JTextField DefineTurmas;
    private javax.swing.JComboBox<String> DefineTurno;
    private javax.swing.JSpinner DefineValorProva;
    private javax.swing.JLabel LabelDataDaProva;
    private javax.swing.JLabel LabelDataDeEntrega;
    private javax.swing.JLabel LabelDataDeRecebimento;
    private javax.swing.JLabel LabelDuracao;
    private javax.swing.JLabel LabelElaborador;
    private javax.swing.JLabel LabelFormularioDeInformacoes;
    private javax.swing.JLabel LabelInstituicao;
    private javax.swing.JLabel LabelMatricula;
    private javax.swing.JLabel LabelMinutos;
    private javax.swing.JLabel LabelMostraBrasao;
    private javax.swing.JLabel LabelMostraCarometro;
    private javax.swing.JLabel LabelMostraLogo;
    private javax.swing.JLabel LabelNumDeQuestoes;
    private javax.swing.JLabel LabelPontos;
    private javax.swing.JLabel LabelQuantidadeDeAlunos;
    private javax.swing.JLabel LabelTipoDeInstituicao;
    private javax.swing.JLabel LabelTipoDeTeste;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JLabel LabelTurmas;
    private javax.swing.JLabel LabelTurno;
    private javax.swing.JLabel Labelvalor;
    private javax.swing.JPanel PainelDatas;
    private javax.swing.JRadioButton RadioGrupo;
    private javax.swing.JRadioButton RadioIndividual;
    private javax.swing.JRadioButton RadioPrivada;
    private javax.swing.JRadioButton RadioProva;
    private javax.swing.JRadioButton RadioPublica;
    private javax.swing.JRadioButton RadioTrabalho;
    private javax.swing.JRadioButton RadioTurma;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables
}
