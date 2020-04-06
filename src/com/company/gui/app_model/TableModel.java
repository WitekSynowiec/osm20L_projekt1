package com.company.gui.app_model;

import javax.swing.table.AbstractTableModel;

/** Klasa {@code TableModel} obsługę model głównej tablicy używanej w apliakcji.
 * Klasa nie realizuje dziedziczenia po DefaultTableModel ale po AbstractTableModel.
 * Wynika to z prostszej implementacji w naszym zastosowaniu.
 * @author Janek Grzegorek
 * @author Witek Synowiec
 * */
public class TableModel extends AbstractTableModel {

    private PatientRegister register;
    private String[] colNames = {"Imię i nazwisko", "Płeć", "Pesel","Ubezpieczenie", "Badanie"};

    /** Konstruktor {@code TableModel} przyjmuje jeden parametr <code>t</code> klasy
     * <code>PatientRegister</code>. Jest to de facto instancja "bazy danych" pacjentów
     * na której operujemy.
     * */
    public TableModel(PatientRegister t){
        super();
        register = t;
    }

    public void insertData(PatientRegister t)
    {
        register = t;
    }

    /**Metoda <code>getRowCount</code> zwraca wielkość <code>register</code> zdefiniowanej w
     * implementacji klasy parametru. Jest ona (a przynajmneij powinna być) równa liczbie
     * wyświetlonych wierszy tablicy. Niezbędne jest zadbanie o to wykorzystując odpowiednie
     * metody inferfejsu <code>ListSelectionListener</code>.*/
    @Override
    public int getRowCount(){
        return register.getSize();
    }

    /**Metoda <code>getColumnCount</code> zwraca długość tablicy <code>colNames</code>.*/
    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    /**Metoda <code>getValueAt(int rowIndex, int columnIndex)</code> zwraca element
     * <code>register</code> o indeksie <code>rowIndex</code> a następnie w zależności od wartości
     * parametru  tablicy <code>colNames</code> zwraca dany element danych. Jest on (a przynajmniejj
     * powienien być równy odpowiadającemu elementowi w wyświetlonemu tabeli. Jeśli jest inaczej
     * jest to błąd. Należy zadbać aby ta równość była spełniona wykorzystując odpowiednie metody.
     * */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return register.getRecord(rowIndex).getFullName();
            case 1:
                return register.getRecord(rowIndex).getSex();
            case 2:
                return register.getRecord(rowIndex).getPesel();
            case 3:
                return register.getRecord(rowIndex).getIns().getIns();
            case 4:
                return register.getRecord(rowIndex).isExamined();
            default:
                return 0;
        }
    }

    /**Metoda <code>getColumnNames(int i)</code> zwraca element i-ty element tablicy <code>colNames</code>.*/
    @Override
    public String getColumnName(int i) {
        return colNames[i];
    }

    /**Metoda <code>getColumnClass(int columnIndex)</code> zwraca typ klasy przechowywany w wierszu
     * tablicy na pozycji <code>columnIndex</code>.*/
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }
}
