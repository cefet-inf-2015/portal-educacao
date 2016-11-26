package trabalhobimestral;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;

public class PreVisualizaCabecalho extends JPanel{
    
    private String Tipo;
    
    private JLabel LabelBrasao;
    private JLabel LabelCabecalho;
    private JLabel LabelCarometro;
    private JLabel LabelDataEntrega;
    private JLabel LabelDataProva;
    private JLabel LabelDataRecebimento;
    private JLabel LabelLogo;
    private JLabel LabelMatricula;
    private JLabel LabelNomeAluno;
    private JLabel LabelNomeInstituicao;
    private JLabel LabelNomeProfessor;
    private JLabel LabelNomeProvaOuTrabalho;
    private JLabel LabelTurma;
    private JLabel LabelValor;
    private JLabel LabelDuracao;
    private JLabel LabelTurno;
    private JLabel LabelNumeroDeQuestoes;
    
    private JPanel PainelBrancoInferior;
    
    public void setDuracao(String duracao) {
        LabelDuracao = new JLabel();
        LabelDuracao.setFont(new Font("Arial", 0, 16));
        
        if (Tipo.equals("Prova")) {
            add(LabelDuracao);
            LabelDuracao.setBounds(106, 287, 450, 26);
            LabelDuracao.setText(duracao);
        } else {
            add(LabelDuracao);
            LabelDuracao.setBounds(105, 279, 450, 26);
            LabelDuracao.setText(duracao);
        }
    }
    
    public void setTurno(String turno) {
        LabelTurno = new JLabel();
        LabelTurno.setFont(new Font("Arial", 0, 16));
        
        if (Tipo.equals("Prova")) {
            add(LabelTurno);
            LabelTurno.setBounds(90, 317, 450, 26);
            LabelTurno.setText(turno);
        } else {
            add(LabelTurno);
            LabelTurno.setBounds(90, 333, 240, 20);
            LabelTurno.setText(turno);
        }
    }
    
    public void setNumeroDeQuestoes(String numeroDeQuestoes) {
        LabelNumeroDeQuestoes = new JLabel();
        LabelNumeroDeQuestoes.setFont(new Font("Arial", 0, 16));
        
        if (Tipo.equals("Prova")) {
            add(LabelNumeroDeQuestoes);
            LabelNumeroDeQuestoes.setBounds(694, 317, 450, 26);
            LabelNumeroDeQuestoes.setText(numeroDeQuestoes);
        } else {
            add(LabelNumeroDeQuestoes);
            LabelNumeroDeQuestoes.setBounds(658, 282, 90, 20);
            LabelNumeroDeQuestoes.setText(numeroDeQuestoes);
        }
    }
    
    public void setDataRecebimento(String dataRecebimento){
        LabelDataRecebimento = new JLabel();
        
        LabelDataRecebimento.setFont(new Font("Tahoma", 0, 16));
        add(LabelDataRecebimento);
        LabelDataRecebimento.setBounds(675, 310, 90, 20);
        LabelDataRecebimento.setText(dataRecebimento);
    }
    
    public void setDataEntrega(String dataEntrega) {
        LabelDataEntrega = new JLabel();
        
        LabelDataEntrega.setFont(new Font("Arial", 0, 16));
        add(LabelDataEntrega);
        LabelDataEntrega.setBounds(635, 224, 90, 20);
        LabelDataEntrega.setText(dataEntrega);
    }
    
    public void setTipo(String tipo) {
        if(tipo.equals("Prova")) {
            LabelCabecalho.setIcon(new ImageIcon("prova.png"));
            Tipo = "Prova";
        } else {
            LabelCabecalho.setIcon(new ImageIcon("trabalho.jpg"));
            Tipo = "Trabalho";
        }
    }
    
    public PreVisualizaCabecalho() {
        iniciaComponentesDeafault();
    }
    
    public void desenha() {
        add(LabelCabecalho);
        add(PainelBrancoInferior);
        
        setVisible(true);
        
        setSize(787, 1092);
    }
    
    public void setCarometro(ImageIcon carometro) {
        LabelCarometro = new JLabel();
        
        add(LabelCarometro);
        LabelCarometro.setBounds(20, 10, 100, 90);
        LabelCarometro.setIcon(carometro);
    }
    
    public void setLogo(ImageIcon logo) {
        LabelLogo.setIcon(logo);
    }
    
    public void setBrasao(ImageIcon brasao) {
        LabelBrasao = new JLabel();
        
        add(LabelBrasao);
        LabelBrasao.setBounds(670, 15, 100, 100);
        LabelBrasao.setIcon(brasao);
    }
    
