package com.company.gui.app_model;

public class PatientRecord {
    private FullName fullName;
    private String pesel;
    private Sex sex;
    private Insurance ins;
    private Examination examination;

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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Insurance getIns() {
        return ins;
    }

    public void setIns(Insurance ins) {
        this.ins = ins;
    }

    public Examination getExamination() {
        return examination;
    }

    public Boolean isExamined(){
        if (examination == null)
            return Boolean.FALSE;
        else
            return Boolean.TRUE;
    }

    public void setExamination(Examination examination) {
        this.examination = examination;
    }

    public void set(PatientRecord record) {
        this.setName(record.getName());
        this.setSurname(record.getSurname());
        this.setPesel(record.getPesel());
        this.setSex(record.getSex());
        this.setIns(record.getIns());
        this.setExamination(record.getExamination());
    }

    public boolean equals(PatientRecord record){
        return record.getPesel()==pesel;
    }

    public PatientRecord(String _name, String _surname, String _pesel, Sex _sex, Insurance _ins){
        this.fullName = new FullName(_name,_surname);
        pesel = _pesel;
        sex = _sex;
        ins = _ins;
        examination = null;
    }
}
