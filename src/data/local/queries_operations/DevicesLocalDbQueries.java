/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.local.queries_operations;

import data.pojo.Device;
import data.pojo.DeviceSearchFields;
import data.pojo.DeviceTransaction;
import data.pojo.Model;
import data.pojo.responses.DeviceTransactionResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import org.joda.time.DateTime;

/**
 *
 * @author pc
 */
public class DevicesLocalDbQueries extends base.BaseLocalDbQueries {

    public DevicesLocalDbQueries(Connection connection) {
        super(connection);
    }

    public PreparedStatement getEachDepartmentWithModelsAndDevicesCount(int[] depsIds) throws Exception {
        StringBuilder sql = new StringBuilder("SELECT "
                + "departments.department,"
                + "devices_brands.brand,"
                + "devices_models.model ,"
                + "COUNT(devices.id) as `COUNT` "
                + ""
                + "        FROM departments"
                + "		LEFT OUTER JOIN devices"
                + "            ON devices.current_department_id = departments.dep_id "
                + "        LEFT  outer JOIN devices_models"
                + "            on devices.model_id = devices_models.model_id"
                + "        LEFT outer JOIN devices_brands"
                + "            on devices_models.brand_id = devices_brands.brand_id"
                + "            "
                + "        "
        );
        if (depsIds.length > 0) {
            String arr = Arrays.toString(depsIds).replace("[", "(").replace("]", ")").replace(" ", "");
//            sql.append("  WHERE departments.dep_id in '").append(arr);
            sql.append("  WHERE departments.dep_id in ").append(arr);
        }

        sql.append(" GROUP BY devices_models.model_id,departments.dep_id")
                .append(" ORDER BY devices_models.type_id asc");

        System.out.println("Sql => " + sql.toString());
        PreparedStatement pStatment = getConnection().prepareStatement(sql.toString());
        return pStatment;
    }

    public PreparedStatement getChangeDepartmentPreparedStatemtent(DeviceTransaction trans) throws SQLException {

        String sql = "UPDATE `devices`"
                + "                 SET "
                + "                    `current_department_id`='" + trans.getDistinationDepartmentId() + "',"
                + "                    `name` = '" + trans.getDeviceNewName() + "'"
                + "                    WHERE devices.id = '" + trans.getDeviceId() + "'";

        return getConnection().prepareStatement(sql);
    }

    public PreparedStatement getMoveDevicePreparedStatemtent(DeviceTransaction trans) throws SQLException {

        String sql = "INSERT INTO `devices_transactions` (`trans_id`, `device_id`, `current_department_id`, `distination_department_id`, `receiver_name`, `sender_name`, `trans_timestamp`, `transaction_reason`) "
                + "VALUES ("
                + "NULL,"
                + "'" + trans.getDeviceId() + "'  ,"
                + "'" + trans.getCurrentDepartmentId() + "'  ,"
                + "'" + trans.getDistinationDepartmentId() + "'  ,"
                + "'" + trans.getReceiver() + "'  ,"
                + "'" + trans.getSender() + "',"
                + " current_timestamp,"
                + "'" + trans.getTransactionReason() + "'"
                + ")";

        return getConnection().prepareStatement(sql);
    }

    public PreparedStatement getInsertNewDevicePreparedStatment(Device device) throws Exception {
        String sql = "INSERT INTO `devices` (`id`, `serial_number`, `current_department_id`, `name`, `model_id`, `adding_timestamp`) VALUES "
                + " ( NULL, ?, ?, ?, ?,current_timestamp ) ";
//          System.out.println(" SQL => "+sql);
//        System.out.println("Device => " + device);

//        String sql = "INSERT INTO `devices` (`id`, `serial_number`, `current_department_id`, `name`, `model_id`, `adding_timestamp`) VALUES "
//                + " (NULL, '" + device.getSerialNumber() + "',  '" + device.getCurrentDepartment().getDepartmentId() + "', '" + device.getDeviceName() + "', '" + device.getModel().getModelId() + "',current_timestamp() ); ";
//        
//        String sql = "INSERT INTO `devices` (`id`, `serial_number`, `current_department_id`, `name`, `model_id`, `adding_timestamp`) VALUES "
//                + " (NULL, 'hh',  '1', 'jjjj', '1',current_timestamp() ); ";
//        System.out.println("SQL => "+sql);
        PreparedStatement pStatment = getConnection().prepareStatement(sql);
        pStatment.setString(1, device.getSerialNumber());
        pStatment.setInt(2, device.getCurrentDepartment().getDepartmentId());
        pStatment.setString(3, device.getDeviceName());
        pStatment.setInt(4, device.getModel().getModelId());

//
        return pStatment;
//
//        String sql = "INSERT INTO `devices_models` (`model_id`, `brand_id`,`type_id`, `model`) VALUES  (NULL, '"+model.getBrandId()+"' , '"+model.getTypeId()+"', '"+model.getModelName()+"' )";
//        Statement stmt  = getConnection().createStatement();
//        return stmt;
    }

