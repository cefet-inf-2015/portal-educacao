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
public class Professor extends Usuario{
    private ArrayList<String> turmas;
    /**
     *
     * @param primeiroNome
     * @param ultimoNome
     * @param nickname
     * @param foto
     * @param numeroMatricula
     * @param turmas
     */
    public Professor(String primeiroNome, String ultimoNome, String nickname, ImageIcon foto, String numeroMatricula, ArrayList<String> turmas) {
        super(primeiroNome, ultimoNome, nickname, foto, numeroMatricula);
        this.turmas=turmas;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getTurmas() {
        return turmas;
    }

    /**
     *
     * @param turmas
     */
    public void setTurmas(ArrayList<String> turmas) {
        this.turmas = turmas;
    }
    
}
