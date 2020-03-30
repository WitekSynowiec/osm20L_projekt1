package com.company.gui.app_view;

import com.company.gui.app_view.LeftPanel;
import com.company.gui.app_view.RightPanel;
import com.company.gui.interfaces.ViewListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame{
    private LeftPanel leftPanel;
    private RightPanel rightPanel;
    private ViewListener listener;
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

//        ActionHandler handler = new ActionHandler();

    }


//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource()==this.mIncrementButton)
//            this.mListener.viewChanged(this,"Increment");
//        else if (e.getSource()==this.mDecrementButton)
//            this.mListener.viewChanged(this,"Decrement");
//    }
}
