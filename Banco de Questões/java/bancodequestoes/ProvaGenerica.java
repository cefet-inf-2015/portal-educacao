/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodequestoes;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author ThalesGSN
 */
public class ProvaGenerica extends Prova {
//Variaveis de instancia    
       /**Define o numero de questoes total da prova */
   private int numQuestoes;

//construtores

   /**Construtor vazio para uso de sets e gets. */
    public ProvaGenerica() {  }

    /**
     * Contrutor que faz uma prova mista com questoes de qualquer tipo(Multipla escolha, aberta, Verdadeiro ou
     * Falso), pegando somente a materia da prova e o numero de questoes, pegando o tipo de questoes 
     * aleatoriamente e o conteudo definido .
     * @param materia <i>String</i> Que representa a materia da prova
     * @param conteudo <i>String</i> Que representa o conteudo da prova.
     * @param numQuestoes <i>Inteiro</i> que representa o numero de questões total da prova.
     */
    public ProvaGenerica(String materia, String conteudo, int numQuestoes) {
        this.materia = materia;
        this.conteudos.add(conteudo);
        this.numQuestoes = numQuestoes;
    }
    
   /**
     * Contrutor que faz uma prova mista com questoes de qualquer tipo(Multipla escolha, aberta, Verdadeiro ou
     * Falso), pegando somente a materia da prova e o numero de questoes, pegando o tipo de questoes 
     * aleatoriamente e o conteudo e dificuldade media definidos.
     * @param materia <i>String</i> Que representa a materia da prova
     * @param conteudo <i>String</i> Que representa o conteudo da prova.
     * @param numQuestoes <i>Inteiro</i> que representa o numero de questões total da prova.
     * @param dificuldade <i>byte</i> que representa o nivel de dificuldade medio da prova.
     */
    public ProvaGenerica(String materia,String conteudo, int numQuestoes, byte dificuldade) {
        this.materia = materia;
        this.conteudos.add(conteudo);
        this.numQuestoes = numQuestoes;
        this.dificuldade = dificuldade;
    } 
    
//Sets e gets
     /**
     * Gera um numero de questoes aleatorio de cada tipo com limite do parametro passado.
     * @param numQuestoes <i>Inteiro</i> numero da prova a ser gerada.
     */
    public void setNumQuestoes(int numQuestoes) {
       this.numQuestoes = numQuestoes;
    }

      /**
     * Retorna o numero de questões totais da prova da prova.
     * @return <i>Inteiro</i> que representa o numero de questoes totais da prova.
     */
    public int getNumQuestoes() {
        return numQuestoes;
    }
    
    
  
     /**
     * Adiciona uma questão qualquer na prova.
     * @param questao  Objeto questão a ser adicionado na prova
     */
    public void addquestao(Questao questao){
        super.add(questao);
    }

    //@TODO REFAZER GERAR PROVA
//Metodos abstratos herdados de Prova
    @Override
    public boolean gerar() throws SQLException,SAXException, ParserConfigurationException, IOException {
        ConexaoBD conn =  new ConexaoBD();
        
        for(int cont = 0; cont < numFaceis; cont++){
            ResultSet questoes = conn.getQuestoes(materia, conteudos);
           //@TODO PEGA questoes de cada tipo de dificuldade
        }
//       
//        
//       
//       
//       if(numQuestoes > questoes.getFetchSize()) throw new SQLException("Não existe questoes sufucientes"
//               + " no banco.");
//       
//       questoes.first();
//       for(int cont = 0; cont < numQuestoes; cont++){
//            
//                super.add(Questao.newInstance(questoes.getString("XML")));
//          
//           questoes.next();
//       }
//       
     return true;
    }
    

}
