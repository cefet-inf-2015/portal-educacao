package galeria;

import ssh.SSH;
import com.jcraft.jsch.SftpException;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * Créditos: código base de uso da web cam em conjunto com o OpenCV criado por Danilo Filitto.
 */
public class Carometro extends javax.swing.JFrame {

    InformacoesCarometro i = new InformacoesCarometro();

    /* 
     * Construtor da classe. Inicia os componentes do frame e faz outras configurações básicas.
     */
    public Carometro() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        File f = new File("Galeria");
        if(!f.isDirectory()){
            f.mkdir();
        }
        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/ALICE_COSTA 201511130024.jpg", "Galeria/ALICE_COSTA 201511130024.jpg");

        ImageIcon icon2 = new ImageIcon("Galeria/ALICE_COSTA 201511130024.jpg");
        icon2.setImage(icon2.getImage().getScaledInstance(120, 140, 100));
        label2.setIcon(icon2);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/AMAURY_VIANNA 201511130326.jpg", "Galeria/AMAURY_VIANNA 201511130326.jpg");

        ImageIcon icon3 = new ImageIcon("Galeria/AMAURY_VIANNA 201511130326.jpg");
        icon3.setImage(icon3.getImage().getScaledInstance(120, 140, 100));

        label3.setIcon(icon3);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/ANA_LUISA 201511130016.jpg", "Galeria/ANA_LUISA 201511130016.jpg");

        ImageIcon icon4 = new ImageIcon("Galeria/ANA_LUISA 201511130016.jpg"); //Somente esta linha foi alterada
        icon4.setImage(icon4.getImage().getScaledInstance(120, 140, 100));

        label4.setIcon(icon4);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/ANDRE_MATHEUS 201411130170.jpg", "Galeria/ANDRE_MATHEUS 201411130170.jpg");

        ImageIcon icon5 = new ImageIcon("Galeria/ANDRE_MATHEUS 201411130170.jpg");
        icon5.setImage(icon5.getImage().getScaledInstance(120, 140, 100));

        label5.setIcon(icon5);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/BRENO_MARIZ 201511130059.jpg", "Galeria/BRENO_MARIZ 201511130059.jpg");

        ImageIcon icon6 = new ImageIcon("Galeria/BRENO_MARIZ 201511130059.jpg");
        icon6.setImage(icon6.getImage().getScaledInstance(120, 140, 100));

        label6.setIcon(icon6);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/BRENO_PAIVA 201511130067.jpg", "Galeria/BRENO_PAIVA 201511130067.jpg");

        ImageIcon icon7 = new ImageIcon("Galeria/BRENO_PAIVA 201511130067.jpg");
        icon7.setImage(icon7.getImage().getScaledInstance(120, 140, 100));

        label7.setIcon(icon7);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/BRUNO 201511130040.JPG", "Galeria/BRUNO 201511130040.JPG");

        ImageIcon icon8 = new ImageIcon("Galeria/BRUNO 201511130040.JPG");
        icon8.setImage(icon8.getImage().getScaledInstance(120, 140, 100));

        label8.setIcon(icon8);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/CARLOS_EDUARDO 201411130197.jpg", "Galeria/CARLOS_EDUARDO 201411130197.jpg");

        ImageIcon icon9 = new ImageIcon("Galeria/CARLOS_EDUARDO 201411130197.jpg");
        icon9.setImage(icon9.getImage().getScaledInstance(120, 140, 100));

        label9.setIcon(icon9);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/ESTER 201511130083.JPG", "Galeria/ESTER 201511130083.JPG");

        ImageIcon icon10 = new ImageIcon("Galeria/ESTER 201511130083.JPG");
        icon10.setImage(icon10.getImage().getScaledInstance(120, 140, 100));

        label10.setIcon(icon10);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/FELIPE 201511130091.jpg", "Galeria/FELIPE 201511130091.jpg");

        ImageIcon icon11 = new ImageIcon("Galeria/FELIPE 201511130091.jpg");
        icon11.setImage(icon11.getImage().getScaledInstance(120, 140, 100));

        label11.setIcon(icon11);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/GABRIEL_HADDAD 201511130288.jpg", "Galeria/GABRIEL_HADDAD 201511130288.jpg");

