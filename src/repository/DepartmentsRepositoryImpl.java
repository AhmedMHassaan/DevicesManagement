/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import data.pojo.Department;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface DepartmentsRepositoryImpl {
    
    ArrayList<Department> getAllDepartments();
    
    boolean addNewDepartment(String department);
    boolean deleteDepartment(int departmentId);
    boolean updateDepartment(int departmentId, String departmentName);
    
    
    
}
