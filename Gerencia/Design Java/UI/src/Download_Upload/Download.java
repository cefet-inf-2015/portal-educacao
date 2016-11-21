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

public class Download {

    private String retorno;
    private ResultSet rx;
    private Conexao j;
    private String query;

    public String lerColunas() {
        //String namefile = JOptionPane.showInputDialog("Insira o nome do arquivo e.e");
        try {
            rx = j.enviarQueryResultados(query);
            for (int i = 1; i < 7; i++) {
                retorno += rx.getString(i);
            }
        } catch (SQLException ex) {
        }
        return retorno;
    }

    public void avancarLinha() {
        try {
            rx.next();
        } catch (SQLException ex) {
        }
    }

    public Download() throws SQLException {
        retorno = "";
        query = "SELECT * FROM arquivo;";
        System.out.println(query);
        j = new Conexao();
        j.conectar("cefet-inf-2015.ddns.net:43306", "download", "inf2015", "bd_upload");
        ResultSet res = j.enviarQueryResultados(query);
    }
    
    public void baixar(){
        
    }
}
