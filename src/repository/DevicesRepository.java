/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.local.db.connection.LocalDatabaseConnection;
import data.local.local_db_repos.DevicesLocalRepository;
import data.local.queries_operations.DevicesLocalDbQueries;
import data.local.queries_operations.ModelsLocalDbQueries;
import data.local.queries_operations.ResultSetParser;
import data.pojo.Brand;
import data.pojo.Department;
import data.pojo.Device;
import data.pojo.DeviceSearchFields;
import data.pojo.DeviceTransaction;
import data.pojo.DeviceType;
import data.pojo.DeviceUpload;
import data.pojo.Model;
import data.pojo.UploadingStatus;
import data.pojo.responses.DeviceTransactionResponse;
import data.pojo.responses.ReportResponse;
import data.pojo.responses.ReportRow;
import data.pojo.responses.ServerResponse;
import data.remote.HttpRequests;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import other.Constants;
import ui.reports.DevicesReportUI;
import uis_items.CustomProgressDialog;
import utils.Base64Utils;
import utils.MessageBox;

/**
 *
 * @author pc
 */
public class DevicesRepository extends DevicesLocalRepository implements DevicesRepositoryImpl {

    private static DevicesRepository instance;
    private ModelsRepository modelsRepository;
    private DepartmentsRepository departmentsRepository;

    public synchronized static DevicesRepository getInstance(ModelsRepository _modelsRepo, DepartmentsRepository _depsRepo) {

        synchronized (DevicesRepository.class) {
            if (instance == null) {
                synchronized (DevicesRepository.class) {
                    instance = new DevicesRepository(_modelsRepo, _depsRepo);
                }
            }
            instance.modelsRepository = _modelsRepo;
            instance.departmentsRepository = _depsRepo;
        }

        return instance;
    }

    public synchronized static DevicesRepository getInstance() {

        return getInstance(ModelsRepository.getInstance(), DepartmentsRepository.getInstance());
    }

    private DevicesRepository(ModelsRepository _modelsRepo, DepartmentsRepository _depsRepo) {
        this.departmentsRepository = _depsRepo;
        this.modelsRepository = _modelsRepo;
    }

    @Override
    public ReportResponse getDevicesReport() {
        return getDevicesReport(new int[]{}, new int[]{});
    }

