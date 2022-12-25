/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class AdvancedTable extends JTable {

    public AdvancedTable() {
        super();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        centerRenderer.setHorizontalTextPosition(JLabel.CENTER);

        setDefaultRenderer(Object.class, centerRenderer);

    }

    public void clearTable() {

        ((DefaultTableModel) getModel()).setNumRows(0);
        ((DefaultTableModel) getModel()).setRowCount(0);
//        removeAll();
    }

    public DefaultTableModel getMutableModel() {
        return (DefaultTableModel) getModel();
    }

    public String getSelectedCell() {
        try {
            int rowIndex = getSelectedRow();
            int colIndex = getSelectedColumn();
            return getValueAt(rowIndex, colIndex).toString();
        } catch (Exception e) {

        }
        return null;
    }

}
