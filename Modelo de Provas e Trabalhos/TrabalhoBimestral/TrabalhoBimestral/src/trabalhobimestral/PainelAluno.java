package trabalhobimestral;

import java.awt.Color;
import javax.swing.ImageIcon;

public class PainelAluno extends javax.swing.JPanel {
    private ImageIcon Foto = new ImageIcon();
    private int auxEscolhido = 0;
    private String matricula = "";
    private String nome = "";

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public int getAuxEscolhido() {
        return auxEscolhido;
    }

    public void setAuxEscolhido(int auxEscolhido) {
        this.auxEscolhido = auxEscolhido;
    }
    
    public PainelAluno() {
        initComponents();
        auxEscolhido = 0;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
        LabelMatricula.setText(matricula);
    }
    
    public void setNome(String nome) {
        this.nome = nome;
        LabelNome.setText(nome);
    }
    
    public void setTurma(String turma) {
        LabelTurma.setText(turma);
    }
    
    public void setFoto(ImageIcon img) {
        LabelFoto.setIcon(img);
        Foto = img;
    }
    
    public ImageIcon getFoto() {
        return Foto;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelFoto = new javax.swing.JLabel();
        LabelNome = new javax.swing.JLabel();
        LabelMatricula = new javax.swing.JLabel();
        LabelTurma = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(130, 195));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Selecionado(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eventoMouseEntrou(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                eventoMouseSaiu(evt);
            }
        });

        LabelFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Selecionado(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eventoMouseEntrou(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                eventoMouseSaiu(evt);
            }
        });

        LabelNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LabelMatricula.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelMatricula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        LabelTurma.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelTurma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTurma.setText("INF2A");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LabelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
            .addComponent(LabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LabelMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LabelTurma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelMatricula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(LabelTurma))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void eventoMouseEntrou(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventoMouseEntrou
        setBackground(Color.GRAY);
    }//GEN-LAST:event_eventoMouseEntrou

    private void eventoMouseSaiu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventoMouseSaiu
        setBackground(new java.awt.Color(240, 240, 240));
    }//GEN-LAST:event_eventoMouseSaiu

    private void Selecionado(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Selecionado
        auxEscolhido++;
    }//GEN-LAST:event_Selecionado


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel LabelFoto;
    private javax.swing.JLabel LabelMatricula;
    private javax.swing.JLabel LabelNome;
    private javax.swing.JLabel LabelTurma;
    // End of variables declaration//GEN-END:variables
}
