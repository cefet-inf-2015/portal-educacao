/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import BancoDeDados.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Victor
 */
public class MostraTopico extends Exibicao{
    private String ip;
    private String user;
    private String senha;
    private String banco;
    private ResultSet resultado;
    private String comando;
    private String categoria;
    private String titulo;
    private int quantidade;
    private int numeroPag;
    private int contador;
    private int PagAtual;
    private ResultSet resultadoUsuario;
    private Conexao conec;
    public MostraTopico() {
        
    }
    public void CarregaTopico() throws SQLException {
        PagAtual=0;
        categoria = categoria.replaceAll("[aáàãâä]","a");
        categoria = categoria.replaceAll("[eéèêë]","e");
        categoria = categoria.replaceAll("[iíìîï]","i");
        categoria = categoria.replaceAll("[oóòõôö]","o");
        categoria = categoria.replaceAll("[uúùûü]","u");
        conec = new Conexao();
        ip = "cefet-inf-2015.ddns.net:43306";
        user = "forum";
        senha = "inf2015";
        banco = "bdforum";
        try {    
            conec.conectar(ip, user, senha, banco);
            comando = "SELECT * FROM "+categoria+" WHERE Titulo='"+titulo+"'";
            resultado = conec.enviarQueryResultados(comando);
            //comando = "SELECT * FROM usuario WHERE nome='"+
            //resultado.getString("Autor")+"'";
            resultado.last();
            quantidade = resultado.getRow();
            if((quantidade%5)==0) {
                numeroPag = ((quantidade-(quantidade%5))/5);
            } else {
                numeroPag = (((quantidade-(quantidade%5))/5)+1);
            }
            System.out.println("N de linhas: "+resultado.getRow()+"\nPag:"+numeroPag);
            CarregaPagina();
            
            
        } catch(Exception ex) {
                System.out.println("Erro Alou!: "+ex);
        }
    }
    public String Formata(String resultado) {
        String TextoFormatado = resultado;
        TextoFormatado = TextoFormatado.replaceAll("<div style=\"color:"
        +" grey\"> ", "");
        TextoFormatado = TextoFormatado.replaceAll("<br>", "\n");
        TextoFormatado = TextoFormatado.replaceAll("\"", "");
        TextoFormatado = TextoFormatado.replaceAll(
        "				"
        +"						 ", "");
        TextoFormatado = TextoFormatado.replaceAll("</div>", 
        "---------------------------"
        +"-----------------------------------------------------------");
        return TextoFormatado;
    }
    
    public void CarregaPagina() throws SQLException {
        if(PagAtual<numeroPag) {
            String[] Conteudo = new String[5];
            String[] Usuario = new String[5];
            resultado.first();
            for(int i=0; i<(PagAtual*5); i++) resultado.next();
            if((PagAtual+1)!=numeroPag) {
                System.out.println("Até aqui chegou");
                for(int i=0; i<5; i++) {
                    Conteudo[i] = Formata(resultado.getString("Conteudo"));
                    resultado.next();
                }
                
                //jLabel17.setText(Formata(resultado.getString("Conteudo")));
                
                //jTextArea15.setText(Formata(resultado.getString("Conteudo")));
                jTextArea16.setText(Conteudo[0]);

                //jLabel14.setText(Formata(resultado.getString("Conteudo")));
                //jTextArea2.setText(Formata(resultado.getString("Conteudo")));
                jTextArea7.setText(Conteudo[1]);

                //jLabel16.setText(Formata(resultado.getString("Conteudo")));
                //jTextArea1.setText(Formata(resultado.getString("Conteudo")));
                jTextArea8.setText(Conteudo[2]);

                //jLabel18.setText(Formata(resultado.getString("Conteudo")));
                //jTextArea4.setText(Formata(resultado.getString("Conteudo")));
                jTextArea9.setText(Conteudo[3]);

                //jLabel20.setText(Formata(resultado.getString("Conteudo")));
                //jTextArea5.setText(Formata(resultado.getString("Conteudo")));
                jTextArea10.setText(Conteudo[4]);
            } else {
                for(int i=0; i<(quantidade%5); i++) {
                    Conteudo[i] = Formata(resultado.getString("Conteudo"));
                    //resultadoUsuario = conec.enviarQueryResultados(comando);
                    //Usuario[i] = formataUsuario(resultadoUsuario);
                    resultado.next();
                }
                for(int i=(quantidade%5); i<5; i++) {
                    Conteudo[i] = " ";
                    Usuario[i] = " ";
                    resultado.next();
                }
                //jLabel17.setText(Formata(resultado.getString("Conteudo")));
                
                //jTextArea15.setText(Usuario[0]);
                jTextArea16.setText(Conteudo[0]);

                //jLabel14.setText(Formata(resultado.getString("Conteudo")));
                //jTextArea2.setText(Usuario[1]);
                jTextArea7.setText(Conteudo[1]);

                //jLabel16.setText(Formata(resultado.getString("Conteudo")));
                //jTextArea1.setText(Usuario[2]);
                jTextArea8.setText(Conteudo[2]);

                //jLabel18.setText(Formata(resultado.getString("Conteudo")));
                //jTextArea4.setText(Usuario[3]);
                jTextArea9.setText(Conteudo[3]);

                //jLabel20.setText(Formata(resultado.getString("Conteudo")));
                //jTextArea5.setText(Usuario[4]);
                jTextArea10.setText(Conteudo[4]);
            }
            PagAtual++;
        }
    }
    
    public void VoltaPagina() throws SQLException {
        if(PagAtual>1) {
            String[] Conteudo = new String[5];
            resultado.first();
            for(int i=0; i<((PagAtual-2)*5); i++) resultado.next();
                for(int i=0; i<5; i++) {
                    Conteudo[i] = Formata(resultado.getString("Conteudo"));
                    resultado.next();
                }
                //jLabel17.setText(Formata(resultado.getString("Conteudo")));
                //jTextArea15.setText(Formata(resultado.getString("Conteudo")));
                jTextArea16.setText(Conteudo[0]);

                //jLabel14.setText(Formata(resultado.getString("Conteudo")));
                //jTextArea2.setText(Formata(resultado.getString("Conteudo")));
                jTextArea7.setText(Conteudo[1]);

                //jLabel16.setText(Formata(resultado.getString("Conteudo")));
                //jTextArea1.setText(Formata(resultado.getString("Conteudo")));
                jTextArea8.setText(Conteudo[2]);

                //jLabel18.setText(Formata(resultado.getString("Conteudo")));
                //jTextArea4.setText(Formata(resultado.getString("Conteudo")));
                jTextArea9.setText(Conteudo[3]);

                //jLabel20.setText(Formata(resultado.getString("Conteudo")));
                //jTextArea5.setText(Formata(resultado.getString("Conteudo")));
                jTextArea10.setText(Conteudo[4]);
            PagAtual--;
        }
    }
    
    public String formataUsuario(ResultSet resultado) throws SQLException {
        String formatado = "Nome:\n"+resultado.getString("nome")
        +" ("+resultado.getString("tipo")+")"
        +"\nMatrícula: \n"+resultado.getString("matricula")+"\nPosts: \n"
        +resultado.getString("comentarios");
        return formatado;
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

    public ResultSet getResultado() {
        return resultado;
    }

    public void setResultado(ResultSet resultado) {
        this.resultado = resultado;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getNumeroPag() {
        return numeroPag;
    }

    public void setNumeroPag(int numeroPag) {
        this.numeroPag = numeroPag;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
}
