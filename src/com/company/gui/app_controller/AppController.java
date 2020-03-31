package com.company.gui.app_controller;

import com.company.gui.app_model.Insurance;
import com.company.gui.app_model.PatientRegister;
import com.company.gui.app_model.Sex;
import com.company.gui.app_view.AppView;
import com.company.gui.interfaces.ModelListener;
import com.company.gui.interfaces.ViewListener;
import com.company.gui.app_view.PDPanel;


public class AppController implements ViewListener, ModelListener {
    private AppView mView = null;
    private PatientRegister	pRegister=null;
    public AppController (AppView appView, PatientRegister patientRegister){
        this.mView = appView;
        this.pRegister = patientRegister;

    }

    @Override
    public void modelChanged(PatientRegister m) {

    }


    @Override
    public void savePD() {

    }

    @Override
    public void clearPD(PDPanel m) {
        m.clearGetNameTextField();
        m.clearGetSurnameTextField();
        m.clearGetPeselTextField();
        m.clearGetInsurance();
        m.clearManWomanRadioButtons();
    }
}
