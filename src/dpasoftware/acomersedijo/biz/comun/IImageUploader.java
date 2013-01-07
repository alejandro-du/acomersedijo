package dpasoftware.acomersedijo.biz.comun;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 *
 * @author Alejandro
 */
public interface IImageUploader {
    
    /**
     * Carga el archivo de imagen especificado en el archivo especificado por nombreCompletoArchivo ajustando la
     * imagen al tamaño especificado.
     * @param archivo Archivo a subir.
     * @param eliminar Si se debe elimiar el archivo especificado por nombreCompletoArchivo.
     * @param nombreCompletoArchivo Cadena con el nombre completo del archivo a subir.
     * @param anchoImagen Ancho al que debe ajustarse la imagen.
     * @param altoImagen Alto al que debe ajustarse la imagen.
     * @return true, si la operación tiene éxito. false, en otro caso.
     */
    boolean cargarImagen(File archivo, boolean eliminar, String nombreCompletoArchivo, int anchoImagen, int altoImagen);
    
    /**
     * Saves a BufferedImage to the given file.
     * @param img
     * @param saveFile
     */
    void saveImage(BufferedImage img, File ref);
    
    BufferedImage resizeImage(BufferedImage img, int newW, int newH);

}
