/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.local.local_db_repos;

import data.pojo.Department;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public abstract class DepartmentsLocalRepository {

    public abstract ArrayList<Department> getAllLocalDepartments();
    
    public abstract ArrayList<Department> getAllLocalDepartments(int[] depsIds, String department);

    public abstract boolean addNewLocalDepartment(String department);

    public abstract boolean deleteLocalDepartment(int departmentId);

    public abstract boolean updateLocalDepartment(int departmentId, String departmentName);

}
