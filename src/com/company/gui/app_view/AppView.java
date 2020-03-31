package com.company.gui.app_view;

import com.company.gui.interfaces.ModelListener;
import com.company.gui.interfaces.ViewListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppView extends JFrame implements ActionListener{
    private ViewListener modelListener;
    PDPanel patientDataPanel;
    EPanel examinationPanel;
    TablePanel tablePanel;
    public AppView(){
        this.doGui();
    }

    private void doGui()
    {
        getContentPane().setBackground(Color.lightGray);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        patientDataPanel = new PDPanel();
        examinationPanel = new EPanel();
        tablePanel = new TablePanel();

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

        this.setVisible(true);
        this.setResizable(false);
    }
    public void setController(ActionListener a)
    {
//        leftPanel.pdPanel
    }
    public void addListener(ViewListener listener)
    {
        this.modelListener = listener;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource()==patientDataPanel.bu)
//            this.mListener.viewChanged(this,"Increment");
//        else if (e.getSource()==this.mDecrementButton)
//            this.mListener.viewChanged(this,"Decrement");
    }
}
