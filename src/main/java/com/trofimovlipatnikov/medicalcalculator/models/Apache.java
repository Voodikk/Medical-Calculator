package com.trofimovlipatnikov.medicalcalculator.models;

public class Apache {
    private int value;
    private boolean isRenalFailure;
    private int age;
    private double rectalTemper;
    private int avgBloodPressure;
    private int heartRate;
    private int respiratoryRate;
    private int serumSodium;
    private double serumPotassium;
    private int serumCreatinine;
    private int hematocrit;
    private int whiteBloodCells;
    private int ratingGlasgowComa;
    private boolean isAssessmentBloodGas;

    private double arterialBloodAcidity;
    private boolean isLowerFiO2;
    private int mmPaO2;
    private int gradientAA;

    private int serumBicarbonate;

    public Apache(){}
    public Apache(int value, boolean isRenalFailure, int age, double rectalTemper, int avgBloodPressure, int heartRate, int respiratoryRate, int serumSodium, double serumPotassium, int serumCreatinine, int hematocrit, int whiteBloodCells, int ratingGlasgowComa, boolean isAssessmentBloodGas, double arterialBloodAcidity, boolean isLowerFiO2, int mmHg) {
        this.value = value;
        this.isRenalFailure = isRenalFailure;
        this.age = age;
        this.rectalTemper = rectalTemper;
        this.avgBloodPressure = avgBloodPressure;
        this.heartRate = heartRate;
        this.respiratoryRate = respiratoryRate;
        this.serumSodium = serumSodium;
        this.serumPotassium = serumPotassium;
        this.serumCreatinine = serumCreatinine;
        this.hematocrit = hematocrit;
        this.whiteBloodCells = whiteBloodCells;
        this.ratingGlasgowComa = ratingGlasgowComa;
        this.isAssessmentBloodGas = isAssessmentBloodGas;
        this.arterialBloodAcidity = arterialBloodAcidity;
        this.isLowerFiO2 = isLowerFiO2;
        if(isLowerFiO2) {
            this.mmPaO2 = mmHg;
        }
        else {
            this.gradientAA = mmHg;
        }
    }

    public Apache(int value, boolean isRenalFailure, int age, double rectalTemper, int avgBloodPressure, int heartRate, int respiratoryRate, int serumSodium, double serumPotassium, int serumCreatinine, int hematocrit, int whiteBloodCells, int ratingGlasgowComa, boolean isAssessmentBloodGas, int serumBicarbonate) {
        this.value = value;
        this.isRenalFailure = isRenalFailure;
        this.age = age;
        this.rectalTemper = rectalTemper;
        this.avgBloodPressure = avgBloodPressure;
        this.heartRate = heartRate;
        this.respiratoryRate = respiratoryRate;
        this.serumSodium = serumSodium;
        this.serumPotassium = serumPotassium;
        this.serumCreatinine = serumCreatinine;
        this.hematocrit = hematocrit;
        this.whiteBloodCells = whiteBloodCells;
        this.ratingGlasgowComa = ratingGlasgowComa;
        this.isAssessmentBloodGas = isAssessmentBloodGas;
        this.serumBicarbonate = serumBicarbonate;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isRenalFailure() {
        return isRenalFailure;
    }

    public void setRenalFailure(boolean renalFailure) {
        isRenalFailure = renalFailure;
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

    public int getHematocrit() {
        return hematocrit;
    }

    public void setHematocrit(int hematocrit) {
        this.hematocrit = hematocrit;
    }

    public int getWhiteBloodCells() {
        return whiteBloodCells;
    }

    public void setWhiteBloodCells(int whiteBloodCells) {
        this.whiteBloodCells = whiteBloodCells;
    }

    public int getRatingGlasgowComa() {
        return ratingGlasgowComa;
    }

    public void setRatingGlasgowComa(int ratingGlasgowComa) {
        this.ratingGlasgowComa = ratingGlasgowComa;
    }

    public boolean isAssessmentBloodGas() {
        return isAssessmentBloodGas;
    }

    public void setAssessmentBloodGas(boolean assessmentBloodGas) {
        isAssessmentBloodGas = assessmentBloodGas;
    }

    public double getArterialBloodAcidity() {
        return arterialBloodAcidity;
    }

    public void setArterialBloodAcidity(double arterialBloodAcidity) {
        this.arterialBloodAcidity = arterialBloodAcidity;
    }

    public boolean isLowerFiO2() {
        return isLowerFiO2;
    }

    public void setLowerFiO2(boolean lowerFiO2) {
        isLowerFiO2 = lowerFiO2;
    }

    public int getMmPaO2() {
        return mmPaO2;
    }

    public void setMmPaO2(int mmPaO2) {
        this.mmPaO2 = mmPaO2;
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
                ", isRenalFailure=" + isRenalFailure +
                ", age=" + age +
                ", rectalTemper=" + rectalTemper +
                ", avgBloodPressure=" + avgBloodPressure +
                ", heartRate=" + heartRate +
                ", respiratoryRate=" + respiratoryRate +
                ", serumSodium=" + serumSodium +
                ", serumPotassium=" + serumPotassium +
                ", serumCreatinine=" + serumCreatinine +
                ", hematocrit=" + hematocrit +
                ", whiteBloodCells=" + whiteBloodCells +
                ", ratingGlasgowComa=" + ratingGlasgowComa +
                ", isAssessmentBloodGas=" + isAssessmentBloodGas +
                ", arterialBloodAcidity=" + arterialBloodAcidity +
                ", isLowerFiO2=" + isLowerFiO2 +
                ", mmPaO2=" + mmPaO2 +
                ", gradientAA=" + gradientAA +
                ", serumBicarbonate=" + serumBicarbonate +
                '}';
    }
}
