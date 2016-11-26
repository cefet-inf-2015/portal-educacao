package bancodequestoes;

import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

//@TODO Implementar IMAGENS ate 3

/**
 * Classe que representa uma <i>questão</i> para a tarefa <b>banco de questões</b>, ela define a 
 * questão que depois sera armazenada num <b>banco de dados</b> para depois ser gerado uma
 * prova com as questões armazenadas.
 * A <b>Questão</b> pode adotar 3 formas:
 *   <ul>
 * <li>Aberta
 * <li>Multipla escolha
 * <li>Verdadeiro ou Falso
 * </ul>
 * @author ThalesGSN
 */
public abstract class Questao {
//variaveis de instancia
    /** <i>String</i> que representa a <i>materia</i> da <b>questão</b>.*/
    protected String materia;
    /** <i>String</i> que representa o <i>conteudo</i> da <b>questão</b>.*/
    protected String conteudo;
    /** <i>byte</i> que representa a <i>dificuldade</i> da <b>questão</b>.*/
    protected byte dificuldade;
     /**<i>Byte</i> que define o tipo da questão. */
    protected byte tipo;
    /** <i>String</i> que representa o <i>enunciado</i> da <b>questão</b>.*/
    protected String enunciado;
    /** <i>Imagem</i> que representa o <i>imagem</i> da <b>questão</b>.*/
    protected Imagem imagem;
    
//Constantes de tipo
    /** Tipo padrão da <b>questão</b>, admite varias alternativas e a resposta correta é apenas uma,
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
     * 
     *  Essa constante foi feita para ser agregado ao tipo da <b>questão</b>.
     */
    public static final byte MULTIPLA_ESCOLHA = 0;
    
    /** Tipo de <b>questão</b>, admite varias alternativas e a resposta correta pode ser uma ou mais alternativas,
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
     *  Essa constante foi feita para ser agregado ao tipo da <b>questão</b>.
     */
     static final public byte VERDADEIRO_FALSO = 1;
    
     /** Tipo de <b>questão</b>, não admite alternativa nenhuma e a resposta correta não é exata, dependendo
     * da correção do professor, <b><i>exemplo</i></b>:<br>
     * <code>(UFMG - 2010 2ª etapa) Leia atentamente esta frase:<br>
     * <b>"O acusado vai estar chegando em Porto Alegre, vindo dos EUA, amanhã."</b><br>
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
 
//constantes de dificuldade
     /**
      * Constante que define a dificuldade de uma questão, sendo esta do tipo Facil. 
      */
     static final public byte FACIL = 1;
      /**
      * Constante que define a dificuldade de uma questão, sendo esta do tipo Mediana. 
      */
     static final public byte MEDIANA = 2;
      /**
      * Constante que define a dificuldade de uma questão, sendo esta do tipo Dificil. 
      */
     static  final public byte DIFICIL = 3;
   
//Sets e Gets

    /** 
     * Retorna a <i>String</i> que representa a <i>materia</i> da <b>questão</b>.<br>
     * <b>Exemplo:</b><br>
     * <code>Matematica</code>
     * @return <i>String</i> que representa a <i>materia</i> da <b>questão</b>.
     */
    public String getMateria() {
        return materia;
    }

    /**
     * Altera ou Define <i>String</i> que representa a <i>materia</i> da <b>questão</b>.<br>
     * <b>Exemplo:</b><br>
     * <code>Matematica</code>
     * @param materia <i>String</i> que representa a <i>materia</i> da <b>questão</b>.
     */
    public void setMateria(String materia) {
        this.materia = materia;
    }

    /**
     * Retorna a <i>String</i> que representa o <i>conteudo</i> da <b>questão</b>.<br>
     * <b>Exemplo:</b><br>
     * <code>Função do 2º grau</code>
     * @return conteudo <i>String</i> que representa o <i>conteudo</i> da <b>questão</b>.
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * Altera ou Define a <i>String</i> que representa o <i>conteudo</i> da <b>questão</b>.
     * <b>Exemplo:</b><br>
     * <code>Função do 2º grau</code>
     * @param conteudo <i>String</i> que representa o <i>conteudo</i> da <b>questão</b>.
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * Retorna um  um Numero de 1 a 10 que representa a <i>dificuldade</i> da <b>questao.</b>, e retorna
     *  true se esse numero for alterado ou definido com sucesso.<br>
     * <b>Exemplo:</b><br>
     * <code>questao7.setDificuldade(5);//retorna true <br>
     *              questao7.setDificuldade(11);//retorna false<br>
     *              questao7.setDificuldade(-5);//retorna false<br>
     * </code>
     * @return Numero de 1 a 10 que representa a <i>dificuldade</i> da <b>questao.</b>.
     */
    public byte getDificuldade() {
        return dificuldade;
    }

