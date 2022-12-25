/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.devices;

import base.AdvancedTable;
import data.pojo.Brand;
import data.pojo.Department;
import data.pojo.Device;
import data.pojo.DeviceSearchFields;
import data.pojo.DeviceTransaction;
import data.pojo.DeviceType;
import data.pojo.Model;
import data.pojo.responses.DeviceTransactionResponse;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Frame;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repository.DepartmentsRepository;
import repository.DevicesRepository;
import repository.ModelsRepository;
import repository.TypesRepository;
import uis_items.CustomProgressDialog;
import utils.ConfigurationsUtils;
import utils.MessageBox;

/**
 *
 * @author pc
 */
public class DevicesController {

    private DevicesRepository devicesRepository;
    private DepartmentsRepository departmentsRepository;
    private TypesRepository typesRepository;
    private ModelsRepository modelsRepository;
    private final ArrayList<Device> allDevices;
    private final ArrayList<Department> allDepartments;
    private final ArrayList<DeviceType> allTypes;
    private final ArrayList<Model> allModels;

    private final char LINE_SEPARATOR = ',';
//    private final String EXCEL_FILE_NAME = FilePathsConstants.DEVICES_EXPORT_FILE_PATH;
//    private  String EXCEL_FILE_NAME =""; 

    public DevicesController(DevicesRepository repository, DepartmentsRepository departmentsRepository, TypesRepository _typesRepo, ModelsRepository _modelsRepo) {
        this.devicesRepository = repository;
        this.departmentsRepository = departmentsRepository;
        this.typesRepository = _typesRepo;
        this.modelsRepository = _modelsRepo;
        this.allDevices = new ArrayList<>();
        this.allDepartments = new ArrayList<>();
        this.allTypes = new ArrayList<>();
        this.allModels = new ArrayList<>();
    }

    ArrayList<Device> getCachedDevices() {
//        ArrayList<Device> devices = new ArrayList<>(); // because java use object; 
//        devices.addAll(allDevices);
        return allDevices;
    }

    ArrayList<Department> getCachedDepartments() {
        if (allDepartments == null) {
            return new ArrayList<>();
        }

        return allDepartments;
    }

    ArrayList<DeviceType> getCachedTypes() {
        if (allTypes == null) {
            return new ArrayList<>();
        }

        return allTypes;
    }

    ArrayList<Model> getCachedModels() {
        if (allModels == null) {
            return new ArrayList<>();
        }

        return allModels;
    }

    public ArrayList<Device> getAllDevices(DeviceSearchFields deviceSearch) {
//        ArrayList<Device> devices = devicesRepository.getAllDevices(deviceSearch);
        ArrayList<Device> devices = devicesRepository.getAllLocalDevices(deviceSearch);
        if (devices != null) {
            this.allDevices.clear();
            this.allDevices.addAll(devices);
        }

        return devices;
    }

    /*public ArrayList<Device> getAllDevices(String serial, int depId) {
    ArrayList<Device> devices = devicesRepository.getAllDevices(serial);
    if (devices != null) {
    this.allDevices.clear();
    this.allDevices.addAll(devices);
    }
    
    return devices;
    }*/
    public boolean addNewDevice(Device device) {
        return devicesRepository.insertDevice(device);
    }

    public boolean updateDevice(Device device) {
//        String deviceName = Base64Utils.encode(device.getDeviceName());
//        device.setDeviceName(deviceName);
//        return devicesRepository.updateDevice(device);
        return devicesRepository.updateLocalDevice(device);
    }

    public void fillDevicesTable(AdvancedTable table) {
        table.clearTable();
        DefaultTableModel model = table.getMutableModel();

        Object[] row = new Object[6];

        getCachedDevices().forEach((device) -> {
            row[0] = device.getDeviceName();
            row[1] = device.getSerialNumber();
            row[2] = device.getModel().getModelName();
            row[3] = device.getBrand().getBrandName();
            row[4] = device.getType().getTypeName();
            row[5] = device.getCurrentDepartment().getDepartmentName();
//            row[6] = device.getAddingTimestamp();
//            JTextField txt = new JTextField(device.getAddingTimestamp());
//            txt.setFont(Font.getFont(Font.SERIF));
//            txt.setBackground(Color.yellow);
//            row[5] = txt;
            model.addRow(row);
        });

        model.fireTableDataChanged();

    }

