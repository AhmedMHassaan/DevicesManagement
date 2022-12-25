/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.google.gson.reflect.TypeToken;
import data.local.SQLiteUtils;
import data.local.db.connection.LocalDatabaseConnection;
import data.pojo.responses.ServerResponse;
import data.remote.HttpRequests;
import data.remote.HttpRequestsEnqueue;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import other.Constants;
import ui.test_connection.TestConfigtationsUI;
import utils.LiveData;
import utils.MessageBox;
import utils.MutableLiveData;

/**
 *
 * @author pc
 */
public class ConnectionRepository implements ConnectionRepositoryImpl {

    private static ConnectionRepository instance;

    public static ConnectionRepository getInstance() {
        if (instance == null) {
            instance = new ConnectionRepository();
        }
        return instance;
    }

    private ConnectionRepository() {
    }

    @Override
    public boolean checkConnection() {
        try {

            String url = Constants.API_LINK + "checkConnectionStability.php";
            Type type = new TypeToken<ServerResponse<Boolean>>() {
            }.getType();

//            System.out.println("URL is "+url);
            return new HttpRequests<Boolean>().sendGetRequest(url, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
            return false;
        }
    }

    @Override
    public LiveData<ServerResponse<Boolean>> testConnection() {
        //ONLINE REQUEST
        /*  try {
        String url = Constants.API_LINK + "checkConnectionStability.php";
        java.lang.reflect.Type type = new TypeToken<ServerResponse<Boolean>>() {
        }.getType();
        
        return new HttpRequestsEnqueue<Boolean>()
        .sendGetRequest(url, type);
        
        } catch (Exception ex) {
        Logger.getLogger(TestConfigtationsUI.class.getName()).log(Level.SEVERE, null, ex);
        //            MessageBox.showErrorMessage(ex.getMessage());
        ServerResponse<Boolean> response = new ServerResponse<>(0, ex.getMessage(), null);
        return new MutableLiveData<>(response);
        
        }*/

//         OFFLIBE
        try {
            Connection connectionInstance = LocalDatabaseConnection.getConnection();

            //        SQLiteUtils.createDevicesLocalDatabase(connectionInstance);
            SQLiteUtils.createDBTables(connectionInstance);

            ServerResponse<Boolean> response = new ServerResponse<>(connectionInstance.isClosed() ? 0 : 1, "Connected ", connectionInstance.isClosed() ? null : true);
            //            LocalDatabaseConnection.connect();
            return new MutableLiveData<>(response);
        } catch (Exception ex) {
            ServerResponse<Boolean> response = new ServerResponse<>(0, ex.getMessage(), null);
            return new MutableLiveData<>(response);
        }
    }

}
