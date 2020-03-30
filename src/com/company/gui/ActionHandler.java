//package com.company.gui;
//
//import com.company.data_model.Insurance;
//import com.company.data_model.Pair;
//import com.company.data_model.PatientRecord;
//import com.company.data_model.Sex;
//import com.company.gui.*;
//
//import javax.swing.*;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
//import javax.swing.table.DefaultTableModel;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.LinkedList;
//
//import static com.company.gui.AppView.rightPanel;
//import static com.company.gui.RightPanel.pTable;
//
//public class ActionHandler implements ActionListener, ListSelectionListener{
//    ListSelectionModel cellSelectionModel = pTable.getSelectionModel();
//    LinkedList<Pair> pair = new LinkedList<>();
//    public ActionHandler(){
//        LeftPanel.pdPanel.spdButton.addActionListener(this);
//        LeftPanel.pdPanel.cpdButton.addActionListener(this);
//        LeftPanel.ePanel.button1.addActionListener(this);
//        LeftPanel.ePanel.button2.addActionListener(this);
//        LeftPanel.ePanel.button3.addActionListener(this);
//        LeftPanel.pdPanel.getManRadioButton.addActionListener(this);
//        LeftPanel.pdPanel.getWomanRadioButton.addActionListener(this);
//        RightPanel.button1.addActionListener(this);
//        RightPanel.button2.addActionListener(this);
//        pTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        pTable.getSelectionModel().addListSelectionListener(e -> {
//            clear_pd_sheet();
////                LeftPanel.pdPanel.getNameTextField.setText(pair.get(pTable.getSelectedRow()).value1);
////                LeftPanel.pdPanel.getSurnameTextField.setText(pair.get(pTable.getSelectedRow()).value2);
////            LeftPanel.pdPanel.getNameTextField.setText(pTable.getModel().getValueAt(pTable.getSelectedRow(),1).toString());
////            LeftPanel.pdPanel.getPeselTextField.setText(pTable.getModel().getValueAt(pTable.getSelectedRow(), 2).toString());
//            LeftPanel.pdPanel.getPeselTextField.setText(pTable.getModel().getValueAt(pTable.getSelectedRow(), 2).toString());
//            if (pTable.getModel().getValueAt(pTable.getSelectedRow(), 1).toString().equals(Sex.M.getSex())){
//                LeftPanel.pdPanel.getManRadioButton.setSelected(true);
//                LeftPanel.pdPanel.getWomanRadioButton.setSelected(false);
//            }
//            else if (pTable.getModel().getValueAt(pTable.getSelectedRow(), 1).toString().equals(Sex.K.getSex())){
//                LeftPanel.pdPanel.getManRadioButton.setSelected(false);
//                LeftPanel.pdPanel.getWomanRadioButton.setSelected(true);
//            }
//            if (pTable.getModel().getValueAt(pTable.getSelectedRow(),3).toString().equals(Insurance.NO_ANS.getIns()))
//                LeftPanel.pdPanel.iComboBox.setSelectedIndex(0);
//            else if (pTable.getModel().getValueAt(pTable.getSelectedRow(),3).toString().equals(Insurance.NFZ.getIns()))
//                LeftPanel.pdPanel.iComboBox.setSelectedIndex(1);
//            else if (pTable.getModel().getValueAt(pTable.getSelectedRow(),3).toString().equals(Insurance.LACK.getIns()))
//                LeftPanel.pdPanel.iComboBox.setSelectedIndex(2);
//            else if (pTable.getModel().getValueAt(pTable.getSelectedRow(),3).toString().equals(Insurance.PRIVATE.getIns()))
//                LeftPanel.pdPanel.iComboBox.setSelectedIndex(3);
//        });
//        if (pTable.isEditing())
//            pTable.getCellEditor().stopCellEditing();
//    }
//
//    private void clear_pd_sheet() {
//        LeftPanel.pdPanel.getNameTextField.setText("");
//        LeftPanel.pdPanel.getSurnameTextField.setText("");
//        LeftPanel.pdPanel.getPeselTextField.setText("");
//        LeftPanel.pdPanel.getWomanRadioButton.setSelected(false);
//        LeftPanel.pdPanel.getManRadioButton.setSelected(false);
//        LeftPanel.pdPanel.iComboBox.setSelectedIndex(0);
//    }
//
//
//    public void valueChanged(ListSelectionEvent e) {
//        if (e.getSource() == pTable.getSelectionModel() && pTable.getRowSelectionAllowed()) {
//            int first = e.getFirstIndex();
//            int last = e.getLastIndex();
//        } else if (e.getSource() == pTable.getColumnModel().getSelectionModel()
//                && pTable.getColumnSelectionAllowed()) {
//            int first = e.getFirstIndex();
//            int last = e.getLastIndex();
//        }
//        if (e.getValueIsAdjusting()) {
//            System.out.println("The mouse button has not yet been released");
//        }
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//            Object source = e.getSource();
//
//            // tylko jedna płeć może być zaznaczona
//            if (source == LeftPanel.pdPanel.getManRadioButton && LeftPanel.pdPanel.getWomanRadioButton.isSelected())
//                LeftPanel.pdPanel.getWomanRadioButton.setSelected(false);
//            else if  (source == LeftPanel.pdPanel.getWomanRadioButton && LeftPanel.pdPanel.getManRadioButton.isSelected())
//                LeftPanel.pdPanel.getManRadioButton.setSelected(false);
//
//
//            if (source == LeftPanel.pdPanel.spdButton)
//            {
//                Sex sex;
//                if (LeftPanel.pdPanel.getManRadioButton.isSelected())
//                    sex = Sex.M;
//                else
//                    sex = Sex.K;
//
//                Insurance ins;
//                if (LeftPanel.pdPanel.iComboBox.getSelectedIndex()==1)
//                    ins =  Insurance.LACK;
//                else if (LeftPanel.pdPanel.iComboBox.getSelectedIndex()==2)
//                    ins =  Insurance.NFZ;
//                else if (LeftPanel.pdPanel.iComboBox.getSelectedIndex()==3)
//                    ins =  Insurance.PRIVATE;
//                else
//                    ins =  Insurance.NO_ANS;
//
//                //tworzenie nowego obiektu listy patient_database
//
////                pair = new Pair(LeftPanel.pdPanel.getNameTextField.getText(),LeftPanel.pdPanel.getSurnameTextField.getText());
//                // alternative
//                Pair newPair = new Pair(LeftPanel.pdPanel.getNameTextField.getText(),LeftPanel.pdPanel.getSurnameTextField.getText());
//                pair.add(newPair);
////                Object[] addon = {pair.get(pair.size()-1).value1+ " "+pair.get(pair.size()-1).value2,sex.getSex(),Long.parseLong(LeftPanel.pdPanel.getPeselTextField.getText()),ins.getIns(), false};
////                Object[] addon = {LeftPanel.pdPanel.getNameTextField.getText()+ " "+LeftPanel.pdPanel.getNameTextField.getText(),sex.getSex(),Long.parseLong(LeftPanel.pdPanel.getPeselTextField.getText()),ins.getIns(), false};
//
////                rightPanel.model.addRow(addon);
//                clear_pd_sheet();
//
//            }
//            //jeśli klikamy anuluj resetujemy pola
//            else if (source == LeftPanel.pdPanel.cpdButton)
//            {
//                clear_pd_sheet();
//            }
////            int t[]  = new int[4];
////            int a = Math.;
//
//
//        if (source == RightPanel.button2){
//            clear_pd_sheet();
//            int no = pTable.getSelectedRow();
////            pair.remove(no);
////            pTable.setSortable( false );
////            model.removeRow( selectedModelRow );
////            clsController.getTable().setSortable( true );
//            DefaultCellEditor dce = (DefaultCellEditor)pTable.getCellEditor();
//            if (dce != null) dce.stopCellEditing();
//            int viewIndex = pTable.getSelectedRow();
////            if(viewIndex != -1) {
////                int modelIndex = pTable.convertRowIndexToModel(viewIndex); // converts the row index in the view to the appropriate index in the model
////                DefaultTableModel model = (DefaultTableModel)pTable.getModel();
////                model.removeRow(modelIndex);
////            }
//            rightPanel.model.removeRow(no);
////            rightPanel.model.removeRow(no);
////////            pTable.getSelectionModel().
//////            rightPanel.model.addRow(new String[]{"", "", "", "", "", ""});
//////            pair.add(new Pair )
//////            pair.remove(no);
//
////            rightPanel.model.removeRow(pTable.getSelectedRow());
////            pTable.setRowHeight(pTable.getSelectedRow(), 120);
//
////            System.out.println(rightPanel.model.row);
//        }
//
//        }
//
//}
