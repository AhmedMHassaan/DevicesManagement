/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.local.db.connection.LocalDatabaseConnection;
import data.local.local_db_repos.ModelsLocalRepository;
import data.local.queries_operations.BrandsLocalDbQueries;
import data.local.queries_operations.ModelsLocalDbQueries;
import data.local.queries_operations.ResultSetParser;
import data.local.queries_operations.TypesLocalDbQueries;
import data.pojo.Brand;
import data.pojo.Department;
import data.pojo.DeviceType;
import data.pojo.Model;
import data.pojo.responses.ServerResponse;
import data.remote.HttpRequests;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.ArrayList;
import other.Constants;
import utils.Base64Utils;
import utils.MessageBox;

/**
 *
 * @author pc
 */
public class ModelsRepository extends ModelsLocalRepository implements ModelsRepositoryImpl {

    private static ModelsRepository instance;

    public synchronized static ModelsRepository getInstance() {

        synchronized (ModelsRepository.class) {
            if (instance == null) {
                synchronized (ModelsRepository.class) {
                    instance = new ModelsRepository();
                }
            }
        }

        return instance;
    }

    private ModelsRepository() {
    }

    @Override
    public ArrayList<Model> getAllModels(boolean forceToShowCountMessage, String modelName, String departmentName) {
        try {
            String url = Constants.API_LINK + "Models/getAllModels.php?model_name=" + modelName
                    + "&dep_name=" + departmentName
                    + "&forceToShowMessages=" + forceToShowCountMessage;
            Type type = new TypeToken<ServerResponse<ArrayList<Model>>>() {
            }.getType();
            return new HttpRequests<ArrayList<Model>>().sendGetRequest(url, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
            return new ArrayList<>();
        }
    }

    public ArrayList<Model> getAllModels(String modelName, String departmentName) {
        try {
            String url = Constants.API_LINK + "Models/getAllModels.php?model_name=" + modelName
                    + "&dep_name=" + departmentName
                    + "&forceToShowMessages=" + true;
            ;
            Type type = new TypeToken<ServerResponse<ArrayList<Model>>>() {
            }.getType();
            return new HttpRequests<ArrayList<Model>>().sendGetRequest(url, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
            return new ArrayList<>();
        }
    }

    public ArrayList<Model> getAllModels(boolean forceToShowCountMessage) {
        try {
            String url = Constants.API_LINK + "Models/getAllModels.php?model_name=" + ""
                    + "&dep_name=" + ""
                    + "&forceToShowMessages=" + forceToShowCountMessage;
            ;
            Type type = new TypeToken<ServerResponse<ArrayList<Model>>>() {
            }.getType();
            return new HttpRequests<ArrayList<Model>>().sendGetRequest(url, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public boolean addNewModel(Model model) {
        try {
            String url = Constants.API_LINK + "Models/addNewModel.php";
            String encodedModel = Base64Utils.encode(new Gson().toJson(model));
//            String params = new Gson().toJson(model);
            Type type = new TypeToken<ServerResponse<Boolean>>() {
            }.getType();
            return new HttpRequests<Boolean>().sendPostRequest(url, encodedModel, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteModel(int modelId) {
        try {
            String url = Constants.API_LINK + "Models/deleteModel.php?model_id=" + modelId;
            Type type = new TypeToken<ServerResponse<Boolean>>() {
            }.getType();
            return new HttpRequests<Boolean>().sendGetRequest(url, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateModel(Model model) {
        try {
            String url = Constants.API_LINK + "Models/updateModel.php";
//            String params = new Gson().toJson(model);
            String encodedModel = Base64Utils.encode(new Gson().toJson(model));

            Type type = new TypeToken<ServerResponse<Boolean>>() {
            }.getType();
            return new HttpRequests<Boolean>().sendPostRequest(url, encodedModel, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Model> getAllLocalModels(String modelName, String departmentName, int[] modelsIds) {
        ModelsLocalDbQueries dbQueries = null;
        Type type = new TypeToken<ArrayList<Model>>() {
        }.getType();
        try {

            dbQueries = new ModelsLocalDbQueries(LocalDatabaseConnection.getConnection());
            PreparedStatement prepareStatement = dbQueries.getAllModelsPreparedStatment(departmentName, modelName, modelsIds);
            ResultSet resultSet = prepareStatement.executeQuery();

            ArrayList<Model> models = new ResultSetParser<ArrayList<Model>>().parseResultSet(resultSet, type);
            dbQueries.destroy();
            dbQueries = null;

            return models;
        } catch (Exception e) {

            dbQueries.destroy();

            MessageBox.showErrorMessage(e.getMessage());
            return new ArrayList<>();
        }
    }

    public ArrayList<Model> getAllLocalModels(String modelName, String departmentName) {
        ModelsLocalDbQueries dbQueries = null;
        Type type = new TypeToken<ArrayList<Model>>() {
        }.getType();
        try {

            dbQueries = new ModelsLocalDbQueries(LocalDatabaseConnection.getConnection());
            PreparedStatement prepareStatement = dbQueries.getAllModelsPreparedStatment(departmentName, modelName, new int[]{});
            ResultSet resultSet = prepareStatement.executeQuery();

            ArrayList<Model> models = new ResultSetParser<ArrayList<Model>>().parseResultSet(resultSet, type);
            dbQueries.destroy();
            dbQueries = null;

            return models;
        } catch (Exception e) {

            dbQueries.destroy();

            MessageBox.showErrorMessage(e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public boolean addNewLocalModel(Model model) {
        return addNewLocalModel(model, true);

    }

    public boolean addNewLocalModel(Model model, boolean showAlertMsgs) {
        try {

            Connection connection = LocalDatabaseConnection.getConnection();
            PreparedStatement ps = new ModelsLocalDbQueries(connection).getInsertNewModelPreparedStatment(model);
//            String sql = "INSERT INTO `devices_models` (`model_id`, `brand_id`,`type_id`, `model`) VALUES  (NULL, '" + model.getBrandId() + "' , '" + model.getTypeId() + "', '" + model.getModelName() + "' )";
//            Statement statment = new ModelsLocalDbQueries(connection).getInsertNewModelPreparedStatment(model);
//            connection.commit();

            boolean isInserted = !ps.execute();
//            int executedUpdate = ps.executeUpdate();
//            int executedUpdate = statment.executeUpdate(sql);
//            String errorMsg = ;
//             System.out.println("e.message = "+connection.getWarnings());
//            int updatedCount = statment.getMaxRows();
//            int row = ps.executeUpdate();
//            ps.execute();
//            ps.close();
//            System.out.println("Warnings => ");ps.getWarnings();

//            System.out.println("Ex=> " + row + " //\\ " + ps.getUpdateCount() + " ** " );
//            int updatedCount = ps.getUpdateCount();
//            System.out.println("Inserted Rows  => " + row);
            if (isInserted) {
                if (showAlertMsgs) {

                    MessageBox.showMessage(" تم إضافة " + model.getModelName() + " بنجاح");
                }
            }
            connection.close();

            return isInserted;
        } catch (Exception e) {

            String error = e.getMessage();
            if (error.contains(" is not unique")) {
                error = "بيانات الموديل مضافة من قبل";
            }
            if (showAlertMsgs) {

                MessageBox.showErrorMessage(error);
            }

            return false;
        }
    }

    public String addNewLocalModel(Connection connection, Model model) {
        try {

            PreparedStatement ps = new ModelsLocalDbQueries(connection).getInsertNewModelPreparedStatment(model);

            boolean isInserted = !ps.execute();

            return null;
        } catch (Exception e) {

            String error = e.getMessage();
//            if (error.contains(" is not unique")) {
//                error = "بيانات الموديل مضافة من قبل";
//            }

            return error;
        }
    }

    @Override
    public boolean deleteLocalModel(int modelId) {
        try {

            Connection connection = LocalDatabaseConnection.getConnection();
            PreparedStatement ps = new ModelsLocalDbQueries(connection).getDeleteModelPreparedStatment(modelId);
            boolean isDeleted = !ps.execute();
            if (isDeleted) {
                MessageBox.showMessage(" تم حذف الموديل  بنجاح");
            }
            connection.close();
            System.gc();
            return isDeleted;
        } catch (Exception e) {

            String error = e.getMessage();
//            if (error.contains(" is not unique")) {
//                error = "اسم النوع (" + typeName + ") مضاف من قبل";
//            }
            MessageBox.showErrorMessage(error);

            return false;
        }

    }

    @Override
    public boolean updateLocalModel(Model model) {
        try {

            Connection connection = LocalDatabaseConnection.getConnection();
            PreparedStatement ps = new ModelsLocalDbQueries(connection).getUpdateModelPreparedStatment(model);
            boolean isUpdated = !ps.execute();
            if (isUpdated) {
                MessageBox.showMessage(" تم تعديل " + model.getModelName() + " بنجاح");
            }
            connection.close();
            System.gc();
            return isUpdated;
        } catch (Exception e) {

            String error = e.getMessage();
//            if (error.contains(" is not unique")) {
//                error = "اسم النوع (" + typeName + ") مضاف من قبل";
//            }
            MessageBox.showErrorMessage(error);

            return false;
        }
    }

    public Model getModelFromItsName(Connection connection, String modelName) {
        ModelsLocalDbQueries modelsLocalDbQueries = null;

        try {

            modelsLocalDbQueries = new ModelsLocalDbQueries(connection);
            PreparedStatement brandsPrepareStatement = modelsLocalDbQueries.getModelIdFromItsNamePreparedStatment(modelName);
            ResultSet modelResultSet = brandsPrepareStatement.executeQuery();

//            Brand brand = new ResultSetParser<Brand>().parseResultSet(brandResultSet, type);
            Model model = null;
            while (modelResultSet.next()) {
                int modelId = modelResultSet.getInt(1);
                int brandId = modelResultSet.getInt(2);
                int typeId = modelResultSet.getInt(3);
                String name = modelResultSet.getString(4);
                model = new Model(modelId, brandId, name, typeId);

            }

//            modelsLocalDbQueries.destroy();
//            modelsLocalDbQueries = null;
//            System.gc();
            return model;
        } catch (Exception e) {

//            modelsLocalDbQueries.destroy();
            System.out.println("Error in models => " + e.getMessage());
//            MessageBox.showErrorMessage(e.getMessage());
            return null;
        }
    }

    ServerResponse<Model> getLocalModelIdOrInsert(Connection connection, Model modelToBeAdded) throws Exception {
        Model model = getModelFromItsName(connection, modelToBeAdded.getModelName());
        if (model != null) {
            return new ServerResponse<>(1, "", model);
        } else {
            String error = addNewLocalModel(connection, modelToBeAdded);
            if (error == null) {
//                connection.commit();
                return getLocalModelIdOrInsert(connection, modelToBeAdded);
            } else {
                return new ServerResponse<>(error);
            }
        }
    }

}
