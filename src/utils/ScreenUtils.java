/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

/**
 *
 * @author pc
 */
public class ScreenUtils {
    
    
    
    public static Dimension getScreenSize(){
        return Toolkit.getDefaultToolkit().getScreenSize();
    }
    
    
    public static int getScreenSizeWidth(){
        GraphicsDevice graphic = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        return graphic.getDisplayMode().getWidth();
    }
    
    public static int getScreenSizeHeight(){
        GraphicsDevice graphic = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        return graphic.getDisplayMode().getHeight();
    }
    
   
    
    
            
}
