package com.company.gui.app_model;

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
}
