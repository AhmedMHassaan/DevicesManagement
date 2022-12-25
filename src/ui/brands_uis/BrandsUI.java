/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.brands_uis;

import base.AdvancedFrame;
import data.pojo.Brand;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import repository.BrandsRepository;
import utils.MessageBox;

/**
 *
 * @author pc
 */
public class BrandsUI extends AdvancedFrame {

    private final ArrayList<Brand> allBrands = new ArrayList<>();
    private static BrandsUI instance = null;

    /**
     * Creates new form DepartmentsUI
     */
    private BrandsUI() {
        initComponents();
    }

    public static BrandsUI getInstance() {

        synchronized (BrandsUI.class) {
            if (instance == null) {
                synchronized (BrandsUI.class) {
                    instance = new BrandsUI();
                }
            }

        }

        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel3 = new com.k33ptoo.components.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBrands = new base.AdvancedTable();
        lblTableTitle = new javax.swing.JLabel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        txtAddBrand = new javax.swing.JTextField();
        btnAddBrand = new com.k33ptoo.components.KButton();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel3 = new javax.swing.JLabel();
        lblBrandsId = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSaveChanges = new com.k33ptoo.components.KButton();
        txtBrandNameForUpdate = new javax.swing.JTextField();
        lblDeleteBrand = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblDevicesCount = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("صفحة شركات الأجهزة");
        setBackground(new java.awt.Color(204, 204, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        kGradientPanel3.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel3.setkStartColor(new java.awt.Color(153, 153, 153));

        tableBrands.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "اسم الشركة", "عدد أجهزة الشركة"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableBrands.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tableBrands.getTableHeader().setReorderingAllowed(false);
        tableBrands.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBrandsMouseClicked(evt);
            }
        });
        tableBrands.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableBrandsKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableBrands);
        if (tableBrands.getColumnModel().getColumnCount() > 0) {
            tableBrands.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableBrands.getColumnModel().getColumn(1).setPreferredWidth(150);
            tableBrands.getColumnModel().getColumn(2).setPreferredWidth(60);
        }

        lblTableTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTableTitle.setForeground(new java.awt.Color(51, 102, 255));
        lblTableTitle.setText("انواع شركات الأجهزة");
        lblTableTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTableTitleMouseClicked(evt);
            }
        });

        kGradientPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "إضافة شركة", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 102, 255))); // NOI18N
        kGradientPanel1.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("اسم الشركة");

        txtAddBrand.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAddBrand.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtAddBrand.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAddBrandKeyPressed(evt);
            }
        });

        btnAddBrand.setText("إضافة الشركة");
        btnAddBrand.setFont(btnAddBrand.getFont().deriveFont(btnAddBrand.getFont().getStyle() | java.awt.Font.BOLD, btnAddBrand.getFont().getSize()+1));
        btnAddBrand.setkAllowGradient(false);
        btnAddBrand.setkBackGroundColor(new java.awt.Color(51, 102, 255));
        btnAddBrand.setkBorderRadius(40);
        btnAddBrand.setkEndColor(new java.awt.Color(0, 102, 153));
        btnAddBrand.setkHoverColor(new java.awt.Color(0, 102, 153));
        btnAddBrand.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnAddBrand.setkHoverStartColor(new java.awt.Color(0, 102, 153));
        btnAddBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBrandActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(txtAddBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap())
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAddBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(btnAddBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        kGradientPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "تعديل بيانات الشركة", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 102, 255))); // NOI18N
        kGradientPanel2.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel2.setkStartColor(new java.awt.Color(204, 204, 204));

        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("رقم الشركة");

        lblBrandsId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblBrandsId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("الاسم");

        btnSaveChanges.setText("حفظ التغييرات");
        btnSaveChanges.setFont(btnSaveChanges.getFont().deriveFont(btnSaveChanges.getFont().getStyle() | java.awt.Font.BOLD, btnSaveChanges.getFont().getSize()+1));
        btnSaveChanges.setkAllowGradient(false);
        btnSaveChanges.setkBackGroundColor(new java.awt.Color(51, 102, 255));
        btnSaveChanges.setkBorderRadius(40);
        btnSaveChanges.setkEndColor(new java.awt.Color(51, 51, 255));
        btnSaveChanges.setkHoverColor(new java.awt.Color(0, 102, 153));
        btnSaveChanges.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSaveChanges.setkStartColor(new java.awt.Color(0, 102, 102));
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesActionPerformed(evt);
            }
        });

        txtBrandNameForUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtBrandNameForUpdate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtBrandNameForUpdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBrandNameForUpdateKeyPressed(evt);
            }
        });

        lblDeleteBrand.setFont(lblDeleteBrand.getFont().deriveFont(lblDeleteBrand.getFont().getStyle() | java.awt.Font.BOLD));
        lblDeleteBrand.setForeground(new java.awt.Color(255, 51, 51));
        lblDeleteBrand.setText("حذف الشركة");
        lblDeleteBrand.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDeleteBrand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDeleteBrandMouseClicked(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("عدد الأجهزة");

        lblDevicesCount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDevicesCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBrandsId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBrandNameForUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDevicesCount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(19, 19, 19))
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(lblDeleteBrand)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel6});

        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblBrandsId, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblDevicesCount, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBrandNameForUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDeleteBrand))
                .addContainerGap())
        );

        btnSaveChanges.setVisible(false);
        lblDeleteBrand.setVisible(false);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTableTitle))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(lblTableTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        getFormData();
    }//GEN-LAST:event_formWindowOpened

    private void tableBrandsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBrandsMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            if (evt.getClickCount() == 1) {
                int selectedRowIndex = tableBrands.getSelectedRow();
                Brand brand = getDepartmentFromSelectedRow(selectedRowIndex);
                showItemDetails(brand);
                changeUpdateDepControllesVisibility();
            }
        }
    }//GEN-LAST:event_tableBrandsMouseClicked

    private void btnAddBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBrandActionPerformed
        String brand = txtAddBrand.getText().trim();
        if (brand.isEmpty()) {
            MessageBox.showErrorMessage("يرجي كتابة اسم الشركة");
            return;
        }

        boolean isAdded = addBrandToDB(brand);
        if (isAdded) {
            getFormData();
        }
    }//GEN-LAST:event_btnAddBrandActionPerformed

    private void lblDeleteBrandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeleteBrandMouseClicked

        int delOption = JOptionPane.showConfirmDialog(this, "سيتم حذف الشركة نهائيا\nهل تريد المتابعة", "حذف الشركة", JOptionPane.YES_NO_OPTION);
        if (delOption == JOptionPane.YES_OPTION) {
            int selectedIndex = tableBrands.getSelectedRow();
            if (selectedIndex == -1) {
                MessageBox.showErrorMessage("يرجي اختيار شركة أولا للحذف");
                return;
            }

            Brand brand = allBrands.get(selectedIndex);
            boolean isDeleted = deleteBrand(brand);
            if (isDeleted) {
                lblBrandsId.setText("");
                txtBrandNameForUpdate.setText("");
                tableBrands.setSelectionModel(new DefaultListSelectionModel());
                getFormData();
            }
        }

    }//GEN-LAST:event_lblDeleteBrandMouseClicked

    private void btnSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangesActionPerformed

        String brandName = txtBrandNameForUpdate.getText().trim();
        int selectedIndex = tableBrands.getSelectedRow();

        if (selectedIndex == -1) {
            MessageBox.showErrorMessage("يرجي اختيار شركة أولا لإكمال التعديل");
            return;
        }

        if (brandName.isEmpty()) {
            MessageBox.showErrorMessage("يرجي كتابة اسم الشركة");
            return;
        }

        Brand brand = allBrands.get(selectedIndex);
        brand.setBrandName(brandName);
        boolean isUpdated = updateBrand(brand);
        if (isUpdated) {
            getFormData();
        }
    }//GEN-LAST:event_btnSaveChangesActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void tableBrandsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableBrandsKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            getFormData();
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            lblDeleteBrandMouseClicked(null);
        }
        
    }//GEN-LAST:event_tableBrandsKeyPressed

    private void lblTableTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTableTitleMouseClicked
        getFormData();
    }//GEN-LAST:event_lblTableTitleMouseClicked

    private void txtAddBrandKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddBrandKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAddBrand.doClick();
        }
    }//GEN-LAST:event_txtAddBrandKeyPressed

    private void txtBrandNameForUpdateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBrandNameForUpdateKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSaveChanges.doClick();
        }
    }//GEN-LAST:event_txtBrandNameForUpdateKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        destroyInstance();
    }//GEN-LAST:event_formWindowClosed

    /**
     *
     */
    @Override
    public void destroyInstance() {
        allBrands.clear();
        instance = null;
    }
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
            java.util.logging.Logger.getLogger(BrandsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BrandsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BrandsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BrandsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BrandsUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnAddBrand;
    private com.k33ptoo.components.KButton btnSaveChanges;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel3;
    private javax.swing.JLabel lblBrandsId;
    private javax.swing.JLabel lblDeleteBrand;
    private javax.swing.JLabel lblDevicesCount;
    private javax.swing.JLabel lblTableTitle;
    private base.AdvancedTable tableBrands;
    private javax.swing.JTextField txtAddBrand;
    private javax.swing.JTextField txtBrandNameForUpdate;
    // End of variables declaration//GEN-END:variables

    private void getFormData() {
        ArrayList<Brand> brands = getAllBrands();
        if (brands != null) {
            allBrands.clear();
            allBrands.addAll(brands);

            fillBrandsTable(allBrands);
        }

//        emptyFormFields(this);
        txtAddBrand.setText("");
        lblBrandsId.setText("");
        txtBrandNameForUpdate.setText("");
        tableBrands.setSelectionModel(new DefaultListSelectionModel());

    }

    private ArrayList<Brand> getAllBrands() {
//        return BrandsRepository.getInstance().getAllBrands();
        return BrandsRepository.getInstance().getAllLocalBrands();
    }

    private void fillBrandsTable(ArrayList<Brand> brands) {
        tableBrands.clearTable();
        DefaultTableModel model = tableBrands.getMutableModel();

        brands.forEach((brand) -> {
//            System.out.println("Brand id => "+brand.getBrandId()+" : "+brand.getBrandNameWithTypeName()+" == "+brand.getBrandName() + " == "+brand.getDevicesCountInBrand());
            model.addRow(new Object[]{
                brand.getBrandId(),
                brand.getBrandNameWithTypeName(),
                brand.getDevicesCountInBrand()
            });
        });
        tableBrands.setModel(model);
    }

    private Brand getDepartmentFromSelectedRow(int selectedRowIndex) {
        return allBrands.get(selectedRowIndex);
    }

    private void showItemDetails(Brand brand) {
        lblBrandsId.setText(brand.getBrandId()+ "");
        txtBrandNameForUpdate.setText(brand.getBrandName());
        lblDevicesCount.setText(brand.getDevicesCountInBrand()+"");
    }

    private void changeUpdateDepControllesVisibility() {
        btnSaveChanges.setVisible(true);
        lblDeleteBrand.setVisible(true);
    }

    private boolean addBrandToDB(String brand) {
//        return BrandsRepository.getInstance().addNewBrand(brand);
        return BrandsRepository.getInstance().addNewLocalBrand(brand);
    }

    private boolean deleteBrand(Brand brand) {
//        return BrandsRepository.getInstance().deleteBrand(brand.getBrandId());
        return BrandsRepository.getInstance().deleteLocalBrand(brand.getBrandId());
    }

    private boolean updateBrand(Brand brand) {
//        return BrandsRepository.getInstance().updateBrand(brand.getBrandId(), brand.getBrandName());
        return BrandsRepository.getInstance().updateLocalBrand(brand.getBrandId(), brand.getBrandName());
    }

    private void emptyFormFields(Container container) {
        for (Component comp : container.getComponents()) {
            if (comp instanceof JTextField) {
                ((JTextField) comp).setText("");
            }
            else if (comp instanceof JLabel) {
                
                ((JLabel) comp).setText("");
            }
            else if (comp instanceof Container) {
                emptyFormFields((Container) comp);
            }
        }
    }
}
