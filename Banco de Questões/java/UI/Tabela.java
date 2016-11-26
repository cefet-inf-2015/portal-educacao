/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import bancodequestoes.Aberta;
import bancodequestoes.ConexaoBD;
import bancodequestoes.MultiplaEscolha;
import bancodequestoes.Questao;
import bancodequestoes.VOuF;
import java.awt.Color;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Paiva Morais
 */
public class Tabela extends javax.swing.JFrame {

    /**
     * Creates new form Tabela
     */
    public Tabela()  {
        initComponents();
        ConexaoBD conn = new ConexaoBD();
        
        try{
          ResultSet result = conn.getQuestoesUser();    

           int linhaAtual = 0;
           result.beforeFirst();
           
           while (result.next()) {  
               Object[] row = new Object[6];
               Questao questao = Questao.newInstance(result.getString("XML")); 
               
                   row[0] = result.getInt("ID");
                   row[1] = questao.getMateria();
                   row[2] = questao.getConteudo();
                   
                   switch(questao.getDificuldade()){
                       case 1:
                           row[3] = "Facil";
                       break;
                       case 2:
                           row[3] = "Mediana";
                       break;
                       case 3:
                           row[3] = "Dificil";
                       break;
                   }
                   
                   switch( questao.getTipo()){
                       case 0:
                           row[4] = "Multipla Escolha";
                       break;
                       case 1:
                           row[4] = "V ou F";
                       break;
                       case 2:
                           row[4] = "Dissertativa";
                       break;
                   }
                   
                   row[5] = questao.getEnunciado();
               ((DefaultTableModel) tabelaTabela.getModel()).insertRow(linhaAtual, row);
               linhaAtual++;
           }
        } catch(SQLException | NoSuchAlgorithmException ex){
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de "
                    + "dados. Cheque sua conexão.", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            
        }
        
    }
    
    public Tabela(ResultSet result){
        initComponents();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        IDText.setVisible(false);
        EditarBTN.setVisible(false);
        ExcluirBTN.setVisible(false);
            
       Object[][] tableData = null;
       
         try{
           
             int linhaAtual = 0;
             result.beforeFirst();
           while (result.next()) {  
               Object[] row = new Object[6];
               Questao questao = Questao.newInstance(result.getString("XML")); 
               
                   row[0] = result.getInt("ID");
                   row[1] = questao.getMateria();
                   row[2] = questao.getConteudo();
                   
                   switch(questao.getDificuldade()){
                       case 1:
                           row[3] = "Facil";
                       break;
                       case 2:
                           row[3] = "Mediana";
                       break;
                       case 3:
                           row[3] = "Dificil";
                       break;
                   }
                   
                   switch( questao.getTipo()){
                       case 0:
                           row[4] = "Multipla Escolha";
                       break;
                       case 1:
                           row[4] = "V ou F";
                       break;
                       case 2:
                           row[4] = "Dissertativa";
                       break;
                   }
                   
                   row[5] = questao.getEnunciado();
               ((DefaultTableModel) tabelaTabela.getModel()).insertRow(linhaAtual, row);
               linhaAtual++;
           }
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de "
                    + "dados. Cheque sua conexão.", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            
        }

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaTabela = new javax.swing.JTable();
        HomeTabela = new javax.swing.JButton();
        EditarBTN = new javax.swing.JButton();
        ExcluirBTN = new javax.swing.JButton();
        IDText = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Pesquisa");
        setBackground(new java.awt.Color(250, 250, 250));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tabelaTabela.setAutoCreateRowSorter(true);
        tabelaTabela.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tabelaTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Matéria ", "Conteúdo", "Dificuldade", "Tipo", "Enunciado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaTabela.setCellSelectionEnabled(true);
        tabelaTabela.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabelaTabelaFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaTabela);

