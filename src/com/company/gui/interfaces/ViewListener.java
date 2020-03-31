package com.company.gui.interfaces;

import com.company.gui.app_model.PatientRegister;
import com.company.gui.app_view.PDPanel;

public interface ViewListener {
//    public void addListener(ViewListener listener);
    void savePD();
    void clearPD(PDPanel m);
//    public void viewChanged(AppView v, String c);
}
