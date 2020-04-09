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
 * obsługę zdarzeń. Klasa implementuje trzy interfejsy:<br></br>
 * 1) <code>ActionListener</code><br></br>
 * 2) <code>ListSelectionListener</code><br></br>
 * 3) <code>TableModelListener</code><br></br>
 * Ze względu na to że opisy funkcji tutaj oznaczonych symbolem @Overrride są
 * dane w implementacji interfejsów właściwych (można mając kursor na nazwie interfejsu
 * i wklepać ctrl+B(Win)/command+B(Mac) je podejrzeć - przynajmniej w środowisku intelliJ)
 * nie uważamy za stosowne opisywanie tutaj tych metod.<br></br><br></br>
 *
 * Klasa {@code AppController} posiada dwa parametry prywatne:<br></br>
 * 1) <code>mView</code> klasy <code>AppView</code> przechowyjąca wskaźnik na widok aplikacji<br></br>
 * 2) <code>pRegister</code> klasy <code>PatientRegister</code> przechowująca wskaźnik
 * na rejestr pacjentów.
 *
 * @author Janek Grzegorek
 * @author Witek Synowiec
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

    /**Metoda prywatna <code>validateE()</code> sprawdza czy podane dane badań są poprawne.*/
    private boolean validateE(){
        if(mView.getEPanel().getDate()==null){
            JOptionPane.showMessageDialog(mView, "Nie zaznaczono daty badania.","Wiadomość",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(mView.getEPanel().getAmylaseTextField().equals("")){
            JOptionPane.showMessageDialog(mView, "Nie wpisano stężenia amylazy.","Wiadomość",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(mView.getEPanel().getGlucoseTextField().equals("")){
            JOptionPane.showMessageDialog(mView, "Nie wpisano stężenia glukozy.","Wiadomość",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(mView.getEPanel().getPhosphateTextField().equals("")){
            JOptionPane.showMessageDialog(mView, "Nie wpisano stężenia fosforanów.","Wiadomość",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        for(char c : mView.getEPanel().getAmylaseTextField().toCharArray()){
            if(!(Character.isDigit(c) || c=='.')){
                JOptionPane.showMessageDialog(mView, "Stężenie amylazy musi być podane jako liczba rzeczywista.","Wiadomość",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        for(char c : mView.getEPanel().getGlucoseTextField().toCharArray()){
            if(!(Character.isDigit(c) || c=='.')){
                JOptionPane.showMessageDialog(mView, "Stężenie glukozy musi być podane jako liczba rzeczywista.","Wiadomość",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        for(char c : mView.getEPanel().getPhosphateTextField().toCharArray()){
            if(!(Character.isDigit(c) || c=='.')){
                JOptionPane.showMessageDialog(mView, "Stężenie fosforanów musi być podane jako liczba rzeczywista.","Wiadomość",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    /**Metoda prywatna <code>validatePD()</code> sprawdza czy podane dane pacjentów są właściwe.*/
    private boolean validatePD(PatientRecord record, boolean peselCheck){
        if (pRegister.contains(record)&&peselCheck){
            JOptionPane.showMessageDialog(mView, "Podany pesel już istnieje.","Wiadomość",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(mView.getPDPanel().getTextGetNameTextField().isEmpty()){
            JOptionPane.showMessageDialog(mView, "Nie wpisano imienia..","Wiadomość",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(mView.getPDPanel().getTextGetSurnameTextField().isEmpty()){
            JOptionPane.showMessageDialog(mView, "Nie wpisano nazwiska.","Wiadomość",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(mView.getPDPanel().getTextGetPeselTextField().isEmpty()){
            JOptionPane.showMessageDialog(mView, "Nie wpisano numeru pesel.","Wiadomość",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!mView.getPDPanel().getGetManRadioButton().isSelected() && !mView.getPDPanel().getGetWomanRadioButton().isSelected()){
            JOptionPane.showMessageDialog(mView, "Nie wybrano płci.","Wiadomość",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(mView.getPDPanel().getGetInsurance().getIns().equals("")){
            JOptionPane.showMessageDialog(mView, "Nie wybrano ubezpieczenia.","Wiadomość",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(mView.getPDPanel().getTextGetPeselTextField().length() != 11){
            JOptionPane.showMessageDialog(mView, "Pesel musi mieć 11 cyfr.","Wiadomość",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**Metoda prywatna <code>clearTableSelection()</code> usuwa zaznaczenia z tablicy.*/
    private void clearTableSelection(){
        try {
            mView.getTPanel().getTable().clearSelection();
        }
        catch(Exception ignored){
        }
    }


    private void addSetHandler(TableModel model, StringBuilder str)
    {
        model.fireTableRowsUpdated(0,model.getRowCount()-1);
        mView.getPDPanel().clearAllFields();
        mView.getEPanel().clearAllFields();
        mView.getPDPanel().enableChange(false);
        mView.getEPanel().enableChange(false);
        clearTableSelection();
        mView.getPDPanel().enableChange(false);
        mView.getEPanel().enableChange(false);
        JOptionPane.showMessageDialog(mView, str, "Wiadomość", JOptionPane.INFORMATION_MESSAGE);
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
            PatientRecord record = new PatientRecord(mView.getPDPanel().getTextGetNameTextField(), mView.getPDPanel().getTextGetSurnameTextField(), mView.getPDPanel().getTextGetPeselTextField(), mView.getPDPanel().getGetSex(), mView.getPDPanel().getGetInsurance());
            Boolean isInDatabase = pRegister.contains(record);

            if ((selectedRow!=-1 && !pRegister.getRecord(selectedRow).getPesel().equals(mView.getPDPanel().getTextGetPeselTextField()) && validatePD(record, true))||(selectedRow!=-1 && pRegister.getRecord(selectedRow).getPesel().equals(mView.getPDPanel().getTextGetPeselTextField()) && validatePD(record, false)))
            {
                pRegister.getRecord(selectedRow).setName(mView.getPDPanel().getTextGetNameTextField());
                pRegister.getRecord(selectedRow).setSurname(mView.getPDPanel().getTextGetSurnameTextField());
                pRegister.getRecord(selectedRow).setPesel(mView.getPDPanel().getTextGetPeselTextField());
                pRegister.getRecord(selectedRow).setSex(mView.getPDPanel().getGetSex());
                pRegister.getRecord(selectedRow).setIns(mView.getPDPanel().getGetInsurance());
                str.append("Zmodyfikowano pacjenta ");
                str.append(pRegister.getRecord(selectedRow).getName());
                str.append(" ");
                str.append(pRegister.getRecord(selectedRow).getSurname());
                addSetHandler(model, str);
            }
            else if ((selectedRow == -1 && validatePD(record, true)))
            {
                pRegister.add(record);
                str.append("Dodano pacjenta ");
                str.append(pRegister.getRecord(pRegister.getSize()-1).getName());
                str.append(" ");
                str.append(pRegister.getRecord(pRegister.getSize()-1).getSurname());
                addSetHandler(model, str);
            }

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
                JOptionPane.showMessageDialog(mView, "Usunięto pacjenta.","Wiadomość",JOptionPane.INFORMATION_MESSAGE);
            }
            clearTableSelection();
            mView.getEPanel().clearAllFields();
            mView.getPDPanel().clearAllFields();
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
                pRegister.getRecord(selectedRow).setExamination(new Examination(mView.getEPanel().getFloatGlucoseTextField(),mView.getEPanel().getFloatAmylaseTextField(),mView.getEPanel().getFloatPhosphateTextField(),mView.getEPanel().getDate()));
                model.fireTableRowsUpdated(0,model.getRowCount()-1);
                mView.getEPanel().clearAllFields();
                mView.getPDPanel().clearAllFields();

                str.append(pRegister.getRecord(selectedRow).getName());
                str.append(" ");
                str.append(pRegister.getRecord(selectedRow).getSurname());
                clearTableSelection();
                JOptionPane.showMessageDialog(mView, str,"Wiadomość",JOptionPane.INFORMATION_MESSAGE);
                mView.getEPanel().enableChange(false);
                mView.getPDPanel().enableChange(false);
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
