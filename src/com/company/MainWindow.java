package com.company;

import javax.swing.*;
import java.awt.*;
import javax.swing.UIManager.*;

//klasa mająca odpowiadać za główne  okno
public class MainWindow extends JFrame {
    static JButton b, b1, b2, b3;


    public MainWindow() {
        this.setTitle("Rejestracja wyników badań");
        this.setSize(1024, 768);
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);


        // panel odpowiedzialny za lewą strone, ma sie tu znaleźć blok Dane Pacjenta i Badanie
        JPanel lPanel = new JPanel(new BorderLayout());
        lPanel.setPreferredSize(new Dimension(getWidth() * 2 / 5, getHeight()));
        lPanel.setBackground(Color.lightGray);
        this.add(lPanel, BorderLayout.WEST);


        //panel Dane Pacjenta
        JPanel pdPanel = new JPanel();
        pdPanel.setBackground(Color.lightGray);
        pdPanel.setBorder(BorderFactory.createTitledBorder("Dane Pacjenta"));
//        pdPanel.setPreferredSize(new Dimension(getWidth(), this.getContentPane().getHeight() * 3 / 5));
        pdPanel.setBounds(30, 30, 40, 40);

        lPanel.add(pdPanel, BorderLayout.NORTH);

        JLabel getNameLabel = new JLabel("Imię: ");
        JTextField getNameTextField = new JTextField(10);
        JLabel getSurnameLabel = new JLabel("Nazwisko: ");
        JTextField getSurnameTextField = new JTextField(10);
        JLabel getPeselLabel = new JLabel("Pesel: ");
        JTextField getPeselTextField = new JTextField(10);

        JLabel getSexLabel = new JLabel("Płeć: ");
        JRadioButton getWomanRadioButton = new JRadioButton("Kobieta", false);
        JRadioButton getManRadioButton = new JRadioButton("Mężczyzna", false);
//        this.add(getWomanRadioButton);
//        this.add(getManRadioButton);

        JLabel getInsLabel = new JLabel("Ubezpieczenie");
        String[] ins_states = {"Prywatne", "Brak"};
        JComboBox<String> iComboBox = new JComboBox<>(ins_states);
//        iComboBox.setEditable(false);

        JButton spdButton = new JButton("Zapisz");
        JButton cpdButton = new JButton("Anuluj");
        spdButton.setMargin(new Insets(0,0,0,0));
        cpdButton.setMargin(new Insets(0,0,0,0));
        spdButton.setAlignmentX(LEFT_ALIGNMENT);
        cpdButton.setAlignmentX(LEFT_ALIGNMENT);
        GroupLayout patientDataLayout = new GroupLayout(pdPanel);
        pdPanel.setLayout(patientDataLayout);
        patientDataLayout.setAutoCreateGaps(true);

        //grupowanie po pionie
        patientDataLayout.setHorizontalGroup(patientDataLayout.createSequentialGroup().addGroup(patientDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(getNameLabel).addComponent(getSurnameLabel).addComponent(getPeselLabel).addComponent(getSexLabel).addComponent(getInsLabel).addGroup(patientDataLayout.createSequentialGroup().addComponent(spdButton).addComponent(cpdButton))).addGroup(patientDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(getNameTextField).addComponent(getSurnameTextField).addComponent(getPeselTextField).addGroup(patientDataLayout.createSequentialGroup().addComponent(getWomanRadioButton).addComponent(getManRadioButton)).addComponent(iComboBox)));
        //grupowanie po poziomie
        patientDataLayout.setVerticalGroup(patientDataLayout.createSequentialGroup().addGroup(patientDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(getNameLabel).addComponent(getNameTextField)).addGroup(patientDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(getSurnameLabel).addComponent(getSurnameTextField)).addGroup(patientDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(getPeselLabel).addComponent(getPeselTextField)).addGroup(patientDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(getSexLabel).addGroup(patientDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(getWomanRadioButton).addComponent(getManRadioButton))).addGroup(patientDataLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(getInsLabel).addComponent(iComboBox)).addGroup(patientDataLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(spdButton).addComponent(cpdButton)));

        ///DO OPRACOWANIA!
        //panel Badania
        JPanel examinationPanel = new JPanel(new BorderLayout());
        examinationPanel.setBackground(Color.lightGray);
        examinationPanel.setBorder(BorderFactory.createTitledBorder("Badanie"));
//        examinationPanel.setPreferredSize(new Dimension(getWidth(), this.getContentPane().getHeight() * 2 / 5));
        examinationPanel.setBounds(30, 30, 40, 40);
        b2 = new JButton("buttonx");
        b3 = new JButton("buttony");
        examinationPanel.add(b2, BorderLayout.NORTH);
//        examinationPanel.add(b3, BorderLayout.);
        lPanel.add(examinationPanel, BorderLayout.CENTER);


        //panel prawy
        JPanel rPanel = new JPanel(new BorderLayout());
        rPanel.setPreferredSize(new Dimension(getWidth() * 3 / 5, getHeight()));
        rPanel.setBorder(BorderFactory.createTitledBorder("Lista Pacjentów: "));
        rPanel.setBackground(Color.lightGray);
        this.add(rPanel, BorderLayout.EAST);
        JTable plTable = new JTable();
        rPanel.add(plTable);

    }

}
