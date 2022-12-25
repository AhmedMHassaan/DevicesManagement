/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.test_connection;

import base.BaseController;
import data.pojo.Config;
import data.pojo.DeviceType;
import data.pojo.responses.ServerResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import repository.ConnectionRepository;
import repository.TypesRepository;
import utils.ConfigurationsUtils;
import utils.ImagesUtils;
import utils.LiveData;
import utils.MessageBox;
import utils.MutableLiveData;

/**
 *
 * @author pc
 */
public class TestConnectionController extends BaseController {

    private ConnectionRepository connectionRepository;
    private TypesRepository typesRepository;

    public TestConnectionController(ConnectionRepository _connectionRepository, TypesRepository _typesRepo) {
        this.connectionRepository = _connectionRepository;
        this.typesRepository = _typesRepo;
    }

    public LiveData<Boolean> testConnection() {
        MutableLiveData<Boolean> response = new MutableLiveData();

//        progress.setVisible(true);
//        main.setVisible(false);
        connectionRepository
                .testConnection()
                .observe(
                        (LiveData.IData<ServerResponse<Boolean>>) (ServerResponse<Boolean> data) -> {

//                            main.setVisible(true);
//                            progress.setVisible(false);
//                            System.out.println("data observed is "+data);
                            if (data.getCode() == 1 && data.getResponse() != null) {
//                                response.postData(false);
//                                MessageBox.showErrorMessage(data.getMessage());

                                response.postData(data.getResponse());
                            } else {
                                response.postData(false);
                                MessageBox.showErrorMessage(data.getMessage());
                            }

                        });

        return response;
    }

    @Override
    public void destroy() {
        connectionRepository = null;
        typesRepository = null;
    }

    ArrayList<DeviceType> getAllTypes() {
//        return typesRepository.getAllTypes();
        return typesRepository.getAllTypes();
    }

    ArrayList<DeviceType> getAllLocalTypes() {
//        return typesRepository.getAllTypes();
        return typesRepository.getAllLocalTypes();
    }

//    Config getConfiObject() throws Exception{
////        return ConfigurationsUtils.loadConfigurations();
//    }
    void setSplashScreenData(JLabel lblScreenLogo, JLabel lblUntiTitle, JLabel lblDepTitle, JLabel lblAppTitle) {

        
        setSplashScreenLogo(lblScreenLogo);
        setAppTitle(lblAppTitle);
        setUntiTitle(lblUntiTitle);
        setDepTitle(lblDepTitle);
    }

    private void setSplashScreenLogo(JLabel lblScreenLogo) {
        try {
            String splashScreenLogoPath = ConfigurationsUtils.getSplashScreenLogoPath();
            ImagesUtils.loadSplashScreenImage(lblScreenLogo, splashScreenLogoPath);

        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            MessageBox.showMessage(e.getMessage());
        }
    }

    private void setAppTitle(JLabel lblAppTitle) {
        try {
            lblAppTitle.setText(ConfigurationsUtils.getAppName());
        } catch (Exception ex) {
            Logger.getLogger(TestConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            lblAppTitle.setText("تطبيق مراقبة العهدة");
        }
    }

    private void setUntiTitle(JLabel lblUntiTitle) {
         try {
            lblUntiTitle.setText(ConfigurationsUtils.getUnitName());
        } catch (Exception ex) {
            Logger.getLogger(TestConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            lblUntiTitle.setText("كلية الضباط الإحتياط");
        }
    }

    private void setDepTitle(JLabel lblDepTitle) {
           try {
            lblDepTitle.setText(ConfigurationsUtils.getDepartmentName());
        } catch (Exception ex) {
            Logger.getLogger(TestConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            lblDepTitle.setText("فرع نظم المعلومات");
        }
    }
}
