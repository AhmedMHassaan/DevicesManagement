/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.reports;

import base.BaseController;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import data.local.db.connection.LocalDatabaseConnection;
import data.local.queries_operations.DevicesLocalDbQueries;
import data.pojo.Device;
import data.pojo.DeviceSearchFields;
import data.pojo.Model;
import data.pojo.responses.ReportResponse;
import data.pojo.responses.ReportRow;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repository.DevicesRepository;
import repository.ModelsRepository;
import uis_items.CustomProgressDialog;
import utils.MessageBox;

/**
 *
 * @author pc
 */
public class ReportController extends BaseController {

    private DevicesRepository devicesRepository;
    private ModelsRepository modelsRepository;
    private ReportResponse devicesReport;

    final private Map<Integer, Color> departmentsColors = new HashMap<>();

    public ReportController(DevicesRepository devicesRepository, ModelsRepository modelsRepo) {
        this.devicesRepository = devicesRepository;
        this.modelsRepository = modelsRepo;

    }

    public void exportDesvicesSheet(String fileName) throws Exception {
//        ArrayList<Device> allDevices = devicesRepository.getAllDevices(new DeviceSearchFields());
        ArrayList<Device> allDevices = devicesRepository.getAllLocalDevices(new DeviceSearchFields());

        checkDevicesList(allDevices);
        saveDevicesInSheet(fileName, allDevices);
    }

    private void checkDevicesList(ArrayList<Device> devices) throws Exception {
        if (devices == null) {
            throw new Exception("لا توجد أي أجهزة في الداتابيز");
        }
        if (devices.isEmpty()) {
            throw new Exception("لا توجد أي أجهزة في الداتابيز");
        }

    }

    @Override
    public void destroy() {
        devicesRepository = null;
        modelsRepository = null;
        if (devicesReport != null) {
            devicesReport.getTableHeader().clear();
            devicesReport.getTableRows().clear();
            devicesReport = null;
        }

        departmentsColors.clear();
    }

    private void saveDevicesInSheet(String fileName, ArrayList<Device> devices) throws Exception {
        checkThatFileIsExcel(fileName);
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFCreationHelper createHelper = wb.getCreationHelper();
        XSSFSheet sheet = wb.createSheet("توزيع أجهزة الفرع");

        XSSFRow excelHeader = sheet.createRow(0);

        XSSFFont boldFont = createBoldFont(wb);

        addTableHeader(createHelper, excelHeader, boldFont);
        addTableValues(devices, boldFont, createHelper, sheet);
        saveExcelFile(wb, fileName);
        CustomProgressDialog.hideProgressDialog();
        showOpenFileMessageAlert(fileName);
    }

    private void openExcelFile(String fileName) {
        try {
            Desktop.getDesktop().open(new File(fileName));
        } catch (Exception ex) {
            MessageBox.showErrorMessage(fileName + " غير موجود في الملفات \n" + ex.getMessage());
        }
    }

    private void checkThatFileIsExcel(String fileName) throws Exception {
        if (fileName == null) {
            throw new Exception("اسم الملف غير معروف");
        }
        if (!fileName.endsWith("xlsx")) {
            throw new Exception("الملف ليس بصيغة Excel");
        }
    }

    private XSSFFont createBoldFont(XSSFWorkbook wb) {

        XSSFFont boldFont = wb.createFont();
        boldFont.setBold(true);
        return boldFont;
    }

    private void addTableHeader(XSSFCreationHelper createHelper, XSSFRow excelHeader, XSSFFont boldFont) {
//        addHeaderCellToExcelSheet(createHelper, excelHeader, 0, "م", boldFont);
        addHeaderCellToExcelSheet(createHelper, excelHeader, 0, "السيريال", boldFont);
        addHeaderCellToExcelSheet(createHelper, excelHeader, 1, "الاسم", boldFont);
        addHeaderCellToExcelSheet(createHelper, excelHeader, 2, "الفرع", boldFont);
        addHeaderCellToExcelSheet(createHelper, excelHeader, 3, "النوع", boldFont);
        addHeaderCellToExcelSheet(createHelper, excelHeader, 4, "الشركة", boldFont);
        addHeaderCellToExcelSheet(createHelper, excelHeader, 5, "الموديل", boldFont);
        addHeaderCellToExcelSheet(createHelper, excelHeader, 6, "وقت الإضافة", boldFont);
//        addHeaderCellToExcelSheet(createHelper, excelHeader, 6, "م", boldFont);
//        addHeaderCellToExcelSheet(createHelper, excelHeader, 7, "م", boldFont);
    }