    @Override
    public ReportResponse getDevicesReport(int[] depsIDs, int[] modelsIds) {
        try {
            String params = "models_ids=" + Arrays.toString(modelsIds)
                    + "&deps_ids=" + Arrays.toString(depsIDs);
            String url = Constants.API_LINK + "Devices/getDevicesReport.php";
            Type type = new TypeToken<ServerResponse<ReportResponse>>() {
            }.getType();

//            System.out.println("URL is "+url);
            return new HttpRequests<ReportResponse>().sendPostRequest(url, params, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<Device> getAllDevices(DeviceSearchFields deviceSearch) {
        try {

            String params = Base64Utils.encode(new Gson().toJson(deviceSearch));
//            String url = Constants.API_LINK + "Devices/getAllDevices.php?serial="+serialNumber+"&depId="+depId;
            String url = Constants.API_LINK + "Devices/getAllDevices.php";
            Type type = new TypeToken<ServerResponse<ArrayList<Device>>>() {
            }.getType();

//            System.out.println("URL is "+url);
//            return new HttpRequests<ArrayList<Device>>().sendGetRequest(url,type);
            return new HttpRequests<ArrayList<Device>>().sendPostRequest(url, params, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public boolean insertDevice(Device device) {
        try {

            String encodedParams = Base64Utils.encode(new Gson().toJson(device));
            String url = Constants.API_LINK + "Devices/addNewDevice.php";
            Type type = new TypeToken<ServerResponse<Boolean>>() {
            }.getType();

//            System.out.println("URL is "+url);
            return new HttpRequests<Boolean>().sendPostRequest(url, encodedParams, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateDevice(Device device) {
        try {

            String params = new Gson().toJson(device);
            String url = Constants.API_LINK + "Devices/updateDevice.php";
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
    public boolean moveDeviceToAnotherDepartment(DeviceTransaction transaction) {
        try {

            String params = Base64Utils.encode(new Gson().toJson(transaction));
            String url = Constants.API_LINK + "Devices/moveDeviceToAnotherDep.php";
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
    public ArrayList<DeviceTransactionResponse> getAllDevicesTransactions() {

        return getTransactions(0);

    }

    @Override
    public ArrayList<DeviceTransactionResponse> getDeviceTransactions(int deviceId) {
        return getTransactions(deviceId);
    }

    private ArrayList<DeviceTransactionResponse> getTransactions(int deviceId) {
        try {

            String url = Constants.API_LINK + "Devices/getAllDevicesTransactions.php?deviceId=" + deviceId;
            Type type = new TypeToken<ServerResponse<ArrayList<DeviceTransactionResponse>>>() {
            }.getType();

//            System.out.println("URL is "+url);
            return new HttpRequests<ArrayList<DeviceTransactionResponse>>().sendGetRequest(url, type, false);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public boolean deleteSelectedDevices(int[] selectedIDs) {
        try {

            String url = Constants.API_LINK + "Devices/deleteDevice.php";
            String params = "devices_ids=" + Arrays.toString(selectedIDs);
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
    public ArrayList<DeviceUpload> checkDevicesForUploading(ArrayList<DeviceUpload> devicesToUpload, int checkingType) {
        try {

            String url = Constants.API_LINK + "Devices/checkDevicesForUploading.php";
            String params = "devices=" + Base64Utils.encode(new Gson().toJson(devicesToUpload)) + "&checkType=" + checkingType;
//            Type type = new TypeToken<ServerResponse<Boolean>>() {
            Type type = new TypeToken<ServerResponse<ArrayList<DeviceUpload>>>() {
            }.getType();

//            System.out.println("URL is "+url);
//            return new HttpRequests<Boolean>().sendPostRequest(url, params, type);
            return new HttpRequests<ArrayList<DeviceUpload>>().sendPostRequest(url, params, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
//            return false;
            return new ArrayList<>();
        }
    }

    @Override
    public ArrayList<DeviceUpload> uploadDevicesToDatabase(ArrayList<DeviceUpload> devicesToUpload, int checkingType) {
        try {

            String url = Constants.API_LINK + "Devices/uploadDevices.php";
            String params = "devices=" + Base64Utils.encode(new Gson().toJson(devicesToUpload)) + "&checkType=" + checkingType;
            Type type = new TypeToken<ServerResponse<ArrayList<DeviceUpload>>>() {
            }.getType();

//            System.out.println("URL is "+url);
//            return new HttpRequests<Boolean>().sendPostRequest(url, params, type);
            return new HttpRequests<ArrayList<DeviceUpload>>().sendPostRequest(url, params, type);

        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
//            return false;
            return new ArrayList<>();
        }
    }

    @Override
    public ReportResponse getLocalDevicesReport() {
        return getLocalDevicesReport(new int[]{}, new int[]{});
    }

    @Override
    public ReportResponse getLocalDevicesReport(int[] depsIDs, int[] modelsIds) {

        ReportResponse reportResponse = new ReportResponse();
        DevicesLocalDbQueries dbDevicesQueries = null;
        ModelsLocalDbQueries dbModelsQueries = null;

        try {

            Connection connection = LocalDatabaseConnection.getConnection();
            dbDevicesQueries = new DevicesLocalDbQueries(connection);
            dbModelsQueries = new ModelsLocalDbQueries(connection);
            ArrayList<ReportRow> rows = new ArrayList<>();

            //            dbModelsQueries.getAllM
//            PreparedStatement prepareStatement = dbModelsQueries.getAllModelsPreparedStatment(departmentName, modelName, new int[]{});
            ArrayList<Model> allLocalModels = modelsRepository.getAllLocalModels("", "", modelsIds);
            ArrayList<Department> allLocalDepartments = departmentsRepository.getAllLocalDepartments(depsIDs);

            ArrayList<Model> tableHeader = new ArrayList<>();
            tableHeader.add(new Model("المكان/ النوع"));
            tableHeader.addAll(allLocalModels);
            tableHeader.add(new Model("مج أجهزة الفرع"));

// depName with list of models
            HashMap<String, Integer> modelNameWithItsDevicesCounts = new HashMap<>();
//            HashMap<String,ArrayList<Model>> depNamesWithModelsList = new HashMap<>();

            for (int depsIndex = 0; depsIndex < allLocalDepartments.size(); depsIndex++) {
                ReportRow row = new ReportRow();
                Department department = allLocalDepartments.get(depsIndex);
//                ArrayList<Model> modelsByDeps = depNamesWithModelsList.getOrDefault(department.getDepartmentName(), new ArrayList<>());
//                modelsByDeps.add(e)
//                ArrayList<Integer> modelsCountValues = new ArrayList<>();
                int[] modelsCountValues = new int[allLocalModels.size() + 1];
                int devicesSumForEachDepartment = 0;
                for (int modelsLoopIndex = 0; modelsLoopIndex < allLocalModels.size(); modelsLoopIndex++) {
                    Model model = allLocalModels.get(modelsLoopIndex);
                    ArrayList<Model> selectedModelByDepNameAndModelName = modelsRepository.getAllLocalModels(model.getModelName(), department.getDepartmentName());
                    int devicesCount = 0;
                    if (selectedModelByDepNameAndModelName != null && selectedModelByDepNameAndModelName.size() > 0) {
                        devicesCount = selectedModelByDepNameAndModelName.get(0).getDevicesCountInModel();
                        devicesSumForEachDepartment += devicesCount;
//                        modelsCountValues.add(devicesCount);
                        modelsCountValues[modelsLoopIndex] = devicesCount;

                        Integer devicesCountInModel = modelNameWithItsDevicesCounts.getOrDefault(model.getModelName(), 0);
                        modelNameWithItsDevicesCounts.put(model.getModelName(), (devicesCountInModel + devicesCount));

                    }
                    if (isLastItemInArray(modelsLoopIndex, allLocalModels)) {
//                            modelsCountValues.add(devicesSumForEachDepartment);
                        modelsCountValues[allLocalModels.size()] = devicesSumForEachDepartment;
                        devicesSumForEachDepartment = 0;

                    }

                }

                row.setDepartmentName(department.getDepartmentName());

                row.setModelsValues(modelsCountValues);
                rows.add(row);
//                System.out.println("Row is " + department.getDepartmentName() + " => " + Arrays.toString(modelsCountValues));

            }

            int[] sumOfDevicesModelsValues = new int[allLocalModels.size() + 1];
            int index = 0;
            int allDevicesSum = 0;

            for (Model model : allLocalModels) {
                int count = modelNameWithItsDevicesCounts.getOrDefault(model.getModelName(), 0);
                sumOfDevicesModelsValues[index] = count;
                allDevicesSum += count;
                index++;
            }
            System.out.println("models size => " + allLocalModels.size() + " , headersize => " + tableHeader.size() + " , vsum values size=> " + sumOfDevicesModelsValues.length);
            sumOfDevicesModelsValues[index] = allDevicesSum;
            rows.add(new ReportRow("المجموع", sumOfDevicesModelsValues));
            System.out.println("Row is المجموع => " + Arrays.toString(sumOfDevicesModelsValues));

            reportResponse.setTableRows(rows);

            reportResponse.setTableHeader(tableHeader);

            dbDevicesQueries.destroy();

            dbModelsQueries.destroy();
            dbModelsQueries = null;

//            return re;
        } catch (Exception e) {

            dbDevicesQueries.destroy();

            MessageBox.showErrorMessage(e.getMessage());
            Logger.getLogger(DevicesRepository.class.getName()).log(Level.SEVERE, null, e);
        }
        return reportResponse;
    }

    @Override
    public ArrayList<Device> getAllLocalDevices(DeviceSearchFields deviceSearch) {
        DevicesLocalDbQueries devicesLocalDbQueries = null;

        try {

            devicesLocalDbQueries = new DevicesLocalDbQueries(LocalDatabaseConnection.getConnection());
            PreparedStatement devicesPreparedStatment = devicesLocalDbQueries.getAllDevicesPrepStatment(deviceSearch);
            ResultSet devicesResultSet = devicesPreparedStatment.executeQuery();

//            ArrayList<Device> devices = new ResultSetParser<ArrayList<Device>>().parseResultSet(devicesResultSet, type);
            ArrayList<Device> devices = new ArrayList<>();
            while (devicesResultSet.next()) {

                int modelIdColIndex = 10;
                int brandIdColIndex = 11;
                int typesIdColIndex = 12;
                Device device = new Device(
                        devicesResultSet.getInt("id"),
                        devicesResultSet.getString("serial_number"),
                        devicesResultSet.getString("name"),
                        devicesResultSet.getString("adding_timestamp")
                );

                device.setCurrentDepartment(new Department(
                        devicesResultSet.getInt("current_department_id"),
                        devicesResultSet.getString("current_department")
                ));

                device.setModel(new Model(
                        devicesResultSet.getInt(modelIdColIndex),
                        devicesResultSet.getInt(brandIdColIndex),
                        devicesResultSet.getString("model"),
                        devicesResultSet.getString("brand"),
                        devicesResultSet.getInt(12)
                ));

                device.setType(new DeviceType(
                        devicesResultSet.getInt(typesIdColIndex),
                        devicesResultSet.getString("type")
                ));

                device.setBrand(new Brand(
                        devicesResultSet.getInt(brandIdColIndex),
                        devicesResultSet.getString("brand")
                ));

//                System.out.println("Device => " + device);
                devices.add(device);
            }
            devicesLocalDbQueries.destroy();
            devicesLocalDbQueries = null;

            return devices;
        } catch (Exception e) {

            if (devicesLocalDbQueries != null) {
                devicesLocalDbQueries.destroy();
            }

            Logger.getLogger(DevicesRepository.class.getName()).log(Level.SEVERE, null, e);
            MessageBox.showErrorMessage(e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public ArrayList<DeviceTransactionResponse> getAllLocalDevicesTransactions() {
        return getDeviceTransactions(-1);
    }

    @Override
    public ArrayList<DeviceTransactionResponse> getLocalDeviceTransactions(int deviceId) {
        return getLocalDeviceTransactions(new DeviceTransactionResponse(deviceId), false);
    }

    public ArrayList<DeviceTransactionResponse> getLocalDeviceTransactions(DeviceTransactionResponse filter) {
        return getLocalDeviceTransactions(filter, false);
    }

    public ArrayList<DeviceTransactionResponse> getLocalDeviceTransactions(DeviceTransactionResponse filter, boolean justTopOne) {
        DevicesLocalDbQueries devicesLocalDbQueries = null;

        try {

            devicesLocalDbQueries = new DevicesLocalDbQueries(LocalDatabaseConnection.getConnection());
            PreparedStatement devicesPreparedStatment = devicesLocalDbQueries.getAllTransactionsPrepStatment(filter, justTopOne);
            ResultSet devicesResultSet = devicesPreparedStatment.executeQuery();

//            ArrayList<Device> devices = new ResultSetParser<ArrayList<Device>>().parseResultSet(devicesResultSet, type);
            ArrayList<DeviceTransactionResponse> devicesTransactions = new ArrayList<>();
            while (devicesResultSet.next()) {

                int modelIdColIndex = 17;
                int brandIdColIndex = 18;
                int typesIdColIndex = 19;
                int currentDepIdColIndex = 3;
                int distDepIdColIndex = 4;

                Device device = new Device(
                        devicesResultSet.getInt("id"),
                        devicesResultSet.getString("serial_number"),
                        devicesResultSet.getString("name"),
                        devicesResultSet.getString("adding_timestamp")
                );

                Department newDep = new Department(
                        devicesResultSet.getInt(distDepIdColIndex),
                        devicesResultSet.getString("distination_department_name")
                );
                Department oldDep = new Department(
                        devicesResultSet.getInt(currentDepIdColIndex),
                        devicesResultSet.getString("old_department")
                );

                device.setCurrentDepartment(newDep);

                Model model = new Model(
                        devicesResultSet.getInt(modelIdColIndex),
                        devicesResultSet.getInt(brandIdColIndex),
                        devicesResultSet.getString("model"),
                        devicesResultSet.getString("brand"),
                        devicesResultSet.getInt(typesIdColIndex)
                );

                Brand brand = new Brand(
                        devicesResultSet.getInt(brandIdColIndex),
                        devicesResultSet.getString("brand")
                );

                DeviceType deviceType = new DeviceType(
                        devicesResultSet.getInt(typesIdColIndex),
                        devicesResultSet.getString("type")
                );

                device.setModel(model);

                device.setType(deviceType);

                device.setBrand(brand);

                DeviceTransactionResponse trans = new DeviceTransactionResponse(
                        devicesResultSet.getInt("trans_id"),
                        device,
                        devicesResultSet.getString("receiver_name"),
                        devicesResultSet.getString("sender_name"),
                        devicesResultSet.getString("trans_timestamp"),
                        devicesResultSet.getString("transaction_reason"),
                        oldDep,
                        newDep
                );

                devicesTransactions.add(trans);
            }

            devicesLocalDbQueries.destroy();
            devicesLocalDbQueries = null;

            return devicesTransactions;
        } catch (Exception e) {

            if (devicesLocalDbQueries != null) {
                devicesLocalDbQueries.destroy();
            }

            Logger.getLogger(DevicesRepository.class.getName()).log(Level.SEVERE, null, e);
            MessageBox.showErrorMessage(e.getMessage());
            return new ArrayList<>();
        }
    }

    public DeviceTransactionResponse getLastTransitionOperation() {
        ArrayList<DeviceTransactionResponse> allLocalTransitions = getLocalDeviceTransactions(null, true);
        if (allLocalTransitions.size() > 0) {
            return allLocalTransitions.get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean moveLocalDeviceToAnotherDepartment(DeviceTransaction transaction) {
        Connection connection = null;
        try {
            connection = LocalDatabaseConnection.getConnection();
            if (transaction.getDeviceId() == 0) {
                throw new Exception("يرجي تحديد الجهاز أولا");
            }

            if (transaction.getCurrentDepartmentId() == 0) {
                throw new Exception("يرجي تحديد الفرع / القسم أولا");
            }

            if (transaction.getDistinationDepartmentId() == 0) {
                throw new Exception("يرجي تحديد الفرع / القسم أولا");
            }
            if (transaction.getDeviceNewName().isEmpty()) {
                throw new Exception("يرجي إرسال اسم الجهاز الجديد بعد نقله إلي القسم الجديد");
            }

            if (transaction.getSender().isEmpty()) {
                throw new Exception("يرجي إرسال اسم أمين العهدة");
            }

            if (transaction.getReceiver().isEmpty()) {
                throw new Exception("يرجي إرسال اسم المستلم ");
            }

            if (transaction.getTransactionReason().isEmpty()) {
                throw new Exception("يرجي وضع سبب للنقل ");
            }

            if (transaction.getCurrentDepartmentId() == transaction.getDistinationDepartmentId()) {
                throw new Exception("الجهاز موجود أصلا في هذا الفرع");
            }

            connection.setAutoCommit(false);
//            String sqlTransaction = "BEGIN TRANSACTION;";
//            connection.prepareStatement(sqlTransaction).execute();
            System.out.println("Transaction started ");
            PreparedStatement changeDep = new DevicesLocalDbQueries(connection).getChangeDepartmentPreparedStatemtent(transaction);
            changeDep.execute();
            System.out.println("Dep Changed ");
            PreparedStatement moveDevicePS = new DevicesLocalDbQueries(connection).getMoveDevicePreparedStatemtent(transaction);
            moveDevicePS.execute();
            System.out.println("Device Moved Changed ");
            connection.commit();
            connection.setAutoCommit(true);

//            String sqlTransactionCommit = "COMMIT";
//            connection.prepareStatement(sqlTransactionCommit).execute();
            connection.close();
//            MessageBox.showMessage("تم نقل الجهاز " + transaction.getDeviceNewName() + " بنجاح ");
//            CustomProgressDialog.hideProgressDialog();
            connection = null;
            return true;
        } catch (Exception e) {
            System.out.println("Ex => " + e);
            try {

//
                if (!connection.getAutoCommit()) {
//                    String sqlTransactionCommit = "ROLLBACK";
//                    connection.prepareStatement(sqlTransactionCommit).execute();
                    connection.rollback();
                }
//                System.out.println("Rollbacked");
            } catch (SQLException ex) {
                Logger.getLogger(DevicesRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            String error = e.getMessage();
            MessageBox.showErrorMessage(error);

            return false;
        }
    }

    @Override
    public boolean insertLocalDevice(Device device) {
        try {
            Connection connection = LocalDatabaseConnection.getConnection();
            return insertLocalDevice(connection, device, true) == null;
        } catch (Exception e) {
            return false;
        }
    }

    public String insertLocalDevice(Connection connection, Device device, boolean showAlertMessage) {

        try {

            PreparedStatement ps = new DevicesLocalDbQueries(connection).getInsertNewDevicePreparedStatment(device);
            boolean isInserted = !ps.execute();
            if (isInserted) {
                if (showAlertMessage) {
                    MessageBox.showMessage(" تم إضافة " + device.getDeviceName() + " بنجاح");
                }

            }
//            connection.close();

            return null;
        } catch (Exception e) {

            String error = e.getMessage();
            if (error.contains(" is not unique")) {
                error = "السيريال مكرر من قبل";
            }
            if (showAlertMessage) {

                MessageBox.showErrorMessage(error);
            }

//            Logger.getLogger(DepartmentsRepository.class.getName()).log(Level.SEVERE, null, e);
            return error;
        }
    }

    @Override
    public boolean updateLocalDevice(Device device
    ) {
        try {

            Connection connection = LocalDatabaseConnection.getConnection();
            PreparedStatement ps = new DevicesLocalDbQueries(connection).getUpdateDevicePreparedStatment(device);
            boolean isInserted = !ps.execute();
            if (isInserted) {
                MessageBox.showMessage(" تم تعديل " + device.getDeviceName() + " بنجاح");
            }
            connection.close();

            return isInserted;
        } catch (Exception e) {

            String error = e.getMessage();
//            if (error.contains(" is not unique")) {
//                error = "اسم الشركة (" + brand + ") مضاف من قبل";
//            }
            MessageBox.showErrorMessage(error);

            Logger.getLogger(DepartmentsRepository.class.getName()).log(Level.SEVERE, null, e);

            return false;
        }
    }

    @Override
    public boolean deleteSelectedLocalDevices(int[] selectedIDs
    ) {
        try {

            Connection connection = LocalDatabaseConnection.getConnection();
            PreparedStatement ps = new DevicesLocalDbQueries(connection).getDeleteSelectedIDs(selectedIDs);
            boolean isInserted = !ps.execute();
            if (isInserted) {
                if (selectedIDs.length > 1) {
                    MessageBox.showMessage(" تم حذف الأجهزة بنجاح");
                } else {
                    MessageBox.showMessage(" تم حذف الجهاز بنجاح");
                }

            }
            connection.close();

            return isInserted;
        } catch (Exception e) {

            String error = e.getMessage();
//            if (error.contains(" is not unique")) {
//                error = "اسم الشركة (" + brand + ") مضاف من قبل";
//            }
            MessageBox.showErrorMessage(error);

            Logger.getLogger(DepartmentsRepository.class.getName()).log(Level.SEVERE, null, e);

            return false;
        }
    }

    @Override
    public ArrayList<DeviceUpload> checkLocalDevicesForUploading(ArrayList<DeviceUpload> devicesToUpload, int checkingType) {
        ArrayList<DeviceUpload> devicesUploadsResponse = new ArrayList<>();
        ArrayList<Device> allLocalDevices = getAllLocalDevices(new DeviceSearchFields());
        Map<String, Integer> serialsAndIDs = new HashMap<>();
        try {

            for (int i = 0; i < devicesToUpload.size(); i++) {
                DeviceUpload uploadObj = devicesToUpload.get(i);
                Device device = uploadObj.getDeviceToUpload();

                // GET DEPARTMENT ID
                try {
                    String serialNumber = device.getSerialNumber();
                    String deviceName = device.getDeviceName();
                    int excelRowNumber = device.getDeviceId();
                    String depName = device.getCurrentDepartment().getDepartmentName();
                    String brandName = device.getBrand().getBrandName();
                    String modelName = device.getModel().getModelName();
                    String typeName = device.getType().getTypeName();

                    checkEmptySerialNumber(serialNumber, excelRowNumber);
                    checkEmptyDeviceName(deviceName, excelRowNumber);
                    checkEmptyDeviceDepName(depName, excelRowNumber);
                    checkEmptyDeviceBrandName(brandName, excelRowNumber);
                    checkEmptyDeviceModelName(modelName, excelRowNumber);
                    checkEmptyDeviceTypeName(typeName, excelRowNumber);

                    allLocalDevices.forEach(dev -> {

                        serialsAndIDs.put(dev.getSerialNumber().toLowerCase(), dev.getDeviceId());
//                        System.out.println("Dev ser " + dev.getSerialNumber() + " and size => " + serialsAndIDs.size());
                    });

//                    int duplicationDeviceIndex = isDeviceSerialFoundedIn(serialsAndIDs, serialNumber);
//                    System.out.println("Duplicated Value = "+duplicationDeviceIndex);
//                    if (duplicationDeviceIndex != -1) {
                    if (serialsAndIDs.containsKey(serialNumber.toLowerCase())) {
                        System.out.println("Duplicated serial let's see what is the decsision");
                        switch (checkingType) {
                            case TYPE_SKIP_DUPPLICATION:
                                System.out.println("Duplication Skiped");
                                uploadObj.setUploadingState(new UploadingStatus(false, "سيريال مكرر"));
                                devicesUploadsResponse.add(uploadObj);
                                continue;
//                                break;
                            case TYPE_UPDATE_DUPPLICATED_VALUES:
                                System.out.println("Duplication : Values is Updated");
                                device.setSerialNumber(serialNumber);
                                device.setDeviceName(deviceName);
                                device.setCurrentDepartment(new Department(depName));
                                device.getBrand().setBrandName(brandName);
                                device.getModel().setModelName(modelName);
                                device.getType().setTypeName(typeName);
                                uploadObj.setDeviceToUpload(device);
//                                if (serialsAndIDs.containsKey(device.getSerialNumber().toLowerCase())) {
//                                    uploadObj.setUploadingState(new UploadingStatus(true, "تم تعديل البيانات"));
//                                    MessageBox.showMessage("غير قادر علي تعديل بيانات الصف رقم " + excelRowNumber + " لأن السيريال مكرر حتي بعد تعديل البيانات");
//                                } else {
                                uploadObj.setUploadingState(new UploadingStatus(true, "سيتم تعديل البيانات"));
//                                }

                                break;

//                            case TYPE_CANCEL_OPERATION:
                            default:
                                System.out.println("Operation is Canceled !");
                                MessageBox.showErrorMessage("السيريال " + device.getSerialNumber() + " مكرر - الصف رقم " + excelRowNumber);
                                uploadObj.setUploadingState(new UploadingStatus("سيريال مكرر"));

                                devicesUploadsResponse.add(uploadObj);
                                return devicesUploadsResponse;
//                                        break;
//                            default:
//                                uploadObj.setUploadingState(new UploadingStatus("Default "));
                        }
                    } else {

                        serialsAndIDs.put(serialNumber.toLowerCase(), excelRowNumber);
                        System.out.println("Serial : " + serialNumber + " id : " + excelRowNumber + " is a new Device!  and size now => " + serialsAndIDs.size() + " \nMap => " + serialsAndIDs);

                        uploadObj.setUploadingState(new UploadingStatus(true, "جاهز للرفع"));
                    }

                    devicesUploadsResponse.add(uploadObj);
                    System.out.println("Device Obj Added To List");

                } catch (Exception ex) {
                    Logger.getLogger(DevicesRepository.class.getName()).log(Level.SEVERE, null, ex);
//                    errorUploadingStateMessage.append("\n").append(ex.getMessage());
                    try {
                        if (!LocalDatabaseConnection.getConnection().getAutoCommit()) {

                            rollback(LocalDatabaseConnection.getConnection());
                        }
                    } catch (Exception e) {
                    }

                    MessageBox.showErrorMessage(ex.getMessage());
                    return devicesToUpload;
                }
            }

        } catch (Exception e) {
            String error = e.getMessage();

            MessageBox.showErrorMessage(error);

            Logger.getLogger(DepartmentsRepository.class.getName()).log(Level.SEVERE, null, e);

            return devicesToUpload;
        }

//        MessageBox.showMessage("تم فحص البيانات\nقم باستخدام القائمة المنسدلة للفلترة بين الحالات");
        return devicesUploadsResponse;
    }

    @Override
    public ArrayList<DeviceUpload> uploadLocalDevicesToDatabase(JProgressBar progress, ArrayList<DeviceUpload> devicesToUpload, int checkingType,
            DepartmentsRepository departmentsRepo,
            BrandsRepository brandRepo,
            ModelsRepository modelsRepo
    ) throws Exception {

        ArrayList<DeviceUpload> uploadsResponse = new ArrayList<>();
        Connection connection = LocalDatabaseConnection.getConnection();

//        if (connection.getAutoCommit() == false) {
//            connection.setAutoCommit(true);
//        }
        connection.setAutoCommit(false);
        System.out.println("In Thread => " + Thread.currentThread().getName());
        for (int i = 0; i < devicesToUpload.size(); i++) {

            if (connection.isClosed()) {
                MessageBox.showErrorMessage("Connection closed in Loop Index In Start Of Loop " + i);
                return devicesToUpload;
            }

            DeviceUpload uploadObj = devicesToUpload.get(i);
            Device device = uploadObj.getDeviceToUpload();

            ServerResponse<Department> departmentsResponse = departmentsRepo.getDepartmentOrInsert(connection, device.getCurrentDepartment().getDepartmentName());
            if (departmentsResponse.getCode() == 0) {
//                uploadObj.setUploadingState(new UploadingStatus("لم يتم إضافة الفرع بنجاح"));
                rollbackAndThrowError(connection, departmentsResponse.getMessage());
                return uploadsResponse;
            }

            int depId = departmentsResponse.getResponse().getDepartmentId();
//                    System.out.println("Dep is "+departmentsResponse.getDepartmentName() + " and id is => "+depId);

            if (connection.isClosed()) {
                MessageBox.showErrorMessage("Connection closed in Loop Index After Deps " + i);
                return devicesToUpload;
            }

            // GET TYPE ID  
            ServerResponse<DeviceType> typeResponse = TypesRepository.getInstance().getLocalTypeOrInsert(connection, device.getType().getTypeName());
            if (typeResponse.getCode() == 0) {
//                uploadObj.setUploadingState(new UploadingStatus("لم يتم إضافة الفرع بنجاح"));
                rollbackAndThrowError(connection, typeResponse.getMessage());
                return uploadsResponse;
            }

            if (connection.isClosed()) {
                MessageBox.showErrorMessage("Connection closed in Loop Index After Types " + i);
                return devicesToUpload;
            }
//            int typeId = typeResponse.getResponse().getTypeId();
            // GET BRAND ID :
            ServerResponse<Brand> brandResponse = brandRepo.getBrandIdOrInsert(connection, device.getBrand().getBrandName());
            if (brandResponse.getCode() == 0) {
//                uploadObj.setUploadingState(new UploadingStatus("لم يتم إضافة الفرع بنجاح"));
                rollbackAndThrowError(connection, brandResponse.getMessage());
                return uploadsResponse;
            }
            int brandId = brandResponse.getResponse().getBrandId();

            if (connection.isClosed()) {
                MessageBox.showErrorMessage("Connection closed in Loop Index After Brands " + i);
                return devicesToUpload;
            }

//            System.out.println("Brand is " + brandResponse.getResponse().getBrandName() + " and id is => " + brandId);
            // GET MODEL ID :
            Model modelToBeAdded = new Model(-1, brandId, device.getModel().getModelName(), typeResponse.getResponse().getTypeId());
            ServerResponse<Model> modelResponse = modelsRepo.getLocalModelIdOrInsert(connection, modelToBeAdded);
            if (modelResponse.getCode() == 0) {
                rollbackAndThrowError(connection, modelResponse.getMessage());
                return uploadsResponse;
            }

            int modelId = modelResponse.getResponse().getModelId();

            if (connection.isClosed()) {
                MessageBox.showErrorMessage("Connection closed in Loop Index After Models " + i);
                return devicesToUpload;
            }

            System.out.println("Dep Id => " + depId + " brandId => " + brandId + " modelId " + modelId);
            System.out.println("Now Will Adding " + device.getSerialNumber());
            String errorMsg = insertLocalDevice(connection, new Device(device.getSerialNumber(), device.getDeviceName(), departmentsResponse.getResponse(), modelResponse.getResponse()), false);
//            connection.commit();

            if (connection.isClosed()) {
                MessageBox.showErrorMessage("Connection closed in Loop Index After Device " + i);
                return devicesToUpload;
            }
            if (errorMsg == null) {

                uploadObj.setUploadingState(new UploadingStatus(true, "تم الرفع"));
//                uploadsResponse.add(uploadObj);
            } else {
                if (errorMsg.contains("is not unique")) {
                    switch (checkingType) {
                        case TYPE_UPDATE_DUPPLICATED_VALUES:
                            String updatingError = updateLocalDeviceWithSerialNumber(connection, new Device(device.getSerialNumber(), device.getDeviceName(), departmentsResponse.getResponse(), modelResponse.getResponse()));
                            if (updatingError == null) {
                                uploadObj.setUploadingState(new UploadingStatus(true, "تم تحديث البيانات"));
                            } else {
                                uploadObj.setUploadingState(new UploadingStatus(errorMsg));
                            }
                            uploadsResponse.add(uploadObj);
                            break;
                        case TYPE_SKIP_DUPPLICATION:
                            uploadObj.setUploadingState(new UploadingStatus("تم التخطي"));
                            break;
                        case TYPE_CANCEL_OPERATION:
                            rollbackAndThrowError(connection, errorMsg);
                            return uploadsResponse;
//                            break;
                        default:
                            rollbackAndThrowError(connection, errorMsg);
                            return uploadsResponse;
//                            break;
                    }
                }

            }

            calculateProgressRatio(progress, i, devicesToUpload);
            uploadsResponse.add(uploadObj);

            if (connection.isClosed()) {
                MessageBox.showErrorMessage("Connection closed in Loop Index After Adding UIpload Obnject " + i);
                return devicesToUpload;
            }
        }
        if (connection.getAutoCommit() == false) {
            connection.commit();
            connection.setAutoCommit(true);
        }
        if (connection.isClosed()) {
            MessageBox.showErrorMessage("Connection closed in Loop Index After End Foor loop ");
            return devicesToUpload;
        }

        return uploadsResponse;

    }

    private boolean isLastItemInArray(int index, ArrayList<Model> list) {
        return index == list.size() - 1;
    }

    private void rollback(Connection connection) throws SQLException {
        if (connection.getAutoCommit() == false) {
            connection.rollback();
            connection.setAutoCommit(true);
            connection.close();
        } else {
            connection.close();
            connection = null;
        }

    }

    private void checkEmptySerialNumber(String serialNumber, int excelRowNumber) throws Exception {
        if (serialNumber != null && !serialNumber.isEmpty()) {

        } else {
            throw new Exception("السيريال فارغ في الصف رقم " + excelRowNumber);
        }
    }

    private void checkEmptyDeviceName(String deviceName, int excelRowNumber) throws Exception {
        if (deviceName == null || deviceName.isEmpty()) {
            throw new Exception("اسم الجهاز فارغ في الصف رقم " + excelRowNumber);
        }
    }

    private void checkEmptyDeviceDepName(String depName, int excelRowNumber) throws Exception {
        if (depName == null || depName.isEmpty()) {
            throw new Exception("اسم الفرع فارغ في الصف رقم " + excelRowNumber);
        }
    }

    private void checkEmptyDeviceBrandName(String brandName, int excelRowNumber) throws Exception {
        if (brandName == null || brandName.isEmpty()) {
            throw new Exception("اسم الشركة فارغ في الصف رقم " + excelRowNumber);
        }
    }

    private void checkEmptyDeviceModelName(String modelName, int excelRowNumber) throws Exception {
        if (modelName == null || modelName.isEmpty()) {
            throw new Exception("اسم الموديل فارغ في الصف رقم " + excelRowNumber);
        }
    }

    private void checkEmptyDeviceTypeName(String typeName, int excelRowNumber) throws Exception {
        if (typeName == null || typeName.isEmpty()) {
            throw new Exception(" النوع فارغ في الصف رقم " + excelRowNumber);
        }
    }

    private int isDeviceSerialFoundedIn(Map<String, Integer> allLocalDevices, String serialNumber) {
        return allLocalDevices.getOrDefault(serialNumber.toLowerCase(), -1);

    }

    private void rollbackAndThrowError(Connection connection, String message) throws Exception {
        MessageBox.showErrorMessage("Connection Will Be Closed beacause " + message);
        rollback(connection);
        throw new Exception(message);
    }

    private String updateLocalDeviceWithSerialNumber(Connection connection, Device device) {
        try {

            PreparedStatement ps = new DevicesLocalDbQueries(connection).getUpdateDeviceWithSerialNumberPreparedStatment(device);
            boolean isInserted = !ps.execute();

            return null;
        } catch (Exception e) {

            String error = e.getMessage();
//            if (error.contains(" is not unique")) {
//                error = "اسم الشركة (" + brand + ") مضاف من قبل";
//            }
            MessageBox.showErrorMessage(error);

            Logger.getLogger(DepartmentsRepository.class.getName()).log(Level.SEVERE, null, e);

            return error;
        }
    }

    private void calculateProgressRatio(JProgressBar progress, int i, ArrayList<DeviceUpload> devicesToUpload) {
        progress.setIndeterminate(false);

//        int value = (i + 1) * (100 / devicesToUpload.size());
        int size = devicesToUpload.size();
        int devicesUploadedCount = i + 1;

        int value = (devicesUploadedCount / size) * 100;
//        int value = (i + 1) * (100 / devicesToUpload.size());
        if (i == devicesToUpload.size() - 1) {
            value = 100;
        }

        System.out.println("Size is " + devicesToUpload.size() + " uploaded Count = " + devicesUploadedCount + " (100 / " + devicesToUpload.size() + " ) = " + (100 / devicesToUpload.size()) + " Value is " + value);
        progress.setValue(value);
        progress.repaint();
//        System.out.println("Value is "+value);
    }

}