        HomeTabela.setBackground(new java.awt.Color(33, 150, 243));
        HomeTabela.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        HomeTabela.setForeground(new java.awt.Color(255, 255, 255));
        HomeTabela.setText("HOME");
        HomeTabela.setToolTipText("Ir para o inicio");
        HomeTabela.setNextFocusableComponent(IDText);
        HomeTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeTabelaActionPerformed(evt);
            }
        });

        EditarBTN.setBackground(new java.awt.Color(33, 150, 243));
        EditarBTN.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        EditarBTN.setForeground(new java.awt.Color(255, 255, 255));
        EditarBTN.setText("EDITAR");
        EditarBTN.setToolTipText("Editar a questão com o ID");
        EditarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarBTNActionPerformed(evt);
            }
        });

        ExcluirBTN.setBackground(new java.awt.Color(33, 150, 243));
        ExcluirBTN.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        ExcluirBTN.setForeground(new java.awt.Color(255, 255, 255));
        ExcluirBTN.setText("EXCLUIR");
        ExcluirBTN.setToolTipText("Deletar a questão com o ID");
        ExcluirBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirBTNActionPerformed(evt);
            }
        });

        IDText.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        IDText.setForeground(new java.awt.Color(153, 153, 153));
        IDText.setText("ID");
        IDText.setToolTipText("ID da questão a ser editada ou deletada");
        IDText.setFocusAccelerator('9');
        IDText.setNextFocusableComponent(EditarBTN);
        IDText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                IDTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                IDTextFocusLost(evt);
            }
        });
        IDText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IDTextMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(HomeTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IDText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExcluirBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HomeTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExcluirBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomeTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeTabelaActionPerformed
        FormInicial home = new FormInicial();
        home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_HomeTabelaActionPerformed

    private void EditarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarBTNActionPerformed
      ConexaoBD conn = new ConexaoBD();
        
        try {
            ResultSet result = conn.enviarQueryResultados("SELECT XML FROM questoes WHERE ID = " +
                    IDText.getText());
           Questao questao =  Questao.newInstance(result.getString("XML"));
           
           switch(questao.getTipo()){
               case 0:
                   InserirME inserirME = new InserirME((MultiplaEscolha) questao, Integer.parseInt(IDText.getText()));
                   inserirME.setVisible(true);
                break;
               case 1:
                   InserirVouF inserirVouF = new InserirVouF((VOuF) questao, Integer.parseInt(IDText.getText()));
                   inserirVouF.setVisible(true);
               break;
               case 2:
                   InserirAberta inserirAberta = new InserirAberta((Aberta) questao, Integer.parseInt(IDText.getText()));
                   inserirAberta.setVisible(true);
               break;
           }
           
           this.setVisible(false);
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de "
                    + "dados. Cheque sua conexão.", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro com o parsing da questão.", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Esta não é uma ID valida.", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_EditarBTNActionPerformed

    private void ExcluirBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirBTNActionPerformed
        ConexaoBD conn = new ConexaoBD();
        try {
            conn.deleteQuestaobd(Integer.parseInt(IDText.getText()));
            JOptionPane.showMessageDialog(this, "Questão deletada com sucesso.", "SUCESSO", 
                    JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
        new FormInicial().setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de "
                    + "dados. Cheque sua conexão.", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Esta não é uma ID valida.", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NO PARSING DA QUESTÂO.", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ExcluirBTNActionPerformed

    private void IDTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IDTextFocusGained
        if(IDText.getText().equals("ID")){
           IDText.setText("");
           IDText.setForeground(new Color(0,0,0));
       }
    }//GEN-LAST:event_IDTextFocusGained

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
   
    }//GEN-LAST:event_formWindowActivated

    private void tabelaTabelaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabelaTabelaFocusGained
       
    }//GEN-LAST:event_tabelaTabelaFocusGained

    private void IDTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IDTextMouseClicked
      IDText.requestFocus();
    }//GEN-LAST:event_IDTextMouseClicked

    private void IDTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IDTextFocusLost
        if(IDText.getText().equals("")){
           IDText.setText("DIGITE O TEXTO AQUI.");
           IDText.setForeground(new Color(0,0,0));
       }
    }//GEN-LAST:event_IDTextFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException 
//                | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Tabela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Tabela().setVisible(true);
        });
        
        //</editor-fold>
        //</editor-fold>
 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditarBTN;
    private javax.swing.JButton ExcluirBTN;
    private javax.swing.JButton HomeTabela;
    private javax.swing.JTextField IDText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabelaTabela;
    // End of variables declaration//GEN-END:variables
}
