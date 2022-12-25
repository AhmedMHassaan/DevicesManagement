/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.import_devices;

import base.AdvancedTable;
import com.k33ptoo.components.KButton;
import data.pojo.Brand;
import data.pojo.Device;
import data.pojo.DeviceUpload;
import data.pojo.Model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import repository.BrandsRepository;
import repository.DepartmentsRepository;
import repository.DevicesRepository;
import repository.ModelsRepository;
import uis_items.CustomProgressDialog;
import utils.MessageBox;

/**
 *
 * @author pc
 */
public class ImportDevicesController {

//    private DevicesRepository devicesRepository;
//    private DepartmentsRepository departmentsRepository;
    private final ArrayList<DeviceUpload> allDevices = new ArrayList<>();
//    private final ArrayList<Department> allDepartments;

    private DevicesRepository devicesRepository;
    private final char LINE_SEPARATOR = ',';
    private final String EXCEL_FILE_NAME = "devices.xls";

    public ImportDevicesController(DevicesRepository devicesRepository_, ArrayList<DeviceUpload> devices) {
//        this.devicesRepository = repository;
//        this.departmentsRepository = departmentsRepository;
        this.allDevices.clear();
        this.allDevices.addAll(devices);
        this.devicesRepository = devicesRepository_;
//        this.allDepartments = new ArrayList<>();
    }

    public ArrayList<DeviceUpload> getCachedAllDevices() {
        return allDevices;
    }

    public void fillDevicesTable(AdvancedTable table) {
        fillTableWithList(table, allDevices);

    }

    void filterDevicesWithState(AdvancedTable tableDevices, String selectedState) {
        ArrayList<DeviceUpload> filteredList = filterImportedDevicesBy(selectedState);
        fillTableWithList(tableDevices, filteredList);
    }

    public void destroy() {
//        devicesRepository = null;
//        departmentsRepository = null;
        allDevices.clear();
        devicesRepository = null;

    }

    void showDeviceInfo(
            Device selectedDevice, JLabel lblCurrentDep, JLabel lblName, JLabel lblSerial, JLabel lblAddingTime) {

        lblCurrentDep.setText(selectedDevice.getCurrentDepartment().getDepartmentName());
        String name = makeNameFromModelAndBrand(selectedDevice.getModel(), selectedDevice.getBrand()) + " **  " + selectedDevice.getDeviceName();
        lblName.setText(name);
        lblAddingTime.setText(selectedDevice.getAddingTimestamp());

        lblSerial.setText(selectedDevice.getSerialNumber());

    }

    private String makeNameFromModelAndBrand(Model model, Brand brand) {
        return "" + brand.getBrandName() + " - " + model.getModelName();
    }

    void putRowsCountInLabel(JLabel lblDevicesCount, int devicesCount) {
        lblDevicesCount.setText(String.format("%d جهاز", devicesCount));
    }

    void getUploadingStatesThenPutIntoCombo(JComboBox<String> comboUploadingStates) {
        ArrayList<String> uploadingStatus = getUploadingStatusFromImportedList();
        System.out.println("States = " + uploadingStatus);
        fillStatesIntoCombo(comboUploadingStates, uploadingStatus);
//        selectFirstItemInCombo();
    }

    private ArrayList<String> getUploadingStatusFromImportedList() {
        final ArrayList<String> states = new ArrayList<>();
        final Map<String, Integer> statesCounter = new HashMap();
        states.add("الكل");
        allDevices.forEach(upload -> {
            String state = upload.getUploadingState().getUploadingResponseMessage();

//            states.add(state);
            Integer stateCounter = statesCounter.get(state);
            if (stateCounter == null) {
                stateCounter = 0;
            } else {
                stateCounter++;
            }
            statesCounter.put(state, stateCounter);
        });

        statesCounter.forEach((state, counter) -> {
//            states.add(String.format(Locale.ENGLISH, "%s  ( %d )", state, counter));
            states.add(state);
            System.out.println("Upload state message = " + state);
        });
        return states;
    }

    private void fillStatesIntoCombo(JComboBox<String> comboUploadingStates, ArrayList<String> states) {
        comboUploadingStates.removeAllItems();
//        comboUploadingStates.addItem("الكل");
        states.forEach((state) -> {
            comboUploadingStates.addItem(state);
        });

    }

