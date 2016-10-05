/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class LoginApp {
    public static void main(String[] args){
        Login.conectarBanco("localhost", "root", "", "teste", "users");
        try {
            Login.logarUsuario("jão", "senha123");
        } catch (SQLException ex) {
            System.err.println("Usuario inexistente");
                       }
    }
}
