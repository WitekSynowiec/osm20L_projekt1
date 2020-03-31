package com.company.gui.app_view;

import javax.swing.table.AbstractTableModel;

import com.company.gui.app_model.Sex;
import com.company.gui.app_model.Insurance;
import com.company.gui.app_model.Examination;

import java.awt.*;

public class TableModel extends AbstractTableModel{

    String[] colNames = {"Imię i nazwisko", "Płeć", "Pesel","Ubezpieczenie", "Badanie"};
    Class[] colTypes = {String.class, Sex.class, Long.class, Insurance.class,Examination.class};
    private Color gridColor = null;

    public TableModel(){
        super();
    }
    public void getPatientRegister(){
//        return Main.getRegister();
    }
    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 5;
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
