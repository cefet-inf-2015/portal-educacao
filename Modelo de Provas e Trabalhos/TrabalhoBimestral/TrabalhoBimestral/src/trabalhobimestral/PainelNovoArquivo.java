package trabalhobimestral;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class PainelNovoArquivo extends javax.swing.JPanel {

    EscolheAluno SelectAluno = new EscolheAluno();
    PainelGerado painelGerado = new PainelGerado();
    private int contadorLogo = 0;
    private int contadorBrasao = 0;
    private File file;
    private File file2;
    String tipo;
    PreVisualizaCabecalho preVisuCabecalho = new PreVisualizaCabecalho();

    public PainelNovoArquivo() {

        initComponents();
        DefineElaborador.setText("José Wilson da Costa");
        BotaoEnviaBrasao.setVisible(false);
        BotaoEnviaLogo.setVisible(false);
        LabelDataDaProva.setVisible(false);
        LabelDataDeRecebimento.setVisible(false);
        LabelDataDeEntrega.setVisible(false);
        jDateChooser1.setVisible(false);
        jDateChooser2.setVisible(false);
        jDateChooser3.setVisible(false);

        LabelMatricula.setVisible(false);
        DefineMatricula.setVisible(false);
        BotaoEnviaCarometro.setVisible(false);

        RadioPublica.setSelected(true);
        BotaoEnviaLogo.setVisible(true);
        BotaoEnviaBrasao.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        LabelQuantidadeDeAlunos = new javax.swing.JLabel();
        RadioIndividual = new javax.swing.JRadioButton();
        RadioTurma = new javax.swing.JRadioButton();
        RadioGrupo = new javax.swing.JRadioButton();
        LabelTipoDeTeste = new javax.swing.JLabel();
        RadioProva = new javax.swing.JRadioButton();
        RadioTrabalho = new javax.swing.JRadioButton();
        Labelvalor = new javax.swing.JLabel();
        DefineValorProva = new javax.swing.JSpinner();
        LabelTitulo = new javax.swing.JLabel();
        DefineTitulo = new javax.swing.JTextField();
        LabelFormularioDeInformacoes = new javax.swing.JLabel();
        LabelNumDeQuestoes = new javax.swing.JLabel();
        DefineNumDeQuestoes = new javax.swing.JSpinner();
        LabelTurno = new javax.swing.JLabel();
        DefineTurno = new javax.swing.JComboBox<>();
        LabelTurmas = new javax.swing.JLabel();
        DefineTurmas = new javax.swing.JTextField();
        LabelElaborador = new javax.swing.JLabel();
        DefineInstituicao = new javax.swing.JTextField();
        LabelInstituicao = new javax.swing.JLabel();
        DefineElaborador = new javax.swing.JTextField();
        LabelTipoDeInstituicao = new javax.swing.JLabel();
        RadioPublica = new javax.swing.JRadioButton();
        RadioPrivada = new javax.swing.JRadioButton();
        BotaoEnvia = new javax.swing.JButton();
        PainelDatas = new javax.swing.JPanel();
        LabelDataDaProva = new javax.swing.JLabel();
        LabelDataDeRecebimento = new javax.swing.JLabel();
        LabelDataDeEntrega = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        LabelMatricula = new javax.swing.JLabel();
        DefineMatricula = new javax.swing.JTextField();
        BotaoEnviaCarometro = new javax.swing.JButton();
        BotaoEnviaLogo = new javax.swing.JButton();
        BotaoEnviaBrasao = new javax.swing.JButton();
        LabelMostraLogo = new javax.swing.JLabel();
        LabelMostraBrasao = new javax.swing.JLabel();
        LabelMostraCarometro = new javax.swing.JLabel();
        DefineDuracao = new javax.swing.JSpinner();
        LabelDuracao = new javax.swing.JLabel();
        LabelMinutos = new javax.swing.JLabel();
        LabelPontos = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1024, 516));
        setMinimumSize(new java.awt.Dimension(1024, 516));
        setPreferredSize(new java.awt.Dimension(1024, 516));
        setLayout(null);

        LabelQuantidadeDeAlunos.setForeground(new java.awt.Color(102, 102, 102));
        LabelQuantidadeDeAlunos.setText("Quantidade de alunos:");
        add(LabelQuantidadeDeAlunos);
        LabelQuantidadeDeAlunos.setBounds(10, 67, 109, 14);

        RadioIndividual.setBackground(new java.awt.Color(255, 255, 255));
        RadioIndividual.setText("Individual");
        RadioIndividual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioIndividualActionPerformed(evt);
            }
        });
        add(RadioIndividual);
        RadioIndividual.setBounds(10, 83, 71, 23);

        RadioTurma.setBackground(new java.awt.Color(255, 255, 255));
        RadioTurma.setText("Turma");
        RadioTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioTurmaActionPerformed(evt);
            }
        });
        add(RadioTurma);
        RadioTurma.setBounds(83, 83, 55, 23);

        RadioGrupo.setBackground(new java.awt.Color(255, 255, 255));
        RadioGrupo.setText("Grupo");
        RadioGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioGrupoActionPerformed(evt);
            }
        });
        add(RadioGrupo);
        RadioGrupo.setBounds(140, 83, 55, 23);

        LabelTipoDeTeste.setForeground(new java.awt.Color(102, 102, 102));
        LabelTipoDeTeste.setText("Tipo:");
        add(LabelTipoDeTeste);
        LabelTipoDeTeste.setBounds(10, 113, 24, 14);

        RadioProva.setBackground(new java.awt.Color(255, 255, 255));
        RadioProva.setText("Prova");
        RadioProva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioProvaActionPerformed(evt);
            }
        });
        add(RadioProva);
        RadioProva.setBounds(10, 133, 53, 23);

        RadioTrabalho.setBackground(new java.awt.Color(255, 255, 255));
        RadioTrabalho.setText("Trabalho");
        RadioTrabalho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioTrabalhoActionPerformed(evt);
            }
        });
        add(RadioTrabalho);
        RadioTrabalho.setBounds(65, 133, 67, 23);

        Labelvalor.setForeground(new java.awt.Color(102, 102, 102));
        Labelvalor.setText("Valor:");
        add(Labelvalor);
        Labelvalor.setBounds(10, 182, 28, 14);
        add(DefineValorProva);
        DefineValorProva.setBounds(10, 208, 42, 28);

        LabelTitulo.setForeground(new java.awt.Color(102, 102, 102));
        LabelTitulo.setText("Título:");
        add(LabelTitulo);
        LabelTitulo.setBounds(10, 246, 30, 14);

        DefineTitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add(DefineTitulo);
        DefineTitulo.setBounds(10, 266, 403, 38);

        LabelFormularioDeInformacoes.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LabelFormularioDeInformacoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelFormularioDeInformacoes.setText("Formulário de informações");
        add(LabelFormularioDeInformacoes);
        LabelFormularioDeInformacoes.setBounds(0, 20, 856, 29);

        LabelNumDeQuestoes.setForeground(new java.awt.Color(102, 102, 102));
        LabelNumDeQuestoes.setText("Nº de questões:");
        add(LabelNumDeQuestoes);
        LabelNumDeQuestoes.setBounds(10, 320, 78, 14);
        add(DefineNumDeQuestoes);
        DefineNumDeQuestoes.setBounds(10, 340, 42, 28);

        LabelTurno.setForeground(new java.awt.Color(102, 102, 102));
        LabelTurno.setText("Turno:");
        add(LabelTurno);
        LabelTurno.setBounds(10, 381, 32, 14);

        DefineTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manhã", "Tarde", "Noite" }));
        add(DefineTurno);
        DefineTurno.setBounds(10, 401, 57, 20);

        LabelTurmas.setForeground(new java.awt.Color(102, 102, 102));
        LabelTurmas.setText("Turmas:");
        add(LabelTurmas);
        LabelTurmas.setBounds(10, 433, 39, 14);

        DefineTurmas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add(DefineTurmas);
        DefineTurmas.setBounds(10, 454, 403, 38);

        LabelElaborador.setForeground(new java.awt.Color(102, 102, 102));
        LabelElaborador.setText("Elaborador:");
        add(LabelElaborador);
        LabelElaborador.setBounds(430, 70, 56, 14);

        DefineInstituicao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add(DefineInstituicao);
        DefineInstituicao.setBounds(430, 160, 403, 38);

        LabelInstituicao.setForeground(new java.awt.Color(102, 102, 102));
        LabelInstituicao.setText("Nome da instituição:");
        add(LabelInstituicao);
        LabelInstituicao.setBounds(430, 140, 97, 14);

        DefineElaborador.setEditable(false);
        DefineElaborador.setBackground(new java.awt.Color(255, 255, 255));
        DefineElaborador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add(DefineElaborador);
        DefineElaborador.setBounds(430, 90, 403, 38);

        LabelTipoDeInstituicao.setForeground(new java.awt.Color(102, 102, 102));
        LabelTipoDeInstituicao.setText("Tipo de instituição:");
        add(LabelTipoDeInstituicao);
        LabelTipoDeInstituicao.setBounds(430, 210, 90, 14);

        RadioPublica.setBackground(new java.awt.Color(255, 255, 255));
        RadioPublica.setText("Pública");
        RadioPublica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioPublicaActionPerformed(evt);
            }
        });
        add(RadioPublica);
        RadioPublica.setBounds(430, 230, 59, 23);

        RadioPrivada.setBackground(new java.awt.Color(255, 255, 255));
        RadioPrivada.setText("Privada");
        RadioPrivada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioPrivadaActionPerformed(evt);
            }
        });
        add(RadioPrivada);
        RadioPrivada.setBounds(490, 230, 61, 23);

        BotaoEnvia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalhobimestral/Envia.PNG"))); // NOI18N
        BotaoEnvia.setBorderPainted(false);
        BotaoEnvia.setContentAreaFilled(false);
        BotaoEnvia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEnviaActionPerformed(evt);
            }
        });
        add(BotaoEnvia);
        BotaoEnvia.setBounds(690, 470, 150, 40);

        PainelDatas.setBackground(new java.awt.Color(255, 255, 255));
        PainelDatas.setLayout(null);

        LabelDataDaProva.setForeground(new java.awt.Color(102, 102, 102));
        LabelDataDaProva.setText("Data da prova:");
        PainelDatas.add(LabelDataDaProva);
        LabelDataDaProva.setBounds(40, 10, 80, 20);

        LabelDataDeRecebimento.setForeground(new java.awt.Color(102, 102, 102));
        LabelDataDeRecebimento.setText("Data de recebimento do trabalho:");
        PainelDatas.add(LabelDataDeRecebimento);
        LabelDataDeRecebimento.setBounds(10, 10, 170, 14);

        LabelDataDeEntrega.setForeground(new java.awt.Color(102, 102, 102));
        LabelDataDeEntrega.setText("Data de entrega do trabalho:");
        PainelDatas.add(LabelDataDeEntrega);
        LabelDataDeEntrega.setBounds(10, 70, 170, 14);
        PainelDatas.add(jDateChooser1);
        jDateChooser1.setBounds(40, 30, 87, 20);
        PainelDatas.add(jDateChooser2);
        jDateChooser2.setBounds(40, 30, 87, 20);
        PainelDatas.add(jDateChooser3);
        jDateChooser3.setBounds(40, 90, 87, 20);

        add(PainelDatas);
        PainelDatas.setBounds(138, 113, 275, 127);

        LabelMatricula.setForeground(new java.awt.Color(102, 102, 102));
        LabelMatricula.setText("Matrícula:");
        add(LabelMatricula);
        LabelMatricula.setBounds(440, 400, 60, 20);

        DefineMatricula.setEditable(false);
        DefineMatricula.setBackground(new java.awt.Color(255, 255, 255));
        DefineMatricula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add(DefineMatricula);
        DefineMatricula.setBounds(440, 420, 403, 38);

        BotaoEnviaCarometro.setText("Envia Foto do aluno");
        BotaoEnviaCarometro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEnviaCarometroActionPerformed(evt);
            }
        });
        add(BotaoEnviaCarometro);
        BotaoEnviaCarometro.setBounds(720, 270, 140, 23);

        BotaoEnviaLogo.setText("Envia logo");
        BotaoEnviaLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEnviaLogoActionPerformed(evt);
            }
        });
        add(BotaoEnviaLogo);
        BotaoEnviaLogo.setBounds(430, 270, 115, 23);

        BotaoEnviaBrasao.setText("Envia Brasão");
        BotaoEnviaBrasao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEnviaBrasaoActionPerformed(evt);
            }
        });
        add(BotaoEnviaBrasao);
        BotaoEnviaBrasao.setBounds(570, 270, 115, 23);
        add(LabelMostraLogo);
        LabelMostraLogo.setBounds(440, 300, 100, 90);
        add(LabelMostraBrasao);
        LabelMostraBrasao.setBounds(580, 300, 100, 90);
        add(LabelMostraCarometro);
        LabelMostraCarometro.setBounds(740, 300, 100, 90);
        add(DefineDuracao);
        DefineDuracao.setBounds(140, 340, 42, 28);

        LabelDuracao.setForeground(new java.awt.Color(102, 102, 102));
        LabelDuracao.setText("Duração:");
        add(LabelDuracao);
        LabelDuracao.setBounds(140, 320, 50, 10);

        LabelMinutos.setForeground(new java.awt.Color(102, 102, 102));
        LabelMinutos.setText("minutos");
        add(LabelMinutos);
        LabelMinutos.setBounds(190, 350, 78, 14);

        LabelPontos.setForeground(new java.awt.Color(102, 102, 102));
        LabelPontos.setText("pontos");
        add(LabelPontos);
        LabelPontos.setBounds(60, 220, 33, 14);
    }// </editor-fold>//GEN-END:initComponents

    private void RadioIndividualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioIndividualActionPerformed
        RadioTurma.setSelected(false);
        RadioGrupo.setSelected(false);

        LabelMatricula.setVisible(true);
        DefineMatricula.setVisible(true);
        BotaoEnviaCarometro.setVisible(true);
        LabelMostraCarometro.setVisible(true);
    }//GEN-LAST:event_RadioIndividualActionPerformed

    private void BotaoEnviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEnviaActionPerformed
        Documento d = new Documento();
        String[] dados = null;
        if (tipo.equals("Prova")) {
            dados = new String[16];
            dados[1] = DefineElaborador.getText();
            dados[2] = DefineTurmas.getText();
            dados[3] = (String) DefineTurno.getSelectedItem();
            dados[4] = DefineInstituicao.getText();
            SimpleDateFormat dataSimples2 = new SimpleDateFormat("dd/MM/yyyy");
            String data2 = dataSimples2.format(jDateChooser1.getDate());
            dados[5] = data2;
            dados[6] = String.format("%s", (int) DefineValorProva.getValue());
            dados[7] = String.format("%s", (int) DefineNumDeQuestoes.getValue());
            dados[8] = String.format("%s", (int) DefineDuracao.getValue());
            dados[10] = file.getName();
            dados[11] = file2.getName();
            dados[12] = DefineTitulo.getText();
            if (RadioProva.isSelected()) {
                dados[13] = "Prova";
            } else {
                if (RadioTrabalho.isSelected()) {
                    dados[13] = "Trabalho";
                }
            }
            if (RadioIndividual.isSelected()) {
                dados[14] = "Individual";
            } else {
                if (RadioTurma.isSelected()) {
                    dados[14] = "Turma";
                }
            }
            if (RadioPublica.isSelected()) {
                dados[15] = "Publica";
            } else {
                if (RadioPrivada.isSelected()) {
                    dados[15] = "Privada";
                }
            }
        } else {
            if (tipo.equals("Trabalho")) {
                dados = new String[17];
                dados[1] = DefineElaborador.getText();
                dados[2] = DefineTurmas.getText();
                dados[3] = (String) DefineTurno.getSelectedItem();
                dados[4] = DefineInstituicao.getText();
                SimpleDateFormat dataSimples2 = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat dataSimples3 = new SimpleDateFormat("dd/MM/yyyy");
                String data2 = dataSimples2.format(jDateChooser2.getDate());
                String data3 = dataSimples3.format(jDateChooser3.getDate());
                dados[5] = data2;
                dados[6] = data3;
                dados[7] = String.format("%s", (int) DefineValorProva.getValue());
                dados[8] = String.format("%s", (int) DefineNumDeQuestoes.getValue());//System.out.println(dados[8]);
                dados[10] = String.format("%s", (int) DefineDuracao.getValue());
                dados[11] = file.getName();
                dados[12] = file2.getName();
                dados[13] = DefineTitulo.getText();
                if (RadioProva.isSelected()) {
                    dados[14] = "Prova";
                } else {
                    if (RadioTrabalho.isSelected()) {
                        dados[14] = "Trabalho";
                    }
                }
                if (RadioIndividual.isSelected()) {
                    dados[15] = "Individual";
                } else {
                    if (RadioTurma.isSelected()) {
                        dados[15] = "Turma";
                    }
                }
                if (RadioPublica.isSelected()) {
                    dados[16] = "Publica";
                } else {
                    if (RadioPrivada.isSelected()) {
                        dados[16] = "Privada";
                    }
                }
            }
        }
        String nome = "";
        if (RadioIndividual.isSelected() == true) {
            preVisuCabecalho.setMatricula(DefineMatricula.getText());

            for (int i = 0; i < SelectAluno.aluno.length; i++) {
                if (SelectAluno.aluno[i].getAuxEscolhido() > 0) {
                    preVisuCabecalho.setCarometro(SelectAluno.aluno[i].getFoto());
                    preVisuCabecalho.setNomeAluno(SelectAluno.aluno[i].getNome().replace("_", " "));
                    dados[0] = SelectAluno.aluno[i].getNome().replace("_", " ");
                    nome = SelectAluno.aluno[i].getNome() + " " + DefineMatricula.getText();
                }
            }
            dados[9] = nome;
        } else {
            preVisuCabecalho.setCarometro(new ImageIcon("avatar.jpg"));
            preVisuCabecalho.setMatricula("201511130202");
            preVisuCabecalho.setNomeAluno("\"Nome do aluno\"");
        }

        if (tipo.equals("Prova")) {
            SimpleDateFormat dataSimples = new SimpleDateFormat("dd/MM/yyyy");
            String data = dataSimples.format(jDateChooser1.getDate());
            preVisuCabecalho.setDataProva(data);
        } else {
            SimpleDateFormat dataSimples = new SimpleDateFormat("dd/MM/yyyy");
            String data = dataSimples.format(jDateChooser2.getDate());
            preVisuCabecalho.setDataRecebimento(data);

            data = dataSimples.format(jDateChooser3.getDate());
            preVisuCabecalho.setDataEntrega(data);
        }

        preVisuCabecalho.setNomeProvaOuTrabalho(DefineTitulo.getText());
        preVisuCabecalho.setValor(DefineValorProva.getValue().toString());
        preVisuCabecalho.setTurma(DefineTurmas.getText());
        preVisuCabecalho.setNomeProfessor(DefineElaborador.getText());
        preVisuCabecalho.setTurno(DefineTurno.getSelectedItem().toString());
        preVisuCabecalho.setNomeInstituicao(DefineInstituicao.getText());
        preVisuCabecalho.setNumeroDeQuestoes(DefineNumDeQuestoes.getValue().toString());
        preVisuCabecalho.setNomeProfessor("José Wilson");
        preVisuCabecalho.setDuracao(DefineDuracao.getValue().toString());
        contadorBrasao--;
        preVisuCabecalho.setBrasao(new ImageIcon("Brasao" + contadorBrasao + ".jpg"));
        contadorLogo--;
        preVisuCabecalho.setLogo(new ImageIcon("Logo" + contadorLogo + ".jpg"));
        if (tipo.equals("Prova") && RadioIndividual.isSelected()) {
            String colunas2 = "titulo,tipo,modalidade,escola,dataProva,nomeLogotipo,nomeBrasao"
                    + ",nomeAluno,nomeProfessor,numeroQuestoes,valor,turma,turno,nomeEscola,duracao,matricula";
            try {
                d.insereDadosMySQL_Servidor(colunas2, true, dados);
            } catch (IOException | SQLException ex) {
                Logger.getLogger(PainelNovoArquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
            d.gerarProva(DefineTitulo.getText());
        } else {
            if(tipo.equals("Prova") && RadioTurma.isSelected()){
                String colunas2 = "titulo,tipo,modalidade,escola,dataProva,nomeLogotipo,nomeBrasao"
                    + ",nomeAluno,nomeProfessor,numeroQuestoes,valor,turma,turno,nomeEscola,duracao,matricula";
                try {
                  d.insereDadosMySQL_Servidor(colunas2, true, dados);
                    d.gerarCabecalhoProvaTurma(DefineTitulo.getText());
                } catch (IOException | InvalidFormatException | SQLException ex) {
                    Logger.getLogger(PainelNovoArquivo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (tipo.equals("Trabalho")) {
                String colunas2 = "titulo,tipo,modalidade,escola,dataRecebimento,dataEntrega,nomeLogotipo,nomeBrasao"
                        + ",nomeAluno,nomeProfessor,numeroQuestoes,valor,turma,turno,nomeEscola,duracao,matricula";
                try {
                    d.insereDadosMySQL_Servidor(colunas2, false, dados);
                } catch (IOException | SQLException ex) {
                    Logger.getLogger(PainelNovoArquivo.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    d.gerarTrabalho(DefineTitulo.getText());
                } catch (SQLException ex) {
                    Logger.getLogger(PainelNovoArquivo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        preVisuCabecalho.desenha();
        EscondeOuMostraComponentes(false);
        painelGerado.setBounds(getBounds());
        preVisuCabecalho.setBounds(0, 0, painelGerado.PainelPrevisu.getWidth(), painelGerado.PainelPrevisu.getHeight());
        painelGerado.PainelPrevisu.add(preVisuCabecalho);
        painelGerado.PainelPrevisu.repaint();
        painelGerado.PainelPrevisu.revalidate();
        painelGerado.revalidate();
        painelGerado.repaint();
        add(painelGerado);
        revalidate();
        repaint();
    }//GEN-LAST:event_BotaoEnviaActionPerformed

    private void RadioPublicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioPublicaActionPerformed
        BotaoEnviaBrasao.setVisible(true);
        BotaoEnviaLogo.setVisible(true);
        RadioPrivada.setSelected(false);
    }//GEN-LAST:event_RadioPublicaActionPerformed

    private void RadioPrivadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioPrivadaActionPerformed
        BotaoEnviaLogo.setVisible(true);
        BotaoEnviaBrasao.setVisible(false);
        RadioPublica.setSelected(false);
    }//GEN-LAST:event_RadioPrivadaActionPerformed

    private void RadioProvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioProvaActionPerformed
        LabelDataDeRecebimento.setVisible(false);
        LabelDataDeEntrega.setVisible(false);
        jDateChooser2.setVisible(false);
        jDateChooser3.setVisible(false);
        RadioTrabalho.setSelected(false);
        LabelDataDaProva.setVisible(true);
        jDateChooser1.setVisible(true);

        tipo = "Prova";
        preVisuCabecalho.setTipo(tipo);
    }//GEN-LAST:event_RadioProvaActionPerformed

    private void RadioTrabalhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioTrabalhoActionPerformed
        LabelDataDeRecebimento.setVisible(true);
        LabelDataDeEntrega.setVisible(true);
        jDateChooser2.setVisible(true);
        jDateChooser3.setVisible(true);
        RadioProva.setSelected(false);
        LabelDataDaProva.setVisible(false);
        jDateChooser1.setVisible(false);

        tipo = "Trabalho";
        preVisuCabecalho.setTipo(tipo);
    }//GEN-LAST:event_RadioTrabalhoActionPerformed

    private void RadioTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioTurmaActionPerformed
        RadioIndividual.setSelected(false);
        RadioGrupo.setSelected(false);

        LabelMatricula.setVisible(false);
        DefineMatricula.setVisible(false);
        BotaoEnviaCarometro.setVisible(false);
        LabelMostraCarometro.setVisible(false);
    }//GEN-LAST:event_RadioTurmaActionPerformed

    private void RadioGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioGrupoActionPerformed
        RadioIndividual.setSelected(false);
        RadioTurma.setSelected(false);

        LabelMatricula.setVisible(false);
        DefineMatricula.setVisible(false);
        BotaoEnviaCarometro.setVisible(false);
        LabelMostraCarometro.setVisible(false);
    }//GEN-LAST:event_RadioGrupoActionPerformed

    private void BotaoEnviaCarometroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEnviaCarometroActionPerformed

        EscondeOuMostraComponentes(false);

        SelectAluno.setBounds(getBounds());
        add(SelectAluno);
        revalidate();
        SelectAluno.EscondeOuMostraComponentes(true);
        revalidate();
        repaint();

        for (int i = 0; i < SelectAluno.aluno.length; i++) {
            SelectAluno.aluno[i].addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    alunoSelecionado(evt);
                }
            });

            SelectAluno.aluno[i].LabelFoto.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    alunoSelecionado(evt);
                }
            });

            SelectAluno.aluno[i].setAuxEscolhido(0);

            SelectAluno.aluno[i].setBackground(new java.awt.Color(240, 240, 240));
        }
    }//GEN-LAST:event_BotaoEnviaCarometroActionPerformed

    private void BotaoEnviaLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEnviaLogoActionPerformed
        String caminho = null;
        String auxCaminho = null;
        LabelMostraLogo.setIcon(null);

        try {
            JFileChooser jFileChooser = new JFileChooser();
            int ok = jFileChooser.showOpenDialog(null);
            if (ok == JFileChooser.APPROVE_OPTION) {
                file = jFileChooser.getSelectedFile();
                auxCaminho = jFileChooser.getCurrentDirectory().getPath() + '/' + jFileChooser.getSelectedFile().getName(); // caminho do arquivo
                caminho = auxCaminho.replace('\\', '/');
                System.out.println(file.toPath());
                Files.copy(file.toPath(), new File("C:/logotipo_brasao/"+file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
            } else {
                jFileChooser.cancelSelection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        BufferedImage imagem = null;
        try {
            imagem = ImageIO.read(new File(caminho));
        } catch (IOException ex) {
            //Logger.getLogger(ImagePanel2.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedImage new_img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = new_img.createGraphics();
        g2.drawImage(imagem, 0, 0, 100, 100, null);
        try {
            ImageIO.write(new_img, "JPG", new File("Logo" + contadorLogo + ".jpg"));

        } catch (IOException ex) {
            Logger.getLogger(PainelNovoArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

        LabelMostraLogo.setIcon(new ImageIcon("Logo" + contadorLogo + ".jpg"));

        if (contadorLogo > 0) {
            contadorLogo--;
        }

        new File("Logo" + contadorLogo + ".jpg").delete();
        contadorLogo++;
    }//GEN-LAST:event_BotaoEnviaLogoActionPerformed

    private void BotaoEnviaBrasaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEnviaBrasaoActionPerformed
        String caminho = null;
        String auxCaminho = null;
        LabelMostraBrasao.setIcon(null);

        try {
            JFileChooser jFileChooser = new JFileChooser();
            int ok = jFileChooser.showOpenDialog(null);
            if (ok == JFileChooser.APPROVE_OPTION) {
                file2 = jFileChooser.getSelectedFile();
                 Files.copy(file2.toPath(), new File("C:/logotipo_brasao/"+file2.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                auxCaminho = jFileChooser.getCurrentDirectory().getPath() + '/' + jFileChooser.getSelectedFile().getName(); // caminho do arquivo
                caminho = auxCaminho.replace('\\', '/');
            } else {
                jFileChooser.cancelSelection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        BufferedImage imagem = null;
        try {
            imagem = ImageIO.read(new File(caminho));
        } catch (IOException ex) {
            //Logger.getLogger(ImagePanel2.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedImage new_img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = new_img.createGraphics();
        g2.drawImage(imagem, 0, 0, 100, 100, null);
        try {
            ImageIO.write(new_img, "JPG", new File("Brasao" + contadorBrasao + ".jpg"));

        } catch (IOException ex) {
            Logger.getLogger(PainelNovoArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

        LabelMostraBrasao.setIcon(new ImageIcon("Brasao" + contadorBrasao + ".jpg"));

        if (contadorBrasao > 0) {
            contadorBrasao--;
        }

        new File("Brasao" + contadorBrasao + ".jpg").delete();
        contadorBrasao++;
    }//GEN-LAST:event_BotaoEnviaBrasaoActionPerformed

    public void alunoSelecionado(java.awt.event.MouseEvent evt) {
        remove(SelectAluno);
        revalidate();
        EscondeOuMostraComponentes(true);

        for (int i = 0; i < SelectAluno.aluno.length; i++) {
            if (SelectAluno.aluno[i].getAuxEscolhido() > 0) {
                DefineMatricula.setText(SelectAluno.aluno[i].getMatricula());
                LabelMostraCarometro.setIcon(SelectAluno.aluno[i].getFoto());
            }
        }

        revalidate();
        repaint();
    }

    public void EscondeOuMostraComponentes(boolean define) {
        LabelFormularioDeInformacoes.setVisible(define);
        LabelQuantidadeDeAlunos.setVisible(define);
        RadioIndividual.setVisible(define);
        RadioTurma.setVisible(define);
        RadioGrupo.setVisible(define);
        LabelTipoDeTeste.setVisible(define);
        RadioProva.setVisible(define);
        RadioTrabalho.setVisible(define);
        if (RadioProva.isSelected()) {
            LabelDataDaProva.setVisible(define);
        }
        if (RadioTrabalho.isSelected()) {
            LabelDataDeRecebimento.setVisible(define);
        }
        if (RadioProva.isSelected() || RadioTrabalho.isSelected()) {
            jDateChooser1.setVisible(define);
        }
        if (RadioTrabalho.isSelected()) {
            jDateChooser3.setVisible(define);
        }
        if (RadioTrabalho.isSelected()) {
            LabelDataDeEntrega.setVisible(define);
        }
        PainelDatas.setVisible(define);
        Labelvalor.setVisible(define);
        DefineValorProva.setVisible(define);
        LabelTitulo.setVisible(define);
        DefineTitulo.setVisible(define);
        LabelNumDeQuestoes.setVisible(define);
        DefineNumDeQuestoes.setVisible(define);
        LabelTurno.setVisible(define);
        DefineTurno.setVisible(define);
        LabelTurmas.setVisible(define);
        DefineTurmas.setVisible(define);
        LabelElaborador.setVisible(define);
        DefineElaborador.setVisible(define);
        LabelInstituicao.setVisible(define);
        DefineInstituicao.setVisible(define);
        LabelTipoDeInstituicao.setVisible(define);
        RadioPublica.setVisible(define);
        RadioPrivada.setVisible(define);
        BotaoEnviaLogo.setVisible(define);
        BotaoEnviaBrasao.setVisible(define);
        BotaoEnviaCarometro.setVisible(define);
        LabelMostraLogo.setVisible(define);
        LabelMostraBrasao.setVisible(define);
        LabelMostraCarometro.setVisible(define);
        LabelMatricula.setVisible(define);
        DefineMatricula.setVisible(define);
        BotaoEnvia.setVisible(define);
        DefineDuracao.setVisible(define);
        LabelDuracao.setVisible(define);
        LabelMinutos.setVisible(define);
        LabelPontos.setVisible(define);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoEnvia;
    private javax.swing.JButton BotaoEnviaBrasao;
    private javax.swing.JButton BotaoEnviaCarometro;
    private javax.swing.JButton BotaoEnviaLogo;
    private javax.swing.JSpinner DefineDuracao;
    private javax.swing.JTextField DefineElaborador;
    private javax.swing.JTextField DefineInstituicao;
    private javax.swing.JTextField DefineMatricula;
    private javax.swing.JSpinner DefineNumDeQuestoes;
    private javax.swing.JTextField DefineTitulo;
    private javax.swing.JTextField DefineTurmas;
    private javax.swing.JComboBox<String> DefineTurno;
    private javax.swing.JSpinner DefineValorProva;
    private javax.swing.JLabel LabelDataDaProva;
    private javax.swing.JLabel LabelDataDeEntrega;
    private javax.swing.JLabel LabelDataDeRecebimento;
    private javax.swing.JLabel LabelDuracao;
    private javax.swing.JLabel LabelElaborador;
    private javax.swing.JLabel LabelFormularioDeInformacoes;
    private javax.swing.JLabel LabelInstituicao;
    private javax.swing.JLabel LabelMatricula;
    private javax.swing.JLabel LabelMinutos;
    private javax.swing.JLabel LabelMostraBrasao;
    private javax.swing.JLabel LabelMostraCarometro;
    private javax.swing.JLabel LabelMostraLogo;
    private javax.swing.JLabel LabelNumDeQuestoes;
    private javax.swing.JLabel LabelPontos;
    private javax.swing.JLabel LabelQuantidadeDeAlunos;
    private javax.swing.JLabel LabelTipoDeInstituicao;
    private javax.swing.JLabel LabelTipoDeTeste;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JLabel LabelTurmas;
    private javax.swing.JLabel LabelTurno;
    private javax.swing.JLabel Labelvalor;
    private javax.swing.JPanel PainelDatas;
    private javax.swing.JRadioButton RadioGrupo;
    private javax.swing.JRadioButton RadioIndividual;
    private javax.swing.JRadioButton RadioPrivada;
    private javax.swing.JRadioButton RadioProva;
    private javax.swing.JRadioButton RadioPublica;
    private javax.swing.JRadioButton RadioTrabalho;
    private javax.swing.JRadioButton RadioTurma;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables
}
