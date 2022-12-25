/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.pojo.Department;
import data.pojo.Device;
import data.pojo.DeviceUpload;
import data.pojo.Model;
import data.pojo.UploadingStatus;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author pc
 */
public class ExcelReader {

    public static void read(File file) throws IOException {
//obtaining input bytes from a file  
        FileInputStream fis = new FileInputStream(file);
//creating workbook instance that refers to .xls file  
        HSSFWorkbook wb = new HSSFWorkbook(fis);
//creating a Sheet object to retrieve the object  
        HSSFSheet sheet = wb.getSheetAt(0);
//evaluating cell type   
        FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
        for (Row row : sheet) //iteration over row using for each loop  
        {
            for (Cell cell : row) //iteration over cell using for each loop  
            {
                switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
                    case NUMERIC:   //field that represents numeric cell type  
//getting the value of the cell as a number  
                        System.out.print(cell.getNumericCellValue() + "\t\t");
                        break;
                    case STRING:    //field that represents string cell type  
//getting the value of the cell as a string  
                        System.out.print(cell.getStringCellValue() + "\t\t");
                        break;
                }
            }
            System.out.println();
        }
    }

    public static void readNewExcel(File file) throws Exception {
        //obtaining input bytes from a file  
        FileInputStream fis = new FileInputStream(file);
//creating workbook instance that refers to .xls file  
        XSSFWorkbook wb = new XSSFWorkbook(fis);
//creating a Sheet object to retrieve the object  
        XSSFSheet sheet = wb.getSheetAt(0);
//evaluating cell type   

        FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
        for (Row row : sheet) //iteration over row using for each loop  
        {
            for (Cell cell : row) //iteration over cell using for each loop  
            {
                switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
                    case NUMERIC:   //field that represents numeric cell type  
//getting the value of the cell as a number  
                        System.out.print(cell.getNumericCellValue() + "\t\t");
                        break;
                    case STRING:    //field that represents string cell type  
//getting the value of the cell as a string  
                        System.out.print(cell.getStringCellValue() + "\t\t");
                        break;
                }
            }
            System.out.println();
        }

    }

    public static ArrayList<DeviceUpload> readNewExcelAsArray(File file) throws Exception {
        //obtaining input bytes from a file  
        FileInputStream fis = new FileInputStream(file);
//creating workbook instance that refers to .xls file  
        XSSFWorkbook wb = new XSSFWorkbook(fis);
//creating a Sheet object to retrieve the object  
        XSSFSheet sheet = wb.getSheetAt(0);
//evaluating cell type   

        final ArrayList<DeviceUpload> devicesList = new ArrayList<>();
        FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
        for (Row row : sheet) //iteration over row using for each loop  
        {

//            System.out.println("Row number is "+row.getRowNum());
            if (row.getRowNum() == 0) {
                // skip header of excel table;
                continue;
            }

//            String lineNumber = getCellValue(formulaEvaluator, row.getCell(0));
            String serialNumber = getCellValue(formulaEvaluator, row.getCell(0));

            String deviceName = getCellValue(formulaEvaluator, row.getCell(1));
            String deviceDepartment = getCellValue(formulaEvaluator, row.getCell(2));
            String deviceType = getCellValue(formulaEvaluator, row.getCell(3));
            String brandName = getCellValue(formulaEvaluator, row.getCell(4));
            String deviceModel = getCellValue(formulaEvaluator, row.getCell(5));
            Device device = new Device(
                    serialNumber,
                    deviceName,
                    brandName,
                    deviceDepartment,
                    deviceModel,
                    deviceType
            );
            
            System.out.println("Device is "+device);

            // we well treat device id as Excel Row Number instead of devoice id because no device Id founded here !!
            device.setDeviceId(row.getRowNum() + 1); // +1 becasue rows number start here from 0 not 1
//            System.out.println("Device is "+device.toString());
            devicesList.add(new DeviceUpload(new UploadingStatus("لم يتم الرفع"), device));
//            devicesList.add(new DeviceUpload(new UploadingStatus("Error Duplicate Id"), device));

        }

        System.out.println("In Thread "+Thread.currentThread().getName());
        
        wb.close();
        fis.close();
        return devicesList;
    }

    private static String getCellValue(FormulaEvaluator formulaEvaluator, Cell cell) {
        if (cell == null) {
//            System.out.println("Cell is null");
            return "";
        }
        switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
            case NUMERIC:   //field that represents numeric cell type
//getting the value of the cell as a number
//                return ((int)cell.getNumericCellValue()) + "";
                String cellValue = (int)cell.getNumericCellValue() + "";
//                return cellValue.replace(".0", "");
                return cellValue;
//                System.out.print(cell.getNumericCellValue() + "\t\t");
            case STRING:    //field that represents string cell type
//getting the value of the cell as a string
//                System.out.print(cell.getStringCellValue() + "\t\t");
                return cell.getStringCellValue();

            case BLANK:
                return "";
            default:
                System.out.println("yupe is " + formulaEvaluator.evaluateInCell(cell).getCellType());
                return "UNKNOWN_CELL_TYPE";
        }
    }
}
