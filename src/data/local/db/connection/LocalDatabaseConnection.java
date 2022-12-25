/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.local.db.connection;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import other.Constants;
import repository.BrandsRepository;
import utils.MessageBox;

/**
 *
 * @author pc
 */
public class LocalDatabaseConnection {

    /* private  Connection connection;
    
    
    
    
    private static LocalDatabaseConnection instance;
    
    public synchronized static LocalDatabaseConnection getInstance() {
    
    synchronized (LocalDatabaseConnection.class) {
    if (instance == null) {
    synchronized (LocalDatabaseConnection.class) {
    instance = new LocalDatabaseConnection();
    }
    }
    }
    
    return instance;
    }
     */
    public static Connection getConnection() throws Exception {

        Class.forName("org.sqlite.JDBC");
        Properties properties = new Properties();
        properties.setProperty("PRAGMA foreign_keys", "ON");
//        connection = DriverManager.getConnection("jdbc:sqlite:nozom_devices.db");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + Constants.LOCAL_DATABASE_NAME, properties);

//        System.out.println("Connected "+connection);
//        connection = DriverManager.getConnection("jdbc:sqlite:nozom_devices.devices_db");
        return connection;
    }

 

    /*public Connection getConnectionInstance() throws Exception{
   
   if (connection == null) {
   connection = connect();
   }
   
   return connection;
   }*/
    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
            connection = null;
        }

    }
}
