package com.company.gui.app_controller;

import com.company.gui.app_model.*;
import com.company.gui.app_view.AppView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppController implements ActionListener, ListSelectionListener, TableModelListener {
    private AppView mView;
    private PatientRegister	pRegister;

    private boolean validatePD(){

        if(!pRegister.validate(
                mView.getPDPanel().getTextGetNameTextField(),
                mView.getPDPanel().getTextGetSurnameTextField(),
                mView.getPDPanel().getTextGetPeselTextField(),
                mView.getPDPanel().getGetManRadioButton(),
                mView.getPDPanel().getGetWomanRadioButton(),
                mView.getPDPanel().getGetInsurance().getIns())){
            System.out.println("Walidacja nie udana");
            return false;
        }
        System.out.println("Walidacja udana");
        return true;
    }
    private boolean validateE(){

        if(!pRegister.validateExam(
                mView.getEPanel().getAmylaseTextField(),
                mView.getEPanel().getGlucoseTextField(),
                mView.getEPanel().getPhosphateTextField(),
                mView.getEPanel().getDateChooser().getDate())){
            System.out.println("Walidacja nie udana");
            return false;
        }
        System.out.println("Walidacja udana");
        return true;
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
    public void actionPerformed(ActionEvent e) {
        int selectedRow = mView.getTPanel().getTable().getSelectedRow();
        TableModel model = mView.getTPanel().getTableModel();
        Object source = e.getSource();

        if (source == mView.getPDPanel().getSpdButton())
        {
            if (validatePD()) {
                pRegister.add(new PatientRecord(mView.getPDPanel().getTextGetNameTextField(), mView.getPDPanel().getTextGetSurnameTextField(), mView.getPDPanel().getTextGetPeselTextField(), mView.getPDPanel().getGetSex(), mView.getPDPanel().getGetInsurance()));
                model.fireTableRowsUpdated(0,model.getRowCount()-1);
                mView.getPDPanel().clearAllFields();
                mView.getPDPanel().enableChange(false);
                mView.getEPanel().enableChange(false);
            }
            mView.getTPanel().getTable().getSelectionModel().removeListSelectionListener(this);
            mView.getTPanel().getTable().clearSelection();
            mView.getTPanel().getTable().getSelectionModel().addListSelectionListener(this);
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

        if (source == mView.getTPanel().getDelButton()){
            if (!pRegister.isEmpty())
            {
                model.fireTableRowsUpdated(0,model.getRowCount()-1);
                pRegister.remove(selectedRow);
            }
            mView.getPDPanel().clearAllFields();
        }

        if (source == mView.getEPanel().getSeButton())
        {
            if(validateE()){
                pRegister.getRecord(selectedRow).setExamination(new Examination(mView.getEPanel().getFloatGlucoseTextField(),mView.getEPanel().getFloatAmylaseTextField(),mView.getEPanel().getFloatPhosphateTextField(),mView.getEPanel().getDateChooser().getDate()));
                model.fireTableRowsUpdated(0,model.getRowCount()-1);
                mView.getEPanel().clearAllFields();
                mView.getPDPanel().clearAllFields();
                mView.getEPanel().enableChange(false);
                mView.getPDPanel().enableChange(false);
            }
            try {
                mView.getTPanel().getTable().clearSelection();
            }
            catch(Exception x){
                System.out.println("Ominieto bląd");
            }

        }

        if (source == mView.getEPanel().getCeButton())
        {
            mView.getEPanel().clearAllFields();
        }

        if (source == mView.getTPanel().getAddButton())
        {
            mView.getPDPanel().clearAllFields();
            mView.getEPanel().clearAllFields();
            mView.getPDPanel().enableChange(true);
            mView.getEPanel().enableChange(true);
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        mView.getPDPanel().enableChange(true);
        mView.getPDPanel().setTextGetNameTextField(pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).getName());
        mView.getPDPanel().setTextGetSurnameTextField(pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).getSurname());
        mView.getPDPanel().setTextGetPeselTextField(pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).getPesel());
        mView.getPDPanel().setGetInsurance(pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).getIns());
        mView.getPDPanel().setSexRadioButton(pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).getSex());
        mView.getEPanel().enableChange(true);
        if (pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).isExamined())
        {
            mView.getEPanel().setPhosphateTextField(pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).getExamination().getPhosphateConcentration().toString());
            mView.getEPanel().setAmylaseTextField(pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).getExamination().getAmylaseConcentration().toString());
            mView.getEPanel().setGlucoseTextField(pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).getExamination().getGlucoseConcentration().toString());
            mView.getEPanel().setDateChooser(pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).getExamination().getExaminationDate());
        }
        else
        mView.getEPanel().clearAllFields();

    }

    @Override
    public void tableChanged(TableModelEvent e) {
        mView.getTPanel().getTableModel().insertData(pRegister);

    }

    public AppController (AppView appView, PatientRegister patientRegister){
        this.mView = appView;
        this.pRegister = patientRegister;
        mView.getPDPanel().enableChange(false);
        mView.getEPanel().enableChange(false);
        mView.getTPanel().getTable().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
