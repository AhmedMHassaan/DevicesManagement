/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import data.pojo.Brand;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface BrandsRepositoryImpl {
    
    ArrayList<Brand> getAllBrands();
    ArrayList<Brand> getAllBrandsByTypeId(int typeId);
    
    ArrayList<Brand> getOnlyBrandNames();
    
    boolean addNewBrand(String brand);
    boolean deleteBrand(int brandId);
    boolean updateBrand(int brandId, String brandName);
    
    
    
}
