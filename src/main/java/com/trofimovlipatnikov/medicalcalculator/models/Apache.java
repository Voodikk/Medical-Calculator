package com.trofimovlipatnikov.medicalcalculator.models;

public class Apache {
    private int value;
    private boolean renalFailure;
    private int age;
    private double rectalTemper;
    private int avgBloodPressure;
    private int heartRate;
    private int respiratoryRate;
    private int serumSodium;
    private double serumPotassium;
    private int serumCreatinine;
    private int percHematocrit;
    private double wbc;
    private int gcs;
    private boolean availableABGC;
    private double phArterialBlood;
    private boolean lowerFiO2;
    private int PaO2;
    private int gradientAA;
    private int serumBicarbonate;

    public Apache() {}

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isRenalFailure() {
        return renalFailure;
    }

    public void setRenalFailure(boolean renalFailure) {
        this.renalFailure = renalFailure;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getRectalTemper() {
        return rectalTemper;
    }

    public void setRectalTemper(double rectalTemper) {
        this.rectalTemper = rectalTemper;
    }

    public int getAvgBloodPressure() {
        return avgBloodPressure;
    }

    public void setAvgBloodPressure(int avgBloodPressure) {
        this.avgBloodPressure = avgBloodPressure;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public int getSerumSodium() {
        return serumSodium;
    }

    public void setSerumSodium(int serumSodium) {
        this.serumSodium = serumSodium;
    }

    public double getSerumPotassium() {
        return serumPotassium;
    }

    public void setSerumPotassium(double serumPotassium) {
        this.serumPotassium = serumPotassium;
    }

    public int getSerumCreatinine() {
        return serumCreatinine;
    }

    public void setSerumCreatinine(int serumCreatinine) {
        this.serumCreatinine = serumCreatinine;
    }

    public int getPercHematocrit() {
        return percHematocrit;
    }

    public void setPercHematocrit(int percHematocrit) {
        this.percHematocrit = percHematocrit;
    }

    public double getWbc() {
        return wbc;
    }

    public void setWbc(double wbc) {
        this.wbc = wbc;
    }

    public int getGcs() {
        return gcs;
    }

    public void setGcs(int gcs) {
        this.gcs = gcs;
    }

    public boolean isAvailableABGC() {
        return availableABGC;
    }

    public void setAvailableABGC(boolean availableABGC) {
        this.availableABGC = availableABGC;
    }

    public double getPhArterialBlood() {
        return phArterialBlood;
    }

    public void setPhArterialBlood(double phArterialBlood) {
        this.phArterialBlood = phArterialBlood;
    }

    public boolean isLowerFiO2() {
        return lowerFiO2;
    }

    public void setLowerFiO2(boolean lowerFiO2) {
        this.lowerFiO2 = lowerFiO2;
    }

    public int getPaO2() {
        return PaO2;
    }

    public void setPaO2(int paO2) {
        PaO2 = paO2;
    }

    public int getGradientAA() {
        return gradientAA;
    }

    public void setGradientAA(int gradientAA) {
        this.gradientAA = gradientAA;
    }

    public int getSerumBicarbonate() {
        return serumBicarbonate;
    }

    public void setSerumBicarbonate(int serumBicarbonate) {
        this.serumBicarbonate = serumBicarbonate;
    }

    @Override
    public String toString() {
        return "Apache{" +
                "value=" + value +
                ", renalFailure=" + renalFailure +
                ", age=" + age +
                ", rectalTemper=" + rectalTemper +
                ", avgBloodPressure=" + avgBloodPressure +
                ", heartRate=" + heartRate +
                ", respiratoryRate=" + respiratoryRate +
                ", serumSodium=" + serumSodium +
                ", serumPotassium=" + serumPotassium +
                ", serumCreatinine=" + serumCreatinine +
                ", percHematocrit=" + percHematocrit +
                ", wbc=" + wbc +
                ", gcs=" + gcs +
                ", availableABGC=" + availableABGC +
                ", phArterialBlood=" + phArterialBlood +
                ", lowerFiO2=" + lowerFiO2 +
                ", PaO2=" + PaO2 +
                ", gradientAA=" + gradientAA +
                ", serumBicarbonate=" + serumBicarbonate +
                '}';
    }
}
