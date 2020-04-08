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

    /**Metoda <code>contains(PatientRecord record)</code>
     * zwraca true jeśli rejestr zawiera podany na wejściu rekord pacjenta. Zgodnie z metodą
     * <code>equals()</code> klasy <code>PatientRecord</code> równość zachodzi gdy numery pesel
     * są równe.*/
    public boolean contains(PatientRecord record) {
        for(int i=0;i<getSize();i++){
            if(record.equals(getRecord(i))){
                return true;
            }
        }
        return false;
    }

    /** Metoda prywatna <code>validateString(String str)</code>  sprawdza czy dany ciąg znaków
     * zawiera wyłącznie litery. Jeśli zawiera tylko litery zwraca true. False zwraca w p.p.*/
    private boolean validateString(String str) {
        str = str.toLowerCase();
        char[] charArray = str.toCharArray();
        for (char ch : charArray) {
            if (!(ch >= 'a' && ch <= 'z')) {
                return false;
            }
        }
        return true;
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
