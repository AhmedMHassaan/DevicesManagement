/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.pojo;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author pc
 */
public class Device {

    @SerializedName("id")
    private int deviceId;

    @SerializedName("serial_number")
    private String serialNumber;

    @SerializedName("name")
    private String deviceName;

    @SerializedName("adding_timestamp")
    private String addingTimestamp;

    @SerializedName("brand")
    private Brand brand;

    @SerializedName("current_department")
    private Department currentDepartment;

    @SerializedName("model")
    private Model model;

    @SerializedName("type")
    private DeviceType type;

    public Device() {
    }

    public Device(int _deviceId) {
        this.deviceId =_deviceId; 
    }

    public Device(int deviceId, String serialNumber, String deviceName, String addingTimestamp) {
        this.deviceId = deviceId;
        this.serialNumber = serialNumber;
        this.deviceName = deviceName;
        this.addingTimestamp = addingTimestamp;
    }

    public Device(String serialNumber, String deviceName, String brandName, String currentDepartmentName, String modelName, String typeName) {
        this.serialNumber = serialNumber;
        this.deviceName = deviceName;
        this.brand = new Brand(brandName, brandName + " - " + typeName);
        this.currentDepartment = new Department(currentDepartmentName);
        this.model = new Model(modelName, brandName, typeName);
        this.type = new DeviceType(typeName);
    }

    public Device(int deviceId, String serialNumber, String deviceName, String addingTimestamp, Brand brand, Department currentDepartment, Model model, DeviceType type) {
        this.deviceId = deviceId;
        this.serialNumber = serialNumber;
        this.deviceName = deviceName;
        this.addingTimestamp = addingTimestamp;
        this.brand = brand;
        this.currentDepartment = currentDepartment;
        this.model = model;
        this.type = type;
    }

    public Device(String serialNumber, String deviceName, Department currentDepartment, Model model) {
        this.serialNumber = serialNumber;
        this.deviceName = deviceName;
        this.currentDepartment = currentDepartment;
        this.model = model;
    }

    public Device(int deviceId, String serialNumber, String deviceName, Department currentDepartment, Model model) {
        this.deviceId = deviceId;
        this.serialNumber = serialNumber;
        this.deviceName = deviceName;
        this.currentDepartment = currentDepartment;
        this.model = model;
    }

    public DeviceType getType() {
        return type;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getAddingTimestamp() {
        return addingTimestamp;
    }

    public void setAddingTimestamp(String addingTimestamp) {
        this.addingTimestamp = addingTimestamp;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Department getCurrentDepartment() {
        return currentDepartment;
    }

    public void setCurrentDepartment(Department currentDepartment) {
        this.currentDepartment = currentDepartment;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Device{" + "deviceId=" + deviceId + ", serialNumber=" + serialNumber + ", deviceName=" + deviceName + ", addingTimestamp=" + addingTimestamp + ", brand=" + brand + ", currentDepartment=" + currentDepartment + ", model=" + model + ", type=" + type + '}';
    }

}
