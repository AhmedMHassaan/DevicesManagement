/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.local.queries_operations;

import data.pojo.Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Arrays;

/**
 *
 * @author pc
 */
public class ModelsLocalDbQueries extends base.BaseLocalDbQueries {

    public ModelsLocalDbQueries(Connection connection) {
        super(connection);
    }

    public PreparedStatement getAllModelsPreparedStatment(String depName, String modelName, int[] modelsIds) throws Exception {
        StringBuilder sql = new StringBuilder("SELECT devices_models.*,devices_types.type, devices_brands.brand, COUNT(devices.id) as `devices_count_in_model` "
                + "                FROM `devices_models` "
                + "                    INNER JOIN devices_brands "
                + "                        on devices_brands.brand_id = devices_models.brand_id "
                + "                    LEFT OUTER JOIN devices"
                + "                        ON devices.model_id = devices_models.model_id"
                + "                    inner join devices_types"
                + "                        on devices_types.type_id = devices_models.type_id"
                + ""
                + "                WHERE devices_models.model_id is not null");

        if (depName != null && !depName.isEmpty()) {
            sql.append(" AND devices.current_department_id = (SELECT departments.dep_id FROM departments"
                    + "                     WHERE departments.department = '").append(depName).append("')");
        }

        if (modelName != null && !modelName.isEmpty()) {
            sql.append(" and  devices_models.model = '").append(modelName).append("'");
        }

        if (modelsIds.length > 0) {
            String arr = Arrays.toString(modelsIds).replace("[", "(").replace("]", ")").replace(" ", "");
//            sql.append("  and  devices_models.model_id in  '").append(arr);
            sql.append("  and  devices_models.model_id in  ").append(arr);
        }

        sql.append(" GROUP BY model_id order by type_id asc");

        PreparedStatement pStatment = getConnection().prepareStatement(sql.toString());
        return pStatment;
    }

    public PreparedStatement getInsertNewModelPreparedStatment(Model model) throws Exception {
//    public Statement getInsertNewModelPreparedStatment(Model model) throws Exception {
        String sql = "INSERT INTO main.devices_models (`model_id`, `brand_id`,`type_id`, `model`) VALUES  (NULL, ? , ?, ? )";
        PreparedStatement pStatment = getConnection().prepareStatement(sql);
        pStatment.setInt(1, model.getBrandId());
        pStatment.setInt(2, model.getTypeId());
        pStatment.setString(3, model.getModelName());
//
        return pStatment;
//
//        String sql = "INSERT INTO `devices_models` (`model_id`, `brand_id`,`type_id`, `model`) VALUES  (NULL, '"+model.getBrandId()+"' , '"+model.getTypeId()+"', '"+model.getModelName()+"' )";
//        Statement stmt  = getConnection().createStatement();
//        return stmt;
    }

    public PreparedStatement getUpdateModelPreparedStatment(Model model) throws Exception {
        String sql = "UPDATE devices_models"
                + "                        set model = ?,"
                + "                        brand_id = ?,"
                + "                        type_id = ?"
                + "                       WHERE model_id = ?  ";

        PreparedStatement pStatment = getConnection().prepareStatement(sql);
        pStatment.setString(1, model.getModelName());
        pStatment.setInt(2, model.getBrandId());
        pStatment.setInt(3, model.getTypeId());
        pStatment.setInt(4, model.getModelId());

        return pStatment;
    }

    public PreparedStatement getDeleteModelPreparedStatment(int modelId) throws Exception {
        String sql = "DELETE from devices_models WHERE model_id  = ? ";

        PreparedStatement pStatment = getConnection().prepareStatement(sql);
        pStatment.setInt(1, modelId);
        return pStatment;
    }

    public PreparedStatement getModelIdFromItsNamePreparedStatment(String modelName) throws Exception {
        String sql = "SELECT * from devices_models where devices_models.model = ? ";

        PreparedStatement pStatment = getConnection().prepareStatement(sql);
        pStatment.setString(1, modelName);
        return pStatment;
    }

}
