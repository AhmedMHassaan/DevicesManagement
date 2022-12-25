/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.devices;

import base.AdvancedFrame;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import data.pojo.Department;
import data.pojo.Device;
import data.pojo.DeviceSearchFields;
import data.pojo.DeviceType;
import data.pojo.Model;
import data.pojo.responses.DeviceTransactionResponse;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STOnOff1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import other.FilePathsConstants;
import repository.DepartmentsRepository;
import repository.DevicesRepository;
import repository.ModelsRepository;
import repository.TypesRepository;
import ui.add_new_device.AddNewDevice;
import ui.departments.DepartmentsUI;
import ui.transactions_ui.TransactionsUI;
import ui.transition_report.TransisionReportUI;
import ui.update_device_info.UpdateDeviceInfoUI;
import uis_items.CustomProgressDialog;
import utils.MessageBox;
import utils.MutableLiveData;

/**
 *
 * @author pc
 */
public class DevicesUI extends AdvancedFrame {

//   private final ArrayList<Device> allDevices = new ArrayList<>();
    private DevicesController devicesController = new DevicesController(
            DevicesRepository.getInstance(),
            DepartmentsRepository.getInstance(),
            TypesRepository.getInstance(),
            ModelsRepository.getInstance()
    );

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    private static DevicesUI instance = null;
    private String departmentName = null; // will be sent to filter by one dep  from reportUI page
    private int typeId = -1; // will be sent to filter by one type  from statistics page
    private int modelId = -1; // will be sent to filter by one type  from statistics page
    public static MutableLiveData<Boolean> addingLiveData = new MutableLiveData<>();

    /**
     * Creates new form DepartmentsUI
     *
     * @param depName
     * @param _typeId
     * @param _modelId
     */
    public DevicesUI(String depName, int _typeId, int _modelId) {
        this.departmentName = depName;
        this.typeId = _typeId;
        this.modelId = _modelId;
        initComponents();
    }

    public static DevicesUI getInstance() {

        return getInstance(null, -1, -1);
    }