    private void addHeaderCellToExcelSheet(XSSFCreationHelper creationHelper, XSSFRow excelHeader, int cellIndex, String cellValue, XSSFFont font) {

        addCellToRow(creationHelper, excelHeader, cellIndex, cellValue, font);

    }

    private void addCellToRow(XSSFCreationHelper creationHelper, XSSFRow row, int cellIndex, String cellValue, XSSFFont font) {
        XSSFCell cell = row.createCell(cellIndex);
        cell.setCellValue(creationHelper.createRichTextString(cellValue));
        CellStyle cellStyle = cell.getCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        cellStyle.setFont(font);

        cell.setCellStyle(cellStyle);
    }

    private void addTableValues(ArrayList<Device> devicesList, XSSFFont font, XSSFCreationHelper creationHelper, XSSFSheet sheet) throws Exception {

//        int lineCounter = 1;
        for (int i = 0; i < devicesList.size(); i++) {
            XSSFRow excelRow = sheet.createRow(i + 1);
            Device device = devicesList.get(i);
//            addCellToRow(creationHelper, excelRow, 0, "" + (i + 1), font);
            addCellToRow(creationHelper, excelRow, 0, device.getSerialNumber(), font);
            addCellToRow(creationHelper, excelRow, 1, device.getDeviceName(), font);
            addCellToRow(creationHelper, excelRow, 2, device.getCurrentDepartment().getDepartmentName(), font);
            addCellToRow(creationHelper, excelRow, 3, device.getType().getTypeName(), font);
            addCellToRow(creationHelper, excelRow, 4, device.getBrand().getBrandName(), font);
            addCellToRow(creationHelper, excelRow, 5, device.getModel().getModelName(), font);
            addCellToRow(creationHelper, excelRow, 6, device.getAddingTimestamp(), font);
//            System.out.println("Device => "+i + " Added !");
        }

    }

    private void saveExcelFile(XSSFWorkbook wb, String fileName) throws Exception {
        FileOutputStream fileOut;
//        try {
//        fileOut = new FileOutputStream("workbook.xls");
        fileOut = new FileOutputStream(fileName);
        wb.write(fileOut);
        fileOut.close();
        wb.close();
    }

