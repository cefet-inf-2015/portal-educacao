/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendario;

import BancoDeDados.Conexao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author umcan
 */
public class ListenerData implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Entrou");
        JLabel fonte = (JLabel) e.getSource();
        Calendario cal = (Calendario) fonte.getParent().getParent();
        int I;
        for(I=0; I<42; I++){
            if(cal.block[I].getText()!=""){
                break;
            }
        }
        I--;
        Conexao c = new Conexao();
        c.conectar("cefet-inf-2015.ddns.net:43306", "root", "apenasinf-2015", "calendario");
        try {
            String eventos="";
            String dia;
            String ultimaHora="";
            String subHora="";
            ResultSet res = c.enviarQueryResultados("SELECT * FROM eventos WHERE ano='" + cal.data.getYear() + "' AND mes='" + cal.data.getMonthValue() + "' ORDER BY hora ASC");
            while(!res.isAfterLast()){
                dia=res.getString("dia");
                if(cal.block[I+Integer.parseInt(dia)]==fonte){
                    if(!res.getString("hora").substring(0, 5).equals(ultimaHora)){
                        subHora = res.getString("hora").substring(0, 5);
                        ultimaHora=subHora;
                        eventos+=subHora+"\n";
                    }
                    eventos+=res.getString("atividade") + " - " + res.getString("descricao") + " - " + res.getString("materia") + "\n";
                }
                res.next();
            }
            System.out.println(eventos);
            cal.ativ.setText(eventos);
            cal.diaSelec=fonte;
        } catch (SQLException ex) {
            Logger.getLogger(ListenerData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
