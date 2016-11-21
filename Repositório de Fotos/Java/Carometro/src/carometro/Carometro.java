/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carometro;

import com.jcraft.jsch.SftpException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Anonymous
 */
public class Carometro {

    public static ImageIcon getFotoCarometro(String matricula) throws SftpException{
        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/" + matricula + ".png", "Galeria/" + matricula + ".png");
        return new ImageIcon("Galeria/" + matricula + ".png");
    }
}


