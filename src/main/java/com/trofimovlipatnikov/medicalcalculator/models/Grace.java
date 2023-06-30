package com.trofimovlipatnikov.medicalcalculator.models;

public class Grace {
    private int age;
    private int heartRate;
    private int sbp;
    private int serumCreatinine;
    private boolean heartStop;
    private boolean segDeviationST;
    private boolean hloce;
    private int selectValue;

    private int result;

    //private String info = ;

    public Grace() {}

    public Grace(int age, int heartRate, int sbp, int serumCreatinine, boolean heartStop, boolean segDeviationST, boolean hloce, int selectValue) {
        this.age = age;
        this.heartRate = heartRate;
        this.sbp = sbp;
        this.serumCreatinine = serumCreatinine;
        this.heartStop = heartStop;
        this.segDeviationST = segDeviationST;
        this.hloce = hloce;
        this.selectValue = selectValue;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getSbp() {
        return sbp;
    }

    public void setSbp(int sbp) {
        this.sbp = sbp;
    }

    public int getSerumCreatinine() {
        return serumCreatinine;
    }

    public void setSerumCreatinine(int serumCreatinine) {
        this.serumCreatinine = serumCreatinine;
    }

    public boolean isHeartStop() {
        return heartStop;
    }

    public void setHeartStop(boolean heartStop) {
        this.heartStop = heartStop;
    }

    public boolean isSegDeviationST() {
        return segDeviationST;
    }

    public void setSegDeviationST(boolean segDeviationST) {
        this.segDeviationST = segDeviationST;
    }

    public boolean isHloce() {
        return hloce;
    }

    public void setHloce(boolean hloce) {
        this.hloce = hloce;
    }

    public int getSelectValue() {
        return selectValue;
    }

    public void setSelectValue(int selectValue) {
        this.selectValue = selectValue;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

}
