package com.trofimovlipatnikov.medicalcalculator.models.CalculatorModels;

public class Apache {

    //  Модель калькулятора Apache

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
    //  В задании было указано именно так получать информацию о калькуляторе, это не моя инициатива
    private String info = "<p class=\"big_text_info\">Об этом калькуляторе</p> <p class=\"text_info\">Прогноз летальности у пациентов в ОРИТ по шкале APACHE II (шкала оценки острых физиологических расстройств и хронических нарушений состояния II)</p>  <div> <p class=\"big_text_info\">Формула</p> <p class=\"text_info\">Сумма баллов по следующим критериям:</p> <table> <tbody><tr class=\"big_text_info\"> <th><span>Критерий</span></th> <th><span>Количество баллов</span></th> </tr> <tr class=\"big_text_info\"><td><span>Возраст, лет</span></td></tr><tr class=\"text_info\"><td>&lt;=44</td><td>0</td></tr><tr class=\"text_info\"><td>45-54</td><td>2</td></tr><tr class=\"text_info\"><td>55-64</td><td>3</td></tr><tr class=\"text_info\"><td>65-74</td><td>5</td></tr><tr class=\"text_info\"><td>&gt;74</td><td>6</td></tr><tr class=\"big_text_info\"><td><span>Тяжелая органная дисфункция или иммуносупрессия в анамнезе</span></td></tr><tr class=\"text_info\"><td>Нет</td><td>0</td></tr><tr class=\"text_info\"><td>Да, планово оперированные пациенты</td><td>2</td></tr><tr class=\"text_info\"><td>Да, неоперированные пациенты, оперированные по экстренным показаниям</td><td>5</td></tr><tr class=\"big_text_info\"><td><span>Ректальная температура, <sup>°</sup>C</span></td></tr><tr class=\"text_info\"><td>&gt;40.9</td><td>4</td></tr><tr class=\"text_info\"><td>39-40.9</td><td>3</td></tr><tr class=\"text_info\"><td>38.5-38.9</td><td>1</td></tr><tr class=\"text_info\"><td>36-38.4</td><td>0</td></tr><tr class=\"text_info\"><td>34-35.9</td><td>1</td></tr><tr class=\"text_info\"><td>32-33.9</td><td>2</td></tr><tr class=\"text_info\"><td>30-31.9</td><td>3</td></tr><tr class=\"text_info\"><td>&lt;30</td><td>4</td></tr><tr class=\"big_text_info\"><td><span>Среднее артериальное давление, мм Hg</span></td></tr><tr class=\"text_info\"><td>&gt;159</td><td>4</td></tr><tr class=\"text_info\"><td>130-159</td><td>3</td></tr><tr class=\"text_info\"><td>110-129</td><td>2</td></tr><tr class=\"text_info\"><td>70-109</td><td>0</td></tr><tr class=\"text_info\"><td>50-69</td><td>2</td></tr><tr class=\"text_info\"><td>&lt;50</td><td>4</td></tr><tr class=\"big_text_info\"><td><span>Частота сердечных сокращений, уд/мин</span></td></tr><tr class=\"text_info\"><td>&gt;179</td><td>4</td></tr><tr class=\"text_info\"><td>140-179</td><td>3</td></tr><tr class=\"text_info\"><td>110-139</td><td>2</td></tr><tr class=\"text_info\"><td>70-109</td><td>0</td></tr><tr class=\"text_info\"><td>55-69</td><td>2</td></tr><tr class=\"text_info\"><td>40-54</td><td>3</td></tr><tr class=\"text_info\"><td>&lt;40</td><td>4</td></tr><tr class=\"text_info\"><td colspan=\"2\"><span style=\"font-weight:bold\">Частота дыхания, дых/мин</span></td></tr><tr class=\"text_info\"><td>&gt;49</td><td>4</td></tr><tr class=\"text_info\"><td>35-49</td><td>3</td></tr><tr class=\"text_info\"><td>25-34</td><td>1</td></tr><tr class=\"text_info\"><td>12-24</td><td>0</td></tr><tr class=\"text_info\"><td>10-11</td><td>1</td></tr><tr class=\"text_info\"><td>6-9</td><td>2</td></tr><tr class=\"text_info\"><td>&lt;6</td><td>4</td></tr><tr class=\"big_text_info\"><td><span>Оксигенация</span> (если FiO<sub>2</sub> &lt; 0.5 - используется PaO<sub>2</sub>, мм Hg; если &gt;= 0.5 - A-a - градиент, мм Hg)</td></tr><tr class=\"text_info\"><td>A-a - градиент &gt;499</td><td>4</td></tr><tr class=\"text_info\"><td>A-a - градиент 350-499</td><td>3</td></tr><tr class=\"text_info\"><td>A-a - градиент 200-349</td><td>2</td></tr><tr class=\"text_info\"><td>A-a - градиент &lt;200 (если FiO<sub>2</sub> &gt; 0.49) или PaO<sub>2</sub> &gt;70 (если<span style=\"font-weight:bold\"> </span>FiO<sub>2</sub> &lt; 0.5)</td><td>0</td></tr><tr class=\"text_info\"><td>PaO<sub>2</sub> 61-70</td><td>1</td></tr><tr class=\"text_info\"><td>PaO<sub>2</sub> 55-60</td><td>3</td></tr><tr class=\"text_info\"><td>PaO<sub>2</sub> &lt;55</td><td>4</td></tr><tr class=\"big_text_info\"><td><span>pH артериальной крови</span></td></tr><tr class=\"text_info\"><td>&gt;7.69</td><td>4</td></tr><tr class=\"text_info\"><td>7.60-7.69</td><td>3</td></tr><tr class=\"text_info\"><td>7.50-7.59</td><td>1</td></tr><tr class=\"text_info\"><td>7.33-7.49</td><td>0</td></tr><tr class=\"text_info\"><td>7.25-7.32</td><td>2</td></tr><tr class=\"text_info\"><td>7.15-7.24</td><td>3</td></tr><tr class=\"text_info\"><td>&lt;7.15</td><td>4</td></tr><tr class=\"big_text_info\"><td><span>Натрий сыворотки, ммоль/л</span></td></tr><tr class=\"text_info\"><td>&gt;179</td><td>4</td></tr><tr class=\"text_info\"><td>160-179</td><td>3</td></tr><tr class=\"text_info\"><td>155-159</td><td>2</td></tr><tr class=\"text_info\"><td>150-154</td><td>1</td></tr><tr class=\"text_info\"><td>130-149</td><td>0</td></tr><tr class=\"text_info\"><td>120-129</td><td>2</td></tr><tr class=\"text_info\"><td>111-119</td><td>3</td></tr><tr class=\"text_info\"><td>&lt;111</td><td>4</td></tr><tr class=\"big_text_info\"><td><span>Калий сыворотки, ммоль/л</span></td></tr><tr class=\"text_info\"><td>&gt;6.9</td><td>4</td></tr><tr class=\"text_info\"><td>6-6.9</td><td>3</td></tr><tr class=\"text_info\"><td>5.5-5.9</td><td>1</td></tr><tr class=\"text_info\"><td>3.5-5.4</td><td>0</td></tr><tr class=\"text_info\"><td>3-3.4</td><td>1</td></tr><tr class=\"text_info\"><td>2.5-2.9</td><td>2</td></tr><tr class=\"text_info\"><td>&lt;2.5</td><td>4</td></tr><tr class=\"big_text_info\"><td><span>Креатинин сыворотки, мкмоль/л</span></td></tr><tr class=\"text_info\"><td>&gt;300.56 и ОПН</td><td>8</td></tr><tr class=\"text_info\"><td>176.8-300.56 и ОПН</td><td>6</td></tr><tr class=\"text_info\"><td>&gt;300.56 и ХПН</td><td>4</td></tr><tr class=\"text_info\"><td>132.6-176.7 и ОПН</td><td>4</td></tr><tr class=\"text_info\"><td>176.8-300.56 и ХПН</td><td>3</td></tr><tr class=\"text_info\"><td>132.6-176.7 и ХПН</td><td>2</td></tr><tr class=\"text_info\"><td>53.04-132.5</td><td>0</td></tr><tr class=\"text_info\"><td>&lt;53.04</td><td>2</td></tr><tr class=\"big_text_info\"><td><span>Гематокрит, %</span></td></tr><tr class=\"text_info\"><td>&gt;59.9</td><td>4</td></tr><tr class=\"text_info\"><td>50-59.9</td><td>2</td></tr><tr class=\"text_info\"><td>46-49.9</td><td>1</td></tr><tr class=\"text_info\"><td>30-45.9</td><td>0</td></tr><tr class=\"text_info\"><td>20-29.9</td><td>2</td></tr><tr class=\"text_info\"><td>&lt;20</td><td>4</td></tr><tr class=\"big_text_info\"><td><span>Лейкоциты, *10<sup>9</sup>/л</span></td></tr><tr class=\"text_info\"><td>&gt;39.9</td><td>4</td></tr><tr class=\"text_info\"><td>20-39.9</td><td>2</td></tr><tr class=\"text_info\"><td>15-19.9</td><td>1</td></tr><tr class=\"text_info\"><td>3.0-14.9</td><td>0</td></tr><tr class=\"text_info\"><td>1.0-2.9</td><td>2</td></tr><tr class=\"text_info\"><td>&lt;1.0</td><td>4</td></tr><tr><td><span class=\"big_text_info\">Шкала комы Глазго</span></td><td class=\"text_info\">15 - Оценка комы по Глазго</td></tr><tr><td class=\"text_info\"><span class=\"big_text_info\">Бикарбонат, ммоль/л.</span> Применяется, когда невозможно оценить газовый состав крови у пациентов с нормальной оксигенацией.</td></tr><tr class=\"text_info\"><td>&gt;52</td><td>4</td></tr><tr class=\"text_info\"><td>41-52</td><td>3</td></tr><tr class=\"text_info\"><td>32-40.9</td><td>1</td></tr><tr class=\"text_info\"><td>22-31.9</td><td>0</td></tr><tr class=\"text_info\"><td>18-21.9</td><td>2</td></tr><tr class=\"text_info\"><td>15-17.9</td><td>3</td></tr><tr class=\"text_info\"><td>&lt;15</td><td>4</td></tr></tbody></table><p class=\"text_info\">Тяжелая органная дисфункция подразумевает под собой (анамнестически, до текущей госпитализации):</p><p class=\"big_text_info\">Печень</p><ul class=\"text_info\"><li>Цирроз, подтвержденный биопсией</li><li>Подтвержденная портальная гипертензия (ПГ)</li><li>ЖК-кровотечение, ассоциированное с ПГ</li><li>Печеночная энцефалопатия, кома</li></ul><p class=\"big_text_info\">Сердце и сосуды</p><ul class=\"text_info\"><li>Сердечная недостаточность NYHA IV</li></ul><p class=\"big_text_info\">Дыхательная система</p><ul class=\"text_info\"><li>Хроническое рестриктивное, обструктивное или васкулярное заболевание, приведшеое к значительному ограничению физической активности, - неспособности подняться по лестнице или неспособности вести домашнее хозяйство.</li><li>Задокументированная хроническая гипоксия, гиперкапния, вторичная полицитемия, тяжелая легочная гипертензия (&gt;40 мм Hg), зависимость от респиратора.</li></ul><p class=\"big_text_info\">Почки</p><ul class=\"text_info\"><li>Программный гемодиализ</li></ul><p class=\"big_text_info\">Иммуносупрессия</p><ul><li class=\"text_info\">Пациент получал иммуносупрессиную терапию, снизившую его сопротивляемость к инфекции: химиотерапия, облучение, высокие дозы стероидов. Заболевания, снижающие сопротивляемость к инфекции: лейкемия, лимфома, ВИЧ и проч.</li></ul></div><div><p class=\"big_text_info\">Интерпретация</p><table><tbody><tr class=\"big_text_info\"><th>Оценка по шкале APACHE II</th><th>    Летальность, %</th></tr><tr class=\"text_info\"><td>0-4</td><td>4</td></tr><tr class=\"text_info\"><td>5-9</td><td>8</td></tr><tr class=\"text_info\"><td>10-14</td><td>15</td></tr><tr class=\"text_info\"><td>15-19</td><td>25</td></tr><tr class=\"text_info\"><td>20-24</td><td>40</td></tr><tr class=\"text_info\"><td>25-29</td><td>55</td></tr><tr class=\"text_info\"><td>30-34</td><td>75</td></tr><tr class=\"text_info\"><td>&gt;34</td><td>85</td></tr></tbody></table></div><div><p class=\"big_text_info\">Дополнительные сведения</p><p class=\"text_info\">Шкалы APACHE III и APACHE IV, несмотря на доскональную разработку и высокую прогностическую значимость, не получили широкого распространения по причине защиты их статистических методов авторским правом.</p><p class=\"text_info\">Шкала APACHE II может быть использована с целью информирования родственников пациента о вероятном исходе лечения и агрессивности терапии.</p><p class=\"text_info\">Все шкалы, применяемые в ОРИТ, должны быть периодически рекалиброваны для сответствия постоянно изменяющимся подходам в лечении и демографии.</p></div>";

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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

