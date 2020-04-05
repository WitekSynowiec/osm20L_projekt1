package com.company.gui.app_model;

import java.util.ArrayList;

public class PatientRegister {
    private ArrayList<PatientRecord> patientDatabase = new ArrayList<>();

    public void add(PatientRecord record)
    {
        patientDatabase.add(record);
    }
    public void remove(int i)
    {
        patientDatabase.remove(i);
    }

    public void insert(int i, PatientRecord record)
    {
        patientDatabase.set(i, record);
    }

    public boolean contains(PatientRecord record)
    {
        return patientDatabase.contains(record);
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
    public boolean isEmpty()
    {
        return patientDatabase.isEmpty();
    }

}
