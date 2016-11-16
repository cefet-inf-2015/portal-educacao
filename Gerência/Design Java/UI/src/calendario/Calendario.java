package calendario;

import BancoDeDados.Conexao;
import calendario.Formulario;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Calendario extends javax.swing.JPanel {
    /*Contêm os Labels dos blocos do calendário*/
    public JLabel[] block;
    /*Recebe os dados para inserção de atividade*/
    private Formulario form;
    /*Contêm a data inserida no calendário*/
    public LocalDate data;
    
    public JLabel diaSelec;
    public JTextArea ativ;
    public Calendario() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        //Inicia a interface
        initComponents();
        ativ = jTextArea1;
        /*Ultra Mega Hyper Gambiarra por conta da p***a do Netbeans que não me deixa alterar as coisas*/
        block = new JLabel[42];
        block[0] = lBlock1;
        block[1] = lBlock2;
        block[2] = lBlock3;
        block[3] = lBlock4;
        block[4] = lBlock5;
        block[5] = lBlock6;
        block[6] = lBlock7;
        block[7] = lBlock8;
        block[8] = lBlock9;
        block[9] = lBlock10;
        block[10] = lBlock11;
        block[11] = lBlock12;
        block[12] = lBlock13;
        block[13] = lBlock14;
        block[14] = lBlock15;
        block[15] = lBlock16;
        block[16] = lBlock17;
        block[17] = lBlock18;
        block[18] = lBlock19;
        block[19] = lBlock20;
        block[20] = lBlock21;
        block[21] = lBlock22;
        block[22] = lBlock23;
        block[23] = lBlock24;
        block[24] = lBlock25;
        block[25] = lBlock26;
        block[26] = lBlock27;
        block[27] = lBlock28;
        block[28] = lBlock29;
        block[29] = lBlock30;
        block[30] = lBlock31;
        block[31] = lBlock32;
        block[32] = lBlock33;
        block[33] = lBlock34;
        block[34] = lBlock35;
        block[35] = lBlock36;
        block[36] = lBlock37;
        block[37] = lBlock38;
        block[38] = lBlock39;
        block[39] = lBlock40;
        block[40] = lBlock41;
        block[41] = lBlock42;
        //Pega a data local e transforma em uma matriz de String
        data = LocalDate.now();
        String sData[] = data.toString().split("-");
        //Seta o texto do JTextField com a data 
        jTextField3.setText(sData[1]+sData[0]);
        //Chama exibição dos dias do calendário
        exibeData(data);     
        //Adiciona o Action Listener às datas
        for(int I=0; I<42; I++){
            block[I].addMouseListener(new ListenerData());
        }
    }
    
    private void exibeData(LocalDate data) {
        //Seta a data para o primeiro dia do mês
        data = data.withDayOfMonth(1);
        //Pega o dia da semana em que o mês começa
        int dia = data.getDayOfWeek().getValue();
        //Considera domingo sendo o primeiro dia da semana
        if(dia==7)
            dia=0;
        /*Define o mês do Calendário*/
        switch (data.getMonthValue()) {
            case 1:
                jLabel3.setText("Janeiro");
                break;
            case 2:
                jLabel3.setText("Fevereiro");
                break;
            case 3:
                jLabel3.setText("Março");
                break;
            case 4:
                jLabel3.setText("Abril");
                break;
            case 5:
                jLabel3.setText("Maio");
                break;
            case 6:
                jLabel3.setText("Junho");
                break;
            case 7:
                jLabel3.setText("Julho");
                break;
            case 8:
                jLabel3.setText("Agosto");
                break;
            case 9:
                jLabel3.setText("Setembro");
                break;
            case 10:
                jLabel3.setText("Outubro");
                break;
            case 11:
                jLabel3.setText("Novembro");
                break;
            case 12:
                jLabel3.setText("Dezembro");
                break;       
        }
        
        //Capta quantos dias tem o mês
        int qdias = data.lengthOfMonth();
        
        //Preenche o calendário
        int auxd = 1;
        while(auxd<=qdias) {
            block[dia].setText(Integer.toString(auxd));
            auxd++;
            dia++;
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        block1 = new javax.swing.JPanel();
        lBlock1 = new javax.swing.JLabel();
        block8 = new javax.swing.JPanel();
        lBlock8 = new javax.swing.JLabel();
        block15 = new javax.swing.JPanel();
        lBlock15 = new javax.swing.JLabel();
        block22 = new javax.swing.JPanel();
        lBlock22 = new javax.swing.JLabel();
        block29 = new javax.swing.JPanel();
        lBlock29 = new javax.swing.JLabel();
        block23 = new javax.swing.JPanel();
        lBlock23 = new javax.swing.JLabel();
        block30 = new javax.swing.JPanel();
        lBlock30 = new javax.swing.JLabel();
        block9 = new javax.swing.JPanel();
        lBlock9 = new javax.swing.JLabel();
        block2 = new javax.swing.JPanel();
        lBlock2 = new javax.swing.JLabel();
        block16 = new javax.swing.JPanel();
        lBlock16 = new javax.swing.JLabel();
        block10 = new javax.swing.JPanel();
        lBlock10 = new javax.swing.JLabel();
        block3 = new javax.swing.JPanel();
        lBlock3 = new javax.swing.JLabel();
        block24 = new javax.swing.JPanel();
        lBlock24 = new javax.swing.JLabel();
        block31 = new javax.swing.JPanel();
        lBlock31 = new javax.swing.JLabel();
        block17 = new javax.swing.JPanel();
        lBlock17 = new javax.swing.JLabel();
        block32 = new javax.swing.JPanel();
        lBlock32 = new javax.swing.JLabel();
        block18 = new javax.swing.JPanel();
        lBlock18 = new javax.swing.JLabel();
        block11 = new javax.swing.JPanel();
        lBlock11 = new javax.swing.JLabel();
        block25 = new javax.swing.JPanel();
        lBlock25 = new javax.swing.JLabel();
        block4 = new javax.swing.JPanel();
        lBlock4 = new javax.swing.JLabel();
        block12 = new javax.swing.JPanel();
        lBlock12 = new javax.swing.JLabel();
        block5 = new javax.swing.JPanel();
        lBlock5 = new javax.swing.JLabel();
        block19 = new javax.swing.JPanel();
        lBlock19 = new javax.swing.JLabel();
        block33 = new javax.swing.JPanel();
        lBlock33 = new javax.swing.JLabel();
        block26 = new javax.swing.JPanel();
        lBlock26 = new javax.swing.JLabel();
        block34 = new javax.swing.JPanel();
        lBlock34 = new javax.swing.JLabel();
        block27 = new javax.swing.JPanel();
        lBlock27 = new javax.swing.JLabel();
        block13 = new javax.swing.JPanel();
        lBlock13 = new javax.swing.JLabel();
        block6 = new javax.swing.JPanel();
        lBlock6 = new javax.swing.JLabel();
        block20 = new javax.swing.JPanel();
        lBlock20 = new javax.swing.JLabel();
        block7 = new javax.swing.JPanel();
        lBlock7 = new javax.swing.JLabel();
        block35 = new javax.swing.JPanel();
        lBlock35 = new javax.swing.JLabel();
        block28 = new javax.swing.JPanel();
        lBlock28 = new javax.swing.JLabel();
        block21 = new javax.swing.JPanel();
        lBlock21 = new javax.swing.JLabel();
        block14 = new javax.swing.JPanel();
        lBlock14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        block38 = new javax.swing.JPanel();
        lBlock38 = new javax.swing.JLabel();
        block39 = new javax.swing.JPanel();
        lBlock39 = new javax.swing.JLabel();
        block42 = new javax.swing.JPanel();
        lBlock42 = new javax.swing.JLabel();
        block41 = new javax.swing.JPanel();
        lBlock41 = new javax.swing.JLabel();
        block36 = new javax.swing.JPanel();
        lBlock36 = new javax.swing.JLabel();
        block37 = new javax.swing.JPanel();
        lBlock37 = new javax.swing.JLabel();
        block40 = new javax.swing.JPanel();
        lBlock40 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        try{ 
            javax.swing.text.MaskFormatter mData = new javax.swing.text.MaskFormatter("##/####");
            jTextField3 = new javax.swing.JFormattedTextField(mData);
        }
        catch (Exception e){
        }
        jPanel13 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(21, 101, 192));

        jLabel1.setBackground(new java.awt.Color(153, 255, 0));
        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Calendário de Atividades");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Data");

        jPanel2.setBackground(new java.awt.Color(21, 101, 192));
        jPanel2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Mês");
        jLabel3.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        block1.setBackground(new java.awt.Color(204, 204, 204));
        block1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block1.setMaximumSize(new java.awt.Dimension(55, 55));
        block1.setMinimumSize(new java.awt.Dimension(55, 55));
        block1.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block1Layout = new javax.swing.GroupLayout(block1);
        block1.setLayout(block1Layout);
        block1Layout.setHorizontalGroup(
            block1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block1Layout.setVerticalGroup(
            block1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block8.setBackground(new java.awt.Color(204, 204, 204));
        block8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block8.setMaximumSize(new java.awt.Dimension(55, 55));
        block8.setMinimumSize(new java.awt.Dimension(55, 55));
        block8.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock8.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block8Layout = new javax.swing.GroupLayout(block8);
        block8.setLayout(block8Layout);
        block8Layout.setHorizontalGroup(
            block8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock8, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block8Layout.setVerticalGroup(
            block8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block15.setBackground(new java.awt.Color(204, 204, 204));
        block15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block15.setMaximumSize(new java.awt.Dimension(55, 55));
        block15.setMinimumSize(new java.awt.Dimension(55, 55));
        block15.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock15.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block15Layout = new javax.swing.GroupLayout(block15);
        block15.setLayout(block15Layout);
        block15Layout.setHorizontalGroup(
            block15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock15, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block15Layout.setVerticalGroup(
            block15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block22.setBackground(new java.awt.Color(204, 204, 204));
        block22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block22.setMaximumSize(new java.awt.Dimension(55, 55));
        block22.setMinimumSize(new java.awt.Dimension(55, 55));
        block22.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock22.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block22Layout = new javax.swing.GroupLayout(block22);
        block22.setLayout(block22Layout);
        block22Layout.setHorizontalGroup(
            block22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock22, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block22Layout.setVerticalGroup(
            block22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block29.setBackground(new java.awt.Color(204, 204, 204));
        block29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block29.setMaximumSize(new java.awt.Dimension(55, 55));
        block29.setMinimumSize(new java.awt.Dimension(55, 55));
        block29.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock29.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block29Layout = new javax.swing.GroupLayout(block29);
        block29.setLayout(block29Layout);
        block29Layout.setHorizontalGroup(
            block29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock29, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block29Layout.setVerticalGroup(
            block29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block23.setBackground(new java.awt.Color(204, 204, 204));
        block23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block23.setMaximumSize(new java.awt.Dimension(55, 55));
        block23.setMinimumSize(new java.awt.Dimension(55, 55));
        block23.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock23.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block23Layout = new javax.swing.GroupLayout(block23);
        block23.setLayout(block23Layout);
        block23Layout.setHorizontalGroup(
            block23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock23, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block23Layout.setVerticalGroup(
            block23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block30.setBackground(new java.awt.Color(204, 204, 204));
        block30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block30.setMaximumSize(new java.awt.Dimension(55, 55));
        block30.setMinimumSize(new java.awt.Dimension(55, 55));
        block30.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock30.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block30Layout = new javax.swing.GroupLayout(block30);
        block30.setLayout(block30Layout);
        block30Layout.setHorizontalGroup(
            block30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock30, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block30Layout.setVerticalGroup(
            block30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block9.setBackground(new java.awt.Color(204, 204, 204));
        block9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block9.setMaximumSize(new java.awt.Dimension(55, 55));
        block9.setMinimumSize(new java.awt.Dimension(55, 55));
        block9.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock9.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block9Layout = new javax.swing.GroupLayout(block9);
        block9.setLayout(block9Layout);
        block9Layout.setHorizontalGroup(
            block9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock9, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block9Layout.setVerticalGroup(
            block9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block2.setBackground(new java.awt.Color(204, 204, 204));
        block2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block2.setMaximumSize(new java.awt.Dimension(55, 55));
        block2.setMinimumSize(new java.awt.Dimension(55, 55));
        block2.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block2Layout = new javax.swing.GroupLayout(block2);
        block2.setLayout(block2Layout);
        block2Layout.setHorizontalGroup(
            block2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block2Layout.setVerticalGroup(
            block2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block16.setBackground(new java.awt.Color(204, 204, 204));
        block16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block16.setMaximumSize(new java.awt.Dimension(55, 55));
        block16.setMinimumSize(new java.awt.Dimension(55, 55));
        block16.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock16.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block16Layout = new javax.swing.GroupLayout(block16);
        block16.setLayout(block16Layout);
        block16Layout.setHorizontalGroup(
            block16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock16, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block16Layout.setVerticalGroup(
            block16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block10.setBackground(new java.awt.Color(204, 204, 204));
        block10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block10.setMaximumSize(new java.awt.Dimension(55, 55));
        block10.setMinimumSize(new java.awt.Dimension(55, 55));
        block10.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock10.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block10Layout = new javax.swing.GroupLayout(block10);
        block10.setLayout(block10Layout);
        block10Layout.setHorizontalGroup(
            block10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock10, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block10Layout.setVerticalGroup(
            block10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block3.setBackground(new java.awt.Color(204, 204, 204));
        block3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block3.setMaximumSize(new java.awt.Dimension(55, 55));
        block3.setMinimumSize(new java.awt.Dimension(55, 55));
        block3.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block3Layout = new javax.swing.GroupLayout(block3);
        block3.setLayout(block3Layout);
        block3Layout.setHorizontalGroup(
            block3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock3, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block3Layout.setVerticalGroup(
            block3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block24.setBackground(new java.awt.Color(204, 204, 204));
        block24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block24.setMaximumSize(new java.awt.Dimension(55, 55));
        block24.setMinimumSize(new java.awt.Dimension(55, 55));
        block24.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock24.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block24Layout = new javax.swing.GroupLayout(block24);
        block24.setLayout(block24Layout);
        block24Layout.setHorizontalGroup(
            block24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock24, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block24Layout.setVerticalGroup(
            block24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block31.setBackground(new java.awt.Color(204, 204, 204));
        block31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block31.setMaximumSize(new java.awt.Dimension(55, 55));
        block31.setMinimumSize(new java.awt.Dimension(55, 55));
        block31.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock31.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block31Layout = new javax.swing.GroupLayout(block31);
        block31.setLayout(block31Layout);
        block31Layout.setHorizontalGroup(
            block31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock31, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block31Layout.setVerticalGroup(
            block31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block17.setBackground(new java.awt.Color(204, 204, 204));
        block17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block17.setMaximumSize(new java.awt.Dimension(55, 55));
        block17.setMinimumSize(new java.awt.Dimension(55, 55));
        block17.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock17.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block17Layout = new javax.swing.GroupLayout(block17);
        block17.setLayout(block17Layout);
        block17Layout.setHorizontalGroup(
            block17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock17, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block17Layout.setVerticalGroup(
            block17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block32.setBackground(new java.awt.Color(204, 204, 204));
        block32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block32.setMaximumSize(new java.awt.Dimension(55, 55));
        block32.setMinimumSize(new java.awt.Dimension(55, 55));
        block32.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock32.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block32Layout = new javax.swing.GroupLayout(block32);
        block32.setLayout(block32Layout);
        block32Layout.setHorizontalGroup(
            block32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock32, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block32Layout.setVerticalGroup(
            block32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block18.setBackground(new java.awt.Color(204, 204, 204));
        block18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block18.setMaximumSize(new java.awt.Dimension(55, 55));
        block18.setMinimumSize(new java.awt.Dimension(55, 55));
        block18.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock18.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block18Layout = new javax.swing.GroupLayout(block18);
        block18.setLayout(block18Layout);
        block18Layout.setHorizontalGroup(
            block18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock18, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block18Layout.setVerticalGroup(
            block18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block11.setBackground(new java.awt.Color(204, 204, 204));
        block11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block11.setMaximumSize(new java.awt.Dimension(55, 55));
        block11.setMinimumSize(new java.awt.Dimension(55, 55));
        block11.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock11.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block11Layout = new javax.swing.GroupLayout(block11);
        block11.setLayout(block11Layout);
        block11Layout.setHorizontalGroup(
            block11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock11, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block11Layout.setVerticalGroup(
            block11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block25.setBackground(new java.awt.Color(204, 204, 204));
        block25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block25.setMaximumSize(new java.awt.Dimension(55, 55));
        block25.setMinimumSize(new java.awt.Dimension(55, 55));
        block25.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock25.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block25Layout = new javax.swing.GroupLayout(block25);
        block25.setLayout(block25Layout);
        block25Layout.setHorizontalGroup(
            block25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock25, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block25Layout.setVerticalGroup(
            block25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block4.setBackground(new java.awt.Color(204, 204, 204));
        block4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block4.setMaximumSize(new java.awt.Dimension(55, 55));
        block4.setMinimumSize(new java.awt.Dimension(55, 55));
        block4.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block4Layout = new javax.swing.GroupLayout(block4);
        block4.setLayout(block4Layout);
        block4Layout.setHorizontalGroup(
            block4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock4, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block4Layout.setVerticalGroup(
            block4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block12.setBackground(new java.awt.Color(204, 204, 204));
        block12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block12.setMaximumSize(new java.awt.Dimension(55, 55));
        block12.setMinimumSize(new java.awt.Dimension(55, 55));
        block12.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock12.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block12Layout = new javax.swing.GroupLayout(block12);
        block12.setLayout(block12Layout);
        block12Layout.setHorizontalGroup(
            block12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock12, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block12Layout.setVerticalGroup(
            block12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block5.setBackground(new java.awt.Color(204, 204, 204));
        block5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block5.setMaximumSize(new java.awt.Dimension(55, 55));
        block5.setMinimumSize(new java.awt.Dimension(55, 55));
        block5.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block5Layout = new javax.swing.GroupLayout(block5);
        block5.setLayout(block5Layout);
        block5Layout.setHorizontalGroup(
            block5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock5, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block5Layout.setVerticalGroup(
            block5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block19.setBackground(new java.awt.Color(204, 204, 204));
        block19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block19.setMaximumSize(new java.awt.Dimension(55, 55));
        block19.setMinimumSize(new java.awt.Dimension(55, 55));
        block19.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock19.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block19Layout = new javax.swing.GroupLayout(block19);
        block19.setLayout(block19Layout);
        block19Layout.setHorizontalGroup(
            block19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock19, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block19Layout.setVerticalGroup(
            block19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block33.setBackground(new java.awt.Color(204, 204, 204));
        block33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block33.setMaximumSize(new java.awt.Dimension(55, 55));
        block33.setMinimumSize(new java.awt.Dimension(55, 55));
        block33.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock33.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block33Layout = new javax.swing.GroupLayout(block33);
        block33.setLayout(block33Layout);
        block33Layout.setHorizontalGroup(
            block33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock33, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block33Layout.setVerticalGroup(
            block33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block26.setBackground(new java.awt.Color(204, 204, 204));
        block26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block26.setMaximumSize(new java.awt.Dimension(55, 55));
        block26.setMinimumSize(new java.awt.Dimension(55, 55));
        block26.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock26.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block26Layout = new javax.swing.GroupLayout(block26);
        block26.setLayout(block26Layout);
        block26Layout.setHorizontalGroup(
            block26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock26, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block26Layout.setVerticalGroup(
            block26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block34.setBackground(new java.awt.Color(204, 204, 204));
        block34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block34.setMaximumSize(new java.awt.Dimension(55, 55));
        block34.setMinimumSize(new java.awt.Dimension(55, 55));
        block34.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock34.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block34Layout = new javax.swing.GroupLayout(block34);
        block34.setLayout(block34Layout);
        block34Layout.setHorizontalGroup(
            block34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock34, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block34Layout.setVerticalGroup(
            block34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block27.setBackground(new java.awt.Color(204, 204, 204));
        block27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block27.setMaximumSize(new java.awt.Dimension(55, 55));
        block27.setMinimumSize(new java.awt.Dimension(55, 55));
        block27.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock27.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block27Layout = new javax.swing.GroupLayout(block27);
        block27.setLayout(block27Layout);
        block27Layout.setHorizontalGroup(
            block27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock27, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block27Layout.setVerticalGroup(
            block27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block13.setBackground(new java.awt.Color(204, 204, 204));
        block13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block13.setMaximumSize(new java.awt.Dimension(55, 55));
        block13.setMinimumSize(new java.awt.Dimension(55, 55));
        block13.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock13.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block13Layout = new javax.swing.GroupLayout(block13);
        block13.setLayout(block13Layout);
        block13Layout.setHorizontalGroup(
            block13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock13, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block13Layout.setVerticalGroup(
            block13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block6.setBackground(new java.awt.Color(204, 204, 204));
        block6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block6.setMaximumSize(new java.awt.Dimension(55, 55));
        block6.setMinimumSize(new java.awt.Dimension(55, 55));
        block6.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block6Layout = new javax.swing.GroupLayout(block6);
        block6.setLayout(block6Layout);
        block6Layout.setHorizontalGroup(
            block6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock6, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block6Layout.setVerticalGroup(
            block6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block20.setBackground(new java.awt.Color(204, 204, 204));
        block20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block20.setMaximumSize(new java.awt.Dimension(55, 55));
        block20.setMinimumSize(new java.awt.Dimension(55, 55));
        block20.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock20.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block20Layout = new javax.swing.GroupLayout(block20);
        block20.setLayout(block20Layout);
        block20Layout.setHorizontalGroup(
            block20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock20, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block20Layout.setVerticalGroup(
            block20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block7.setBackground(new java.awt.Color(204, 204, 204));
        block7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block7.setMaximumSize(new java.awt.Dimension(55, 55));
        block7.setMinimumSize(new java.awt.Dimension(55, 55));
        block7.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock7.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block7Layout = new javax.swing.GroupLayout(block7);
        block7.setLayout(block7Layout);
        block7Layout.setHorizontalGroup(
            block7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock7, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block7Layout.setVerticalGroup(
            block7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block35.setBackground(new java.awt.Color(204, 204, 204));
        block35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block35.setMaximumSize(new java.awt.Dimension(55, 55));
        block35.setMinimumSize(new java.awt.Dimension(55, 55));
        block35.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock35.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block35Layout = new javax.swing.GroupLayout(block35);
        block35.setLayout(block35Layout);
        block35Layout.setHorizontalGroup(
            block35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock35, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block35Layout.setVerticalGroup(
            block35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block28.setBackground(new java.awt.Color(204, 204, 204));
        block28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block28.setMaximumSize(new java.awt.Dimension(55, 55));
        block28.setMinimumSize(new java.awt.Dimension(55, 55));
        block28.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock28.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block28Layout = new javax.swing.GroupLayout(block28);
        block28.setLayout(block28Layout);
        block28Layout.setHorizontalGroup(
            block28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock28, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block28Layout.setVerticalGroup(
            block28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block21.setBackground(new java.awt.Color(204, 204, 204));
        block21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block21.setMaximumSize(new java.awt.Dimension(55, 55));
        block21.setMinimumSize(new java.awt.Dimension(55, 55));
        block21.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock21.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block21Layout = new javax.swing.GroupLayout(block21);
        block21.setLayout(block21Layout);
        block21Layout.setHorizontalGroup(
            block21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock21, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block21Layout.setVerticalGroup(
            block21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block14.setBackground(new java.awt.Color(204, 204, 204));
        block14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block14.setMaximumSize(new java.awt.Dimension(55, 55));
        block14.setMinimumSize(new java.awt.Dimension(55, 55));
        block14.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock14.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block14Layout = new javax.swing.GroupLayout(block14);
        block14.setLayout(block14Layout);
        block14Layout.setHorizontalGroup(
            block14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock14, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block14Layout.setVerticalGroup(
            block14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setBackground(new java.awt.Color(21, 101, 192));
        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Inserir Atividade");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setMaximumSize(new java.awt.Dimension(117, 23));
        jButton2.setMinimumSize(new java.awt.Dimension(117, 23));
        jButton2.setPreferredSize(new java.awt.Dimension(117, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(21, 101, 192));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("OK");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        block38.setBackground(new java.awt.Color(204, 204, 204));
        block38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block38.setMaximumSize(new java.awt.Dimension(55, 55));
        block38.setMinimumSize(new java.awt.Dimension(55, 55));
        block38.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock38.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block38Layout = new javax.swing.GroupLayout(block38);
        block38.setLayout(block38Layout);
        block38Layout.setHorizontalGroup(
            block38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock38, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block38Layout.setVerticalGroup(
            block38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block39.setBackground(new java.awt.Color(204, 204, 204));
        block39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block39.setMaximumSize(new java.awt.Dimension(55, 55));
        block39.setMinimumSize(new java.awt.Dimension(55, 55));
        block39.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock39.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block39Layout = new javax.swing.GroupLayout(block39);
        block39.setLayout(block39Layout);
        block39Layout.setHorizontalGroup(
            block39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock39, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block39Layout.setVerticalGroup(
            block39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block42.setBackground(new java.awt.Color(204, 204, 204));
        block42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block42.setMaximumSize(new java.awt.Dimension(55, 55));
        block42.setMinimumSize(new java.awt.Dimension(55, 55));
        block42.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock42.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block42Layout = new javax.swing.GroupLayout(block42);
        block42.setLayout(block42Layout);
        block42Layout.setHorizontalGroup(
            block42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock42, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block42Layout.setVerticalGroup(
            block42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block41.setBackground(new java.awt.Color(204, 204, 204));
        block41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block41.setMaximumSize(new java.awt.Dimension(55, 55));
        block41.setMinimumSize(new java.awt.Dimension(55, 55));
        block41.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock41.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block41Layout = new javax.swing.GroupLayout(block41);
        block41.setLayout(block41Layout);
        block41Layout.setHorizontalGroup(
            block41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock41, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block41Layout.setVerticalGroup(
            block41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block36.setBackground(new java.awt.Color(204, 204, 204));
        block36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block36.setMaximumSize(new java.awt.Dimension(55, 55));
        block36.setMinimumSize(new java.awt.Dimension(55, 55));
        block36.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock36.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block36Layout = new javax.swing.GroupLayout(block36);
        block36.setLayout(block36Layout);
        block36Layout.setHorizontalGroup(
            block36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock36, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block36Layout.setVerticalGroup(
            block36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block37.setBackground(new java.awt.Color(204, 204, 204));
        block37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block37.setMaximumSize(new java.awt.Dimension(55, 55));
        block37.setMinimumSize(new java.awt.Dimension(55, 55));
        block37.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock37.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block37Layout = new javax.swing.GroupLayout(block37);
        block37.setLayout(block37Layout);
        block37Layout.setHorizontalGroup(
            block37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock37, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block37Layout.setVerticalGroup(
            block37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        block40.setBackground(new java.awt.Color(204, 204, 204));
        block40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        block40.setMaximumSize(new java.awt.Dimension(55, 55));
        block40.setMinimumSize(new java.awt.Dimension(55, 55));
        block40.setPreferredSize(new java.awt.Dimension(55, 45));

        lBlock40.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lBlock40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout block40Layout = new javax.swing.GroupLayout(block40);
        block40.setLayout(block40Layout);
        block40Layout.setHorizontalGroup(
            block40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, block40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock40, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );
        block40Layout.setVerticalGroup(
            block40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(block40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lBlock40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setOpaque(false);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("*Insira uma data e selecione algum dia");
        jTextArea1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextArea1.setPreferredSize(new java.awt.Dimension(200, 84));
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        jPanel5.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Atividade");

        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Matéria");
        jLabel5.setPreferredSize(new java.awt.Dimension(61, 18));

        jTextField2.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N

        jButton3.setBackground(new java.awt.Color(21, 101, 192));
        jButton3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Filtrar Atividades");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2)
                    .addComponent(jTextField1))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap())
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(55, 16));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Domingo");
        jLabel6.setFocusable(false);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setPreferredSize(new java.awt.Dimension(55, 16));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setPreferredSize(new java.awt.Dimension(55, 16));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Terça");
        jLabel8.setFocusable(false);
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel8.setPreferredSize(new java.awt.Dimension(55, 16));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel7.setPreferredSize(new java.awt.Dimension(55, 16));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Segunda");
        jLabel7.setFocusable(false);
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.setPreferredSize(new java.awt.Dimension(55, 16));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel8.setPreferredSize(new java.awt.Dimension(55, 16));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Quinta");
        jLabel10.setFocusable(false);
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel10.setPreferredSize(new java.awt.Dimension(55, 16));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel9.setPreferredSize(new java.awt.Dimension(55, 16));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Quarta");
        jLabel9.setFocusable(false);
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel9.setPreferredSize(new java.awt.Dimension(55, 16));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel10.setPreferredSize(new java.awt.Dimension(55, 16));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Sexta");
        jLabel11.setFocusable(false);
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel11.setPreferredSize(new java.awt.Dimension(55, 16));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel11.setPreferredSize(new java.awt.Dimension(55, 16));

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Sábado");
        jLabel12.setFocusable(false);
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel12.setPreferredSize(new java.awt.Dimension(55, 16));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTextField3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jPanel13.setBackground(new java.awt.Color(21, 101, 192));

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Atividades");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(block1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(block8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(block15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(block22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(block29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(block36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(block23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(block30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(block9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(block2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(block16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(block37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(block10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(block3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(block24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(block31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(block17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(block38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(block32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(block18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(block11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(block25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(block4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(block39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(block12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(block5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(block19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(block33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(block26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(block40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(block34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(block27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(block13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(block6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(block20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(block41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(block35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(block28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(block42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(block7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(block21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(block14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(445, 445, 445)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(block1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(block2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(block3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(block4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(block5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(block6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(block7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(block14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(block35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(block42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Inicializa frame correspondente ao formulário
        form = new Formulario();
        //Deixa o formulario visível
        form.setLocationRelativeTo(null);
        form.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Esvazia o calendário
        for(int x=0; x<42; x++) {
            block[x].setText("");
        }
        //Capta o dado inserido pelo usuário
        String sData[] = jTextField3.getText().split("/");
        //Verifica se o dado é válido
        if(Integer.parseInt(sData[0])>12) {
            JOptionPane.showMessageDialog(null, "Data inserida inválida!!!","                                      Alerta",
            JOptionPane.ERROR_MESSAGE,new ImageIcon("img.jpg"));
            //Pega a data local e transforma em uma matriz de String
            data = LocalDate.now();
            String sEData[] = data.toString().split("-");
            //Seta o texto do JTextField com a data 
            jTextField3.setText(sEData[1]+sEData[0]);
            //Chama exibição dos dias do calendário
            exibeData(data);
        }
        //Se válido constroi o calendário
        else {    
            data = data.withYear(Integer.parseInt(sData[1]));
            data = data.withMonth(Integer.parseInt(sData[0]));
            exibeData(data);
        }      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int I;
        for(I=0; I<42; I++){
            if(!block[I].getText().equals("")){
                break;
            }
        }
        I--;
        Conexao c = new Conexao();
        try {
            c.conectar("cefet-inf-2015.ddns.net:43306", "root", "apenasinf-2015", "calendario");
            String eventos="";
            String dia;
            String ultimaHora="";
            String subHora="";
            ResultSet res = c.enviarQueryResultados("SELECT * FROM eventos WHERE ano='" + data.getYear() + "' AND mes='" + data.getMonthValue() + "' ORDER BY hora ASC");
            while(!res.isAfterLast()){
                dia=res.getString("dia");
                if(block[I+Integer.parseInt(dia)]==diaSelec && (res.getString("atividade").equals(jTextField1.getText()) || jTextField1.getText().equals("")) && (res.getString("materia").equals(jTextField2.getText()) || jTextField2.getText().equals(""))){
                    if(!res.getString("hora").substring(0, 5).equals(ultimaHora)){
                        subHora = res.getString("hora").substring(0, 5);
                        ultimaHora=subHora;
                        eventos+=subHora+"\n";
                    }
                    eventos+=res.getString("atividade") + " - " + res.getString("descricao") + " - " + res.getString("materia") + "\n";
                }
                res.next();
            }
            ativ.setText(eventos);
            System.out.println("Filtrou");
            System.out.println(eventos);
        } catch (SQLException ex) {
            Logger.getLogger(Calendario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel block1;
    private javax.swing.JPanel block10;
    private javax.swing.JPanel block11;
    private javax.swing.JPanel block12;
    private javax.swing.JPanel block13;
    private javax.swing.JPanel block14;
    private javax.swing.JPanel block15;
    private javax.swing.JPanel block16;
    private javax.swing.JPanel block17;
    private javax.swing.JPanel block18;
    private javax.swing.JPanel block19;
    private javax.swing.JPanel block2;
    private javax.swing.JPanel block20;
    private javax.swing.JPanel block21;
    private javax.swing.JPanel block22;
    private javax.swing.JPanel block23;
    private javax.swing.JPanel block24;
    private javax.swing.JPanel block25;
    private javax.swing.JPanel block26;
    private javax.swing.JPanel block27;
    private javax.swing.JPanel block28;
    private javax.swing.JPanel block29;
    private javax.swing.JPanel block3;
    private javax.swing.JPanel block30;
    private javax.swing.JPanel block31;
    private javax.swing.JPanel block32;
    private javax.swing.JPanel block33;
    private javax.swing.JPanel block34;
    private javax.swing.JPanel block35;
    private javax.swing.JPanel block36;
    private javax.swing.JPanel block37;
    private javax.swing.JPanel block38;
    private javax.swing.JPanel block39;
    private javax.swing.JPanel block4;
    private javax.swing.JPanel block40;
    private javax.swing.JPanel block41;
    private javax.swing.JPanel block42;
    private javax.swing.JPanel block5;
    private javax.swing.JPanel block6;
    private javax.swing.JPanel block7;
    private javax.swing.JPanel block8;
    private javax.swing.JPanel block9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lBlock1;
    private javax.swing.JLabel lBlock10;
    private javax.swing.JLabel lBlock11;
    private javax.swing.JLabel lBlock12;
    private javax.swing.JLabel lBlock13;
    private javax.swing.JLabel lBlock14;
    private javax.swing.JLabel lBlock15;
    private javax.swing.JLabel lBlock16;
    private javax.swing.JLabel lBlock17;
    private javax.swing.JLabel lBlock18;
    private javax.swing.JLabel lBlock19;
    private javax.swing.JLabel lBlock2;
    private javax.swing.JLabel lBlock20;
    private javax.swing.JLabel lBlock21;
    private javax.swing.JLabel lBlock22;
    private javax.swing.JLabel lBlock23;
    private javax.swing.JLabel lBlock24;
    private javax.swing.JLabel lBlock25;
    private javax.swing.JLabel lBlock26;
    private javax.swing.JLabel lBlock27;
    private javax.swing.JLabel lBlock28;
    private javax.swing.JLabel lBlock29;
    private javax.swing.JLabel lBlock3;
    private javax.swing.JLabel lBlock30;
    private javax.swing.JLabel lBlock31;
    private javax.swing.JLabel lBlock32;
    private javax.swing.JLabel lBlock33;
    private javax.swing.JLabel lBlock34;
    private javax.swing.JLabel lBlock35;
    private javax.swing.JLabel lBlock36;
    private javax.swing.JLabel lBlock37;
    private javax.swing.JLabel lBlock38;
    private javax.swing.JLabel lBlock39;
    private javax.swing.JLabel lBlock4;
    private javax.swing.JLabel lBlock40;
    private javax.swing.JLabel lBlock41;
    private javax.swing.JLabel lBlock42;
    private javax.swing.JLabel lBlock5;
    private javax.swing.JLabel lBlock6;
    private javax.swing.JLabel lBlock7;
    private javax.swing.JLabel lBlock8;
    private javax.swing.JLabel lBlock9;
    // End of variables declaration//GEN-END:variables
}
