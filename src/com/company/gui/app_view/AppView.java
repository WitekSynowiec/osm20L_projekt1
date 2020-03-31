package com.company.gui.app_view;

import com.company.gui.interfaces.ViewListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppView extends JFrame implements ActionListener{
    public AppView(){
        this.doGui();
    }
    private void doGui()
    {
        getContentPane().setBackground(Color.lightGray);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        LeftPanel leftPanel = new LeftPanel();
//        RightPanel rightPanel = new RightPanel();
        PDPanel patientDataPanel = new PDPanel();
        EPanel examinationPanel = new EPanel();
        TablePanel tablePanel = new TablePanel();

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(patientDataPanel,c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        this.add(examinationPanel, c);

        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 5;
        c.gridheight = 2;
        this.add(tablePanel,c);
        pack();


//        c.fill =
        this.setVisible(true);
        this.setResizable(false);


//        this.setSize();
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.gridx = 1;
//        c.gridy = 0;
//        c.gridheight = 2;
//        c.weighty = 1.0;
//        c.weightx = 1.0;
//
//        this.add(tablePanel, c);

//
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.gridx = 2;
//        c.gridy = 0;
//        this.add(leftPanel);

//        JButton button;
//
//        button = new JButton("Button 2");
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.5;
//        c.gridx = 1;
//        c.gridy = 0;
//        this.add(button, c);
//
//        button = new JButton("Button 3");
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.5;
//        c.gridx = 2;
//        c.gridy = 0;
//        this.add(button, c);
//
//        button = new JButton("Long-Named Button 4");
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.ipady = 40;      //make this component tall
//        c.weightx = 0.0;
//        c.gridwidth = 3;
//        c.gridx = 0;
//        c.gridy = 1;
//        this.add(button, c);
//
//        button = new JButton("5");
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.ipady = 0;       //reset to default
//        c.weighty = 1.0;   //request any extra vertical space
//        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
//        c.insets = new Insets(10,0,0,0);  //top padding
//        c.gridx = 1;       //aligned with button 2
//        c.gridwidth = 2;   //2 columns wide
//        c.gridy = 2;       //third row
//        this.add(button, c);

//        this.setLayout(new BorderLayout());
//        this.add(BorderLayout.EAST, rightPanel);
//        this.add(BorderLayout.WEST, leftPanel);
//        this.setBackground(Color.red);
    }
    public void setController(ActionListener a)
    {
//        leftPanel.pdPanel
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
