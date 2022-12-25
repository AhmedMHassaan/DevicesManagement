/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.pojo;

/**
 *
 * @author pc
 */
public class DeviceSearchFields {
    
    private String deviceSerialNumber;
    private String deviceName;
    private int departmentId;
    private int typeId;
    private int modelId;

    
    
    public DeviceSearchFields(String deviceSerialNumber, String deviceName, int departmentId, int _typeId, int _modelId) {
        this.deviceSerialNumber = deviceSerialNumber;
        this.deviceName = deviceName;
        this.departmentId = departmentId;
        this.typeId = _typeId;
        this.modelId = _modelId;
    }

    public DeviceSearchFields(String deviceSerialNumber) {
        this(deviceSerialNumber,"",-1,-1,-1);
    }
    

    public DeviceSearchFields() {
        this("","",-1,-1,-1);
    }

    public String getDeviceSerialNumber() {
        return deviceSerialNumber == null?"":deviceSerialNumber;
    }

    public void setDeviceSerialNumber(String deviceSerialNumber) {
        this.deviceSerialNumber = deviceSerialNumber;
    }

    public String getDeviceName() {
        return deviceName == null?"":deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }
    
    
    
    
    
    
    
}