    public void destroy() {
        devicesRepository = null;
        departmentsRepository = null;
        typesRepository = null;
        modelsRepository = null;
        allDevices.clear();
        allTypes.clear();
        allModels.clear();
        allDepartments.clear();

    }

    Device getSelectedDevice(AdvancedTable tableDevices) throws Exception {
        int index = tableDevices.getSelectedRow();
        if (index == -1) {
            throw new Exception("يرجي اختيار جهاز لعرض التفاصيل");
        }
        if (index >= getCachedDevices().size()) {
            throw new Exception("عنصر غير معروف");
        }

        return getCachedDevices().get(index);

    }

    void showDeviceInfo(
            Device selectedDevice, JLabel lblCurrentDep, JLabel lblName, JLabel lblSerial, JTextField txtNewName, JLabel lblAddingTime, JTextField txtSender) {

        lblCurrentDep.setText(selectedDevice.getCurrentDepartment().getDepartmentName());
        String name = makeNameFromModelAndBrand(selectedDevice.getModel(), selectedDevice.getBrand()) + " **  " + selectedDevice.getDeviceName();
        lblName.setText(name);
        txtNewName.setText(selectedDevice.getDeviceName());
        lblAddingTime.setText(selectedDevice.getAddingTimestamp());

        String sender = ConfigurationsUtils.getSenderName();
        txtSender.setText(sender);
        lblSerial.setText(selectedDevice.getSerialNumber());

    }

    public ArrayList<Department> getAllDepartments() {
//        ArrayList<Department> deps = departmentsRepository.getAllDepartments();
        ArrayList<Department> deps = departmentsRepository.getAllLocalDepartments(new int[]{});
        if (deps != null) {
            this.allDepartments.clear();
            this.allDepartments.addAll(deps);
        }

        return deps;

    }

    ArrayList<DeviceType> getAllTypes() {
//        ArrayList<DeviceType> types = typesRepository.getAllTypes();
        ArrayList<DeviceType> types = typesRepository.getAllLocalTypes();
        if (types != null) {
            this.allTypes.clear();
            this.allTypes.addAll(types);
        }

        return types;
    }

    ArrayList<Model> getAllModels() {
//         ArrayList<Model> models = modelsRepository.getAllModels(false);
        ArrayList<Model> models = modelsRepository.getAllLocalModels("", "");
        if (models != null) {
            this.allModels.clear();
            this.allModels.addAll(models);
        }

        return models;
    }

    public void fillDepartmentsIn(JComboBox<String> comboDeps) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        getCachedDepartments().forEach((dep) -> {
            model.addElement(dep.getDepartmentName());
        });

