package com.company.gui.app_model;

public enum Sex {
    M("M"),
    K("K");
    private String sex;
    Sex (String getSex){
        this.sex = getSex;
    }
    public  String getSex(){
        return sex;
    }
    public boolean equals(Sex s){
        return sex.equals(s.getSex());
    }
}
