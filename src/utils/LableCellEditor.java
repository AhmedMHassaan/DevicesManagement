/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author pc
 */
public class LableCellEditor extends DefaultCellEditor {

    protected JLabel lbl;
    private String text;

    public LableCellEditor() {
        super(new JCheckBox());

        lbl = new JLabel();
        lbl.setOpaque(true);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (isSelected) {
            lbl.setForeground(Color.BLACK);
            lbl.setBackground(Color.BLUE);
        } else {
            lbl.setForeground(table.getForeground());
            lbl.setBackground(table.getBackground());
        }
        text = (value == null) ? "" : value.toString();
        lbl.setText(text);
//        isPushed = true;
        return lbl;
    }

    @Override
    public Object getCellEditorValue() {
//        if (isPushed) {
        // 
        // 
        JOptionPane.showMessageDialog(lbl, text + ": Ouch!");
        // System.out.println(label + ": Ouch!");
//        }
//        isPushed = false;
        return new String(text);
    }

    @Override
    public boolean stopCellEditing() {
//        isPushed = false;
        return super.stopCellEditing();
    }

    /**
     *
     */
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }

}
