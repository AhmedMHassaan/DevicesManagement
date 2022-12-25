/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.pojo.responses;

import com.google.gson.annotations.SerializedName;
import data.pojo.Department;
import data.pojo.Device;

/**
 *
 * @author pc
 */
public class DeviceTransactionResponse {

    @SerializedName("trans_id")
    private int transactionId;

    @SerializedName("device")
    private Device device;

    @SerializedName("receiver_name")
    private String receiverName;

    @SerializedName("sender_name")
    private String senderName;

    @SerializedName("trans_timestamp")
    private String transitionTimestamp;

    @SerializedName("transaction_reason")
    private String transactionReason;

    @SerializedName("old_department")
    private Department oldDepartment;

    @SerializedName("new_department")
    private Department newDepartment;

    public DeviceTransactionResponse() {
    }

    public DeviceTransactionResponse(int deviceId) {
        if (this.device == null) {
            this.device = new Device();
        }
        this.device.setDeviceId(deviceId);
    }

    public DeviceTransactionResponse(int transactionId, Device device, String receiverName, String senderName, String transitionTimestamp, String transactionReason, Department oldDepartment, Department newDepartment) {
        this.transactionId = transactionId;
        this.device = device;
        this.receiverName = receiverName;
        this.senderName = senderName;
        this.transitionTimestamp = transitionTimestamp;
        this.transactionReason = transactionReason;
        this.oldDepartment = oldDepartment;
        this.newDepartment = newDepartment;
    }

    public DeviceTransactionResponse(Device device, String receiverName, String senderName, String transitionTimestamp, String transactionReason, Department oldDepartment, Department newDepartment) {
        this.device = device;
        this.receiverName = receiverName;
        this.senderName = senderName;
        this.transitionTimestamp = transitionTimestamp;
        this.transactionReason = transactionReason;
        this.oldDepartment = oldDepartment;
        this.newDepartment = newDepartment;
    }

    public Department getNewDepartment() {
        if (newDepartment == null) {
            return new Department("");
        }
        return newDepartment;
    }

    public void setNewDepartment(Department newDepartment) {
        this.newDepartment = newDepartment;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getReceiverName() {
        return receiverName == null ? "" : receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getSenderName() {
        return senderName == null ? "" : senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getTransitionTimestamp() {
        return transitionTimestamp;
    }

    public void setTransitionTimestamp(String transitionTimestamp) {
        this.transitionTimestamp = transitionTimestamp;
    }

    public String getTransactionReason() {
        return transactionReason == null ? "" : transactionReason;
    }

    public void setTransactionReason(String transactionReason) {
        this.transactionReason = transactionReason;
    }

    public Department getOldDepartment() {
        if (oldDepartment == null) {
            return new Department("");
        }
        return oldDepartment;
    }

    public void setOldDepartment(Department oldDepartment) {
        this.oldDepartment = oldDepartment;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "DeviceTransactionResponse{" + "transactionId=" + transactionId + ", device=" + device + ", receiverName=" + receiverName + ", senderName=" + senderName + ", transitionTimestamp=" + transitionTimestamp + ", transactionReason=" + transactionReason + ", oldDepartment=" + oldDepartment + ", newDepartment=" + newDepartment + '}';
    }

}
