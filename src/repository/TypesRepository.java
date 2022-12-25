/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.google.gson.reflect.TypeToken;
import data.local.db.connection.LocalDatabaseConnection;
import data.local.local_db_repos.TypesLocalRepository;
import data.local.queries_operations.BrandsLocalDbQueries;
import data.local.queries_operations.ResultSetParser;
import data.pojo.Brand;
import data.local.queries_operations.TypesLocalDbQueries;
import data.pojo.DeviceType;
import data.pojo.responses.ServerResponse;
import data.remote.HttpRequests;
import java.io.File;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import other.Constants;
import utils.Base64Utils;
import utils.MessageBox;

/**
 *
 * @author pc
 */
public class TypesRepository extends TypesLocalRepository implements TypesRepositoryImpl {

    private static TypesRepository instance;

    public synchronized static TypesRepository getInstance() {

        synchronized (TypesRepository.class) {
            if (instance == null) {
                synchronized (TypesRepository.class) {
                    instance = new TypesRepository();
                }
            }
        }

        return instance;
    }

    private TypesRepository() {
    }

    @Override
    public ArrayList<DeviceType> getAllTypes() {
        try {
//            String params = "models_ids="+Arrays.toString(modelsIds);
            String url = Constants.API_LINK + "Types/getAllTypes.php";
            Type type = new TypeToken<ServerResponse<ArrayList<DeviceType>>>() {
            }.getType();

//            System.out.println("URL is "+url);
            return new HttpRequests<ArrayList<DeviceType>>().sendGetRequest(url, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public boolean addNewType(String typeName) {
        try {
//            String params = "type_name="+Base64Utils.encode(typeName);  // encode to arabic
            String params = "type_name=" + Base64Utils.encode(typeName)
                    + "&image=";  // encode to arabic
//             RequestBody reqBody = RequestBody.create(MediaType.parse("images/*"), new File("C:\\Users\\pc\\Pictures\\Screenshots\\Screenshot (1).png"));

            String url = Constants.API_LINK + "Types/addNewType.php";
            Type type = new TypeToken<ServerResponse<Boolean>>() {
            }.getType();

//            System.out.println("URL is "+url);
            return new HttpRequests<Boolean>().sendPostRequest(url, params, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteType(int typeId) {
        try {
//            String params = "models_ids="+Arrays.toString(modelsIds);
            String url = Constants.API_LINK + "Types/deleteType.php"
                    + "?type_id=" + typeId;
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
    public boolean updateType(int typeId, String typeName) {
        try {

            String params = "type_name=" + Base64Utils.encode(typeName)
                    + "&type_id=" + typeId;
            String url = Constants.API_LINK + "Types/updateType.php";
            Type type = new TypeToken<ServerResponse<Boolean>>() {
            }.getType();

//            System.out.println("URL is "+url);
            return new HttpRequests<Boolean>().sendPostRequest(url, params, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<DeviceType> getAllLocalTypes() {

        TypesLocalDbQueries typesLocalDbQueries = null;
        Type type = new TypeToken<ArrayList<DeviceType>>() {
        }.getType();
        try {

            typesLocalDbQueries = new TypesLocalDbQueries(LocalDatabaseConnection.getConnection());
            PreparedStatement typesPrepareStatement = typesLocalDbQueries.getAllTypesPreparedStatment();
            ResultSet typesResultSet = typesPrepareStatement.executeQuery();

            ArrayList<DeviceType> types = new ResultSetParser<ArrayList<DeviceType>>().parseResultSet(typesResultSet, type);
            typesLocalDbQueries.destroy();
            typesLocalDbQueries = null;

            return types;
        } catch (Exception e) {

            typesLocalDbQueries.destroy();

            MessageBox.showErrorMessage(e.getMessage());
            return new ArrayList<>();
        }

    }

    @Override
    public boolean addNewLocalType(String type) {
        try {

            Connection connection = LocalDatabaseConnection.getConnection();
            PreparedStatement ps = new TypesLocalDbQueries(connection).getInsertNewTypePreparedStatment(type);
            boolean isInserted = !ps.execute();
            if (isInserted) {
                MessageBox.showMessage(" تم إضافة " + type + " بنجاح");
            }
            connection.close();

            return isInserted;
        } catch (Exception e) {

            String error = e.getMessage();
            if (error.contains(" is not unique")) {
                error = "اسم النوع (" + type + ") مضاف من قبل";
            }
            MessageBox.showErrorMessage(error);

            return false;
        }
    }

    public String addNewLocalType(Connection connection, String type) {
        try {

            PreparedStatement ps = new TypesLocalDbQueries(connection).getInsertNewTypePreparedStatment(type);
            boolean isInserted = !ps.execute();
            System.out.println("Type => " + type + " inserted !");
            return null;
        } catch (Exception e) {

            String error = e.getMessage();
//            if (error.contains(" is not unique")) {
//                error = "اسم النوع (" + type + ") مضاف من قبل";
//            }
//            MessageBox.showErrorMessage(error);

            return error;
        }
    }

    @Override
    public boolean deleteLocalType(int typeId) {

        try {

            Connection connection = LocalDatabaseConnection.getConnection();
            PreparedStatement ps = new TypesLocalDbQueries(connection).getDeleteTypePreparedStatment(typeId);
            boolean isDeleted = !ps.execute();
            if (isDeleted) {
                MessageBox.showMessage(" تم حذف النوع  بنجاح");
            }
            connection.close();
            System.gc();
            return isDeleted;
        } catch (Exception e) {

            String error = e.getMessage();

            MessageBox.showErrorMessage(error);

//            Logger.getLogger(Ty.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

    }

    @Override
    public boolean updateLocalType(int typeId, String typeName) {
        try {

            Connection connection = LocalDatabaseConnection.getConnection();
            PreparedStatement ps = new TypesLocalDbQueries(connection).getUpdateTypePreparedStatment(typeId, typeName);
            boolean isUpdated = !ps.execute();
            if (isUpdated) {
                MessageBox.showMessage(" تم تعديل " + typeName + " بنجاح");
            }
            connection.close();
            System.gc();
            return isUpdated;
        } catch (Exception e) {

            String error = e.getMessage();
            if (error.contains(" is not unique")) {
                error = "اسم النوع (" + typeName + ") مضاف من قبل";
            }
            MessageBox.showErrorMessage(error);

            return false;
        }

    }

    @Override
    public int getLocalTypeIdFromTypeName(String typeName) {
        TypesLocalDbQueries typeLocalDbQueries = null;
        Type type = new TypeToken<Integer>() {
        }.getType();
        try {

            typeLocalDbQueries = new TypesLocalDbQueries(LocalDatabaseConnection.getConnection());
            PreparedStatement typesPrepareStatement = typeLocalDbQueries.getTypeIdFromItsNamePreparedStatment(typeName);
            ResultSet typeResultSet = typesPrepareStatement.executeQuery();

            int brandId = new ResultSetParser<Integer>().parseResultSet(typeResultSet, type);
            typeLocalDbQueries.destroy();
            typeLocalDbQueries = null;

            return brandId;
        } catch (Exception e) {

            typeLocalDbQueries.destroy();

            MessageBox.showErrorMessage(e.getMessage());
            return -1;
        }

    }

    public DeviceType getLocalTypeFromTypeName(Connection connection, String typeName) {
        TypesLocalDbQueries typeLocalDbQueries = null;
        Type type = new TypeToken<Type>() {
        }.getType();
        try {

            typeLocalDbQueries = new TypesLocalDbQueries(connection);
            PreparedStatement typesPrepareStatement = typeLocalDbQueries.getTypeFromItsNamePreparedStatment(connection, typeName);
            ResultSet typeResultSet = typesPrepareStatement.executeQuery();
            DeviceType deviceType = null;
            while (typeResultSet.next()) {
                deviceType = new DeviceType(typeResultSet.getInt(1), typeResultSet.getString(2));
            }
//             = new ResultSetParser<DeviceType>().parseResultSet(typeResultSet, type);
            System.out.println("Type retuened is " + deviceType);
//            typeLocalDbQueries.destroy();
//            typeLocalDbQueries = null;

            return deviceType;
        } catch (Exception e) {

            System.out.println("Error in getLocalTypeFromTypeName()=> "+e);
//            typeLocalDbQueries.destroy();
//            MessageBox.showErrorMessage(e.getMessage());
            return null;
        }

    }

    ServerResponse<DeviceType> getLocalTypeOrInsert(Connection connection, String typeName) {
//         System.out.println("Try Department => "+department);
        DeviceType localType = getLocalTypeFromTypeName(connection, typeName);
        if (localType != null) {
            System.out.println("Dep returned " + localType.getTypeName());
            return new ServerResponse<>(1, "", localType);
        } else {
            String error = addNewLocalType(connection, typeName);
//            connection.commit();
            System.out.println("Error getLocalTypeOrInsert=> " + error);
            if (error == null) {
                System.out.println("Recursion => ");
                return getLocalTypeOrInsert(connection, typeName);
            } else {
                return new ServerResponse<>(0, error, null);
            }
        }
    }

}
