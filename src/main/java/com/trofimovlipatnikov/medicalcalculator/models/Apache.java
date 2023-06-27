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
    private int paO2;
    private int gradientAA;
    private int serumBicarbonate;
    private int result;
    private int percLetal;

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
        return paO2;
    }

    public void setPaO2(int paO2) {
        this.paO2 = paO2;
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
                ", paO2=" + paO2 +
                ", gradientAA=" + gradientAA +
                ", serumBicarbonate=" + serumBicarbonate +
                '}';
    }
    public void setResult() {
        result = 0;

        if(age >= 45 && age <= 54) {
            result += 2;
        }
        else if(age >= 55 && age <= 64) {
            result+=3;
        }
        else if (age >= 65 && age <= 74) {
            result+=5;
        }
        else if(age > 74) {
            result+=6;
        }
        result +=value;

        if(rectalTemper > 40.9 || rectalTemper < 30) {
            result += 4;
        }
        else if((rectalTemper >= 39 && rectalTemper <= 40.9) || (rectalTemper >= 30 && rectalTemper < 32)) {
            result += 3;
        }
        else if((rectalTemper >= 38.5 && rectalTemper < 39) || (rectalTemper >= 34 && rectalTemper <= 35.9)) {
            result += 1;
        }
        else if(rectalTemper >= 32 && rectalTemper < 34) {
            result += 2;
        }

        if(avgBloodPressure > 159 || avgBloodPressure < 50) {
            result += 4;
        }
        else if(avgBloodPressure >= 130 && avgBloodPressure <= 159) {
            result += 3;
        }
        else if((avgBloodPressure >= 110 && avgBloodPressure < 129) || (avgBloodPressure >= 50 && avgBloodPressure <= 69)) {
            result += 2;
        }

        if(heartRate > 179 || heartRate < 40) {
            result += 4;
        }
        else if((heartRate >= 140 && heartRate <= 179) || (heartRate >= 40 && heartRate <= 54)) {
            result += 3;
        }
        else if((heartRate >= 110 && heartRate <= 139) || (heartRate >= 55 && heartRate <= 69)) {
            result += 2;
        }

        if(respiratoryRate > 49 || respiratoryRate < 6) {
            result += 4;
        }
        else if (respiratoryRate >= 35 && respiratoryRate <= 49) {
            result += 3;
        }
        else if((respiratoryRate > 24 && respiratoryRate <= 34) || (respiratoryRate == 10 || respiratoryRate == 11)) {
            result += 1;
        }
        else if(respiratoryRate >= 6 && respiratoryRate <= 9) {
            result += 2;
        }

        if (availableABGC){
            if (lowerFiO2) {
                if (paO2 < 55) {
                    result += 4;
                }
                else if (paO2 >= 55 && paO2 <= 60) {
                    result += 3;
                }
                else if (paO2 >= 61 && paO2 <= 70) {
                    result += 1;
                }
            }
            else {
                if (gradientAA > 499) {
                    result += 4;
                }
                else if (gradientAA >= 350 && gradientAA <= 499) {
                    result += 3;
                }
                else if (gradientAA >= 200 && gradientAA <= 349) {
                    result += 2;
                }
            }

            if (phArterialBlood > 7.69 || phArterialBlood < 7.15) {
                result += 4;
            }
            else if ((phArterialBlood >= 7.6 && phArterialBlood <= 7.69) || (phArterialBlood >= 7.15 && phArterialBlood < 7.25)) {
                result += 3;
            }
            else if (phArterialBlood >= 7.5 && phArterialBlood < 7.6) {
                result += 1;
            }
            else if (phArterialBlood >= 7.25 && phArterialBlood < 7.33) {
                result += 2;
            }
        }
        else {
            if(serumBicarbonate > 52 || serumBicarbonate < 15) {
                result += 4;
            }
            else if((serumBicarbonate >= 41 && serumBicarbonate <= 52) || (serumBicarbonate >= 15 && serumBicarbonate < 18)) {
                result += 3;
            }
            else if(serumBicarbonate >= 32 && serumBicarbonate < 41) {
                result += 2;
            }
            else if(serumBicarbonate >= 18 && serumBicarbonate < 22) {
                result += 1;
            }
        }

        if(serumSodium > 179 || serumSodium < 111) {
            result += 4;
        }
        else if((serumSodium >= 160 && serumSodium <= 179) || (serumSodium >= 111 && serumSodium <= 119)) {
            result += 3;
        }
        else if((serumSodium >= 155 && serumSodium <= 159) || (serumSodium >= 120 && serumSodium <= 129)) {
            result += 2;
        }
        else if(serumSodium >= 150 && serumSodium <= 154) {
            result += 1;
        }

        if(serumPotassium > 6.9 || serumPotassium < 2.5) {
            result += 4;
        }
        else if (serumPotassium >= 6 && serumPotassium <= 6.9) {
            result += 3;
        }
        else if (serumPotassium >= 2.5 && serumPotassium < 3) {
            result += 2;
        }
        else if((serumPotassium >= 5.5 && serumPotassium < 6) || (serumPotassium >= 3 && serumPotassium < 3.5)) {
            result += 1;
        }

        if(serumCreatinine > 300.56 && renalFailure) {
            result+=8;
        }
        else if ((serumCreatinine >= 176.8 && serumCreatinine <= 300.56) && renalFailure) {
            result += 6;
        }
        else if(serumCreatinine > 300.56 && !renalFailure) {
            result += 4;
        }
        else if ((serumCreatinine >= 132.6 && serumCreatinine < 176.8) && renalFailure) {
            result += 4;
        }
        else if ((serumCreatinine >= 176.8 && serumCreatinine <= 300.56) && !renalFailure) {
            result += 3;
        }
        else if (((serumCreatinine >= 132.6 && serumCreatinine <= 176.8) && !renalFailure) || serumCreatinine < 53.04) {
            result += 2;
        }

        if (percHematocrit > 59.9 || percHematocrit < 20) {
            result += 4;
        }
        else if ((percHematocrit >= 50 && percHematocrit <= 59.9) || (percHematocrit >= 20 && percHematocrit < 30)) {
            result += 2;
        }
        else if(percHematocrit >= 46 && percHematocrit < 50) {
            result += 1;
        }

        if(wbc > 39.9 || wbc < 1) {
            result += 4;
        }
        else if ((wbc >= 20 && wbc <= 39.9) || (wbc >= 1 && wbc < 3)) {
            result += 2;
        }
        else if (wbc >= 15 && wbc < 20) {
            result += 1;
        }

        result += 15 - gcs;
    }
    public void setPercLetal() {
        if(result <= 4) {
            percLetal = 4;
        }
        else if(result >= 5 && result <= 9) {
            percLetal = 8;
        }
        else if(result >= 10 && result <= 14) {
            percLetal = 15;
        }
        else if(result >= 15 && result <= 19) {
            percLetal = 25;
        }
        else if(result >= 20 && result <= 24) {
            percLetal = 40;
        }
        else if(result >= 25 && result <= 29) {
            percLetal = 55;
        }
        else if(result >= 30 && result <= 34) {
            percLetal = 75;
        }
        else {
            percLetal = 85;
        }
    }

    public int getPercLetal() {
        return percLetal;
    }

    public int getResult() {
        return result;
    }
}
