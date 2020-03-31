package com.company;

import com.company.gui.app_model.PatientRegister;

public class Main {
    public static void main(String[] args) {
        PatientRegister register = new PatientRegister();
        com.company.gui.app_view.AppView app = new com.company.gui.app_view.AppView();
        app.setVisible(true);
    }
}
