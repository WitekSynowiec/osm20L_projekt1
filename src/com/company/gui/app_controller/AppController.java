package com.company.gui.app_controller;

import com.company.gui.app_model.*;
import com.company.gui.app_view.AppView;
import com.company.Main;

import javax.swing.*;
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
        if (source == mView.getPDPanel().getSpdButton())
        {
            if (validatePD()) {
                mView.getPDPanel().setGetNameTextField(capitalize(mView.getPDPanel().getGetNameTextField()));
                mView.getPDPanel().setGetSurnameTextField(capitalize(mView.getPDPanel().getGetSurnameTextField()));
                mView.getTPanel().getTableModel().addRow(new PatientRecord(mView.getPDPanel().getGetNameTextField(), mView.getPDPanel().getGetSurnameTextField(), mView.getPDPanel().getGetPeselTextField(), mView.getPDPanel().getGetSex(), mView.getPDPanel().getGetInsurance()));
                mView.getPDPanel().clearAllFields();
            }
        }
        if (source == mView.getPDPanel().getCpdButton())
        {
            mView.getPDPanel().clearAllFields();
        }
        if (source == mView.getPDPanel().getGetManRadioButton())
        {
            mView.getPDPanel().setGetManRadioButton();
        }
        if (source == mView.getPDPanel().getGetWomanRadioButton())
        {
            mView.getPDPanel().setGetWomanRadioButton();
        }

        if (source == mView.getEPanel().getCpdButton())
        {
            mView.getEPanel().clearAllFields();
        }

        if (source == mView.getTPanel().getDelButton()){
            mView.getTPanel().getTableModel().removeRow(mView.getTPanel().getTable().getSelectedRow());
        }

    }

    private boolean validatePD(){
        return !mView.getPDPanel().getGetNameTextField().isEmpty() && !mView.getPDPanel().getGetSurnameTextField().isEmpty() && !mView.getPDPanel().getGetPeselTextField().toString().isEmpty() && (mView.getPDPanel().getGetManRadioButton().isSelected() || mView.getPDPanel().getGetWomanRadioButton().isSelected()) && !mView.getPDPanel().getGetInsurance().getIns().equals("");
    }


    private boolean validateString(String str) {
        str = str.toLowerCase();
        char[] charArray = str.toCharArray();
        for (char ch : charArray) {
            if (!(ch >= 'a' && ch <= 'z')) {
                return false;
            }
        }
        return true;
    }

    private String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
