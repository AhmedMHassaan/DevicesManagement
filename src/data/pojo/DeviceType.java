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
public class DeviceType {
    @SerializedName("type_id")
    int typeId;
    
    
    @SerializedName("type")
    String typeName;

    
    @SerializedName("devices_count_in_type")
    private int devicesCountInType;

    public DeviceType(String typeName) {
        this.typeName = typeName;
    }

    public DeviceType() {
    }

    public DeviceType(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    
    
    
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getDevicesCountInType() {
        return devicesCountInType;
    }

    public void setDevicesCountInType(int devicesCountInType) {
        this.devicesCountInType = devicesCountInType;
    }
    
    
    
    
    
    
}
