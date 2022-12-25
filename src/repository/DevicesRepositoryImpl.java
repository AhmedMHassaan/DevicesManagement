/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import data.pojo.Device;
import data.pojo.DeviceSearchFields;
import data.pojo.DeviceTransaction;
import data.pojo.DeviceUpload;
import data.pojo.responses.DeviceTransactionResponse;
import data.pojo.responses.ReportResponse;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface DevicesRepositoryImpl {
    
    ReportResponse getDevicesReport();
    
    ReportResponse getDevicesReport(int[] depsIDs, int[] modelsIds);
    
    ArrayList<Device> getAllDevices(DeviceSearchFields deviceSearch);
    
    
    ArrayList<DeviceTransactionResponse> getAllDevicesTransactions();
    
    
    ArrayList<DeviceTransactionResponse> getDeviceTransactions(int deviceId);
    
    
    
    boolean moveDeviceToAnotherDepartment(DeviceTransaction transaction);
    
    boolean insertDevice(Device device);
    
    boolean updateDevice(Device device);
    
//    boolean deleteDevice(int deviceId);
    
    boolean deleteSelectedDevices(int selectedIDs []);
    
    
    ArrayList<DeviceUpload> checkDevicesForUploading(ArrayList<DeviceUpload> devicesToUpload, int checkingType);
    
    
    ArrayList<DeviceUpload> uploadDevicesToDatabase(ArrayList<DeviceUpload> devicesToUpload, int checkingType);
}
