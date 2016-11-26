package bancodequestoes;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//Bibliotecas XML
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/** Um tipo de <b>questão</b>, admite varias alternativas e a resposta correta pode ser uma ou mais alternativas,
 *  <b><i>exemplo</i></b>:<br>
 * <code>(UFFS - 2009) Identifique se são verdadeiras (V) ou falsas (F) as afirmativas com relação às fontes
 * históricas. <br>
 *  1- ( ) Apesar de existirem vários tipos de fontes disponíveis ao historiador, as únicas realmente confiáveis são
 * as escritas.<br> 
 *  2- ( ) Uma vez que as fontes falam por si, não cabe ao historiador preocupar-se com o contexto das
 * mesmas.<br> 
 *  3- ( ) Na análise de fontes, o historiador precisa estar atento aos critérios de quem produziu o documento.<br> 
 *  4- ( ) Cabe ao historiador zelar pela preservação das fontes, sempre tomando os devidos cuidados
 * ao manuseá-las.<br> 
 * </code>
 * Resposta correta: alternativas <b>3 e 4</b>.<br>
 * 
 * @author ThalesGSN
 */
public class VOuF extends Questao{
//Variaveis de instancia    
    /** <i>Vetor de Alternativas</i> que representa as alternativas da <b>questão</b>.*/
    private ArrayList<Alternativa> alternativas = new ArrayList();
    /**<i>Boolean</i> que define se as alternativas terão ordem aleatoria*/
    private boolean aleatorio;
//Construtores
    /**
     * Instancia o objeto para o mesmo ser construido com sets e gets.
     */
     public VOuF() {
        this.alternativas = new ArrayList();
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
    public VOuF(String materia, String conteudo, byte dificuldade, String enunciado,
            ArrayList<Alternativa> alternativas) {
        this.materia = materia;
         this.conteudo = conteudo;
         this.dificuldade = dificuldade;
         this.enunciado = enunciado;
         this.alternativas = alternativas;
         this.tipo = VERDADEIRO_FALSO;
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
    public VOuF(String materia, String conteudo, byte dificuldade, String enunciado, 
           ArrayList<Alternativa> alternativas, boolean aleatorio) {
        this.materia = materia;
         this.conteudo = conteudo;
         this.dificuldade = dificuldade;
         this.enunciado = enunciado;
         this.alternativas = alternativas;
         this.aleatorio = aleatorio;
         this.tipo = VERDADEIRO_FALSO;
    }
    
      /**
      *  Constroi a questão de multipla escolha a partir de uma <i>String</i> XML de questão aberta.
     * @param XML <i>String</i> XML do tipo questão Multipla escolha.
     * @throws javax.xml.parsers.ParserConfigurationException
     * 
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public VOuF(String XML) throws ParserConfigurationException, SAXException, IOException{
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
     *  Define como <b>false</b> o atributo que define se as alternativas irão ter ordem aleatorias numa prova.
     */
    public void asNaoAleatoria(){
        aleatorio = false;
    }
    
    /**
     * Adiciona uma alternativa na questão e define se a mesma é correta.
     * @param Alternativa <i>String</i> que define o texto da alternativa.
     * @param correta define se a alternativa é correta usando true.
     */
    public void addAlternativa(String Alternativa, boolean correta){
        alternativas.add(new Alternativa(materia, correta));
    }

    @Override
    public boolean isCompleta() {
        return !(alternativas.isEmpty() && conteudo.isEmpty() && enunciado.isEmpty() && materia.isEmpty()) && 
                dificuldade!=0;
    }

    @Override
    public String toXML(int ID) {
       String XML = "<questao tipo=\"VF\">\n" +
                    "<dificuldade>" + dificuldade + "</dificuldade>\n" +
                    "<materia>" + materia+ "</materia>\n" +
                    "<conteudo>" + conteudo + "</conteudo>\n" +
                    "<enunciado>" + enunciado +  "</enunciado>\n" +
                    "<imagem>" + ID + ".jpg</imagem>\n";

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
       String XML = "<questao tipo=\"VF\">\n" +
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
        
        for (Alternativa escolha : alternativas) {
            questao += "( )" + escolha.getTexto() + "\n";
        }
        return questao;
    }
}
