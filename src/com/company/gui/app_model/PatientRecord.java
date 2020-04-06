package com.company.gui.app_model;

/** Klasa {@code PatientRecord} odpowiada za przechowanie i obsługę danych pacjenta.
 * i ich badań. Jej parametry są parametrami danych pacjenta {@param fullName},
 * {@param pesel}, {@param sex}, {@param ins}, oraz jego badania {@param examination}.
 * */
public class PatientRecord {
    private FullName fullName;
    private String pesel;
    private Sex sex;
    private Insurance ins;
    private Examination examination;


    /**Jedyny konstruktor klasy <code>PatientRecord</code> to konstruktor zwykły,
     * przyjmujący za argumenty wskaźniki na wszystkie elementy danych pacjenta.
     * Wynika to z faktu że nie ma sensu tworzyć obiektu klasy z wybrakowanymi danymi.
     * Parametr {@param examination} jest domyślnie ustawiony na null. Jest to motywowane
     * faktem że najpierw pacjent musi być dodany żeby przeprowadzić mu badanie.
     * */
    public PatientRecord(String _name, String _surname, String _pesel, Sex _sex, Insurance _ins){
        this.fullName = new FullName(_name,_surname);
        pesel = _pesel;
        sex = _sex;
        ins = _ins;
        examination = null;
    }
    /**Metody realizujące funkcje getterów i setterów pól klasy <code>PatientRecord<code/>*/
    public String getName() {
        return fullName.getValue1();
    }

    public void setName(String name) {
        this.fullName.setValue1(name);
    }

    public String getSurname() {
        return fullName.getValue2();
    }

    public void setSurname(String surname) {
        this.fullName.setValue2(surname);
    }

    public StringBuilder getFullName(){
        return fullName.getFullName();
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Insurance getIns() {
        return ins;
    }

    public void setIns(Insurance ins) {
        this.ins = ins;
    }

    public Examination getExamination() {
        return examination;
    }

    public void setExamination(Examination examination) {
        this.examination = examination;
    }

    /**Metoda <code>isExamined<code/> ma na celu poinformowanie
     * żądającego czy dany pacjent ma wykonane badanie. Jeśli ma
     * funkcja zwraca true, w p.p false.*/
    public Boolean isExamined(){
        if (examination == null)
            return Boolean.FALSE;
        else
            return Boolean.TRUE;
    }

    /** Metoda <code>set<code/> ustawia wszystkie parametry klasy na parametru podanej
     * jako argument klasy <code>PatientRecord<code/>. */
    public void set(PatientRecord record) {
        this.setName(record.getName());
        this.setSurname(record.getSurname());
        this.setPesel(record.getPesel());
        this.setSex(record.getSex());
        this.setIns(record.getIns());
        this.setExamination(record.getExamination());
    }

    /** Metoda <code>equals<code/> definiuje równość dwóch rekordów pacjentów. Zachodzi
     * ona wtedy, kiedy obaj pacjenci mają ten sam numer pesel. */
    public boolean equals(PatientRecord record){
        return record.getPesel().equals(pesel);
    }
}
