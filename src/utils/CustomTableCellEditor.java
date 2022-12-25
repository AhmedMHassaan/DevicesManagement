/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author pc
 */
public class CustomTableCellEditor extends DefaultCellEditor {

    protected JButton button;

    private String label;

    private boolean isPushed;

    private boolean isZeroValue;

    public CustomTableCellEditor(boolean isZeroValue) {
        super(new JComboBox());
        this.isZeroValue = isZeroValue;

        System.out.println("I am here in Con and value is "+isZeroValue);

//        button = new JButton();
//        button.setOpaque(true);
//        button.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                fireEditingStopped();
//            }
//        });
    }

    public CustomTableCellEditor() {
        super(new JComboBox());

        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        Component cell = super.getTableCellEditorComponent(table, value, isSelected, row, column);
//        cell.setBackground(backgroundColor);
//        cell.setForeground(foregroundColor);
//        return cell;
//        if (isZeroValue) {
        if (value == null) {
            cell.setForeground(Color.BLACK);
            cell.setBackground(Color.BLACK);
//            setBackground(table.getSelectionBackground());
        } else {
//            setForeground(table.getForeground());
            System.out.println("Is Blue Value");

            cell.setForeground(Color.BLUE);
            cell.setBackground(Color.BLUE);
//            setBackground(UIManager.getColor("Button.background"));
        }
//        setText((value == null) ? "" : value.toString());

        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
//        return button;
        return cell;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            // 
            // 
            JOptionPane.showMessageDialog(button, label + ": Ouch!");
            // System.out.println(label + ": Ouch!");
        }
        isPushed = false;
        return new String(label);
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }

}