        ImageIcon icon12 = new ImageIcon("Galeria/GABRIEL_HADDAD 201511130288.jpg");
        icon12.setImage(icon12.getImage().getScaledInstance(120, 140, 100));

        label12.setIcon(icon12);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/GABRIEL_VICTOR 201511130113.jpg", "Galeria/GABRIEL_VICTOR 201511130113.jpg");

        ImageIcon icon13 = new ImageIcon("Galeria/GABRIEL_VICTOR 201511130113.jpg");
        icon13.setImage(icon13.getImage().getScaledInstance(120, 140, 100));

        label13.setIcon(icon13);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/ISABELA_CAROLINA 201511130130.jpg", "Galeria/ISABELA_CAROLINA 201511130130.jpg");

        ImageIcon icon14 = new ImageIcon("Galeria/ISABELA_CAROLINA 201511130130.jpg");
        icon14.setImage(icon14.getImage().getScaledInstance(120, 140, 100));

        label14.setIcon(icon14);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/JOAO_PEDRO_ROSA 201511130270.jpg", "Galeria/JOAO_PEDRO_ROSA 201511130270.jpg");

        ImageIcon icon15 = new ImageIcon("Galeria/JOAO_PEDRO_ROSA 201511130270.jpg");
        icon15.setImage(icon15.getImage().getScaledInstance(120, 140, 100));

        label15.setIcon(icon15);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/JOAO_PEDRO_SANTOS 201511130300.jpg", "Galeria/JOAO_PEDRO_SANTOS 201511130300.jpg");

        ImageIcon icon16 = new ImageIcon("Galeria/JOAO_PEDRO_SANTOS 201511130300.jpg");
        icon16.setImage(icon16.getImage().getScaledInstance(120, 140, 100));

        label16.setIcon(icon16);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/JOAO_VICTOR 201511130148.jpg", "Galeria/JOAO_VICTOR 201511130148.jpg");

        ImageIcon icon17 = new ImageIcon("Galeria/JOAO_VICTOR 201511130148.jpg");
        icon17.setImage(icon17.getImage().getScaledInstance(120, 140, 100));

        label17.setIcon(icon17);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/LUANA_PINHEIRO_201511130296.jpg", "Galeria/LUANA_PINHEIRO_201511130296.jpg");

        ImageIcon icon18 = new ImageIcon("Galeria/LUANA_PINHEIRO_201511130296.jpg");
        icon18.setImage(icon18.getImage().getScaledInstance(120, 140, 100));

        label18.setIcon(icon18);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/LUCAS 201511130261.jpg", "Galeria/LUCAS 201511130261.jpg");

        ImageIcon icon19 = new ImageIcon("Galeria/LUCAS 201511130261.jpg");
        icon19.setImage(icon19.getImage().getScaledInstance(120, 140, 100));

        label19.setIcon(icon19);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/LUIZ 201511130156.jpg", "Galeria/LUIZ 201511130156.jpg");

        ImageIcon icon20 = new ImageIcon("Galeria/LUIZ 201511130156.jpg");
        icon20.setImage(icon20.getImage().getScaledInstance(120, 140, 100));

        label20.setIcon(icon20);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/MARCELO 201511130180.jpg", "Galeria/MARCELO 201511130180.jpg");

        ImageIcon icon21 = new ImageIcon("Galeria/MARCELO 201511130180.jpg");
        icon21.setImage(icon21.getImage().getScaledInstance(120, 140, 100));

        label21.setIcon(icon21);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/MARIA_CAROLINA 201511130253.jpg", "Galeria/MARIA_CAROLINA 201511130253.jpg");

        ImageIcon icon22 = new ImageIcon("Galeria/MARIA_CAROLINA 201511130253.jpg");
        icon22.setImage(icon22.getImage().getScaledInstance(120, 140, 100));

        label22.setIcon(icon22);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/PAULA_RIBEIRO 201511130245.jpg", "Galeria/PAULA_RIBEIRO 201511130245.jpg");

        ImageIcon icon23 = new ImageIcon("Galeria/PAULA_RIBEIRO 201511130245.jpg");
        icon23.setImage(icon23.getImage().getScaledInstance(120, 140, 100));

        label23.setIcon(icon23);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/PEDRO_HENRIQUE 201511130199.jpg", "Galeria/PEDRO_HENRIQUE 201511130199.jpg");