    private void showOpenFileMessageAlert(String fileName) {
        int option = JOptionPane.showConfirmDialog(null, "تم عمل الملف\nهل تريد فتحه الآن", "فتح الملف ؟", JOptionPane.YES_NO_OPTION);
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

    public ReportResponse handleReportResponse(int[] depsIds, int[] modelsIds) throws Exception {
        ReportResponse reportResponse = new ReportResponse();

        // prepare table Header 
        ArrayList<Model> tableHeader = prepareAndGetTableHeader(modelsIds);
        reportResponse.setTableHeader(tableHeader);

        PreparedStatement preparedStatement = new DevicesLocalDbQueries(LocalDatabaseConnection.getConnection()).getEachDepartmentWithModelsAndDevicesCount(depsIds);
        ResultSet depsValuesCountResultSet = getTableRowsValuesResultSet(preparedStatement);
        ArrayList<Model> allModels = modelsRepository.getAllLocalModels("", "", new int[]{});
        ArrayList<ReportRow> tableRows = preapareAndGetTableRows(allModels, depsValuesCountResultSet);
        reportResponse.setTableRows(tableRows);

        return reportResponse;

    }

    private ArrayList<Model> prepareAndGetTableHeader(int[] modelsIds) {
        ArrayList<Model> localModels = modelsRepository.getAllLocalModels(null, null, modelsIds);
        localModels.add(0, new Model("المكان/ النوع", null, null));
        localModels.add(new Model("مج أجهزة الفرع", null, null));
        return localModels;
    }

    private ArrayList<ReportRow> preapareAndGetTableRows(ArrayList<Model> allLocalModels, ResultSet resultSet) throws Exception {
        //        ReportRow reportRow = new ReportRow();
        JsonArray reportRow = new JsonArray();
        ArrayList<ReportRow> reportTableRows = new ArrayList<>();

        //        Map<String, 
        final Set<String> departmentsNames = new HashSet<>();
        final Map<String, ArrayList<String>> modelsNamesInDepartment = new HashMap<>();
        final Map<String, Integer> modelNameWithDevicesCount = new HashMap<>();

        while (resultSet.next()) {
            String department = resultSet.getString("department");
            departmentsNames.add(department);

            ArrayList<String> oldModelsNames = modelsNamesInDepartment.getOrDefault(department, new ArrayList<>());
            String modelName = resultSet.getString("model");
            if (modelName != null && !modelName.isEmpty()) {
                oldModelsNames.add(modelName);
            }
            modelsNamesInDepartment.put(department, oldModelsNames);

        }
        JsonObject tableRow = new JsonObject();

        Object[] deps = departmentsNames.toArray();
        for (int depLoopIndex = 0; depLoopIndex < deps.length; depLoopIndex++) {
//            ReportRow reportRow = new ReportRow();

            String dep = deps[depLoopIndex] + "";
            tableRow.addProperty("dep", dep);

//            reportRow.add();deps[depLoopIndex]);
            ArrayList<String> modelNamesInDep = modelsNamesInDepartment.get(deps[depLoopIndex].toString());
//            ArrayList<Integer> modelsCountInRow = new ArrayList<>();
            JsonArray modelsCountInRow = new JsonArray();

            if (allLocalModels == null) {
                allLocalModels = new ArrayList<>();
            }
            int devicesSumForEachDep = 0;

            for (int modelLoopIndex = 0; modelLoopIndex < allLocalModels.size(); modelLoopIndex++) {
                Model model = allLocalModels.get(modelLoopIndex);
                ArrayList<Model> modelsInDepartment = modelsRepository.getAllLocalModels(model.getModelName(), dep, new int[]{});
                int devicesCount = 0;
                if (modelsInDepartment != null && modelsInDepartment.size() > 0) {
                    devicesCount = modelsInDepartment.get(0).getDevicesCountInModel();
                }

                devicesSumForEachDep += devicesCount;
                modelsCountInRow.add(devicesCount);
                if (isLastIndexInArray(allLocalModels, modelLoopIndex)) {
                    modelsCountInRow.add(devicesCount);
                    devicesSumForEachDep = 0;
                }

                int deviceCountValue = modelNameWithDevicesCount.getOrDefault(model.getModelName(), 0);
                modelNameWithDevicesCount.put(model.getModelName(), deviceCountValue + devicesCount);

            }

//            System.out.println("Models Values => "+new Gson().toJson(modelsCountInRow));
//            tableRow.addProperty("models_values", new Gson().toJson(modelsCountInRow));
            tableRow.add("models_values", modelsCountInRow);
            Type type = new TypeToken<ReportRow>() {
            }.getType();
            System.out.println("Table Row => " + tableRow.toString());
            ReportRow row = new Gson().fromJson(tableRow, type);
            reportTableRows.add(row);
        }

        return reportTableRows;

    }

    private ResultSet getTableRowsValuesResultSet(PreparedStatement preparedStatement) throws Exception {
        return preparedStatement.executeQuery();
    }

    private boolean isLastIndexInArray(ArrayList<Model> array, int i) {
        return i == (array.size() - 1);
    }

    public ReportResponse getReport(int[] depsIds, int[] modelsIds) {
//        this.devicesReport = DevicesRepository.getInstance().getDevicesReport(depsIds, modelsIds);
        this.devicesReport = devicesRepository.getLocalDevicesReport(depsIds, modelsIds);

        if (devicesReport.getTableRows() != null) {
            departmentsColors.clear();
            Random random = new Random();
            int red;
            int green;
            int blue;

            System.out.println("Table Rows => " + devicesReport.getTableRows().size());
            for (int i = 0; i < devicesReport.getTableRows().size(); i++) {
                red = random.nextInt(255);
                green = random.nextInt(255);
                blue = random.nextInt(255);
                departmentsColors.put(i, new Color(red, green, blue));
            }
        }
        /*try {
        ReportResponse reportResponse = reportController.handleReportResponse(depsIds, modelsIds);
        //            return DevicesRepository.getInstance().getDevicesReport(depsIds, modelsIds);
        return reportResponse;
        } catch (Exception ex) {
        Logger.getLogger(DevicesReportUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;*/
        return devicesReport;
    }

    public Color getDepartmentBackgroundIndicatorColor(int depIndex) {
        return departmentsColors.get(depIndex);
    }

    public Color getDepartmentForegroundIndicatorColor(int depIndex) {
        Color color = departmentsColors.get(depIndex);
        return new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue());
    }

    public ReportResponse getDeviceReport() {
        return devicesReport;
    }

}
