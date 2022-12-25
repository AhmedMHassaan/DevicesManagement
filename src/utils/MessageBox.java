/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.JOptionPane;

/**
 *
 * @author Nozom
 */
public class MessageBox {
      public static void showMessage(String response) {
        JOptionPane.showMessageDialog(null, response,"Message",JOptionPane.INFORMATION_MESSAGE);
    }
    
      
        public static void showErrorMessage(String response) {
        JOptionPane.showMessageDialog(null, response,"Error",JOptionPane.ERROR_MESSAGE);
    }
    
}
