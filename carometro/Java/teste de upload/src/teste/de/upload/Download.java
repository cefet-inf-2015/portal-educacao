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

public class Download {

    public Download() {

        //String namefile = JOptionPane.showInputDialog("Insira o nome do arquivo e.e");
        String query = "SELECT * FROM bd_trabalho.arquivo;";
        System.out.println(query);
        Conexao j = new Conexao();
        j.conectar("localhost:3306", "root", "123", "bd_trabalho");

        try {
            ResultSet rx = j.enviarQueryResultados(query);
            for (int a = 0; a < 10; a++) {

                for (int i = 1; i < 7; i++) {

                    System.out.println(rx.getString(i));
                }
                rx.next();
            }
        } catch (SQLException ex) {
        }

    }
}
