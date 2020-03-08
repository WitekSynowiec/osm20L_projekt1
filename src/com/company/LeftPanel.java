package com.company;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {
    PDPanel pdPanel;
    EPanel ePanel;
    public LeftPanel(JFrame parentFrame){
        this.setPreferredSize(new Dimension(parentFrame.getWidth() * 2 / 5, parentFrame.getHeight()));
//        this.setBorder(BorderFactory.createTitledBorder("Lista Pacjentów: "));


        pdPanel = new PDPanel(parentFrame);
        ePanel = new EPanel(parentFrame);

        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, pdPanel);
        this.add(BorderLayout.CENTER, ePanel);
    }
}
