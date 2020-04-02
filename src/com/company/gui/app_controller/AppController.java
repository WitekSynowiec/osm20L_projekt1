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

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == mView.getPDPanel().getSpdButton())
        {
            if (validatePD()) {
                mView.getPDPanel().setTextGetNameTextField(capitalize(mView.getPDPanel().getTextGetNameTextField()));
                mView.getPDPanel().setTextGetSurnameTextField(capitalize(mView.getPDPanel().getTextGetSurnameTextField()));
                mView.getTPanel().getTableModel().addRow(new PatientRecord(mView.getPDPanel().getTextGetNameTextField(), mView.getPDPanel().getTextGetSurnameTextField(), mView.getPDPanel().getTextGetPeselTextField(), mView.getPDPanel().getGetSex(), mView.getPDPanel().getGetInsurance()));
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
        return !mView.getPDPanel().getTextGetNameTextField().isEmpty() && !mView.getPDPanel().getTextGetSurnameTextField().isEmpty() && !mView.getPDPanel().getTextGetPeselTextField().toString().isEmpty() && (mView.getPDPanel().getGetManRadioButton().isSelected() || mView.getPDPanel().getGetWomanRadioButton().isSelected()) && !mView.getPDPanel().getGetInsurance().getIns().equals("");
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

    @Override
    public void valueChanged(ListSelectionEvent e) {
//        System.out.println(mView.getTPanel().getTable().getSelectedRow());
//        if (e.getSource() == mView.getTPanel().getTable().getSelectionModel() && mView.getTPanel().getTable().getRowSelectionAllowed()) {
//            int first = e.getFirstIndex();
//            int last = e.getLastIndex();
//        } else if (e.getSource() == mView.getTPanel().getTable().getColumnModel().getSelectionModel()
//                && mView.getTPanel().getTable().getColumnSelectionAllowed()) {
//            int first = e.getFirstIndex();
//            int last = e.getLastIndex();
//        }
//        if (e.getValueIsAdjusting()) {
//            System.out.println("The mouse button has not yet been released");
//        }
//        mView.getPDPanel().getGetNameTextField().setText(pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).getName());
//        mView.getPDPanel().getGetSurnameTextField().setText(pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).getSurname());
//        mView.getPDPanel().getGetPeselTextField().setText(pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).getPesel().toString());
//        mView.getPDPanel().getGetWomanRadioButton().setSelected(pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).getSex().equals(Sex.K));
//        mView.getPDPanel().getGetManRadioButton().setSelected(pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).getSex().equals(Sex.M));
//        mView.getPDPanel().getGetInsurance().setIns(pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).getIns());
    }
}
