package Tela;

import Tela.Comparador;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame{
    protected GridLayout layout;
    protected JPanel painel;
    protected JButton[] botao;
    protected ArrayList<Dados> lista;
    protected Dados dados;
    protected int[] aux;
    protected String espacamento;
    protected int size;
    protected String linha;
    protected DefaultListModel listModel;
    public Frame() {
        size=100;
        aux = new int[3];
        for(int i=0; i<aux.length; i++) aux[i]=-1;
        Dados.setAux(aux);
        lista = new ArrayList<Dados>();
        botao = new JButton[3];
        layout = new GridLayout(10,0);
        botao[0] = new JButton("Nome");
        botao[1] = new JButton("Data");
        botao[2] = new JButton("Avaliacao");
        //BotaoEvento ativaEvento = new BotaoEvento();
        //----------------------------------------------//
        
        lista.add(new Dados("A", 70, new GregorianCalendar( 2016, 8, 28 ))); //Atribui tais elementos testes à lista
        lista.add(new Dados("B", 50, new GregorianCalendar( 2016, 8, 27 ))); //Atribui tais elementos testes à lista
        lista.add(new Dados("C", 90, new GregorianCalendar( 2015, 8, 28 ))); //Atribui tais elementos testes à lista
        
        /*for(Dados d: lista) { //Imprime a lista antes de ser ordenada
            System.out.print(d.getNome()+" : "+d.getAvaliacao()+", "
            +d.getData().get(Calendar.DAY_OF_MONTH)+"/"
            +d.getData().get(Calendar.MONTH)+"/"
            +d.getData().get(Calendar.YEAR)+"\n");
        }System.out.print("----------------\n");*/
    }
    /*public DefaultListModel Display(int quantidade) {
        listModel.removeAllElements();
        String data;
        String avaliacao;
        String format = "%1$-40s %2$-10s %3$-10s";
        for(int i=0; i<quantidade; i++) {
            data = lista.get(i).getData().get(Calendar.DAY_OF_MONTH)
            +"/"+lista.get(i).getData().get(Calendar.MONTH)+"/"
            +lista.get(i).getData().get(Calendar.YEAR);
            avaliacao = String.valueOf(lista.get(i).avaliacao);
                        
            listModel.addElement(String.format(
            format,lista.get(i).Titulo, avaliacao, data));
        }
        return listModel;
    }*/
    /*private class BotaoEvento implements ActionListener{
        public void actionPerformed(ActionEvent evento) {
            if(evento.getActionCommand()=="Nome") { //Ativa quando o botão que ordena por nome é ativado
                if(Dados.aux[0]==1) {
                    Collections.sort(lista); 
                    for(Dados d: lista) { //Imprime a lista antes de ser ordenada
                        System.out.print(d.getNome()+" : "+d.getAvaliacao()+", "
                        +d.getData().get(Calendar.DAY_OF_MONTH)+"/"
                        +d.getData().get(Calendar.MONTH)+"/"
                        +d.getData().get(Calendar.YEAR)+"\n");
                    }System.out.print("----------------\n");
                    Dados.aux[0]=-1;
                } else {
                    Collections.sort(lista); 
                    for(Dados d: lista) { //Imprime a lista antes de ser ordenada
                        System.out.print(d.getNome()+" : "+d.getAvaliacao()+", "
                        +d.getData().get(Calendar.DAY_OF_MONTH)+"/"
                        +d.getData().get(Calendar.MONTH)+"/"
                        +d.getData().get(Calendar.YEAR)+"\n");
                    }System.out.print("----------------\n");
                    Dados.aux[0]=1;
                }
            }
            if(evento.getActionCommand()=="Avaliacao") { //Ativa quando o botão que ordena por avaliação é ativado
                if(Dados.aux[1]==1) {
                    Collections.sort(lista, new Dados()); 
                    for(Dados d: lista) { //Imprime a lista antes de ser ordenada
                        System.out.print(d.getNome()+" : "+d.getAvaliacao()+", "
                        +d.getData().get(Calendar.DAY_OF_MONTH)+"/"
                        +d.getData().get(Calendar.MONTH)+"/"
                        +d.getData().get(Calendar.YEAR)+"\n");
                    }System.out.print("----------------\n");
                    Dados.aux[1]=-1;
                } else {
                    Collections.sort(lista, new Dados()); 
                    for(Dados d: lista) { //Imprime a lista antes de ser ordenada
                        System.out.print(d.getNome()+" : "+d.getAvaliacao()+", "
                        +d.getData().get(Calendar.DAY_OF_MONTH)+"/"
                        +d.getData().get(Calendar.MONTH)+"/"
                        +d.getData().get(Calendar.YEAR)+"\n");
                    }System.out.print("----------------\n");
                    Dados.aux[1]=1;
                }
            }
            if(evento.getActionCommand()=="Data") { //Ativa quando o botão que ordena por data é ativado
                if(Dados.aux[2]==1) {
                    Collections.sort(lista, new Comparador()); 
                    for(Dados d: lista) { //Imprime a lista antes de ser ordenada
                        System.out.print(d.getNome()+" : "+d.getAvaliacao()+", "
                        +d.getData().get(Calendar.DAY_OF_MONTH)+"/"
                        +d.getData().get(Calendar.MONTH)+"/"
                        +d.getData().get(Calendar.YEAR)+"\n");
                    }System.out.print("----------------\n");
                    Dados.aux[2]=-1;
                } else {
                    Collections.sort(lista, new Comparador()); 
                    for(Dados d: lista) { //Imprime a lista antes de ser ordenada
                        System.out.print(d.getNome()+" : "+d.getAvaliacao()+", "
                        +d.getData().get(Calendar.DAY_OF_MONTH)+"/"
                        +d.getData().get(Calendar.MONTH)+"/"
                        +d.getData().get(Calendar.YEAR)+"\n");
                    } System.out.print("----------------\n");
                    Dados.aux[2]=1;
                }
            }
        }
    }*/
}