        comboDeps.setModel(model);
        comboDeps.setSelectedIndex(-1);

    }

    public void fillTypesIn(JComboBox<String> comboTypes) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        getCachedTypes().forEach((type) -> {
            model.addElement(type.getTypeName());
        });

        comboTypes.setModel(model);
        comboTypes.setSelectedIndex(-1);

    }

    public void fillModelsIn(JComboBox<String> comboModels) {
        DefaultComboBoxModel<String> dataModel = new DefaultComboBoxModel<>();
        getCachedModels().forEach((model) -> {
            dataModel.addElement(model.getModelName());
        });

        comboModels.setModel(dataModel);
        comboModels.setSelectedIndex(-1);

    }

    private String makeNameFromModelAndBrand(Model model, Brand brand) {
        return "" + brand.getBrandName() + " - " + model.getModelName();
    }

    boolean deleteSelectedDevice(AdvancedTable table) throws Exception {
        Device device = getSelectedDevice(table);

//        return devicesRepository.deleteSelectedDevices(new int[]{device.getDeviceId()});
        return devicesRepository.deleteSelectedLocalDevices(new int[]{device.getDeviceId()});

    }

    boolean moveDeviceToAnotherDepartment(Frame parentForProgress,AdvancedTable table, JComboBox<String> comboDeps, JTextField txtDeviceNewName, JTextField txtSender, JTextField txtReceiver, JTextArea txtTransReason) throws Exception {

        Device selectedDevice = getSelectedDevice(table);
        String deviceNewName = txtDeviceNewName.getText().trim();
        String sender = txtSender.getText().trim();
        String receiver = txtReceiver.getText().trim();
        String reason = txtTransReason.getText().trim();

        Department distDepartment = getSelectedDepartment(comboDeps);

        if (deviceNewName.isEmpty()) {
            throw new Exception("يرجي كتابة الاسم الجديد للجهاز");
        }
        if (sender.isEmpty()) {
            throw new Exception("يرجي كتابة اسم أمين العهدة");
        }

        if (receiver.isEmpty()) {
            throw new Exception("يرجي كتابة اسم المستلم");
        }

        if (reason.isEmpty()) {
            throw new Exception("يرجي وضع سبب لنقل الجهاز");
        }
        CustomProgressDialog.showProgressDialog(parentForProgress, "جار نقل الجهاز  ..");
        return moveDeviceTo(
                new DeviceTransaction(
                        selectedDevice.getDeviceId(),
                        selectedDevice.getCurrentDepartment().getDepartmentId(),
                        distDepartment.getDepartmentId(),
                        deviceNewName,
                        sender,
                        receiver,
                        reason
                )
        );

    }

    public Department getSelectedDepartment(JComboBox<String> comboDeps) throws Exception {
        int index = comboDeps.getSelectedIndex();
        if (index == -1) {
            throw new Exception("يرجي اختيار الفرع");
        }

        if (index >= getCachedDepartments().size()) {
            throw new Exception("يرجي اختيار قسم صحيح");
        }
        return getCachedDepartments().get(index);
    }

    public DeviceType getSelectedType(JComboBox<String> comboTypes) throws Exception {
        int index = comboTypes.getSelectedIndex();
        if (index == -1) {
            throw new Exception("يرجي اختيار النوع");
        }

        if (index >= getCachedTypes().size()) {
            throw new Exception("يرجي اختيار نوع  صحيح");
        }
        return getCachedTypes().get(index);
    }

    public Model getSelectedModel(JComboBox<String> comboModels) throws Exception {
        int index = comboModels.getSelectedIndex();
        if (index == -1) {
            throw new Exception("يرجي اختيار النوع");
        }

        if (index >= getCachedModels().size()) {
            throw new Exception("يرجي اختيار نوع  صحيح");
        }
        return getCachedModels().get(index);
    }

    private boolean moveDeviceTo(DeviceTransaction deviceTransaction) {
//        return devicesRepository.moveDeviceToAnotherDepartment(deviceTransaction);
        return devicesRepository.moveLocalDeviceToAnotherDepartment(deviceTransaction);
    }

    void search(DeviceSearchFields deviceSearchFields) {

        getAllDevices(deviceSearchFields);
    }

    boolean deleteSelectedDevices(AdvancedTable tableDevices) {
        int[] selectedRows = tableDevices.getSelectedRows();

        if (selectedRows.length == 0) {
            showNoItemSelectedErrorMessage();
            return false;
        }
        int option = JOptionPane.showConfirmDialog(tableDevices, "سيتم حذف الأجهزة المحددة نهائيا\nهل تريد المتابعة", "حذف ؟", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option != JOptionPane.YES_OPTION) {
            return false;
        }
        ArrayList<Device> selectedDevices = getSelectedDevicesFromSelectedRows(selectedRows);
        int[] selectedIDs = new int[tableDevices.getSelectedRowCount()];

        for (int i = 0; i < selectedDevices.size(); i++) {
            Device device = selectedDevices.get(i);
            selectedIDs[i] = device.getDeviceId();
        }

        return deleteSelectedDevicesFromDatabase(selectedIDs);
    }

    private ArrayList<Device> getSelectedDevicesFromSelectedRows(int[] selectedRows) {
        ArrayList<Device> selectedDevices = new ArrayList<>();
        for (int i = 0; i < selectedRows.length; i++) {
            int rowIndex = selectedRows[i];
            Device selectedDevice = getCachedDevices().get(rowIndex);
            selectedDevices.add(selectedDevice);
        }
        return selectedDevices;
    }

    private boolean deleteSelectedDevicesFromDatabase(int[] selectedIDs) {
//        return devicesRepository.deleteSelectedDevices(selectedIDs);
        return devicesRepository.deleteSelectedLocalDevices(selectedIDs);
    }

    private void showNoItemSelectedErrorMessage() {
        MessageBox.showErrorMessage("يرجي تحديد أجهزة أولا");
    }

    void exportDevicesAsExellSheet(AdvancedTable tableDevices, String fileName) throws Exception {

        if (getCachedDevices().isEmpty()) {
            throw new Exception("لا توجد أي أجهزة لحفظ الملف");
        }

//        int coloumnsCount = tableDevices.getColumnCount();
//        for (int i = 0; i < coloumnsCount; i++) {
//            System.out.println("Column " + tableDevices.getColumnName(i));
//        }
        XSSFWorkbook wb = new XSSFWorkbook();
//        Workbook wb = new XSSFWorkbook();
        XSSFCreationHelper createHelper = wb.getCreationHelper();
        XSSFSheet sheet = wb.createSheet("الأجهزة");

        XSSFRow excelHeader = sheet.createRow(0);

        XSSFFont boldFont = createBoldFont(wb);

        addTableHeader(createHelper, excelHeader, boldFont);
        addTableValues(tableDevices, getCachedDevices(), boldFont, createHelper, sheet);
//        saveExcelFile(wb, EXCEL_FILE_NAME);
        saveExcelFile(wb, fileName);
        CustomProgressDialog.hideProgressDialog();
        showOpenFileMessageAlert(tableDevices.getParent(), fileName);
//        addTableValuesAsCVs(tableDevices, getCachedDevices());

    }

    private void openExcelFile(String fileName) {
        try {
            Desktop.getDesktop().open(new File(fileName));
        } catch (IOException ex) {
            MessageBox.showErrorMessage(fileName + " غير موجود في الملفات \n" + ex.getMessage());
        }
    }

    private void addHeaderCellToExcelSheet(XSSFCreationHelper creationHelper, XSSFRow excelHeader, int cellIndex, String cellValue, XSSFFont font) {

        addCellToRow(creationHelper, excelHeader, cellIndex, cellValue, font);

    }

    private void addTableHeader(XSSFCreationHelper createHelper, XSSFRow excelHeader, XSSFFont boldFont) {
//        addHeaderCellToExcelSheet(createHelper, excelHeader, 0, "م", boldFont);
        addHeaderCellToExcelSheet(createHelper, excelHeader, 0, "الاسم", boldFont);
        addHeaderCellToExcelSheet(createHelper, excelHeader, 1, "السيريال", boldFont);
        addHeaderCellToExcelSheet(createHelper, excelHeader, 2, "الموديل", boldFont);
        addHeaderCellToExcelSheet(createHelper, excelHeader, 3, "النوع", boldFont);
        addHeaderCellToExcelSheet(createHelper, excelHeader, 4, "الفرع", boldFont);
        addHeaderCellToExcelSheet(createHelper, excelHeader, 5, "وقت الإضافة", boldFont);
//        addHeaderCellToExcelSheet(createHelper, excelHeader, 6, "م", boldFont);
//        addHeaderCellToExcelSheet(createHelper, excelHeader, 7, "م", boldFont);
    }

    private XSSFFont createBoldFont(XSSFWorkbook wb) {

        XSSFFont boldFont = wb.createFont();
        boldFont.setBold(true);
        return boldFont;
    }

    private void addTableValues(AdvancedTable tableDevices, ArrayList<Device> devicesList, XSSFFont font, XSSFCreationHelper creationHelper, XSSFSheet sheet) throws Exception {

//        int lineCounter = 1;
        for (int i = 0; i < devicesList.size(); i++) {
            XSSFRow excelRow = sheet.createRow(i + 1);
            Device device = devicesList.get(i);
//            addCellToRow(creationHelper, excelRow, 0, "" + (i + 1), font);
            addCellToRow(creationHelper, excelRow, 0, device.getDeviceName(), font);
            addCellToRow(creationHelper, excelRow, 1, device.getSerialNumber(), font);
            addCellToRow(creationHelper, excelRow, 2, device.getModel().getModelNameWithBrand(), font);
            addCellToRow(creationHelper, excelRow, 3, device.getType().getTypeName(), font);
            addCellToRow(creationHelper, excelRow, 4, device.getCurrentDepartment().getDepartmentName(), font);
            addCellToRow(creationHelper, excelRow, 5, device.getAddingTimestamp(), font);
        }

    }

    private void addTableValuesAsCVs(AdvancedTable tableDevices, ArrayList<Device> devicesList) throws Exception {

        File exportedFile = createCSVfileForExcportedDevices();
//        PrintWriter printWriter = new PrintWriter(exportedFile,"utf-8");
        PrintWriter printWriter = new PrintWriter(exportedFile);

//        addHeaderLineToCSVfile();
        String headerLine
                = new StringBuilder()
                        //                        .append("م").append(LINE_SEPARATOR)
                        .append("السيريال").append(LINE_SEPARATOR)
                        .append("الموديل").append(LINE_SEPARATOR)
                        .append("النوع").append(LINE_SEPARATOR)
                        .append("الفرع").append(LINE_SEPARATOR)
                        .append("وقت الإضافة")
                        .toString();

        printWriter.println(headerLine);

        final StringBuilder values = new StringBuilder();
        int lineCounter = 1;
        devicesList.forEach((device) -> {

            values
                    //                    .append(lineCounter).append(LINE_SEPARATOR)
                    .append(device.getSerialNumber()).append(LINE_SEPARATOR)
                    .append(device.getModel().getModelName()).append(LINE_SEPARATOR)
                    .append(device.getType().getTypeName()).append(LINE_SEPARATOR)
                    .append(device.getCurrentDepartment().getDepartmentName()).append(LINE_SEPARATOR)
                    .append(device.getAddingTimestamp());

            values.append("\n");

        });

//        System.out.println("Values "+values.toString());
        printWriter.append(values.toString());
        printWriter.flush();
        printWriter.close();
    }

    private File createCSVfileForExcportedDevices() {
        File file = new File("devices.csv");

        return file;
    }

    private void addCellToRow(XSSFCreationHelper creationHelper, XSSFRow row, int cellIndex, String cellValue, XSSFFont font) {
        Cell cell = row.createCell(cellIndex);
        cell.setCellValue(creationHelper.createRichTextString(cellValue));
        CellStyle cellStyle = cell.getCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        cellStyle.setFont(font);

        cell.setCellStyle(cellStyle);
    }

    private void saveExcelFile(XSSFWorkbook wb, String fileName) throws Exception {
        FileOutputStream fileOut;
//        try {
//        fileOut = new FileOutputStream("workbook.xls");
        fileOut = new FileOutputStream(fileName);
        wb.write(fileOut);
        fileOut.close();
    }

    private void showOpenFileMessageAlert(Component component, String fileName) {
        int option = JOptionPane.showConfirmDialog(component, "تم عمل الملف\nهل تريد فتحه الآن", "فتح الملف ؟", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
//            JOptionPane jOptionPane = new JOptionPane();
//            jOptionPane.setMessage("اكتب اسم الملف");
//            jOptionPane.setWantsInput(true);
//            JDialog dialog = jOptionPane.createDialog("Hi Hi Captin !");
//            
//            JTextField txtFileName = new JTextField(EXCEL_FILE_NAME.replace(".xls", ""));
//            
//            dialog.setVisible(true);

//            String fileName = txtFileName.getText();
//            String fileName = dialog.getComponents()[0].toString();
//            System.out.println("File Name = "+fileName);
//            jOptionPane.setValue(EXCEL_FILE_NAME);
//            jOptionPane.show();
            openExcelFile(fileName);
        }
    }

    public String getTypeNameFromTypeId(int typeId) {
        String deviceTypeName = null;
        for (int i = 0; i < getCachedTypes().size(); i++) {
            DeviceType cachedType = getCachedTypes().get(i);
            if (cachedType.getTypeId() == typeId) {
                deviceTypeName = cachedType.getTypeName();
                break;
            }
        }

        return deviceTypeName;
    }

    public String getModelNameFromModelId(int modelId) {
        String deviceModelName = null;
        for (int i = 0; i < getCachedModels().size(); i++) {
            Model cachedModel = getCachedModels().get(i);
            if (cachedModel.getTypeId() == modelId) {
                deviceModelName = cachedModel.getModelName();
                break;
            }
        }

        return deviceModelName;
    }

    void updateDeviceCountLabel(JLabel lblDeviceCount) {
        lblDeviceCount.setText("" + getCachedDevices().size());
    }

    void resetDeviceCountLabel(JLabel lblDeviceCount) {
        lblDeviceCount.setText(" -- ");
    }

    DeviceTransactionResponse getLastTransitionOperation() {
        return devicesRepository.getLastTransitionOperation();
    }

}
