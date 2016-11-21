package capturadefotos;

import capturadefotos.SSH.SSH;
import com.jcraft.jsch.SftpException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.opencv.highgui.Highgui;

/*
 * Créditos: código base de uso da web cam em conjunto com o OpenCV criado por Danilo Filitto.
 */
public class jfmPrincipal extends javax.swing.JFrame {

    VideoCaptura webCam;
    ExibeQuadro exibeQuadro;
    Thread executor;

    /* 
     * Construtor da classe. Inicia os componentes do frame e faz outras configurações básicas.
     */
    public jfmPrincipal() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jbtIniciar = new javax.swing.JButton();
        jbtParar = new javax.swing.JButton();
        frameDeCaptura = new javax.swing.JScrollPane();
        jlbCaptura = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jbtSalvar = new javax.swing.JButton();
        jbEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Repositório de Fotos");
        setBackground(new java.awt.Color(255, 255, 255));

        jbtIniciar.setBackground(new java.awt.Color(1, 87, 155));
        jbtIniciar.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        jbtIniciar.setForeground(new java.awt.Color(255, 255, 255));
        jbtIniciar.setText("INICIAR");
        jbtIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtIniciarActionPerformed(evt);
            }
        });

        jbtParar.setBackground(new java.awt.Color(1, 87, 155));
        jbtParar.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        jbtParar.setForeground(new java.awt.Color(255, 255, 255));
        jbtParar.setText("PARAR");
        jbtParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPararActionPerformed(evt);
            }
        });

        frameDeCaptura.setPreferredSize(new java.awt.Dimension(646, 485));

        jlbCaptura.setPreferredSize(new java.awt.Dimension(300, 250));
        frameDeCaptura.setViewportView(jlbCaptura);

        jPanel1.setBackground(new java.awt.Color(1, 87, 155));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Captura de Fotos");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nome do Usuário");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(33, 150, 243));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("<html><body>Centro Federal de Educação Tecnológica de Minas Gerais <br> Av. Amazonas 5253 - Nova Suiça - Belo Horizonte - MG - Brasil<br> Telefone: +55 (31) 3319-7000 - Fax: +55 (31) 3319-7001</body></html>");

        jButton2.setBackground(new java.awt.Color(1, 87, 155));
        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("VOLTAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtSalvar.setBackground(new java.awt.Color(1, 87, 155));
        jbtSalvar.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        jbtSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jbtSalvar.setText("SALVAR FOTO");
        jbtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSalvarActionPerformed(evt);
            }
        });

        jbEnviar.setBackground(new java.awt.Color(1, 87, 155));
        jbEnviar.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        jbEnviar.setForeground(new java.awt.Color(255, 255, 255));
        jbEnviar.setText("ENVIAR");
        jbEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(367, 367, 367)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtIniciar)
                        .addGap(30, 30, 30)
                        .addComponent(jbtParar)
                        .addGap(240, 240, 240)
                        .addComponent(jbEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtSalvar))
                    .addComponent(frameDeCaptura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(395, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(frameDeCaptura, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtIniciar)
                    .addComponent(jbtParar)
                    .addComponent(jbtSalvar)
                    .addComponent(jbEnviar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* 
     * Métodos para o botão "INICIAR". Ao ser pressionado, inicia uma conexão com a web cam encontrada no computador
     * (caso essa exista) exibindo no frame central a imagem capturada em tempo real através da chamada a classe exibeQuadro,
     * dando inicio a uma nova thread e desativando o botão para salvar a foto até que a web cam seja parada em uma foto específica.
     */

    private void jbtIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtIniciarActionPerformed
        webCam = new VideoCaptura();
        exibeQuadro = new ExibeQuadro(webCam, jlbCaptura);
        executor = new Thread(exibeQuadro);
        executor.start();
        jbtSalvar.setEnabled(false);
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jbtIniciarActionPerformed

    /* 
     * Métodos para o botão "PARAR". Ao ser pressionado, encerra a conexão com a web cam e deixa em aberto no frame central a 
     * última imagem captada; ativa então o botão "SALVAR FOTO" possibilitando o envio da foto para seu devido repositório.
     */

    private void jbtPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPararActionPerformed
        executor.suspend();
        jButton2.setEnabled(false);
        jbtSalvar.setEnabled(true);
    }//GEN-LAST:event_jbtPararActionPerformed

    /* 
     * Métodos para o botão "SALVAR FOTO". Ao ser pressionado, tenta salvar a foto tirada com o botão "PARAR" através do componente
     * jFileChooser em um diretório especifico escolhido pelo usuário.
     */

    private void jbtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSalvarActionPerformed
        int returnVal = jFileChooser1.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            Highgui.imwrite(file.getPath(), webCam.capturaQuadroMat());
        } else {
            System.out.println("Tente novamente.");
        }
        System.out.println("OK");
    }//GEN-LAST:event_jbtSalvarActionPerformed

    //ENVIAR PARA O SERVIDOR.

    private void jbEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEnviarActionPerformed
        try {
            //UploadImagem.UploadImagem();
            webCam.criaArquivoTemporario();
        } catch (IOException ex) {
            System.out.println("Não foi possível criar o arquivo temporário da foto.");
        }
        
        try {
            SSH.enviarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "C:/Users/Anonymous/Desktop/portal-educacao-master/Repositório de Fotos/Java/CF/FOTO.png", "/carometro/camera/FOTO.png");
        } catch (SftpException ex) {
            Logger.getLogger(jfmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbEnviarActionPerformed

    /* 
     * Método principal; torna o frame principa da aplicação visível e funcional.
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane frameDeCaptura;
    private javax.swing.JButton jButton2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbEnviar;
    private javax.swing.JButton jbtIniciar;
    private javax.swing.JButton jbtParar;
    private javax.swing.JButton jbtSalvar;
    private javax.swing.JLabel jlbCaptura;
    // End of variables declaration//GEN-END:variables
}
