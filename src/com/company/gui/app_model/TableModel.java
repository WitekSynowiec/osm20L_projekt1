package com.company.gui.app_model;

import javax.swing.table.AbstractTableModel;

import com.company.Main;
import com.company.gui.app_model.*;

import java.awt.*;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel {

    private String[] colNames = {"Imię i nazwisko", "Płeć", "Pesel","Ubezpieczenie", "Badanie"};
    private Object[] data = null;
    private Class[] colTypes = {String.class, Sex.class, Long.class, Insurance.class,Examination.class};
    private Color gridColor = null;

    public TableModel(){
        super();

    }
    public void getPatientRegister(){
//        return Main.getRegister();
    }



    @Override
    public int getRowCount(){
        return PatientRegister.getRowCount();
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
