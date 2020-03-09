package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    static LeftPanel leftPanel;
    static RightPanel  rightPanel;
    public MainWindow(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(1024, 768);

        leftPanel = new LeftPanel(this);
        rightPanel = new RightPanel(this);

        this.setLayout(new BorderLayout());
        this.add(BorderLayout.EAST,rightPanel);
        this.add(BorderLayout.WEST,leftPanel);

        ActionHandler handler = new ActionHandler();

    }



}
