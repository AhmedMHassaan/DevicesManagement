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
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import utils.MessageBox;
import utils.MutableLiveData;

/**
 *
 * @author pc
 * @param <T>
 */
public class HttpRequestsEnqueue<T> {

    private final OkHttpClient client = new OkHttpClient();

    public MutableLiveData<ServerResponse<T>> sendGetRequest(String requestUrl, Type type) throws Exception {
        MutableLiveData<ServerResponse<T>> responseLiveData = new MutableLiveData<>();
//        System.out.println("send Request to "+requestUrl);
        URL url = new URL(requestUrl);

        Request request = new Request.Builder()
                .url(url)
                .build();

        client
                .newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException ex) {
                        responseLiveData.postData(new ServerResponse<>(0, ex.getMessage(), null));
                    }

                    @Override
                    public void onResponse(Call call, Response rspns) throws IOException {
                        if (rspns.isSuccessful() && rspns.body() != null) {
                            try {
                                String responseAsString = rspns.body().string();
                                
                                Gson gson = new Gson();
                                
                                System.out.println("Response => " + responseAsString);
                                ServerResponse<T> serverResponse = gson.fromJson(responseAsString, type);
//                                handelServerResponse(serverResponse);
                                responseLiveData.postData(serverResponse);
                            } catch (Exception ex) {
                                Logger.getLogger(HttpRequestsEnqueue.class.getName()).log(Level.SEVERE, null, ex);
                                MessageBox.showErrorMessage(ex.getMessage());
                                 responseLiveData.postData(new ServerResponse<>(0, ex.getMessage(), null));
                            }

                        }
                        
                    }
                });

//        System.out.println("ResPONSE "+response.toString());
//        System.out.println("Type is " + type.getTypeName());
       
        return responseLiveData;

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
        handleResponseCode(response);
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

    private void handleResponseCode(ServerResponse response) throws Exception {
        if (response.getCode() != 1) {
            if (response.getMessage() == null || response.getMessage().isEmpty()) {
                throw new Exception("هناك خطأ في الرد من السيرفر");
            } else {
                throw new Exception(response.getMessage());
            }
        }
    }

    private void handleResponse(T response) throws Exception {
        if (response == null) {
            throw new Exception("لا توجد أي بيانات");
        }
        if (response instanceof ArrayList) {
            if (((ArrayList) response).isEmpty()) {
                throw new Exception("لا توجد أي بيانات");
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