        ImageIcon icon24 = new ImageIcon("Galeria/PEDRO_HENRIQUE 201511130199.jpg");
        icon24.setImage(icon24.getImage().getScaledInstance(120, 140, 100));

        label24.setIcon(icon24);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/THALES_ALLAN 201611130433.jpg", "Galeria/THALES_ALLAN 201611130433.jpg");

        ImageIcon icon25 = new ImageIcon("Galeria/THALES_ALLAN 201611130433.jpg");
        icon25.setImage(icon25.getImage().getScaledInstance(120, 140, 100));

        label25.setIcon(icon25);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/THALES_GABRIEL 201411130251.jpg", "Galeria/THALES_GABRIEL 201411130251.jpg");

        ImageIcon icon26 = new ImageIcon("Galeria/THALES_GABRIEL 201411130251.jpg");
        icon26.setImage(icon26.getImage().getScaledInstance(120, 140, 100));

        label26.setIcon(icon26);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/VICTOR_CESAR 201511130202.jpg", "Galeria/VICTOR_CESAR 201511130202.jpg");

        ImageIcon icon27 = new ImageIcon("Galeria/VICTOR_CESAR 201511130202.jpg");
        icon27.setImage(icon27.getImage().getScaledInstance(120, 140, 100));

        label27.setIcon(icon27);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/VICTOR_GABRIEL 201511130210.jpg", "Galeria/VICTOR_GABRIEL 201511130210.jpg");

        ImageIcon icon28 = new ImageIcon("Galeria/VICTOR_GABRIEL 201511130210.jpg");
        icon28.setImage(icon28.getImage().getScaledInstance(120, 140, 100));

        label28.setIcon(icon28);

        SSH.baixarArquivo("cefet-inf-2015.ddns.net", "root", "apenasinf-2015", "/carometro/VITOR_RODARTE 201511130229.jpg", "Galeria/VITOR_RODARTE 201511130229.jpg");

        ImageIcon icon29 = new ImageIcon("Galeria/VITOR_RODARTE 201511130229.jpg");
        icon29.setImage(icon29.getImage().getScaledInstance(120, 140, 100));

