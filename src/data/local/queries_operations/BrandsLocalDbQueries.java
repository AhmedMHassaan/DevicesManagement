/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.local.queries_operations;

import data.pojo.Brand;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author pc
 */
public class BrandsLocalDbQueries extends base.BaseLocalDbQueries {

    public BrandsLocalDbQueries(Connection connection) {
        super(connection);
    }

    public PreparedStatement getAllBrandsPreparedStatment(int typeId) throws Exception {
        StringBuilder sql = new StringBuilder("SELECT devices_brands.brand_id,"
                + "         ifnull((devices_brands.brand +  ' - ' +  devices_types.type), devices_brands.brand) as `brand_with_type`,devices_types.type, "
                + "         devices_brands.brand, COUNT(devices.id) as `devices_count_in_brand` "
                + "         from devices_brands"
                + "            LEFT OUTER JOIN devices_models "
                + "                on devices_models.brand_id = devices_brands.brand_id"
                + "            LEFT OUTER JOIN devices "
                + "                ON devices.model_id = devices_models.model_id "
                + "            LEFT OUTER JOIN devices_types "
                + "                ON devices_types.type_id = devices_models.type_id "
                + "            "
                + "            WHERE devices_brands.brand_id is not null ");

        if (typeId > 0) {
            sql.append("and  devices_models.type_id =  ").append(typeId);
        }

        sql.append("GROUP BY devices_brands.brand_id, devices_types.type_id ORDER by devices_types.type asc");

        PreparedStatement pStatment = getConnection().prepareStatement(sql.toString());
        return pStatment;
    }

    public PreparedStatement getInsertNewBrandPreparedStatment(String brandName) throws Exception {
        String sql = "INSERT INTO `devices_brands`  (`brand_id`, `brand`)  VALUES (NULL, ?)";

        PreparedStatement pStatment = getConnection().prepareStatement(sql);
        pStatment.setString(1, brandName);
        return pStatment;
    }
    public PreparedStatement getUpdateBrandPreparedStatment(int brandId, String brandName) throws Exception {
        String sql = "UPDATE devices_brands SET brand = ?   WHERE brand_id = ?  ";

        PreparedStatement pStatment = getConnection().prepareStatement(sql);
        pStatment.setString(1, brandName);
        pStatment.setInt(2, brandId);
        return pStatment;
    }
    public PreparedStatement getDeleteBrandPreparedStatment(int brandId) throws Exception {
        String sql = "DELETE FROM  devices_brands  WHERE brand_id = ?  ";

        PreparedStatement pStatment = getConnection().prepareStatement(sql);
        pStatment.setInt(1, brandId);
        return pStatment;
    }
    public PreparedStatement getBrandFromItsNamePreparedStatment(String brandName) throws Exception {
        String sql = "SELECT *  from devices_brands WHERE brand  = ? ";

        PreparedStatement pStatment = getConnection().prepareStatement(sql);
        pStatment.setString(1, brandName);
        return pStatment;
    }

}
