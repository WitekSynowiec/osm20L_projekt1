package com.company.gui.app_model;

public class FullName extends Pair {
    public FullName(String a, String b) {
        super(a,b);
        value1 = capitalize(a);
        value2 = capitalize(b);
    }
    public StringBuilder getFullName(){
        StringBuilder str = new StringBuilder();
        str.append(getValue1());
        str.append(" ");
        str.append(getValue2());
        return str;
    }
    private String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
