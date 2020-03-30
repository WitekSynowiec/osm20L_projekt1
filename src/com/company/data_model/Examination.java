package com.company.data_model;

public class Examination {
    private float glucoseConcentration;
    private float amylaseConcentration;
    private float phosphateConcentration;

    public Examination(float glucoseConcentration, float amylaseConcentration, float phosphateConcentration) {
        this.glucoseConcentration = glucoseConcentration;
        this.amylaseConcentration = amylaseConcentration;
        this.phosphateConcentration = phosphateConcentration;
    }

    public float getGlucoseConcentration() {
        return glucoseConcentration;
    }

    public void setGlucoseConcentration(float glucoseConcentration) {
        this.glucoseConcentration = glucoseConcentration;
    }

    public float getAmylaseConcentration() {
        return amylaseConcentration;
    }

    public void setAmylaseConcentration(float amylaseConcentration) {
        this.amylaseConcentration = amylaseConcentration;
    }

    public float getPhosphateConcentration() {
        return phosphateConcentration;
    }

    public void setPhosphateConcentration(float phosphateConcentration) {
        this.phosphateConcentration = phosphateConcentration;
    }
}
