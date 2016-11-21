/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoDeDados;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Vitor Rodarte
 */
public class Coordenador extends Usuario{
    private ArrayList<String> cursos;

    /**
     *
     * @param primeiroNome
     * @param ultimoNome
     * @param nickname
     * @param foto
     * @param numeroMatricula
     * @param cursos
     */
    public Coordenador(String primeiroNome, String ultimoNome, String nickname, ImageIcon foto, String numeroMatricula, ArrayList<String> cursos) {
        super(primeiroNome, ultimoNome, nickname, foto, numeroMatricula);
        this.cursos=cursos;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getCursos() {
        return cursos;
    }

    /**
     *
     * @param cursos
     */
    public void setCursos(ArrayList<String> cursos) {
        this.cursos = cursos;
    }
    
    
    
}
