/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import com.sun.corba.se.impl.protocol.giopmsgheaders.MessageBase;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MessageBox;

/**
 *
 * @author pc
 */
public class BaseLocalDbQueries {

    private Connection connection;

    public BaseLocalDbQueries(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
//        System.out.println("Connection is "+connection);
        return connection;
    }
    
    

   
    public void destroy() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException ex) {
                Logger.getLogger(BaseLocalDbQueries.class.getName()).log(Level.SEVERE, null, ex);
                MessageBox.showErrorMessage(ex.getMessage());
            }
        }
    }

}
