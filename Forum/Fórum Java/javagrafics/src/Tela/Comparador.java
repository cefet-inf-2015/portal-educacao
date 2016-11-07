package Tela;

import java.util.Comparator;

public class Comparador implements Comparator<Dados>{
    public int compare(Dados d, Dados d1) {
       return d.aux[2]*(d.data.compareTo(d1.data)); 
    }
}
