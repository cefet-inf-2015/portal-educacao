package bancodequestoes;

//bibliotecas XML
import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/** Tipo de <b>questão</b>, não admite alternativa nenhuma e a resposta correta não é exata, dependendo
 * da correção do professor, <b><i>exemplo</i></b>:<br>
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
 * @author ThalesGSN
 */
public class Aberta extends Questao{
//construtores
    
    /** Construtor para ser construido com sets e gets.*/
    public Aberta(){
      this.tipo = Questao.ABERTA;
    }
    
    /**
     * Constroi a questão completamente com todos os atributos necessarios.
     * @param materia <i>String</i> que representa a materia da <b>questão</b>
     * @param conteudo  <i>String</i> que representa o conteudo da <b>questão</b>
     * @param dificuldade <i>byte</i> que representa o nivel de dificuldade da <b>questao</b>
     * @param enunciado <i>String</i> do enunciado da  <b>questão</b>
     */
    public Aberta(String materia, String conteudo, byte dificuldade, String enunciado) {
       this.materia = materia;
       this.conteudo = conteudo;
       this.dificuldade = dificuldade;
       this.enunciado = enunciado;
       this.tipo = Questao.ABERTA;
    }

    /**
     * A partir de uma <i>String</i> XML do tipo questão aberta constroi o objeto.
     * @param XML <i>String</i> XML do tipo questão aberta.
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public Aberta(String XML) throws ParserConfigurationException, SAXException, IOException{
       
            //MONTA O DOM
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(XML));
            Document doc = dBuilder.parse(is);
           doc.getDocumentElement().normalize();

           //Lê o XML
           NodeList nList = doc.getElementsByTagName("questao");//Lista elementos questao
           Element eQuestao = (Element) nList.item(0); //Pega a questão como elemento
           
           this.tipo = Questao.ABERTA;
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
    }

//Metodos sobrescritos e herdados de Questao
        
    @Override
    public boolean isCompleta() {
       return !(conteudo.isEmpty() && enunciado.isEmpty() && materia.isEmpty()) && dificuldade!=0;
    }

    @Override
    public String toXML(int ID) {
       return "<questao tipo=\"ABERTA\">\n" +
                    "<dificuldade>" + dificuldade + "</dificuldade>\n" +
                    "<materia>" + materia+ "</materia>\n" +
                    "<conteudo>" + conteudo + "</conteudo>\n" +
                    "<enunciado>" + enunciado +  "</enunciado>\n" +
                     "<imagem>" + ID + ".jpg</imagem>\n" +
                    "</questao>";
    }
    
    @Override
    public String toXML() {
       return "<questao tipo=\"ABERTA\">\n" +
                    "<dificuldade>" + dificuldade + "</dificuldade>\n" +
                    "<materia>" + materia+ "</materia>\n" +
                    "<conteudo>" + conteudo + "</conteudo>\n" +
                    "<enunciado>" + enunciado +  "</enunciado>\n" +
                    "</questao>";
    }
    
        @Override
        public String toString() {
           return enunciado;
        }
    
}
