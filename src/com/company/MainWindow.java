package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {
    public static LeftPanel leftPanel;
    public static  RightPanel  rightPanel;
    public MainWindow(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(true);
        this.setSize(1024, 768);

        leftPanel = new LeftPanel(this);
        rightPanel = new RightPanel(this);

        this.setLayout(new BorderLayout());
        this.add(BorderLayout.EAST,rightPanel);
        this.add(BorderLayout.WEST,leftPanel);

        leftPanel.pdPanel.spdButton.addActionListener(this);
        leftPanel.pdPanel.cpdButton.addActionListener(this);
        leftPanel.ePanel.button1.addActionListener(this);
        leftPanel.ePanel.button2.addActionListener(this);
        leftPanel.ePanel.button3.addActionListener(this);
        leftPanel.pdPanel.getManRadioButton.addActionListener(this);
        leftPanel.pdPanel.getWomanRadioButton.addActionListener(this);
    }


    private void clear_pd_sheet() {
        leftPanel.pdPanel.getNameTextField.setText("");
        leftPanel.pdPanel.getSurnameTextField.setText("");
        leftPanel.pdPanel.getPeselTextField.setText("");
        leftPanel.pdPanel.getWomanRadioButton.setSelected(false);
        leftPanel.pdPanel.getManRadioButton.setSelected(false);
        leftPanel.pdPanel.iComboBox.setSelectedIndex(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        // tylko jedna płeć może być zaznaczona
        if (source == leftPanel.pdPanel.getManRadioButton && leftPanel.pdPanel.getWomanRadioButton.isSelected())
            leftPanel.pdPanel.getWomanRadioButton.setSelected(false);
        else if  (source == leftPanel.pdPanel.getWomanRadioButton && leftPanel.pdPanel.getManRadioButton.isSelected())
            leftPanel.pdPanel.getManRadioButton.setSelected(false);

        //
        if (source == leftPanel.pdPanel.spdButton)
        {
            PatientRecord.Sex_enum sex;
            if (leftPanel.pdPanel.getManRadioButton.isSelected())
                sex = PatientRecord.Sex_enum.M;
            else
                sex = PatientRecord.Sex_enum.K;

            PatientRecord.Insurance_enum ins;
            if (leftPanel.pdPanel.iComboBox.getSelectedIndex()==1)
                ins =  PatientRecord.Insurance_enum.LACK;
            else if (leftPanel.pdPanel.iComboBox.getSelectedIndex()==2)
                ins =  PatientRecord.Insurance_enum.NFZ;
            else if (leftPanel.pdPanel.iComboBox.getSelectedIndex()==3)
                ins =  PatientRecord.Insurance_enum.PRIVATE;
            else
                ins =  PatientRecord.Insurance_enum.NO_ANS;

            //tworzenie nowego obiektu listy patient_database
            PatientRegister.patient_database.add(new PatientRecord(leftPanel.pdPanel.getNameTextField.getText(),leftPanel.pdPanel.getSurnameTextField.getText(),Long.parseLong(leftPanel.pdPanel.getPeselTextField.getText()), sex, ins, false));
            clear_pd_sheet();

        }
        //jeśli klikamy anuluj resetujemy pola
        else if (source == leftPanel.pdPanel.cpdButton)
        {
            clear_pd_sheet();
        }

//        if ((source == leftPanel.pdPanel.spdButton || source == leftPanel.pdPanel.cpdButton)&&(leftPanel.pdPanel.getNameTextField.getText().isEmpty()||leftPanel.pdPanel.getSurnameTextField.getText().isEmpty()||leftPanel.pdPanel.getPeselTextField.getText().isEmpty()))  return;
////        if (source == leftPanel.pdPanel.getManRadioButton && )


    }
}
