package com.company.gui.app_model;

import javax.swing.*;
import java.util.ArrayList;

/** Klasa {@code PatientRegister} odpowiada za przechowanie i obsługę
 * bazy danych pacjentów. Posiada jeden parametr <code>ArrayList</code>,
 * przechowujące rekordy pacjentów. Tą klasę można zastąpić w aplikacji prostą bazą
 * danych.
 * @author Janek Grzegorek
 * @author Witek Synowiec
 * */
public class PatientRegister {
    private ArrayList<PatientRecord> patientDatabase = new ArrayList<>();

    public PatientRegister(){
        super();
    }

    /**Metoda <code>add(PatientRecord record)</code> dodaje do rejestru element
     * klasy <code>PatientRecord</code> na koniec listy.*/
    public void add(PatientRecord record)
    {
        patientDatabase.add(record);
    }

    /**Metoda <code>remove(int i)</code> usuwa z rejestru i-ty element.*/
    public void remove(int i)
    {
        patientDatabase.remove(i);
    }

    /**Metoda <code>ValidateExam(String amylaza, String glukoza, String phosfo, java.util.Date date)</code>
     * zwraca true jeśli wpisane przez użytkownika dane badania są poprawne.*/
    public boolean validateExam(String amylaza, String glukoza, String phosfo, java.util.Date date){
        if(date==null){
//            System.out.println("Data - pusto");
            return false;
        }
        if(amylaza.equals("")){
//            System.out.println("Amylase - pusto");
            return false;
        }
        if(glukoza.equals("")){
//            System.out.println("Glucose - pusto");
            return false;
        }
        if(phosfo.equals("")){
//            System.out.println("Phosphate - pusto");
            return false;
        }
        for(char c : amylaza.toCharArray()){
            if(!(Character.isDigit(c) || c=='.')){
//                System.out.println("Amylase - Nie wszystkie znaki są cyframi");
                return false;
            }
        }
        for(char c : glukoza.toCharArray()){
            if(!(Character.isDigit(c) || c=='.')){
//                System.out.println("Glucose - Nie wszystkie znaki są cyframi");
                return false;
            }
        }
        for(char c : phosfo.toCharArray()){
            if(!(Character.isDigit(c) || c=='.')){
//                System.out.println("Phosphate - Nie wszystkie znaki są cyframi");
                return false;
            }
        }
        return true;
    }

    /**Metoda <code>contains(PatientRecord record)</code>
     * zwraca true jeśli rejestr zawiera podany na wejściu rekord pacjenta. Zgodnie z metodą
     * <code>equals()</code> klasy <code>PatientRecord</code> równość zachodzi gdy numery pesel
     * są równe.*/
    public boolean contains(PatientRecord record) {
        return patientDatabase.contains(record);
    }

    /**Metoda <code>containsPesel(String pesel, String srpesel)</code>
     * zwraca true jeśli rejestr zawiera podany na wejściu rekord pacjenta.*/
    public boolean containsPesel(String pesel, String srpesel){
        for(int i=0;i<getSize();i++){
            if(pesel.equals(getRecord(i).getPesel())){
                if(pesel.equals(srpesel)){
                    continue;
                }
//                System.out.println("Jest już w bazie pacjent o takim peselu");
                return true;
            }
        }
        return false;
    }

    /**Metoda
     * <code>validatePD(String name, String surname, String pesel, JRadioButton sexm, JRadioButton sexw, String ins, String srpesel)</code>
     * zwraca true jeśli wpisane przez użytkownika dane użytkownika są poprawne.*/
    public boolean validatePD(String name, String surname, String pesel, JRadioButton sexm, JRadioButton sexw, String ins, String srpesel){
        if (containsPesel(pesel,srpesel)){
//            System.out.println("Podany pesel juz istnieje");
            return false;
        }
        if(name.isEmpty()){
//            System.out.println("Nie wpisano imienia");
            return false;
        }
        if(surname.isEmpty()){
//            System.out.println("Nie wpisano nazwiska");
            return false;
        }
        if(pesel.isEmpty()){
//            System.out.println("Nie wpisano peselu");
            return false;
        }
        if(!sexm.isSelected() && !sexw.isSelected()){
//            System.out.println("Nie wybrano plci");
            return false;
        }
        if(ins.equals("")){
//            System.out.println("Nie wybrano ubezpieczenia");
            return false;
        }
        //            System.out.println("Nie poprawna liczba cyfr w peselu");
        return pesel.length() == 11;
    }

    /**Metoda <code>get()</code>
     * zwraca listę <code>patientDatabase</code>.*/
    public ArrayList<PatientRecord> get(){
        return patientDatabase;
    }

    /**Metoda <code>getRecord(int i)</code>
     * zwraca i-ty element listy <code>patientDatabase</code>.*/
    public PatientRecord getRecord(int i){
        return patientDatabase.get(i);
    }

    /**Metoda <code>getSize()</code>
     * zwraca wielkość listy <code>patientDatabase</code> liczoną
     * jako liczba elementów <code>patientDatabase</code> w liście.*/
    public int getSize(){
        return patientDatabase.size();
    }

    /**Metoda <code>isEmpty()</code>
     * zwraca true jeśli liczba elementów <code>patientDatabase</code>
     * w <code>patientDatabase</code> jest równa zeru, a false w p.p.*/
    public boolean isEmpty() {
        return patientDatabase.isEmpty();
    }

}
