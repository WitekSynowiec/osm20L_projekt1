package com.company.data_model;

public class Pair {
    private String value1;
    private String value2;
    public Pair(String a, String b){
        value1 = a;
        value2 = b;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }
}
