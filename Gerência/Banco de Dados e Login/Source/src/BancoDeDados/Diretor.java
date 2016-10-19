/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoDeDados;

import javax.swing.ImageIcon;

/**
 *
 * @author Vitor Rodarte
 */
public class Diretor extends Usuario{
    
    /**
     *
     * @param primeiroNome
     * @param ultimoNome
     * @param nickname
     * @param foto
     * @param numeroMatricula
     */
    public Diretor(String primeiroNome, String ultimoNome, String nickname, ImageIcon foto, String numeroMatricula) {
        super(primeiroNome, ultimoNome, nickname, foto, numeroMatricula);
    }
    
}
