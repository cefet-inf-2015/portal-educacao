package bancodequestoes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 * //@TODO usar pdfbox e Java2Word para fazer arquivos PDF com as provas. ESPERAR cabeçario. O que fazer
 * //@TODO DOCUMENTAR =(
 * @author ThalesGSN
 */
public class ProvaOut {
//Variaveis de instancia.
    /** <i>Path </i> que define o local para escrever o arquivo. */
    Path diretorio;
    /** <i>File</i> que define o arquivo a ser gravado. */
    File arquivo;
//Construtores
    /**
     * Construtor vazio para uso de sets e gets.
     */
    public ProvaOut() { }

    /**
     * Constru
     * @param diretorio 
     */
    public ProvaOut(Path diretorio) {
        this.diretorio = diretorio;
        arquivo = diretorio.toFile();
    }
    
//SETS e GETS

    public Path getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(Path diretorio) {
        this.diretorio = diretorio;
        arquivo = diretorio.toFile();
    }

//Metodos uteis
    /**
     * @param prova
     * //@TODO IMPLEMENTAR toDoc Cabecario
     * @return 
     * @throws java.io.FileNotFoundException 
     */
    public boolean provaToDoc(Prova prova) throws FileNotFoundException{
        FileOutputStream file = new FileOutputStream(new File(diretorio.toUri()));
        XWPFDocument documento = new XWPFDocument();
        
        XWPFParagraph paragraph = documento.createParagraph();
        XWPFRun run=paragraph.createRun();
        
        ListIterator itrProva = (ListIterator) prova.iterator();
        
        while(itrProva.hasNext()) {
            Questao questao = (Questao) itrProva.next();
            run.setText((itrProva.nextIndex() - 1) + ')' + questao.toString());
        }
        
       return true; //por enquanto
    }
    
    /**
     * @param prova
     * //@TODO IMPLEMENTAR toPDF
     * @return 
     */
    public boolean provaToPDF(Prova prova){
       return false; //por enquanto
    }
   
}
