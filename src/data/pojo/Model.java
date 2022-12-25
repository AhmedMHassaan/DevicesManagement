/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.pojo;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author pc
 */
public class Model {
    @SerializedName("model_id")
    private int modelId ;
    
    
    @SerializedName("brand_id")
    private int brandId ;
    
    
    @SerializedName("model")
    private String modelName;
    
    
    @SerializedName("brand")
    private String brandName;
    
    
    @SerializedName("devices_count_in_model")
    private int devicesCountInModel ;
    
    @SerializedName("type_id")
    private int typeId;
    
    
    @SerializedName("type")
    private String type;

    public Model(String modelName, String brandName, String type) {
        this.modelName = modelName;
        this.brandName = brandName;
        this.type = type;
    }

    public Model(int modelId, int brandId, String modelName, String brandName, int typeId) {
        this.modelId = modelId;
        this.brandId = brandId;
        this.modelName = modelName;
        this.brandName = brandName;
        this.typeId = typeId;
    }
    
    

    public Model(String modelName) {
        this(modelName,"","");
    }

    public Model(String modelName, String brandName, int devicesCountInModel) {
        this.modelName = modelName;
        this.brandName = brandName;
        this.devicesCountInModel = devicesCountInModel;
    }
    

    
    
    public Model(int brandId, String modelName, int typeId) {
        this.brandId = brandId;
        this.modelName = modelName;
        this.typeId = typeId;
    }

    public Model(int modelId, int brandId, String modelName, int typeId) {
        this.modelId = modelId;
        this.brandId = brandId;
        this.modelName = modelName;
        this.typeId = typeId;
    }
    
    

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getDevicesCountInModel() {
        return devicesCountInModel;
    }

    public void setDevicesCountInModel(int devicesCountInModel) {
        this.devicesCountInModel = devicesCountInModel;
    }

    @Override
    public String toString() {
        return "Model{" + "modelId=" + modelId + ", brandId=" + brandId + ", modelName=" + modelName + ", brandName=" + brandName + ", devicesCountInModel=" + devicesCountInModel + ", typeId=" + typeId + ", type=" + type + '}';
    }

   

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String  getModelNameWithBrand(){
        return getBrandName() + " - " +getModelName();
    }
    
     
    
    
}