    public void setNomeProvaOuTrabalho(String nomeTeste){
        LabelNomeProvaOuTrabalho.setText(nomeTeste);
    }
    
    public void setNomeProfessor(String nomeProf) {
        LabelNomeProfessor = new JLabel();
        LabelNomeProfessor.setFont(new Font("Arial", 0, 16));
        
        if (Tipo.equals("Prova")) {
            add(LabelNomeProfessor);
            LabelNomeProfessor.setBounds(140, 258, 450, 26);
            LabelNomeProfessor.setText(nomeProf);
        } else {
            add(LabelNomeProfessor);
            LabelNomeProfessor.setBounds(139, 252, 240, 20);
            LabelNomeProfessor.setText(nomeProf);
        }
    }
    
    public void setNomeAluno(String nomeAluno) {
        LabelNomeAluno = new JLabel();
        LabelNomeAluno.setFont(new Font("Arial", 0, 16));
        
        if (Tipo.equals("Prova")) {
            add(LabelNomeAluno);
            LabelNomeAluno.setBounds(110, 228, 420, 26);
            LabelNomeAluno.setText(nomeAluno);
        } else { 
            add(LabelNomeAluno);
            LabelNomeAluno.setBounds(110, 223, 210, 20);
            LabelNomeAluno.setText(nomeAluno);
        }
    }
    
    public void setMatricula(String matricula) {
        LabelMatricula = new JLabel();
        
        LabelMatricula.setFont(new Font("Arial", 0, 14));
        LabelMatricula.setHorizontalAlignment(SwingConstants.CENTER);
        add(LabelMatricula);
        LabelMatricula.setBounds(0, 100, 140, 14);
        LabelMatricula.setText(matricula);
    }
    
    public void setNomeInstituicao(String nomeInstituicao) {
        LabelNomeInstituicao.setText(nomeInstituicao);
    }
    
    public void setTurma(String turma) {
        LabelTurma = new JLabel();
        LabelTurma.setFont(new Font("Arial", 0, 16));
        
        if (Tipo.equals("Prova")) {
            add(LabelTurma);
            LabelTurma.setBounds(630, 231, 1000, 20);
            LabelTurma.setText(turma);
        } else {
            add(LabelTurma);
            LabelTurma.setBounds(90, 307, 1000, 20);
            LabelTurma.setText(turma);
        }
    }
    
    public void setDataProva(String data) {
        LabelDataProva = new JLabel();
        
        LabelDataProva.setFont(new Font("Arial", 0, 16));
        add(LabelDataProva);
        LabelDataProva.setBounds(614, 260, 150, 26);
        LabelDataProva.setText(data);
    }
    
    public void setValor(String valor) {
        LabelValor = new JLabel();
        LabelValor.setFont(new Font("Arial", 0, 16));
        
        if (Tipo.equals("Prova")) {
            add(LabelValor);
            LabelValor.setBounds(619, 287, 150, 26);
            LabelValor.setText(valor);
        } else {
            add(LabelValor);
            LabelValor.setBounds(582, 253, 50, 20);
            LabelValor.setText(valor);
        }
    }
    
    private void iniciaComponentesDeafault() {
        LabelCabecalho = new JLabel();
        LabelLogo = new JLabel();
        LabelNomeInstituicao = new JLabel();
        LabelNomeProvaOuTrabalho = new JLabel();
        PainelBrancoInferior = new JPanel();
        
        setLayout(null);
               
        LabelCabecalho.setBounds(0, 0, 770, 365);
        
        add(LabelLogo);
        LabelLogo.setBounds(344, 24, 140, 90);

        LabelNomeInstituicao.setFont(new Font("Arial", 0, 16)); 
        LabelNomeInstituicao.setHorizontalAlignment(SwingConstants.CENTER);
        add(LabelNomeInstituicao);
        LabelNomeInstituicao.setBounds(4, 150, 760, 20);
        
        LabelNomeProvaOuTrabalho.setFont(new Font("Arial", 0, 16));
        LabelNomeProvaOuTrabalho.setHorizontalAlignment(SwingConstants.CENTER);
        add(LabelNomeProvaOuTrabalho);
        LabelNomeProvaOuTrabalho.setBounds(4, 170, 760, 20);
        
        PainelBrancoInferior.setBackground(new Color(255, 255, 255));
        PainelBrancoInferior.setBounds(-10, 240, 820, 870);
    }     
}