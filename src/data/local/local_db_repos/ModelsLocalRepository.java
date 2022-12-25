/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.local.local_db_repos;

import data.pojo.Model;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public abstract class ModelsLocalRepository {

    public abstract ArrayList<Model> getAllLocalModels(String modelName, String departmentName, int[] modelsIds);
    
    public abstract boolean addNewLocalModel(Model model);
    
    public abstract boolean deleteLocalModel(int modelId);
    
    public abstract boolean updateLocalModel(Model model);

}
