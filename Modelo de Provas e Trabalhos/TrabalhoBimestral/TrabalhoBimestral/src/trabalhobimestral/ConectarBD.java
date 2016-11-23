package trabalhobimestral;

import BancoDeDados.Conexao;

public class ConectarBD {

    BancoDeDados.Conexao bd;

    public ConectarBD() {
     
        bd = new Conexao();

        bd.conectar("cefet-inf-2015.ddns.net:43306", "modelo", "inf2015", "Modelos");
    }

    public BancoDeDados.Conexao getConexao() {
        return bd;
    }
}
