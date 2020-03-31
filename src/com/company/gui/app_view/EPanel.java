package com.company.gui.app_view;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

public class EPanel extends JPanel{
    JLabel label1, label2, label3, label4;
    JTextField textField1, textField2, textField3, textField4;
    JButton button1, button2, button3;
    JDateChooser dateChooser;
    public EPanel(){
        this.setBackground(Color.lightGray);
        this.setBorder(BorderFactory.createTitledBorder("Badanie: "));

        label1 = new JLabel("Data: ");
        label2 = new JLabel("Stężenie glukozy: ");
        label3 = new JLabel("Stężenie amylazy: ");
        label4 = new JLabel("Stężenie fosforanów: ");

        textField1 = new JTextField(3);
        textField2 = new JTextField(3);
        textField3 = new JTextField(3);
        textField4 = new JTextField(3);

        dateChooser = new JDateChooser();

        button1 = new JButton("Zapisz");
        button2 = new JButton("Anuluj");
        button3 = new JButton("Kalendarz");

        GroupLayout examinationLayout = new GroupLayout(this);
        this.setLayout(examinationLayout);
        examinationLayout.setAutoCreateGaps(true);

        examinationLayout.setHorizontalGroup(examinationLayout.createSequentialGroup().addGroup(examinationLayout.createParallelGroup( GroupLayout.Alignment.LEADING).addComponent(label1).addComponent(label2).addComponent(label3).addComponent(label4).addGroup(examinationLayout.createSequentialGroup().addComponent(button1).addComponent(button2))).addGroup(examinationLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(dateChooser).addComponent(textField1).addComponent(textField2).addComponent(textField3)));
        examinationLayout.setVerticalGroup(examinationLayout.createSequentialGroup().addGroup(examinationLayout.createParallelGroup( GroupLayout.Alignment.BASELINE).addComponent(label1).addComponent(dateChooser)).addGroup(examinationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label2).addComponent(textField1)).addGroup(examinationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label3).addComponent(textField2)).addGroup(examinationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label4).addComponent(textField3)).addGroup(examinationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addGroup(examinationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(button1).addComponent(button2))));

    }
}
