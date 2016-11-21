package Tela;

import BancoDeDados.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class Topicos {
    private int quantidade;
    private String[] titulo;
    private String[] autor;
    private int[] avaliacao;
    private String[] data;
    private String ip;
    private String user;
    private String senha;
    private String banco;
    private ResultSet resultado;
    private String comando;
    public Topicos(String categoria) throws SQLException {
            categoria = categoria.replaceAll("[aáàãâä]","a");
            categoria = categoria.replaceAll("[eéèêë]","e");
            categoria = categoria.replaceAll("[iíìîï]","i");
            categoria = categoria.replaceAll("[oóòõôö]","o");
            categoria = categoria.replaceAll("[uúùûü]","u");
            System.out.println(categoria);
            Conexao conec = new Conexao();
            /*
            ip = "cefet-inf-2015.ddns.net:43306";
            user = "forum";
            senha = "inf2015";
            */
            ip = "localhost";
            user = "root";
            senha = "";
            banco = "bdforum";
            try {
                conec.conectar(ip, user, senha, banco);
                //comando = "SELECT * FROM `"+categoria+"`";
                comando = "SELECT * FROM "+categoria+" WHERE Comentario='0'";
                resultado = conec.enviarQueryResultados(comando);
                resultado.last();
                quantidade =  resultado.getRow();
                resultado.first();

                titulo = new String[quantidade];
                autor = new String[quantidade];
                avaliacao = new int[quantidade];
                data = new String[quantidade];

                for(int i=0; i<quantidade; i++) {
                    String[] aux = new String[3];
                    titulo[i] = resultado.getString("Titulo");
                    autor[i] = resultado.getString("Autor");
                    avaliacao[i] = resultado.getInt("Avaliacao");
                    aux = resultado.getString("Data").split("/");
                    if(Integer.parseInt(aux[0])<10) {
                        data[i] = "0"+resultado.getString("Data");
                    } else {
                        data[i] = resultado.getString("Data");
                    }
                    
                    resultado.next();
                }
            } catch(Exception ex) {
                System.out.println("Erro: "+ex);
            }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String[] getTitulo() {
        return titulo;
    }

    public void setTitulo(String[] titulo) {
        this.titulo = titulo;
    }

    public int[] getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int[] avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public String[] getAutor() {
        return autor;
    }

    public void setAutor(String[] autor) {
        this.autor = autor;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
    
}
