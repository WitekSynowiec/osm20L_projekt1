package com.company.gui.app_model;

import javax.swing.table.AbstractTableModel;

import com.company.Main;
import com.company.gui.app_model.*;

import java.awt.*;
import com.company.gui.app_view.AppView;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel {

    private PatientRegister register;
    private String[] colNames = {"Imię i nazwisko", "Płeć", "Pesel","Ubezpieczenie", "Badanie"};
    private Class[] colTypes = {String.class, Sex.class, Long.class, Insurance.class,Examination.class};
    private Color gridColor = null;
    private int rowCount = 0;

    public TableModel(PatientRegister t){
        super();
        register = t;
    }

    public void addRow(PatientRecord do1) {
        register.add(do1);
        rowCount++;
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }
    @Override
    public int getRowCount(){

        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
    @Override
    public String getColumnName(int index) {
        return colNames[index];
    }
}
