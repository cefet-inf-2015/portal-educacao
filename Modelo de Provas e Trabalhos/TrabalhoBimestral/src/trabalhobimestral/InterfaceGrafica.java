/**
 * Pacote com o conjunto de classes necessarias à Aplicação
 */
package trabalhobimestral;

/**
 * Bibliotecas necessárias para a aplicação
 */
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * @author Gabriel Víctor
 */
public class InterfaceGrafica extends JFrame {

    private JFileChooser janelaDialogo;//Janela para seleção de arquivo (upload)
    private JDateChooser data; //Campo para inserir data da prova ou recebimento (em caso de trabalho)
    private JDateChooser data2;//Campo para inserir data de entrega, caso seja um trabalho
    private BufferedImage imagem;//Variavel para manipular a imagem (logotipo ou brasao)
    private File arquivo;//Variavel para manipular um prototipo (.txt) de banco de dados
    private JLabel mostraLogotipo;//Area para mostrar uma pre-visualização do Logotipo
    private JLabel mostraBrasao;//Area para mostrar uma pre-visualização do Brasão
    private Upload upload;//Objeto da classe privada e interna Upload para tratar evento de clique nos botoes uploadLogotipo e uploadBrasao
    private enviarDados submit;//Objeto da classe enviarDados para tratamento de evento de clique no botão para finalizar o envio do formulario 
    private JPanel painel;//Painel onde é disposto os componentes do formulário
    private JButton uploadLogotipo;//Botão para upload de logotipo
    private JButton uploadBrasao;//Botão para upload de brasão
    private JLabel[] legendas;//label's que contém texto que será disposto antes de um campo de inserção Ex.: Matricula: <- legenda (campo inserção dados)
    private JTextField titulo;//campo para inserção do titulo Ex.: Prova Bimestral de Matematica
    private JTextField matricula;//campo para inserção de matricula Ex.: 2016111
    private JRadioButton prova;//opção em JRadioButton para selecionar a opção "Prova"
    private JRadioButton trabalho;//opção em JRadioButton para selecionar a opção "Trabalho"
    private JRadioButton individualTurma;//opção em JRadioButton para selecionar a opção "Individual (para a turma)"
    private JRadioButton individualUnico;//opção em JRadioButton para selecionar a opção "Individual (Unico)"
    private JRadioButton grupo;//opção em JRadioButton para selecionar a opção "Grupo"
    private JRadioButton publica;//opção em JRadioButton para selecionar a opção de Escola "Publica"
    private JRadioButton privada;//opção em JRadioButton para selecionar a opção de Escola "Privada"
    private ButtonGroup grupo1;//Primeiro grupo de Opções radio (Prova/Trabalho)
    private ButtonGroup grupo2;//Segundo grupo de Opções radio (Individual/Turma -> Individual/Unico -> Grupo)
    private ButtonGroup grupo3;//Terceiro grupo de Opções radio (Prova/Trabalho)
    private JButton confirmar;//Botão para confirmar primeira parte do formulário
    private JButton enviaDados;//Botão para enviar segunda parte do formulário
    private EventoGrupo1 evento;//Evento não implementado para o primeiro grupo de JRadioButton (Prova -> Trabalho)
    private EventoFoco eventoFoco;//Evento para tratar ganho/perca de foco em campos JTextField (Titulo -> Matricula) com textos pre-definidos
    private eventoConfirmar eventoConfirma;//Evento para tratar o clique no JButton Confirmar para envio da primeira parte do formulário
    private final int max_Label = 7;//Tamanho do vetor "legendas"
    private final String exemplo1 = "Ex.: Prova/Trabalho Bimestral";//Texto pre-definido para o JTextField "titulo"
    private final String exemplo2 = "Ex.: C2015111";//Texto pre-definido para o JTextField "matricula"
    private final String BD = "bd";//Nome do protótipo de banco de dados (uma pasta local)
    private String dados = "";//Armazena a opção selecionada no primeiro grupo de JRadioButton (Prova -> Trabalho)
    private String dados2 = "";//Armazena a opção selecionada no segundo grupo de JRadioButton (Individual/Turma -> Individual/Unico -> Grupo)
    private String dados3 = "";//Armazena a opção selecionada no terceiro grupo de JRadioButton (Publica -> Privada)
    private String dataEntrega = "";//Armazena a data de entrega selecionada em caso de trabalho
    private String dataRecebimento = "";//Armazena a data de recebimento selecionada em caso de trabalho
    private String dataDados = "";//Armazena a data selecionada em caso de prova

