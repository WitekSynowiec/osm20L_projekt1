package com.company.gui.app_view;

import com.company.gui.app_model.PatientRegister;
import com.company.gui.app_model.TableModel;

import javax.swing.*;
import java.awt.*;

/**Klasa {@code TablePanel} odpowiada za panel obsługujący tablicę uwidaczniającą
 * dane pacjentów w bazie znajdujący się w głównym framie aplikacji.
 * Klasa jest zrealizowana przy pomocy funkcji i modułów klasy bazowej <code>JPanel</code>.
 * Składa się z tablicy oraz panelu "południowego" zawierającego przyciski do dodania pacjenta
 * bądź jego usunięcia. Ze względu na ładwość realizacji użyto do ustawienia tych komponentów
 * klasy BorderLayout.
 * @author Janek Grzegorek
 * @author Witek Synowiec
 */
public class TablePanel extends JPanel{
    private JButton button1  = new JButton("Dodaj");
    private JButton button2  = new JButton("Usuń");
    private JPanel southPanel;
    private JTable pTable;
    private TableModel model;

    public TablePanel(PatientRegister register){
        setBackground(Color.red);
        this.setBorder(BorderFactory.createTitledBorder("Lista Pacjentów: "));

        this.setBackground(Color.lightGray);
        this.setBorder(BorderFactory.createTitledBorder("Lista Pacjentów: "));

        southPanel = new JPanel();
        model = new TableModel(register);
        pTable = new JTable(model);
        pTable.setGridColor(Color.black);
        pTable.setShowGrid(true);

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
    public JButton getAddButton(){
        return button1;
    }
    public JButton getDelButton(){
        return button2;
    }

    public JTable getTable()
    {
        return pTable;
    }
    public TableModel getTableModel()
    {
        return model;
    }
}
