package Tela;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Topicos {
    private int quantidade;
    private String[] titulo;
    private int[] avaliacao;
    private Calendar[] data;
    
    public Topicos(String categoria) {
        if(categoria.equals("Matemática")) {
            /*
            Pega os dados(Tópicos) do Banco de Dados relativo a categoria 
            matematica.
            */
            quantidade=3;
            titulo = new String[quantidade];
            avaliacao = new int[quantidade];
            data = new Calendar[quantidade];
            /*
            Exemplo
            */
            titulo[0] = "A famosa matemágica";
            avaliacao[0] = 575;
            data[0] = new GregorianCalendar( 2016, 8, 28 );
            
            titulo[1] = "Inicio a funções de 2ºgrau";
            avaliacao[1] = 777;
            data[1] = new GregorianCalendar( 2016, 8, 27 );
            
            titulo[2] = "Um tópico sobre matemática";
            avaliacao[2] = 700;
            data[2] = new GregorianCalendar( 2015, 8, 28 );
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

    public Calendar[] getData() {
        return data;
    }

    public void setData(Calendar[] data) {
        this.data = data;
    }
}
