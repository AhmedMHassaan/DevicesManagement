/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import base.AdvancedFrame;
import com.google.gson.Gson;
import data.pojo.Config;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;

/**
 *
 * @author pc
 */
public class ConfigurationsUtils {

    private static File getConfFile() {
        String configPath = "configrations/confgs.json";
        File jsonFile = new File(configPath);
        return jsonFile;
    }

    private static Config loadConfigurations() throws Exception {

        File jsonFile = getConfFile();
        if (jsonFile.exists()) {
            FileReader fr = new FileReader(jsonFile);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            StringBuilder jsonObj = new StringBuilder();
            while ((line = br.readLine()) != null) {
                jsonObj.append(line).append("\n");

            }
            fr.close();
            br.close();

            return new Gson().fromJson(jsonObj.toString(), Config.class);

        } else {
            throw new Exception("غير قادر علي إيجاد ملق التعريفات");
        }
    }

    public static String getSenderName() {
        try {
            return loadConfigurations().getAmeenEl3ohda();
        } catch (Exception ex) {
            showError(ex);
            return "غير معروف";
        }
    }

    public static String getEndDate() {
        try {
            return loadConfigurations().getEndAppDate();
        } catch (Exception ex) {
            showError(ex);
            return DateTime.now().toString("yyyy-MM-dd");
        }
    }

    private static void showError(Exception error) {
        System.out.println("ConfigUtilsEx => " + error);
    }

    public static String getAppLogoImagePath() throws Exception {
//        try {
        return loadConfigurations().getAppLogoImagePath();
//        } catch (Exception ex) {
//            showError(ex);
//            URL resource = AdvancedFrame.class.getResource("/images_res/icons8-devices-64.png");
//            return resource.getFile().substring(1).replace("%20", "");
//        }
    }

    public static String getSplashScreenLogoPath() throws Exception {
//        try {
        return loadConfigurations().getSplahLogoPath();
//        } catch (Exception ex) {
//            showError(ex);
//            URL resource = AdvancedFrame.class.getResource("/images_res/icons8-devices-64.png");
//            return resource.getFile().substring(1).replace("%20", "");
//        }
    }

    public static String getAppName() throws Exception {
        return loadConfigurations().getAppName();
    }
    public static String getUnitName() throws Exception {
        return loadConfigurations().getUnitName();
    }
    public static String getDepartmentName() throws Exception {
        return loadConfigurations().getDepartmentName();
    }

    public static String getDepManagerName()throws Exception {
        return loadConfigurations().getDepManagerName();
    }

    public static String getDepManagerJobTitle()throws Exception{
        return loadConfigurations().getDepManagerJobTitle();
    }
}
