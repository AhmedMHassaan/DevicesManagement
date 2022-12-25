/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.local.local_db_repos;

import data.pojo.Device;
import data.pojo.DeviceSearchFields;
import data.pojo.DeviceTransaction;
import data.pojo.DeviceUpload;

import data.pojo.responses.DeviceTransactionResponse;
import data.pojo.responses.ReportResponse;
import java.util.ArrayList;
import javax.swing.JProgressBar;
import repository.BrandsRepository;
import repository.DepartmentsRepository;
import repository.ModelsRepository;

/**
 *
 * @author pc
 */
public abstract class DevicesLocalRepository {

    protected final int TYPE_SKIP_DUPPLICATION = 1;
    protected final int TYPE_UPDATE_DUPPLICATED_VALUES = 2;
    protected final int TYPE_CANCEL_OPERATION = 3;

    public abstract ReportResponse getLocalDevicesReport();
//

    public abstract ReportResponse getLocalDevicesReport(int[] depsIDs, int[] modelsIds);

    public abstract ArrayList<Device> getAllLocalDevices(DeviceSearchFields deviceSearch);

    public abstract ArrayList<DeviceTransactionResponse> getAllLocalDevicesTransactions();

    public abstract ArrayList<DeviceTransactionResponse> getLocalDeviceTransactions(int deviceId);

    public abstract boolean moveLocalDeviceToAnotherDepartment(DeviceTransaction transaction);

    public abstract boolean insertLocalDevice(Device device);

    public abstract boolean updateLocalDevice(Device device);

//    boolean deleteDevice(int deviceId);
    public abstract boolean deleteSelectedLocalDevices(int selectedIDs[]);

    public abstract ArrayList<DeviceUpload> checkLocalDevicesForUploading(ArrayList<DeviceUpload> devicesToUpload, int checkingType);

    public abstract ArrayList<DeviceUpload> uploadLocalDevicesToDatabase(
            JProgressBar progress,
            ArrayList<DeviceUpload> devicesToUpload,
            int checkingType,
            DepartmentsRepository departmentsRepository,
            BrandsRepository brandRepo,
            ModelsRepository modelsRepo) throws Exception;

}
