package trabalhobimestral;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class EscolheAluno extends JPanel {
    
    private File pastaCarometro = new File("C:/carometro"); 
    private int numDealunos = 0;
    PainelAluno aluno[];
    
    public static String reverse (String o) { 
        String temporaria = ""; 
        for (int i = o.length() - 1; i >= 0; i--) 
            temporaria += o.charAt(i); 
        return temporaria; 
    }

    public EscolheAluno() {
        initComponents();
        
        File[] fotos = pastaCarometro.listFiles();
        
        aluno = new PainelAluno[fotos.length];
        
        LabelEscolhaAFoto.setVisible(true);
        
        int EspacamentoX = 1;
        int EspacamentoY = 1;
        
        for(int i = 0; i < aluno.length; i++) {
            String nomeArq = "";
            
            aluno[i] = new PainelAluno();
            
            if(fotos[i].isFile()) {
                
                aluno[i].setFoto(new ImageIcon(fotos[i].getPath().replace("\\", "/")));
                aluno[i].setAuxEscolhido(0);
                
                if (fotos[i].getName().contains(".jpg")) {
                    nomeArq = fotos[i].getName().replaceAll(".jpg", "");
                }
                
                if (fotos[i].getName().contains(".JPG")) {
                    nomeArq = fotos[i].getName().replaceAll(".JPG", "");
                }
                
                char auxNomeArq[] = nomeArq.toCharArray();
                
                String matricula = "";
                for (int y = auxNomeArq.length - 1; y > auxNomeArq.length - 13 ; y--) {
                    matricula += auxNomeArq[y];
                }
                
                aluno[i].setMatricula(reverse(matricula));
                
                String nomeAluno = "";
                for (int j = 0; j < auxNomeArq.length - 13; j++) {
                    nomeAluno += auxNomeArq[j];
                }
                
                aluno[i].setNome(nomeAluno);

                if (EspacamentoY == 210) {
                    EspacamentoY = 1;
                    aluno[i].setBounds(EspacamentoX, EspacamentoY, 130, 200);
                    revalidate();
                    EspacamentoX += 140;
                } else {
                    EspacamentoY = 210;
                    aluno[i].setBounds(EspacamentoX, EspacamentoY, 130, 200);
                }

                aluno[i].addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    alunoSelecionado(evt);
                }
                });

                PainelAlunos.add(aluno[i]);
                aluno[i].setVisible(true);
                PainelAlunos.revalidate(); 
            }
        }
        
        EscondeOuMostraComponentes(true);
        
        if (numDealunos <= 14) {
            BotaoProximo.setVisible(false);
            BotaoAnterior.setVisible(false);
        }
        
        for (int i = 0; i < aluno.length; i++) {
            if(aluno[i].getX() > 930) {
                BotaoAnterior.setVisible(true);
            } else {
                BotaoAnterior.setVisible(false);
            }
        }
        
        BotaoProximo.setVisible(false);

        repaint();
    }
    
    public void alunoSelecionado(java.awt.event.MouseEvent evt) {
        EscondeOuMostraComponentes(false);
    }
    
    public void EscondeOuMostraComponentes(boolean define) {
        for(int i = 0; i < aluno.length; i++) {
            aluno[i].setVisible(define);
        }
        
        LabelEscolhaAFoto.setVisible(define);
        BotaoAnterior.setVisible(define);
        BotaoProximo.setVisible(define);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelEscolhaAFoto = new javax.swing.JLabel();
        PainelAlunos = new javax.swing.JPanel();
        BotaoAnterior = new javax.swing.JButton();
        BotaoProximo = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1024, 516));
        setMinimumSize(new java.awt.Dimension(1024, 516));

        LabelEscolhaAFoto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LabelEscolhaAFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelEscolhaAFoto.setText("Escolha o aluno para o qual se deseja gerar a prova");
        LabelEscolhaAFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        PainelAlunos.setBackground(new java.awt.Color(255, 255, 255));
        PainelAlunos.setLayout(null);

        BotaoAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalhobimestral/previous.PNG"))); // NOI18N
        BotaoAnterior.setBorderPainted(false);
        BotaoAnterior.setContentAreaFilled(false);
        BotaoAnterior.setFocusPainted(false);
        BotaoAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAnteriorActionPerformed(evt);
            }
        });

        BotaoProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalhobimestral/next.PNG"))); // NOI18N
        BotaoProximo.setBorderPainted(false);
        BotaoProximo.setContentAreaFilled(false);
        BotaoProximo.setFocusPainted(false);
        BotaoProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoProximoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LabelEscolhaAFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PainelAlunos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotaoAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotaoProximo)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(LabelEscolhaAFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PainelAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BotaoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAnteriorActionPerformed
        for(int i = 0; i < aluno.length; i++) {
            aluno[i].setBounds(aluno[i].getX()-140, aluno[i].getY(), 130, 200);
        }
        
        for (int i = 0; i < aluno.length; i++) {
            if(aluno[i].getX() > 930) {
                BotaoAnterior.setVisible(true);
            } else {
                BotaoAnterior.setVisible(false);
            }
        }
        
        BotaoProximo.setVisible(true);
        
        PainelAlunos.revalidate();
        PainelAlunos.repaint();
    }//GEN-LAST:event_BotaoAnteriorActionPerformed

    private void BotaoProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoProximoActionPerformed
        for(int i = 0; i < aluno.length; i++) {
            aluno[i].setBounds(aluno[i].getX()+140, aluno[i].getY(), 130, 200);
        }
        
        for (int i = aluno.length-1; i >= 0; i--) {
            if(aluno[i].getX() < 0) {
                BotaoProximo.setVisible(true);
            } else {
                BotaoProximo.setVisible(false);
            }
        }
        
        BotaoAnterior.setVisible(true);
        
        PainelAlunos.revalidate();
        PainelAlunos.repaint();
    }//GEN-LAST:event_BotaoProximoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAnterior;
    private javax.swing.JButton BotaoProximo;
    private javax.swing.JLabel LabelEscolhaAFoto;
    private javax.swing.JPanel PainelAlunos;
    // End of variables declaration//GEN-END:variables
}
