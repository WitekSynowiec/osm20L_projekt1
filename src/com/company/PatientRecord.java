package com.company;

public class PatientRecord {
    public enum Sex_enum
    {
        M("M"),
        K("K");
        private String sex;
        Sex_enum (String getSex){
            this.sex = getSex;
        }
        public  String getSex(){
            return sex;
        }
    }
    public enum Insurance_enum
    {
        NO_ANS(""),
        NFZ("NFZ"),
        PRIVATE("prywatnie"),
        LACK("brak");

        private String ins;
        Insurance_enum (String getIns){
            this.ins = getIns;
        }
        public  String getIns(){
            return ins;
        }
    }

    String name;
    String surname;
    long pesel;
    Sex_enum sex;
    Insurance_enum ins;
    boolean examination;

    public PatientRecord(String _name, String _surname, long _pesel, Sex_enum _sex, Insurance_enum _ins, boolean _examination){
        name = _name;
        surname = _surname;
        pesel = _pesel;
        sex = _sex;
        ins = _ins;
        examination = _examination;
    }

}
