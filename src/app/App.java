/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import ui.test_connection.TestConfigtationsUI;

/**
 *
 * @author pc
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestConfigtationsUI ui = new TestConfigtationsUI();
         ui.setLocationRelativeTo(null);
        ui.setVisible(true);
        
        /*
        try {
        // TODO code application logic here
        //            Desktop.getDesktop().browse(new URI("C://xampp/xampp_start.exe"));
        //            Desktop.getDesktop().browse(new URI("C://xampp/mysql_start.bat"));
        Desktop.getDesktop().browse(new URI("C://xampp/xampp-control.exe"));
        
        } catch (URISyntaxException | IOException ex) {
        System.out.println(""+ex);
        String error = ex.getMessage();
        if (error.contains("cannot find the file")) {
        MessageBox.showErrorMessage("غير قادر علي تشغيل السيرفر\nتأكد من المسار"+"\n"+error);
        }else if (error.contains("operation was canceled by the user")) {
        MessageBox.showErrorMessage("تم إلغاء فتح الملف"+"\n"+error);
        }else{
        MessageBox.showErrorMessage(error);
        }
        
        System.exit(0);
        }*/

    }
    
}
