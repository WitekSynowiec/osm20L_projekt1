package com.company.gui.app_model;

import java.util.Date;

public class Examination {
    private float glucoseConcentration;
    private float amylaseConcentration;
    private float phosphateConcentration;
    private Date examinationDate;


    public Float getGlucoseConcentration() {
        return glucoseConcentration;
    }

    public void setGlucoseConcentration(float glucoseConcentration) {
        this.glucoseConcentration = glucoseConcentration;
    }

    public Float getAmylaseConcentration() {
        return amylaseConcentration;
    }

    public void setAmylaseConcentration(float amylaseConcentration) {
        this.amylaseConcentration = amylaseConcentration;
    }

    public Float getPhosphateConcentration() {
        return phosphateConcentration;
    }

    public void setPhosphateConcentration(float phosphateConcentration) {
        this.phosphateConcentration = phosphateConcentration;
    }

    public Date getExaminationDate() {
        return examinationDate;
    }

    public void setExaminationDate(Date date) {
        this.examinationDate = date;
    }



    public Examination(Float glucoseConcentration, Float amylaseConcentration, Float phosphateConcentration, Date d) {
        this.glucoseConcentration = glucoseConcentration;
        this.amylaseConcentration = amylaseConcentration;
        this.phosphateConcentration = phosphateConcentration;
        this.examinationDate = d;
    }

    }
