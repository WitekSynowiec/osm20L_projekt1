package com.company.gui.app_model;

import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PatientRegister extends AbstractTableModel {
    private ArrayList<PatientRecord> patientDatabase;
    private String[] colNames = {"Imię i nazwisko", "Płeć", "Pesel","Ubezpieczenie", "Badanie"};
    private Class[] colTypes = {String.class, Sex.class, Long.class, Insurance.class,Examination.class};
    private Color gridColor = null;
    public void add(PatientRecord record)
    {
        patientDatabase.add(record);
    }
    public ArrayList<PatientRecord> get(){
        return patientDatabase;
    }
    public PatientRegister(){
        super();
    }

    @Override
    public int getRowCount(){
//        return getPatientRegister().getRowCount();
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
