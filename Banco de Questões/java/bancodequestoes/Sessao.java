/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodequestoes;

import BancoDeDados.Aluno;
import BancoDeDados.Coordenador;
import BancoDeDados.Diretor;
import BancoDeDados.Professor;
import BancoDeDados.Usuario;

/**
 *
 * @author Aluno
 */
public class Sessao {
    public static Usuario usuario = new Aluno("joãozim", "Da Silva", "joãozim12", null, "322343243", "HOSP3B", "2ª");
    
    /**
     *
     * @return Verdadeiro caso o usuario seja um aluno e falso caso contrário
     */
    public static boolean isAluno(){
        return usuario instanceof Aluno;
    }
    
    /**
     *
     * @return Verdadeiro caso o usuario seja um professor e falso caso contrário
     */
    public static boolean isProfessor(){
        return usuario instanceof Professor;
    }
    
    /**
     *
     * @return Verdadeiro caso o usuario seja um coordenador e falso caso contrário
     */
    public static boolean isCoordenador(){
        return usuario instanceof Coordenador;
    }
    
    /**
     *
     * @return Verdadeiro caso o usuario seja um diretor e falso caso contrário
     */
    public static boolean isDiretor(){
        return usuario instanceof Diretor;
    }
}
