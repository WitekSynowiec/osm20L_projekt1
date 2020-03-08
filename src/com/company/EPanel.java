package com.company;

import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;

public class EPanel extends JPanel{
    static JLabel label1, label2, label3, label4;
    static JTextField textField1, textField2, textField3;
    JButton button1, button2, button3;
    static JCalendar calendar;
    public EPanel(JFrame parentPanel){
        this.setBackground(Color.lightGray);
        this.setPreferredSize(new Dimension(parentPanel.getWidth(), parentPanel.getHeight()*2/5));
        this.setBorder(BorderFactory.createTitledBorder("Badanie: "));

        label1 = new JLabel("Data: ");
        label2 = new JLabel("Stężenie glukozy: ");
        label3 = new JLabel("Stężenie amylazy: ");
        label4 = new JLabel("Stężenie fosforanów: ");

        textField1 = new JTextField(3);
        textField2 = new JTextField(3);
        textField3 = new JTextField(3);

        calendar = new JCalendar();

        button1 = new JButton("Zapisz");
        button2 = new JButton("Anuluj");
        button3 = new JButton("Kalendarz");

        GroupLayout examinationLayout = new GroupLayout(this);
        this.setLayout(examinationLayout);
        examinationLayout.setAutoCreateGaps(true);

        examinationLayout.setHorizontalGroup(examinationLayout.createSequentialGroup().addGroup(examinationLayout.createParallelGroup( GroupLayout.Alignment.LEADING).addComponent(label1).addComponent(label2).addComponent(label3).addGroup(examinationLayout.createSequentialGroup().addComponent(button1).addComponent(button2))).addGroup(examinationLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(button3).addComponent(textField1).addComponent(textField2)));
        examinationLayout.setVerticalGroup(examinationLayout.createSequentialGroup().addGroup(examinationLayout.createParallelGroup( GroupLayout.Alignment.BASELINE).addComponent(label1).addComponent(button3)).addGroup(examinationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label2).addComponent(textField1)).addGroup(examinationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label3).addComponent(textField2)).addGroup(examinationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addGroup(examinationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(button1).addComponent(button2))));

    }
}
