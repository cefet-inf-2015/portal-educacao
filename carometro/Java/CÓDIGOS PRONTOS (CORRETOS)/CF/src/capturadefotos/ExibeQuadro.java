package capturadefotos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ExibeQuadro implements Runnable {

    VideoCaptura webCam;
    JLabel jlbQuadro;
    int cont =1;
    
    /*
     * Construtor da classe; faz conexão com a web cam e com o frame principal configurados em VideoCaptura.
     */
    
    public ExibeQuadro(VideoCaptura cam, JLabel label){
        this.webCam = cam;
        this.jlbQuadro = label;
    }
    
    /*
     * Inicia a thread que controla a execução da aplicação.
     */
    
    @Override
    public void run() {
        while(webCam.video.isOpened()){
            Icon icon = new ImageIcon(webCam.capturaQuadroBufferedImage());
            this.jlbQuadro.setIcon(icon);
            this.jlbQuadro.repaint();
            
            try {
                Thread.sleep(150);
            } catch (InterruptedException ex) {
                Logger.getLogger(ExibeQuadro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
