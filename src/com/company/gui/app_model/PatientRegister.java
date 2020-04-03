package com.company.gui.app_model;

import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PatientRegister {
    private ArrayList<PatientRecord> patientDatabase = new ArrayList<>();
    private String[] colNames = {"Imię i nazwisko", "Płeć", "Pesel","Ubezpieczenie", "Badanie"};
    private Class[] colTypes = {String.class, Sex.class, Long.class, Insurance.class,Examination.class};
    private Color gridColor = null;



    public void add(PatientRecord record)
    {
        patientDatabase.add(record);
    }
    public void remove(int i)
    {
        patientDatabase.remove(i);
    }
    public ArrayList<PatientRecord> get(){
        return patientDatabase;
    }
    public PatientRegister(){
        super();
    }

    public PatientRecord getRecord(int i){
        return patientDatabase.get(i);
    }

    public int getSize(){
        return patientDatabase.size();
    }


}
