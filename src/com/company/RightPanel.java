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

        pTable.setShowGrid(true);
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