    /*public PreparedStatement getUpdateDevicePreparedStatment(Device device) throws Exception {
    String sql = "";
    PreparedStatement pStatment = getConnection().prepareStatement(sql);
    pStatment.setString(1, model.getModelName());
    pStatment.setInt(2, model.getBrandId());
    pStatment.setInt(3, model.getTypeId());
    pStatment.setInt(4, model.getModelId());
    
    return pStatment;
    }*/
    public PreparedStatement getDeleteDevicePreparedStatment(int deviceId) throws Exception {
        String sql = "DELETE from devices WHERE id = ? ";

        PreparedStatement pStatment = getConnection().prepareStatement(sql);
        pStatment.setInt(1, deviceId);
        return pStatment;
    }

    public PreparedStatement getUpdateDevicePreparedStatment(Device device) throws Exception {
        String sql = "UPDATE devices "
                + "SET name = ?,"
                + "serial_number = ?,"
                + "model_id = ?,"
                + "current_department_id = ? "
                + " where id = ?  ";

        PreparedStatement pStatment = getConnection().prepareStatement(sql);
        pStatment.setString(1, device.getDeviceName());
        pStatment.setString(2, device.getSerialNumber());
        pStatment.setInt(3, device.getModel().getModelId());
        pStatment.setInt(4, device.getCurrentDepartment().getDepartmentId());
        pStatment.setInt(5, device.getDeviceId());

        return pStatment;
    }

    public PreparedStatement getUpdateDeviceWithSerialNumberPreparedStatment(Device device) throws Exception {
        String sql = "UPDATE devices "
                + "SET name = ?,"
                //                + "serial_number = ?,"
                + "model_id = ?,"
                + "current_department_id = ? "
                + " where serial_number = ?  ";

        PreparedStatement pStatment = getConnection().prepareStatement(sql);
        pStatment.setString(1, device.getDeviceName());
//        pStatment.setString(2, device.getSerialNumber());
        pStatment.setInt(2, device.getModel().getModelId());
        pStatment.setInt(3, device.getCurrentDepartment().getDepartmentId());
        pStatment.setInt(4, device.getDeviceId());

        return pStatment;
    }

    public PreparedStatement getDeleteSelectedIDs(int[] devicesList) throws Exception {
        String devicesIDs = Arrays.toString(devicesList).replace("[", "(").replace("]", ")");
        String sql = "DELETE FROM devices where id in " + devicesIDs;

        PreparedStatement pStatment = getConnection().prepareStatement(sql);
//        pStatment.setString(1, typeName);
        return pStatment;
    }

    public PreparedStatement getAllDevicesPrepStatment(DeviceSearchFields deviceSearch) throws SQLException {
        StringBuilder sql = new StringBuilder(""
                + "SELECT DISTINCT devices.*, devices_types.*, departments.department as `current_department`, devices_models.*, devices_brands.*"
                + "                from devices"
                + "                    "
                + "                    INNER JOIN departments"
                + "                    ON devices.current_department_id = departments.dep_id"
                + "                    INNER JOIN devices_models"
                + "                        on devices.model_id = devices_models.model_id"
                + "                    INNER JOIN devices_types"
                + "                        on devices_types.type_id = devices_models.type_id"
                + "                    INNER JOIN devices_brands"
                + "                        on devices_brands.brand_id = devices_models.brand_id"
                + "                    "
                + "                    WHERE  devices.id is not null ");

        if (!deviceSearch.getDeviceSerialNumber().isEmpty()) {
            sql.append(" and lower(devices.serial_number) like '%").append(deviceSearch.getDeviceSerialNumber()).append("%' ");
        }

        if (!deviceSearch.getDeviceName().isEmpty()) {
            sql.append(" and lower(devices.name) like '%").append(deviceSearch.getDeviceName()).append("%' ");
        }
        if (deviceSearch.getDepartmentId() != -1) {
            sql.append("  and devices.current_department_id = ").append(deviceSearch.getDepartmentId());
        }

        if (deviceSearch.getTypeId() != -1) {
            sql.append("  and devices_types.type_id = ").append(deviceSearch.getTypeId());
        }

        if (deviceSearch.getModelId() != -1) {
            sql.append("  and devices.model_id = ").append(deviceSearch.getModelId());
        }

        sql.append(" ORDER BY devices.id ASC ");

        System.out.println("SQL => " + sql.toString());
        return getConnection().prepareStatement(sql.toString());

    }

