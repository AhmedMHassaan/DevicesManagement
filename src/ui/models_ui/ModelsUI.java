/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.models_ui;

import base.AdvancedFrame;
import data.pojo.Brand;
import data.pojo.DeviceType;
import data.pojo.Model;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import repository.BrandsRepository;
import repository.ModelsRepository;
import repository.TypesRepository;
import ui.brands_uis.BrandsUI;
import ui.types_uis.TypesUI;
import utils.MessageBox;

/**
 *
 * @author pc
 */
public class ModelsUI extends AdvancedFrame {

    private final ArrayList<Model> allModels = new ArrayList<>();
    private final ArrayList<Brand> allBrandsCombo = new ArrayList<>();
    private final ArrayList<DeviceType> allTypesCombo = new ArrayList<>();

    /**
     * Creates new form DepartmentsUI
     */
    private static ModelsUI instance = null;

    /**
     * Creates new form DepartmentsUI
     */
    private ModelsUI() {
        initComponents();
    }

    public static ModelsUI getInstance() {

        synchronized (ModelsUI.class) {
            if (instance == null) {
                synchronized (ModelsUI.class) {
                    instance = new ModelsUI();
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
        tableModels = new base.AdvancedTable();
        lblTableTitle = new javax.swing.JLabel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        txtAddModel = new javax.swing.JTextField();
        btnAddModel = new com.k33ptoo.components.KButton();
        jLabel5 = new javax.swing.JLabel();
        comboBrandName = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        comboTypes = new javax.swing.JComboBox<>();
        lblAddBrand = new javax.swing.JLabel();
        lblAddType = new javax.swing.JLabel();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel3 = new javax.swing.JLabel();
        lblModelId = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSaveChanges = new com.k33ptoo.components.KButton();
        txtModelNameForUpdate = new javax.swing.JTextField();
        lblDeleteModel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblDevicesCount = new javax.swing.JLabel();
        comboBrandNameUpdate = new javax.swing.JComboBox<>();
        comboTypesUpdate = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnRefreshFormData = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("موديلات الأجهزة");
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

        tableModels.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "الموديل", " الشركة", "النوع", "عدد أجهزة الموديل"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableModels.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tableModels.getTableHeader().setReorderingAllowed(false);
        tableModels.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableModelsMouseClicked(evt);
            }
        });
        tableModels.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableModelsKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableModels);
        if (tableModels.getColumnModel().getColumnCount() > 0) {
            tableModels.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableModels.getColumnModel().getColumn(2).setPreferredWidth(80);
            tableModels.getColumnModel().getColumn(4).setPreferredWidth(60);
        }

        lblTableTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTableTitle.setForeground(new java.awt.Color(51, 102, 255));
        lblTableTitle.setText("انواع موديلات الأجهزة");
        lblTableTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTableTitleMouseClicked(evt);
            }
        });

        kGradientPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "إضافة موديل", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 102, 255))); // NOI18N
        kGradientPanel1.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("اسم الموديل");

        txtAddModel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAddModel.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtAddModel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAddModelKeyPressed(evt);
            }
        });

        btnAddModel.setText("إضافة الموديل");
        btnAddModel.setFont(btnAddModel.getFont().deriveFont(btnAddModel.getFont().getStyle() | java.awt.Font.BOLD, btnAddModel.getFont().getSize()+1));
        btnAddModel.setkAllowGradient(false);
        btnAddModel.setkBackGroundColor(new java.awt.Color(51, 102, 255));
        btnAddModel.setkBorderRadius(40);
        btnAddModel.setkEndColor(new java.awt.Color(0, 102, 153));
        btnAddModel.setkHoverColor(new java.awt.Color(0, 102, 153));
        btnAddModel.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnAddModel.setkHoverStartColor(new java.awt.Color(0, 102, 153));
        btnAddModel.setkPressedColor(new java.awt.Color(0, 102, 204));
        btnAddModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddModelActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("اسم الشركة");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("نوع الموديل");

        comboTypes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTypesActionPerformed(evt);
            }
        });

        lblAddBrand.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAddBrand.setForeground(new java.awt.Color(51, 102, 255));
        lblAddBrand.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddBrand.setText("إضافة شركة");
        lblAddBrand.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAddBrand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddBrandMouseClicked(evt);
            }
        });

        lblAddType.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAddType.setForeground(new java.awt.Color(51, 102, 255));
        lblAddType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddType.setText("إضافة نوع جديد");
        lblAddType.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAddType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddTypeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnAddModel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap(16, Short.MAX_VALUE)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(lblAddType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(lblAddBrand, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBrandName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddModel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))))))
                .addContainerGap())
        );

        kGradientPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblAddBrand, lblAddType});

        kGradientPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comboBrandName, comboTypes, txtAddModel});

        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAddModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboBrandName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddBrand))
                .addGap(87, 87, 87)
                .addComponent(btnAddModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        kGradientPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "تعديل بيانات الموديل", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 102, 255))); // NOI18N
        kGradientPanel2.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel2.setkStartColor(new java.awt.Color(204, 204, 204));

        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("رقم الموديل");

        lblModelId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblModelId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("الاسم");

        btnSaveChanges.setText("حفظ التغييرات");
        btnSaveChanges.setFocusable(false);
        btnSaveChanges.setFont(btnSaveChanges.getFont().deriveFont(btnSaveChanges.getFont().getStyle() | java.awt.Font.BOLD, btnSaveChanges.getFont().getSize()+1));
        btnSaveChanges.setkAllowGradient(false);
        btnSaveChanges.setkBackGroundColor(new java.awt.Color(51, 102, 255));
        btnSaveChanges.setkBorderRadius(40);
        btnSaveChanges.setkEndColor(new java.awt.Color(51, 51, 255));
        btnSaveChanges.setkHoverColor(new java.awt.Color(0, 102, 153));
        btnSaveChanges.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSaveChanges.setkPressedColor(new java.awt.Color(0, 102, 204));
        btnSaveChanges.setkStartColor(new java.awt.Color(0, 102, 102));
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesActionPerformed(evt);
            }
        });

        txtModelNameForUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtModelNameForUpdate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtModelNameForUpdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtModelNameForUpdateKeyPressed(evt);
            }
        });

        lblDeleteModel.setFont(lblDeleteModel.getFont().deriveFont(lblDeleteModel.getFont().getStyle() | java.awt.Font.BOLD));
        lblDeleteModel.setForeground(new java.awt.Color(255, 51, 51));
        lblDeleteModel.setText("حذف الموديل");
        lblDeleteModel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDeleteModel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDeleteModelMouseClicked(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("عدد الأجهزة");

        lblDevicesCount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDevicesCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("اسم الشركة");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("نوع الموديل");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblDeleteModel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtModelNameForUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBrandNameUpdate, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboTypesUpdate, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDevicesCount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModelId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91))
        );

        kGradientPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel6});

        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblModelId, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblDevicesCount, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtModelNameForUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboBrandNameUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboTypesUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDeleteModel))
                .addContainerGap())
        );

        btnSaveChanges.setVisible(false);
        lblDeleteModel.setVisible(false);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnRefreshFormData.setText("تحديث");
        btnRefreshFormData.setFont(new java.awt.Font("Adobe Arabic", 1, 8)); // NOI18N
        btnRefreshFormData.setkAllowGradient(false);
        btnRefreshFormData.setkBackGroundColor(new java.awt.Color(51, 102, 255));
        btnRefreshFormData.setkBorderRadius(40);
        btnRefreshFormData.setkEndColor(new java.awt.Color(0, 102, 153));
        btnRefreshFormData.setkHoverColor(new java.awt.Color(0, 102, 153));
        btnRefreshFormData.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnRefreshFormData.setkHoverStartColor(new java.awt.Color(0, 102, 153));
        btnRefreshFormData.setkPressedColor(new java.awt.Color(0, 102, 204));
        btnRefreshFormData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshFormDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(btnRefreshFormData, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTableTitle)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGap(5, 5, 5)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTableTitle)
                            .addComponent(btnRefreshFormData, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void tableModelsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableModelsMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            if (evt.getClickCount() == 1) {
                int selectedRowIndex = tableModels.getSelectedRow();
                Model model = getModelFromSelectedRow(selectedRowIndex);
                showItemDetails(model);
                changeUpdateDepControllesVisibility();
            }
        }
    }//GEN-LAST:event_tableModelsMouseClicked

    private void btnAddModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddModelActionPerformed
        try {
            String modelName = getModelTextFrom(txtAddModel);
            checkThatModelNameIsNotEmpty(modelName);
            Brand brand = getSelectedBrand(comboBrandName);
            checkIfBrandIsNotNull(brand);
            data.pojo.DeviceType type = getSelectedType(comboTypes);

            Model model = new Model(brand.getBrandId(), modelName, type.getTypeId());
//            Model model = new Model(1500, modelName, type.getTypeId());
//            Model model = new Model(1500, modelName, 100);

            System.out.println("Model Name is "+modelName);
            boolean isAdded = addModelToDB(model);
            if (isAdded) {
                getFormData();
            }
        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
        }

    }//GEN-LAST:event_btnAddModelActionPerformed

    private void lblDeleteModelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeleteModelMouseClicked
        int selectedIndex = tableModels.getSelectedRow();
        if (selectedIndex == -1) {
            MessageBox.showErrorMessage("يرجي اختيار موديل أولا للحذف");
            return;
        }

        int delOption = JOptionPane.showConfirmDialog(this, "سيتم حذف الموديل نهائيا\nهل تريد المتابعة", "حذف الموديل", JOptionPane.YES_NO_OPTION);
        if (delOption == JOptionPane.YES_OPTION) {

            Model model = allModels.get(selectedIndex);
            boolean isDeleted = deleteModel(model);
            if (isDeleted) {
                lblModelId.setText("");
                txtModelNameForUpdate.setText("");
                tableModels.setSelectionModel(new DefaultListSelectionModel());
                getFormData();
            }
        }

    }//GEN-LAST:event_lblDeleteModelMouseClicked

    private void btnSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangesActionPerformed

        try {
            String modelName = getModelTextFrom(txtModelNameForUpdate);
            checkThatModelNameIsNotEmpty(modelName);
            Brand brand = getSelectedBrand(comboBrandNameUpdate);
            checkIfBrandIsNotNull(brand);
            data.pojo.DeviceType type = getSelectedType(comboTypesUpdate);

            int modelId = Integer.parseInt(lblModelId.getText().trim());
            Model model = new Model(modelId, brand.getBrandId(), modelName, type.getTypeId());

            boolean isUpdated = updateModel(model);
            if (isUpdated) {
                getFormData();
            }
        } catch (Exception e) {
            MessageBox.showErrorMessage(e.getMessage());
        }
    }//GEN-LAST:event_btnSaveChangesActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void tableModelsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableModelsKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            getFormData();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            lblDeleteModelMouseClicked(null);
        }
    }//GEN-LAST:event_tableModelsKeyPressed

    private void lblTableTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTableTitleMouseClicked

    }//GEN-LAST:event_lblTableTitleMouseClicked

    private void txtAddModelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddModelKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAddModel.doClick();
        }
    }//GEN-LAST:event_txtAddModelKeyPressed

    private void txtModelNameForUpdateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModelNameForUpdateKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSaveChanges.doClick();
        }
    }//GEN-LAST:event_txtModelNameForUpdateKeyPressed

    private void btnRefreshFormDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshFormDataActionPerformed
        getFormData();
    }//GEN-LAST:event_btnRefreshFormDataActionPerformed

    private void lblAddBrandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddBrandMouseClicked
        startNewFrameWithOldFrame(BrandsUI.getInstance());
    }//GEN-LAST:event_lblAddBrandMouseClicked

    private void lblAddTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddTypeMouseClicked
        startNewFrameWithOldFrame(TypesUI.getInstance());
    }//GEN-LAST:event_lblAddTypeMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        destroyInstance();
    }//GEN-LAST:event_formWindowClosed

    private void comboTypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTypesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTypesActionPerformed

    @Override
    public void destroyInstance() {
        allBrandsCombo.clear();
        allModels.clear();
        allTypesCombo.clear();
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
            java.util.logging.Logger.getLogger(ModelsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModelsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModelsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModelsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModelsUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btnAddModel;
    private com.k33ptoo.components.KButton btnRefreshFormData;
    private com.k33ptoo.components.KButton btnSaveChanges;
    private javax.swing.JComboBox<String> comboBrandName;
    private javax.swing.JComboBox<String> comboBrandNameUpdate;
    private javax.swing.JComboBox<String> comboTypes;
    private javax.swing.JComboBox<String> comboTypesUpdate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel3;
    private javax.swing.JLabel lblAddBrand;
    private javax.swing.JLabel lblAddType;
    private javax.swing.JLabel lblDeleteModel;
    private javax.swing.JLabel lblDevicesCount;
    private javax.swing.JLabel lblModelId;
    private javax.swing.JLabel lblTableTitle;
    private base.AdvancedTable tableModels;
    private javax.swing.JTextField txtAddModel;
    private javax.swing.JTextField txtModelNameForUpdate;
    // End of variables declaration//GEN-END:variables

    private void getFormData() {

        ArrayList<Model> models = getAllModels();
        if (models != null) {
            allModels.clear();
            allModels.addAll(models);

            fillModelTable(allModels);
        }
//        System.out.println("Model is "+models.size());

        ArrayList<Brand> brands = getBrandNames();
        if (brands != null) {
            allBrandsCombo.clear();
            allBrandsCombo.addAll(brands);

            fillBrandsComboBox(brands);
        }
//        System.out.println("Brands is ok "+brands.size());

        ArrayList<DeviceType> types = getAllTypes();
        if (types != null) {
            allTypesCombo.clear();
            allTypesCombo.addAll(types);

            fillTypesComboBox(types);
        }
//        System.out.println("Type is ok "+types.size());

//        emptyFormFields(this);
        txtAddModel.setText("");
        lblModelId.setText("");
        lblDevicesCount.setText("");

        comboBrandName.setSelectedIndex(-1);
        comboBrandNameUpdate.setSelectedIndex(-1);

        comboTypes.setSelectedIndex(-1);
        comboTypesUpdate.setSelectedIndex(-1);

        txtModelNameForUpdate.setText("");
        tableModels.setSelectionModel(new DefaultListSelectionModel());

    }

    private ArrayList<Model> getAllModels() {
//        return ModelsRepository.getInstance().getAllModels("", "");
        return ModelsRepository.getInstance().getAllLocalModels("", "", new int[]{});
    }

    private void fillModelTable(ArrayList<Model> models) {
        tableModels.clearTable();
        DefaultTableModel model = tableModels.getMutableModel();

        models.forEach((m) -> {
            model.addRow(new Object[]{
                m.getModelId(),
                m.getModelName(),
                m.getBrandName(),
                m.getType(),
                m.getDevicesCountInModel()

            });
        });
        tableModels.setModel(model);
    }

    private Model getModelFromSelectedRow(int selectedRowIndex) {
        return allModels.get(selectedRowIndex);
    }

    private void showItemDetails(Model model) {
        lblModelId.setText(model.getModelId() + "");
        txtModelNameForUpdate.setText(model.getModelName());
        lblDevicesCount.setText(model.getDevicesCountInModel() + "");
        comboBrandNameUpdate.setSelectedItem(model.getBrandName());
        comboTypesUpdate.setSelectedItem(model.getType());
    }

    private void changeUpdateDepControllesVisibility() {
        btnSaveChanges.setVisible(true);
        lblDeleteModel.setVisible(true);
    }

    private boolean addModelToDB(Model model) {
//        return ModelsRepository.getInstance().addNewModel(model);
        return ModelsRepository.getInstance().addNewLocalModel(model);
    }

    private boolean deleteModel(Model model) {
//        return ModelsRepository.getInstance().deleteModel(model.getModelId());
        return ModelsRepository.getInstance().deleteLocalModel(model.getModelId());
    }

    private boolean updateModel(Model model) {
//        return ModelsRepository.getInstance().updateModel(model);
        return ModelsRepository.getInstance().updateLocalModel(model);
    }

    private void emptyFormFields(Container container) {
        for (Component comp : container.getComponents()) {
            if (comp instanceof JTextField) {
                ((JTextField) comp).setText("");
            } else if (comp instanceof JLabel) {

                ((JLabel) comp).setText("");
            } else if (comp instanceof Container) {
                emptyFormFields((Container) comp);
            }
        }
    }

    private Brand getSelectedBrand(JComboBox brandsComboBox) throws Exception {
        int selectedBrandIndex = brandsComboBox.getSelectedIndex();
        if (selectedBrandIndex == -1) {
            throw new Exception("يرجي اختيار الشركة");
        }
        return allBrandsCombo.get(selectedBrandIndex);
    }

    private String getModelTextFrom(JTextField txtModelName) {
        String model = txtModelName.getText().trim();
        return model;
    }

    private void checkThatModelNameIsNotEmpty(String modelName) throws Exception {
        if (modelName.trim().isEmpty()) {
            throw new Exception("يرجي ادخال قيمة صحيحة للموديل");
        }
    }

    private void checkIfBrandIsNotNull(Brand brand) throws Exception {
        if (brand == null) {
            throw new Exception("يرجي اختيار الشركة");
        }

        if (brand.getBrandId() <= 0) {
            throw new Exception("يرجي اختيار الشركة");
        }

    }

    private data.pojo.DeviceType getSelectedType(JComboBox typesComboBox) throws Exception {
        int selectedTypeIndex = typesComboBox.getSelectedIndex();
        if (selectedTypeIndex == -1) {
            throw new Exception("يرجي اختيار نوع الموديل");
        }
        return allTypesCombo.get(selectedTypeIndex);
    }

    private ArrayList<Brand> getBrandNames() {
//        return BrandsRepository.getInstance().getOnlyBrandNames();
        return BrandsRepository.getInstance().getOnlyLocalBrandNames();
    }

    private void fillBrandsComboBox(ArrayList<Brand> brands) {
        DefaultComboBoxModel modelForAdding = new DefaultComboBoxModel();
        DefaultComboBoxModel modelForUpdating = new DefaultComboBoxModel();

        brands.forEach((brand) -> {
            modelForAdding.addElement(brand.getBrandName());
            modelForUpdating.addElement(brand.getBrandName());
        });

        comboBrandName.setModel(modelForAdding);
        comboBrandNameUpdate.setModel(modelForUpdating);
    }

    private ArrayList<data.pojo.DeviceType> getAllTypes() {
//        return TypesRepository.getInstance().getAllTypes();
        return TypesRepository.getInstance().getAllLocalTypes();
    }

    private void fillTypesComboBox(ArrayList<DeviceType> types) {

        DefaultComboBoxModel modelForAdding = new DefaultComboBoxModel();
        DefaultComboBoxModel modelForUpdating = new DefaultComboBoxModel();

        types.forEach((type) -> {
            modelForAdding.addElement(type.getTypeName());
            modelForUpdating.addElement(type.getTypeName());
        });

        comboTypes.setModel(modelForAdding);
        comboTypesUpdate.setModel(modelForUpdating);
    }
}