        label29.setIcon(icon29);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        label36 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label17 = new javax.swing.JLabel();
        label10 = new javax.swing.JLabel();
        label18 = new javax.swing.JLabel();
        label27 = new javax.swing.JLabel();
        label28 = new javax.swing.JLabel();
        label20 = new javax.swing.JLabel();
        label29 = new javax.swing.JLabel();
        label30 = new javax.swing.JLabel();
        label31 = new javax.swing.JLabel();
        label32 = new javax.swing.JLabel();
        label33 = new javax.swing.JLabel();
        label34 = new javax.swing.JLabel();
        label35 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        label8 = new javax.swing.JLabel();
        label9 = new javax.swing.JLabel();
        label11 = new javax.swing.JLabel();
        label12 = new javax.swing.JLabel();
        label13 = new javax.swing.JLabel();
        label14 = new javax.swing.JLabel();
        label15 = new javax.swing.JLabel();
        label16 = new javax.swing.JLabel();
        label19 = new javax.swing.JLabel();
        label21 = new javax.swing.JLabel();
        label22 = new javax.swing.JLabel();
        label23 = new javax.swing.JLabel();
        label24 = new javax.swing.JLabel();
        label25 = new javax.swing.JLabel();
        label26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Repositório de Fotos");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(1, 87, 155));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Galeria");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(228, 225, 225));
        jLabel4.setText("Carômetro");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(1063, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1454, 0);

        jPanel2.setBackground(new java.awt.Color(33, 150, 243));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("<html><body>Centro Federal de Educação Tecnológica de Minas Gerais <br> Av. Amazonas 5253 - Nova Suiça - Belo Horizonte - MG - Brasil<br> Telefone: +55 (31) 3319-7000 - Fax: +55 (31) 3319-7001</body></html>");

        jButton2.setBackground(new java.awt.Color(1, 87, 155));
        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("VOLTAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 937, Short.MAX_VALUE)
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

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 710, 1350, 60);

        label36.setBackground(new java.awt.Color(0, 0, 0));
        label36.setText("jLabel3");
        label36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label36MouseClicked(evt);
            }
        });
        getContentPane().add(label36);
        label36.setBounds(1170, 550, 120, 140);

        label1.setBackground(new java.awt.Color(0, 0, 0));
        label1.setText("jLabel3");
        label1.setMaximumSize(new java.awt.Dimension(120, 140));
        label1.setMinimumSize(new java.awt.Dimension(120, 140));
        label1.setPreferredSize(new java.awt.Dimension(120, 140));
        label1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label1MouseClicked(evt);
            }
        });
        getContentPane().add(label1);
        label1.setBounds(50, 100, 120, 140);

        label17.setBackground(new java.awt.Color(0, 0, 0));
        label17.setText("jLabel3");
        label17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label17MouseClicked(evt);
            }
        });
        getContentPane().add(label17);
        label17.setBounds(1030, 250, 120, 140);

        label10.setBackground(new java.awt.Color(0, 0, 0));
        label10.setText("jLabel3");
        label10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label10MouseClicked(evt);
            }
        });
        getContentPane().add(label10);
        label10.setBounds(50, 250, 120, 140);

        label18.setBackground(new java.awt.Color(0, 0, 0));
        label18.setText("jLabel3");
        label18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label18MouseClicked(evt);
            }
        });
        getContentPane().add(label18);
        label18.setBounds(1170, 250, 120, 140);

        label27.setBackground(new java.awt.Color(0, 0, 0));
        label27.setText("jLabel3");
        label27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label27MouseClicked(evt);
            }
        });
        getContentPane().add(label27);
        label27.setBounds(1170, 400, 120, 140);

        label28.setBackground(new java.awt.Color(0, 0, 0));
        label28.setText("jLabel3");
        label28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label28MouseClicked(evt);
            }
        });
        getContentPane().add(label28);
        label28.setBounds(50, 550, 120, 140);

        label20.setBackground(new java.awt.Color(0, 0, 0));
        label20.setText("jLabel3");
        label20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label20MouseClicked(evt);
            }
        });
        getContentPane().add(label20);
        label20.setBounds(190, 400, 120, 140);

        label29.setBackground(new java.awt.Color(0, 0, 0));
        label29.setText("jLabel3");
        label29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label29MouseClicked(evt);
            }
        });
        getContentPane().add(label29);
        label29.setBounds(190, 550, 120, 140);

        label30.setBackground(new java.awt.Color(0, 0, 0));
        label30.setText("jLabel3");
        label30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label30MouseClicked(evt);
            }
        });
        getContentPane().add(label30);
        label30.setBounds(330, 550, 120, 140);

        label31.setBackground(new java.awt.Color(0, 0, 0));
        label31.setText("jLabel3");
        label31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label31MouseClicked(evt);
            }
        });
        getContentPane().add(label31);
        label31.setBounds(470, 550, 120, 140);

        label32.setBackground(new java.awt.Color(0, 0, 0));
        label32.setText("jLabel3");
        label32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label32MouseClicked(evt);
            }
        });
        getContentPane().add(label32);
        label32.setBounds(610, 550, 120, 140);

        label33.setBackground(new java.awt.Color(0, 0, 0));
        label33.setText("jLabel3");
        label33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label33MouseClicked(evt);
            }
        });
        getContentPane().add(label33);
        label33.setBounds(750, 550, 120, 140);

        label34.setBackground(new java.awt.Color(0, 0, 0));
        label34.setText("jLabel3");
        label34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label34MouseClicked(evt);
            }
        });
        getContentPane().add(label34);
        label34.setBounds(890, 550, 120, 140);

        label35.setBackground(new java.awt.Color(0, 0, 0));
        label35.setText("jLabel3");
        label35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label35MouseClicked(evt);
            }
        });
        getContentPane().add(label35);
        label35.setBounds(1030, 550, 120, 140);

        label2.setBackground(new java.awt.Color(0, 0, 0));
        label2.setText("jLabel3");
        label2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label2MouseClicked(evt);
            }
        });
        getContentPane().add(label2);
        label2.setBounds(190, 100, 120, 140);

        label3.setBackground(new java.awt.Color(0, 0, 0));
        label3.setText("jLabel3");
        label3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label3MouseClicked(evt);
            }
        });
        getContentPane().add(label3);
        label3.setBounds(330, 100, 120, 140);

        label4.setBackground(new java.awt.Color(0, 0, 0));
        label4.setText("jLabel3");
        label4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label4MouseClicked(evt);
            }
        });
        getContentPane().add(label4);
        label4.setBounds(470, 100, 120, 140);

        label5.setBackground(new java.awt.Color(0, 0, 0));
        label5.setText("jLabel3");
        label5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label5MouseClicked(evt);
            }
        });
        getContentPane().add(label5);
        label5.setBounds(610, 100, 120, 140);

        label6.setBackground(new java.awt.Color(0, 0, 0));
        label6.setText("jLabel3");
        label6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label6MouseClicked(evt);
            }
        });
        getContentPane().add(label6);
        label6.setBounds(750, 100, 120, 140);

        label7.setBackground(new java.awt.Color(0, 0, 0));
        label7.setText("jLabel3");
        label7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label7MouseClicked(evt);
            }
        });
        getContentPane().add(label7);
        label7.setBounds(890, 100, 120, 140);

        label8.setBackground(new java.awt.Color(0, 0, 0));
        label8.setText("jLabel3");
        label8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label8MouseClicked(evt);
            }
        });
        getContentPane().add(label8);
        label8.setBounds(1030, 100, 120, 140);

        label9.setBackground(new java.awt.Color(0, 0, 0));
        label9.setText("jLabel3");
        label9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label9MouseClicked(evt);
            }
        });
        getContentPane().add(label9);
        label9.setBounds(1170, 100, 120, 140);

        label11.setBackground(new java.awt.Color(0, 0, 0));
        label11.setText("jLabel3");
        label11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label11MouseClicked(evt);
            }
        });
        getContentPane().add(label11);
        label11.setBounds(190, 250, 120, 140);

        label12.setBackground(new java.awt.Color(0, 0, 0));
        label12.setText("jLabel3");
        label12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label12MouseClicked(evt);
            }
        });
        getContentPane().add(label12);
        label12.setBounds(330, 250, 120, 140);

        label13.setBackground(new java.awt.Color(0, 0, 0));
        label13.setText("jLabel3");
        label13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label13MouseClicked(evt);
            }
        });
        getContentPane().add(label13);
        label13.setBounds(470, 250, 120, 140);

        label14.setBackground(new java.awt.Color(0, 0, 0));
        label14.setText("jLabel3");
        label14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label14MouseClicked(evt);
            }
        });
        getContentPane().add(label14);
        label14.setBounds(610, 250, 120, 140);

        label15.setBackground(new java.awt.Color(0, 0, 0));
        label15.setText("jLabel3");
        label15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label15MouseClicked(evt);
            }
        });
        getContentPane().add(label15);
        label15.setBounds(750, 250, 120, 140);

        label16.setBackground(new java.awt.Color(0, 0, 0));
        label16.setText("jLabel3");
        label16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label16MouseClicked(evt);
            }
        });
        getContentPane().add(label16);
        label16.setBounds(890, 250, 120, 140);

        label19.setBackground(new java.awt.Color(0, 0, 0));
        label19.setText("jLabel3");
        label19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label19MouseClicked(evt);
            }
        });
        getContentPane().add(label19);
        label19.setBounds(50, 400, 120, 140);

        label21.setBackground(new java.awt.Color(0, 0, 0));
        label21.setText("jLabel3");
        label21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label21MouseClicked(evt);
            }
        });
        getContentPane().add(label21);
        label21.setBounds(330, 400, 120, 140);

        label22.setBackground(new java.awt.Color(0, 0, 0));
        label22.setText("jLabel3");
        label22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label22MouseClicked(evt);
            }
        });
        getContentPane().add(label22);
        label22.setBounds(470, 400, 120, 140);

        label23.setBackground(new java.awt.Color(0, 0, 0));
        label23.setText("jLabel3");
        label23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label23MouseClicked(evt);
            }
        });
        getContentPane().add(label23);
        label23.setBounds(610, 400, 120, 140);

        label24.setBackground(new java.awt.Color(0, 0, 0));
        label24.setText("jLabel3");
        label24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label24MouseClicked(evt);
            }
        });
        getContentPane().add(label24);
        label24.setBounds(750, 400, 120, 140);

        label25.setBackground(new java.awt.Color(0, 0, 0));
        label25.setText("jLabel3");
        label25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label25MouseClicked(evt);
            }
        });
        getContentPane().add(label25);
        label25.setBounds(890, 400, 120, 140);

        label26.setBackground(new java.awt.Color(0, 0, 0));
        label26.setText("jLabel3");
        label26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label26MouseClicked(evt);
            }
        });
        getContentPane().add(label26);
        label26.setBounds(1030, 400, 120, 140);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void baixaImagens() {

    }

    public ImageIcon redimensionar(JLabel jLabel, int xLargura, int yAltura) {

        ImageIcon img = new ImageIcon(jLabel.getIcon().toString());
        img.setImage(img.getImage().getScaledInstance(xLargura, yAltura, 100));

        return img;
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Galeria gal = new Galeria();
        this.setVisible(false);
        gal.setVisible(true);


    }//GEN-LAST:event_jButton2ActionPerformed

    private void label1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label1MouseClicked
        InformacoesCarometro i = new InformacoesCarometro();
    }//GEN-LAST:event_label1MouseClicked

    private void label2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label2MouseClicked
        i.abreInformacoes("Galeria/ALICE_COSTA 201511130024.jpg", "ALICE DE OLIVEIRA ANDALÉCIO COSTA\nMATRÍCULA: 201511130024\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label2MouseClicked

    private void label3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label3MouseClicked
        i.abreInformacoes("Galeria/AMAURY_VIANNA 201511130326.jpg", "AMAURY VIANNA\nMATRÍCULA: 201511130326\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label3MouseClicked

    private void label4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label4MouseClicked
        i.abreInformacoes("Galeria/ANA_LUISA 201511130016.jpg", "ANA LUISA OHNO\nMATRÍCULA: 201511130016\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label4MouseClicked

    private void label5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label5MouseClicked
        i.abreInformacoes("Galeria/ANDRE_MATHEUS 201411130170.jpg", "ANDRÉ MATHEUS\nMATRÍCULA: 201411130170\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label5MouseClicked

    private void label6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label6MouseClicked
        i.abreInformacoes("Galeria/BRENO_MARIZ 201511130059.jpg", "BRENO MARIZ\nMATRÍCULA: 201511130059\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label6MouseClicked

    private void label7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label7MouseClicked
        i.abreInformacoes("Galeria/BRENO_PAIVA 201511130067.jpg", "BRENO PAIVA\nMATRÍCULA: 201511130067\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label7MouseClicked

    private void label8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label8MouseClicked
        i.abreInformacoes("Galeria/BRUNO 201511130040.jpg", "BRUNO\nMATRÍCULA: 201511130040\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label8MouseClicked

    private void label9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label9MouseClicked
        i.abreInformacoes("Galeria/CARLOS_EDUARDO 201411130197.jpg", "CARLOS EDUARDO\nMATRÍCULA: 201411130197\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label9MouseClicked

    private void label10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label10MouseClicked
        i.abreInformacoes("Galeria/ESTER 201511130083.jpg", "ESTER PIRES\nMATRÍCULA: 201511130083\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label10MouseClicked

    private void label11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label11MouseClicked
        i.abreInformacoes("Galeria/FELIPE 201511130091.jpg", "FELIPE LINHARES\nMATRÍCULA: 201511130091\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label11MouseClicked

    private void label12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label12MouseClicked
        i.abreInformacoes("Galeria/GABRIEL_HADDAD 201511130288.jpg", "GABRIEL HADDAD\nMATRÍCULA: 201511130288\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label12MouseClicked

    private void label13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label13MouseClicked
        i.abreInformacoes("Galeria/GABRIEL_VICTOR 201511130113.jpg", "GABRIEL VICTOR\nMATRÍCULA: 201511130113\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label13MouseClicked

    private void label14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label14MouseClicked
        i.abreInformacoes("Galeria/ISABELA_CAROLINA 201511130130.jpg", "ISABELA CAROLINA\nMATRÍCULA: 201511130130\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label14MouseClicked

    private void label15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label15MouseClicked
        i.abreInformacoes("Galeria/JOAO_PEDRO_ROSA 201511130270.jpg", "JOÃO PEDRO ROSA\nMATRÍCULA: 201511130270\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label15MouseClicked

    private void label16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label16MouseClicked
        i.abreInformacoes("Galeria/JOAO_PEDRO_SANTOS 201511130300.jpg", "JOÃO PEDRO DOS SANTOS\nMATRÍCULA: 201511130300\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label16MouseClicked

    private void label17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label17MouseClicked
        i.abreInformacoes("Galeria/JOAO_VICTOR 201511130148.jpg", "JOÃO VITOR DE CARVALHO\nMATRÍCULA: 201511130148\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label17MouseClicked

    private void label18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label18MouseClicked
        i.abreInformacoes("Galeria/LUANA_PINHEIRO_201511130296.jpg", "LUANA PINHEIRO\nMATRÍCULA: 201511130296\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label18MouseClicked

    private void label19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label19MouseClicked
        i.abreInformacoes("Galeria/LUCAS 201511130261.jpg", "LUCAS OCARINO\nMATRÍCULA: 201511130261\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label19MouseClicked

    private void label20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label20MouseClicked
        i.abreInformacoes("Galeria/LUIZ 201511130156.jpg", "LUIZ AUGUSTO\nMATRÍCULA: 201511130156\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label20MouseClicked

    private void label21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label21MouseClicked
        i.abreInformacoes("Galeria/MARCELO 201511130180.jpg", "MARCELO AUGUSTO\nMATRÍCULA: 201511130180\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label21MouseClicked

    private void label22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label22MouseClicked
        i.abreInformacoes("Galeria/MARIA_CAROLINA 201511130253.jpg", "MARIA CAROLINA\nMATRÍCULA: 201511130253\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label22MouseClicked

    private void label23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label23MouseClicked
        i.abreInformacoes("Galeria/PAULA_RIBEIRO 201511130245.jpg", "PAULA RIBEIRO\nMATRÍCULA: 201511130245\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label23MouseClicked

    private void label24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label24MouseClicked
        i.abreInformacoes("Galeria/PEDRO_HENRIQUE 201511130199.jpg", "PEDRO HENRIQUE\nMATRÍCULA: 201511130199\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label24MouseClicked

    private void label25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label25MouseClicked
        i.abreInformacoes("Galeria/THALES_ALLAN 201611130433.jpg", "THALES ALLAN\nMATRÍCULA: 201611130433\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label25MouseClicked

    private void label26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label26MouseClicked
        i.abreInformacoes("Galeria/THALES_GABRIEL 201411130251.jpg", "THALES GABRIEL\nMATRÍCULA: 201411130251\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label26MouseClicked

    private void label27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label27MouseClicked
        i.abreInformacoes("Galeria/VICTOR_CESAR 201511130202.jpg", "VICTOR CESAR\nMATRÍCULA: 201511130202\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label27MouseClicked

    private void label28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label28MouseClicked
        i.abreInformacoes("Galeria/VICTOR_GABRIEL 201511130210.jpg", "VICTOR GABRIEL\nMATRÍCULA: 201511130210\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label28MouseClicked

    private void label29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label29MouseClicked
        i.abreInformacoes("Galeria/VITOR_RODARTE 201511130229.jpg", "VITOR RODARTE\nMATRÍCULA: 201511130229\nINFORMÁTICA 2A");
    }//GEN-LAST:event_label29MouseClicked

    private void label30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label30MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_label30MouseClicked

    private void label31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label31MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_label31MouseClicked

    private void label32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label32MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_label32MouseClicked

    private void label33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label33MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_label33MouseClicked

    private void label34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label34MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_label34MouseClicked

    private void label35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label35MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_label35MouseClicked

    private void label36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label36MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_label36MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label11;
    private javax.swing.JLabel label12;
    private javax.swing.JLabel label13;
    private javax.swing.JLabel label14;
    private javax.swing.JLabel label15;
    private javax.swing.JLabel label16;
    private javax.swing.JLabel label17;
    private javax.swing.JLabel label18;
    private javax.swing.JLabel label19;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label20;
    private javax.swing.JLabel label21;
    private javax.swing.JLabel label22;
    private javax.swing.JLabel label23;
    private javax.swing.JLabel label24;
    private javax.swing.JLabel label25;
    private javax.swing.JLabel label26;
    private javax.swing.JLabel label27;
    private javax.swing.JLabel label28;
    private javax.swing.JLabel label29;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label30;
    private javax.swing.JLabel label31;
    private javax.swing.JLabel label32;
    private javax.swing.JLabel label33;
    private javax.swing.JLabel label34;
    private javax.swing.JLabel label35;
    private javax.swing.JLabel label36;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    // End of variables declaration//GEN-END:variables
}