    public static DevicesUI getInstance(String depName, int _typeId, int _modelId) {

        synchronized (DevicesUI.class) {
            if (instance == null) {
                synchronized (DevicesUI.class) {
//                    instance = new DevicesUI();
                    instance = new DevicesUI(depName, _typeId, _modelId);
                }
            }

        }
        instance.departmentName = depName;
        instance.typeId = _typeId;
        instance.modelId = _modelId;
        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablePopupMenu = new javax.swing.JPopupMenu();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDevices = new base.AdvancedTable();
        lblTableTitle = new javax.swing.JLabel();
        lblRefreshPage = new javax.swing.JLabel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        txtSeialNoForSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSearch = new com.k33ptoo.components.KButton();
        jLabel1 = new javax.swing.JLabel();
        combTypesForSearching = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        lblRemoveTypeSelection = new javax.swing.JLabel();
        txtDeviceNameForSearch = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        comboDepsForSearching = new javax.swing.JComboBox<>();
        lblRemoveDepSelection = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblRemoveModelsSelection = new javax.swing.JLabel();
        comboModelsForSearching = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        lblClearFilterFields = new javax.swing.JLabel();
        btnAddDevice = new javax.swing.JButton();
        btnDeleteSelectedDevices = new javax.swing.JButton();
        btnShowTransactions = new javax.swing.JButton();
        btnUpdateDeviceInfo = new javax.swing.JButton();
        btnExportAsExel = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        txtReceiver = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtTransReason = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDeviceNewName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblCurrentDep = new javax.swing.JLabel();
        comboDeps = new javax.swing.JComboBox<>();
        btnMoveDevice = new com.k33ptoo.components.KButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblDeviceName = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblSerialNumber = new javax.swing.JLabel();
        lblDeleteDevice = new javax.swing.JLabel();
        lblAddNewDep = new javax.swing.JLabel();
        lblAddingTime = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtSender = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        lblDeviceCount = new javax.swing.JLabel();

        tablePopupMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tablePopupMenu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("بيانات الأجهزة");
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
                "الاسم", "S.N", "الموديل", "الشركة", "النوع", "الفرع"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
        tableDevices.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableDevicesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableDevices);
        if (tableDevices.getColumnModel().getColumnCount() > 0) {
            tableDevices.getColumnModel().getColumn(1).setMinWidth(10);
            tableDevices.getColumnModel().getColumn(1).setPreferredWidth(10);
            tableDevices.getColumnModel().getColumn(2).setMinWidth(10);
            tableDevices.getColumnModel().getColumn(2).setPreferredWidth(10);
            tableDevices.getColumnModel().getColumn(3).setMinWidth(15);
            tableDevices.getColumnModel().getColumn(3).setPreferredWidth(15);
            tableDevices.getColumnModel().getColumn(4).setMinWidth(20);
            tableDevices.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        lblTableTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTableTitle.setForeground(new java.awt.Color(51, 102, 255));
        lblTableTitle.setText("أجهزة كلية الضباط الاحتياط");
        lblTableTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTableTitleMouseClicked(evt);
            }
        });

        lblRefreshPage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblRefreshPage.setText("تحديث الصفحة");
        lblRefreshPage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRefreshPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRefreshPageMouseClicked(evt);
            }
        });

        kGradientPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true), "البحث عن جهاز", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        kGradientPanel1.setkBorderRadius(15);
        kGradientPanel1.setkEndColor(java.awt.SystemColor.activeCaption);
        kGradientPanel1.setkGradientFocus(50);
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 204, 204));

        txtSeialNoForSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSeialNoForSearch.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSeialNoForSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSeialNoForSearchKeyPressed(evt);
            }
        });

        jLabel2.setText("السيريال");

        btnSearch.setText("بحث");
        btnSearch.setFocusable(false);
        btnSearch.setFont(btnSearch.getFont().deriveFont(btnSearch.getFont().getStyle() | java.awt.Font.BOLD, btnSearch.getFont().getSize()+1));
        btnSearch.setkAllowGradient(false);
        btnSearch.setkBackGroundColor(new java.awt.Color(51, 102, 255));
        btnSearch.setkBorderRadius(40);
        btnSearch.setkEndColor(new java.awt.Color(0, 102, 153));
        btnSearch.setkHoverColor(new java.awt.Color(0, 102, 153));
        btnSearch.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSearch.setkHoverStartColor(new java.awt.Color(0, 102, 153));
        btnSearch.setkPressedColor(new java.awt.Color(0, 102, 204));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("البجث عن جهاز");
        jLabel1.setToolTipText("");

        combTypesForSearching.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        combTypesForSearching.setMaximumRowCount(10);
        combTypesForSearching.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combTypesForSearchingItemStateChanged(evt);
            }
        });
        combTypesForSearching.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                combTypesForSearchingPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        combTypesForSearching.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combTypesForSearchingMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                combTypesForSearchingMouseReleased(evt);
            }
        });
        combTypesForSearching.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combTypesForSearchingActionPerformed(evt);
            }
        });
        combTypesForSearching.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                combTypesForSearchingPropertyChange(evt);
            }
        });
        combTypesForSearching.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                combTypesForSearchingVetoableChange(evt);
            }
        });

        jLabel12.setText("نوع الجهاز");

        lblRemoveTypeSelection.setFont(lblRemoveTypeSelection.getFont().deriveFont(lblRemoveTypeSelection.getFont().getStyle() | java.awt.Font.BOLD, lblRemoveTypeSelection.getFont().getSize()-1));
        lblRemoveTypeSelection.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRemoveTypeSelection.setText("إلغاء التحديد");
        lblRemoveTypeSelection.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRemoveTypeSelection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRemoveTypeSelectionMouseClicked(evt);
            }
        });

        txtDeviceNameForSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDeviceNameForSearch.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDeviceNameForSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDeviceNameForSearchKeyPressed(evt);
            }
        });

        jLabel14.setText("اسم الجهاز");

        comboDepsForSearching.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        comboDepsForSearching.setMaximumRowCount(10);
        comboDepsForSearching.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboDepsForSearchingItemStateChanged(evt);
            }
        });
        comboDepsForSearching.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comboDepsForSearchingPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        comboDepsForSearching.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comboDepsForSearchingMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                comboDepsForSearchingMouseReleased(evt);
            }
        });
        comboDepsForSearching.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDepsForSearchingActionPerformed(evt);
            }
        });
        comboDepsForSearching.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                comboDepsForSearchingPropertyChange(evt);
            }
        });
        comboDepsForSearching.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                comboDepsForSearchingVetoableChange(evt);
            }
        });

        lblRemoveDepSelection.setFont(lblRemoveDepSelection.getFont().deriveFont(lblRemoveDepSelection.getFont().getStyle() | java.awt.Font.BOLD, lblRemoveDepSelection.getFont().getSize()-1));
        lblRemoveDepSelection.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRemoveDepSelection.setText("إلغاء التحديد");
        lblRemoveDepSelection.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRemoveDepSelection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRemoveDepSelectionMouseClicked(evt);
            }
        });

        jLabel16.setText("الفرع الحالي");

        lblRemoveModelsSelection.setFont(lblRemoveModelsSelection.getFont().deriveFont(lblRemoveModelsSelection.getFont().getStyle() | java.awt.Font.BOLD, lblRemoveModelsSelection.getFont().getSize()-1));
        lblRemoveModelsSelection.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRemoveModelsSelection.setText("إلغاء التحديد");
        lblRemoveModelsSelection.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRemoveModelsSelection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRemoveModelsSelectionMouseClicked(evt);
            }
        });

        comboModelsForSearching.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        comboModelsForSearching.setMaximumRowCount(10);
        comboModelsForSearching.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboModelsForSearchingItemStateChanged(evt);
            }
        });
        comboModelsForSearching.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comboModelsForSearchingPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        comboModelsForSearching.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comboModelsForSearchingMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                comboModelsForSearchingMouseReleased(evt);
            }
        });
        comboModelsForSearching.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboModelsForSearchingActionPerformed(evt);
            }
        });
        comboModelsForSearching.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                comboModelsForSearchingPropertyChange(evt);
            }
        });
        comboModelsForSearching.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                comboModelsForSearchingVetoableChange(evt);
            }
        });

        jLabel17.setText("موديل الجهاز");

        lblClearFilterFields.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClearFilterFields.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClearFilterFields.setText("مسح تحديدات البحث");
        lblClearFilterFields.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClearFilterFields.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClearFilterFieldsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblClearFilterFields)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRemoveTypeSelection)
                                    .addComponent(lblRemoveDepSelection)
                                    .addComponent(lblRemoveModelsSelection))
                                .addGap(18, 18, 18)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(combTypesForSearching, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDeviceNameForSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(comboDepsForSearching, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboModelsForSearching, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(txtSeialNoForSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel2)
                            .addComponent(jLabel12)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10))))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSeialNoForSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtDeviceNameForSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(combTypesForSearching, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRemoveTypeSelection))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(comboDepsForSearching, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRemoveDepSelection))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(comboModelsForSearching, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRemoveModelsSelection))
                .addGap(17, 17, 17)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClearFilterFields))
                .addContainerGap())
        );

        btnAddDevice.setText("إضافة جهاز");
        btnAddDevice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDeviceActionPerformed(evt);
            }
        });

        btnDeleteSelectedDevices.setText("حذف الأجهزة المحددة");
        btnDeleteSelectedDevices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSelectedDevicesActionPerformed(evt);
            }
        });

        btnShowTransactions.setText("عرض عمليات النقل");
        btnShowTransactions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowTransactionsActionPerformed(evt);
            }
        });

        btnUpdateDeviceInfo.setText("تعديل البيانات");
        btnUpdateDeviceInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDeviceInfoActionPerformed(evt);
            }
        });

        btnExportAsExel.setBackground(new java.awt.Color(51, 153, 0));
        btnExportAsExel.setForeground(new java.awt.Color(255, 255, 255));
        btnExportAsExel.setText("حفظ في ملف Exel");
        btnExportAsExel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportAsExelActionPerformed(evt);
            }
        });

        kGradientPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true), "نقل الجهاز", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        kGradientPanel2.setkEndColor(java.awt.SystemColor.activeCaption);
        kGradientPanel2.setkGradientFocus(200);
        kGradientPanel2.setkStartColor(new java.awt.Color(204, 204, 204));

        txtReceiver.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtReceiver.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtTransReason.setColumns(20);
        txtTransReason.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        txtTransReason.setRows(5);
        jScrollPane2.setViewportView(txtTransReason);

        jLabel6.setText("المستلم");

        jLabel7.setText("سبب النقل");

        jLabel5.setText("نقل إلي");

        txtDeviceNewName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtDeviceNewName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel4.setText("القسم الحالي");

        jLabel8.setText("اسم الجهاز الجديد");

        lblCurrentDep.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCurrentDep.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        comboDeps.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        comboDeps.setMaximumRowCount(10);

        btnMoveDevice.setText("نقل الجهاز");
        btnMoveDevice.setFont(btnMoveDevice.getFont().deriveFont(btnMoveDevice.getFont().getStyle() | java.awt.Font.BOLD));
        btnMoveDevice.setkAllowGradient(false);
        btnMoveDevice.setkBackGroundColor(new java.awt.Color(51, 102, 255));
        btnMoveDevice.setkBorderRadius(40);
        btnMoveDevice.setkEndColor(new java.awt.Color(0, 102, 153));
        btnMoveDevice.setkHoverColor(new java.awt.Color(0, 102, 153));
        btnMoveDevice.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnMoveDevice.setkHoverStartColor(new java.awt.Color(0, 102, 153));
        btnMoveDevice.setkPressedColor(new java.awt.Color(0, 102, 204));
        btnMoveDevice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveDeviceActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 255));
        jLabel3.setText("نقل الجهاز إلي قسم آخر");
        jLabel3.setToolTipText("");

        jLabel9.setText("اسم الجهاز");

        lblDeviceName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDeviceName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel11.setText("السيريال");

        lblSerialNumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSerialNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lblDeleteDevice.setFont(lblDeleteDevice.getFont().deriveFont(lblDeleteDevice.getFont().getStyle() | java.awt.Font.BOLD));
        lblDeleteDevice.setForeground(new java.awt.Color(255, 51, 51));
        lblDeleteDevice.setText("حذف الجهاز");
        lblDeleteDevice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDeleteDevice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDeleteDeviceMouseClicked(evt);
            }
        });

        lblAddNewDep.setFont(lblAddNewDep.getFont().deriveFont(lblAddNewDep.getFont().getStyle() | java.awt.Font.BOLD, lblAddNewDep.getFont().getSize()+1));
        lblAddNewDep.setForeground(new java.awt.Color(51, 102, 255));
        lblAddNewDep.setText("إضافة فرع جديد");
        lblAddNewDep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAddNewDep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddNewDepMouseClicked(evt);
            }
        });

        lblAddingTime.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAddingTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel13.setText("وقت الإضافة");

        jLabel15.setText("أمين العهدة");

        txtSender.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtSender.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(10, 10, 10))
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSerialNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblAddingTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(lblDeviceName, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))
                        .addGap(24, 24, 24))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(btnMoveDevice, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDeleteDevice)
                        .addGap(269, 269, 269))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDeviceNewName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtReceiver, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(lblAddNewDep)
                                .addGap(29, 29, 29)
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboDeps, javax.swing.GroupLayout.Alignment.TRAILING, 0, 132, Short.MAX_VALUE)
                                    .addComponent(lblCurrentDep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(txtSender, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel15))
                        .addContainerGap())))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblDeviceName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblSerialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblAddingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(lblCurrentDep, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboDeps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddNewDep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDeviceNewName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtSender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtReceiver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoveDevice, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDeleteDevice)))
        );

        lblDeleteDevice.setVisible(false);

        jScrollPane3.setViewportView(kGradientPanel2);

        jLabel18.setForeground(new java.awt.Color(0, 102, 255));
        jLabel18.setText("عدد الأجهزة");

        lblDeviceCount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDeviceCount.setText("--");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblDeviceCount)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel18)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblRefreshPage)
                        .addGap(18, 18, 18)
                        .addComponent(btnExportAsExel)
                        .addGap(311, 311, 311)
                        .addComponent(lblTableTitle)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdateDeviceInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnShowTransactions)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteSelectedDevices)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddDevice)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTableTitle)
                                .addComponent(lblRefreshPage)
                                .addComponent(btnExportAsExel))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAddDevice)
                                .addComponent(btnDeleteSelectedDevices)
                                .addComponent(btnShowTransactions)
                                .addComponent(btnUpdateDeviceInfo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(lblDeviceCount))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        btnShowTransactions.setVisible(false);
        btnUpdateDeviceInfo.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void lblTableTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTableTitleMouseClicked

    }//GEN-LAST:event_lblTableTitleMouseClicked

    private void lblRefreshPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefreshPageMouseClicked

        makeSearchingFieldsEmpty();
        getFormData();
    }//GEN-LAST:event_lblRefreshPageMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        devicesController.destroy();
        devicesController = null;
