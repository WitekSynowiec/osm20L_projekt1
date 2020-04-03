package com.company.gui.app_controller;

import com.company.gui.app_model.PatientRecord;
import com.company.gui.app_model.PatientRegister;
import com.company.gui.app_view.AppView;
import com.company.Main;
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
        Object source = e.getSource();
        if (source == mView.getPDPanel().getCpdButton())
        {
            mView.getPDPanel().clearManWomanRadioButtons();
            mView.getPDPanel().clearGetInsurance();
            mView.getPDPanel().clearGetPeselTextField();
            mView.getPDPanel().clearGetSurnameTextField();
            mView.getPDPanel().clearGetNameTextField();
            mView.getPDPanel().clearGetPeselTextField();
        }
        if (source == mView.getPDPanel().getSpdButton())
        {
            PatientRegister.add(new PatientRecord(mView.getPDPanel().getGetNameTextField(),mView.getPDPanel().getGetSurnameTextField(),mView.getPDPanel().getGetPeselTextField(), mView.getPDPanel().getGetSex(), mView.getPDPanel().getGetInsurance()));



        }
        if (source == mView.getPDPanel().getGetManRadioButton())
        {
            mView.getPDPanel().setGetManRadioButton();
        }
        if (source == mView.getPDPanel().getGetWomanRadioButton())
        {
            mView.getPDPanel().setGetWomanRadioButton();
        }

    }
}
