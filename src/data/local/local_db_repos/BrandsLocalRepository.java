/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.local.local_db_repos;

import data.pojo.Brand;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public abstract class BrandsLocalRepository {

    public abstract ArrayList<Brand> getAllLocalBrands();

    public abstract ArrayList<Brand> getAllLocalBrandsByTypeId(int typeId);
    
    public abstract Brand getBrandFromItsName(String brandName);

    public abstract ArrayList<Brand> getOnlyLocalBrandNames();

    public abstract boolean addNewLocalBrand(String brand);

    public abstract boolean deleteLocalBrand(int brandId);

    public abstract boolean updateLocalBrand(int brandId, String brandName);
    
    

}
