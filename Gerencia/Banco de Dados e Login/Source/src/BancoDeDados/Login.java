/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoDeDados;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import ssh.SSH;

/**
 *
 * @author Aluno
 */
public class Login {

    private static Conexao conexao;
    
    //Pra salvar ArrayLists deve ser usado o método Join

    /**
     * Faz a conexão com o banco de dados
     *
     * @param ip Ip do banco
     * @param user Usuário do banco
     * @param senha Senha do usuário do banco
     * @param banco Nome do banco de dados a ser selecionado
     */
    
    public static void conectarBanco(String ip, String user, String senha, String banco) {
        conexao = new Conexao();
        conexao.conectar(ip, user, senha, banco);
    }
    
    private static String md5(String senha){
		String sen = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
		sen = hash.toString(16);			
		return sen;
    }
    
    private static ImageIcon baixarFoto(String path){
        String arquivo[] = path.split("\\/");
        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", path, arquivo[arquivo.length-1]);
        return new ImageIcon(arquivo[arquivo.length-1]);
    }

    /**
     * Realiza o login de um aluno
     * 
     * @param username Nome de usuario do aluno
     * @param senha Senha do aluno
     * @param tabela Tabela do banco em que os alunos estão guardados
     * @return Aluno
     * @throws SQLException
     */
    public static Aluno logarAluno(String username, String senha, String tabela) throws SQLException {
        ResultSet resultado = conexao.enviarQueryResultados("SELECT * FROM " + tabela + " WHERE username=\'" + username + "\' AND senha=\'" + md5(senha) + "\'");
        resultado.first();
        //Instancia um novo usuário com os dados recuperados do Banco de Dados
        Aluno usuario;
        usuario = new Aluno(resultado.getString("primeiroNome"), 
                resultado.getString("ultimoNome"),
                resultado.getString("username"),
                baixarFoto(resultado.getString("foto")),
                resultado.getString("matricula"),
                resultado.getString("turma"),
                resultado.getString("divisao"));
        resultado.close();
        return usuario;
    }
    /**
     * Realiza o login de um diretor
     * 
     * @param username Nome de usuario do diretor
     * @param senha Senha do diretor
     * @param tabela Tabela do banco em que os diretores estão guardados
     * @return Diretor
     * @throws SQLException
     */
    public static Diretor logarDiretor(String username, String senha, String tabela) throws SQLException {
        ResultSet resultado = conexao.enviarQueryResultados("SELECT * FROM " + tabela + " WHERE username=\'" + username + "\' AND senha=\'" + md5(senha) + "\'");
        resultado.first();
        //Instancia um novo usuário com os dados recuperados do Banco de Dados
        Diretor usuario = new Diretor(resultado.getString("primeiroNome"), 
                              resultado.getString("ultimoNome"), 
                              resultado.getString("username"), 
                              baixarFoto(resultado.getString("foto")),
                              resultado.getString("matricula"));
        resultado.close();
        return usuario;
    }
    /**
     * Realiza o login de um professor
     * 
     * @param username Nome de usuario do professor
     * @param senha Senha do professor
     * @param tabela Tabela do banco em que os professores estão guardados
     * @throws SQLException
     */
    public static Professor logarProfessor(String username, String senha, String tabela) throws SQLException {
        ResultSet resultado = conexao.enviarQueryResultados("SELECT * FROM " + tabela + " WHERE username=\'" + username + "\' AND senha=\'" + md5(senha) + "\'");
        resultado.first();
        //Instancia um novo usuário com os dados recuperados do Banco de Dados
        Professor usuario;
        usuario = new Professor(resultado.getString("primeiroNome"), 
                resultado.getString("ultimoNome"),
                resultado.getString("username"),
                baixarFoto(resultado.getString("foto")),
                resultado.getString("matricula"),
                new ArrayList(Arrays.asList(resultado.getString("turmas").split(","))));
        resultado.close();
        return usuario;
    }
    /**
     * Realiza o login de um coordenador
     * 
     * @param username Nome de usuario do coordenador
     * @param senha Senha do coordenador
     * @param tabela Tabela do banco em que os coordenadores estão guardados
     * @return Coordenador
     * @throws SQLException
     */
    public static Coordenador logarCoordenador(String username, String senha, String tabela) throws SQLException {
        ResultSet resultado = conexao.enviarQueryResultados("SELECT * FROM " + tabela + " WHERE username=\'" + username + "\' AND senha=\'" + md5(senha) + "\'");
        resultado.first();
        //Instancia um novo usuário com os dados recuperados do Banco de Dados
        Coordenador usuario = new Coordenador(resultado.getString("primeiroNome"), 
                              resultado.getString("ultimoNome"), 
                              resultado.getString("username"), 
                              baixarFoto(resultado.getString("foto")),
                              resultado.getString("matricula"),
                              new ArrayList(Arrays.asList(resultado.getString("cursos").split(","))));
        resultado.close();
        return usuario;
    }

}
