package com.company.gui.app_model;

public class FullName extends Pair {
    public FullName(String a, String b) {
        super(a, b);
    }
    public StringBuilder getFullName(){
        StringBuilder str = new StringBuilder();
        str.append(getValue1());
        str.append(" ");
        str.append(getValue2());
        return str;
    }
}
