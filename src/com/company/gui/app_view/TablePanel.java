package com.company.gui.app_view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TablePanel extends JPanel{

    Object[][] pData = {
            {"Klara Synowiec","a","a","a","a"},

    };
    JButton button1  = new JButton("Dodaj");
    JButton button2  = new JButton("Usuń");
    JPanel southPanel;
    JTable pTable;
    TableModel model;

    public TablePanel(){
        setBackground(Color.red);
        this.setBorder(BorderFactory.createTitledBorder("Lista Pacjentów: "));

        this.setBackground(Color.lightGray);
        this.setBorder(BorderFactory.createTitledBorder("Lista Pacjentów: "));

        southPanel = new JPanel();
        model = new TableModel();
        pTable = new JTable(model);


        pTable.setShowGrid(true);
//        pTable.setShowHorizontalLines();
        pTable.setGridColor(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(pTable);
        pTable.setFillsViewportHeight(true);
        this.add(scrollPane);

        this.setLayout(new BorderLayout());
        this.add(pTable.getTableHeader(), BorderLayout.PAGE_START);
        this.add(pTable, BorderLayout.CENTER);

        southPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        southPanel.setBackground(Color.lightGray);
        southPanel.add(button1);
        southPanel.add(button2);
        this.add(southPanel,BorderLayout.SOUTH);
    }
}
