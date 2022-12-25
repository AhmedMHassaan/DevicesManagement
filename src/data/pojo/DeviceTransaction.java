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
public class DeviceTransaction {
    @SerializedName("trans_id")
    private int transactionId;
    
    @SerializedName("device_id")
    private int deviceId ;
    
    @SerializedName("current_department_id")
    private int currentDepartmentId ;
    
    @SerializedName("distination_department_id")
    private int distinationDepartmentId ;
    
    @SerializedName("sender_name")
    private String sender ;
    
    @SerializedName("receiver_name")
    private String receiver ;
    
    @SerializedName("transaction_reason")
    private String transactionReason;
    
    private String deviceNewName;
    

    public DeviceTransaction(int deviceId, int currentDepartmentId, int distinationDepartmentId,String deviceNewName_, String sender, String receiver, String transactionReason) {
        this.deviceId = deviceId;
        this.currentDepartmentId = currentDepartmentId;
        this.distinationDepartmentId = distinationDepartmentId;
        this.deviceNewName = deviceNewName_;
        this.sender = sender;
        this.receiver = receiver;
        this.transactionReason = transactionReason;
    }

    public String getTransactionReason() {
        return transactionReason;
    }

    public void setTransactionReason(String transactionReason) {
        this.transactionReason = transactionReason;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getCurrentDepartmentId() {
        return currentDepartmentId;
    }

    public void setCurrentDepartmentId(int currentDepartmentId) {
        this.currentDepartmentId = currentDepartmentId;
    }

    public int getDistinationDepartmentId() {
        return distinationDepartmentId;
    }

    public void setDistinationDepartmentId(int distinationDepartmentId) {
        this.distinationDepartmentId = distinationDepartmentId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    
    

    @Override
    public String toString() {
        return "DeviceTransaction{" + "transactionId=" + transactionId + ", deviceId=" + deviceId + ", currentDepartmentId=" + currentDepartmentId + ", distinationDepartmentId=" + distinationDepartmentId + ", sender=" + sender + ", receiver=" + receiver + ", transactionReason=" + transactionReason + '}';
    }

    public String getDeviceNewName() {
        
        return deviceNewName ==null?"":deviceNewName  ;
    }

    public void setDeviceNewName(String deviceNewName) {
        this.deviceNewName = deviceNewName;
    }
    
    
    
    
    
    
}