    /**
     * Altera ou Define um Numero de 1 a 3 que representa a <i>dificuldade</i> da <b>questao.</b>, sendo
     * 1 facil 2 mediana e 3 dificil, e retorna true se esse numero for alterado ou definido com sucesso.<br>
     * <b>Exemplo:</b><br>
     * <code>questao7.setDificuldade(3);//retorna true <br>
     *              questao7.setDificuldade(11);//retorna false<br>
     *              questao7.setDificuldade(-5);//retorna false<br>
     * </code>
     * @param dificuldade Numero de 1 a 10 que representa a <i>dificuldade</i> da <b>questao.</b>.
     * @return <b>true</b> se e somente se, a <i>dificuldade</i> for alterada ou definida com sucesso.
     */
    public boolean setDificuldade(byte dificuldade) {
        if(dificuldade > 0 &&  dificuldade <= 3){
            this.dificuldade = dificuldade;
            return true;
        }
        //else
        return  false;
    }

    /**
     * Retorna a <i>String</i> que é o <i>enunciado</i> da <b>questao</b>.<br>
     * <b>Exemplo:</b><br>
     * <code>Dada a função y = 2x2 + x + 3, determine o conjunto imagem referente aos domínios
     * –2, –1, 0, 1, 2, 3, 4. </code>
     * @return enunciado <i>String</i> que é o <i>enunciado</i> da <b>questao</b>.
     */
    public String getEnunciado() {
        return enunciado;
    }

    /**
     * Define ou Altera a <i>String</i> que é o <i>enunciado</i> da <b>questao</b>.<br>
     * <b>Exemplo:</b><br>
     * <code>Dada a função y = 2x2 + x + 3, determine o conjunto imagem referente aos domínios
     * –2, –1, 0, 1, 2, 3, 4. </code>
     * @param enunciado <i>String</i> que é o <i>enunciado</i> da <b>questao</b>.
     */
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

     /**
     * Retorna o tipo da <b>questão</b> por meio de constantes, eles podem ser:
     * <ol>
     *      <li>Questao.MULTIPLA_ESCOLHA(Padrão)
     *      <li>Questao.VERDADEIRO_FALSO
     *      <li>Questao.ABERTA 
     * </ol>
     * @return tipo <b>constante</b> da propia classe que define o tipo da <b>questão</b>.
     */
    public byte getTipo() {
        return tipo;
    }
    
     /**
     * Retorna o tipo da <b>questão</b> por meio de constantes, eles podem ser:
     * <ol>
     *      <li>Questao.MULTIPLA_ESCOLHA(Padrão)
     *      <li>Questao.VERDADEIRO_FALSO
     *      <li>Questao.ABERTA 
     * </ol>
     * @param tipo <b>constante</b> da propia classe que define o tipo da <b>questão</b>.
     */
    protected void setTipo(byte tipo) {
        this.tipo = tipo;
    }

    public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
    }

    
//Metodos Uteis
    
    public static Questao newInstance(String XML) throws SAXException, IOException, 
            ParserConfigurationException {
         //MONTA O DOM
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(XML));
            Document doc = dBuilder.parse(is);
           doc.getDocumentElement().normalize();

           //Lê o XML
           NodeList nList = doc.getElementsByTagName("questao");//Lista elementos questao
           Element eQuestao = (Element) nList.item(0); //Pega a questão como elemento
           
          String tipo  = eQuestao.getAttribute("tipo");
          
          switch(tipo){
              case "ME":
               return new MultiplaEscolha(XML);
              
              case "VF":
                return new VOuF(XML);
                
                case "ABERTA":
                    return new Aberta(XML);
          }
       throw new IOException("Erro no parsing do XML");
    }
    
    /**
     * Informa atravez de um <i>boolean</i> se a questão esta completa e pronta para ser perte de uma prova.
     * @return <b>true</b> se e somente se, a questão estiver completa com:
     *  <ul>
     *          <li><i>Alternativas</i>
     *          <li><i>Conteudo</i>
     *          <li><i>enunciado</i>
     *          <li><i>Materia</i>
     *          <li><i>Dificuldade</i>
     * </ul><br>
     *  Diferentes de null ou diferentes de 0(zero). Exeto no caso da qustão ser aberta onde não ha necessidade
     * de alternativas.
     * 
     */
    public abstract boolean isCompleta();
   
    /**
     *  Retorna o modelo xml da questão, util para a equipe de correção.
     * @return XML <i>String</i> Que representa o modelo xml da questão.
     */
    public abstract String toXML();
    
    /**
     *  Retorna o modelo xml da questão, util para a equipe de correção.
     * @param ID da questão se ela tiver imagem.
     * @return XML <i>String</i> Que representa o modelo xml da questão.
     */
    public abstract String toXML(int ID);

    @Override
    public abstract String toString();  
    
}
