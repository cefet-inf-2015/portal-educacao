package bancodequestoes;

/**
 * Classe que representa uma imagem de uma questão do grupo banco de questoes.
 * @author ThalesGSN
 */
public class Imagem {
 //Variaveis de instancia.
    /** String que representa o caminho da imagem no servidor ou localmente pra ser uploadado. */ 
    String path;
    /** checa se a imagem esta online. */
    boolean online;

//construtores
/**
 * Constroi um objeto de imagem ofline com o caminho do arquivo 
 * @param path String do caminho do Arquivo
 */
    public Imagem(String path) {
        this.path = path;
        this.online = false;
    }
    /**
     * Constroi um objeto de imagem online ou oflinbe com o caminho do arquivo
     * @param path String o caminho do arquivo
     * @param online  verifica se esta online
     */
    public Imagem(String path, boolean online) {
        this.path = path;
        this.online = online;
    }

//Sets e gets
    /** 
     * Retorna o caminho do arquivo
     * @return String caminho do arquivo
     */
    public String getPath() {
        return path;
    }

    /**
     * Define ou altera o caminho da imagem.
     * @param path String o caminho da imagem.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     *  boolean  que define se a imagem ja esta online
     * @return true se e somente se a imagem ja estiver online
     */
    public boolean isOnline() {
        return online;
    }
    
}
