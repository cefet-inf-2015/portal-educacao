package Tela;

import java.util.*;
class Dados implements Comparator<Dados>, Comparable<Dados> {
   protected String Titulo;
   protected int avaliacao;
   protected Calendar data;
   protected static int[] aux;
   Dados() {
   }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
   
   Dados(String n, int av, Calendar d) {
      Titulo = n;
      avaliacao = av;
      data = d;
   }

    public static int[] getAux() {
        return aux;
    }

    public static void setAux(int[] aux) {
        Dados.aux = aux;
    }

    
   
    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }
   
   // Overriding the compareTo method
    public int compareTo(Dados d) { //Metodo relacionado ao modo de sort
       return aux[0]*((this.Titulo).compareTo(d.Titulo));
    }
    

   // Overriding the compare method to sort the age 
   public int compare(Dados d, Dados d1) { //Metodo relacionado ao metodo de sort comparator
       return aux[1]*(d.avaliacao - d1.avaliacao);
   }
   
}   
