package com.company.gui.app_model;

import javax.swing.event.TableModelListener;
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

    public TableModel(PatientRegister t){
        super();

        register = t;
    }

    public void addRow(PatientRecord do1) {
        register.add(do1);
        System.out.println("register.getSize(): "+register.getSize());
        System.out.println("getRowCount: "+getRowCount());

        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);

    }

    public void removeRow(int i){

        if (!register.isEmpty())
        {
            register.remove(i);
//            fireTableRowsDeleted(i,i);
        }



    }
    public TableModelListener addTableModelListener()
    {
        return addTableModelListener();
    }

    public void insertData(PatientRegister t)
    {
        register = t;
    }

    @Override
    public int getRowCount(){
        return register.getSize();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return register.getRecord(rowIndex).getFullName();
            case 1:
                return register.getRecord(rowIndex).getSex();
            case 2:
                return register.getRecord(rowIndex).getPesel();
            case 3:
                return register.getRecord(rowIndex).getIns().getIns();
            case 4:
                return register.getRecord(rowIndex).getExamination();
            default:
                return 0;
        }
    }
    @Override
    public String getColumnName(int index) {
        return colNames[index];
    }
}
