/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.pojo.responses;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author pc
 */
public class ReportRow {
    @SerializedName("dep")
    private String departmentName;
    
    @SerializedName("models_values")
    private int[] modelsValues;

    public String getDepartmentName() {
        return departmentName;
    }

    public ReportRow(String departmentName, int[] modelsValues) {
        this.departmentName = departmentName;
        this.modelsValues = modelsValues;
    }

    public ReportRow() {
    }

    
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int[] getModelsValues() {
        return modelsValues;
    }

    public void setModelsValues(int[] modelsValues) {
        this.modelsValues = modelsValues;
    }
    
    
    
}
