/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.pojo.responses;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Nozom
 * @param <T>
 */
public class ServerResponse<T> {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String alertMessage;

    @SerializedName("error_message")
    String errorMessage;

    @SerializedName("response")
    private T response;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public ServerResponse(int code, String message, T response) {
        this.code = code;
        this.alertMessage = message;
        this.response = response;
    }

    public ServerResponse(String message) {
        this(0, message, null);
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public String getErrorMessage() {
        return errorMessage == null ? "" : errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ServerResponse{" + "code=" + code + ", alertMessage=" + alertMessage + ", errorMessage=" + errorMessage + ", response=" + response + '}';
    }

    public String getMessage() {
        if (getErrorMessage().isEmpty()) {
            return getAlertMessage();
        } else {
            return getErrorMessage();
        }
    }

}
