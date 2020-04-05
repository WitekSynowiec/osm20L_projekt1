package com.company.gui.app_view;

import com.company.gui.app_controller.AppController;
import com.company.gui.app_model.PatientRegister;
import javax.swing.*;
import java.awt.*;

/**Klasa {@code AppView} głównego frame'u aplikacji
 * klasa jest zrealizowana przy pomocy funkcji i modułów klasy bazowej <code>JFrame<code/>>
 * składa się z trzech paneli, odpowiedzialnych odpowiednio:
 * 1) za obsługę danych pacjenta <code>PDPanel</code>
 * 2) za obsługę badań pacjenta <code>EPanel</code>
 * 3) za obsługę tabeli z rekordami pacjentów <code>PDPanel</code>
 * Klasa <code>PatientRegister</code> służy do przechowywania danych rekordów pacjentów
 * Klasa <code>ctrl</code> to klasa kontrolera odpowiedzialnego za obsługę zdarzeń w aplikacji.
*/

public class AppView extends JFrame {
    private PDPanel patientDataPanel;
    private EPanel examinationPanel;
    private TablePanel tablePanel;
    private PatientRegister patientRegister;
    private AppController ctrl;


    /**Jedyny konstruktor klasy {@code AppView} wymaga podania argumentu
     * w postaci obiektu klasy <code>PatientRegister</code>. Jest to realizacja
     * modelu MVC.
     * Uzasadniamy to koniecznością istnienia klasy przechowującej dane
     * do działania aplikacji. Tą klasę można łatwo zmienić w bardziej
     * zaawansowaną bazę danych, modyfikując ją.
    * */
    public AppView(PatientRegister register){

        this.doGui(register);
        ctrl = new AppController(this, patientRegister);
        setListeners(ctrl);
    }

    /**Metoda <code>doGui()<code/> odpowiedzialna jest za stworzenie widoku aplikacji. Metodę
     * <code>doGui()</code> realizujemy jako prywatną, gdyż sensu nie ma stosowanie jej
     * poza klasą <code>AppView</code>.
     */
    private void doGui(PatientRegister register)
    {
        this.setTitle("Aplikacja do obsługi rejestru pacjentów");
        getContentPane().setBackground(Color.lightGray);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        patientRegister =  register;
        patientDataPanel = new PDPanel();
        examinationPanel = new EPanel();
        tablePanel = new TablePanel(patientRegister);


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

    /**Metoda <code>setListeners()<code/> odpowiedzialna jest za ustawienie listener'ów,
     * na wszystkie możliwe modyfikowalne przez użytkownika pola i moduły. Metodę
     * <code>setListeners()</code> realizujemy jako prywatną gdyż nie ma potrzeby
     * udostępniania jej w zastosowaniach poza klasą <code>AppView</code>.
     */
    private void setListeners(AppController ctrl)
    {
        patientDataPanel.getCpdButton().addActionListener(ctrl);
        patientDataPanel.getSpdButton().addActionListener(ctrl);
        patientDataPanel.getGetManRadioButton().addActionListener(ctrl);
        patientDataPanel.getGetWomanRadioButton().addActionListener(ctrl);
        examinationPanel.getSeButton().addActionListener(ctrl);
        examinationPanel.getCeButton().addActionListener(ctrl);
        tablePanel.getAddButton().addActionListener(ctrl);
        tablePanel.getDelButton().addActionListener(ctrl);
        tablePanel.getTable().getSelectionModel().addListSelectionListener(ctrl);
        tablePanel.getTable().getModel().addTableModelListener(ctrl);
    }

    /**Metoda <code>getPDPanel()<code/> odpowiedzialna jest za wydanie obiektu panelu
     * <code>PDPanel<code/> na żądania wystosowane w innych klasach. Jest metodą publiczną
     * ze względu na dostępność w klasie kontrolera.*/
    public PDPanel getPDPanel(){
        return patientDataPanel;
    }

    /**Metoda <code>getEPanel()<code/> odpowiedzialna jest za wydanie obiektu panelu
     * <code>EPanel<code/> na żądania wystosowane w innych klasach. Jest metodą publiczną
     * ze względu na dostępność w klasie kontrolera.*/
    public EPanel getEPanel(){
        return examinationPanel;
    }

    /**Metoda <code>getTPanel()<code/> odpowiedzialna jest za wydanie obiektu panelu
     * <code>TPanel<code/> na żądania wystosowane w innych klasach. Jest metodą publiczną
     * ze względu na dostępność w klasie kontrolera.*/
    public TablePanel getTPanel(){
        return tablePanel;
    }

}
