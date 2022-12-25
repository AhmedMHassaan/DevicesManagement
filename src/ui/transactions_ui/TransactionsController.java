/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.transactions_ui;

import base.AdvancedTable;
import data.pojo.Department;
import data.pojo.Device;
import data.pojo.responses.DeviceTransactionResponse;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import repository.DepartmentsRepository;
import repository.DevicesRepository;

/**
 *
 * @author pc
 */
public class TransactionsController extends base.BaseController {

    private final ArrayList<DeviceTransactionResponse> allTransactions = new ArrayList<>();
    private DevicesRepository devicesRepository;
    private ArrayList<Department> allDepartmentForFilter;

    public TransactionsController(DevicesRepository devicesRepository) {
        this.devicesRepository = devicesRepository;
    }

    public void getAllTransactionsThenFillTable(AdvancedTable table, DeviceTransactionResponse filter) {

        ArrayList<DeviceTransactionResponse> transactions = getAllDevicesTransactions(filter);
        if (transactions != null) {
            allTransactions.clear();
            allTransactions.addAll(transactions);
        }

        System.out.println("Filter result with Sizw => " + transactions.size());

        fillTableWithTransactions(table, transactions);
    }

    public void getAllTransactionsThenFillTable(AdvancedTable table, int deviceId, DeviceTransactionResponse filter) {

        ArrayList<DeviceTransactionResponse> transactions = getAllDevicesTransactions(deviceId);
        if (transactions != null) {
            allTransactions.clear();
            allTransactions.addAll(transactions);
        }

        fillTableWithTransactions(table, transactions);
    }

    @Override
    public void destroy() {
        devicesRepository = null;
        allTransactions.clear();

        System.gc();
    }

    public ArrayList<DeviceTransactionResponse> getCachedTransactions() {
//        return new ArrayList<>(allTransactions);
        return allTransactions;
    }

    private ArrayList<DeviceTransactionResponse> getAllDevicesTransactions(int deviceId) {
//        System.out.println("devRepo = "+devicesRepository);
        return devicesRepository.getLocalDeviceTransactions(deviceId);
    }

    private ArrayList<DeviceTransactionResponse> getAllDevicesTransactions(DeviceTransactionResponse filter) {
//        System.out.println("devRepo = "+devicesRepository);
        return devicesRepository.getLocalDeviceTransactions(filter);
    }

    public ArrayList<Department> getAllDepartmentForFilter() {
        if (allDepartmentForFilter != null && allDepartmentForFilter.size() > 0) {
            return allDepartmentForFilter;
        } else {
            return DepartmentsRepository.getInstance().getAllLocalDepartments();
        }
    }

    private void fillTableWithTransactions(AdvancedTable table, ArrayList<DeviceTransactionResponse> transactions) {
//        table.clearTable();
        DefaultTableModel model = table.getMutableModel();
        table.clearTable();

        Object[] row = new Object[10];

        transactions.forEach((transaction) -> {
            Device device = transaction.getDevice();
            row[0] = transaction.getTransactionId();
            row[1] = device.getSerialNumber();
            row[2] = device.getBrand().getBrandName() + " - " + device.getModel().getModelName();
            row[3] = device.getType().getTypeName();
            row[4] = transaction.getOldDepartment().getDepartmentName();
            row[5] = transaction.getNewDepartment().getDepartmentName();
            row[6] = transaction.getSenderName();
            row[7] = transaction.getReceiverName();
            row[8] = transaction.getTransactionReason();
            row[9] = transaction.getTransitionTimestamp();

//            JTextField txt = new JTextField(device.getAddingTimestamp());
//            txt.setFont(Font.getFont(Font.SERIF));
//            txt.setBackground(Color.yellow);
//            row[5] = txt;
            model.addRow(row);

        });

//        model.fireTableDataChanged();
        table.setModel(model);
//        System.out.println("Model Assigned to Table");

    }

    DeviceTransactionResponse getSelectTransition(AdvancedTable table) throws Exception {
        int index = table.getSelectedRow();
        if (index > -1) {
            return getCachedTransactions().get(index);
        } else {
            throw new Exception("قم بالأختيار من الجدول أولا");
        }
    }

}
