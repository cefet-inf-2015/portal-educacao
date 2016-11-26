package bancodequestoes;


import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
//bibliotecas XML
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/** Um tipo padrão da <b>questão</b>, admite varias alternativas e a resposta correta é apenas uma,
 *  <b><i>exemplo</i></b>:<br>
 * <code>(OBMEP-2016 1ª fase) Uma função <b>f</b> é tal que <b><i>f(1-x)+2f(x)=3x</i></b>, para todo<br>
 * x real. Qual é o valor de <b><i>f(0)</i></b>?<br>
 * A)–2<br>
 * B)–1<br>
 * C)0<br>
 * D)1<br>
 * E)2<br>
 * </code>
 * Resposta correta: alternativa <b>B</b>.<br> 
 * @author ThalesGSN
 */
public class MultiplaEscolha extends Questao {
    /** <i>Vetor de Alternativas</i> que representa as alternativas da <b>questão</b>.*/
    private ArrayList<Alternativa> alternativas = new ArrayList();
    /**<i>Boolean</i> que define se as alternativas terão ordem aleatoria*/
    private boolean aleatorio;
    
//Construtores
    /**
     * Instancia o objeto para o mesmo ser construido com sets e gets.
     */
     public MultiplaEscolha() {
        this.tipo = Questao.MULTIPLA_ESCOLHA;
    }

      /**
     * Inicia o objeto com todos os parametros necessarios e define a aleatoriedade da ordem das alternativas da
     * questão como falso.
     * @param materia <i>String</i> que representa a <i>materia</i> da <b>questão</b>.
     * @param conteudo <i>String</i> que representa o <i>conteudo</i> da <b>questão</b>.
     * @param dificuldade <i>byte</i> que representa a <i>dificuldade</i> da <b>questão</b>.
     * @param enunciado <i>String</i> que representa o <i>enunciado</i> da <b>questão</b>.
     * @param alternativas <i>Vetor de Alternativas</i> que representa as alternativas da <b>questão</b>.
     */
    public MultiplaEscolha(String materia, String conteudo, byte dificuldade, String enunciado,
            ArrayList<Alternativa> alternativas) {
         this.materia = materia;
         this.conteudo = conteudo;
         this.dificuldade = dificuldade;
         this.enunciado = enunciado;
         this.alternativas = alternativas;
         this.tipo = Questao.MULTIPLA_ESCOLHA;
    }
    
    /**
     * Inicia o objeto com todos os atributos necessarios e torna a como uma <b>questão</b> completa.
     * @param materia <i>String</i> que representa a <i>materia</i> da <b>questão</b>.
     * @param conteudo <i>String</i> que representa o <i>conteudo</i> da <b>questão</b>.
     * @param dificuldade <i>byte</i> que representa a <i>dificuldade</i> da <b>questão</b>.
     * @param enunciado <i>String</i> que representa o <i>enunciado</i> da <b>questão</b>.
     * @param alternativas<i>ArrayList</i> de alternativas da <b>questão</b>.
     * @param aleatorio <i>boolean</i>  atributo que define se as alternativas irão ter ordem aleatorias numa
     * prova.
     */
    public MultiplaEscolha(String materia, String conteudo, byte dificuldade, String enunciado, 
           ArrayList<Alternativa> alternativas, boolean aleatorio) {
        this.materia = materia;
         this.conteudo = conteudo;
         this.dificuldade = dificuldade;
         this.enunciado = enunciado;
         this.alternativas = alternativas;
         this.aleatorio = aleatorio;
         this.tipo = Questao.MULTIPLA_ESCOLHA;
    }
    
