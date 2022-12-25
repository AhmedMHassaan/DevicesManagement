/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uis_items;

import data.pojo.Department;
import data.pojo.responses.DeviceTransactionResponse;
import java.util.ArrayList;
import listeners.OnItemClickListener;

/**
 *
 * @author pc
 */
public class TransactionsFilterUI extends javax.swing.JDialog {

//    private String msg ;
    private OnItemClickListener<DeviceTransactionResponse> listener;
    private DeviceTransactionResponse filter;
    private ArrayList<Department> allDepartments;

    /**
     * Creates new form TransactionsFilterUI
     *
     * @param parent
     * @param modal
     * @param _filter
     * @param allDeps
     */
    public TransactionsFilterUI(java.awt.Frame parent, boolean modal, DeviceTransactionResponse _filter, ArrayList<Department> allDeps) {
        super(parent, modal);
        this.filter = _filter;
        this.allDepartments = allDeps;
        initComponents();
        getFiltersPreRequests();
        putFilterDataInUiFields();
    }

    public void setOnResultReadyCallback(OnItemClickListener<DeviceTransactionResponse> _listener) {
        this.listener = _listener;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboNewDep = new javax.swing.JComboBox<>();
        comboOldDep = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSenderName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comoTransTime = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtTransReason = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtReceiverName = new javax.swing.JTextField();
        btnFilter = new com.k33ptoo.components.KButton();
        lblResetFilter = new javax.swing.JLabel();
        lblClearOldDep = new javax.swing.JLabel();
        lblClearNewDepSelction = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        comboOldDep.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        comboOldDep.setAutoscrolls(true);
        comboOldDep.setPreferredSize(new java.awt.Dimension(10, 20));

        jLabel1.setText("الفرع المرسل");

        jLabel2.setText("الفرع المستلم");

        jLabel3.setText("أمين العهدة");

        txtSenderName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtSenderName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel4.setText("وقت النقل");

        comoTransTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "كل الأوقات", "اليوم", "الأمس", "آخر سبع أيام", "آخر 30 يوم", "السنة الحالية" }));

        jLabel5.setText("سبب النقل");

        txtTransReason.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtTransReason.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel6.setText("اسم المستلم");

        txtReceiverName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtReceiverName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnFilter.setText("فلتر");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        lblResetFilter.setText("إرجاع القيم الإفتراضة");
        lblResetFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblResetFilter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblResetFilterMouseClicked(evt);
            }
        });

        lblClearOldDep.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClearOldDep.setForeground(new java.awt.Color(51, 153, 255));
        lblClearOldDep.setText("مسح التحديد");
        lblClearOldDep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClearOldDep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClearOldDepMouseClicked(evt);
            }
        });

        lblClearNewDepSelction.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClearNewDepSelction.setForeground(new java.awt.Color(51, 153, 255));
        lblClearNewDepSelction.setText("مسح التحديد");
        lblClearNewDepSelction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClearNewDepSelction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClearNewDepSelctionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblClearOldDep)
                    .addComponent(lblClearNewDepSelction))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboOldDep, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboNewDep, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtReceiverName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSenderName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comoTransTime, javax.swing.GroupLayout.Alignment.TRAILING, 0, 194, Short.MAX_VALUE)
                    .addComponent(txtTransReason, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(lblResetFilter)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboOldDep, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(lblClearOldDep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboNewDep)
                    .addComponent(jLabel2)
                    .addComponent(lblClearNewDepSelction))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReceiverName)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenderName, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comoTransTime)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTransReason, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel5))
                .addGap(113, 113, 113)
                .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lblResetFilter)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed

        if (filter == null) {
            filter = new DeviceTransactionResponse();
        }
        String oldDep = comboOldDep.getSelectedItem() + "";
        String newDep = comboNewDep.getSelectedItem() + "";
        String receiverName = txtReceiverName.getText();
        String senderName = txtSenderName.getText();
        String reason = txtTransReason.getText();
        String time = comoTransTime.getSelectedItem() + "";

        filter.setNewDepartment(new Department(newDep));
        filter.setOldDepartment(new Department(oldDep));
        filter.setReceiverName(receiverName);
        filter.setSenderName(senderName);
        filter.setTransactionReason(reason);
        filter.setTransitionTimestamp(time);

        if (listener != null) {
            listener.onItemClick(filter);
        }

        dispose();

    }//GEN-LAST:event_btnFilterActionPerformed

    private void lblResetFilterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetFilterMouseClicked
        resetDefaultFilter();
    }//GEN-LAST:event_lblResetFilterMouseClicked

    private void lblClearOldDepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClearOldDepMouseClicked
        comboOldDep.setSelectedIndex(-1);
    }//GEN-LAST:event_lblClearOldDepMouseClicked

    private void lblClearNewDepSelctionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClearNewDepSelctionMouseClicked
        comboNewDep.setSelectedIndex(-1);
    }//GEN-LAST:event_lblClearNewDepSelctionMouseClicked

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
            java.util.logging.Logger.getLogger(TransactionsFilterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionsFilterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionsFilterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionsFilterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            TransactionsFilterUI dialog = new TransactionsFilterUI(new javax.swing.JFrame(), true, null, null);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);

                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnFilter;
    private javax.swing.JComboBox<String> comboNewDep;
    private javax.swing.JComboBox<String> comboOldDep;
    private javax.swing.JComboBox<String> comoTransTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblClearNewDepSelction;
    private javax.swing.JLabel lblClearOldDep;
    private javax.swing.JLabel lblResetFilter;
    private javax.swing.JTextField txtReceiverName;
    private javax.swing.JTextField txtSenderName;
    private javax.swing.JTextField txtTransReason;
    // End of variables declaration//GEN-END:variables

    private void getFiltersPreRequests() {
        if (allDepartments != null) {
            fillDepartmentsCombo();
        }
    }

    private void putFilterDataInUiFields() {
        if (filter == null) {
            return;
        }
        txtReceiverName.setText(filter.getReceiverName());
        txtSenderName.setText(filter.getSenderName());
        txtTransReason.setText(filter.getTransactionReason());

        comboNewDep.setSelectedItem(filter.getNewDepartment().getDepartmentName());
        comboOldDep.setSelectedItem(filter.getOldDepartment().getDepartmentName());
        comoTransTime.setSelectedItem(filter.getTransitionTimestamp());

    }

    private void fillDepartmentsCombo() {
//        DefaultComboBoxModel<String> oldDepsmodel = new DefaultComboBoxModel<>();
//        DefaultComboBoxModel<String> newDepsModelmodel = new DefaultComboBoxModel<>();
        comboNewDep.removeAllItems();
        comboOldDep.removeAllItems();

        allDepartments.forEach(dep -> {
            comboNewDep.addItem(dep.getDepartmentName());
            comboOldDep.addItem(dep.getDepartmentName());
            
        });
        comboNewDep.setSelectedIndex(-1);
        comboOldDep.setSelectedIndex(-1);

    }

    private void resetDefaultFilter() {
        filter = null;
        comboNewDep.setSelectedIndex(-1);
        comboOldDep.setSelectedIndex(-1);
        comoTransTime.setSelectedIndex(0);
        
        txtReceiverName.setText("");
        txtSenderName.setText("");
        txtTransReason.setText("");
    }
}
