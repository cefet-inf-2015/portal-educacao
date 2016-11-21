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

    @Override
    public void run () {
        boolean novo=false;
        
        while(true){
            novo=false;
            System.out.println("LA");
            if(Sessao.usuario!=null){
                
                Home.notificacao.setVisible(true);
                try {
                    System.out.println("Logado");
                    ResultSet resultado = c.bd.enviarQueryResultados("SELECT * FROM mensagens WHERE alvo = '"+ Sessao.usuario.getNickname() +"' ORDER BY id DESC");
                    if(resultado.first()) {
                        while(!resultado.isAfterLast()){
                            //checando se recebeu uma nova mensagem
                            if(!resultado.getBoolean("visualizado")) {
                                Home.notificacao.setText("Você tem novas mensagens");
                                novo=true;
                            }
                            resultado.next();
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Check.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(!novo){
                    Home.notificacao.setText("Você não tem novas mensagens");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Check.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }   





    
        
}
