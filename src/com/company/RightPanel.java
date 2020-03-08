package com.company;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {
    static  Object[][] pData = {
            {"Klara Synowiec","a","a","a","a"},
            {"a","a","a","a","a"},
            {"a","a","a","a","a"},{"a","a","a","a","a"},
            {"a","a","a","a","a"},{"a","a","a","a","a"},
            {"a","a","a","a","a"},{"a","a","a","a","a"},
            {"a","a","a","a","a"},{"a","a","a","a","a"},
            {"a","a","a","a","a"},{"a","a","a","a","a"},
            {"a","a","a","a","a"},{"a","a","a","a","a"},
            {"a","a","a","a","a"},{"a","a","a","a","a"},
            {"a","a","a","a","a"},{"a","a","a","a","a"},
            {"a","a","a","a","a"},{"a","a","a","a","a"},
            {"a","a","a","a","a"},
            {"a","a","a","a","a"}
    };
    static String[] columnNames = {"Imię i nazwisko", "Płeć", "Pesel","Ubezpieczenie", "Badanie"};

    public RightPanel(JFrame parentFrame){
        this.setBackground(Color.lightGray);
        this.setPreferredSize(new Dimension(parentFrame.getBounds().width * 3 / 5, parentFrame.getBounds().height));
        this.setBorder(BorderFactory.createTitledBorder("Lista Pacjentów: "));




        JTable pTable = new JTable(pData,columnNames);
        pTable.setShowGrid(true);
        pTable.setGridColor(Color.BLACK);
        pTable.setRowHeight(40);
        pTable.getColumnModel().getColumn(0).setMinWidth(100);
        pTable.getColumnModel().getColumn(0).setMaxWidth(200);
        pTable.getColumnModel().getColumn(1).setMinWidth(100);
        pTable.getColumnModel().getColumn(1).setMaxWidth(200);
        pTable.getColumnModel().getColumn(2).setMinWidth(100);
        pTable.getColumnModel().getColumn(2).setMaxWidth(200);
//        this.add(pTable.getTableHeader());
//        this.add(pTable);

        JScrollPane scrollPane = new JScrollPane(pTable);
        pTable.setFillsViewportHeight(true);
        this.add(scrollPane);
        this.setLayout(new BorderLayout());
        this.add(pTable.getTableHeader(), BorderLayout.PAGE_START);
        this.add(pTable, BorderLayout.CENTER);
    }
}
