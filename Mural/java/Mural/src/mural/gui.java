package mural;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import javax.swing.JTextArea;
import javax.swing.JFrame;

               
        
/**
 *
 * @author Aluno
 */
public class gui extends JFrame{
    private JLabel title;
    private JButton publicar, vizualizar;
    private JTextField cxtexto;
    
    gui () {
        super("Mural de informações");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(4,4));
        this.setVisible(true);
        
        publicar = new JButton("Compartilhe algo aqui");
        vizualizar = new JButton("Vizualizar mural");
        
        publicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Digite seu nome: ");
                String info = JOptionPane.showInputDialog("Digite algo e clique OK para publicar no mural: ");
                Date aux = new Date();

                try {
                    FileWriter arq = new FileWriter("C:\\Mural\\mural.txt", true);
                    PrintWriter gravar = new PrintWriter(arq);
                    gravar.println(nome);
                    gravar.println(aux.toString());
                    gravar.println("");
                    gravar.println(info);
                    gravar.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    arq.close();

                }
                catch (IOException ex){
                    System.out.println("");
                }

            }

        });

        vizualizar.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileReader arq = new FileReader("C:\\Mural\\mural.txt");
                    BufferedReader ler = new BufferedReader(arq);
                    JTextArea saida = new JTextArea (11,20);

                    String linha = ler.readLine();
                    while (linha != null) {
                        saida.append(linha);
                        saida.append("\n");
                        linha = ler.readLine();
                    }
                    arq.close();
                    
                    
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setTitle("Mural");
                    frame.setSize(650, 600);
                    frame.setLocationRelativeTo(null);  // -- Codigo para centralizar
                    frame.add(saida);
                    frame.setVisible(true);


                }
                catch (IOException ex){
                System.out.println("");    
                }
            }

        });
            
        
        
        this.add(publicar);
        this.add(vizualizar);
    }
    
}
