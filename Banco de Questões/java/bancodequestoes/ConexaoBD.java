package bancodequestoes;

import BancoDeDados.Conexao;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;



/**
 *  Classe que faz todas as interações com o banco de dados na tarefa de <b>Banco de questões</b>,
 *  realiza as Querys, salva no <b>banco de dados</b> e faz o retorno das informações necessarias.
 * 
 * O objetivo dessa classe é otimizar e simplificar o codigo da classe <b>Questão</b> tornando a mais
 * objetiva.
 * @author ThalesGSN
 */
public class ConexaoBD extends Conexao {
//Variaveis de instancia    
   
//Construtores
    /**
     * Construtor vazio para construir o objeto usando sets e gets.
     */
    public ConexaoBD() {   }
    
     /**
     *  Construtor que trabalha com três parametros e inicia uma conexão com o <b>banco de dados</b>, nesse objeto.
     * 
     * @param endereco Endereço IP de onde o <b>banco de dados</b> se apresenta.
     * @param user  <i>String</i> que representa o nome de usuario da conexão.
     * @param nomeBD Nome do <b>banco de dados</b>.
     * @param senha  <i>String</i> que representa a senha da conexão.
     * @throws java.sql.SQLException
     * Quando ocorre algum erro na conexão com o banco de dados.
     */
    public ConexaoBD(String endereco, String user, String senha, String nomeBD) throws SQLException{ 
        super.conectar(endereco, user, senha, nomeBD);  
    }
  
 //Metodos Uteis
    /**
     * Seleciona uma questão aleatoria do banco de dados de uma materia qualquer.
     * @param materia <i>String</i> que define a materia da questão que vai ser retornada.
     * @return <i>ResultSet</i> das questões com a materia especificada.
     * @throws SQLException 
     * Quando ocorre algum erro na conexão com o banco de dados
     */
    public ResultSet getQuestoes(String materia)  throws SQLException{  
           return  super.enviarQueryResultados("SELECT * FROM questoes WHERE Materia = \'" + materia + "\'"
                   + " ORDER BY rand()");
    }
    
    /**
     * Seleciona uma questão aleatoria do banco de dados de uma materia e de um conteudo
     * especificos.
     * @param materia <i>String</i> da materia da questão a ser retornada.
     * @param conteudos
     * @return As questões da materia especificada em ordem aleatoria.
     * @throws SQLException 
     * Quando ocorre algum erro na conexão com o banco de dados.
     */
    public ResultSet getQuestoes(String materia, ArrayList<String> conteudos)  throws SQLException{
        Iterator it = conteudos.iterator();
       
        String query = "SELECT * FROM questoes WHERE Materia = \'" + materia
                + "\' AND conteudo = \'" + it.next() + "\'";
        
       while(it.hasNext()){
           query += "\' OR conteudo = \'" + it.next()+ "\'";
       }
       
       query += " ORDER BY RAND()";
        return super.enviarQueryResultados(query);
    }
    
    
    /**
     * Seleciona uma questão aleatoria do banco de dados de uma materia e de um conteudo
     * e um tipo especifico.
     * @param materia <i>String</i> da materia da questão a ser retornada.
     * @param conteudos
     * @param dificuldade <i>byte</i> do nivel da dificuldade da questao.
      * @return Todas as questões com os requisitos especificados em ordem aleatoria
     * @throws SQLException 
     * Quando ocorre algum erro na conexão com o banco de dados.
     */
    public ResultSet getQuestoesGenericas(String materia, ArrayList<String> conteudos, byte dificuldade)
            throws SQLException { 
        Iterator it = conteudos.iterator();
       
        String query = "SELECT * FROM questoes WHERE Materia = \'" + materia
                + "\' AND conteudo = \'" + it.next() + "\'";
        
       while(it.hasNext()){
           query += "\' OR conteudo = \'" + it.next()+ "\'";
       }
       
       query += "\'  AND dificuldade = \' " + dificuldade + " \' ORDER BY RAND()";
        return super.enviarQueryResultados(query);
    }
    