     /**
      *  Constroi a questão de multipla escolha a partir de uma <i>String</i> XML de questão aberta.
     * @param XML <i>String</i> XML do tipo questão Multipla escolha.
     * @throws javax.xml.parsers.ParserConfigurationException
     * 
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public MultiplaEscolha(String XML) throws ParserConfigurationException, SAXException, IOException{
            //MONTA O DOM
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(XML));
            Document doc = dBuilder.parse(is);
           doc.getDocumentElement().normalize();

           //Lê o XML
           NodeList nList = doc.getElementsByTagName("questao");//Lista elementos questao
           Element eQuestao = (Element) nList.item(0); //Pega a questão como elemento
           
           this.tipo = Questao.MULTIPLA_ESCOLHA;
           this.aleatorio = Boolean.getBoolean(eQuestao.getAttribute("aleatorio"));
           this.dificuldade = Byte.parseByte(eQuestao.getElementsByTagName("dificuldade").item(0)
                   .getTextContent()); //pega o texto adquitido do elemento no xml e passa o texto para um numero
           this.materia =  eQuestao.getElementsByTagName("materia").item(0).getTextContent();
           this.conteudo =  eQuestao.getElementsByTagName("conteudo").item(0).getTextContent();
           this.enunciado =  eQuestao.getElementsByTagName("enunciado").item(0).getTextContent();       
           //adicionando imagem
           if(eQuestao.getElementsByTagName("imagem").item(0) != null) {
           String imgPath = eQuestao.getElementsByTagName("imagem").item(0).getTextContent();
            this.imagem = new Imagem(imgPath,true);
           }   else this.imagem = null;
           
           
         NodeList eAlternativas = eQuestao.getElementsByTagName("alternativa");
         
         for(int cont = 0; cont < eAlternativas.getLength(); cont++){
             Element eAlternativa = (Element) eAlternativas.item(cont);
             
             Alternativa aux = new Alternativa();//instancia alternativa
             aux.setTexto(eAlternativa.getTextContent());//pega o texto
             
             //se for correta seta a alternativa como correta
             if(Boolean.valueOf(eAlternativa.getAttribute("correta"))) aux.setCorreta();
             
             //Adiciona a alternativa na arraylist
             alternativas.add(aux);
         }
         Collections.shuffle(alternativas, new Random(System.nanoTime()));
    }
   
//Metodos uteis
     /**
     * Retorna um <i>boolean</i>, que é o atributo que define se as alternativas irão ter ordem aleatorias
     * numa prova.
     * @return <b>true</b> se e somente se, a questão estiver definida com ordem aleatoria em suas 
     * alternativas.
     */
    public boolean isAleatoria(){
        return aleatorio;
    }
    
    /**
     *  Define como <b>true</b> o atributo que define se as alternativas irão ter ordem aleatorias numa prova.
     * @param aleatoria parametro que verifica se a questão é ou não aleatoria.
     */
    public void setAleatoria(boolean aleatoria){
        this.aleatorio = aleatoria;
    }
    
    
    /**
     * Adiciona uma alternativa em determinada <b>questao</b>.
     * @param Alternativa <i>String</i> que representa o texto da <b>questão</b>
     * @param correta <i>boolean</i> que representa se essa alternativa adicionada é uma correta.
     */
     void addAlternativa(String Alternativa, boolean correta){
        this.alternativas.add(new Alternativa(materia, correta));
    }
    
//Metodos abstratos de questão
     
    /**
     * Retorna um ArrayList de Alternativas nessa questão.
     * @return ArrayList de Alternativas nessa questão.
     */
    public ArrayList<Alternativa> getAlternativas() {
        return alternativas;
    }

    /**
     * Define ou Altera o ArrayList de alternativas da questão.
     * @param alternativas ArrayList de alternativas da questão.
     */
    public void setAlternativas(ArrayList<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }
    
    @Override
    public boolean isCompleta() {
       return !(alternativas.isEmpty() && conteudo.isEmpty() && enunciado.isEmpty() && materia.isEmpty()) && 
                dificuldade!=0;
    }

    @Override
    public String toXML(int ID) {
       String XML = "<questao tipo=\"ME\" aleatorio=\"" + aleatorio + "\">\n" +
                            "<dificuldade>" + dificuldade + "</dificuldade>\n" +
                            "<materia>" + materia+ "</materia>\n" +
                            "<conteudo>" + conteudo + "</conteudo>\n" +
                            "<enunciado>" + enunciado +  "</enunciado>\n";

         for(Alternativa alternativa: alternativas){
            if(alternativa.IsCorreta()){
                XML += "<alternativa correta=\"true\">" + alternativa + "</alternativa>\n";
            } else{
                XML += "<alternativa>" + alternativa + "</alternativa>\n";
            }
        }
        
        XML += "</questao>";
        
        return XML;
    }

    @Override
    public String toXML() {
       String XML = "<questao tipo=\"ME\" aleatorio=\"" + aleatorio + "\">\n" +
                            "<dificuldade>" + dificuldade + "</dificuldade>\n" +
                            "<materia>" + materia+ "</materia>\n" +
                            "<conteudo>" + conteudo + "</conteudo>\n" +
                            "<enunciado>" + enunciado +  "</enunciado>\n";

         for(Alternativa alternativa: alternativas){
            if(alternativa.IsCorreta()){
                XML += "<alternativa correta=\"true\">" + alternativa + "</alternativa>\n";
            } else{
                XML += "<alternativa>" + alternativa + "</alternativa>\n";
            }
        }
        
        XML += "</questao>";
        
        return XML;
    }

    
    @Override
    public String toString() {      
        String questao;
        questao = enunciado + '\n';
        
            char ch = 'a';
            for(Alternativa escolha : alternativas){
                questao += ch + ")" + escolha.getTexto() + "\n";
                ch++; 
    }
    return questao;
    }
}
    