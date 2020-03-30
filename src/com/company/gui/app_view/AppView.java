package com.company.gui.app_view;

import com.company.gui.interfaces.ViewListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AppView extends JFrame{
    private LeftPanel leftPanel;
    private RightPanel rightPanel;
    private ViewListener listener;
    public AppView(){
        this.doGui();
//        ActionHandler handler = new ActionHandler();
    }
    private void doGui()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(1024, 768);
        leftPanel = new LeftPanel(this);
        rightPanel = new RightPanel(this);
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.EAST,rightPanel);
        this.add(BorderLayout.WEST,leftPanel);
        this.setBackground(Color.red);
    }
    public void setController(ActionListener a)
    {
//        leftPanel.pdPanel
    }
}
