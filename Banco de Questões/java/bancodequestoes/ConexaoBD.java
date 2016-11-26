package bancodequestoes;

import BancoDeDados.Conexao;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;



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
     * @EODARTE voce pode usar esse construtor para conectar e evitar de 
     * consertar todos.
     */
    public ConexaoBD() { 
        super.conectar("localhost", "root", "", "testdb");
    }
    
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
     *  Arraylist que se refere aos conteudos possiveis da prova, exemplo:
     * Materia: Matématica, conteudo: função de segundo grau && inequação do segundo grau
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
     * Colocar XML da prova no BD.
     * @param prova prova a ser adicionada no BD.
     * @return true se e somente se a questão for adicionada com sucesso no BD.
     * @throws SQLException 
     * Se houver algum erro com o BD.
     */
    public boolean enviarProvaDB(Prova prova) throws SQLException{
      return super.enviarQuery("INSERT INTO provas (XML) VALUES "
                + "(\'" + prova.toXML() + "\')");
    }
    
    /**
     * Seleciona uma questão aleatoria do banco de dados de uma materia e de um conteudo
     * e um tipo especifico.
     * @param materia <i>String</i> da materia da questão a ser retornada.
     * @param conteudos
     *  Arraylist que se refere aos conteudos possiveis da prova, exemplo:
     * Materia: Matématica, conteudo: função de segundo grau && inequação do segundo grau
     * @param tipo <i>byte</i> do tipo da questao.
     * @return Todas as questões com os requisitos especificados em ordem aleatoria
     * @throws SQLException 
     * Quando ocorre algum erro na conexão com o banco de dados.
     */
    public ResultSet getQuestoes(String materia, ArrayList<String> conteudos, byte tipo)
            throws SQLException { 
        Iterator it = conteudos.iterator();
       
        String query = "SELECT * FROM questoes WHERE Materia = \'" + materia
                + "\' AND Conteudo = \'" + it.next() + "\'";
        
       while(it.hasNext()){
           query += "\' OR Conteudo = \'" + it.next()+ "\'";
       }
       
       query += " AND Tipo = " + tipo + " ORDER BY RAND()";
   
        return super.enviarQueryResultados(query);
    }
    
    /**
     * Seleciona uma questão aleatoria do banco de dados de uma materia e de um conteudo
     * e um tipo especifico.
     * @param materia <i>String</i> da materia da questão a ser retornada.
     * @param conteudos
     *  Arraylist que se refere aos conteudos possiveis da prova, exemplo:
     * Materia: Matématica, conteudo: função de segundo grau && inequação do segundo grau
     * @param facil
     * @param media
     * @param dificil
      * @return Todas as questões com os requisitos especificados em ordem aleatoria
     * @throws SQLException 
     * Quando ocorre algum erro na conexão com o banco de dados.
     */
    public ResultSet getQuestoes(String materia, ArrayList<String> conteudos, boolean facil, boolean media,
            boolean dificil) throws SQLException { 
        Iterator it = conteudos.iterator();
       
        String query = "SELECT * FROM questoes WHERE Materia = \'" + materia
                + "\' AND conteudo = \'" + it.next() + "\'";
        
       while(it.hasNext()){
           query += "\' OR conteudo = \'" + it.next()+ "\'";
       }
       
       
       if(facil){
           query += " AND dificuldade = " + Questao.FACIL;
           
           if(media) query += " OR dificuldade = " + Questao.MEDIANA;
           if (dificil) query += " OR dificuldade = " + Questao.DIFICIL;
       } else if (media) {
            query += " AND dificuldade = " + Questao.MEDIANA;
            
            if (dificil) query += " OR dificuldade = " + Questao.DIFICIL;
        } else if (dificil) {
            query += " AND dificuldade = " + Questao.DIFICIL;
        }
       
           query += " ORDER BY RAND()";
        return super.enviarQueryResultados(query);
    }
    
    /**
     * Seleciona uma questão aleatoria do banco de dados de uma materia e de um conteudo
     * e um tipo especifico.
     * @param materia <i>String</i> da materia da questão a ser retornada.
     * @param conteudos
     *  Arraylist que se refere aos conteudos possiveis da prova, exemplo:
     * Materia: Matématica, conteudo: função de segundo grau && inequação do segundo grau
     * @param tipo
     * @param facil
     * @param media
     * @param dificil
     * @return Todas as questões com os requisitos especificados em ordem aleatoria
     * @throws SQLException 
     * Quando ocorre algum erro na conexão com o banco de dados.
     */
    public ResultSet getQuestoes(String materia, ArrayList<String> conteudos, byte tipo, boolean facil, 
            boolean media, boolean dificil) throws SQLException { 
        Iterator it = conteudos.iterator();
       
        String query = "SELECT * FROM questoes WHERE Materia = \'" + materia
                + "\' AND conteudo = \'" + it.next() + "\'";
        
       while(it.hasNext()){
           query += "\' OR conteudo = \'" + it.next()+ "\'";
       }
       
       
       if(facil){
           query += " AND dificuldade = " + Questao.FACIL;
           
           if(media) query += " OR dificuldade = " + Questao.MEDIANA;
           if (dificil) query += " OR dificuldade = " + Questao.DIFICIL;
       } else if (media) {
            query += " AND dificuldade = " + Questao.MEDIANA;
            
            if (dificil) query += " OR dificuldade = " + Questao.DIFICIL;
        } else if (dificil) {
            query += " AND dificuldade = " + Questao.DIFICIL;
        }
       
           query += "AND Tipo = " + tipo + " ORDER BY RAND()";
        return super.enviarQueryResultados(query);
    }
    
    /**
     * Seleciona uma questão aleatoria do banco de dados de uma materia e de um conteudo
     * e um tipo especifico.
     * @param materia <i>String</i> da materia da questão a ser retornada.
     * @param conteudos
     *  Arraylist que se refere aos conteudos possiveis da prova, exemplo:
     * Materia: Matématica, conteudo: função de segundo grau && inequação do segundo grau
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
       
       query += "\' AND tipo = " + tipo + " AND dificuldade = " + dificuldade + " ORDER BY RAND()";
        return super.enviarQueryResultados(query);
    }
    
    /**
     * Seleciona uma questão aleatoria do banco de dados de uma materia e de um conteudo
     * e um tipo especifico.
     * @return Todas as questões com os requisitos especificados em ordem aleatoria
     * @throws SQLException 
     * Quando ocorre algum erro na conexão com o banco de dados.
     * @throws java.security.NoSuchAlgorithmException
     */
    public ResultSet getQuestoesUser()  throws SQLException, NoSuchAlgorithmException { 
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
     * @throws java.io.FileNotFoundException
     */
    public boolean addQuestaobd(Questao questao) throws SQLException, FileNotFoundException, IOException{ 
        //Envia tudo menos  o XML para o BD
        super.enviarQuery("INSERT INTO questoes (Materia, Conteudo, Dificuldade, Tipo, User, XML)" +
            " VALUES (\'" + questao.getMateria() + "\', "
                 +  "\'" + questao.getConteudo() + "\', "
                 +  "\'" + questao.getDificuldade()  +  "\', " 
                 +  "\'" + questao.getTipo()  +  "\', " 
                + "\'" + Sessao.usuario.getNickname() + "\'," 
                + "\'nada\'" +
                 ")"); //retorna false caso exista algum erro
        //Pega o id da ultima questão adicionada
         int idQuestao = super.enviarQueryResultados("SELECT ID FROM questoes"
                        + " WHERE user = \'" + Sessao.usuario.getNickname() + "\'" 
                        +  " ORDER BY ID DESC").getInt("ID");
         
            if(questao.getImagem() != null){ // se tiver imagem para ser adicionada
                File imagem = new File(questao.imagem.getPath());
                File destino = new File("\\Temp\\"+ idQuestao + ".jpg");           
                if(!destino.exists()){
                    destino.mkdir(); //se a pasta temp não existir ainda ela cria
                    destino.deleteOnExit(); //deleta a pasta assim que sair do programa
                }
                imagem.renameTo(destino);// copia e muda o nome da imagem para TEMP/ id da questão.jpg
                ssh.SSH.enviarArquivo("", "", "", destino.getPath(), "/banco"); //@RODARTE

            }
            //agora adiciona o xml naquiela questão
            super.enviarQuery("UPDATE questoes SET"
                        + " XML = \'" + questao.toXML() + "\'"
                        + "WHERE ID = " + idQuestao);

        return true;
    }
             
    
    /**
     * Deleta uma questão questão no banco de dados a partir de um objeto questão.
     * @param id Pega o id da questão
     * @throws java.sql.SQLException
     * Quando ha algum erro na conexão com o banco de dados.
     * @return <i>true</i> se e somente se, a questão for deletada com sucesso no banco de dados.
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     * @throws javax.xml.parsers.ParserConfigurationException
     */
    public boolean deleteQuestaobd(int id) 
            throws SQLException, SAXException, IOException, ParserConfigurationException{ 
        String img;
        Questao questao = Questao.newInstance(super.enviarQueryResultados("SELECT XML FROM questoes WHERE "
                + "id = " + id).getString("XML"));
        
        if(questao.getImagem() != null)
            ssh.SSH.deletarArquivo("", "", "", questao.getImagem().getPath()); //@RODARTE
        super.enviarQuery("DELETE FROM questoes WHERE id = " + id);
     return true;
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
        super.enviarQuery("UPDATE questoes SET materia = \'" + questao.getMateria() + "\',"
                +  "conteudo = \'" + questao.getConteudo() + "\',"
                + " dificuldade = \'" + questao.getDificuldade()  +  "\', "
                + "tipo = " +  "\'" + questao.getTipo()  +  "\',"
                + "xml = " + "\'" + questao.toXML() + "\'"
                + " WHERE ID = " + id ); //retorna false caso exista algum erro
            
            if(questao.getImagem() != null){
                File imagem = new File(questao.imagem.getPath());
                File destino = new File("\\Temp\\"+ id + ".jpg");           
                if(!destino.exists()){
                    destino.mkdir();
                    destino.deleteOnExit();
                }
                imagem.renameTo(destino);
                ssh.SSH.enviarArquivo("", "", "", destino.getPath(), "/banco"); //@RODARTE
            }
            //agora adiciona o xml naquiela questão
            super.enviarQuery("UPDATE questoes SET"
                        + " XML = \'" + questao.toXML() + "\'"
                        + " WHERE ID = " + id);

    return true;
    }
    
    /**
     * Pesquisa questões no banco de dados com base na materia conteudo e uma String pesquisa.
     * @param Materia Materia da questão Pesquisada.
     * @param Conteudo Conteudo  da questão Pesquisada.
     * @param pesquisa Texto  da questão Pesquisada.
     * @return ResultSet o resultado das pesquisas.
     * @throws SQLException 
     *  Quando ha algum erro na conexão com o banco de dados.
     */
    public ResultSet pesquisarQuestoes(String Materia, String Conteudo, String pesquisa) throws SQLException{
        String query;
        query = "SELECT * FROM questoes WHERE ";
        if(!(Materia == null) ){
            query += " Materia LIKE \'%" + Materia + "%\' ";
            if(!(Conteudo== null) || !(pesquisa == null)) query += " AND ";
        }
        if(!(Conteudo == null)){
            query +=  " Conteudo LIKE \'%" + Conteudo + "%\' ";
            if(!(pesquisa== null)) query += " AND ";
        }
        if(!(pesquisa== null)) query += " XML LIKE \'%" + pesquisa + "%\' ";
        
        query += "ORDER BY ID ASC";
        return super.enviarQueryResultados(query);
    }
    
    @Override
    public String toString() {
        return super.toString();
    }

}

