package com.company.gui.app_model;

import java.util.ArrayList;

public class PatientRegister {
    private static ArrayList<PatientRecord> patientDatabase;
    static public void add(PatientRecord record)
    {
        patientDatabase.add(record);
    }
    static public ArrayList<PatientRecord> get(){
        return patientDatabase;
    }
    static public int getRowCount(){
        return patientDatabase.size();
    }
}
