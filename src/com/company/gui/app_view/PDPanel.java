package com.company.gui.app_view;

import com.company.gui.app_model.Insurance;
import com.company.gui.app_model.Sex;

import javax.swing.*;
import java.awt.*;

/**Klasa {@code PDPanel} odpowiada za panel obsługujący wpisywanie danych pacjenta
 * w głównym framie aplikacji.
 * klasa jest zrealizowana przy pomocy funkcji i modułów klasy bazowej <code>JPanel</code>
 * składa się przycisków zrealizowanych przy pomocy GroupLayout.
 * @author Janek Grzegorek
 * @author Witek Synowiec
 */
public class PDPanel extends JPanel {

    private JLabel getNameLabel, getSurnameLabel, getPeselLabel, getSexLabel, getInsLabel;
    private JTextField getNameTextField, getSurnameTextField, getPeselTextField;
    private JRadioButton getWomanRadioButton, getManRadioButton;
    private String[] ins_states;
    private JComboBox<String> iComboBox;
    private JButton spdButton, cpdButton;

    public PDPanel(){
        this.setBackground(Color.lightGray);
        this.setBorder(BorderFactory.createTitledBorder("Dane pacjenta: "));

        getNameLabel = new JLabel("Imię: ");
        getNameTextField = new JTextField(10);
        getSurnameLabel = new JLabel("Nazwisko: ");
        getSurnameTextField = new JTextField(10);
        getPeselLabel = new JLabel("Pesel: ");
        getPeselTextField = new JTextField(10);

        getSexLabel = new JLabel("Płeć: ");
        getWomanRadioButton = new JRadioButton("Kobieta", false);
        getManRadioButton = new JRadioButton("Mężczyzna", false);
        getManRadioButton.setBackground(Color.lightGray);
        getWomanRadioButton.setBackground(Color.lightGray);

        getInsLabel = new JLabel("Ubezpieczenie");
        ins_states = new String[]{Insurance.NO_ANS.getIns(), Insurance.NFZ.getIns(), Insurance.LACK.getIns(), Insurance.PRIVATE.getIns()};
        iComboBox = new JComboBox<>(ins_states);


        spdButton = new JButton("Zapisz");
        cpdButton = new JButton("Anuluj");
        spdButton.setMargin(new Insets(0,0,0,0));
        cpdButton.setMargin(new Insets(0,0,0,0));
        spdButton.setAlignmentX(LEFT_ALIGNMENT);
        cpdButton.setAlignmentX(LEFT_ALIGNMENT);

        GroupLayout patientDataLayout = new GroupLayout(this);
        this.setLayout(patientDataLayout);
        patientDataLayout.setAutoCreateGaps(true);

        //grupowanie po pionie
        patientDataLayout.setHorizontalGroup(patientDataLayout.createSequentialGroup().addGroup(patientDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(getNameLabel).addComponent(getSurnameLabel).addComponent(getPeselLabel).addComponent(getSexLabel).addComponent(getInsLabel).addGroup(patientDataLayout.createSequentialGroup().addComponent(spdButton).addComponent(cpdButton))).addGroup(patientDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(getNameTextField).addComponent(getSurnameTextField).addComponent(getPeselTextField).addGroup(patientDataLayout.createSequentialGroup().addComponent(getWomanRadioButton).addComponent(getManRadioButton)).addComponent(iComboBox)));
        //grupowanie po poziomie
        patientDataLayout.setVerticalGroup(patientDataLayout.createSequentialGroup().addGroup(patientDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(getNameLabel).addComponent(getNameTextField)).addGroup(patientDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(getSurnameLabel).addComponent(getSurnameTextField)).addGroup(patientDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(getPeselLabel).addComponent(getPeselTextField)).addGroup(patientDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(getSexLabel).addGroup(patientDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(getWomanRadioButton).addComponent(getManRadioButton))).addGroup(patientDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(getInsLabel).addComponent(iComboBox)).addGroup(patientDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(spdButton).addComponent(cpdButton)));

    }