    //  Так работает вычисление результата в калькуляторе
    public void setResult() {
        result = 0;

        result += (age >= 45 && age <= 54) ? 2 :
                (age >= 55 && age <= 64) ? 3 :
                        (age >= 65 && age <= 74) ? 5 :
                                (age > 74) ? 6 :
                                        0;

        result += value;

        result += (rectalTemper > 40.9 || rectalTemper < 30) ? 4 :
                ((rectalTemper >= 39 && rectalTemper <= 40.9) || (rectalTemper >= 30 && rectalTemper < 32)) ? 3 :
                        ((rectalTemper >= 38.5 && rectalTemper < 39) || (rectalTemper >= 34 && rectalTemper <= 35.9)) ? 1 :
                                (rectalTemper >= 32 && rectalTemper < 34) ? 2 :
                                        0;

        result += (avgBloodPressure > 159 || avgBloodPressure < 50) ? 4 :
                (avgBloodPressure >= 130 && avgBloodPressure <= 159) ? 3 :
                        ((avgBloodPressure >= 110 && avgBloodPressure < 129) || (avgBloodPressure >= 50 && avgBloodPressure <= 69)) ? 2 :
                                0;

        result += (heartRate > 179 || heartRate < 40) ? 4 :
                ((heartRate >= 140 && heartRate <= 179) || (heartRate >= 40 && heartRate <= 54)) ? 3 :
                        ((heartRate >= 110 && heartRate <= 139) || (heartRate >= 55 && heartRate <= 69)) ? 2 :
                                0;

        result += (respiratoryRate > 49 || respiratoryRate < 6) ? 4 :
                (respiratoryRate >= 35 && respiratoryRate <= 49) ? 3 :
                        ((respiratoryRate > 24 && respiratoryRate <= 34) || (respiratoryRate == 10 || respiratoryRate == 11)) ? 1 :
                                (respiratoryRate >= 6 && respiratoryRate <= 9) ? 2 :
                                        0;


        if (availableABGC){
            if (lowerFiO2) {
                result += (paO2 < 55) ? 4 :
                        (paO2 >= 55 && paO2 <= 60) ? 3 :
                                (paO2 >= 61 && paO2 <= 70) ? 1 :
                                        0;

            }
            else {
                result += (gradientAA > 499) ? 4 :
                        (gradientAA >= 350 && gradientAA <= 499) ? 3 :
                                (gradientAA >= 200 && gradientAA <= 349) ? 2 :
                                        0;
            }

            result += (phArterialBlood > 7.69 || phArterialBlood < 7.15) ? 4 :
                    ((phArterialBlood >= 7.6 && phArterialBlood <= 7.69) || (phArterialBlood >= 7.15 && phArterialBlood < 7.25)) ? 3 :
                            (phArterialBlood >= 7.5 && phArterialBlood < 7.6) ? 1 :
                                    (phArterialBlood >= 7.25 && phArterialBlood < 7.33) ? 2 :
                                            0;
        }
        else {
            result += (serumBicarbonate > 52 || serumBicarbonate < 15) ? 4 :
                    ((serumBicarbonate >= 41 && serumBicarbonate <= 52) || (serumBicarbonate >= 15 && serumBicarbonate < 18)) ? 3 :
                            (serumBicarbonate >= 32 && serumBicarbonate < 41) ? 2 :
                                    (serumBicarbonate >= 18 && serumBicarbonate < 22) ? 1 :
                                            0;

        }

        result += (serumSodium > 179 || serumSodium < 111) ? 4 :
                ((serumSodium >= 160 && serumSodium <= 179) || (serumSodium >= 111 && serumSodium <= 119)) ? 3 :
                        ((serumSodium >= 155 && serumSodium <= 159) || (serumSodium >= 120 && serumSodium <= 129)) ? 2 :
                                (serumSodium >= 150 && serumSodium <= 154) ? 1 : 0;

        result += (serumPotassium > 6.9 || serumPotassium < 2.5) ? 4 :
                (serumPotassium >= 6 && serumPotassium <= 6.9) ? 3 :
                        (serumPotassium >= 2.5 && serumPotassium < 3) ? 2 :
                                ((serumPotassium >= 5.5 && serumPotassium < 6) || (serumPotassium >= 3 && serumPotassium < 3.5)) ? 1 : 0;

        result += (serumCreatinine > 300.56 && renalFailure) ? 8 :
                ((serumCreatinine >= 176.8 && serumCreatinine <= 300.56) && renalFailure) ? 6 :
                        (serumCreatinine > 300.56 && !renalFailure) ? 4 :
                                ((serumCreatinine >= 132.6 && serumCreatinine < 176.8) && renalFailure) ? 4 :
                                        ((serumCreatinine >= 176.8 && serumCreatinine <= 300.56) && !renalFailure) ? 3 :
                                                (((serumCreatinine >= 132.6 && serumCreatinine <= 176.8) && !renalFailure) || serumCreatinine < 53.04) ? 2 : 0;

        result += (percHematocrit > 59.9 || percHematocrit < 20) ? 4 :
                ((percHematocrit >= 50 && percHematocrit <= 59.9) || (percHematocrit >= 20 && percHematocrit < 30)) ? 2 :
                        (percHematocrit >= 46 && percHematocrit < 50) ? 1 : 0;

        result += (wbc > 39.9 || wbc < 1) ? 4 :
                ((wbc >= 20 && wbc <= 39.9) || (wbc >= 1 && wbc < 3)) ? 2 :
                        (wbc >= 15 && wbc < 20) ? 1 : 0;


        result += 15 - gcs;
    }
    public void setPercLetal() {
        percLetal = (result <= 4) ? 4 :
                (result >= 5 && result <= 9) ? 8 :
                        (result >= 10 && result <= 14) ? 15 :
                                (result >= 15 && result <= 19) ? 25 :
                                        (result >= 20 && result <= 24) ? 40 :
                                                (result >= 25 && result <= 29) ? 55 :
                                                        (result >= 30 && result <= 34) ? 75 :
                                                                85;

    }

    public int getPercLetal() {
        return percLetal;
    }

    public int getResult() {
        return result;
    }
}
