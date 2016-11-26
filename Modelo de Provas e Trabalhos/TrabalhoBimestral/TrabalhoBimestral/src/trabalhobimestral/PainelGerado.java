package trabalhobimestral;

public class PainelGerado extends javax.swing.JPanel {

    public PainelGerado() {
        initComponents();
    }
    
    public void EscondeOuMostraComponentes(boolean define) {
        LabelPreVisualizacaoDoCabecalho.setVisible(define);
        LabelTitulo.setVisible(define);
        PainelPrevisu.setVisible(define);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelTitulo = new javax.swing.JLabel();
        LabelPreVisualizacaoDoCabecalho = new javax.swing.JLabel();
        PainelAuxBorda = new javax.swing.JPanel();
        PainelPrevisu = new javax.swing.JPanel();
        BotaoInsereQuestoes = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        LabelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        LabelTitulo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(0, 102, 255));
        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("Gerado com sucesso!");
        add(LabelTitulo);
        LabelTitulo.setBounds(0, 29, 1024, 44);

        LabelPreVisualizacaoDoCabecalho.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LabelPreVisualizacaoDoCabecalho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelPreVisualizacaoDoCabecalho.setText("Pré visualização do cabeçalho:");
        add(LabelPreVisualizacaoDoCabecalho);
        LabelPreVisualizacaoDoCabecalho.setBounds(270, 90, 770, 22);

        PainelAuxBorda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 3));
        PainelAuxBorda.setLayout(null);

        PainelPrevisu.setBackground(new java.awt.Color(255, 255, 255));
        PainelPrevisu.setMinimumSize(new java.awt.Dimension(765, 370));

        javax.swing.GroupLayout PainelPrevisuLayout = new javax.swing.GroupLayout(PainelPrevisu);
        PainelPrevisu.setLayout(PainelPrevisuLayout);
        PainelPrevisuLayout.setHorizontalGroup(
            PainelPrevisuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
        );
        PainelPrevisuLayout.setVerticalGroup(
            PainelPrevisuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        PainelAuxBorda.add(PainelPrevisu);
        PainelPrevisu.setBounds(10, 10, 763, 370);
        PainelPrevisu.getAccessibleContext().setAccessibleName("");

        add(PainelAuxBorda);
        PainelAuxBorda.setBounds(240, 120, 780, 390);

        BotaoInsereQuestoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalhobimestral/botaoInsereQuestoes.png"))); // NOI18N
        BotaoInsereQuestoes.setBorderPainted(false);
        BotaoInsereQuestoes.setContentAreaFilled(false);
        BotaoInsereQuestoes.setFocusPainted(false);
        BotaoInsereQuestoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoInsereQuestoesActionPerformed(evt);
            }
        });
        add(BotaoInsereQuestoes);
        BotaoInsereQuestoes.setBounds(10, 140, 210, 43);
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoInsereQuestoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoInsereQuestoesActionPerformed
        
    }//GEN-LAST:event_BotaoInsereQuestoesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoInsereQuestoes;
    private javax.swing.JLabel LabelPreVisualizacaoDoCabecalho;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JPanel PainelAuxBorda;
    public javax.swing.JPanel PainelPrevisu;
    // End of variables declaration//GEN-END:variables
}
