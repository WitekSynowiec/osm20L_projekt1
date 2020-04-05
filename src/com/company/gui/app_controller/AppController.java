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

/**Klasa {@code AppController} to klasa kontrolera apliakcji. Odpowiada za
 * obsługę zdarzeń. Klasa implementuje trzy interfejsy:
 * 1) <code>ActionListener<code/>
 * 2) <code>ListSelectionListener<code/>
 * 3) <code>TableModelListener<code/>
 * Ze względu na to że opisy funkcji tutaj oznaczonych symbolem @Overrride są
 * dane w implementacji interfejsów właściwych (można mając kursor na nazwie interfejsu
 * i wklepać ctrl+B(Win)/command+B(Mac) je podejrzeć - przynajmniej w środowisku intelliJ)
 * nie uważamy za stosowne opisywanie tutaj tych metod.
 *
 * Klasa {@code AppController} posiada dwa parametry prywatne:
 * 1) {@param mView} klasy <code>AppView<code/> przechowyjąca wskaźnik na widok aplikacji
 * 2) {@param pRegister} klasy <code>PatientRegister<code/> przechowująca wskaźnik
 * na rejestr pacjentów.
 */
public class AppController implements ActionListener, ListSelectionListener, TableModelListener {
    private AppView mView;
    private PatientRegister	pRegister;

