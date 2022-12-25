/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.add_new_device;

import base.AdvancedFrame;
import repository.DepartmentsRepository;
import repository.DevicesRepository;
import repository.ModelsRepository;
import repository.TypesRepository;
import ui.departments.DepartmentsUI;
import ui.devices.DevicesUI;
import ui.models_ui.ModelsUI;
import utils.MessageBox;

/**
 *
 * @author pc
 */
 public class AddNewDevice extends AdvancedFrame {

    private  static AddNewDevice instance = null;
    
    private final AddNewDeviceController addDeviceController = new AddNewDeviceController(
            DevicesRepository.getInstance(),
            ModelsRepository.getInstance(),
            DepartmentsRepository.getInstance(),
            TypesRepository.getInstance()
    );

    /**
     * Creates new form AddNewDevice
     *
     * @return
     */
    public static AddNewDevice getInstance() {

        synchronized (AddNewDevice.class) {
            if (instance == null) {
                synchronized(AddNewDevice.class){
                    instance = new AddNewDevice();
                }
            }
            
        }

        return instance;
    }

    private AddNewDevice() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSerialNo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboDeps = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        comboModels = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnAddDevice = new com.k33ptoo.components.KButton();
        lblAddNewDep = new javax.swing.JLabel();
        lblAddNewDep1 = new javax.swing.JLabel();
        lblRefreshPage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("إضافة جهاز جديد");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        kGradientPanel1.setkEndColor(java.awt.SystemColor.activeCaption);
        kGradientPanel1.setkGradientFocus(100);
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("السيريال");

        txtSerialNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSerialNo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("الفرع");

        comboDeps.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        comboDeps.setNextFocusableComponent(comboModels);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 255));
        jLabel3.setText("الموديل");

        comboModels.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 102, 255));
        jLabel4.setText("الاسم");

        txtName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnAddDevice.setText("إضافة الجهاز");
        btnAddDevice.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnAddDevice.setkAllowGradient(false);
        btnAddDevice.setkBackGroundColor(new java.awt.Color(51, 102, 255));
        btnAddDevice.setkBorderRadius(40);
        btnAddDevice.setkEndColor(new java.awt.Color(0, 102, 153));
        btnAddDevice.setkHoverColor(new java.awt.Color(0, 102, 153));
        btnAddDevice.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnAddDevice.setkHoverStartColor(new java.awt.Color(0, 102, 153));
        btnAddDevice.setkPressedColor(new java.awt.Color(0, 102, 204));
        btnAddDevice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDeviceActionPerformed(evt);
            }
        });

        lblAddNewDep.setFont(lblAddNewDep.getFont().deriveFont(lblAddNewDep.getFont().getStyle() | java.awt.Font.BOLD));
        lblAddNewDep.setForeground(new java.awt.Color(51, 102, 255));
        lblAddNewDep.setText("إضافة فرع جديد");
        lblAddNewDep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAddNewDep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddNewDepMouseClicked(evt);
            }
        });

        lblAddNewDep1.setFont(lblAddNewDep1.getFont().deriveFont(lblAddNewDep1.getFont().getStyle() | java.awt.Font.BOLD));
        lblAddNewDep1.setForeground(new java.awt.Color(51, 102, 255));
        lblAddNewDep1.setText("إضافة موديل جديد");
        lblAddNewDep1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAddNewDep1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddNewDep1MouseClicked(evt);
            }
        });

        lblRefreshPage.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblRefreshPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRefreshPage.setText("تحديث الصفحة");
        lblRefreshPage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRefreshPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRefreshPageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddNewDep, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAddNewDep1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSerialNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboDeps, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboModels, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(14, 14, 14))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblRefreshPage))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(btnAddDevice, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRefreshPage)
                .addGap(17, 17, 17)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSerialNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboDeps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAddNewDep)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboModels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAddNewDep1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnAddDevice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddDeviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDeviceActionPerformed
        try {
            
            boolean isAdded = addDeviceController.addNewDevice(
                    txtSerialNo,
                    txtName,
                    comboDeps,
                    comboModels
            );
            
            if (isAdded) {
                DevicesUI.addingLiveData.postData(isAdded);
                dispose();
            }
        } catch (Exception ex) {
            MessageBox.showErrorMessage(ex.getMessage());
        }
    }//GEN-LAST:event_btnAddDeviceActionPerformed

    private void lblAddNewDepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddNewDepMouseClicked
        startNewFrameWithOldFrame(DepartmentsUI.getInstance());
    }//GEN-LAST:event_lblAddNewDepMouseClicked

    private void lblAddNewDep1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddNewDep1MouseClicked
        startNewFrameWithOldFrame(ModelsUI.getInstance());
    }//GEN-LAST:event_lblAddNewDep1MouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        addDeviceController.destroy();
        destroyInstance();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        getFormData();
    }//GEN-LAST:event_formWindowOpened

    private void lblRefreshPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefreshPageMouseClicked
        refreshPage();
    }//GEN-LAST:event_lblRefreshPageMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewDevice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AddNewDevice().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnAddDevice;
    private javax.swing.JComboBox<String> comboDeps;
    private javax.swing.JComboBox<String> comboModels;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblAddNewDep;
    private javax.swing.JLabel lblAddNewDep1;
    private javax.swing.JLabel lblRefreshPage;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSerialNo;
    // End of variables declaration//GEN-END:variables

    private void getFormData() {
        addDeviceController.getAllDepartments();
        addDeviceController.fillDepartmentsIn(comboDeps);

        addDeviceController.putModelsIn(comboModels);
    }

    private void refreshPage() {
        getFormData();
    }

    @Override
    public void destroyInstance() {
        addDeviceController.destroy();
        instance = null;
    }
}