    public InterfaceGrafica() {
        submit = new enviarDados();
        enviaDados = new JButton("Submit");
        data = new JDateChooser();
        data2 = new JDateChooser();
        mostraBrasao = new JLabel();
        upload = new Upload();
        janelaDialogo = new JFileChooser();
        mostraLogotipo = new JLabel();
        uploadLogotipo = new JButton("Enviar Logotipo");
        uploadBrasao = new JButton("Enviar Brasão");
        eventoConfirma = new eventoConfirmar();
        confirmar = new JButton("Confirmar Dados");
        evento = new EventoGrupo1();
        eventoFoco = new EventoFoco();
        legendas = new JLabel[max_Label];
        painel = new JPanel(null);
        titulo = new JTextField();
        matricula = new JTextField();

        grupo1 = new ButtonGroup();
        grupo2 = new ButtonGroup();
        grupo3 = new ButtonGroup();

        prova = new JRadioButton("Prova", false);
        trabalho = new JRadioButton("Trabalho", false);
        individualTurma = new JRadioButton("Individual (Específico)");
        individualUnico = new JRadioButton("Individual (para a turma)");
        publica = new JRadioButton("Pública");
        privada = new JRadioButton("Privada");
        grupo = new JRadioButton("Grupo");
        grupo3.add(publica);
        grupo3.add(privada);
        legendas[0] = new JLabel("Título: ");
        legendas[1] = new JLabel("Modalidade: ");
        legendas[2] = new JLabel("Escola: ");
        legendas[3] = new JLabel("Matrícula: ");
        legendas[4] = new JLabel("Data: ");
        legendas[5] = new JLabel("Data de Recebimento: ");
        legendas[6] = new JLabel("Data de Entrega: ");

        primeiroMenu();//Função para "gerar" primeiro formulário
        enviaDados.addActionListener(submit);
        prova.addItemListener(evento);
        trabalho.addItemListener(evento);
        titulo.addFocusListener(eventoFoco);
        matricula.addFocusListener(eventoFoco);
        confirmar.addActionListener(eventoConfirma);
        uploadLogotipo.addActionListener(upload);
        uploadBrasao.addActionListener(upload);
        add(painel);
    }

