package capturadefotos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;

public class VideoCaptura {

    VideoCapture video;
    Mat imageMat = new Mat();
    BufferedImage imageBuffer;
    byte[] dat;

    public VideoCaptura() {
        this.video = new VideoCapture(); //Inicia uma captura a partir da câmera. Método nativo do OpenCV.
        this.video.open(0);
    }

    public BufferedImage capturaQuadroBufferedImage() {
        this.video.read(this.imageMat); //Captura a imagem ao ser invocado o método
        imageBuffer = this.matToBufferedImage(this.imageMat); //Converte em uma imagem renderizada  
        return imageBuffer;
    }

    public Mat capturaQuadroMat() {
        this.video.read(this.imageMat); //Captura o quadro exibido na tela pela web cam
        return imageMat;
    }

    public void salvarFoto() throws IOException {
        this.video.read(this.imageMat); // "Lê" a imagem capturada pela web cam
        imageBuffer = this.matToBufferedImage(this.imageMat); // Transforma a captura em uma imagem renderizada
        ImageIO.write(imageBuffer, "PNG", new File("FOTO.png")); // Salva o arquivo na pasta de origem do arquivo. AQUI HAVERÁ A CONEXÃO COM O BD.
        System.out.println("Imagem salva em " + System.getProperty("user.dir")); // Log de confirmação, exibindo o destino da foto caso o método seja executado com sucesso.
    }

    /*
     * Método usado para configurar a imagem e renderizá-la antes de ser salva. Configura tamanho, esquema de cores e retorna a imagem.
     */
    
    public BufferedImage matToBufferedImage(Mat matrix) {
        int cols = matrix.cols();
        int rows = matrix.rows();
        int elemSize = (int) matrix.elemSize();
        byte[] data = new byte[cols * rows * elemSize];
        int type;
        matrix.get(0, 0, data);
        switch (matrix.channels()) {
            case 1:
                type = BufferedImage.TYPE_BYTE_GRAY;
                break;
            case 3:
                type = BufferedImage.TYPE_3BYTE_BGR;
                // bgr para rgb  
                byte b;
                for (int i = 0; i < data.length; i = i + 3) {
                    b = data[i];
                    data[i] = data[i + 2];
                    data[i + 2] = b;
                }
                break;
            default:
                return null;
        }
        BufferedImage image = new BufferedImage(cols, rows, type);
        image.getRaster().setDataElements(0, 0, cols, rows, data);
        return image;
    }

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME); //Carrega a biblioteca do OpenCV.
    }
}
