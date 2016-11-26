package trabalhobimestral;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ssh.SSH;

public class Home extends javax.swing.JFrame {

    public Home() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        
        setTitle("Modelo de trabalhos e provas");
        
        setResizable(false);
        
        }
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLayeredPane1 = new javax.swing.JLayeredPane();
    container = new javax.swing.JPanel();
    Home = new javax.swing.JPanel();
    LabelTitulo = new javax.swing.JLabel();
    BotaoNovoArquivo = new javax.swing.JButton();
    BotaoExcluir = new javax.swing.JButton();
    BotaoAtualizaCarometro = new javax.swing.JButton();
    jButton1 = new javax.swing.JButton();
    Baixo = new javax.swing.JPanel();
    Topo = new javax.swing.JPanel();
    jToolBar1 = new javax.swing.JToolBar();

    javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
    jLayeredPane1.setLayout(jLayeredPane1Layout);
    jLayeredPane1Layout.setHorizontalGroup(
      jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 100, Short.MAX_VALUE)
    );
    jLayeredPane1Layout.setVerticalGroup(
      jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 100, Short.MAX_VALUE)
    );

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setBackground(new java.awt.Color(255, 255, 255));

    container.setBackground(new java.awt.Color(255, 255, 255));
    container.setLayout(new java.awt.CardLayout());

    Home.setBackground(new java.awt.Color(255, 255, 255));
    Home.setMaximumSize(new java.awt.Dimension(1024, 516));
    Home.setMinimumSize(new java.awt.Dimension(1024, 516));
    Home.setLayout(null);

    LabelTitulo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
    LabelTitulo.setForeground(new java.awt.Color(0, 102, 255));
    LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelTitulo.setText("Modelos de Provas e Trabalhos");
    Home.add(LabelTitulo);
    LabelTitulo.setBounds(0, 29, 1024, 44);

    BotaoNovoArquivo.setBackground(new java.awt.Color(255, 255, 255));
    BotaoNovoArquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalhobimestral/botaoNovoArquivo.PNG"))); // NOI18N
    BotaoNovoArquivo.setBorder(null);
    BotaoNovoArquivo.setBorderPainted(false);
    BotaoNovoArquivo.setContentAreaFilled(false);
    BotaoNovoArquivo.setFocusPainted(false);
    BotaoNovoArquivo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        BotaoNovoArquivoActionPerformed(evt);
      }
    });
    Home.add(BotaoNovoArquivo);
    BotaoNovoArquivo.setBounds(210, 130, 206, 44);

    BotaoExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalhobimestral/botaoEditar.PNG"))); // NOI18N
    BotaoExcluir.setBorder(null);
    BotaoExcluir.setBorderPainted(false);
    BotaoExcluir.setContentAreaFilled(false);
    BotaoExcluir.setFocusPainted(false);
    BotaoExcluir.setFocusable(false);
    BotaoExcluir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        BotaoExcluirActionPerformed(evt);
      }
    });
    Home.add(BotaoExcluir);
    BotaoExcluir.setBounds(530, 130, 270, 45);

    BotaoAtualizaCarometro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalhobimestral/botaoAtualizaCarometro.PNG"))); // NOI18N
    BotaoAtualizaCarometro.setBorderPainted(false);
    BotaoAtualizaCarometro.setContentAreaFilled(false);
    BotaoAtualizaCarometro.setFocusPainted(false);
    BotaoAtualizaCarometro.setFocusable(false);
    BotaoAtualizaCarometro.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        BotaoAtualizaCarometroActionPerformed(evt);
      }
    });
    Home.add(BotaoAtualizaCarometro);
    BotaoAtualizaCarometro.setBounds(330, 210, 290, 51);

    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalhobimestral/gerarDOCX.PNG"))); // NOI18N
    jButton1.setText("");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });
    Home.add(jButton1);
    jButton1.setBounds(410, 300, 160, 30);

    container.add(Home, "Home");

    Baixo.setBackground(new java.awt.Color(33, 150, 243));

    javax.swing.GroupLayout BaixoLayout = new javax.swing.GroupLayout(Baixo);
    Baixo.setLayout(BaixoLayout);
    BaixoLayout.setHorizontalGroup(
      BaixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );
    BaixoLayout.setVerticalGroup(
      BaixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 116, Short.MAX_VALUE)
    );

    Topo.setBackground(new java.awt.Color(1, 87, 155));

    jToolBar1.setBackground(new java.awt.Color(1, 87, 155));
    jToolBar1.setFloatable(false);
    jToolBar1.setRollover(true);

    javax.swing.GroupLayout TopoLayout = new javax.swing.GroupLayout(Topo);
    Topo.setLayout(TopoLayout);
    TopoLayout.setHorizontalGroup(
      TopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopoLayout.createSequentialGroup()
        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    TopoLayout.setVerticalGroup(
      TopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(TopoLayout.createSequentialGroup()
        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
      .addComponent(Topo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(Baixo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(Topo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(Baixo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed
        Home.removeAll();
        Home.revalidate();
        Home.repaint();
    }//GEN-LAST:event_BotaoExcluirActionPerformed

    private void BotaoNovoArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoArquivoActionPerformed
        File pastaCarometro = new File("C:/carometro");
        
        if(pastaCarometro.exists() == false) {
            EscondeOuInsereComponentes(false);
            LabelTitulo.setText("Baixando arquivos necessários. Aguarde...");
            LabelTitulo.setVisible(true);
            revalidate();
            repaint();
        
            JOptionPane.showMessageDialog(null, "Baixando arquivos necessários. Aguarde...");
            
            SSH.baixarDiretorio("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro", "C:/");
            
            File[] fotos = pastaCarometro.listFiles();
            for (int i = 0; i < fotos.length; i++) {
                
                if (fotos[i].isFile()) {
                    BufferedImage imagem = null;
                    try {
                        imagem = ImageIO.read(new File(fotos[i].getPath().replace("\\", "/")));
                    } catch (IOException ex) {
                        //Logger.getLogger(ImagePanel2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    BufferedImage new_img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
                    Graphics2D g2 = new_img.createGraphics();
                    g2.drawImage(imagem, 0, 0, 100, 100, null);
                    try {
                        ImageIO.write(new_img, "JPG", new File(fotos[i].getPath()));
                    } catch (IOException ex) {
                        Logger.getLogger(PainelNovoArquivo.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                }
            }
        }
        
        PainelNovoArquivo painelNovoArq = new PainelNovoArquivo();
        
        EscondeOuInsereComponentes(false);
        Home.revalidate();

        painelNovoArq.setBounds(Home.getBounds());
        Home.add(painelNovoArq);
        Home.revalidate();
        Home.repaint();
    }//GEN-LAST:event_BotaoNovoArquivoActionPerformed

    private void BotaoAtualizaCarometroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAtualizaCarometroActionPerformed
        File pastaCarometro = new File("C:/carometro");
        
        EscondeOuInsereComponentes(false);
        LabelTitulo.setText("Baixando arquivos necessários. Aguarde...");
        LabelTitulo.setVisible(true);
        revalidate();
        repaint();
        
        JOptionPane.showMessageDialog(null, "Baixando arquivos necessários. Aguarde...");
        
        SSH.baixarDiretorio("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro", "C:/");
        
        File[] fotos = pastaCarometro.listFiles();
            for (int i = 0; i < fotos.length; i++) {
                
                if (fotos[i].isFile()) {
                    BufferedImage imagem = null;
                    try {
                        imagem = ImageIO.read(new File(fotos[i].getPath().replace("\\", "/")));
                    } catch (IOException ex) {
                        //Logger.getLogger(ImagePanel2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    BufferedImage new_img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
                    Graphics2D g2 = new_img.createGraphics();
                    g2.drawImage(imagem, 0, 0, 100, 100, null);
                    try {
                        ImageIO.write(new_img, "JPG", new File(fotos[i].getPath()));
                    } catch (IOException ex) {
                        Logger.getLogger(PainelNovoArquivo.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                }
            }
        
        LabelTitulo.setText("Modelos de provas e trabalhos");
        EscondeOuInsereComponentes(true);
        revalidate();
        repaint();
    }//GEN-LAST:event_BotaoAtualizaCarometroActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String titulo = JOptionPane.showInputDialog("Titulo");
    Documento d = new Documento();
    d.gerarProva(titulo);
  }//GEN-LAST:event_jButton1ActionPerformed
   
    public void EscondeOuInsereComponentes(boolean define) {
            BotaoExcluir.setVisible(define);
            BotaoNovoArquivo.setVisible(define);
            BotaoAtualizaCarometro.setVisible(define);
            LabelTitulo.setVisible(define);       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel Baixo;
  private javax.swing.JButton BotaoAtualizaCarometro;
  private javax.swing.JButton BotaoExcluir;
  private javax.swing.JButton BotaoNovoArquivo;
  private javax.swing.JPanel Home;
  private javax.swing.JLabel LabelTitulo;
  private javax.swing.JPanel Topo;
  private javax.swing.JPanel container;
  private javax.swing.JButton jButton1;
  private javax.swing.JLayeredPane jLayeredPane1;
  private javax.swing.JToolBar jToolBar1;
  // End of variables declaration//GEN-END:variables
}
