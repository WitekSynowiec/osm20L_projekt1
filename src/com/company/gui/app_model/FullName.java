package com.company.gui.app_model;


/**Klasa {@code FullName} jest dostosowaniem klasy <code>Pair</code>
 * do potrzeb przechowywania imienia i nazwiska. W tym celu zrealizowano
 * dziedziczenie po podanej klasie.
 * @author Janek Grzegorek
 * @author Witek Synowiec*/
public class FullName extends Pair {

    /**Konstruktor klasy {@code FullName} jest realizacją konstruktora
     * klasy <code>Pair</code> z poprawionymi danymi na wejściu.*/
    public FullName(String a, String b) {
        super(a,b);
        value1 = capitalize(a);
        value2 = capitalize(b);
    }

    /**Metoda <code>getFullName</code> zwraca obiekt klasy <code>StringBuilder</code>
     * zawierająca imię i nazwisko po spacji.*/

    public StringBuilder getFullName(){
        StringBuilder str = new StringBuilder();
        str.append(getValue1());
        str.append(" ");
        str.append(getValue2());
        return str;
    }

    /**Metoda <code>capitalize</code> zwraca obiekt klasy <code>String</code>
     * zawierająca imię i nazwisko poprawione tak, by pierwsza litera była
     * literą wieką, a pozostałe małymi..*/
    private String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    @Override
    public void setValue1(String v) {
        super.setValue1(capitalize(v));
    }

    @Override
    public void setValue2(String v) {
        super.setValue2(capitalize(v));
    }
}
