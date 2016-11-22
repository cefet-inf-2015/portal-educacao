package teste.de.upload;

import java.io.File;
import javax.swing.JFileChooser;
import BancoDeDados.Conexao;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Escolha {

    String origem;
    String destino;
    String fileName = "";
    int aux = 0;
    String ext = "";

    public Escolha() {
        JFileChooser fc = new JFileChooser();
        Conexao j = new Conexao();
        j.conectar("localhost:3306", "root", "123", "bd_trabalho");
        fc.setAcceptAllFileFilterUsed(true);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int resp = fc.showOpenDialog(null);
        if (resp == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try {
                FileInputStream stream = new FileInputStream(file);
                origem = fc.getCurrentDirectory() + "\\" + fc.getName(file);
                destino = "C:\\\\WebServer\\\\Apache 2.2\\\\htdocs\\\\WEB\\\\dado\\\\" + fc.getName(file);
                copyExecute(origem, destino);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Escolha.class.getName()).log(Level.SEVERE, null, ex);
            }
            fileName = fc.getName(file);
            for (int i = 0; i < fileName.length(); i++) {
                if (fileName.charAt(i) == '.') {
                    aux = i;
                }
            }
            for (; aux < fileName.length(); aux++) {
                ext += fileName.charAt(aux);
            }
            String query = ("INSERT INTO bd_trabalho.arquivo (arquivo_char_nome,"
                    + "arquivo_char_tamanho,"
                    + "arquivo_char_tipo"
                    + ",arquivo_char_diretorio)"
                    + " VALUES ('" + fc.getName(file) + "','"
                    + file.getTotalSpace() + "','" + ext + "','" + destino + "')");
            System.out.println(fileName.length());
            System.out.println(query);
            try {
                j.enviarQuery(query);
            } catch (SQLException ex) {
            }

        }

    }

    public void copyExecute(String origem, String destino) {

        try {
            File srcFile = new File(origem);
            File dstFile = new File(destino);

            FileInputStream srcFileInStream = new FileInputStream(srcFile);
            FileOutputStream dstFileOutStream = new FileOutputStream(dstFile);

            byte[] buffer = new byte[4096];

            int lido = 0;
            do {
                lido = srcFileInStream.read(buffer);
                if (lido > 0) {
                    dstFileOutStream.write(buffer, 0, lido);
                }
            } while (lido > 0);

            srcFileInStream.close();
            dstFileOutStream.close();
            System.out.println("Sucesso");

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo Não Encontrado");

        } catch (IOException e) {
            System.out.println("Erro IO");
        }
    }
}
