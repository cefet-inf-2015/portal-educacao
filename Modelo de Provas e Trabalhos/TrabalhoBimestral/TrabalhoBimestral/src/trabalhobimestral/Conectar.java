package trabalhobimestral;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar {

  Connection conectar = null;

  public Connection conexao() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conectar = DriverManager.getConnection("jdbc:mysql://localhost/modelos","root","$techtudogvgx$");
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println("ERRO NA CONEXAO");
    }
    return conectar;
  }
}  
