/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

import java.io.File;

/**
 *
 * @author pc
 */
public class FilePathsConstants {
    private final static String IMPORTING_FOLDER_NAME = "التنزيلات";
    private final static String EXCEL_EXTENSION_NAME = ".xlsx";
    
    private final static  String DEVICES_EXPORT_FILE_PATH = IMPORTING_FOLDER_NAME+"/"+"بيانات الأجهزة"+EXCEL_EXTENSION_NAME;
    
    
    private static void createDownloadsFolder(){
        File file = new File(IMPORTING_FOLDER_NAME);
        if (!file.exists()) {
            boolean isDirectoryCreated = file.mkdir();
            System.out.println("Dir Created ? "+isDirectoryCreated);
        }
    }
    
    
    
    private String getMainPath(){
        createDownloadsFolder();
        return IMPORTING_FOLDER_NAME+"/";
    }
    
    private String getDevicesReportFolderPath(){
        String path = getMainPath()+"تمام توزيعات الأجهزة";
        createFolder(path);
        return path+"/";
    }
    private String getDevicesFolderPath(){
        String path = getMainPath()+"بيانات الأجهزة";
        createFolder(path);
        return path+"/";
    }
    
    public String getDevicesExportPath(){
         String fileName = "  - بيانات الأجهزة" + System.currentTimeMillis();
        return getDevicesFolderPath()+fileName+EXCEL_EXTENSION_NAME;
    }
    
    public String getDevicesReportPath(){
        String fileName = "تمام توزيعات الأجهزة  -   " + System.currentTimeMillis();
        return getDevicesReportFolderPath()+fileName+EXCEL_EXTENSION_NAME;
    }

    private void createFolder(String path) {
        File file = new File(path);
        if (!file.exists()) {
            boolean isDirectoryCreated = file.mkdir();
//            System.out.println("Dir Created ? "+isDirectoryCreated);
        }
    }
}