    /**
     * Seleciona uma questão aleatoria do banco de dados de uma materia e de um conteudo
     * e um tipo especifico.
     * @param materia <i>String</i> da materia da questão a ser retornada.
     * @param conteudos
     * @param tipo <i>byte</i> do tipo da questão a ser adicionada.
     * Veja as constantes da classe questão.
     * @param dificuldade <i>byte</i> do nivel da dificuldade da questao.
      * @return Todas as questões com os requisitos especificados em ordem aleatoria
     * @throws SQLException 
     * Quando ocorre algum erro na conexão com o banco de dados.
     */
    public ResultSet getQuestoes(String materia, ArrayList<String> conteudos, byte tipo, byte dificuldade)
            throws SQLException { 
        Iterator it = conteudos.iterator();
       
        String query = "SELECT * FROM questoes WHERE Materia = \'" + materia
                + "\' AND conteudo = \'" + it.next() + "\'";
        
       while(it.hasNext()){
           query += "\' OR conteudo = \'" + it.next()+ "\'";
       }
       
       query += "\' AND tipo = \'" + tipo + "\' AND dificuldade = \'" + dificuldade + "\' ORDER BY RAND()";
        return super.enviarQueryResultados(query);
    }
    
    /**
     * Seleciona uma questão aleatoria do banco de dados de uma materia e de um conteudo
     * e um tipo especifico.
     
     * @param user
     * @return Todas as questões com os requisitos especificados em ordem aleatoria
     * @throws SQLException 
     * Quando ocorre algum erro na conexão com o banco de dados.
     * @throws java.security.NoSuchAlgorithmException
     */
    public ResultSet getQuestoesUser(User user)
            throws SQLException, NoSuchAlgorithmException { 
           return super.enviarQueryResultados("SELECT * FROM questoes WHERE user = \'" +  
                  Sessao.usuario.getNickname() + "\' ORDER BY ID ASC" );
    }
    
    
    /**
     * Adiciona questão no banco de dados a partir de um objeto questão.
     * @throws java.sql.SQLException
     * Quando ha algum erro na conexão com o banco de dados.
     * @param questao
     * <i>Questao</i> a ser addicionada no banco de dados.
     * @return <i>true</i> se e somente se, a questão for adicionada com sucesso no banco de dados.
     */
    public boolean addQuestaobd(Questao questao) throws SQLException{ 
        return super.enviarQuery("INSERT INTO questoes (materia, conteudo, dificuldade, tipo, xml, user) " +
            "VALUES (" + "\'" + questao.getMateria() + "\', "
                +  "\'" + questao.getConteudo() + "\', "
                 +  "\'" + questao.getDificuldade()  +  "\', " 
                 +  "\'" + questao.getTipo()  +  "\', "
                + "\'" + questao.toXML() + "\'" +
                "\'" + Sessao.usuario.getNickname() + "\'" +
                ")"); //retorna false caso exista algum erro
    }
    
    /**
     * Deleta uma questão questão no banco de dados a partir de um objeto questão.
     * @param id Pega o id da questão
     * @throws java.sql.SQLException
     * Quando ha algum erro na conexão com o banco de dados.
     * @return <i>true</i> se e somente se, a questão for deletada com sucesso no banco de dados.
     */
    public boolean deleteQuestaobd(int id) throws SQLException{ 
                    return super.enviarQuery("DELETE FROM questoes WHERE id = " + "\'" + id + "\'");
   }
    
    /**
     *Edita uma questão questão no banco de dados a partir de um objeto questão antigo e um novo, esse objeto
     * antigo sera subistituido no banco de dados pelo novo. 
     * @param id
     * Id da quetão a ser alterada
     * @param questao
     * O novo objeto questao a ser atualizado no banco de dados
     * @return <i>true</i> se e somente se, a questão for deletada com sucesso no banco de dados.
     * @throws java.sql.SQLException

     */
    public boolean editQuestaobd(int id, Questao questao)  throws  SQLException{
        return super.enviarQuery("UPDATE questoes SET materia = \'" + questao.getMateria() + "\',"
                +  "conteudo = \'" + questao.getConteudo() + "\',"
                + " dificuldade = \'" + questao.getDificuldade()  +  "\', "
                + "tipo = " +  "\'" + questao.getTipo()  +  "\',"
                + "xml = " + "\'" + questao.toXML() + "\'"
                + " WHERE ID = " + id + "\'"
                
             ); //retorna false caso exista algum erro
    }
    
    @Override
    public String toString() {
        return super.toString();
    }

}

