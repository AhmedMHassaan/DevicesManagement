/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.models_ui;

import base.BaseController;
import data.pojo.Brand;
import java.util.ArrayList;
import repository.BrandsRepository;

/**
 *
 * @author pc
 */
public class ModelsController extends BaseController{

    
    
    private BrandsRepository brandsRepository ;
    private final  ArrayList<Brand> brands = new ArrayList<>();

    public ModelsController(BrandsRepository brandsRepository) {
        this.brandsRepository = brandsRepository;
    }
    
    
    
    
    
    public ArrayList<Brand> getBrandsByType(int typeId){
        return brandsRepository.getAllBrandsByTypeId(typeId);
    }
    @Override
    public void destroy() {
        brandsRepository = null;
        brands.clear();
    }
    
}
