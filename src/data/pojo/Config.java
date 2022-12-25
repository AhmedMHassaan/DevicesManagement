/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.pojo;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author pc
 */
public class Config {
//    @SerializedName("frames_icon")
    @SerializedName("أيقونة الصفحات")
    private String appLogoImage ;
    
//    @SerializedName("ameen_elohda")
    @SerializedName("أمين العهدة")
    private String ameenEl3ohda;
    
    @SerializedName("end_app_date")
    private String endAppDate;
    
    
//    @SerializedName("splash_logo_path")
    @SerializedName("مسار صورة لوجو الوحدة")
    private String splahLogoPath;
    
//    @SerializedName("app_name")
    @SerializedName("اسم التطبيق")
    private String appName;
    
    
//    @SerializedName("militiarity_unit_name")
    @SerializedName("اسم الوحدة")
    private String unitName;
    
//    @SerializedName("department_name")
    @SerializedName("اسم الفرع")
    private String departmentName;
    
    
//    @SerializedName("depManagerName")
    @SerializedName("اسم ورتبة رئيس الفرع")
    private String depManagerName;
    
    
//    @SerializedName("depManagerJobTitle")
    @SerializedName("عنوان وظيفة رئيس الفرع")
    private String depManagerJobTitle;
    
    

    
    
    public String getAppLogoImagePath() {
        return appLogoImage;
    }

    public void setAppLogoImage(String imagePath) {
        this.appLogoImage = imagePath;
    }

    public String getAmeenEl3ohda() {
        return ameenEl3ohda;
    }

    public void setAmeenEl3ohda(String ameenEl3ohda) {
        this.ameenEl3ohda = ameenEl3ohda;
    }

    public String getEndAppDate() {
        return endAppDate;
    }

    public void setEndAppDate(String endAppDate) {
        this.endAppDate = endAppDate;
    }

    public String getSplahLogoPath() {
        return splahLogoPath;
    }

    public void setSplahLogoPath(String splahLogoPath) {
        this.splahLogoPath = splahLogoPath;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepManagerName() {
        return depManagerName;
    }

    public void setDepManagerName(String depManagerName) {
        this.depManagerName = depManagerName;
    }

    public String getDepManagerJobTitle() {
        return depManagerJobTitle;
    }

    public void setDepManagerJobTitle(String depManagerJobTitle) {
        this.depManagerJobTitle = depManagerJobTitle;
    }
    
    
    
    
    
    
}
