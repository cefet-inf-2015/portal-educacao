/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import BancoDeDados.Aluno;
import BancoDeDados.Coordenador;
import BancoDeDados.Diretor;
import BancoDeDados.Professor;
import BancoDeDados.Usuario;

/**
 *
 * @author Aluno
 */
public class Sessão {
    public static Usuario usuario;
    
    /**
     *
     * @return Verdadeiro caso o usuario seja um aluno e falso caso contrário
     */
    public boolean isAluno(){
        return usuario instanceof Aluno;
    }
    
    /**
     *
     * @return Verdadeiro caso o usuario seja um professor e falso caso contrário
     */
    public boolean isProfessor(){
        return usuario instanceof Professor;
    }
    
    /**
     *
     * @return Verdadeiro caso o usuario seja um coordenador e falso caso contrário
     */
    public boolean isCoordenador(){
        return usuario instanceof Coordenador;
    }
    
    /**
     *
     * @return Verdadeiro caso o usuario seja um diretor e falso caso contrário
     */
    public boolean isDiretor(){
        return usuario instanceof Diretor;
    }
}
