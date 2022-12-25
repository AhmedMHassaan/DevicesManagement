/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.local.queries_operations;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.sql.ResultSet;

/**
 *
 * @author pc
 */
public class ResultSetParser<T> {

    public T parseResultSet(ResultSet resultset, Type type) throws Exception {

        JsonArray responseArray = new JsonArray();
//        boolean isInLoop = false;
//        resultset.beforeFirst();
        while (resultset.next()) {
//            System.out.println("Rows => " + resultset.getRow());
//                int depId = depsResultSet.getInt(1);
//                String depName = depsResultSet.getString(2);
//                int devicesCount = depsResultSet.getInt(3);
            int columnsCount = resultset.getMetaData().getColumnCount();
            JsonObject json = new JsonObject();
            for (int i = 1; i <= columnsCount; i++) {

                String columnLabel = resultset.getMetaData().getColumnLabel(i);
                Object value = resultset.getObject(i);
                json.addProperty(columnLabel, value+"");

//                System.out.println(columnLabel + " : " + value);
            }
            responseArray.add(json);
//            isInLoop = true;

        }
//        System.out.println("Response => " + responseArray.toString());
//        if (isInLoop) {
            return new Gson().fromJson(responseArray, type);
//        } else {
//            return null;
//        }

    }
}
