/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import app.App;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author pc
 */
public class ImagesUtils {

    
    
    
    public static void loadSplashScreenImage(JLabel lbl, String imgUrl){
        loadImage(lbl, imgUrl, getSplashDefaultImagePath());
    }
    
 
    
    private static void loadImage(JLabel lbl, String imgUrl, URL defaultImage) {

        try {
            if (imgUrl.startsWith("http")) {
                loadImageFromUrl(lbl, imgUrl);
            } else {
                loadImageFromFile(lbl, imgUrl);
            }

        } catch (Exception ex) {
            Logger.getLogger(ImagesUtils.class.getName()).log(Level.SEVERE, null, ex);
//            MessageBox.showMessage(ex.getMessage());
            putDefaultImage(lbl, defaultImage);

        }
    }


    public static void removeImage(JLabel lbl) {

        try {
            lbl.setIcon(null);

        } catch (Exception ex) {

            MessageBox.showErrorMessage(ex.getMessage());
//            putDefaultImage(lbl);

        }
    }

    private static void loadImageFromUrl(JLabel lbl, String imgUrl) throws Exception {
        URL url = new URL(imgUrl);
        Image img = ImageIO.read(url).getScaledInstance(lbl.getWidth(), lbl.getHeight(), 0);
        ImageIcon icon = new ImageIcon(img);
        lbl.setIcon(icon);
    }

    private static void putDefaultImage(JLabel lbl, URL imgURL) {
        try {
            lbl.setIcon(new ImageIcon(ImageIO.read(imgURL)));
        } catch (IOException ex) {
            Logger.getLogger(ImagesUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void loadImageFromFile(JLabel lbl, String imgUrl) throws Exception {
        File file = new File(imgUrl);
        if (file.isFile() && file.exists()) {
            lbl.setIcon(new ImageIcon(ImageIO.read(file)));
        } else {
            throw new Exception("لم يتم إيجاد الصورة");
        }
    }

    private static URL getSplashDefaultImagePath() {
        return App.class.getResource("/images_res/splash_logo.PNG");
    }
}
