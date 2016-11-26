package bancodequestoes;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


/**
 * Classe que constroi uma <b>prova</b>, com varias <b>questoes</b>, a  prova pode conter questoes de tres 
 * tipos, São eles:
 * <ul>
 * <li>Aberta
 * <li>Multipla escolha
 * <li>Verdadeiro ou Falso
 * </ul>
 * Esta classe prova herda de HashSet como um HashSet de questoes.
 * @author ThalesGSN
 */
public abstract class Prova extends ArrayList<Questao> {
//variaveis de instancia
   /** <i>String</i> que define a materia da prova.*/
   protected String materia;
    /** Array(nao permite duplicatas) que define o conteudo da prova */
   protected ArrayList<String> conteudos = new ArrayList();
   /** informa se havera questões faceis na prova */
   private boolean isFacil;
    /** informa se havera  questões medianas na prova */
   private boolean  isMediana;
    /** informa se havera questões faceis na prova */
   private boolean isDificil;
       
//Constantes de tipo
    /** Tipo de <b>prova</b>,  com <b>questoes</b> que  admitem varias alternativas e a resposta correta é 
     * apenas uma, <b><i>exemplo de questao</i></b>:<br>
     * <code>(OBMEP-2016 1ª fase) Uma função <b>f</b> é tal que <b><i>f(1-x)+2f(x)=3x</i></b>, para todo<br>
     * x real. Qual é o valor de <b><i>f(0)</i></b>?<br>
     * A)–2<br>
     * B)–1<br>
     * C)0<br>
     * D)1<br>
     * E)2<br>
     * </code>
     * Resposta correta: alternativa <b>B</b>.<br>
     * 
     *  Essa constante foi feita para ser agregado ao tipo da <b>questão</b>.
     */
    public static final byte MULTIPLA_ESCOLHA = 0;
    
    /** Tipo de <b>prova</b>, com questoes que admitem varias alternativas e a resposta correta pode ser uma ou
     * mais alternativas, <b><i>exemplo de questao</i></b>:<br>
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
     *  Essa constante foi feita para ser agregado ao tipo da <b>questão</b>.
     */
     static final public byte VERDADEIRO_FALSO = 1;
    
     /** Tipo de <b>prova</b>, com <b>questoes</b> não admitem alternativa nenhuma e a resposta correta não é
      * exata, dependendo da correção do professor, <b><i>exemplo</i></b>:<br>
     * <code>(UFMG - 2010 2ª etapa) Leia atentamente esta frase:<br>
     *  <b>"O acusado vai estar chegando em Porto Alegre, vindo dos EUA, amanhã."</b><br>
     *  <u>Citado por MACHADO, Josué. In: Revista Língua Portuguesa, São Paulo, ano II, n. 15, p.45, 2007.</u>
     * <br>
     * Veiculada em jornal de grande circulação no País, essa frase, de acordo com a norma culta da língua,
     *   apresenta dois problemas.<br>
     *   Com base em seus conhecimentos linguísticos, <b>IDENTIFIQUE e EXPLIQUE</b> esses problemas.  <br>
     * </code>
     * Resposta correta: "Gerundismo" : erro gramatical devido à tradução literal do inglês, utilizando uma<br>
     * construção que não existe em português.<br>
     *   "erro de regência": o verbos que denotam movimento regem preposição "a"<br>
     * 
     *  Essa constante foi feita para ser agregado ao tipo da <b>questão</b>.
     */
     static final public byte ABERTA = 2;
     
     /**
      * Tipo de prova, que admitem todos os tipos de <b>questoes</b>.
      */
     static final public byte MISTA = 3;

     /**
      * Verifica se esta prova é facil
      * @return true so e somente a prova for facil
      */
     public boolean isFacil() {
        return isFacil;
    }

     /**
      * 
      * @param isFacil 
      */
    public void setIsFacil(boolean isFacil) {
        this.isFacil = isFacil;
    }

    /**
     * 
     * @return 
     */
    public boolean isMediana() {
        return isMediana;
    }

    /**
     * 
     * @param isMediana 
     */
    public void setIsMediana(boolean isMediana) {
        this.isMediana = isMediana;
    }

    /**
     * 
     * @return 
     */
    public boolean IsDificil() {
        return isDificil;
    }

    /**
     * 
     * @param isDificil 
     */
    public void setIsDificil(boolean isDificil) {
        this.isDificil = isDificil;
    }

//SETS e GETS 
    /**
     * Retorna a materia da priva  da prova.
     * @return <i>String</i> que representa a materia da prova.
     */
    public String getMateria() {
        return materia;
    }

    /**
     * Define ou alteria a materia da questão.
     * @param materia <i>String</i> que representa a materia da prova.
     */
    public void setMateria(String materia) {
        this.materia = materia;
    }

    /**
     * Retorna o Hashset de conteudos da prova.
     * @return <i>HashSet</i> Conteudos em string da prova.
     */
    public ArrayList<String> getConteudos() {
        return conteudos;
    }

    /**
     * Altera ou define os conteudos da prova
     * @param conteudos <i>HashSet</i> Conteudos em string da prova.
     */
    public void setConteudos(ArrayList<String> conteudos) {
        this.conteudos = conteudos;
    }
  


    
 //Metodos uteis
    /**
     * Adiciona um conteudo na prova.
     * @param conteudo <i>String</i> que representa outro conteudo a ser addicionado na prova.
     */
    public void addConteudo(String conteudo){
        conteudos.add(conteudo);
    }
     
    
     /**
     *  Retorna a representação da prova em XML com todas as questoes com base num modelo pre definido. 
     * @return <i>String</i> XML da prova.
     */
    public String toXML(){
        String ProvaXML;
        ProvaXML = "<prova>\n";
        Iterator<Questao> questoes = super.iterator(); 
        
        while(questoes.hasNext()){
            ProvaXML += questoes.next().toXML() + "\n";
        }
        
        ProvaXML += "</prova>";
        
        return ProvaXML;
    }
    
     /**
     * Retorna a representação escrita de uma prova ou como ela vai aparecer para um usuario. 
     * @return <i>String</i> Representação textual da prova.
     */
    @Override
    public String toString() {
        String ProvaTxt;
        
        ProvaTxt = "Prova de " + materia + '\n';
        for(String conteudo: conteudos){
            ProvaTxt += conteudo + ", ";
        }
        
        Iterator<Questao> questoes = super.iterator(); 
        
        while(questoes.hasNext()){
            ProvaTxt += questoes.next().toString();
        }
        
        return ProvaTxt;
    }

//Metodos abstratos
        /**
     * Gera as questoes da prova pegando elas no banco de dados e armazenando neste HashSet de questoes.
     * @return <i>true</i> se e somente se, a prova for gerada com sucesso.
     * @throws java.sql.SQLException
     *  Caso haja algum erro na conexão com o banco de dados
     * @throws org.xml.sax.SAXException
     *  Caso haja algum erro no parsing do XML
     * @throws java.io.IOException
     * Caso haja algum erro no parsing do XML
     * @throws javax.xml.parsers.ParserConfigurationException
     * Caso haja algum erro no parsing do XML
     */
    public abstract boolean gerar() throws SQLException,SAXException,
            IOException, ParserConfigurationException;



}