//        devicesController = null;
    }//GEN-LAST:event_formWindowClosed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        scheduler.execute(() -> {
            try {
                CustomProgressDialog.showProgressDialog(this, "جار عرض بيانات الأجهزة");
                String serialNumber = txtSeialNoForSearch.getText().trim();
                String deviceName = txtDeviceNameForSearch.getText().trim();
                int departmentId = getSelectedDepartmentId();
                int selectedTypeId = getSelectedTypeId();
                int selectedModelId = getSelectedModelId();

//            devicesController.search(new DeviceSearchFields(serialNumber, deviceName, departmentId, selectedTypeId, selectedModelId));
                resetCounts();
                devicesController.search(new DeviceSearchFields(serialNumber, deviceName, departmentId, selectedTypeId, selectedModelId));
//            System.out.println("Dep id = " + departmentId);
                fillDevicesTable();
                updateCounts();
                makeDetailsLblsEmpty();
                changeDeleteLblVisiblity(false);
                CustomProgressDialog.hideProgressDialog();

            } catch (Exception ex) {
                Logger.getLogger(DevicesUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });


    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnMoveDeviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveDeviceActionPerformed
        scheduler.execute(() -> {
            try {
                
                boolean isMoved = devicesController.moveDeviceToAnotherDepartment(this,tableDevices, comboDeps, txtDeviceNewName, txtSender, txtReceiver, txtTransReason);

                if (isMoved) {

                    CustomProgressDialog.hideProgressDialog();
                    MessageBox.showMessage("تم نقل الجهاز " + txtDeviceNewName.getText() + " بنجاح ");
//                refreshPage();
                    CustomProgressDialog.showProgressDialog(this, "جارتجهيز المستند  ..");
                    DeviceTransactionResponse lastTranOpe = devicesController.getLastTransitionOperation();
                    CustomProgressDialog.hideProgressDialog();

                    if (lastTranOpe != null) {
                        int option = JOptionPane.showConfirmDialog(this, "هل تريد استخراج مستند النقل ؟", "استخراج مستند", JOptionPane.OK_CANCEL_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            startNewFrameWithOldFrame(new TransisionReportUI(lastTranOpe));
                        }
                    }

                    btnSearch.doClick();

                }

            } catch (Exception ex) {
                Logger.getLogger(DevicesUI.class.getName()).log(Level.SEVERE, null, ex);
                MessageBox.showErrorMessage(ex.getMessage());
            }
        });


    }//GEN-LAST:event_btnMoveDeviceActionPerformed

    private void tableDevicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDevicesMouseClicked
        try {
//            if (evt.getButton() == MouseEvent.BUTTON1 || evt.getButton() == MouseEvent.BUTTON3) {
            if (evt.getButton() == MouseEvent.BUTTON1) {
                Device selectedDevice = devicesController.getSelectedDevice(tableDevices);
                devicesController.showDeviceInfo(selectedDevice, lblCurrentDep, lblDeviceName, lblSerialNumber, txtDeviceNewName, lblAddingTime, txtSender);
                changeDeleteLblVisiblity(true);
                changeButtonShowTransactions(true);
                changeButtonUpdateDeviceInfo(true);
            }

            if (evt.getButton() == MouseEvent.BUTTON3) {

                preparePopupMenu();

                int r = tableDevices.rowAtPoint(evt.getPoint());
                if (r >= 0 && r < tableDevices.getRowCount()) {
                    tableDevices.setRowSelectionInterval(r, r);

                } else {
                    tableDevices.clearSelection();
                }

                int rowindex = tableDevices.getSelectedRow();
                if (rowindex < 0) {
                    return;
                }

//                if (evt.isPopupTrigger() && evt.getComponent() instanceof JTable) {
                if (evt.getComponent() instanceof JTable) {
                    showPopupMenu(evt);
//                    tablePopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
                }

//                showPopupMenu(evt);
            }

        } catch (Exception ex) {
            Logger.getLogger(DevicesUI.class.getName()).log(Level.SEVERE, null, ex);
            MessageBox.showErrorMessage(ex.getMessage());
        }
    }//GEN-LAST:event_tableDevicesMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (thereIsDataSentFromPrevioisPages()) {
            getCombosDataAndFillThem();
            selecetIntentDepartmentNameFromDepCombo();
            selecetIntentTypeNameFromTypeCombo();
            selecetIntentModelNameFromTypeCombo();
            btnSearch.doClick();
        } else {
            refreshPage();
        }

    }//GEN-LAST:event_formWindowOpened

    private void lblDeleteDeviceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeleteDeviceMouseClicked

        int delOption = JOptionPane.showConfirmDialog(this, "سيتم حذف الجهاز نهائيا\nهل تريد المتابعة", "حذف " + lblDeviceName.getText(), JOptionPane.YES_NO_OPTION);
        if (delOption == JOptionPane.YES_OPTION) {
            try {
                boolean isDeleted = devicesController.deleteSelectedDevice(tableDevices);
                if (isDeleted) {
                    refreshPage();
                }

            } catch (Exception ex) {
                Logger.getLogger(DevicesUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_lblDeleteDeviceMouseClicked

    private void txtSeialNoForSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSeialNoForSearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSearch.doClick();
        }
    }//GEN-LAST:event_txtSeialNoForSearchKeyPressed

    private void lblAddNewDepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddNewDepMouseClicked
        startNewFrameWithOldFrame(DepartmentsUI.getInstance());
    }//GEN-LAST:event_lblAddNewDepMouseClicked

    private void btnAddDeviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDeviceActionPerformed

        if (addingLiveData != null) {
            addingLiveData.observe((data) -> {
                lblRefreshPageMouseClicked(null);
            });
        }

        startNewFrameWithOldFrame(AddNewDevice.getInstance());
    }//GEN-LAST:event_btnAddDeviceActionPerformed

    private void btnDeleteSelectedDevicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSelectedDevicesActionPerformed

        boolean isDeleted = devicesController.deleteSelectedDevices(tableDevices);
        if (isDeleted) {
            refreshPage();
        }
    }//GEN-LAST:event_btnDeleteSelectedDevicesActionPerformed

    private void btnShowTransactionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowTransactionsActionPerformed
        try {
            Device selectedDevice = devicesController.getSelectedDevice(tableDevices);
            startNewFrameWithOldFrame(TransactionsUI.getInstance(selectedDevice.getDeviceId()));
        } catch (Exception ex) {
            MessageBox.showErrorMessage(ex.getMessage());
            Logger.getLogger(DevicesUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnShowTransactionsActionPerformed

    private void lblRemoveTypeSelectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRemoveTypeSelectionMouseClicked
        combTypesForSearching.setSelectedIndex(-1);
    }//GEN-LAST:event_lblRemoveTypeSelectionMouseClicked

    private void combTypesForSearchingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combTypesForSearchingItemStateChanged


    }//GEN-LAST:event_combTypesForSearchingItemStateChanged

    private void combTypesForSearchingMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combTypesForSearchingMouseReleased
