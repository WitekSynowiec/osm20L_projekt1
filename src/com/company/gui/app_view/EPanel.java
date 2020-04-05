package com.company.gui.app_view;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EPanel extends JPanel{
    private JLabel dateLabel, glucoseLabel, amylaseLabel, phosphateLabel;
    private JTextField glucoseTextField, amylaseTextField, phosphateTextField;
    private JButton seButton, ceButton;
    private JDateChooser dateChooser;



    public EPanel(){
        this.setBackground(Color.lightGray);
        this.setBorder(BorderFactory.createTitledBorder("Badanie: "));

        dateLabel = new JLabel("Data: ");
        glucoseLabel = new JLabel("Stężenie glukozy: ");
        amylaseLabel = new JLabel("Stężenie amylazy: ");
        phosphateLabel = new JLabel("Stężenie fosforanów: ");

        glucoseTextField = new JTextField(3);
        amylaseTextField = new JTextField(3);
        phosphateTextField = new JTextField(3);

        dateChooser = new JDateChooser();

        seButton = new JButton("Zapisz");
        ceButton = new JButton("Anuluj");

        GroupLayout examinationLayout = new GroupLayout(this);
        this.setLayout(examinationLayout);
        examinationLayout.setAutoCreateGaps(true);

        examinationLayout.setHorizontalGroup(examinationLayout.createSequentialGroup().addGroup(examinationLayout.createParallelGroup( GroupLayout.Alignment.LEADING).addComponent(dateLabel).addComponent(glucoseLabel).addComponent(amylaseLabel).addComponent(phosphateLabel).addGroup(examinationLayout.createSequentialGroup().addComponent(seButton).addComponent(ceButton))).addGroup(examinationLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(dateChooser).addComponent(glucoseTextField).addComponent(amylaseTextField).addComponent(phosphateTextField)));
        examinationLayout.setVerticalGroup(examinationLayout.createSequentialGroup().addGroup(examinationLayout.createParallelGroup( GroupLayout.Alignment.BASELINE).addComponent(dateLabel).addComponent(dateChooser)).addGroup(examinationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(glucoseLabel).addComponent(glucoseTextField)).addGroup(examinationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(amylaseLabel).addComponent(amylaseTextField)).addGroup(examinationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(phosphateLabel).addComponent(phosphateTextField)).addGroup(examinationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addGroup(examinationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(seButton).addComponent(ceButton))));

    }
    public JButton getSeButton(){
        return seButton;
    }
    public JButton getCeButton(){
        return ceButton;
    }

    public void setGlucoseTextField(String t){
        glucoseTextField.setText(t);
    }
    public void clearGlucoseTextField(){
        setGlucoseTextField("");
    }
    public void setAmylaseTextField(String t){
        amylaseTextField.setText(t);
    }
    public void clearAmylaseTextField(){
        setAmylaseTextField("");
    }
    public void setPhosphateTextField(String t){
        phosphateTextField.setText(t);
    }
    public void clearPhosphateTextField(){
        setPhosphateTextField("");
    }

    public String getGlucoseTextField() {
        return glucoseTextField.getText();
    }

    public String getAmylaseTextField() {
        return amylaseTextField.getText();
    }

    public String getPhosphateTextField() {
        return phosphateTextField.getText();
    }

    public Float getFloatGlucoseTextField() {
        return Float.parseFloat(glucoseTextField.getText());
    }

    public Float getFloatAmylaseTextField() {
        return Float.parseFloat(amylaseTextField.getText());
    }

    public Float getFloatPhosphateTextField() {
        return Float.parseFloat(phosphateTextField.getText());
    }

    public JDateChooser getDateChooser()
    {
        return dateChooser;
    }

    public void setDateChooser(Date date) {
        dateChooser.setDate(date);
    }

    public void clearAllFields(){
        dateChooser.setCalendar(null);
        clearAmylaseTextField();
        clearGlucoseTextField();
        clearPhosphateTextField();
    }

    public void enableChange(boolean b)
    {
        dateChooser.setEnabled(b);
        glucoseTextField.setEditable(b);
        amylaseTextField.setEditable(b);
        phosphateTextField.setEnabled(b);
    }


}
