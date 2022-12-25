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
public class UploadingStatus {
    private boolean uploadingSuccess ;
    private String uploadingResponseMessage;
//    private

    public UploadingStatus(boolean uploadingSuccess, String uploadingResponseMessage) {
        this.uploadingSuccess = uploadingSuccess;
        this.uploadingResponseMessage = uploadingResponseMessage;
    }
    public UploadingStatus( String errorMessage_) {
        this(false, errorMessage_);
    }

    
    public boolean isUploadingSuccess() {
        return uploadingSuccess;
    }

    public void setUploadingSuccess(boolean uploadingSuccess) {
        this.uploadingSuccess = uploadingSuccess;
    }

    public String getUploadingResponseMessage() {
        return uploadingResponseMessage == null?"":uploadingResponseMessage;
    }

    public void setUploadingResponseMessage(String uploadingResponseMessage) {
        this.uploadingResponseMessage = uploadingResponseMessage;
    }
    
    
}
