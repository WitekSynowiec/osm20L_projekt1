package com.company.gui.app_controller;

import com.company.gui.app_model.Insurance;
import com.company.gui.app_model.PatientRegister;
import com.company.gui.app_model.Sex;
import com.company.gui.app_view.AppView;
import com.company.gui.app_view.PDPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AppController implements ActionListener {
    private AppView mView = null;
    private PatientRegister	pRegister=null;
    public AppController (AppView appView, PatientRegister patientRegister){
        this.mView = appView;
        this.pRegister = patientRegister;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
