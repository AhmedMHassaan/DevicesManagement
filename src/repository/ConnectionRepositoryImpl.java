/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import data.pojo.responses.ServerResponse;
import utils.LiveData;

/**
 *
 * @author pc
 */
public interface ConnectionRepositoryImpl {
    
    boolean checkConnection();
    
    LiveData<ServerResponse<Boolean>> testConnection() ;
    
    
    
}
