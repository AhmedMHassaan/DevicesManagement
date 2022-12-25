/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.google.gson.reflect.TypeToken;
import data.local.db.connection.LocalDatabaseConnection;
import data.local.local_db_repos.DepartmentsLocalRepository;
import data.local.queries_operations.DepartmentLocalDbQueries;
import data.local.queries_operations.ResultSetParser;
import data.pojo.Department;
import data.pojo.responses.ServerResponse;
import data.remote.HttpRequests;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import other.Constants;
import utils.Base64Utils;
import utils.MessageBox;

/**
 *
 * @author pc
 */
public class DepartmentsRepository extends DepartmentsLocalRepository implements DepartmentsRepositoryImpl {

    private static DepartmentsRepository instance;

    public synchronized static DepartmentsRepository getInstance() {

        synchronized (DepartmentsRepository.class) {
            if (instance == null) {
                synchronized (DepartmentsRepository.class) {
                    instance = new DepartmentsRepository();
                }
            }
        }

        return instance;
    }

    private DepartmentsRepository() {
    }

    @Override
    public ArrayList<Department> getAllDepartments() {
        // ONLINE:

        try {
//            String params = "models_ids="+Arrays.toString(modelsIds);
            String url = Constants.API_LINK + "Departments/getAllDepartments.php";
            Type type = new TypeToken<ServerResponse<ArrayList<Department>>>() {
            }.getType();

//            System.out.println("URL is "+url);
            return new HttpRequests<ArrayList<Department>>().sendGetRequest(url, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
            return new ArrayList<>();
        }

    }

    @Override
    public boolean addNewDepartment(String department) {
        try {
            String params = "department_name=" + Base64Utils.encode(department);  // encode to arabic
            String url = Constants.API_LINK + "Departments/addNewDepartment.php";
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
    public boolean deleteDepartment(int departmentId) {
        try {
//            String params = "models_ids="+Arrays.toString(modelsIds);
            String url = Constants.API_LINK + "Departments/deleteDepartment.php"
                    + "?dep_id=" + departmentId;
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
    public boolean updateDepartment(int departmentId, String departmentName) {
        try {

            String params = "department_name=" + Base64Utils.encode(departmentName)
                    + "&department_id=" + departmentId;
            String url = Constants.API_LINK + "Departments/updateDepartment.php";
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
    public ArrayList<Department> getAllLocalDepartments() {
        return getAllLocalDepartments(new int[]{}, "");
    }

    @Override
    public ArrayList<Department> getAllLocalDepartments(int[] depsIds, String department) {
        DepartmentLocalDbQueries departmentLocalDbQueries = null;
        Type type = new TypeToken<ArrayList<Department>>() {
        }.getType();
        try {

            departmentLocalDbQueries = new DepartmentLocalDbQueries(LocalDatabaseConnection.getConnection());
            PreparedStatement depStatmnt = departmentLocalDbQueries.getAllDepartmentSqlStatement(depsIds, department);
            ResultSet depsResultSet = depStatmnt.executeQuery();

            ArrayList<Department> deps = new ResultSetParser<ArrayList<Department>>().parseResultSet(depsResultSet, type);
            departmentLocalDbQueries.destroy();

            return deps;
        } catch (Exception e) {

            departmentLocalDbQueries.destroy();

            MessageBox.showErrorMessage(e.getMessage());
            return new ArrayList<>();
        }
    }

    public ArrayList<Department> getAllLocalDepartments(int[] depsIds) {
        return getAllLocalDepartments(depsIds, "");
    }

    @Override
    public boolean addNewLocalDepartment(String department) {

        return addNewLocalDepartment(department, true);
    }

    public boolean addNewLocalDepartment(String department, boolean showAlertMessage) {
        try {
            Connection connection = LocalDatabaseConnection.getConnection();
//            String sql = "INSERT INTO `departments` (`dep_id`, `department`) VALUES (NULL, ? )";

//            System.out.println("Sql is => "+sql);
//            Class<?> forName = Class.forName("org.sqlite.JDBC");
//        connection = DriverManager.getConnection("jdbc:sqlite:nozom_devices.db");
//            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + Constants.LOCAL_DATABASE_NAME);
//            System.out.println("Get connection and it is => " + connection);
//            Statement createStatement = connection.createStatement();
//            boolean executed = connection.createStatement().execute(sql);
            PreparedStatement ps = new DepartmentLocalDbQueries(connection).getInsertNewDepartmentPreparedStatement(department);
//            ps.set(1, 1);

//            System.out.println("Get Statment and it is => "+createStatement);
            Boolean executeUpdate = ps.execute();
            connection.close();
//            System.out.println("Executed ? " + executeUpdate);

            return !executeUpdate;
        } catch (Exception e) {

            String error = e.getMessage();
            if (error.contains(" is not unique")) {
                error = "اسم الفرع مضاف من قبل";
            }
            if (showAlertMessage) {
                MessageBox.showErrorMessage(error);
            }

            Logger.getLogger(DepartmentsRepository.class.getName()).log(Level.SEVERE, null, e);

            return false;
        }
    }

    public String addNewLocalDepartment(Connection connection, String department) {

        try {

//            System.out.println("Con => "+connection);
            PreparedStatement ps = new DepartmentLocalDbQueries(connection).getInsertNewDepartmentPreparedStatement(department);

//            System.out.println("Ps is null ?"+ps);
            Boolean executeUpdate = ps.execute();
            return null;
        } catch (Exception e) {

            String error = e.getMessage();
//            if (error.contains(" is not unique")) {
//                error = "اسم الفرع مضاف من قبل";
//            }
//            if (showAlertMessage) {
//                MessageBox.showErrorMessage(error);
//            }

            Logger.getLogger(DepartmentsRepository.class.getName()).log(Level.SEVERE, null, e);

            return e.getMessage();
        }
    }

    @Override
    public boolean deleteLocalDepartment(int departmentId) {

        try {

            Connection connection = LocalDatabaseConnection.getConnection();

            PreparedStatement ps = new DepartmentLocalDbQueries(connection).getDeleteDepartmentPreparedStatement(departmentId);

            boolean thereISError = ps.execute();
            connection.close();
            connection = null;

            return !thereISError;
        } catch (Exception e) {

            String error = e.getMessage();
//            if (error.contains(" is not unique")) {
//                error = "اسم الفرع مضاف من قبل";
//            }
            MessageBox.showErrorMessage(error);

            Logger.getLogger(DepartmentsRepository.class.getName()).log(Level.SEVERE, null, e);

            return false;
        }
    }

    @Override
    public boolean updateLocalDepartment(int departmentId, String departmentName) {
        try {

            Connection connection = LocalDatabaseConnection.getConnection();

            PreparedStatement ps = new DepartmentLocalDbQueries(connection).getUpdateDepartmentPreparedStatement(departmentId, departmentName);

            boolean thereISError = ps.execute();

            return !thereISError;
        } catch (Exception e) {

            String error = e.getMessage();
            if (error.contains(" is not unique")) {
                error = "اسم الفرع مضاف من قبل";
            }
            MessageBox.showErrorMessage(error);

            Logger.getLogger(DepartmentsRepository.class.getName()).log(Level.SEVERE, null, e);

            return false;
        }
    }

    public ServerResponse<Department> getDepartmentOrInsert(Connection connection, String department) throws Exception {
        System.out.println("Try Department => " + department);
        Department localDepartment = getDepartmentByName(connection, department);
        if (localDepartment != null) {
            System.out.println("Dep returned " + localDepartment.getDepartmentName());
            return new ServerResponse<>(1, "", localDepartment);
        } else {
            String error = addNewLocalDepartment(connection, department);
//            connection.commit();
            System.out.println("Error => " + error);
            if (error == null) {
                System.out.println("Recursion => ");
                return getDepartmentOrInsert(connection, department);
            } else {
                return new ServerResponse<>(0, error, null);
            }
        }
    }

    private Department getDepartmentByName(Connection connection, String department) {
        DepartmentLocalDbQueries departmentLocalDbQueries = null;
        Type type = new TypeToken<ArrayList<Department>>() {
        }.getType();
        try {

            departmentLocalDbQueries = new DepartmentLocalDbQueries(connection);
            PreparedStatement depStatmnt = departmentLocalDbQueries.getDepartmentByName(department);
            ResultSet depsResultSet = depStatmnt.executeQuery();

            ArrayList<Department> deps = new ResultSetParser<ArrayList<Department>>().parseResultSet(depsResultSet, type);
//            departmentLocalDbQueries.destroy();

            System.out.println("deps => "+deps);
            if (deps != null && deps.size() > 0) {
                return deps.get(0);
            } else {
                return null;
            }
//            return deps;
        } catch (Exception e) {

//            departmentLocalDbQueries.destroy();
            System.out.println("Error in getDep by Name => "+e);
//            MessageBox.showErrorMessage(e.getMessage());
            return null;
        }
    }

}