//        System.out.println("id = " + evt.getID() + " **item =" + evt.get() + " *source " + evt.getSource() + " *state" + evt.getStateChange());
//System.out.println("Reaeased");

    }//GEN-LAST:event_combTypesForSearchingMouseReleased

    private void combTypesForSearchingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combTypesForSearchingMousePressed

    }//GEN-LAST:event_combTypesForSearchingMousePressed

    private void combTypesForSearchingPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combTypesForSearchingPopupMenuWillBecomeInvisible

    }//GEN-LAST:event_combTypesForSearchingPopupMenuWillBecomeInvisible

    private void combTypesForSearchingVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_combTypesForSearchingVetoableChange

    }//GEN-LAST:event_combTypesForSearchingVetoableChange

    private void combTypesForSearchingPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_combTypesForSearchingPropertyChange

    }//GEN-LAST:event_combTypesForSearchingPropertyChange

    private void combTypesForSearchingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combTypesForSearchingActionPerformed
        int selectedIndex = ((JComboBox) evt.getSource()).getSelectedIndex();
//        if (selectedIndex > -1) {
//            departmentName = ((JComboBox) evt.getSource()).getSelectedItem().toString();
//        }
        boolean isItemSelected = selectedIndex != -1;
        lblRemoveTypeSelection.setVisible(isItemSelected);
    }//GEN-LAST:event_combTypesForSearchingActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus


    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged

    }//GEN-LAST:event_formWindowStateChanged

    private void btnUpdateDeviceInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDeviceInfoActionPerformed
        try {
            Device selectedDevice = devicesController.getSelectedDevice(tableDevices);
            System.out.println("Model With brand is " + selectedDevice.getModel().getModelNameWithBrand());
            startNewFrameWithOldFrame(UpdateDeviceInfoUI.getInstance(selectedDevice));
        } catch (Exception ex) {
            Logger.getLogger(DevicesUI.class.getName()).log(Level.SEVERE, null, ex);
            MessageBox.showErrorMessage(ex.getMessage());
        }
    }//GEN-LAST:event_btnUpdateDeviceInfoActionPerformed

    private void btnExportAsExelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportAsExelActionPerformed

        scheduler.execute(() -> {
            try {
                CustomProgressDialog.showProgressDialog(this, "جار تحميل البيانات في ملف");
                String fileName = new FilePathsConstants().getDevicesExportPath();
                devicesController.exportDevicesAsExellSheet(tableDevices, fileName); // we will hide progress dialog in above method in controller

            } catch (Exception ex) {
                Logger.getLogger(DevicesUI.class.getName()).log(Level.SEVERE, null, ex);
                MessageBox.showErrorMessage(ex.getMessage());
            }
        });


    }//GEN-LAST:event_btnExportAsExelActionPerformed

    private void txtDeviceNameForSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDeviceNameForSearchKeyPressed
        txtSeialNoForSearchKeyPressed(evt);
    }//GEN-LAST:event_txtDeviceNameForSearchKeyPressed

    private void tableDevicesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableDevicesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            btnDeleteSelectedDevicesActionPerformed(null);
        }
    }//GEN-LAST:event_tableDevicesKeyPressed

    private void comboDepsForSearchingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboDepsForSearchingItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDepsForSearchingItemStateChanged

    private void comboDepsForSearchingPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboDepsForSearchingPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDepsForSearchingPopupMenuWillBecomeInvisible

    private void comboDepsForSearchingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboDepsForSearchingMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDepsForSearchingMousePressed

    private void comboDepsForSearchingMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboDepsForSearchingMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDepsForSearchingMouseReleased

    private void comboDepsForSearchingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDepsForSearchingActionPerformed
        int selectedIndex = ((JComboBox) evt.getSource()).getSelectedIndex();
