/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import data.pojo.DeviceType;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface TypesRepositoryImpl {
    
    ArrayList<DeviceType> getAllTypes();
    
    boolean addNewType(String brand);
    boolean deleteType(int brandId);
    boolean updateType(int brandId, String brandName);
    
    
    
}
