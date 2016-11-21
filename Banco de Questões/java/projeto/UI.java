/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

/**
 *
 * @author Aluno
 */
public class UI {
    private static final FormInicial INICIO = new FormInicial();
    private static final Inserir INSERIR = new Inserir();
    private static final InserirAberta ABERTA = new InserirAberta();
    private static final InserirME MULTIPLAESCOLHA = new InserirME();
    private static final InserirVouF VERDADEIRO_FALSO = new InserirVouF();
    private static final Gerar GERAR = new Gerar();
//geradas para a classe
    private UI() {
        INICIO.setVisible(true);
    }
    
    public void abrirInserir(){
        INSERIR.setVisible(true);
    }
    
    public void abrirGerar(){
        GERAR.setVisible(true);
    }
    
    public void abrirAberta(){
        ABERTA.setVisible(true);
    }
    
    public void abrirME(){
        MULTIPLAESCOLHA.setVisible(true);
    }
    
    public void abrirVF(){
        VERDADEIRO_FALSO.setVisible(true);
    }
    
//geradas pela class    
    public static UI getInstance() {
        return UIHolder.INSTANCE;
    }
    
    private static class UIHolder {

        private static final UI INSTANCE = new UI();
    }
}
