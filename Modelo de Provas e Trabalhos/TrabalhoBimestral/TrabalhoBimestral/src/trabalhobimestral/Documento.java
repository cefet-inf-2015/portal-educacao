package trabalhobimestral;

import BancoDeDados.Conexao;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import javax.imageio.ImageIO;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Documento {

  private XWPFDocument doc;
  private ArrayList enunciado;
  private ArrayList tipoQuestao;
  private ArrayList[] Questao;
  private ArrayList alternativa;
  private FileOutputStream out;
  private String diretorio;
  private String diretorioM;

  public Documento() {
    diretorio = "C:/carometro/";
    diretorioM = "C:/logotipo_brasao/";
    doc = new XWPFDocument();
    enunciado = new ArrayList();
    alternativa = new ArrayList();
    Questao = null;
    tipoQuestao = new ArrayList();
  }

  public void gerarProva(String titulo) {

    try {
      gerarCabecalhoProva(titulo);
    } catch (InvalidFormatException ex) {
      Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
    }
    adicionarQuestoes();
  }

  public void gerarTrabalho(String titulo) throws SQLException {
    try {
      gerarCabecalhoTrabalho(titulo);
    } catch (InvalidFormatException | IOException ex) {
      Logger.getLogger(Documento.class
              .getName()).log(Level.SEVERE, null, ex);
    }
  }

  public String[] mostraDadosMySQL_Local(String valor) throws SQLException {
    Conectar conectar = new Conectar();
    Connection conexao = conectar.conexao();
    String sql = "";
    if (valor.equals("")) {
      sql = "SELECT * FROM cabecalho";
    } else {
      sql = "SELECT * FROM cabecalho WHERE titulo='" + valor + "'";
    }
    Statement s = conexao.createStatement();

    ResultSet resultado = s.executeQuery(sql);
    // String[] dados = new String[8];

    String[] dados = new String[12];
    Date data = null;
    int valorProva = 0;
    int numeroQuestoes = 0;
    int duracao = 0;

    while (resultado.next()) {
      dados[0] = resultado.getString(10);
      dados[1] = resultado.getString(11);
      dados[2] = resultado.getString(14);
      dados[3] = resultado.getString(15);
      dados[4] = resultado.getString(16);
      data = resultado.getDate(5);
      valorProva = resultado.getInt(13);
      numeroQuestoes = resultado.getInt(12);
      duracao = resultado.getInt(17);
      dados[9] = resultado.getString(18);
      dados[10] = resultado.getString(8);
      dados[11] = resultado.getString(9);
    }
    dados[5] = String.format("%s", data);
    dados[6] = String.format("%s", valorProva);
    dados[7] = String.format("%s", numeroQuestoes);
    dados[8] = String.format("%s", duracao);
    return dados;
  }

  public String[] mostraDadosMySQL_Servidor(String valor) throws SQLException {
    Conectar conectar = new Conectar();
    Connection c = conectar.conexao();

    BancoDeDados.Conexao bd;
    bd = new Conexao();

    bd.conectar(
            "cefet-inf-2015.ddns.net:43306", "modelo", "inf2015", "Modelos");
    ResultSet resultado = bd.enviarQueryResultados("SELECT * FROM cabecalho WHERE titulo='" + valor + "'");
    String[] dados = new String[9];
    Date data = null;
    int valorProva = 0;
    int numeroQuestoes = 0;
    int duracao = 0;

    dados[0] = resultado.getString(10);
    dados[1] = resultado.getString(11);
    dados[2] = resultado.getString(14);
    dados[3] = resultado.getString(15);
    dados[4] = resultado.getString(16);
    data = resultado.getDate(5);
    valorProva = resultado.getInt(13);
    numeroQuestoes = resultado.getInt(12);
    duracao = resultado.getInt(17);
    dados[5] = String.format("%s", data);
    dados[6] = String.format("%s", valorProva);
    dados[7] = String.format("%s", numeroQuestoes);
    dados[8] = String.format("%s", duracao);
    dados[9] = resultado.getString(18);
    dados[10] = resultado.getString(8);
    dados[11] = resultado.getString(9);
    return dados;
  }

  public void gerarCabecalhoProva(String titulo) throws InvalidFormatException, IOException, SQLException {
    String dados[] = mostraDadosMySQL_Local(titulo);
    CTSectPr sectPr = doc.getDocument().getBody().addNewSectPr();
    CTPageMar pageMar = sectPr.addNewPgMar();
    pageMar.setLeft(BigInteger.valueOf(500));
    pageMar.setTop(BigInteger.valueOf(100));
    pageMar.setRight(BigInteger.valueOf(500));
    pageMar.setBottom(BigInteger.valueOf(100));

    File f = new File(diretorio + dados[9] + ".jpg");
    System.out.println(diretorio + dados[9] + ".jpg");
    out = new FileOutputStream(
            new File(f.getName().split("\\.")[0] + ".docx"));

    XWPFTable table = doc.createTable();
    XWPFTable table2 = doc.createTable();

    table.setCellMargins(200, 500, 0, 500);//top,esquerda,baixo,direita
    table2.setCellMargins(0, 500, 0, 500);//top,esquerda,baixo,direita

    BufferedImage foto = ImageIO.read(f);
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    ImageIO.write(foto, f.getName().split("\\.")[1], os);
    InputStream is = new ByteArrayInputStream(os.toByteArray());

    File f2 = new File(diretorioM + dados[10]);
    BufferedImage logo = ImageIO.read(f2);
    ByteArrayOutputStream os2 = new ByteArrayOutputStream();
    ImageIO.write(logo, f2.getName().split("\\.")[1], os2);
    InputStream is2 = new ByteArrayInputStream(os2.toByteArray());

    File f3 = new File(diretorioM + dados[11]);
    BufferedImage brasao = ImageIO.read(f3);
    ByteArrayOutputStream os3 = new ByteArrayOutputStream();
    ImageIO.write(brasao, f3.getName().split("\\.")[1], os3);
    InputStream is3 = new ByteArrayInputStream(os3.toByteArray());

    XWPFParagraph paragrafo = doc.createParagraph();
    paragrafo.setAlignment(ParagraphAlignment.CENTER);

    XWPFRun p = paragrafo.createRun();
    p.setFontFamily("Arial");
    p.setFontSize(12);
    p.setText("    ");
    p.addPicture(is, Document.PICTURE_TYPE_JPEG, f.getName(), Units.toEMU(60), Units.toEMU(60));
    p.addBreak();
    p.setText(f.getName().split(" ")[1].split("\\.")[0]);

    XWPFParagraph paragrafo2 = doc.createParagraph();
    paragrafo2.setAlignment(ParagraphAlignment.CENTER);
    paragrafo2.setSpacingAfter(200);
    XWPFRun p2 = paragrafo2.createRun();

    p2.addPicture(is2, Document.PICTURE_TYPE_GIF, f2.getName(), Units.toEMU(60), Units.toEMU(60));

    XWPFParagraph paragrafo3 = doc.createParagraph();
    paragrafo3.setAlignment(ParagraphAlignment.RIGHT);
    paragrafo3.setSpacingAfter(200);
    XWPFRun p3 = paragrafo3.createRun();

    p3.addPicture(is3, Document.PICTURE_TYPE_GIF, f3.getName(), Units.toEMU(60), Units.toEMU(60));

    XWPFParagraph paragrafo4 = doc.createParagraph();
    paragrafo4.setAlignment(ParagraphAlignment.LEFT);

    XWPFRun p4 = paragrafo4.createRun();
    p4.setFontFamily("Arial");
    p4.setFontSize(12);
    p4.setText("Aluno(a): " + dados[0]);

    XWPFParagraph paragrafo5 = doc.createParagraph();
    paragrafo5.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun p5 = paragrafo5.createRun();
    p5.setFontFamily("Arial");
    p5.setFontSize(12);
    p5.setText("Data: " + dados[5]);

    XWPFParagraph paragrafo6 = doc.createParagraph();
    paragrafo6.setAlignment(ParagraphAlignment.CENTER);
    XWPFRun p6 = paragrafo6.createRun();
    p6.setFontFamily("Arial");
    p6.setFontSize(12);
    p6.setText(dados[4]);
    p6.addBreak();
    p6.setText(titulo);

    XWPFParagraph paragrafo7 = doc.createParagraph();
    paragrafo7.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun p7 = paragrafo7.createRun();
    p7.setFontFamily("Arial");
    p7.setFontSize(12);
    p7.setText("Professor(a): " + dados[1]);

    XWPFParagraph paragrafo8 = doc.createParagraph();
    paragrafo8.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun p8 = paragrafo8.createRun();
    p8.setFontFamily("Arial");
    p8.setFontSize(12);
    p8.setText("Turma: " + dados[2]);

    XWPFParagraph paragrafo9 = doc.createParagraph();
    paragrafo9.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun p9 = paragrafo9.createRun();
    p9.setFontFamily("Arial");
    p9.setFontSize(12);

    p9.setText("Valor: " + dados[6] + "pts");

    XWPFParagraph paragrafo10 = doc.createParagraph();
    paragrafo10.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun p10 = paragrafo10.createRun();
    p10.setFontFamily("Arial");
    p10.setFontSize(12);
    p10.setText("Turno: " + dados[3]);

    XWPFParagraph paragrafo11 = doc.createParagraph();
    paragrafo11.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun p11 = paragrafo11.createRun();
    p11.setFontFamily("Arial");
    p11.setFontSize(12);

    p11.setText("Nº de Questões: " + dados[7]);

    XWPFParagraph paragrafo12 = doc.createParagraph();
    paragrafo12.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun p12 = paragrafo12.createRun();
    p12.setFontFamily("Arial");
    p12.setFontSize(12);
    p12.setText("Duração: " + dados[8] + "min");

    table.getCTTbl().getTblPr().unsetTblBorders();
    table.getCTTbl().addNewTblPr().addNewTblW().setW(BigInteger.valueOf(12000));
    table2.getCTTbl().getTblPr().unsetTblBorders();

    XWPFTableRow linha1 = table.getRow(0);
    linha1.getCell(0).setParagraph(paragrafo);
    linha1.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000));
    linha1.addNewTableCell();
    linha1.addNewTableCell();

    linha1.getCell(1).setParagraph(paragrafo2);
    linha1.getCell(2).setParagraph(paragrafo3);
    linha1.getCell(2).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000));

    XWPFTableRow primeiraLinha = table2.getRow(0);
    table2.createRow();
    table2.createRow();
    table2.createRow();
    table2.createRow();
    primeiraLinha.getCell(0).getCTTc().addNewTcPr();
    primeiraLinha.getCell(0).getCTTc().getTcPr().addNewGridSpan();
    primeiraLinha.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 3));
    primeiraLinha.getCell(0).setParagraph(paragrafo6);

    XWPFTableRow segundaLinha = table2.getRow(1);
    segundaLinha.addNewTableCell();
    segundaLinha.getCell(0).setParagraph(paragrafo4);

    segundaLinha.getCell(0).getCTTc().addNewTcPr();
    segundaLinha.getCell(0).getCTTc().getTcPr().addNewGridSpan();
    segundaLinha.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

    segundaLinha.getCell(1).setParagraph(paragrafo5);
    segundaLinha.getCell(1).getCTTc().addNewTcPr();
    segundaLinha.getCell(1).getCTTc().getTcPr().addNewGridSpan();
    segundaLinha.getCell(1).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

    XWPFTableRow terceiraLinha = table2.getRow(2);
    terceiraLinha.addNewTableCell();
    terceiraLinha.getCell(0).setParagraph(paragrafo7);

    terceiraLinha.getCell(0).getCTTc().addNewTcPr();
    terceiraLinha.getCell(0).getCTTc().getTcPr().addNewGridSpan();
    terceiraLinha.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

    terceiraLinha.getCell(1).setParagraph(paragrafo8);
    terceiraLinha.getCell(1).getCTTc().addNewTcPr();
    terceiraLinha.getCell(1).getCTTc().getTcPr().addNewGridSpan();
    terceiraLinha.getCell(1).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

    XWPFTableRow quartaLinha = table2.getRow(3);
    quartaLinha.addNewTableCell();
    quartaLinha.getCell(0).setParagraph(paragrafo9);

    quartaLinha.getCell(0).getCTTc().addNewTcPr();
    quartaLinha.getCell(0).getCTTc().getTcPr().addNewGridSpan();
    quartaLinha.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

    quartaLinha.getCell(1).setParagraph(paragrafo10);
    quartaLinha.getCell(1).getCTTc().addNewTcPr();
    quartaLinha.getCell(1).getCTTc().getTcPr().addNewGridSpan();
    quartaLinha.getCell(1).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

    XWPFTableRow quintaLinha = table2.getRow(4);
    quintaLinha.addNewTableCell();
    quintaLinha.getCell(0).setParagraph(paragrafo11);

    quintaLinha.getCell(0).getCTTc().addNewTcPr();
    quintaLinha.getCell(0).getCTTc().getTcPr().addNewGridSpan();
    quintaLinha.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

    quintaLinha.getCell(1).setParagraph(paragrafo12);
    quintaLinha.getCell(1).getCTTc().addNewTcPr();
    quintaLinha.getCell(1).getCTTc().getTcPr().addNewGridSpan();
    quintaLinha.getCell(1).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

    doc.removeBodyElement(doc.getPosOfParagraph(paragrafo));
    doc.removeBodyElement(doc.getPosOfParagraph(paragrafo2));
    doc.removeBodyElement(doc.getPosOfParagraph(paragrafo3));
    doc.removeBodyElement(doc.getPosOfParagraph(paragrafo4));
    doc.removeBodyElement(doc.getPosOfParagraph(paragrafo5));
    doc.removeBodyElement(doc.getPosOfParagraph(paragrafo6));
    doc.removeBodyElement(doc.getPosOfParagraph(paragrafo7));
    doc.removeBodyElement(doc.getPosOfParagraph(paragrafo8));
    doc.removeBodyElement(doc.getPosOfParagraph(paragrafo9));
    doc.removeBodyElement(doc.getPosOfParagraph(paragrafo10));
    doc.removeBodyElement(doc.getPosOfParagraph(paragrafo11));
    doc.removeBodyElement(doc.getPosOfParagraph(paragrafo12));
    XWPFParagraph pT = doc.createParagraph();

    XWPFRun rr = pT.createRun();

    rr.setText("______________________________________________________________________________________________________");

  }

  public void gerarCabecalhoProvaTurma(String titulo) throws FileNotFoundException, IOException, InvalidFormatException, SQLException {
    File arquivos[];
    File diretorio = new File("C:/carometro/");
    arquivos = diretorio.listFiles();

    for (int i = 0; i < arquivos.length; i++) {
      doc = new XWPFDocument();
      String dados[] = mostraDadosMySQL_Local(titulo);
      CTSectPr sectPr = doc.getDocument().getBody().addNewSectPr();
      CTPageMar pageMar = sectPr.addNewPgMar();
      pageMar.setLeft(BigInteger.valueOf(500));
      pageMar.setTop(BigInteger.valueOf(100));
      pageMar.setRight(BigInteger.valueOf(500));
      pageMar.setBottom(BigInteger.valueOf(100));

      File f = new File(this.diretorio + arquivos[i].getName());//System.out.println(f.getName());
      out = new FileOutputStream(
              new File(f.getName().split("\\.")[0] + ".docx"));

      XWPFTable table = doc.createTable();
      XWPFTable table2 = doc.createTable();

      table.setCellMargins(200, 500, 0, 500);//top,esquerda,baixo,direita
      table2.setCellMargins(0, 500, 0, 500);//top,esquerda,baixo,direita

      BufferedImage foto = ImageIO.read(f);
      System.out.println(f.toPath());
      ByteArrayOutputStream os = new ByteArrayOutputStream();
      ImageIO.write(foto, f.getName().split("\\.")[1], os);
      InputStream is = new ByteArrayInputStream(os.toByteArray());

      File f2 = new File(diretorioM + dados[10]);
      System.out.println("Logo = " + diretorioM + dados[10]);
      BufferedImage logo = ImageIO.read(f2);
      ByteArrayOutputStream os2 = new ByteArrayOutputStream();
      ImageIO.write(logo, f2.getName().split("\\.")[1], os2);
      InputStream is2 = new ByteArrayInputStream(os2.toByteArray());

      File f3 = new File(diretorioM + dados[11]);
      System.out.println("Bras = " + diretorioM + dados[11]);
      BufferedImage brasao = ImageIO.read(f3);
      ByteArrayOutputStream os3 = new ByteArrayOutputStream();
      ImageIO.write(brasao, f3.getName().split("\\.")[1], os3);
      InputStream is3 = new ByteArrayInputStream(os3.toByteArray());

      XWPFParagraph paragrafo = doc.createParagraph();
      paragrafo.setAlignment(ParagraphAlignment.CENTER);

      XWPFRun p = paragrafo.createRun();
      p.setFontFamily("Arial");
      p.setFontSize(12);
      p.setText("    ");
      p.addPicture(is, Document.PICTURE_TYPE_JPEG, f.getName(), Units.toEMU(60), Units.toEMU(60));
      p.addBreak();
      System.out.println(f.getName());
      p.setText(f.getName().split(" ")[1].split("\\.")[0]);

      XWPFParagraph paragrafo2 = doc.createParagraph();
      paragrafo2.setAlignment(ParagraphAlignment.CENTER);
      paragrafo2.setSpacingAfter(200);
      XWPFRun p2 = paragrafo2.createRun();

      p2.addPicture(is2, Document.PICTURE_TYPE_GIF, f2.getName(), Units.toEMU(60), Units.toEMU(60));

      XWPFParagraph paragrafo3 = doc.createParagraph();
      paragrafo3.setAlignment(ParagraphAlignment.RIGHT);
      paragrafo3.setSpacingAfter(200);
      XWPFRun p3 = paragrafo3.createRun();

      p3.addPicture(is3, Document.PICTURE_TYPE_GIF, f3.getName(), Units.toEMU(60), Units.toEMU(60));

      XWPFParagraph paragrafo4 = doc.createParagraph();
      paragrafo4.setAlignment(ParagraphAlignment.LEFT);

      XWPFRun p4 = paragrafo4.createRun();
      p4.setFontFamily("Arial");
      p4.setFontSize(12);
      p4.setText("Aluno(a): " + dados[0]);

      XWPFParagraph paragrafo5 = doc.createParagraph();
      paragrafo5.setAlignment(ParagraphAlignment.LEFT);
      XWPFRun p5 = paragrafo5.createRun();
      p5.setFontFamily("Arial");
      p5.setFontSize(12);
      p5.setText("Data: " + dados[5]);

      XWPFParagraph paragrafo6 = doc.createParagraph();
      paragrafo6.setAlignment(ParagraphAlignment.CENTER);
      XWPFRun p6 = paragrafo6.createRun();
      p6.setFontFamily("Arial");
      p6.setFontSize(12);
      p6.setText(dados[4]);
      p6.addBreak();
      p6.setText(titulo);

      XWPFParagraph paragrafo7 = doc.createParagraph();
      paragrafo7.setAlignment(ParagraphAlignment.LEFT);
      XWPFRun p7 = paragrafo7.createRun();
      p7.setFontFamily("Arial");
      p7.setFontSize(12);
      p7.setText("Professor(a): " + dados[1]);

      XWPFParagraph paragrafo8 = doc.createParagraph();
      paragrafo8.setAlignment(ParagraphAlignment.LEFT);
      XWPFRun p8 = paragrafo8.createRun();
      p8.setFontFamily("Arial");
      p8.setFontSize(12);
      p8.setText("Turma: " + dados[2]);

      XWPFParagraph paragrafo9 = doc.createParagraph();
      paragrafo9.setAlignment(ParagraphAlignment.LEFT);
      XWPFRun p9 = paragrafo9.createRun();
      p9.setFontFamily("Arial");
      p9.setFontSize(12);

      p9.setText("Valor: " + dados[6] + "pts");

      XWPFParagraph paragrafo10 = doc.createParagraph();
      paragrafo10.setAlignment(ParagraphAlignment.LEFT);
      XWPFRun p10 = paragrafo10.createRun();
      p10.setFontFamily("Arial");
      p10.setFontSize(12);
      p10.setText("Turno: " + dados[3]);

      XWPFParagraph paragrafo11 = doc.createParagraph();
      paragrafo11.setAlignment(ParagraphAlignment.LEFT);
      XWPFRun p11 = paragrafo11.createRun();
      p11.setFontFamily("Arial");
      p11.setFontSize(12);

      p11.setText("Nº de Questões: " + dados[7]);

      XWPFParagraph paragrafo12 = doc.createParagraph();
      paragrafo12.setAlignment(ParagraphAlignment.LEFT);
      XWPFRun p12 = paragrafo12.createRun();
      p12.setFontFamily("Arial");
      p12.setFontSize(12);
      p12.setText("Duração: " + dados[8] + "min");

      table.getCTTbl().getTblPr().unsetTblBorders();
      table.getCTTbl().addNewTblPr().addNewTblW().setW(BigInteger.valueOf(12000));
      table2.getCTTbl().getTblPr().unsetTblBorders();

      XWPFTableRow linha1 = table.getRow(0);
      linha1.getCell(0).setParagraph(paragrafo);
      linha1.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000));
      linha1.addNewTableCell();
      linha1.addNewTableCell();

      linha1.getCell(1).setParagraph(paragrafo2);
      linha1.getCell(2).setParagraph(paragrafo3);
      linha1.getCell(2).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000));

      XWPFTableRow primeiraLinha = table2.getRow(0);
      table2.createRow();
      table2.createRow();
      table2.createRow();
      table2.createRow();
      primeiraLinha.getCell(0).getCTTc().addNewTcPr();
      primeiraLinha.getCell(0).getCTTc().getTcPr().addNewGridSpan();
      primeiraLinha.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 3));
      primeiraLinha.getCell(0).setParagraph(paragrafo6);

      XWPFTableRow segundaLinha = table2.getRow(1);
      segundaLinha.addNewTableCell();
      segundaLinha.getCell(0).setParagraph(paragrafo4);

      segundaLinha.getCell(0).getCTTc().addNewTcPr();
      segundaLinha.getCell(0).getCTTc().getTcPr().addNewGridSpan();
      segundaLinha.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

      segundaLinha.getCell(1).setParagraph(paragrafo5);
      segundaLinha.getCell(1).getCTTc().addNewTcPr();
      segundaLinha.getCell(1).getCTTc().getTcPr().addNewGridSpan();
      segundaLinha.getCell(1).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

      XWPFTableRow terceiraLinha = table2.getRow(2);
      terceiraLinha.addNewTableCell();
      terceiraLinha.getCell(0).setParagraph(paragrafo7);

      terceiraLinha.getCell(0).getCTTc().addNewTcPr();
      terceiraLinha.getCell(0).getCTTc().getTcPr().addNewGridSpan();
      terceiraLinha.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

      terceiraLinha.getCell(1).setParagraph(paragrafo8);
      terceiraLinha.getCell(1).getCTTc().addNewTcPr();
      terceiraLinha.getCell(1).getCTTc().getTcPr().addNewGridSpan();
      terceiraLinha.getCell(1).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

      XWPFTableRow quartaLinha = table2.getRow(3);
      quartaLinha.addNewTableCell();
      quartaLinha.getCell(0).setParagraph(paragrafo9);

      quartaLinha.getCell(0).getCTTc().addNewTcPr();
      quartaLinha.getCell(0).getCTTc().getTcPr().addNewGridSpan();
      quartaLinha.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

      quartaLinha.getCell(1).setParagraph(paragrafo10);
      quartaLinha.getCell(1).getCTTc().addNewTcPr();
      quartaLinha.getCell(1).getCTTc().getTcPr().addNewGridSpan();
      quartaLinha.getCell(1).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

      XWPFTableRow quintaLinha = table2.getRow(4);
      quintaLinha.addNewTableCell();
      quintaLinha.getCell(0).setParagraph(paragrafo11);

      quintaLinha.getCell(0).getCTTc().addNewTcPr();
      quintaLinha.getCell(0).getCTTc().getTcPr().addNewGridSpan();
      quintaLinha.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

      quintaLinha.getCell(1).setParagraph(paragrafo12);
      quintaLinha.getCell(1).getCTTc().addNewTcPr();
      quintaLinha.getCell(1).getCTTc().getTcPr().addNewGridSpan();
      quintaLinha.getCell(1).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

      doc.removeBodyElement(doc.getPosOfParagraph(paragrafo));
      doc.removeBodyElement(doc.getPosOfParagraph(paragrafo2));
      doc.removeBodyElement(doc.getPosOfParagraph(paragrafo3));
      doc.removeBodyElement(doc.getPosOfParagraph(paragrafo4));
      doc.removeBodyElement(doc.getPosOfParagraph(paragrafo5));
      doc.removeBodyElement(doc.getPosOfParagraph(paragrafo6));
      doc.removeBodyElement(doc.getPosOfParagraph(paragrafo7));
      doc.removeBodyElement(doc.getPosOfParagraph(paragrafo8));
      doc.removeBodyElement(doc.getPosOfParagraph(paragrafo9));
      doc.removeBodyElement(doc.getPosOfParagraph(paragrafo10));
      doc.removeBodyElement(doc.getPosOfParagraph(paragrafo11));
      doc.removeBodyElement(doc.getPosOfParagraph(paragrafo12));
      XWPFParagraph pT = doc.createParagraph();

      XWPFRun rr = pT.createRun();

      rr.setText("______________________________________________________________________________________________________");
      adicionarQuestoes();
    }

  }

  public void gerarCabecalhoTrabalho(String titulo) throws InvalidFormatException, IOException, SQLException {

    CTSectPr sectPr = doc.getDocument().getBody().addNewSectPr();
    CTPageMar pageMar = sectPr.addNewPgMar();
    pageMar.setLeft(BigInteger.valueOf(500));
    pageMar.setTop(BigInteger.valueOf(100));
    pageMar.setRight(BigInteger.valueOf(500));
    pageMar.setBottom(BigInteger.valueOf(100));
    String[] dados = mostraDadosMySQL_Local(titulo);
    File f = new File(diretorio + dados[9] + ".jpg");
    System.out.println(diretorio + dados[9]);
    out = new FileOutputStream(new File(f.getName().split("\\.")[0] + "T.docx"));

    XWPFTable table = doc.createTable();
    XWPFTable table2 = doc.createTable();

    table.setCellMargins(200, 500, 0, 500);//top,esquerda,baixo,direita
    table2.setCellMargins(0, 500, 0, 500);//top,esquerda,baixo,direita

    BufferedImage foto = ImageIO.read(f);
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    ImageIO.write(foto, f.getName().split("\\.")[1], os);
    InputStream is = new ByteArrayInputStream(os.toByteArray());

    File f2 = new File(diretorioM + dados[10]);
    BufferedImage logo = ImageIO.read(f2);
    ByteArrayOutputStream os2 = new ByteArrayOutputStream();
    ImageIO.write(logo, f2.getName().split("\\.")[1], os2);
    InputStream is2 = new ByteArrayInputStream(os2.toByteArray());

    File f3 = new File(diretorioM + dados[11]);
    BufferedImage brasao = ImageIO.read(f3);
    ByteArrayOutputStream os3 = new ByteArrayOutputStream();
    ImageIO.write(brasao, f3.getName().split("\\.")[1], os3);
    InputStream is3 = new ByteArrayInputStream(os3.toByteArray());

    XWPFParagraph paragrafo = doc.createParagraph();
    paragrafo.setAlignment(ParagraphAlignment.CENTER);

    XWPFRun p = paragrafo.createRun();
    p.setFontFamily("Arial");
    p.setFontSize(12);
    p.setText("    ");
    p.addPicture(is, Document.PICTURE_TYPE_JPEG, f.getName(), Units.toEMU(60), Units.toEMU(60));
    p.addBreak();
    p.setText(f.getName().split(" ")[1].split("\\.")[0]);

    XWPFParagraph paragrafo2 = doc.createParagraph();
    paragrafo2.setAlignment(ParagraphAlignment.RIGHT);
    paragrafo2.setSpacingAfter(200);
    XWPFRun p2 = paragrafo2.createRun();

    p2.addPicture(is2, Document.PICTURE_TYPE_GIF, f2.getName(), Units.toEMU(60), Units.toEMU(60));

    XWPFParagraph paragrafo3 = doc.createParagraph();
    paragrafo3.setAlignment(ParagraphAlignment.RIGHT);
    paragrafo3.setSpacingAfter(200);
    XWPFRun p3 = paragrafo3.createRun();

    p3.addPicture(is3, Document.PICTURE_TYPE_GIF, f3.getName(), Units.toEMU(60), Units.toEMU(60));

    XWPFParagraph paragrafo4 = doc.createParagraph();
    paragrafo4.setAlignment(ParagraphAlignment.LEFT);

    XWPFRun p4 = paragrafo4.createRun();
    p4.setFontFamily("Arial");
    p4.setFontSize(12);
    p4.setText("Aluno(a): " + dados[0]);

    XWPFParagraph paragrafo5 = doc.createParagraph();
    paragrafo5.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun p5 = paragrafo5.createRun();
    p5.setFontFamily("Arial");
    p5.setFontSize(12);
    p5.setText("Data de Recebimento: 22/02/2002");

    XWPFParagraph paragrafo13 = doc.createParagraph();
    paragrafo13.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun p13 = paragrafo13.createRun();
    p13.setFontFamily("Arial");
    p13.setFontSize(12);
    p13.setText("Data de Entrega: 22/02/2002");

    XWPFParagraph paragrafo6 = doc.createParagraph();
    paragrafo6.setAlignment(ParagraphAlignment.CENTER);
    XWPFRun p6 = paragrafo6.createRun();
    p6.setFontFamily("Arial");
    p6.setFontSize(12);
    p6.setText(dados[4]);
    p6.addBreak();
    p6.setText(titulo);

    XWPFParagraph paragrafo7 = doc.createParagraph();
    paragrafo7.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun p7 = paragrafo7.createRun();
    p7.setFontFamily("Arial");
    p7.setFontSize(12);
    p7.setText("Professor(a): " + dados[1]);

    XWPFParagraph paragrafo8 = doc.createParagraph();
    paragrafo8.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun p8 = paragrafo8.createRun();
    p8.setFontFamily("Arial");
    p8.setFontSize(12);
    p8.setText("Turma: " + dados[2]);

    XWPFParagraph paragrafo9 = doc.createParagraph();
    paragrafo9.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun p9 = paragrafo9.createRun();
    p9.setFontFamily("Arial");
    p9.setFontSize(12);

    p9.setText("Valor: " + dados[6] + "pts");

    XWPFParagraph paragrafo10 = doc.createParagraph();
    paragrafo10.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun p10 = paragrafo10.createRun();
    p10.setFontFamily("Arial");
    p10.setFontSize(12);
    p10.setText("Turno: " + dados[3]);

    XWPFParagraph paragrafo11 = doc.createParagraph();
    paragrafo11.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun p11 = paragrafo11.createRun();
    p11.setFontFamily("Arial");
    p11.setFontSize(12);

    p11.setText("Nº de Questões: " + dados[7]);

    XWPFParagraph paragrafo12 = doc.createParagraph();
    paragrafo12.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun p12 = paragrafo12.createRun();
    p12.setFontFamily("Arial");
    p12.setFontSize(12);
    p12.setText("Duração: " + dados[8] + "min");

    table.getCTTbl().getTblPr().unsetTblBorders();
    table.getCTTbl().addNewTblPr().addNewTblW().setW(BigInteger.valueOf(12000));
    table2.getCTTbl().getTblPr().unsetTblBorders();

    XWPFTableRow linha1 = table.getRow(0);
    linha1.getCell(0).setParagraph(paragrafo);
    linha1.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000));
    linha1.addNewTableCell();
    linha1.addNewTableCell();

    linha1.getCell(1).setParagraph(paragrafo2);
    linha1.getCell(2).setParagraph(paragrafo3);
    linha1.getCell(2).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000));

    XWPFTableRow primeiraLinha = table2.getRow(0);
    table2.createRow();
    table2.createRow();
    table2.createRow();
    table2.createRow();
    table2.createRow();
    primeiraLinha.getCell(0).getCTTc().addNewTcPr();
    primeiraLinha.getCell(0).getCTTc().getTcPr().addNewGridSpan();
    primeiraLinha.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 3));
    primeiraLinha.getCell(0).setParagraph(paragrafo6);

    XWPFTableRow segundaLinha = table2.getRow(1);
    segundaLinha.addNewTableCell();
    segundaLinha.getCell(0).setParagraph(paragrafo4);

    segundaLinha.getCell(0).getCTTc().addNewTcPr();
    segundaLinha.getCell(0).getCTTc().getTcPr().addNewGridSpan();
    segundaLinha.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

    segundaLinha.getCell(1).setParagraph(paragrafo5);
    segundaLinha.getCell(1).getCTTc().addNewTcPr();
    segundaLinha.getCell(1).getCTTc().getTcPr().addNewGridSpan();
    segundaLinha.getCell(1).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

    XWPFTableRow terceiraLinha = table2.getRow(2);
    terceiraLinha.addNewTableCell();
    terceiraLinha.getCell(0).setParagraph(paragrafo7);

    terceiraLinha.getCell(0).getCTTc().addNewTcPr();
    terceiraLinha.getCell(0).getCTTc().getTcPr().addNewGridSpan();
    terceiraLinha.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

    terceiraLinha.getCell(1).setParagraph(paragrafo13);
    terceiraLinha.getCell(1).getCTTc().addNewTcPr();
    terceiraLinha.getCell(1).getCTTc().getTcPr().addNewGridSpan();
    terceiraLinha.getCell(1).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

    XWPFTableRow quartaLinha = table2.getRow(3);
    quartaLinha.addNewTableCell();
    quartaLinha.getCell(0).setParagraph(paragrafo10);

    quartaLinha.getCell(0).getCTTc().addNewTcPr();
    quartaLinha.getCell(0).getCTTc().getTcPr().addNewGridSpan();
    quartaLinha.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

    quartaLinha.getCell(1).setParagraph(paragrafo11);
    quartaLinha.getCell(1).getCTTc().addNewTcPr();
    quartaLinha.getCell(1).getCTTc().getTcPr().addNewGridSpan();
    quartaLinha.getCell(1).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

    XWPFTableRow quintaLinha = table2.getRow(4);
    quintaLinha.addNewTableCell();
    quintaLinha.getCell(0).setParagraph(paragrafo8);

    quintaLinha.getCell(0).getCTTc().addNewTcPr();
    quintaLinha.getCell(0).getCTTc().getTcPr().addNewGridSpan();
    quintaLinha.getCell(0).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

    quintaLinha.getCell(1).setParagraph(paragrafo12);
    quintaLinha.getCell(1).getCTTc().addNewTcPr();
    quintaLinha.getCell(1).getCTTc().getTcPr().addNewGridSpan();
    quintaLinha.getCell(1).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

    XWPFTableRow sextaLinha = table2.getRow(5);
    sextaLinha.addNewTableCell();
    sextaLinha.getCell(0).setParagraph(paragrafo9);
    sextaLinha.getCell(1).getCTTc().addNewTcPr();
    sextaLinha.getCell(1).getCTTc().getTcPr().addNewGridSpan();
    sextaLinha.getCell(1).getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) 2));

    paragrafo.removeRun(0);
    paragrafo2.removeRun(0);
    paragrafo3.removeRun(0);
    paragrafo4.removeRun(0);
    paragrafo5.removeRun(0);
    paragrafo6.removeRun(0);
    paragrafo7.removeRun(0);
    paragrafo8.removeRun(0);
    paragrafo9.removeRun(0);
    paragrafo10.removeRun(0);
    paragrafo11.removeRun(0);
    paragrafo12.removeRun(0);
    paragrafo13.removeRun(0);

    doc.write(out);
    out.close();
  }

  public void insereDadosMySQL_Servidor(String colunas, boolean data, String[] dados) throws IOException, SQLException {
    BancoDeDados.Conexao bd;
    bd = new Conexao();
    String escola = "Centro Federal de Educação Tecnológica de Minas Gerais";
    String colunas2 = "titulo,tipo,modalidade,escola,dataProva,nomeLogotipo,nomeBrasao"
            + ",nomeAluno,nomeProfessor,numeroQuestoes,valor,turma,turno,nomeEscola,duracao";
    bd.conectar("cefet-inf-2015.ddns.net:43306", "modelo", "inf2015", "Modelos");

    bd.enviarQuery("INSERT INTO cabecalho (" + colunas + ") VALUES (\'" + "Prova Bimestral de Matemática" + "',\'" + "Prova" + "',\'" + "Individual" + "',\'" + "Publica" + "',\'"
            + new java.sql.Date(new Date().getTime()) + "',\'" + "logotipo.gif" + "',\'" + "brasao.gif" + "',\'" + "Gabriel Victor Guimaras Xavier" + "',\'"
            + "José Antônio Siqueira" + "',\'" + "180" + "',\'" + "50" + "',\'" + "INF2A" + "',\'" + "MANHA" + "',\'" + escola + "',\'" + "60"
            + "')");
  }

  public void insereDadosMySQL_Local(String colunas, boolean data, String[] dados) throws IOException, SQLException, ParseException {
    Conectar conectar = new Conectar();
    Connection conexao = conectar.conexao();
    String valor = "?";
    for (int i = 0; i < colunas.split(",").length - 1; i++) {
      valor += ",?";
    }
    String sql = "INSERT INTO cabecalho (" + colunas + ")" + " VALUES(" + valor + ")";
    System.out.println(sql);
    PreparedStatement s = conexao.prepareStatement(sql);
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    if (data) {
      java.sql.Date Data = new java.sql.Date(format.parse(dados[5]).getTime());
      s.setString(1, dados[12]);
      s.setString(2, dados[13]);
      s.setString(3, dados[14]);
      s.setString(4, dados[15]);
      s.setDate(5, Data);
      s.setString(6, dados[10]);
      s.setString(7, dados[11]);
      s.setString(8, dados[0]);
      s.setString(9, dados[1]);
      s.setInt(10, Integer.parseInt(dados[7]));
      s.setInt(11, Integer.parseInt(dados[6]));
      s.setString(12, dados[2]);
      s.setString(13, dados[3]);
      s.setString(14, dados[4]);
      s.setInt(15, Integer.parseInt(dados[8]));
      s.setString(16, dados[9]);
    } else {
      for (int i = 0; i < dados.length; i++) {
        System.out.println("dados[" + i + "] = " + dados[i]);
      }
      java.sql.Date Data = new java.sql.Date(format.parse(dados[5]).getTime());
      java.sql.Date Data2 = new java.sql.Date(format.parse(dados[5]).getTime());
      s.setString(1, dados[13]);
      s.setString(2, dados[14]);
      s.setString(3, dados[15]);
      s.setString(4, dados[16]);

      s.setDate(5, Data);
      s.setDate(6, Data2);

      s.setString(7, dados[11]);
      s.setString(8, dados[12]);
      s.setString(9, dados[0]);
      s.setString(10, dados[1]);
      s.setInt(11, Integer.parseInt(dados[8]));
      s.setInt(12, Integer.parseInt(dados[7]));

      s.setString(13, dados[2]);
      s.setString(14, dados[3]);
      s.setString(15, dados[4]);
      s.setInt(16, Integer.parseInt(dados[10]));
      s.setString(17, dados[9]);

    }
    s.executeUpdate();
  }

  public void informacoesProva(org.w3c.dom.Document doc) {

    Node prova = doc.getElementsByTagName("prova").item(0);
    Node valor = prova.getChildNodes().item(1);
    valor.setTextContent("Teste");
    TransformerFactory t = TransformerFactory.newInstance();
    try {
      Transformer t2 = t.newTransformer();
      DOMSource s = new DOMSource(doc);
      try {
        Runtime.getRuntime().exec("cmd /c attrib -h -s -r C:/Temp");
      } catch (IOException ex) {
        Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
      }
      StreamResult c2 = new StreamResult(new File("C:/Temp/XMLq.xml"));
      t2.transform(s, c2);
    } catch (TransformerConfigurationException ex) {
      Logger.getLogger(Documento.class
              .getName()).log(Level.SEVERE, null, ex);
    } catch (TransformerException ex) {
      Logger.getLogger(Documento.class
              .getName()).log(Level.SEVERE, null, ex);
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

  public void adicionarQuestoes() {
    //  ArrayList<String> tipoQuestao = null;

    try {
      String filepath = "XMLq.xml";
      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
      org.w3c.dom.Document doc = docBuilder.parse(filepath);

      informacoesProva(doc);

      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(doc);
      StreamResult result = new StreamResult(new File(filepath));
      transformer.transform(source, result);

      int numeroQuestoes = Questao.length;
      for (int i = 0; i < numeroQuestoes; i++) {
        XWPFParagraph paragrafo = this.doc.createParagraph();
        paragrafo.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun run = paragrafo.createRun();
        run.setBold(true);
        run.setFontFamily("Arial");
        run.setFontSize(12);
        run.setText("Questão " + (i + 1));

        XWPFParagraph paragrafo2 = this.doc.createParagraph();
        paragrafo2.setAlignment(ParagraphAlignment.LEFT);

        XWPFRun run2 = paragrafo2.createRun();
        run2.addBreak(BreakType.TEXT_WRAPPING);
        run2.setFontFamily("Arial");
        run2.setFontSize(12);
        run2.setText(String.format("%s", Questao[i].get(1)));//enunciado
        run2.addBreak();
        run2.addBreak();
        if (Questao[i].get(0).equals("ME")) {
          char letra = 'a';
          ArrayList aux = (ArrayList) this.Questao[i].get(2);
          for (int j = 0; j < aux.size(); j++) {
            run2.setText(String.format("%s", letra));
            run2.setText(") ");
            run2.setText((String) aux.get(j));
            run2.addBreak();
            letra++;
          }
        } else {
          if (Questao[i].get(0).equals("VF")) {
            char letra = 'a';
            ArrayList aux = (ArrayList) this.Questao[i].get(2);
            for (int j = 0; j < aux.size(); j++) {
              run2.setText(String.format("%s", letra));
              run2.setText(") V(  ) F(  ) ");
              run2.setText((String) aux.get(j));
              run2.addBreak();
              letra++;
            }
          } else {
            if (Questao[i].get(0).equals("aberta")) {
              run2.setText("____________________________________________________________________________________");
              run2.setText("____________________________________________________________________________________");
              run2.addBreak();
            }
          }
        }
        run2.setText("____________________________________________________________________________________");
      }
      this.doc.write(out);
      out.close();

    } catch (SAXException | IOException | ParserConfigurationException | TransformerException ex) {
      Logger.getLogger(Documento.class
              .getName()).log(Level.SEVERE, null, ex);
    }
  }
}
