
package com.mycompany.practica5diu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author hugob
 */
public class Lienzo extends JPanel{
    public BufferedImage imagen = null;
    public BufferedImage logotipo = null;
    public BufferedImage ima = null;
    private int v1=0,v2=0;
    private Image im = null;

    public Lienzo() throws IOException {
        try {
            imagen = ImageIO.read(new URL("https://www.cambio16.com/wp-content/uploads/2017/04/fotos-impresionantes-imagenes-que-parecen-modificadas-con-photoshop-11.jpeg"));
            this.setPreferredSize(new Dimension(imagen.getWidth(),imagen.getHeight()));
            ima=imagen;
            logotipo = ImageIO.read(new URL("https://wonder-day.com/wp-content/uploads/2020/10/wonder-day-among-us-png-28.png"));
            im = logotipo.getScaledInstance(imagen.getWidth()/3, imagen.getHeight()/3, 0);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setImagen(BufferedImage i){
        ima = i;
    }
        
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        g.drawImage(ima, 0, 0, null);
        logotipo = imageToBufferedImage(im);
        g.drawImage(logotipo, v1, v2, null);
        
    }
    public void setValues(int valor1, int valor2){
        v1 = valor1;
        v2 = valor2;
    }
    
    
     public static BufferedImage imageToBufferedImage(Image im) {
     BufferedImage bi = new BufferedImage
        (im.getWidth(null),im.getHeight(null),BufferedImage.TYPE_INT_RGB);
     Graphics bg = bi.getGraphics();
     bg.drawImage(im, 0, 0, null);
     bg.dispose();

     return bi;
  }
    
}
