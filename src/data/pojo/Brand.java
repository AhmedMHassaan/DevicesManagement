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
public class Brand {

    @SerializedName("brand_id")
    private int brandId;
    @SerializedName("brand")
    private String brandName;

    @SerializedName("brand_with_type")
    private String brandNameWithTypeName;

    @SerializedName("devices_count_in_brand")
    private int devicesCountInBrand;

    @SerializedName("type")
    private String typeName ;
    
    public Brand(String brandName, String brandNameWithTypeName) {
        this.brandName = brandName;
        this.brandNameWithTypeName = brandNameWithTypeName;
    }

    public Brand() {
    }

    public Brand(int brandId, String brandName, String brandNameWithTypeName, int devicesCountInBrand) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandNameWithTypeName = brandNameWithTypeName;
        this.devicesCountInBrand = devicesCountInBrand;
    }

    
    public Brand(int brandId, String brandName) {
        this.brandId = brandId;
        this.brandName = brandName;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getDevicesCountInBrand() {
        return devicesCountInBrand;
    }

    public void setDevicesCountInBrand(int devicesCountInBrand) {
        this.devicesCountInBrand = devicesCountInBrand;
    }

    public String getBrandNameWithTypeName() {
        if ("0.0".equals(brandNameWithTypeName)) {
            return brandName + " - " + typeName;
        }
        return brandNameWithTypeName;
    }

    public void setBrandNameWithTypeName(String brandNameWithTypeName) {
        this.brandNameWithTypeName = brandNameWithTypeName;
    }

}
