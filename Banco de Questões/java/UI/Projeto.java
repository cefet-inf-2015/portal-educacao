/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.SwingUtilities;

/**
 *
 * @author Aluno
 */
public class Projeto {
 public static void main(String... args)
    {
        SwingUtilities.invokeLater(() -> {
            FormInicial inicial = new FormInicial();
            inicial.setVisible(true);
        });
    }
    
}
