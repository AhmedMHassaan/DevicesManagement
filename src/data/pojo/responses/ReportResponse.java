/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.pojo.responses;

import com.google.gson.annotations.SerializedName;
import data.pojo.Model;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class ReportResponse {
    @SerializedName("header")
    private ArrayList<Model> tableHeader ;
    
    
    
    @SerializedName("rows")
    private ArrayList<ReportRow> tableRows ;

    public ArrayList<Model> getTableHeader() {
        return tableHeader;
    }

    public void setTableHeader(ArrayList<Model> tableHeader) {
        this.tableHeader = tableHeader;
    }
    public void addHeader(Model model){
        if (tableHeader != null) {
            this.tableHeader.add(model);
        }
    }

    public ArrayList<ReportRow> getTableRows() {
        return tableRows;
    }

    public void setTableRows(ArrayList<ReportRow> tableRows) {
        this.tableRows = tableRows;
    }
    
    
    
    
    
}