//        if (selectedIndex > -1) {
//            departmentName = ((JComboBox) evt.getSource()).getSelectedItem().toString();
//        }
        boolean isItemSelected = selectedIndex != -1;
        lblRemoveDepSelection.setVisible(isItemSelected);
    }//GEN-LAST:event_comboDepsForSearchingActionPerformed

    private void comboDepsForSearchingPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_comboDepsForSearchingPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDepsForSearchingPropertyChange

    private void comboDepsForSearchingVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_comboDepsForSearchingVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDepsForSearchingVetoableChange

    private void lblRemoveDepSelectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRemoveDepSelectionMouseClicked
        comboDepsForSearching.setSelectedIndex(-1);
    }//GEN-LAST:event_lblRemoveDepSelectionMouseClicked

    private void lblRemoveModelsSelectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRemoveModelsSelectionMouseClicked
        comboModelsForSearching.setSelectedIndex(-1);
    }//GEN-LAST:event_lblRemoveModelsSelectionMouseClicked

    private void comboModelsForSearchingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboModelsForSearchingItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboModelsForSearchingItemStateChanged

    private void comboModelsForSearchingPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboModelsForSearchingPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_comboModelsForSearchingPopupMenuWillBecomeInvisible

    private void comboModelsForSearchingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboModelsForSearchingMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboModelsForSearchingMousePressed

    private void comboModelsForSearchingMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboModelsForSearchingMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_comboModelsForSearchingMouseReleased

    private void comboModelsForSearchingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboModelsForSearchingActionPerformed
        int selectedIndex = ((JComboBox) evt.getSource()).getSelectedIndex();
