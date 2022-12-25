/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import data.pojo.Model;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface ModelsRepositoryImpl {
    ArrayList<Model> getAllModels(boolean forceToShowCountMessage, String modelName, String departmentName ) ;
    
    boolean addNewModel(Model model);
    
    boolean deleteModel(int modelId);
    
    boolean updateModel(Model model);
    
    
}

