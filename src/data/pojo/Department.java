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
public class Department {
    
    @SerializedName("dep_id")
    private int departmentId;
    
    @SerializedName("department")
    private String departmentName;

    @SerializedName("devives_count_in_dep")
    private int devicesCountInDepartment;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        
    }

    
    
    
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDevicesCountInDepartment() {
        return devicesCountInDepartment;
    }

    public void setDevicesCountInDepartment(int devicesCountInDepartment) {
        this.devicesCountInDepartment = devicesCountInDepartment;
    }

    
    
    
    
    
    
}
