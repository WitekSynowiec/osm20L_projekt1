package com.company.gui.app_view;

import com.company.gui.app_model.Insurance;
import com.company.gui.app_model.Sex;

import javax.swing.*;
import java.awt.*;

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
//###########################
//
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

    public String getGetNameTextField()
    {
        return getNameTextField.getText();
    }

    public void setGetNameTextField(String text)
    {
        getNameTextField.setText(text);
    }

    public String getGetSurnameTextField()
    {
        return getSurnameTextField.getText();
    }
    public void setGetSurnameTextField(String text)
    {
        getSurnameTextField.setText(text);
    }

    public Long getGetPeselTextField()
    {
        return Long.parseLong(getPeselTextField.getText());
    }

    public void setGetPeselTextField(Long text)
    {
        getSurnameTextField.setText(text.toString());
    }

    public Sex getGetSex()
    {
        if (getManRadioButton.isSelected())
            return Sex.M;
        else if (getWomanRadioButton.isSelected())
            return Sex.K;
        else return null;
    }

    public void setGetSex(Sex sex)
    {
        if (sex.getSex().equals("K")){
            getWomanRadioButton.setSelected(true);
            getManRadioButton.setSelected(false);
        }
        else if (sex.getSex().equals("M")){
            getWomanRadioButton.setSelected(false);
            getManRadioButton.setSelected(true);
        }
    }

    public Insurance getGetInsurance()
    {
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
    public void setGetInsurance(Insurance ins)
    {
        switch (ins.getIns())
        {
            case "":
                iComboBox.setSelectedIndex(0);
            case "NFZ":
                iComboBox.setSelectedIndex(1);
            case "prywatnie":
                iComboBox.setSelectedIndex(2);
            case "brak":
                iComboBox.setSelectedIndex(3);
        }
    }



}
