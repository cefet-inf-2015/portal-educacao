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
 *  Prova especifica é um tipo de prova que voce pode escolher o numero de multipla escolha v ou f e de abertas.
 * @author ThalesGSN
 */
public class ProvaEspecifica extends Prova{
//Variaveis de instancia
    /** Numero inteiro que representa o numero de questoes de multipla escolha da prova.*/ 
   private int numMultiplaEscolha;
    /** Numero inteiro que representa o numero de questoes de V ou F da prova.*/
   private int numVF;
    /** Numero inteiro que representa o numero de questoes Abertas da prova.*/
   private int numAbertas;

//Construtores
   /**
    * Para usar com sets e gets.
    */
   public ProvaEspecifica() {  }
   
   /**
     * Contrutor que faz uma prova mista com questoes de qualquer tipo(Multipla escolha, aberta, Verdadeiro ou
     * Falso), pegando somente a materia da prova e o numero de questoes de cada tipo, pegando questoes 
     * aleatoriamente. 
     * @param materia <i>String</i> Que representa a materia da prova
     * @param numMultiplaEscolha <i>Inteiro</i> que representa o numero de questões multipla escolha da prova.
     * @param numVF <i>Inteiro</i> que representa o numero de questões Verdadeiro ou Falso da prova.
     * @param numAbertas   <i>Inteiro</i> que representa o numero de questões abertas da prova.
     */
    public ProvaEspecifica(String materia, int numMultiplaEscolha, int numVF, int numAbertas) {
        this.materia = materia;
        this.numMultiplaEscolha = numMultiplaEscolha;
        this.numVF = numVF;
        this.numAbertas = numAbertas; 
    }
    
    /**
     * Contrutor que faz uma prova mista com questoes de qualquer tipo(Multipla escolha, aberta, Verdadeiro ou
     * Falso), pegando somente a materia da prova e o numero de questoes de cada tipo, pegando questoes 
     * aleatoriamente e o conteudo definido 
     * @param materia <i>String</i> Que representa a materia da prova
     * @param conteudo <i>String</i> Que representa o conteudo da prova.
     * @param numMultiplaEscolha <i>Inteiro</i> que representa o numero de questões multipla escolha da prova.
     * @param numVF <i>Inteiro</i> que representa o numero de questões Verdadeiro ou Falso da prova.
     * @param numAbertas   <i>Inteiro</i> que representa o numero de questões abertas da prova.
     */
    public ProvaEspecifica(String materia,String conteudo, int numMultiplaEscolha, int numVF, int numAbertas) {
        this.materia = materia;
        this.numMultiplaEscolha = numMultiplaEscolha;
        this.numVF = numVF;
        this.numAbertas = numAbertas;
        this.conteudos.add(conteudo);
    }

//Sets e Gets
    
    /**
     * Retorna o numero de questões multipla escolha  da prova.
     * @return <i>Inteiro</i> que representa o numero de questoes multipla escolha  da prova.
     */
    public int getNumMultiplaEscolha() {
        return numMultiplaEscolha;
    }

    /**
     * Altera ou define o numero de questões multipla escolha da prova.
     * @param numMultiplaEscolha <i>Inteiro</i> que representa o numero de questoes multipla
     * escolha  da prova.
     */
    public void setNumMultiplaEscolha(int numMultiplaEscolha) {
        this.numMultiplaEscolha = numMultiplaEscolha;
    }

    /**
     * Retorna o numero de questões verdadeiro ou falso da prova.
     * @return <i>Inteiro</i> que representa o numero de questoes verdadeiro ou falso da prova.
     */
    public int getNumVF() {
        return numVF;
    }

    /**
     * Altera ou define o numero de questões v ou F da prova.
     * @param numVF <i>Inteiro</i> que representa o numero de questoes verdadeiro 
     * ou falso da prova.
     */
    public void setNumVF(int numVF) {
        this.numVF = numVF;
    }

    /**
     * Retorna o numero de questões abertas da prova.
     * @return <i>Inteiro</i> que representa o numero de questoes abertas da prova.
     */
    public int getNumAbertas() {
        return numAbertas;
    }

    /**
     * Altera ou define o numero de questões abertas da prova.
     * @param numAbertas <i>Inteiro</i> numero de questoes abertas da prova.
     */
    public void setNumAbertas(int numAbertas) {
        this.numAbertas = numAbertas;
    }
    
   /**
     * Retorna o numero de questões totais da prova da prova.
     * @return <i>Inteiro</i> que representa o numero de questoes totais da prova.
     */
    public int getNumQuestoes(){
        return numMultiplaEscolha + numVF + numAbertas;
    }
    