//        if (selectedIndex > -1) {
//            departmentName = ((JComboBox) evt.getSource()).getSelectedItem().toString();
//        }
        boolean isItemSelected = selectedIndex != -1;
        lblRemoveModelsSelection.setVisible(isItemSelected);
    }//GEN-LAST:event_comboModelsForSearchingActionPerformed

    private void comboModelsForSearchingPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_comboModelsForSearchingPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_comboModelsForSearchingPropertyChange

    private void comboModelsForSearchingVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_comboModelsForSearchingVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_comboModelsForSearchingVetoableChange

    private void lblClearFilterFieldsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClearFilterFieldsMouseClicked
        makeSearchingFieldsEmpty();
    }//GEN-LAST:event_lblClearFilterFieldsMouseClicked

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
            java.util.logging.Logger.getLogger(DevicesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DevicesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DevicesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DevicesUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DevicesUI(null, -1, -1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDevice;
    private javax.swing.JButton btnDeleteSelectedDevices;
    private javax.swing.JButton btnExportAsExel;
    private com.k33ptoo.components.KButton btnMoveDevice;
    private com.k33ptoo.components.KButton btnSearch;
    private javax.swing.JButton btnShowTransactions;
    private javax.swing.JButton btnUpdateDeviceInfo;
    private javax.swing.JComboBox<String> combTypesForSearching;
    private javax.swing.JComboBox<String> comboDeps;
    private javax.swing.JComboBox<String> comboDepsForSearching;
    private javax.swing.JComboBox<String> comboModelsForSearching;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lblAddNewDep;
    private javax.swing.JLabel lblAddingTime;
    private javax.swing.JLabel lblClearFilterFields;
    private javax.swing.JLabel lblCurrentDep;
    private javax.swing.JLabel lblDeleteDevice;
    private javax.swing.JLabel lblDeviceCount;
    private javax.swing.JLabel lblDeviceName;
    private javax.swing.JLabel lblRefreshPage;
    private javax.swing.JLabel lblRemoveDepSelection;
    private javax.swing.JLabel lblRemoveModelsSelection;
    private javax.swing.JLabel lblRemoveTypeSelection;
    private javax.swing.JLabel lblSerialNumber;
    private javax.swing.JLabel lblTableTitle;
    private base.AdvancedTable tableDevices;
    private javax.swing.JPopupMenu tablePopupMenu;
    private javax.swing.JTextField txtDeviceNameForSearch;
    private javax.swing.JTextField txtDeviceNewName;
    private javax.swing.JTextField txtReceiver;
    private javax.swing.JTextField txtSeialNoForSearch;
    private javax.swing.JTextField txtSender;
    private javax.swing.JTextArea txtTransReason;
    // End of variables declaration//GEN-END:variables

    private void getFormData() {
        scheduler.execute(() -> {
            CustomProgressDialog.showProgressDialog(this, "جار عرض بيانات الأجهزة");
            resetCounts();
            devicesController.getAllDevices(new DeviceSearchFields());
            fillDevicesTable();
            updateCounts();
            makeDetailsLblsEmpty();
            changeDeleteLblVisiblity(false);

            getCombosDataAndFillThem();
            CustomProgressDialog.hideProgressDialog();

        });

    }

    private void fillDevicesTable() {
        devicesController.fillDevicesTable(tableDevices);
    }

    private void fillDepartmentsInComboDeps() {
        devicesController.fillDepartmentsIn(this.comboDeps);
        devicesController.fillDepartmentsIn(comboDepsForSearching);

    }

    private void fillTypesInComboTypes() {
//        devicesController.fillDepartmentsIn(this.comboDeps);
        devicesController.fillTypesIn(combTypesForSearching);

    }

    private void fillModelsInComboModels() {
//        devicesController.fillDepartmentsIn(this.comboDeps);
        devicesController.fillModelsIn(comboModelsForSearching);

    }

    private void makeDetailsLblsEmpty() {
        lblCurrentDep.setText("");
        lblDeviceName.setText("");
        lblSerialNumber.setText("");

        txtReceiver.setText("");
        txtSender.setText("");
        txtDeviceNewName.setText("");
        txtTransReason.setText("");
        lblAddingTime.setText("");

        comboDeps.setSelectedIndex(-1);

    }

    private void refreshPage() {
        lblRefreshPageMouseClicked(null);
    }

    private void changeDeleteLblVisiblity(boolean isVisible) {
        lblDeleteDevice.setVisible(isVisible);
    }

    private void changeButtonShowTransactions(boolean isVisible) {
        btnShowTransactions.setVisible(isVisible);
    }

    private void changeButtonUpdateDeviceInfo(boolean isVisible) {
        btnUpdateDeviceInfo.setVisible(isVisible);
    }

    @Override
    public void destroyInstance() {
        addingLiveData = null;
        devicesController.destroy();
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdown();
        }
        instance = null;

    }

    private void selecetIntentDepartmentNameFromDepCombo() {

        if (departmentName != null) {
            comboDepsForSearching.setSelectedItem(departmentName);
        }

//        btnSearch.doClick();
    }

    private void selecetIntentTypeNameFromTypeCombo() {

        if (typeId != -1) {
            String typeName = devicesController.getTypeNameFromTypeId(typeId);
            if (typeName != null) {
                combTypesForSearching.setSelectedItem(typeName);
            }

        }

//        btnSearch.doClick();
    }

    private void selecetIntentModelNameFromTypeCombo() {

        if (modelId != -1) {

            String typeName = devicesController.getModelNameFromModelId(modelId);
            if (typeName != null) {
                comboModelsForSearching.setSelectedItem(typeName);
            }

        }

//        btnSearch.doClick();
    }

    private int getSelectedDepartmentId() {
        Department selectedDepartment = null;
        try {
            selectedDepartment = devicesController.getSelectedDepartment(comboDepsForSearching);
            return selectedDepartment.getDepartmentId();
        } catch (Exception e) {
            return -1;
        }
    }

    private void preparePopupMenu() {
        tablePopupMenu.removeAll();
        tablePopupMenu.setBorderPainted(true);

        tablePopupMenu.add("حذف").addActionListener((ae) -> {
            lblDeleteDeviceMouseClicked(null);
        });

        tablePopupMenu.add("تعديل البيانات").addActionListener((ae) -> btnUpdateDeviceInfoActionPerformed(ae));
        tablePopupMenu.add("عرض عمليات النقل").addActionListener((ae) -> btnShowTransactionsActionPerformed(ae));
        tablePopupMenu.add("نسخ").addActionListener((ae) -> {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection strse1 = new StringSelection(tableDevices.getSelectedCell());
            clipboard.setContents(strse1, strse1);
            MessageBox.showMessage("تم نسخ " + tableDevices.getSelectedCell() + " بنجاح");

        }
        );
    }

    private void showPopupMenu(MouseEvent evt) {
        tablePopupMenu.show(tableDevices, evt.getX(), evt.getY());
//        System.out.println("Shown");
    }

    private void makeSearchingFieldsEmpty() {
        txtSeialNoForSearch.setText("");
        txtDeviceNameForSearch.setText("");
        lblRemoveDepSelectionMouseClicked(null);
        lblRemoveTypeSelectionMouseClicked(null);
        lblRemoveModelsSelectionMouseClicked(null);

    }

    private int getSelectedTypeId() {
        DeviceType selectedDevice = null;
        try {
            selectedDevice = devicesController.getSelectedType(combTypesForSearching);
            return selectedDevice.getTypeId();
        } catch (Exception e) {
            return -1;
        }
    }

    private int getSelectedModelId() {
        Model model = null;
        try {
            model = devicesController.getSelectedModel(comboModelsForSearching);
            return model.getModelId();
        } catch (Exception e) {
            System.out.println("Error is " + e.getMessage());
            return -1;
        }
    }

    private void getCombosDataAndFillThem() {
        devicesController.getAllDepartments();
        devicesController.getAllTypes();
        devicesController.getAllModels();
        fillDepartmentsInComboDeps();
        fillTypesInComboTypes();
        fillModelsInComboModels();
    }

    private boolean thereIsDataSentFromPrevioisPages() {
        return typeId != -1
                || (departmentName != null && !departmentName.isEmpty())
                || modelId != -1;
    }

    private void updateCounts() {
        devicesController.updateDeviceCountLabel(lblDeviceCount);
    }

    private void resetCounts() {
        devicesController.resetDeviceCountLabel(lblDeviceCount);
    }

    private void word() {
        try {

            /*POIFSFileSystem fileSys = new POIFSFileSystem(new FileInputStream("d.doc"));
            HWPFDocument document = new HWPFDocument(fileSys);
            
            
            HeaderStories headerStore = new HeaderStories(document);
            headerStore.
            
            
            document.getParagraphTable().insert(0, 0, new SprmBuffer("Welcome".getBytes(), true, 0));*/
            XWPFDocument document = new XWPFDocument();

            FileOutputStream out = new FileOutputStream("test.docx");
            addHeaderTitles(document);
            addReportTitle(document);
            addReceiverDepartmentName(document, "فرع الأمن");
            addTableDetails(document);

            document.write(out);
            out.close();

        } catch (Exception ex) {
            Logger.getLogger(DevicesUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addHeaderTitles(XWPFDocument doc) {

        XWPFParagraph paragraph = doc.createParagraph();
        changeParagraphDirectionToRight(paragraph);
        XWPFRun run = paragraph.createRun();
//        run.setLang("ar");
        run.setFontSize(11);
        run.setBold(false);
        run.setItalic(false);
//        run.setFontFamily("New Roman");

        run.setText("كلية الضباط الإحتياط");
        run.addBreak();

        run.setText("فرع نظم المعلومات");
        run.addBreak();

        run.setText("11/11/2022");
        run.addBreak();

    }

    private void addReportTitle(XWPFDocument document) {
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        changeParagraphDirectionToRight(paragraph);

        XWPFRun run = paragraph.createRun();

//            System.out.println("Lang => "+run.getLang());
        run.setLang("ar");

        run.setFontSize(20);
        run.setBold(true);
        run.setUnderline(UnderlinePatterns.SINGLE);
        run.setItalic(false);
        run.setFontFamily("New Roman");
        run.setText("إيصال استلام عهدة من فرع النظم");
        paragraph.addRun(run);
    }

    private void addReceiverDepartmentName(XWPFDocument document, String depName) {
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        changeParagraphDirectionToRight(paragraph);

        XWPFRun run = paragraph.createRun();

//            System.out.println("Lang => "+run.getLang());
        run.setLang("ar");

        run.setFontSize(11);
        run.setBold(true);
//        run.setUnderline(UnderlinePatterns.SINGLE);
        run.setItalic(false);
        run.setFontFamily("New Roman");
        run.setText("إلي : " + depName);
        paragraph.addRun(run);
    }

    private void addTableDetails(XWPFDocument document) {
        final String ROW_COLOR = "dddddd";
        XWPFTable table = document.createTable();

        XWPFTableRow headers = table.getRow(0);

        headers.setRepeatHeader(true);
        XWPFTableCell nameCell = headers.getCell(0);
        nameCell.setText("ملاحظات");
        nameCell.setColor(ROW_COLOR);

        XWPFTableCell cellHeader = headers.addNewTableCell();

        cellHeader.setColor(ROW_COLOR);
        cellHeader.setText("الكمية");

        XWPFTableCell cellHeader2 = headers.addNewTableCell();
        cellHeader2.setColor(ROW_COLOR);
        cellHeader2.setText("السيريال رقم");

        XWPFTableCell cellHeader3 = headers.addNewTableCell();
        cellHeader3.setColor(ROW_COLOR);
        cellHeader3.setText("الصنف اسم");

    }

    private void changeParagraphDirectionToRight(XWPFParagraph paragraph) {
        CTP ctp = paragraph.getCTP();
        CTPPr pPr;
        if ((pPr = ctp.getPPr()) == null) {
            pPr = ctp.addNewPPr();
        }

        pPr.addNewBidi().setVal(STOnOff1.ON);
    }

    private void createPDF() {
        try {
            Document doc = new Document();
            PdfWriter pdfWriter = PdfWriter.getInstance(doc, new FileOutputStream("test.pdf"));
            PdfPTable pdfTable = new PdfPTable(5);
            Paragraph docTitle = new Paragraph("أيصال استلام عهدة من فرع النظم");
            docTitle.setAlignment(Paragraph.ALIGN_CENTER);

            doc.open();
            doc.add(docTitle);
            pdfTable.addCell("م");
            pdfTable.addCell("Name");
            pdfTable.addCell("الكمية");
            pdfTable.addCell("السيريال");
            pdfTable.addCell("ملاحظات");
            pdfTable.completeRow();
            pdfTable.addCell("1");
            pdfTable.addCell("CPU Core I5 Dell");
            pdfTable.addCell("1");
            pdfTable.addCell("ABC123");
            pdfTable.addCell("--");
            doc.add(pdfTable);
            doc.close();
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(DevicesUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
