
package utils;

import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author pc
 */
public class Tools {
    public static void showMessage(String response) {
        JOptionPane.showMessageDialog(null, response,"Message",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static int getIntegerFromTextBox(JTextField txt) throws Exception{
        String num = txt.getText().trim();
        return Integer.parseInt(num);
    }
    
    /* public static Font getPTboldFont(int size){
    //        return new Font("PT Bold Heading", size, Font.BOLD);
    return new Font("PT Bold Heading", Font.BOLD, size);
    }
    */
}
