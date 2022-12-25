/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.remote;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import data.pojo.responses.ServerResponse;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import utils.MessageBox;

/**
 *
 * @author pc
 * @param <T>
 */
public class HttpRequests<T> {

    private boolean showEmptyResponseErrorMessage = true;

    public T sendGetRequest(String requestUrl, Type type, boolean _showEmptyResponseErrorMessage) throws Exception {
//        System.out.println("send Request to "+requestUrl);
        this.showEmptyResponseErrorMessage = _showEmptyResponseErrorMessage;
        URL url = new URL(requestUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();  //connecting to url
        connection.setRequestMethod("GET");
//        connection.connect();

        StringBuilder response;
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String str;
        response = new StringBuilder();
        while ((str = in.readLine()) != null) {
            response.append(str);

        }

        in.close();
        //closing stream

        if (connection.getResponseCode() != 200) {

            throw new Exception(connection.getResponseMessage() + " " + connection.getResponseCode());
//                return new ServerResponse<>(0, connection.getResponseMessage(), null);
        }
//        System.out.println("ResPONSE "+response.toString());

        Gson gson = new Gson();

        System.out.println("Response => " + response);
        ServerResponse<T> serverResponse = gson.fromJson(response.toString(), type);
//        System.out.println("Type is " + type.getTypeName());

        handelServerResponse(serverResponse);
        return serverResponse.getResponse();

    }

    public T sendGetRequest(String requestUrl, Type type) throws Exception {
        return sendGetRequest(requestUrl, type, true);
    }

    public T sendPostRequest(String url, String params, Type type) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("POST");

//        String urlParameters = "param1=a&param2=b&param3=c";
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestProperty("charset", "utf-8");
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//        wr.writeUTF(params);
        wr.writeBytes(params);
        wr.flush();
        wr.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println("Post Response is " + response);
        Gson gson = new Gson();

        ServerResponse<T> serverResponse;
        try {
            serverResponse = gson.fromJson(response.toString(), type);
        } catch (JsonSyntaxException e) {
            throw new Exception(response.toString());
        }

        handelServerResponse(serverResponse);
        return serverResponse.getResponse();
    }

    private void handelServerResponse(ServerResponse<T> response) throws Exception {

        checkIfServerResponseIsNotNull(response);
        handleResponseCode(response.getCode(), response.getAlertMessage(),response.getErrorMessage());
        showResponseMessage(response.getErrorMessage());
        showResponseMessage(response.getAlertMessage());
        handleResponse(response.getResponse());

    }

    private void checkIfServerResponseIsNotNull(ServerResponse<T> response) throws Exception {
        if (response == null) {
            throw new Exception("No Response Founded");
        }

    }

    private void handleServerResponse(ServerResponse<? extends Object> response) throws Exception {
        if (response == null) {
            throw new Exception("No Response Founded");
        }
    }

    private void handleResponseCode(int code, String message, String errorMessage) throws Exception {
        if (code != 1) {
            boolean isEmptyAlert = message == null || message.isEmpty();
            boolean isEmptyError = errorMessage == null || errorMessage.isEmpty();
            if (isEmptyAlert && isEmptyError) {
                throw new Exception("هناك خطأ في الرد من السيرفر");
            } else {

                throw new Exception(isEmptyError ? message : errorMessage);
            }
        }
    }

    private void handleResponse(T response) throws Exception {
        if (showEmptyResponseErrorMessage) {

            if (response == null) {
                throw new Exception("لا توجد أي بيانات");
            }
            if (response instanceof ArrayList) {
                if (((ArrayList) response).isEmpty()) {
                    throw new Exception("لا توجد أي بيانات");
                }
            }
        }

    }

    private void showResponseMessage(String message) {

        if (message == null || message.isEmpty()) {
            return;
        }
        MessageBox.showMessage(message);

    }

}
