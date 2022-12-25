/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import utils.ConfigurationsUtils;
import utils.ImagesUtils;

/**
 *
 * @author Nozom
 */
public abstract class AdvancedFrame extends JFrame {

    public AdvancedFrame() {
        super();

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }

        });

        try {

            String framesIcon = ConfigurationsUtils.getAppLogoImagePath();
//            System.out.println("Image Path => "+framesIcon);
            File iconFile =new File(framesIcon);
//            System.out.println("Icon file exeist ? "+iconFile.exists());
            this.setIconImage(ImageIO.read(iconFile));
//            System.out.println("ICON SET");
        } catch (IOException ex) {
            Logger.getLogger(AdvancedFrame.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("Ex");
        } catch (Exception ex) {
            Logger.getLogger(AdvancedFrame.class.getName()).log(Level.SEVERE, null, ex);
            URL imagePath = AdvancedFrame.class.getResource("/images_res/icons8-devices-64.png");

            Image img;
            try {
                img = ImageIO.read(imagePath);
                setIconImage(img);
            } catch (IOException ex1) {
                Logger.getLogger(AdvancedFrame.class.getName()).log(Level.SEVERE, null, ex1);
            }
//System.out.println("File => "+new File(imagePath).getAbsolutePath());
//            Image img =  ImageIO.read(new File(imagePath));

        }

    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {
        destroyInstance();
//        System.out.println("Destroyed !");
    }

    public abstract void destroyInstance();

    public void startNewFrame(JFrame distenation) {
        startNewFrame(distenation, true);
    }

    public void startNewFrame(JFrame distenation, boolean disposeCurrent) {
        distenation.setLocationRelativeTo(null);
        distenation.setVisible(true);
        if (disposeCurrent) {
            this.dispose();
        }
    }

    public void startNewFrameWithOldFrame(JFrame distenation) {
        distenation.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        startNewFrame(distenation, false);
    }

    /*  public Font getBtBoldFont(int size){
    return Tools.getPTboldFont(size);
    }
    
     */
}
