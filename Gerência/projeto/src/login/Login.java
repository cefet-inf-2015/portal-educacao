/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;

/**
 *
 * @author Aluno
 */
public class Login {

    private static Usuario usuario;
    private static Connection conexao;
    private static String tabela;
    /**
     * retorna o usuario 
     * @return the usuario
     */
    public static Usuario getUsuario() {
        return usuario;
    }

    /**
     * Faz a conexão com o banco de dados
     *
     * @param ip  ip do banco de dados
     * @param user usuario 
     * @param senha senha do Banco de dados
     * @param banco nome do banco que deseja-se conectar
     * @param tabela Tabela do banco que deseja-se conectar
     */
    public static void conectarBanco(String ip, String user, String senha, String banco, String tabela) {
        //Salva a tabela enviada para a conexão
        Login.tabela=tabela;
        try {
            //Inicia o driver do MySQL
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Erro ao conectar com o banco de dados!");
        }
        try {
            //Inicia a conexão com o banco de dados
            conexao = DriverManager.getConnection("jdbc:mysql://" + ip 
                    + ":3306/" + banco, user, senha);
        } catch (SQLException ex) {
            System.err.println("Erro ao conectar com o banco de dados!");
        }
    }

    /**
     * Realiza o login de um usuario
     * 
     * @param username Nome do usuario
     * @param senha Senha
     * @throws SQLException
     */
    public static void logarUsuario(String username, String senha) throws SQLException {
        Statement comando = conexao.createStatement();
        //executa os comandos de SQL para buscar os dados da tabela
        ResultSet resultado = comando.executeQuery("SELECT * FROM " + tabela + 
                " WHERE username=\'" + username + "\' AND senha=\'" + senha + "\'");
        resultado.first();
        //Recupera os dados binários da foto
        Blob blob = resultado.getBlob("foto");
        //Instancia um novo usuário com os dados recuperados do Banco de Dados
        usuario = new Usuario(resultado.getString("primeiroNome"), 
                              resultado.getString("ultimoNome"), 
                              resultado.getString("username"), 
                              new ImageIcon(blob.getBytes(1, (int) blob.length())), 
                              resultado.getString("matricula"));
        resultado.close();
        comando.close();
    }

}
