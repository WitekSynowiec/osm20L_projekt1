package com.company;

import com.company.gui.app_model.PatientRegister;

public class Main {
    private static PatientRegister register;
    public static void main(String[] args) {
        PatientRegister register = new PatientRegister();
        com.company.gui.app_view.AppView app = new com.company.gui.app_view.AppView();
        app.setVisible(true);
    }

    public static void addRecord(){
//        register.
    }
    public static PatientRegister getRegister(){
        return register;
    }
}