    /**
     * Classe para evento de seleção do primeiro grupo de JRadioButton (Prova ->
     * trabalho)
     */
    private class EventoGrupo1 implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (prova.isSelected()) {

            } else {
                if (trabalho.isSelected()) {

                }
            }
        }
    }

    private class EventoFoco implements FocusListener {

        /**
         * @param fe focusGained -> ganho de foco nos campos de inserção Titulo
         * || Matricula focusLost -> perda de foco nos campos de inserção Titulo
         * || Matricula
         */
        @Override
        public void focusGained(FocusEvent fe) {
            /**
             * Se o objeto que "chama" for o titulo, verifica-se se o texto no
             * campo é o texto default, caso seja, retira visto que o usuario
             * selecionou este campo de inserção O mesmo ocorre para o campo
             * matricula
             */
            if (fe.getSource() == titulo) {
                if (titulo.getText().equals(exemplo1)) {
                    titulo.setText("");
                }
            } else {
                if (fe.getSource() == matricula) {
                    if (matricula.getText().equals(exemplo2)) {
                        matricula.setText("");
                    }
                }
            }
        }

        @Override
        public void focusLost(FocusEvent fe) {
            /**
             * Se o objeto que chama (campo de inserção) não possuir nada
             * escrito, insere o texto default, visto que o usuario retirou o
             * foco do campo, sem preenche-lo
             */
            if (fe.getSource() == titulo) {
                if (titulo.getText().equals("")) {
                    titulo.setText(exemplo1);
                }
            } else {
                if (fe.getSource() == matricula) {
                    if (matricula.getText().equals("")) {
                        matricula.setText(exemplo2);
                    }
                }
            }
        }

    }

    public void primeiroMenu() {
        /**
         * Método para "gerar" o primeiro formulário
         */
        legendas[0].setBounds(80, 10, 50, 20);
        titulo.setBounds(130, 10, 250, 20);
        titulo.setText(exemplo1);
        titulo.setToolTipText(exemplo1);
        prova.setBounds(150, 40, 90, 40);
        trabalho.setBounds(240, 40, 90, 40);

        grupo1.add(prova);
        grupo1.add(trabalho);

        individualTurma.setBounds(170, 110, 250, 20);
        individualUnico.setBounds(individualTurma.getX(), 90, 250, 20);
        grupo.setBounds(individualTurma.getX(), 130, 250, 20);
        legendas[1].setBounds(legendas[0].getX(), individualTurma.getY(), 100, 20);
        legendas[2].setBounds(legendas[0].getX(), grupo.getY() + grupo.getHeight() + 20, 50, 20);
        publica.setBounds(grupo.getX(), legendas[2].getY() + 10, 80, 20);
        privada.setBounds(grupo.getX(), publica.getY() + publica.getHeight(), 80, 20);
        confirmar.setBounds(150, 250, 200, 20);
        grupo2.add(individualUnico);
        grupo2.add(individualTurma);
        grupo2.add(grupo);

        painel.add(publica);
        painel.add(privada);
        painel.add(legendas[0]);
        painel.add(legendas[1]);
        painel.add(legendas[2]);
        painel.add(titulo);
        painel.add(prova);
        painel.add(trabalho);
        painel.add(individualUnico);
        painel.add(individualTurma);
        painel.add(grupo);
        painel.add(confirmar);

    }

    public void segundoMenu() throws ParseException {
        /**
         * Método para "gerar" segundo formulário
         */
        enviaDados.setBounds(200, 300, 100, 50);
        painel.add(enviaDados);
        if (dados.equals(prova.getText())) {
            legendas[3].setBounds(legendas[0].getX(), titulo.getY(), 80, titulo.getHeight());
            legendas[4].setBounds(legendas[0].getX(), 50, 40, 20);
            matricula.setBounds((legendas[3].getX() + legendas[3].getWidth()), legendas[3].getY(), titulo.getWidth(), titulo.getHeight());
            data.setBounds(matricula.getX(), 50, 100, 20);
            data.setDateFormatString("dd/MM/yyyy");
            matricula.setText(exemplo2);
            painel.add(legendas[3]);
            painel.add(legendas[4]);
            painel.add(data);
            painel.add(matricula);
        } else {
            if (dados.equals(trabalho.getText())) {

                painel.repaint();
                painel.revalidate();

                legendas[5].setBounds(100, 20, 130, 20);//recebimento
                legendas[6].setBounds(legendas[5].getX(), 50, 100, 20);//entrega

                data.setBounds(legendas[5].getX() + legendas[5].getWidth() + 10, 50, 100, 20);
                data2.setBounds(legendas[5].getX() + legendas[5].getWidth() + 10, 20, 100, 20);
                painel.add(legendas[5]);
                painel.add(legendas[6]);
                painel.add(this.data2);
            }
        }

        painel.add(data);
        if (dados3.equals(publica.getText())) {
            uploadLogotipo.setBounds(100, 100, 130, 50);
            uploadBrasao.setBounds((uploadLogotipo.getX() + uploadLogotipo.getWidth() + 30), 100, 130, 50);
            painel.add(uploadLogotipo);
            painel.add(uploadBrasao);
        } else {
            uploadLogotipo.setBounds(185, 100, 130, 50);
            painel.add(uploadLogotipo);
        }

        add(painel);
    }

    private class eventoConfirmar implements ActionListener {

        /**
         * @param e Método acionado após o usuário clicar em confirmar o
         * primeiro formulário, este método verifica se o usuário
         * inseriu/selecionou todas as informações, caso o tenha feito, as
         * armazena em um BD local prototipo, caso contrário, alerta ao usuario
         * para preencher/selecionar determinado campo
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!titulo.getText().equals("") && !titulo.getText().equals(exemplo1)) {
                if (grupo1.getSelection() != null) {
                    if (grupo2.getSelection() != null) {
                        if (grupo3.getSelection() != null) {
                            File pasta = new File(BD);
                            if (!pasta.exists()) {//Verifica se a pasta que sera utilizada como BD existe, caso não exista, ela é criada
                                pasta.mkdir();//Criação da pasta
                            }
                            File arq = new File("./" + BD + "/registro.txt");
                            if (prova.isSelected()) {
                                dados = prova.getText();

                            } else {
                                dados = trabalho.getText();
                            }
                            if (individualUnico.isSelected()) {
                                dados2 = individualUnico.getText();
                            } else {
                                if (individualTurma.isSelected()) {
                                    dados2 = individualTurma.getText();
                                } else {
                                    dados2 = grupo.getText();
                                }
                            }
                            if (publica.isSelected()) {
                                dados3 = publica.getText();
                            } else {
                                dados3 = privada.getText();
                            }
                            try {
                                /**
                                 * Verifica se o arquivo "registro.txt" existe
                                 * caso exista, continua a "gravar" no fim, caso
                                 * contrário, é criado este arquivo e adiciona
                                 * as informações do formulário
                                 */
                                if (!arq.exists()) {
                                    BufferedWriter gravar = new BufferedWriter(new FileWriter(BD + "/registro.txt"));
                                    gravar.append(titulo.getText());
                                    gravar.newLine();
                                    gravar.append(dados);
                                    gravar.newLine();
                                    gravar.append(dados2);
                                    gravar.newLine();
                                    gravar.append(dados3);
                                    gravar.newLine();
                                    gravar.newLine();
                                    gravar.close();
                                } else {

                                    BufferedWriter gravar = new BufferedWriter(new FileWriter(arq, true));
                                    gravar.append(titulo.getText());
                                    gravar.newLine();
                                    gravar.append(dados);
                                    gravar.newLine();
                                    gravar.append(dados2);
                                    gravar.newLine();
                                    gravar.append(dados3);
                                    gravar.newLine();
                                    gravar.newLine();
                                    gravar.close();

                                }
                            } catch (IOException ex) {

                            }
                            painel.removeAll();
                            painel.repaint();
                            painel.revalidate();
                            try {
                                segundoMenu();
                            } catch (ParseException ex) {
                                Logger.getLogger(InterfaceGrafica.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Selecione uma Escola!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecione uma Modalidade!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione Prova ou Trabalho!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Digite um título!");
            }
        }
    }

    private class Upload implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == uploadLogotipo || e.getSource() == uploadBrasao) {
                janelaDialogo.showOpenDialog(null); // Abra a "janela" para que o usuario faça o upload de uma imagem
                arquivo = janelaDialogo.getSelectedFile();//Armazena o arquivo selecionado em "arquivo"

                try {
                    imagem = ImageIO.read(arquivo);//"lê" a imagem do arquivo selecionado
                    ImageIcon icon = new ImageIcon(imagem);//armazena a "imagem" em "icon"

                    int new_w = 100, new_h = 100; //variavéis para determinar a nova largura e altura da imagem apos redimensionamento

                    //armazena em "extensao" a extensao do arquivo Ex.: .JPG
                    String extensao = arquivo.getName().substring(arquivo.getName().lastIndexOf("."), arquivo.getName().length());
                    extensao = extensao.replace(".", ""); // retira de extensao o "." (ponto final)
                    // cria um arquivo para gerar uma nova imagem redimensionada
                    BufferedImage novaImagem = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
                    Graphics2D g = novaImagem.createGraphics();//Area Grafica (para "desenhar" a nova imagem)

                    g.setColor(Color.WHITE);//determina que o "fundo" da nova imagem será branco
                    //desenha um "retangulo" que servira como fundo para a nova imagem redimensionada
                    g.fillRect(0, 0, 100, 100);//871, 485);
                    g.drawImage(imagem, 0, 0, 100, 100, null);//"desenha" a imagem, redimensionada
                    g.dispose();//fecha a Area Grafica
                    ImageIO.write(novaImagem, extensao, new File("./bd/" + arquivo.getName()));//grava a imagem redimensionada no BD
                    BufferedImage imagemRedimensionada = ImageIO.read(new File("./bd/" + arquivo.getName()));
                    ImageIcon icone = new ImageIcon(imagemRedimensionada);//guarda o icone ("imagem redimensionada") em "icone"

                    if (e.getSource() == uploadBrasao) {
                        mostraBrasao.setIcon(icone);
                        mostraBrasao.setBounds(275, 200, 100, 100);
                        painel.add(mostraBrasao);
                    } else {
                        mostraLogotipo.setIcon(icone);
                        if (dados3.equals(publica.getText())) {
                            mostraLogotipo.setBounds(115, 200, 100, 100);
                        } else {
                            mostraLogotipo.setBounds(200, 200, 100, 100);
                        }
                        painel.add(mostraLogotipo);
                    }
                    painel.repaint();
                    painel.revalidate();

                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (Exception e1) {

                }
            }
        }
    }

    private class enviarDados implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (dados2.equals(individualUnico.getText()) || dados2.equals(individualTurma.getText())) {
                if (matricula.getText().equals("") || matricula.getText().equals(exemplo2)) {

                    JOptionPane.showMessageDialog(null, "Insira a matrícula");
                } else {
                    if (dados.equals(prova.getText())) {
                        if (data.isValid()) {
                            if (mostraLogotipo.getIcon() != null) {

                                File arquivo = new File("./" + BD + "/registro.txt");
                                if (arquivo.exists()) {
                                    try {
                                        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                                        String dataSimples = formatoData.format(data.getDate());
                                        BufferedWriter gravar = new BufferedWriter(new FileWriter(arquivo, true));
                                        gravar.append(matricula.getText());
                                        gravar.newLine();
                                        gravar.append(dataSimples);
                                        gravar.newLine();
                                        gravar.newLine();
                                        gravar.close();
                                        // gravar.append(data.get);
                                    } catch (IOException ex) {
                                        Logger.getLogger(InterfaceGrafica.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                } else {

                                    try {
                                        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                                        String dataSimples = formatoData.format(data.getDate());
                                        BufferedWriter gravar = new BufferedWriter(new FileWriter(BD + "/registro.txt"));
                                        gravar.append(matricula.getText());
                                        gravar.newLine();
                                        gravar.append(dataSimples);
                                        gravar.newLine();
                                        gravar.newLine();
                                        gravar.close();

                                    } catch (IOException ex) {
                                        Logger.getLogger(InterfaceGrafica.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Envie o Logotipo");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Insira um data válida!");
                        }
                    } else {
                        if (dados.equals(trabalho.getText())) {
                            File arq = new File("./" + BD + "/registro.txt");
                            if (!arq.exists()) {
                                try {
                                    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                                    String dataSimples = formatoData.format(data.getDate());
                                    BufferedWriter gravar = new BufferedWriter(new FileWriter(BD + "/registro.txt"));
                                    gravar.append(matricula.getText());
                                    gravar.newLine();

                                } catch (IOException ex) {
                                    Logger.getLogger(InterfaceGrafica.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } else {

                            }
                        }
                    }
                }
            }
        }
    }
}