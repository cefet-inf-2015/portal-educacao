/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javax.swing.ImageIcon;



/**
 *
 * @author Vitor Rodarte / Adalberto Vieira
 * 
 */
public class Usuario {
    private String primeiroNome;
    private String ultimoNome;
    private String nickname;
    private ImageIcon foto;
    private String numeroMatricula;

    /**
     * Cria um usuário para ser manipulado com os dados indicados
     * @param primeiroNome Recebe o primeiro nome do usuario recuperado do banco de dados
     * @param ultimoNome Recebe o ultimo nome do usuario recuperado do banco de dados
     * @param nickname Recebe o nickname do usuario recuperado do banco de dados
     * @param foto Recebe a foto do usuario recuperado do banco de dados
     * @param numeroMatricula Recebe o numero de matricula do usuario recuperado do banco de dados
     */
    public Usuario(String primeiroNome, String ultimoNome, String nickname, ImageIcon foto, String numeroMatricula) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.nickname = nickname;
        this.foto = foto;
        this.numeroMatricula = numeroMatricula;
    }

    /**
     *
     * @return String
     */
    public String getPrimeiroNome() {
        return primeiroNome;
    }

    /**
     *
     * @param primeiroNome
     */
    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }
     /**
     *
     * @return String
     */
    public String getUltimoNome() {
        return ultimoNome;
    }
    /**
     *
     * @param ultimoNome
     */
    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }
    /**
    *
    * @return String
    */
    public String getNickname() {
        return nickname;
    }
    /**
     *
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname=nickname;
    }
     /**
     *
     * @return ImageIcon
     */
    public ImageIcon getFoto() {
        return foto;
    }
    /**
     *
     * @param foto
     */
    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }
     /**
     *
     * @return String
     */
    public String getNumeroMatricula() {
        return numeroMatricula;
    }
    /**
     *
     * @param numeroMatricula
     */
    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
    
    
    
}
