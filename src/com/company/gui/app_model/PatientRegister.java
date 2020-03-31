package com.company.gui.app_model;

import java.util.ArrayList;

public class PatientRegister {
    private ArrayList<PatientRecord> patientDatabase;
    public void add(PatientRecord record)
    {
        patientDatabase.add(record);
    }
    public ArrayList<PatientRecord> get(){
        return patientDatabase;
    }
    public int getRowCount(){
        return patientDatabase.size();
    }
}
