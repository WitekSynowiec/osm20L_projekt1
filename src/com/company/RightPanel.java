package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RightPanel extends JPanel {
    Object[][] pData = {
            {"Klara Synowiec","a","a","a","a"},

    };
    static String[] columnNames = {"Imię i nazwisko", "Płeć", "Pesel","Ubezpieczenie", "Badanie"};
    static JButton button1  = new JButton("Dodaj");
    static JButton button2  = new JButton("Usuń");
    static JPanel southPanel;
    static JTable pTable;
    DefaultTableModel model;

    public RightPanel(JFrame parentFrame){
        this.setBackground(Color.lightGray);
        this.setPreferredSize(new Dimension(parentFrame.getBounds().width * 3 / 5, parentFrame.getBounds().height));
        this.setBorder(BorderFactory.createTitledBorder("Lista Pacjentów: "));

        southPanel = new JPanel();


//        pTable = new JTable(pData,columnNames);
        model = new DefaultTableModel();
        pTable = new JTable(model){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

// Create a couple of columns
        model.addColumn(columnNames[0]);
        model.addColumn(columnNames[1]);
        model.addColumn(columnNames[2]);
        model.addColumn(columnNames[3]);
        model.addColumn(columnNames[4]);

// Append a row
//        model.addRow(new Object[]{"v1", "v2"});

        pTable.setShowGrid(true);
        pTable.setGridColor(Color.BLACK);
//        pTable.setRowHeight(40);
//        pTable.getColumnModel().getColumn(0).setMinWidth(parentFrame.getWidth()/5);
//        pTable.getColumnModel().getColumn(1).setMinWidth(parentFrame.getWidth()/20);
//        pTable.getColumnModel().getColumn(2).setMinWidth(parentFrame.getWidth()/10);
//        pTable.getColumnModel().getColumn(3).setMinWidth(parentFrame.getWidth()/10);
//        pTable.getColumnModel().getColumn(4).setMinWidth(parentFrame.getWidth()/20);

//        pTable.getColumnModel().getColumn(0).

//        pTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//        this.add(pTable.getTableHeader());
//        this.add(pTable);

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
//        this.add(button2,BorderLayout.SOUTH);


//        leftPanel = new LeftPanel(this);
//        rightPanel = new RightPanel(this);
//
//        this.setLayout(new BorderLayout());
//        this.add(BorderLayout.NORTH,scrollPane);
//        this.add(BorderLayout.WEST,);
    }
}
