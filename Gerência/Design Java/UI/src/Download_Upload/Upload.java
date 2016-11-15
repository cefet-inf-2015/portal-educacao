package Download_Upload;

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
import ssh.SSH;
import ui.Sessao;

public class Upload {

    private String origem;
    private String destino;
    private String fileName = "";
    private int aux = 0;
    private String ext = "";
    Conexao conx = new Conexao();// Abrir conexao no BD
    JFileChooser fc = new JFileChooser();//
    File file = fc.getSelectedFile();//Dados sobre o arquivo selecionado

    public Upload() {
       selecionaArq();
        enviaTabela();
    }
    /*
    Seleciona o arquivo e manda para o servidor ser salvo.   
    
     */

    public void selecionaArq() {
        fc.setAcceptAllFileFilterUsed(true);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int resp = fc.showOpenDialog(null);
        while(resp!=JFileChooser.APPROVE_OPTION){
            
        }
        if (resp == JFileChooser.APPROVE_OPTION) {
            try {
                System.out.println("Entrou");
                file = fc.getSelectedFile();
                FileInputStream stream = new FileInputStream(file);
                origem = fc.getCurrentDirectory() + "\\" + fc.getName(file);
                destino = "/upload/"+fc.getName(file);
                SSH.enviarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", origem, destino);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        String user;
        if(Sessao.usuario!=null){
            user=Sessao.usuario.getNickname();
            
        }else{
            user="anonimo";
        }
        conx.conectar("cefet-inf-2015.ddns.net:43306", "root", "apenasinf-2015", "bd_upload");
        String query = "INSERT INTO arquivo (arquivo_char_nome,"
                + "arquivo_char_tamanho,"
                + "arquivo_char_extensao"
                + ",arquivo_char_diretorio, arquivo_char_status, arquivo_char_tag, arquivo_char_cod, arquivo_char_usuario)"
                + " VALUES ('" + fc.getName(file) + "','"
                + file.length() + "','" + ext + "','" + destino + "', 0, '', 1,'" + user + "')";
        System.out.println(query);
        boolean sucesso=false;
        try {
           System.out.println("Entrou 2");
           sucesso = conx.enviarQuery(query);
        } catch (SQLException ex) {
        }
        System.out.println(sucesso);

    }

    /*
    Metodo que envia todos os dados do arquivo quer foi salvo no servidor   
    
     */
    public void enviaTabela() {


    }
}
