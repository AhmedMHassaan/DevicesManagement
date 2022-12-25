/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.local.local_db_repos;

import data.pojo.DeviceType;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public abstract class TypesLocalRepository {

    public abstract ArrayList<DeviceType> getAllLocalTypes();

    public abstract boolean addNewLocalType(String type);

    public abstract boolean deleteLocalType(int type);

    public abstract boolean updateLocalType(int typeId, String typeName);
    
    public abstract int getLocalTypeIdFromTypeName( String typeName);
    
    

}
