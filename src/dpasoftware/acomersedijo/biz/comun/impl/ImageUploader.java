package dpasoftware.acomersedijo.biz.comun.impl;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dpasoftware.acomersedijo.biz.comun.IImageUploader;

/**
 *
 * @author Alejandro.
 */
public class ImageUploader implements IImageUploader {

    public boolean cargarImagen(File archivo, boolean eliminar, String nombreCompletoArchivo, int anchoImagen, int altoImagen) {

        File newFile = new File(nombreCompletoArchivo);
        
        if(eliminar) {
            newFile.delete();
        }
        else if(archivo != null) {
            
            BufferedImage image = null;

            try {
                image = ImageIO.read(archivo);
            }
            catch(Exception e) {
                e.printStackTrace();
                return false;
            }

            image = resizeImage(image, anchoImagen, altoImagen);
            saveImage(image, archivo);

            if(newFile.exists()) {
                newFile.delete();
            }

            if(!archivo.renameTo(newFile)) {
                archivo.delete();
                return false;
            }
        }
        
        return true;
    }

    public void saveImage(BufferedImage img, File ref) {
        try {
            ImageIO.write(img, "png", ref);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage resizeImage(BufferedImage img, int newW, int newH) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
        Graphics2D g = dimg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return dimg;
    }

}
