/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author umcan
 */
public class Conexao {
    
    private Connection conexao;
    
    public Conexao(){
        
    }
    
    /**
     * Conecta com o banco de dados
     * @param ip Ip do banco
     * @param user Usuário do banco
     * @param senha Senha do usuário do banco
     * @param banco Nome do banco de dados a ser selecionado
     */
    public void conectar(String ip, String user, String senha, String banco) {
        //Salva a tabela enviada para a conexão
        try {
            //Inicia o driver do MySQL
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Erro ao conectar com o banco de dados!");
        }
        try {
            //Inicia a conexão com o banco de dados
            conexao = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + banco, user, senha);
        } catch (SQLException ex) {
            System.err.println("Erro ao conectar com o banco de dados!");
        }
    }
    
    /**
     * Envia um comando de SQL que retorna algum resultado (Ex. SELECT)
     * @param query
     * @return Resultados obtidos
     * @throws SQLException
     */
    public ResultSet enviarQueryResultados(String query) throws SQLException{
        Statement comando = conexao.createStatement();
        ResultSet resultado = comando.executeQuery(query);
        resultado.first();
        return resultado;
    }
    
    /**
     * Envia query de SQL que não retorna resultados (Ex. CREATE, ALTER, DROP, etc)
     * @param query
     * @return Sucesso ou falha da operação
     * @throws SQLException
     */
    public boolean enviarQuery(String query) throws SQLException{
        Statement comando = conexao.createStatement();
        boolean resultado = comando.execute(query);
        return resultado;
    }
}
