package com.admin.controler;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class JTableDataSource implements JRDataSource {

    private final TableModel tableModel;
    private int rowIndex = -1;

    public JTableDataSource(JTable table) {
        this.tableModel = table.getModel();
    }

    @Override
    public boolean next() throws JRException {
        rowIndex++;
        return rowIndex < tableModel.getRowCount();
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        String fieldName = jrField.getName();
        int columnIndex = -1;
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            if (tableModel.getColumnName(i).equalsIgnoreCase(fieldName)) {
                columnIndex = i;
                break;
            }
        }
        if (columnIndex == -1) {
            throw new JRException("Field not found: " + fieldName);
        }
        return tableModel.getValueAt(rowIndex, columnIndex);
    }
}