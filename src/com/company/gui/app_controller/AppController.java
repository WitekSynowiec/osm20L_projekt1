package com.company.gui.app_controller;

import com.company.gui.app_model.PatientRegister;
import com.company.gui.app_view.AppView;
import com.company.gui.interfaces.ModelListener;
import com.company.gui.interfaces.ViewListener;

import java.awt.event.ActionEvent;

public class AppController implements ViewListener, ModelListener {
    private AppView mView;


    @Override
    public void modelChanged(PatientRegister m) {

    }

    @Override
    public void setValue(int value) {

    }

}