    private void fillTableWithList(AdvancedTable table, ArrayList<DeviceUpload> devices) {
        table.clearTable();
        DefaultTableModel model = table.getMutableModel();

        Object[] row = new Object[table.getColumnCount()];

        devices.forEach((upload) -> {
            row[0] = upload.getDeviceToUpload().getDeviceId();
            row[1] = upload.getDeviceToUpload().getDeviceName();
            row[2] = upload.getDeviceToUpload().getSerialNumber();
            row[3] = upload.getDeviceToUpload().getModel().getModelName();
            row[4] = upload.getDeviceToUpload().getBrand().getBrandName();
            row[5] = upload.getDeviceToUpload().getType().getTypeName();
            row[6] = upload.getDeviceToUpload().getCurrentDepartment().getDepartmentName();

            row[7] = upload.getUploadingState().getUploadingResponseMessage();
//            row[6] = device.getAddingTimestamp();
//            JTextField txt = new JTextField(device.getAddingTimestamp());
//            txt.setFont(Font.getFont(Font.SERIF));
//            txt.setBackground(Color.yellow);
//            row[5] = txt;

            model.addRow(row);
        });

        model.fireTableDataChanged();
    }

    private ArrayList<DeviceUpload> filterImportedDevicesBy(String selectedState) {

        final ArrayList<DeviceUpload> filteredList = new ArrayList<>();
        allDevices.forEach((upload) -> {
            if (upload.getUploadingState().getUploadingResponseMessage().equals(selectedState)) {
                filteredList.add(upload);
            }
        });

        return filteredList;

    }

    void checkUploadingStates(JProgressBar progress, AdvancedTable table, JComboBox<String> comboUploadingStates, JButton btnCheck, KButton btnUpload, int checkingType) {
//        boolean isReadyForUploading = devicesRepository.checkDevicesForUploading(getCachedAllDevices());
//        ArrayList<DeviceUpload> checkDevicesResponse = devicesRepository.checkDevicesForUploading(getCachedAllDevices(), checkingType);
        btnCheck.setEnabled(false);
//        Thread thread = new Thread(() -> {
        progress.setIndeterminate(true);
        ArrayList<DeviceUpload> checkDevicesResponse = devicesRepository.checkLocalDevicesForUploading(getCachedAllDevices(), checkingType);
        if (checkDevicesResponse != null) {
            this.allDevices.clear();
            this.allDevices.addAll(checkDevicesResponse);

            System.out.println("All Devices Now Contain " + allDevices.size() + " Item");
            fillTableWithList(table, checkDevicesResponse);
            getUploadingStatesThenPutIntoCombo(comboUploadingStates);
//        btnCheck.setVisible(!isReadyForUploading);
//        btnUpload.setVisible(isReadyForUploading);
            CustomProgressDialog.hideProgressDialog();
            btnCheck.setVisible(checkDevicesResponse.isEmpty());
            btnUpload.setVisible(true);
//                if (!Thread.currentThread().getName().contains("AWT-EventQueue")) {
//                    Thread.currentThread().interrupt();
//                }

            if (checkDevicesResponse.size() > 0) {
                MessageBox.showMessage("تم فحص البيانات\nقم باستخدام القائمة المنسدلة للفلترة بين الحالات");
            }
            btnCheck.setEnabled(true);
            progress.setIndeterminate(false);

//        fillTableWithList(table, checkedListDevicesForUploading);
        }
//        });
//        thread.start();

    }

    void uploadDevices(JProgressBar progress, AdvancedTable table, JComboBox<String> comboUploadingStates, int checkingType) throws Exception {
//        ArrayList<DeviceUpload> uploadedDevices = devicesRepository.uploadDevicesToDatabase(getCachedAllDevices(), checkingType);
        progress.setIndeterminate(true);
        ArrayList<DeviceUpload> uploadedDevices = devicesRepository.uploadLocalDevicesToDatabase(progress, getCachedAllDevices(), checkingType, DepartmentsRepository.getInstance(), BrandsRepository.getInstance(), ModelsRepository.getInstance());

        if (uploadedDevices != null) {
            this.allDevices.clear();
            this.allDevices.addAll(uploadedDevices);
            System.out.println("All Devices Now Contain " + allDevices.size() + " Item");
            fillTableWithList(table, uploadedDevices);
            getUploadingStatesThenPutIntoCombo(comboUploadingStates);
            CustomProgressDialog.hideProgressDialog();
            MessageBox.showMessage("تم رفع " + uploadedDevices.size() + " من أصل " + getCachedAllDevices().size() + " جهاز ");
//        btnCheck.setVisible(!isReadyForUploading);
//        btnUpload.setVisible(isReadyForUploading);
//            btnCheck.setVisible(uploadedDevices.isEmpty());
//            btnUpload.setVisible(true);
//        fillTableWithList(table, checkedListDevicesForUploading);
        }

    }

    int getUploadingTypeFromRdoButtons(JRadioButton rdoCancelDuplocated, JRadioButton rdoSkipDuplicated, JRadioButton rdoUpdateDuplicated) {
        if (rdoSkipDuplicated.isSelected()) {
            return 1;
        } else if (rdoUpdateDuplicated.isSelected()) {
            return 2;
        } else if (rdoCancelDuplocated.isSelected()) {
            return 3;
        } else {
            return -1;
        }
    }

}
