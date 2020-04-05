package com.company;

import com.company.gui.app_model.PatientRegister;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        PatientRegister register = new PatientRegister();
        com.company.gui.app_view.AppView app = new com.company.gui.app_view.AppView();
        app.setVisible(true);
    }
}
