package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.MainWindow.leftPanel;
import static com.company.MainWindow.rightPanel;
import static com.company.RightPanel.pTable;

public class ActionHandler implements ActionListener, ListSelectionListener{

    public ActionHandler(){
        LeftPanel.pdPanel.spdButton.addActionListener(this);
        LeftPanel.pdPanel.cpdButton.addActionListener(this);
        LeftPanel.ePanel.button1.addActionListener(this);
        LeftPanel.ePanel.button2.addActionListener(this);
        LeftPanel.ePanel.button3.addActionListener(this);
        LeftPanel.pdPanel.getManRadioButton.addActionListener(this);
        LeftPanel.pdPanel.getWomanRadioButton.addActionListener(this);
        RightPanel.button1.addActionListener(this);
        RightPanel.button2.addActionListener(this);
        pTable.getSelectionModel().addListSelectionListener(this);
    }

    private void clear_pd_sheet() {
        LeftPanel.pdPanel.getNameTextField.setText("");
        LeftPanel.pdPanel.getSurnameTextField.setText("");
        LeftPanel.pdPanel.getPeselTextField.setText("");
        LeftPanel.pdPanel.getWomanRadioButton.setSelected(false);
        LeftPanel.pdPanel.getManRadioButton.setSelected(false);
        LeftPanel.pdPanel.iComboBox.setSelectedIndex(0);
    }


    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource() == pTable.getSelectionModel() && pTable.getRowSelectionAllowed()) {
            int first = e.getFirstIndex();
            int last = e.getLastIndex();
        } else if (e.getSource() == pTable.getColumnModel().getSelectionModel()
                && pTable.getColumnSelectionAllowed()) {
            int first = e.getFirstIndex();
            int last = e.getLastIndex();
        }
        if (e.getValueIsAdjusting()) {
            System.out.println("The mouse button has not yet been released");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == pTable.getSelectionModel())
            {
                LeftPanel.pdPanel.getNameTextField.setText("LUBUIE");
            }
            // tylko jedna płeć może być zaznaczona
            if (source == LeftPanel.pdPanel.getManRadioButton && LeftPanel.pdPanel.getWomanRadioButton.isSelected())
                LeftPanel.pdPanel.getWomanRadioButton.setSelected(false);
            else if  (source == LeftPanel.pdPanel.getWomanRadioButton && LeftPanel.pdPanel.getManRadioButton.isSelected())
                LeftPanel.pdPanel.getManRadioButton.setSelected(false);


            if (source == LeftPanel.pdPanel.spdButton)
            {
                PatientRecord.Sex_enum sex;
                if (LeftPanel.pdPanel.getManRadioButton.isSelected())
                    sex = PatientRecord.Sex_enum.M;
                else
                    sex = PatientRecord.Sex_enum.K;

                PatientRecord.Insurance_enum ins;
                if (LeftPanel.pdPanel.iComboBox.getSelectedIndex()==1)
                    ins =  PatientRecord.Insurance_enum.LACK;
                else if (LeftPanel.pdPanel.iComboBox.getSelectedIndex()==2)
                    ins =  PatientRecord.Insurance_enum.NFZ;
                else if (LeftPanel.pdPanel.iComboBox.getSelectedIndex()==3)
                    ins =  PatientRecord.Insurance_enum.PRIVATE;
                else
                    ins =  PatientRecord.Insurance_enum.NO_ANS;

                //tworzenie nowego obiektu listy patient_database
//            PatientRegister.patient_database.add(new PatientRecord(leftPanel.pdPanel.getNameTextField.getText(),leftPanel.pdPanel.getSurnameTextField.getText(),Long.parseLong(leftPanel.pdPanel.getPeselTextField.getText()), sex, ins, false));
                Object[] addon = {LeftPanel.pdPanel.getNameTextField.getText()+" "+ LeftPanel.pdPanel.getSurnameTextField.getText(),sex.getSex(),Long.parseLong(LeftPanel.pdPanel.getPeselTextField.getText()),ins.getIns(), false};
                rightPanel.model.addRow(addon);
                clear_pd_sheet();

            }
            //jeśli klikamy anuluj resetujemy pola
            else if (source == LeftPanel.pdPanel.cpdButton)
            {
                clear_pd_sheet();
            }

//        if ((source == leftPanel.pdPanel.spdButton || source == leftPanel.pdPanel.cpdButton)&&(leftPanel.pdPanel.getNameTextField.getText().isEmpty()||leftPanel.pdPanel.getSurnameTextField.getText().isEmpty()||leftPanel.pdPanel.getPeselTextField.getText().isEmpty()))  return;
////        if (source == leftPanel.pdPanel.getManRadioButton && )
        if (source == RightPanel.button2){
            rightPanel.model.removeRow(pTable.getSelectedRow());
        }
//        if (source == pTable.getSelectedRow())


        }

}
