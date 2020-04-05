package com.company.gui.app_model;

import javax.swing.*;
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

    public boolean validateExam(String amylaza, String glukoza, String phosfo, java.util.Date date){
        if(date==null){
            System.out.println("Data - pusto");
            return false;
        }
        if(amylaza.equals("")){
            System.out.println("Amylase - pusto");
            return false;
        }
        if(glukoza.equals("")){
            System.out.println("Glucose - pusto");
            return false;
        }
        if(phosfo.equals("")){
            System.out.println("Phosphate - pusto");
            return false;
        }
        for(char c : amylaza.toCharArray()){
            if(!(Character.isDigit(c) || c=='.')){
                System.out.println("Amylase - Nie wszystkie znaki są cyframi");
                return false;
            }
        }
        for(char c : glukoza.toCharArray()){
            if(!(Character.isDigit(c) || c=='.')){
                System.out.println("Glucose - Nie wszystkie znaki są cyframi");
                return false;
            }
        }
        for(char c : phosfo.toCharArray()){
            if(!(Character.isDigit(c) || c=='.')){
                System.out.println("Phosphate - Nie wszystkie znaki są cyframi");
                return false;
            }
        }
        return true;
    }

    public boolean contains(PatientRecord record)
    {
        return patientDatabase.contains(record);
    }

    public boolean containsPesel(String pesel, String srpesel){
        for(int i=0;i<getSize();i++){
            if(pesel.equals(getRecord(i).getPesel())){
                if(pesel.equals(srpesel)){
                    continue;
                }
                System.out.println("Jest już w bazie pacjent o takim peselu");
                return true;
            }
        }
        return false;
    }

    public boolean validate(String name, String surname, String pesel, JRadioButton sexm, JRadioButton sexw, String ins, String srpesel){
        if (containsPesel(pesel,srpesel)){
            System.out.println("Podany pesel juz istnieje");
            return false;
        }
        if(name.isEmpty()){
            System.out.println("Nie wpisano imienia");
            return false;
        }
        if(surname.isEmpty()){
            System.out.println("Nie wpisano nazwiska");
            return false;
        }
        if(pesel.isEmpty()){
            System.out.println("Nie wpisano peselu");
            return false;
        }
        if(!sexm.isSelected() && !sexw.isSelected()){
            System.out.println("Nie wybrano plci");
            return false;
        }
        if(ins.equals("")){
            System.out.println("Nie wybrano ubezpieczenia");
            return false;
        }
        if(!(pesel.length()==11)){
            System.out.println("Nie poprawna liczba cyfr w peselu");
            return false;
        }
        return true;
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
