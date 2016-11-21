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
public class Aluno extends Usuario{
    private String turma;
    private String divisaoTurma;
    /**
     * Cria um aluno para ser manipulado com os dados indicados
     * @param primeiroNome Recebe o primeiro nome do usuario recuperado do banco de dados
     * @param ultimoNome Recebe o ultimo nome do usuario recuperado do banco de dados
     * @param nickname Recebe o nickname do usuario recuperado do banco de dados
     * @param foto Recebe a foto do usuario recuperado do banco de dados
     * @param numeroMatricula Recebe o numero de matricula do usuario recuperado do banco de dados
     * @param turma Recebe a turma do aluno
     * @param divisao Recebe o 'T' do aluno quando a turma é dividida
     */
    public Aluno(String primeiroNome, String ultimoNome, String nickname, ImageIcon foto, String numeroMatricula, String turma, String divisao) {
        super(primeiroNome, ultimoNome, nickname, foto, numeroMatricula);
        this.turma=turma;
        divisaoTurma=divisao;
    }
    /**
     *
     * @return String
     */
    public String getTurma() {
        return turma;
    }

    /**
     *
     * @param turma
     */
    public void setTurma(String turma) {
        this.turma = turma;
    }
    /**
     *
     * @return String
     */
    public String getDivisaoTurma() {
        return divisaoTurma;
    }

    /**
     *
     * @param divisaoTurma
     */
    public void setDivisaoTurma(String divisaoTurma) {
        this.divisaoTurma = divisaoTurma;
    }
    
    
    
}
