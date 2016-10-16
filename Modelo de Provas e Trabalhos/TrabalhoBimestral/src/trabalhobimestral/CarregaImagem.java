package trabalhobimestral;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.*;

public class CarregaImagem extends JFrame {

    //private static final long serialVersionUID = 2893622202255914832L;
    JFileChooser janelaDialogo;
    BufferedImage imagem;
    File arquivo;
    JButton btnCarregaImagem;
    JLabel label;
    Evento e;

    /**
     * Construtor padrão do Sistema
     */
    public CarregaImagem() {
        super("Capturar Imagem");
        janelaDialogo = new JFileChooser();
        JPanel painel = new JPanel();
    //    JRootPane compPane = painel.getRootPane();
        e = new Evento();

        setSize(580, 580);// Dimensões da Janela

        painel.setLayout(new BorderLayout());

        label = new JLabel();

    //        JPanel secpanel = new JPanel();
        // Define que a tela será retirada da memória quando clicar no botão fechar "X" da tela
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         setVisible(true);
//        Container contePane = compPane.getContentPane();
  //            contePane.add(secpanel);
        painel.add(label, BorderLayout.CENTER);

        btnCarregaImagem = new JButton("Selecione uma imagem");
        btnCarregaImagem.addActionListener(e);
        painel.add(btnCarregaImagem, BorderLayout.SOUTH);
        add(painel);
    }

    public ImageIcon createImageIcon(String path) {
        URL imgURL = CarregaImagem.class.getResource(path);

        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Não foi possível carregar o arquivo: " + path);
            return null;
        }
    }

    /**
     * Método acionado quando o usuário clique no botão
     *
     * @ActionEvent - objeto com o comportamento da ação
     */
    private class Evento implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btnCarregaImagem) {

                janelaDialogo.showOpenDialog(null);
                arquivo = janelaDialogo.getSelectedFile();

                try {
                    imagem = ImageIO.read(arquivo);

                    System.out.println(arquivo.getPath());
                    //ImageIcon img = new ImageIcon(getClass().getResource("./bd/minato.jpg"));
                    ImageIcon icon = new ImageIcon(imagem);
                    icon.setImage(icon.getImage().getScaledInstance(300, 300, imagem.SCALE_SMOOTH));
                    /*
                    BufferedImage new_img = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
                    Graphics2D g = new_img.createGraphics();
                    g.drawImage(imagem, 0, 0, new_w, new_h, null);
                     */
                    int new_w = 200, new_h = 200;
                    String extensao = arquivo.getName().substring(arquivo.getName().lastIndexOf("."), arquivo.getName().length());
                    // System.out.println("Extensão: "+extensao);
                    //    BufferedImage imagem = ImageIO.read(image);
                    BufferedImage new_img = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
                    Graphics2D g = new_img.createGraphics();
                    g.setColor(Color.WHITE);
                    g.fillRect(0, 0, 871, 485);
                    g.drawImage(imagem, 0, 0, new_w, new_h, null);
                    g.dispose();
                    // String old = "testando remoção de caracteres em uma string teste";
                    extensao = extensao.replace(".", "");
                    ImageIO.write(new_img, extensao, new File("./bd/" + arquivo.getName()));

                    label.setIcon(icon);

                    Dimension imageSize = new Dimension(100, 100);
                    label.setPreferredSize(imageSize);

                    label.revalidate();
                    label.repaint();
                    Files.copy(Paths.get(arquivo.getPath()), Paths.get("./bd/" + arquivo.getName()));

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }
}
