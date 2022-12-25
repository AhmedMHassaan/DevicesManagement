/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.import_devices;

import base.AdvancedFrame;
import data.pojo.DeviceUpload;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import repository.DevicesRepository;
import uis_items.CustomProgressDialog;
import utils.MessageBox;

/**
 *
 * @author pc
 */
public class ImportDevicesUI extends AdvancedFrame {

//   private final ArrayList<Device> allDevices = new ArrayList<>();
    private ImportDevicesController devicesController;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

//    private static ImportDevicesUI instance = null;
//    private final ArrayList<DeviceUpload> importedDevices = new ArrayList<>();
//    public static MutableLiveData<Boolean> addingLiveData = new MutableLiveData<>();
    /**
     * Creates new form DepartmentsUI
     *
     * @param devices
     */
    public ImportDevicesUI(ArrayList<DeviceUpload> devices) {
//        this.importedDevices.clear();
//        this.importedDevices.addAll(devices);
        this.devicesController = new ImportDevicesController(DevicesRepository.getInstance(), devices);
        initComponents();
    }

//    public static ImportDevicesUI getInstance() {
//
//        return getInstance(null);
//    }
    /* public static ImportDevicesUI getInstance(ArrayList<Device> devices) {
    
    synchronized (ImportDevicesUI.class) {
    if (instance == null) {
    synchronized (ImportDevicesUI.class) {
    //                    instance = new ImportDevicesUI();
    instance = new ImportDevicesUI(devices);
    }
    }
    
    }
    instance.importedDevices = devices;
    return instance;
    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablePopupMenu = new javax.swing.JPopupMenu();
        rdosGroupUploadingTypes = new javax.swing.ButtonGroup();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDevices = new base.AdvancedTable();
        lblTableTitle = new javax.swing.JLabel();
        btnCheckDevices = new javax.swing.JButton();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        rdoCancelDuplocated = new javax.swing.JRadioButton();
        rdoSkipDuplicated = new javax.swing.JRadioButton();
        rdoUpdateDuplicated = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        comboUploadingStates = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblDevicesCount = new javax.swing.JLabel();
        btnUploadDevices = new com.k33ptoo.components.KButton();
        progress = new javax.swing.JProgressBar();

        tablePopupMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tablePopupMenu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("رفع بيانات الأجهوة");
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 102, 255));
        jLabel10.setText("اختصارات");
        jLabel10.setToolTipText("");

        tableDevices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "رقم الأكسل", "الاسم", "S.N", "الموديل", "الشركة", "النوع", "الفرع", "حالة الرفع"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDevices.setFillsViewportHeight(true);
        tableDevices.setFont(tableDevices.getFont().deriveFont(tableDevices.getFont().getStyle() | java.awt.Font.BOLD, tableDevices.getFont().getSize()+1));
        tableDevices.setInheritsPopupMenu(true);
        tableDevices.setIntercellSpacing(new java.awt.Dimension(2, 3));
        tableDevices.setRowHeight(20);
        tableDevices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDevicesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDevices);
        if (tableDevices.getColumnModel().getColumnCount() > 0) {
            tableDevices.getColumnModel().getColumn(0).setMinWidth(5);
            tableDevices.getColumnModel().getColumn(0).setPreferredWidth(5);
            tableDevices.getColumnModel().getColumn(2).setMinWidth(10);
            tableDevices.getColumnModel().getColumn(2).setPreferredWidth(10);
            tableDevices.getColumnModel().getColumn(3).setMinWidth(10);
            tableDevices.getColumnModel().getColumn(3).setPreferredWidth(10);
            tableDevices.getColumnModel().getColumn(4).setMinWidth(15);
            tableDevices.getColumnModel().getColumn(4).setPreferredWidth(15);
            tableDevices.getColumnModel().getColumn(5).setMinWidth(20);
            tableDevices.getColumnModel().getColumn(5).setPreferredWidth(20);
        }

        lblTableTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTableTitle.setForeground(new java.awt.Color(51, 102, 255));
        lblTableTitle.setText("استيراد الأجهزة من ملف");
        lblTableTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTableTitleMouseClicked(evt);
            }
        });

        btnCheckDevices.setBackground(new java.awt.Color(51, 153, 0));
        btnCheckDevices.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckDevices.setText("التأكد من رفع الملفات");
        btnCheckDevices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckDevicesActionPerformed(evt);
            }
        });

        kGradientPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "كيفية رفع البيانات", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        kGradientPanel1.setkBorderRadius(30);
        kGradientPanel1.setkEndColor(new java.awt.Color(153, 153, 255));
        kGradientPanel1.setkGradientFocus(200);
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 204, 204));

        rdosGroupUploadingTypes.add(rdoCancelDuplocated);
        rdoCancelDuplocated.setText("إلغاء العملية و التحذير");

        rdosGroupUploadingTypes.add(rdoSkipDuplicated);
        rdoSkipDuplicated.setSelected(true);
        rdoSkipDuplicated.setText("تخطي المكرر");

        rdosGroupUploadingTypes.add(rdoUpdateDuplicated);
        rdoUpdateDuplicated.setText("تعديل البيانات ");

        jLabel3.setText("في حالة التكرار");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdoCancelDuplocated)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoUpdateDuplicated)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoSkipDuplicated)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoSkipDuplicated)
                    .addComponent(rdoUpdateDuplicated)
                    .addComponent(rdoCancelDuplocated)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        comboUploadingStates.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        comboUploadingStates.setMaximumRowCount(10);
        comboUploadingStates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboUploadingStatesActionPerformed(evt);
            }
        });

        jLabel1.setText("فلترة حالات الرفع");

        jLabel2.setText("عدد الأجهزة");

        lblDevicesCount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDevicesCount.setText("  --  جهاز ");

        btnUploadDevices.setText("رفع البيانات");
        btnUploadDevices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadDevicesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCheckDevices)
                                .addGap(34, 34, 34)
                                .addComponent(lblDevicesCount)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(468, 468, 468))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(comboUploadingStates, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(84, 84, 84)))
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUploadDevices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(466, 466, 466)
                            .addComponent(lblTableTitle)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(lblDevicesCount))
                            .addComponent(btnCheckDevices)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTableTitle)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboUploadingStates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(btnUploadDevices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnUploadDevices.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void lblTableTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTableTitleMouseClicked

    }//GEN-LAST:event_lblTableTitleMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
//        devicesController.destroy();
//        devicesController = null;
//        devicesController = null;
    }//GEN-LAST:event_formWindowClosed

    private void tableDevicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDevicesMouseClicked
        try {
//            if (evt.getButton() == MouseEvent.BUTTON1 || evt.getButton() == MouseEvent.BUTTON3) {
            if (evt.getButton() == MouseEvent.BUTTON1) {
//                Device selectedDevice = devicesController.getSelectedDevice(tableDevices);
//                devicesController.showDeviceInfo(selectedDevice, lblCurrentDep, lblDeviceName, lblSerialNumber, lblAddingTime);
//                changeDeleteLblVisiblity(true);
//                changeButtonShowTransactions(true);
//                changeButtonUpdateDeviceInfo(true);
            }

            if (evt.getButton() == MouseEvent.BUTTON3) {

//                preparePopupMenu();
//
//                int r = tableDevices.rowAtPoint(evt.getPoint());
//                if (r >= 0 && r < tableDevices.getRowCount()) {
//                    tableDevices.setRowSelectionInterval(r, r);
//
//                } else {
//                    tableDevices.clearSelection();
//                }
//
//                int rowindex = tableDevices.getSelectedRow();
//                if (rowindex < 0) {
//                    return;
//                }
//
////                if (evt.isPopupTrigger() && evt.getComponent() instanceof JTable) {
//                if (evt.getComponent() instanceof JTable) {
//                    showPopupMenu(evt);
////                    tablePopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
//                }
//                showPopupMenu(evt);
            }

        } catch (Exception ex) {
            Logger.getLogger(ImportDevicesUI.class.getName()).log(Level.SEVERE, null, ex);
            MessageBox.showErrorMessage(ex.getMessage());
        }
    }//GEN-LAST:event_tableDevicesMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        refreshPage();
//        selecetIntentDepartmentNameFromDepCombo();

        putDevicesInTable();
        updateDeviceCounterNumber();

        getUploadingStatesThenPutIntoCombo(comboUploadingStates);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus


    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged

    }//GEN-LAST:event_formWindowStateChanged

    private void btnCheckDevicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckDevicesActionPerformed

        scheduler.execute(() -> {
            try {
                CustomProgressDialog.showProgressDialog(this, "جار فحص وتجهيز الأجهزة المرفوعة");
                btnUploadDevices.setVisible(false);
                int checkingType = -1;
                if (rdoSkipDuplicated.isSelected()) {
                    checkingType = 1;
                } else if (rdoUpdateDuplicated.isSelected()) {
                    checkingType = 2;
                } else {
                    checkingType = 3;
                }
                devicesController.checkUploadingStates(progress, tableDevices, comboUploadingStates, btnCheckDevices, btnUploadDevices, checkingType);
                
            } catch (Exception ex) {
                Logger.getLogger(ImportDevicesUI.class.getName()).log(Level.SEVERE, null, ex);
                MessageBox.showErrorMessage(ex.getMessage());
            }
        });

//             getUploadingStatesThenPutIntoCombo(comboUploadingStates);

    }//GEN-LAST:event_btnCheckDevicesActionPerformed

    private void comboUploadingStatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUploadingStatesActionPerformed
        String selectedState = comboUploadingStates.getSelectedItem() + "";
        if ("الكل".equals(selectedState)) {
            devicesController.fillDevicesTable(tableDevices);
        } else {
            devicesController.filterDevicesWithState(tableDevices, selectedState);
        }

        updateDeviceCounterNumber();
    }//GEN-LAST:event_comboUploadingStatesActionPerformed

    private void btnUploadDevicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadDevicesActionPerformed

        scheduler.execute(() -> {
            try {
                CustomProgressDialog.showProgressDialog(this, "جار فحص وتجهيز الأجهزة المرفوعة");
                btnUploadDevices.setEnabled(false);

                int checkingType = getUploadTypeFromRdoButtons();
                devicesController.uploadDevices(progress, tableDevices, comboUploadingStates, checkingType);
                

                btnUploadDevices.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(ImportDevicesUI.class.getName()).log(Level.SEVERE, null, ex);
                MessageBox.showErrorMessage(ex.getMessage());
            }
        });


    }//GEN-LAST:event_btnUploadDevicesActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ImportDevicesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImportDevicesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImportDevicesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImportDevicesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImportDevicesUI(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckDevices;
    private com.k33ptoo.components.KButton btnUploadDevices;
    private javax.swing.JComboBox<String> comboUploadingStates;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblDevicesCount;
    private javax.swing.JLabel lblTableTitle;
    private javax.swing.JProgressBar progress;
    private javax.swing.JRadioButton rdoCancelDuplocated;
    private javax.swing.JRadioButton rdoSkipDuplicated;
    private javax.swing.JRadioButton rdoUpdateDuplicated;
    private javax.swing.ButtonGroup rdosGroupUploadingTypes;
    private base.AdvancedTable tableDevices;
    private javax.swing.JPopupMenu tablePopupMenu;
    // End of variables declaration//GEN-END:variables

    private void fillDevicesTable() {
        devicesController.fillDevicesTable(tableDevices);
    }

    @Override
    public void destroyInstance() {
//        addingLiveData = null;
//        instance = null;

        CustomProgressDialog.hideProgressDialog();
        scheduler.shutdown();
        devicesController.destroy();
        devicesController = null;

    }

    private void putDevicesInTable() {
        fillDevicesTable();
    }

    private int calculateDevicesCount() {
//        return devicesController.getImportedDevicesCount();
        return tableDevices.getRowCount();
    }

    private void putRowsCountInLabel(JLabel lblDevicesCount, int devicesCount) {
        devicesController.putRowsCountInLabel(lblDevicesCount, devicesCount);
    }

    private void getUploadingStatesThenPutIntoCombo(JComboBox<String> comboUploadingStates) {
        devicesController.getUploadingStatesThenPutIntoCombo(comboUploadingStates);
    }

    private void updateDeviceCounterNumber() {
        int devicesCount = calculateDevicesCount();
        putRowsCountInLabel(lblDevicesCount, devicesCount);
    }

    private int getUploadTypeFromRdoButtons() {

        return devicesController.getUploadingTypeFromRdoButtons(rdoCancelDuplocated, rdoSkipDuplicated, rdoUpdateDuplicated);
    }

}
