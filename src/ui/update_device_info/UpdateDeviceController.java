/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.update_device_info;

import data.pojo.Department;
import data.pojo.Device;
import data.pojo.Model;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import repository.DepartmentsRepository;
import repository.DevicesRepository;
import repository.ModelsRepository;
import repository.TypesRepository;
import ui.devices.DevicesController;
import utils.Tools;

/**
 *
 * @author pc
 */
public class UpdateDeviceController extends DevicesController{

//    private DevicesRepository devicesRepository;
//    private DepartmentsRepository departmentsRepository;
    private ModelsRepository modelsRepository;

    private final ArrayList<Model> allModels;

   
    public UpdateDeviceController(DevicesRepository devicesRepository, ModelsRepository modelsRepository, DepartmentsRepository departmentsRepository, TypesRepository _typesRepo) {
        super(devicesRepository, departmentsRepository, _typesRepo,modelsRepository);
        
//        this.departmentsRepository = departmentsRepository;
        this.modelsRepository = modelsRepository;
//        this.devicesRepository = devicesRepository;
        this.allModels = new ArrayList<>();
    }

    
    void getAllModels (){
//        ArrayList<Model> models = modelsRepository.getAllModels(false);
        ArrayList<Model> models = modelsRepository.getAllLocalModels("", "");
        if (models != null) {
            this.allModels.clear();
            this.allModels.addAll(models);
        }
        
    }
    void getAllModels (boolean forceToShowMessage){
        ArrayList<Model> models = modelsRepository.getAllModels(forceToShowMessage, "", "");
        if (models != null) {
            this.allModels.clear();
            this.allModels.addAll(models);
        }
        
    }
    @Override
    public void destroy() {
//        devicesRepository = null;
//        departmentsRepository = null;
        modelsRepository = null;
        allModels.clear();
        
        System.gc();
    }

    void putModelsIn(JComboBox<String> comboModels) {
        getAllModels();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        allModels.forEach((data)->{
            
            model.addElement(data.getModelNameWithBrand());
        });
        comboModels.setModel(model);
        comboModels.setSelectedIndex(-1);
    }

    boolean updateDeviceInfo(JTextField txtDeviceId,JTextField txtSerialNo, JTextField txtName, Department dep, JComboBox<String> comboModels) throws Exception {
        String idAsStr = txtDeviceId.getText().trim();
        String serialNumber = txtSerialNo.getText().trim();
        String name =  txtName.getText().trim();
        
        if (idAsStr.isEmpty()) {
            throw new Exception("يرجي اختيار جهاز أولا");
        }
        int deviceId = Tools.getIntegerFromTextBox(txtDeviceId);
        if (serialNumber.isEmpty()) {
            throw new Exception("يرجي كتابة السيريال");
        }
        
        if (name.isEmpty()) {
            throw new Exception("يرجي كتابة اسم الجهاز");
        }
        
//        Department depart = getSelectedDepartment(comboDeps);
        Model model = getSelectedModel(comboModels);
        
        
         Device device = new Device( deviceId, serialNumber, name, dep, model);
         
         return updateDevice(device);
        
    }

    
     public Model getSelectedModel(JComboBox<String> comboModels) throws Exception {
        int index = comboModels.getSelectedIndex();
        if (index == -1) {
            throw new Exception("يرجي اختيار الموديل");
        }

        if (index >= allModels.size()) {
            throw new Exception("يرجي اختيار موديل صحيح");
        }
        return allModels.get(index);
    }

 
  

}
