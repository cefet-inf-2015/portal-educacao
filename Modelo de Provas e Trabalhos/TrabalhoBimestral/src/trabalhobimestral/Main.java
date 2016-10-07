package trabalhobimestral;

import javax.swing.JFrame;

/**
 * 
 * @author Gabriel Víctor
 * 
 */
public class Main {
    /**
     * 
     * @param args 
     * Em main é estanciado um objeto para interface
     * define-se o tamanho do frame,visibilidade,posicionamento 
     * e o encerramento do processo ao fechar o frame manualmente
     */
    public static void main(String[] args) {
        InterfaceGrafica i = new InterfaceGrafica();
        i.setSize(500, 450);
        i.setVisible(true);
        i.setLocationRelativeTo(null);
        i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
