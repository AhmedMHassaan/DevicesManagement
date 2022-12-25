/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.local.queries_operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

/**
 *
 * @author pc
 */
public class DepartmentLocalDbQueries extends base.BaseLocalDbQueries {

    public DepartmentLocalDbQueries(Connection connection) {
        super(connection);
    }

    public PreparedStatement getAllDepartmentSqlStatement(int[] depsIds,String departmentName) throws SQLException {
        String allDepSql
                = "SELECT departments.* , IFnull(COUNT(devices.id), 0) as `devives_count_in_dep` "
                + "FROM `departments` "
                + "LEFT OUTER JOIN devices "
                + "     on devices.current_department_id = departments.dep_id "
                + " where departments.dep_id is not null";

        if (depsIds.length > 0) {
            String depsIdsString = Arrays.toString(depsIds).replace("[", "(").replace("]", ")");
            allDepSql += " and departments.dep_id in " + depsIdsString;
        }
        if (departmentName != null && !departmentName.isEmpty()) {
            allDepSql += " and departments.department = '" + departmentName+"'";
        }
        
        allDepSql += " GROUP BY departments.dep_id ";
        if (getConnection() == null) {
            System.out.println("Connection is nulll !!!");
        }
//        System.out.println("SQL => "+allDepSql);
        PreparedStatement prepareStatement = getConnection().prepareStatement(allDepSql);

        
        return prepareStatement;
    }

    public PreparedStatement getInsertNewDepartmentPreparedStatement(String departmentName) throws Exception {
        String sql = "INSERT INTO `departments` (`dep_id`, `department`) VALUES (NULL, ? ) ";

        PreparedStatement pStatment = getConnection().prepareStatement(sql);
//        System.out.println("Connection in insertDepartm sql is "+getConnection());
//        int executeUpdate = createStatement.executeUpdate(sql);
//        System.out.println("Exc => "+executeUpdate);

//        prepareStatement.setString(1, null);
        pStatment.setString(1, departmentName);

        return pStatment;
    }

    public PreparedStatement getDeleteDepartmentPreparedStatement(int depId) throws Exception {
        String sql = "DELETE FROM`departments` WHERE dep_id =  ? ";

        PreparedStatement pStatment = getConnection().prepareStatement(sql);
        pStatment.setInt(1, depId);

        return pStatment;
    }

    public PreparedStatement getUpdateDepartmentPreparedStatement(int departmentId, String departmentName) throws Exception {
        String sql = "UPDATE departments SET department = ? WHERE dep_id = ? ";

        PreparedStatement pStatment = getConnection().prepareStatement(sql);

        pStatment.setString(1, departmentName);
        pStatment.setInt(2, departmentId);

        return pStatment;
    }

    @Override
    public void destroy() {
        super.destroy();

    }

    public PreparedStatement getDepartmentByName(String department) throws SQLException {
        return getAllDepartmentSqlStatement(new int[]{}, department);
    }

}
