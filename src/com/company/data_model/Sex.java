package com.company.data_model;

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
}
