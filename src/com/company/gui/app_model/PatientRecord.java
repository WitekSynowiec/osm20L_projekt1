package com.company.gui.app_model;

public class PatientRecord {
    private FullName fullName;
    private long pesel;
    private Sex sex;
    private Insurance ins;
    private Examination examination;

    public PatientRecord(String _name, String _surname, long _pesel, Sex _sex, Insurance _ins){
        this.fullName = new FullName(_name,_surname);
        pesel = _pesel;
        sex = _sex;
        ins = _ins;
        examination = null;
    }

    public String getName() {
        return fullName.getValue1();
    }

    public void setName(String name) {
        this.fullName.setValue1(name);
    }

    public String getSurname() {
        return fullName.getValue2();
    }

    public void setSurname(String surname) {
        this.fullName.setValue2(surname);
    }

    public StringBuilder getFullName(){
        return fullName.getFullName();
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getIns() {
        return ins.getIns();
    }

    public void setIns(Insurance ins) {
        this.ins = ins;
    }

    public Examination getExamination() {
        return examination;
    }

    public void setExamination(Examination examination) {
        this.examination = examination;
    }
}
