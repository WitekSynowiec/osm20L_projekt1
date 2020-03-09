package com.company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.company.MainWindow.leftPanel;
import static com.company.MainWindow.rightPanel;
import static com.company.RightPanel.pTable;

public class ActionHandler implements ActionListener, ListSelectionListener{
//    ArrayList<Pair> pair = new ArrayList<Pair>();
    ListSelectionModel cellSelectionModel = pTable.getSelectionModel();
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
        pTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pTable.getSelectionModel().addListSelectionListener(e -> {
            clear_pd_sheet();
//                LeftPanel.pdPanel.getNameTextField.setText(pair.get(pTable.getSelectedRow()).value1);
//                LeftPanel.pdPanel.getSurnameTextField.setText(pair.get(pTable.getSelectedRow()).value2);
            LeftPanel.pdPanel.getNameTextField.setText(pTable.getModel().getValueAt(pTable.getSelectedRow(),1).toString());
            LeftPanel.pdPanel.getPeselTextField.setText(pTable.getModel().getValueAt(pTable.getSelectedRow(), 2).toString());
            if (pTable.getModel().getValueAt(pTable.getSelectedRow(), 1).toString().equals(PatientRecord.Sex_enum.M.getSex())){
                LeftPanel.pdPanel.getManRadioButton.setSelected(true);
                LeftPanel.pdPanel.getWomanRadioButton.setSelected(false);
            }
            else if (pTable.getModel().getValueAt(pTable.getSelectedRow(), 1).toString().equals(PatientRecord.Sex_enum.K.getSex())){
                LeftPanel.pdPanel.getManRadioButton.setSelected(false);
                LeftPanel.pdPanel.getWomanRadioButton.setSelected(true);
            }
            if (pTable.getModel().getValueAt(pTable.getSelectedRow(),3).toString().equals(PatientRecord.Insurance_enum.NO_ANS.getIns()))
                LeftPanel.pdPanel.iComboBox.setSelectedIndex(0);
            else if (pTable.getModel().getValueAt(pTable.getSelectedRow(),3).toString().equals(PatientRecord.Insurance_enum.NFZ.getIns()))
                LeftPanel.pdPanel.iComboBox.setSelectedIndex(1);
            else if (pTable.getModel().getValueAt(pTable.getSelectedRow(),3).toString().equals(PatientRecord.Insurance_enum.LACK.getIns()))
                LeftPanel.pdPanel.iComboBox.setSelectedIndex(2);
            else if (pTable.getModel().getValueAt(pTable.getSelectedRow(),3).toString().equals(PatientRecord.Insurance_enum.PRIVATE.getIns()))
                LeftPanel.pdPanel.iComboBox.setSelectedIndex(3);
        });
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

//                pair = new Pair(LeftPanel.pdPanel.getNameTextField.getText().toString(),LeftPanel.pdPanel.getSurnameTextField.getText().toString());
                // alternative
//                Pair newpair = new Pair(LeftPanel.pdPanel.getNameTextField.getText(),LeftPanel.pdPanel.getSurnameTextField.getText());
//                pair.add(newpair);
//                Object[] addon = {pair.get(pair.size()-1).value1+ " "+pair.get(pair.size()-1).value2,sex.getSex(),Long.parseLong(LeftPanel.pdPanel.getPeselTextField.getText()),ins.getIns(), false};
                Object[] addon = {LeftPanel.pdPanel.getNameTextField.getText()+ " "+LeftPanel.pdPanel.getNameTextField.getText(),sex.getSex(),Long.parseLong(LeftPanel.pdPanel.getPeselTextField.getText()),ins.getIns(), false};

//                rightPanel.model.add
                rightPanel.model.removeRow(0);
                clear_pd_sheet();

            }
            //jeśli klikamy anuluj resetujemy pola
            else if (source == LeftPanel.pdPanel.cpdButton)
            {
                clear_pd_sheet();
            }

        if (source == RightPanel.button2){
            clear_pd_sheet();
//            int no = pTable.getSelectedRow();
//            rightPanel.model.removeRow(no);
//////            pTable.getSelectionModel().
////            rightPanel.model.addRow(new String[]{"", "", "", "", "", ""});
////            pair.add(new Pair )
////            pair.remove(no);
//            rightPanel.model.removeRow(pTable.getSelectedRow());
//            pTable.setRowHeight(pTable.getSelectedRow(), 120);
            System.out.println(pTable.getSelectedRow());

//            System.out.println(rightPanel.model.row);
        }

        }

}
