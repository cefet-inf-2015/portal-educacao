package correção;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Principal {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        Corretor c = new Corretor();
        JFileChooser seletor = new JFileChooser();
        String respostasConcatenadas = null;
        InterfacePrincipal p = new InterfacePrincipal();
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setVisible(true);
    }
}