    /**Gettery i settery do pól panelu. Metody clear czyszczą powierzone im pola tekstowe,
     * przy czym <code>clearAllFields</code> czyści wszystkie */
    public String getTextGetNameTextField()
    {
        return getNameTextField.getText();
    }

    public void setTextGetNameTextField(String text)
    {
        getNameTextField.setText(text);
    }

    public void clearGetNameTextField(){
        setTextGetNameTextField("");
    }

    public String getTextGetSurnameTextField()
    {
        return getSurnameTextField.getText();
    }

    public void setTextGetSurnameTextField(String text)
    {
        getSurnameTextField.setText(text);
    }

    public void clearGetSurnameTextField(){
        setTextGetSurnameTextField("");
    }

    public String getTextGetPeselTextField() {
        String txtpesel = getPeselTextField.getText();

        for(char c : txtpesel.toCharArray()){
            if(!(Character.isDigit(c))){
                System.out.println("Nie wszystkie znaki są cyframi");
                return "";
            }
        }
            return getPeselTextField.getText();
    }

    public void setTextGetPeselTextField(String text)
    {
        getPeselTextField.setText(text);
    }

    public void clearGetPeselTextField()
    {
        getPeselTextField.setText("");
    }

    public Sex getGetSex() {
        if (getManRadioButton.isSelected())
            return Sex.M;
        else if (getWomanRadioButton.isSelected())
            return Sex.K;
        else return null;
    }

    public void setSexRadioButton(Sex sex) {
        if (sex.equals(Sex.K))
            setGetWomanRadioButton();
        else if (sex.equals(Sex.M))
            setGetManRadioButton();
    }

    public void setGetWomanRadioButton() {
            getWomanRadioButton.setSelected(true);
            getManRadioButton.setSelected(false);
    }

    public void setGetManRadioButton() {
        getWomanRadioButton.setSelected(false);
        getManRadioButton.setSelected(true);
    }

    public void clearManWomanRadioButtons() {
        getWomanRadioButton.setSelected(false);
        getManRadioButton.setSelected(false);
    }

    public Insurance getGetInsurance() {
        switch (iComboBox.getSelectedIndex())
        {
            case 0:
                return Insurance.NO_ANS;
            case 1:
                return Insurance.NFZ;
            case 2:
                return Insurance.LACK;
            case 3:
                return Insurance.PRIVATE;
            default:
                return null;
        }
    }

    public void setGetInsurance(Insurance ins) {
        switch (ins) {
            case NO_ANS:
                iComboBox.setSelectedIndex(0);
                break;
            case NFZ:
                iComboBox.setSelectedIndex(1);
                break;
            case LACK:
                iComboBox.setSelectedIndex(2);
                break;
            case PRIVATE:
                iComboBox.setSelectedIndex(3);
                break;
        }
    }

    public void clearGetInsurance(){
        setGetInsurance(Insurance.NO_ANS);
    }

    public JButton getCpdButton(){
        return cpdButton;
    }

    public JButton getSpdButton(){
        return spdButton;
    }

    public JRadioButton getGetManRadioButton(){
        return getManRadioButton;
    }

    public JRadioButton getGetWomanRadioButton(){
        return getWomanRadioButton;
    }

    public void clearAllFields() {
        clearGetPeselTextField();
        clearGetNameTextField();
        clearGetSurnameTextField();
        clearGetInsurance();
        clearManWomanRadioButtons();
    }

    /** Metoda enableChange(boolean b) ustawia komponenty panelu na możliwe (w wypadku
     * <code>b</code> równego true) lub na niemożliwe do edycji, w p.p.*/
    public void enableChange(boolean b) {
        getNameTextField.setEnabled(b);
        getSurnameTextField.setEnabled(b);
        getManRadioButton.setEnabled(b);
        getWomanRadioButton.setEnabled(b);
        getPeselTextField.setEnabled(b);
        iComboBox.setEnabled(b);
    }


}
