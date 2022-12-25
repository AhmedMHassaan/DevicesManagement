/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author pc
 */
public class CustomTableRenderer extends DefaultTableCellRenderer {

    /*private final boolean isZeroValue;
    
    public CustomTableRenderer(boolean isZero) {
    this.isZeroValue = isZero;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    
    Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    //        cell.setBackground(backgroundColor);
    //        cell.setForeground(foregroundColor);
    //        return cell;
    if (isZeroValue) {
    cell.setForeground(Color.BLACK);
    cell.setBackground(Color.BLACK);
    //            System.out.println("Is Zero Value");
    //            setBackground(table.getSelectionBackground());
    } else {
    //            setForeground(table.getForeground());
    cell.setForeground(Color.BLUE);
    cell.setBackground(Color.BLUE);
    System.out.println("Is Value Blue ");
    //            setBackground(UIManager.getColor("Button.background"));
    }
    //        setText((value == null) ? "" : value.toString());
    return cell;
    }*/
    @Override
    public Color getBackground() {
        return super.getBackground();
    }

}