    /**Klasa {@code AppController} ma oczywiście jedynie sens istnienia wówczas gdy jest
     * połączona wskaźnikami z klasą widoku oraz modelu, tak aby zrealizować porządnie model MVC.
     * Stąd takie a nie inne parametry wejściowe.*/
    public AppController (AppView appView, PatientRegister patientRegister){
        this.mView = appView;
        this.pRegister = patientRegister;
        mView.getPDPanel().enableChange(false);
        mView.getEPanel().enableChange(false);
        mView.getTPanel().getTable().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /** Metoda prywatna {@code validateString(String str)} sprawdza czy dany ciąg znaków
     * zawiera wyłącznie litery. Jeśli zawiera tylko litery zwraca true. False zwraca w p.p.*/
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

    /**Metoda prywatna {@code validateE() sprawdza czy } podane dane badań są poprawne.*/
    private boolean validateE(){
        return pRegister.validateExam(
                mView.getEPanel().getAmylaseTextField(),
                mView.getEPanel().getGlucoseTextField(),
                mView.getEPanel().getPhosphateTextField(),
                mView.getEPanel().getDateChooser().getDate());
    }

    /**Metoda prywatna {@code validatePD() sprawdza czy } podane dane pacjentów są właściwe.*/
    private boolean validatePD(){
        String peselsen;
        if (pRegister.getSize()==0){
            peselsen = "000001000000";
        }
        else{
            try {
                peselsen = pRegister.getRecord(mView.getTPanel().getTable().getSelectedRow()).getPesel();
            }
            catch (Exception e){
                peselsen = "0000001000000";
            }
        }
        return pRegister.validatePD(
                mView.getPDPanel().getTextGetNameTextField(),
                mView.getPDPanel().getTextGetSurnameTextField(),
                mView.getPDPanel().getTextGetPeselTextField(),
                mView.getPDPanel().getGetManRadioButton(),
                mView.getPDPanel().getGetWomanRadioButton(),
                mView.getPDPanel().getGetInsurance().getIns(),
                peselsen);
    }

    /**Metoda prywatna {@code clearTableSelection() usuwa zaznaczenia z tablicy.*/
    private void clearTableSelection(){
        try {
            mView.getTPanel().getTable().clearSelection();
        }
        catch(Exception ignored){
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = mView.getTPanel().getTable().getSelectedRow();
        TableModel model = mView.getTPanel().getTableModel();
        Object source = e.getSource();
        mView.getTPanel().getTable().setColumnSelectionAllowed(false);
        mView.getTPanel().getTable().setCellSelectionEnabled(false);
        mView.getTPanel().getTable().setRowSelectionAllowed(true);

        if (source == mView.getPDPanel().getSpdButton())
        {
            StringBuilder str = new StringBuilder();
            if (validatePD()) {
                if(selectedRow == -1){
                    pRegister.add(new PatientRecord(mView.getPDPanel().getTextGetNameTextField(), mView.getPDPanel().getTextGetSurnameTextField(), mView.getPDPanel().getTextGetPeselTextField(), mView.getPDPanel().getGetSex(), mView.getPDPanel().getGetInsurance()));
                    str.append("Dodano pacjenta ");
                    str.append(pRegister.getRecord(pRegister.getSize()-1).getName());
                    str.append(" ");
                    str.append(pRegister.getRecord(pRegister.getSize()-1).getSurname());
                }
                else{
                    pRegister.getRecord(selectedRow).setName(mView.getPDPanel().getTextGetNameTextField());
                    pRegister.getRecord(selectedRow).setSurname(mView.getPDPanel().getTextGetSurnameTextField());
                    pRegister.getRecord(selectedRow).setPesel(mView.getPDPanel().getTextGetPeselTextField());
                    pRegister.getRecord(selectedRow).setSex(mView.getPDPanel().getGetSex());
                    pRegister.getRecord(selectedRow).setIns(mView.getPDPanel().getGetInsurance());

                    str.append("Zmodyfikowano pacjenta ");
                    str.append(pRegister.getRecord(selectedRow).getName());
                    str.append(" ");
                    str.append(pRegister.getRecord(selectedRow).getSurname());
                }

                model.fireTableRowsUpdated(0,model.getRowCount()-1);
                mView.getPDPanel().clearAllFields();
                mView.getEPanel().clearAllFields();
                mView.getPDPanel().enableChange(false);
                mView.getEPanel().enableChange(false);
                clearTableSelection();
                mView.getPDPanel().enableChange(false);
                mView.getEPanel().enableChange(false);
            }
            else str.append("Podano nieprawidłowe dane.");
            JOptionPane.showMessageDialog(mView, str,"Wiadomość",JOptionPane.INFORMATION_MESSAGE);

        }
        if (source == mView.getPDPanel().getCpdButton())
        {
            mView.getPDPanel().clearAllFields();
            clearTableSelection();
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

            if (selectedRow==-1)
                JOptionPane.showMessageDialog(mView, "Nie wybrano pacjenta.","Wiadomość",JOptionPane.INFORMATION_MESSAGE);
            else if (!pRegister.isEmpty())
            {
                model.fireTableRowsUpdated(0,model.getRowCount()-1);
                pRegister.remove(selectedRow);
                mView.getPDPanel().clearAllFields();
                JOptionPane.showMessageDialog(mView, "Usunięto pacjenta.","Wiadomość",JOptionPane.INFORMATION_MESSAGE);
            }
            clearTableSelection();
            mView.getPDPanel().enableChange(false);
            mView.getEPanel().enableChange(false);
        }

        if (source == mView.getEPanel().getSeButton())
        {
            StringBuilder str = new StringBuilder();
            if(validateE()){
                if (pRegister.getRecord(selectedRow).getExamination()==null)
                    str.append("Dodano badanie pacjenta ");
                else
                    str.append("Zmodyfikowano badanie pacjenta ");
                pRegister.getRecord(selectedRow).setExamination(new Examination(mView.getEPanel().getFloatGlucoseTextField(),mView.getEPanel().getFloatAmylaseTextField(),mView.getEPanel().getFloatPhosphateTextField(),mView.getEPanel().getDateChooser().getDate()));
                model.fireTableRowsUpdated(0,model.getRowCount()-1);
                mView.getEPanel().clearAllFields();
                mView.getPDPanel().clearAllFields();

                str.append(pRegister.getRecord(selectedRow).getName());
                str.append(" ");
                str.append(pRegister.getRecord(selectedRow).getSurname());
                clearTableSelection();
            }
            else str.append("Podano nieprawidłowe dane.");
            mView.getEPanel().enableChange(false);
            mView.getPDPanel().enableChange(false);
            JOptionPane.showMessageDialog(mView, str,"Wiadomość",JOptionPane.INFORMATION_MESSAGE);

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
            mView.getEPanel().enableChange(false);
            clearTableSelection();
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


}