    public PreparedStatement getAllTransactionsPrepStatment(DeviceTransactionResponse filter, boolean justLastTransition) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql
                .append("SELECT ")
                .append("devices_transactions.*,dist.department as `distination_department_name`,")
                .append("oldTo.department as `old_department`,")
                .append("devices.*,")
                .append("devices_models.* , ")
                .append(" devices_brands.*, ")
                .append(" devices_types.* ")
                .append("from ")
                .append("devices_transactions ")
                .append("INNER JOIN departments dist  ")
                .append("on dist.dep_id = devices_transactions.distination_department_id ")
                .append("INNER JOIN departments oldTo ")
                .append("on oldTo.dep_id = devices_transactions.current_department_id ")
                .append("INNER JOIN devices	")
                .append("on devices.id = devices_transactions.device_id ")
                .append("INNER JOIN devices_models ")
                .append("on devices.model_id = devices_models.model_id ")
                .append("INNER JOIN devices_brands ")
                .append("on devices_brands.brand_id = devices_models.brand_id ")
                .append("INNER JOIN devices_types ")
                .append("on devices_types.type_id = devices_models.type_id ")
                .append("WHERE devices.id is not NULL ");

        if (filter != null) {

            String newDepName = filter.getNewDepartment().getDepartmentName().trim();
            String oldDepName = filter.getOldDepartment().getDepartmentName().trim();
            String receiverName = filter.getReceiverName().trim();
            String senderName = filter.getSenderName().trim();
            String reason = filter.getTransactionReason().trim();
            String timeStamp = filter.getTransitionTimestamp();

            int deviceId = 0;
            if (filter.getDevice() != null) {
                deviceId = filter.getDevice().getDeviceId();
                if (deviceId > 0) {
                    sql.append(" and devices.id = '").append(deviceId).append("'");
                }
            }
            if (newDepName != null && !newDepName.isEmpty() && !"null".equals(newDepName)) {
                sql.append("and dist.department = '").append(newDepName).append("'");
            }

            if (oldDepName != null && !oldDepName.isEmpty() && !"null".equals(oldDepName)) {
                sql.append(" and oldTo.department = '").append(oldDepName).append("'");
            }

            if (receiverName != null && !receiverName.isEmpty()) {
                sql.append(" and devices_transactions.receiver_name like '%").append(receiverName).append("%' ");
            }

            if (senderName != null && !senderName.isEmpty()) {
                sql.append(" and devices_transactions.sender_name like '%").append(senderName).append("%' ");
            }

            if (reason != null && !reason.isEmpty()) {
                sql.append(" and devices_transactions.transaction_reason like '%").append(reason).append("%'");
            }

            if (timeStamp != null && !timeStamp.isEmpty()) {
                DateTime now = DateTime.now();
                String dateFormat = "yyyy-MM-dd";

                if ("اليوم".equals(timeStamp)) {
                    sql.append(" and devices_transactions.trans_timestamp like '%").append(now.toString(dateFormat)).append("%'");
                } else if ("الأمس".equals(timeStamp)) {
                    sql.append(" and devices_transactions.trans_timestamp like '%").append(now.minusDays(1).toString(dateFormat)).append("%'");

                } else if ("آخر سبع أيام".equals(timeStamp)) {

                    sql
                            .append(" and devices_transactions.trans_timestamp > '")
                            .append(now.minusDays(8).toString(dateFormat)).append("'")
                            .append(" and devices_transactions.trans_timestamp < '")
                            .append(now.plusDays(1).toString(dateFormat)).append("'");

                } else if ("آخر 30 يوم".equals(timeStamp)) {

                    sql
                            .append(" and devices_transactions.trans_timestamp > '")
                            .append(now.minusDays(31).toString(dateFormat)).append("'")
                            .append(" and devices_transactions.trans_timestamp < '")
                            .append(now.plusDays(1).toString(dateFormat)).append("'");

                } else if ("السنة الحالية".equals(timeStamp)) {
                    sql.append(" and devices_transactions.trans_timestamp like '%").append(now.getYear()).append("%'");
                }

            }

        }
        sql.append(" ORDER by devices_transactions.trans_id desc ");
        if (justLastTransition) {
            sql.append(" LIMIT 1 ");
        }
        System.out.println("SQL => " + sql.toString());
        return getConnection().prepareStatement(sql.toString());

    }

    private String getTimestampFromComboSelection(String transitionTimestamp) {
        DateTime now = DateTime.now();
        String dateFormat = "yyyy-MM-dd";

        if ("كل الأوقات".equals(transitionTimestamp)) {
            return null;
        } else if ("اليوم".equals(transitionTimestamp)) {
            return now.toString(dateFormat);
        } else if ("الأمس".equals(transitionTimestamp)) {
            return now.minusDays(1).toString(dateFormat);
        } else if ("آخر سبع أيام".equals(transitionTimestamp)) {
            return now.minusDays(7).toString(dateFormat);
        } else if ("آخر 30 يوم".equals(transitionTimestamp)) {
            return now.minusDays(30).toString(dateFormat);
        } else if ("السنة الحالية".equals(transitionTimestamp)) {
            return now.getYear() + "";
        } else {
            return null;
        }

    }

}
