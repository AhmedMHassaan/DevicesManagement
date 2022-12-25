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
public class DeviceUpload {
    private UploadingStatus uploadingState;
    private Device deviceToUpload;

    public DeviceUpload(UploadingStatus uploadingState, Device deviceToUpload) {
        this.uploadingState = uploadingState;
        this.deviceToUpload = deviceToUpload;
    }

    public UploadingStatus getUploadingState() {
        return uploadingState;
    }

    public void setUploadingState(UploadingStatus uploadingState) {
        this.uploadingState = uploadingState;
    }

    public Device getDeviceToUpload() {
        return deviceToUpload;
    }

    public void setDeviceToUpload(Device deviceToUpload) {
        this.deviceToUpload = deviceToUpload;
    }
    
    
    
    
    /*enum UploadingStatus{
    NOT_CHECKED("لم يتم الفحص"),
    ERROR_STATUS("حدث خطأ"),
    }*/
    
    
}
