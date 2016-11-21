package bancodequestoes;

/**
 *  Classe que define uma <b>alternativa</b> que faz parte de uma questão de <i>MultiplaEscolha</i>
 * <i>VOuF</i>, definindo seu <i>texto</i> e se ela é correta ou não.
 * @author ThalesGSN
 */
public class Alternativa {
//variaveis de instancia    
    /**<i>String</i> <i>texto</i> que representa o texto da <b>alternativa</b>.*/ 
    private String texto;
    /** <i>booleano</i> que informa se a <b>alternativa</b> esta correta. */
    private boolean isCorreta;
//Construtores
    /**
     * Construtor vazio para ser usado e construido com sets e gets.
     */
    public Alternativa() { }

    /**
     *  Construtor que constroi o objeto com dois parametros,
     * @param texto <i>String</i> <i>texto</i> que representa o texto da <b>alternativa</b>.
     * @param isCorreta  <i>booleano</i> que informa se a <b>alternativa</b> esta correta.
     */
    public Alternativa(String texto, boolean isCorreta) {
        this.texto = texto;
        this.isCorreta = isCorreta;
    }
//Sets e Gets
    /**
     * Retorna o <i>texto</i> da <b>alternativa</b>.
     * @return texto <i>String</i> <i>texto</i> que representa o texto da <b>alternativa</b>.
     */
    public String getTexto() {
        return texto;
    }
    
    /**
     *  Altera ou define o <i>texto</i> da <b>alternativa</b>.
     * @param texto <i>String</i> <i>texto</i> que representa o texto da <b>alternativa</b>.
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    /**
     * Retorna se a <b>questão</b> é <i>correta</i> ou não.
     * @return true se e somente se a questão for correta.
     */
    public boolean IsCorreta() {
        return isCorreta;
    }
    
    /**
     * Seta o estado da <b>alternativa</b> como <i>correta</i>.
     */
    public void setCorreta() {
        this.isCorreta = true;
    }
    
    /**
     * Seta o estado da <b>alternativa</b> como <i>incorreta</i>.
     */
    public void setIncorreta() {
        this.isCorreta = false;
    }
    
//Metodos uteis
    @Override
    public String toString() {
        return texto;
    }
    
}
