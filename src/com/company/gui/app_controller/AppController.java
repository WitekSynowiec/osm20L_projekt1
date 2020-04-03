package com.company.gui.app_controller;

import com.company.gui.app_model.*;
import com.company.gui.app_view.AppView;
import com.company.Main;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AppController implements ActionListener, ListSelectionListener {
    private AppView mView;
    private PatientRegister	pRegister;

    public AppController (AppView appView, PatientRegister patientRegister){
        this.mView = appView;
        this.pRegister = patientRegister;
        mView.getPDPanel().enableChange(false);
        mView.getTPanel().getTable().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        System.out.println(mView.getTPanel().getTableModel().getRowCount());
        if (source == mView.getPDPanel().getSpdButton())
        {
            if (validatePD()) {
                mView.getTPanel().getTable().clearSelection();
                mView.getTPanel().getTableModel().addRow(new PatientRecord(mView.getPDPanel().getTextGetNameTextField(), mView.getPDPanel().getTextGetSurnameTextField(), mView.getPDPanel().getTextGetPeselTextField(), mView.getPDPanel().getGetSex(), mView.getPDPanel().getGetInsurance()));
                mView.getPDPanel().clearAllFields();
                mView.getPDPanel().enableChange(false);
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

        if (source == mView.getTPanel().getAddButton())
        {
            mView.getTPanel().getTable().clearSelection();
            mView.getPDPanel().clearAllFields();
            mView.getPDPanel().enableChange(true);
        }

    }

    private boolean validatePD(){
        return !mView.getPDPanel().getTextGetNameTextField().isEmpty() && !mView.getPDPanel().getTextGetSurnameTextField().isEmpty() && !mView.getPDPanel().getTextGetPeselTextField().toString().isEmpty() && (mView.getPDPanel().getGetManRadioButton().isSelected() || mView.getPDPanel().getGetWomanRadioButton().isSelected()) && !mView.getPDPanel().getGetInsurance().getIns().equals("") && mView.getPDPanel().getTextGetPeselTextField()<99999999999L&&mView.getPDPanel().getTextGetPeselTextField()>10000000000L;
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




    @Override
    public void valueChanged(ListSelectionEvent e) {
        mView.getPDPanel().enableChange(true);
        mView.getPDPanel().setTextGetNameTextField(pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).getName());
        mView.getPDPanel().setTextGetSurnameTextField(pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).getSurname());
        mView.getPDPanel().setTextGetPeselTextField(pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).getPesel());
        mView.getPDPanel().setGetInsurance(pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).getIns());
        mView.getPDPanel().setSexRadioButton(pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).getSex());
    }
}
