/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.Thread;
import ui.Home;
import ui.Sessao;
/**
 *
 * @author Eduardo
 */
public class Check extends Conectar implements Runnable{
        private Conectar c = new Conectar();
        private int ultimaMsg = 0;

    @Override
    public void run () {
        while(true){
            System.out.println("Checkando");
            if(Sessao.usuario!=null){
                try {
                    System.out.println("Logado");
                ResultSet resultado = c.bd.enviarQueryResultados("SELECT id, usuario FROM mensagens WHERE alvo = '"+ Sessao.usuario.getNickname() +"' ORDER BY id DESC LIMIT 1");
                if(resultado.first()) {
                    //checando se recebeu uma nova mensagem
                    if(resultado.getInt(1) != ultimaMsg) {
                        ultimaMsg = resultado.getInt("id");
                        Home.notificacao.setVisible(true);
                        Home.notificacao.setText("Você tem novas mensagens");
                    } 
                }
                } catch (SQLException ex) {
                    Logger.getLogger(Check.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Check.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }   

    public int getUltimaMsg() {
        return ultimaMsg;
    }

    public void setUltimaMsg(int ultimaMsg) {
        this.ultimaMsg = ultimaMsg;
    }




    
        
}