      /**
     * Adiciona uma questão qualquer na prova.
     * @param questao  Objeto questão a ser adicionado na prova
     */
    public void addquestao(Questao questao){
        super.add(questao);
        switch(questao.getTipo()){
            case MULTIPLA_ESCOLHA:
                numMultiplaEscolha++;
             break;
             case VERDADEIRO_FALSO:
                 numVF++;
              break;
              case ABERTA:
                  numAbertas++;
               break;
        }
    }

//Metodos herdados de Prova
    @Override
    public boolean gerar() throws SQLException, ParserConfigurationException, SAXException, IOException {
       ConexaoBD conn = new ConexaoBD();
        ResultSet questoes;
         int rowCount = 0;
         
        if(super.isFacil() || super.isMediana() || super.IsDificil()) {//se tiver preferencia por dificuldade
            if(numMultiplaEscolha > 0){//se existir necessidade de gerer multipla escolha
                //Pega todas as questões que se encaxam no padrão
                questoes = conn.getQuestoes(materia, conteudos, Questao.MULTIPLA_ESCOLHA, super.isFacil(), 
                        super.isMediana(), super.IsDificil());
                //verifica se ha questões suficiente  caso contrario joga uma exeção
                if(questoes.last()){
                    rowCount = questoes.getRow(); 
                    questoes.beforeFirst();
                }
        
                if(numMultiplaEscolha > rowCount) throw new SQLException("Questões insuficientes no banco de dados.\n"
                        + "Desculpe o inconviniente e nos ajude a melhorar adicionando novas questões no banco.");
                
                //adiciona as questões na prova
                for(int cont = 0; cont < numMultiplaEscolha; cont++){
                    //move o ponteiro pra proxima linha
                    questoes.next();
                    //pega a coluna de xml e monta um novo objeto e adiciona na prova
                    super.add(new MultiplaEscolha(questoes.getString("XML")));
                }
            }
            if(numVF > 0){
                questoes = conn.getQuestoes(materia, conteudos, Questao.VERDADEIRO_FALSO, super.isFacil(), 
                        super.isMediana(), super.IsDificil());
                if(questoes.last()){
                    rowCount = questoes.getRow(); 
                    questoes.beforeFirst();
                }
        
                if(numVF > rowCount) throw new SQLException("Questões insuficientes no banco de dados.\n"
                        + "Desculpe o  inconviniente e nos ajude a melhorar adicionando novas questões no banco.");
                for(int cont = 0; cont < numVF; cont++){
                    questoes.next();
                    super.add(new VOuF(questoes.getString("XML")));
                }
            }
                if(numAbertas > 0){
                questoes = conn.getQuestoes(materia, conteudos, Questao.ABERTA, super.isFacil(), 
                        super.isMediana(), super.IsDificil());
                
                if(questoes.last()){
                    rowCount = questoes.getRow(); 
                    questoes.beforeFirst();
                }
        
                if(numAbertas > rowCount) throw new SQLException("Questões insuficientes no banco de dados.\n"
                        + "Desculpe o  inconviniente e nos ajude a melhorar adicionando novas questões no banco.");
                for(int cont = 0; cont < numAbertas; cont++){
                    questoes.next();
                    super.add(new Aberta(questoes.getString("XML")));
                }
            }
        } else{ // se o usuario não tiver preferencia por dificuldade
            
            if(numMultiplaEscolha > 0){//se existir questoes multipla escolha a ser gerado
                //pega todas as questões da materia e conteudos de multipla escolha do banco
                questoes = conn.getQuestoes(materia, conteudos, Questao.MULTIPLA_ESCOLHA);
                //verifica se ha questões suficientes no banco caso contrario lança exceção
               if(questoes.last()){
                    rowCount = questoes.getRow(); 
                    questoes.beforeFirst();
                }
        
                if(numMultiplaEscolha > rowCount) throw new SQLException("Questões insuficientes no banco de dados.\n"
                        + "Desculpe o  inconviniente e nos ajude a melhorar adicionando novas questões no banco.");
                //adiciona as questões na prova
                for(int cont = 0; cont < numMultiplaEscolha; cont++){
                    //move o ponteiro pra proxima linha
                    questoes.next();
                    //pega a coluna de xml e monta um novo objeto e adiciona na prova
                    super.add(new MultiplaEscolha(questoes.getString("XML")));
                    
                }
            }
            
            if(numVF > 0){
                questoes = conn.getQuestoes(materia, conteudos, Questao.VERDADEIRO_FALSO);
                if(questoes.last()){
                    rowCount = questoes.getRow(); 
                    questoes.beforeFirst();
                }
        
                if(numVF > rowCount) throw new SQLException("Questões insuficientes no banco de dados.\n"
                        + "Desculpe o  inconviniente e nos ajude a melhorar adicionando novas questões no banco.");
                for(int cont = 0; cont < numVF; cont++){
                    questoes.next();
                    super.add(new VOuF(questoes.getString("XML")));
                }
            }
            
             if(numAbertas > 0){
                questoes = conn.getQuestoes(materia, conteudos, Questao.ABERTA);
                
                if(questoes.last()){
                    rowCount = questoes.getRow(); 
                    System.out.println(rowCount);
                    questoes.beforeFirst();
                }
        
                if(numAbertas > rowCount) throw new SQLException("Questões insuficientes no banco de dados.\n"
                        + "Desculpe o  inconviniente e nos ajude a melhorar adicionando novas questões no banco.");
                
                for(int cont = 0; cont < numAbertas; cont++){
                    questoes.next();
                    super.add(new Aberta(questoes.getString("XML")));
                }
            }
        }

       return true;
  }
}    

