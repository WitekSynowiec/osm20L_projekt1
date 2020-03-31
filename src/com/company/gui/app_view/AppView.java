package com.company.gui.app_view;

import com.company.gui.app_controller.AppController;
import com.company.gui.app_model.Examination;
import com.company.gui.app_model.PatientRecord;
import com.company.gui.app_model.PatientRegister;
//import com.company.gui.interfaces.ModelListener;
//import com.company.gui.interfaces.ViewListener;
//import com.company.gui.interfaces.AppViewInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppView extends JFrame {
    private PDPanel patientDataPanel;
    private EPanel examinationPanel;
    private TablePanel tablePanel;
    private PatientRegister patientRegister;


    public AppView(){
        this.doGui();
        AppController ctrl = new AppController(this, patientRegister);
        setListeners(ctrl);
    }

    private void doGui()
    {
        getContentPane().setBackground(Color.lightGray);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        patientDataPanel = new PDPanel();
        examinationPanel = new EPanel();
        tablePanel = new TablePanel();
        patientRegister =  new PatientRegister();

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(patientDataPanel,c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        this.add(examinationPanel, c);

        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 5;
        c.gridheight = 2;
        this.add(tablePanel,c);
        pack();

        this.setVisible(true);
        this.setResizable(false);
    }


    public void setListeners(AppController ctrl)
    {
        patientDataPanel.getCpdButton().addActionListener(ctrl);
        patientDataPanel.getSpdButton().addActionListener(ctrl);
        patientDataPanel.getGetManRadioButton().addActionListener(ctrl);
        patientDataPanel.getGetWomanRadioButton().addActionListener(ctrl);
        examinationPanel.getSpdButton().addActionListener(ctrl);
        examinationPanel.getCpdButton().addActionListener(ctrl);
        tablePanel.getAddButton().addActionListener(ctrl);
        tablePanel.getDelButton().addActionListener(ctrl);
    }

    public PDPanel getPDPanel(){
        return patientDataPanel;
    }
    public EPanel getEPanel(){
        return examinationPanel;
    }
    public TablePanel getTPanel(){
        return tablePanel;
    }
//    public static PatientRegister getPatientRegister(){
//        return patientRegister;
//    }
}
