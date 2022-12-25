/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.local.queries_operations;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author pc
 */
public class TypesLocalDbQueries extends base.BaseLocalDbQueries {

    public TypesLocalDbQueries(Connection connection) {
        super(connection);
    }

    public PreparedStatement getAllTypesPreparedStatment() throws Exception {
        String sql = "SELECT "
                + "devices_types.*, "
                + "COUNT(devices.id) AS `devices_count_in_type` "
                + "FROM devices_types "
                + "LEFT OUTER JOIN devices_models "
                + "on devices_models.type_id = devices_types.type_id "
                + "LEFT OUTER JOIN devices "
                + "on devices_models.model_id = devices.model_id "
                + "GROUP BY devices_types.type_id "
                + "ORDER BY devices_types.type_id asc ";
        PreparedStatement pStatment = getConnection().prepareStatement(sql);
        return pStatment;
    }

    public PreparedStatement getInsertNewTypePreparedStatment(String typeName) throws Exception {
        String sql = "INSERT INTO `devices_types` (`type_id`, `type`) VALUES (NULL, ? )";

        PreparedStatement pStatment = getConnection().prepareStatement(sql);
        pStatment.setString(1, typeName);
        return pStatment;
    }

    public PreparedStatement getUpdateTypePreparedStatment(int typeId, String typeName) throws Exception {
        String sql = "UPDATE `devices_types`" +
"                    SET `type`=  ? " +
"                     WHERE devices_types.type_id = ?  ";

        PreparedStatement pStatment = getConnection().prepareStatement(sql);
        pStatment.setString(1, typeName);
        pStatment.setInt(2, typeId);
        return pStatment;
    }

    public PreparedStatement getDeleteTypePreparedStatment(int typeId) throws Exception {
        String sql = "DELETE from devices_types WHERE devices_types.type_id  = ?  ";

        PreparedStatement pStatment = getConnection().prepareStatement(sql);
        pStatment.setInt(1, typeId);
        return pStatment;
    }

    public PreparedStatement getTypeIdFromItsNamePreparedStatment(String typeName) throws Exception {
        String sql = "SELECT type_id FROM `devices_types` WHERE type =  ? ";

        PreparedStatement pStatment = getConnection().prepareStatement(sql);
        pStatment.setString(1, typeName);
        return pStatment;
    }
    public PreparedStatement getTypeFromItsNamePreparedStatment(Connection connection ,String typeName) throws Exception {
        String sql = "SELECT * FROM `devices_types` WHERE type =  ? ";

        PreparedStatement pStatment = getConnection().prepareStatement(sql);
        pStatment.setString(1, typeName);
        return pStatment;
    }

}
