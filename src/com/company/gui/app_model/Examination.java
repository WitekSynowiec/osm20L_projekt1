package com.company.gui.app_model;

import java.util.Date;

/**Klasa {@code Examination} odpowiada za przechowanie i obsługę badań pacjentów.
 *
 * */
public class Examination {
    private float glucoseConcentration;
    private float amylaseConcentration;
    private float phosphateConcentration;
    private Date examinationDate;


    /**Jedyny konstruktor klasy <code>Examination</code> to konstruktor zwykły,
     * przyjmujący za argumenty wskaźniki na wszystkie elementy przechowujące stan
     * badań. Wynika to z faktu że nie ma sensu tworzyć obiektu klasy z wybrakowanymi danymi.
     * */
    public Examination(Float glucoseConcentration, Float amylaseConcentration, Float phosphateConcentration, Date d) {
        this.glucoseConcentration = glucoseConcentration;
        this.amylaseConcentration = amylaseConcentration;
        this.phosphateConcentration = phosphateConcentration;
        this.examinationDate = d;
    }

    /**Funkcja <code>getGlucoseConcentration()<code/> podaje na wyjście koncentracje glukozy
     * we krwi jako obiekt klasy <code>Float<code/>.*/
    public Float getGlucoseConcentration() {
        return glucoseConcentration;
    }

    /**Funkcja <code>setGlucoseConcentration()<code/> ustawia parametr {@param glucoseConcentration}.*/
    public void setGlucoseConcentration(Float glucoseConcentration) {
        this.glucoseConcentration = glucoseConcentration;
    }

    /**Funkcja <code>getAmylaseConcentration()<code/> podaje na wyjście koncentracje amylazy
     * we krwi jako obiekt klasy <code>Float<code/>.*/
    public Float getAmylaseConcentration() {
        return amylaseConcentration;
    }

    /**Funkcja <code>setAmylaseConcentration()<code/> ustawia parametr {@param amylaseConcentration}.*/
    public void setAmylaseConcentration(float amylaseConcentration) {
        this.amylaseConcentration = amylaseConcentration;
    }

    /**Funkcja <code>getPhosphateConcentration()<code/> podaje na wyjście koncentracje fosforanów
     * we krwi jako obiekt klasy <code>Float<code/>.*/
    public Float getPhosphateConcentration() {
        return phosphateConcentration;
    }

    /**Funkcja <code>setPhosphateConcentration()<code/> ustawia parametr {@param phosphateConcentration}.*/
    public void setPhosphateConcentration(float phosphateConcentration) {
        this.phosphateConcentration = phosphateConcentration;
    }

    /**Funkcja <code>getExaminationDate()<code/> podaje na wyjście datę wykonania badania
     * we krwi jako obiekt klasy <code>Date<code/>.*/
    public Date getExaminationDate() {
        return examinationDate;
    }

    /**Funkcja <code>SetExaminationDate()<code/> ustawia parametr {@param examinationDate}.*/
    public void setExaminationDate(Date date) {
        this.examinationDate = date;
    }

    }
