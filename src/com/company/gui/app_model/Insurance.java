package com.company.gui.app_model;


/** Typ enum {@code Insurance} odpowiada za przechowywanie rodzaju badania pacjenta.*/
public enum Insurance {
    NO_ANS(""),
    NFZ("NFZ"),
    PRIVATE("prywatnie"),
    LACK("brak");

    private String ins;
    Insurance (String getIns){
        this.ins = getIns;
    }
    public  String getIns(){
        return ins;
    }
    public void setIns(String ins) {
        this.ins = ins;
    }
}
