package com.company.data_model;

public class PatientRecord {
    String name;
    String surname;
    long pesel;
    Sex sex;
    Insurance ins;
    boolean examination;

    public PatientRecord(String _name, String _surname, long _pesel, Sex _sex, Insurance _ins, boolean _examination){
        name = _name;
        surname = _surname;
        pesel = _pesel;
        sex = _sex;
        ins = _ins;
        examination = _examination;
    }

}
