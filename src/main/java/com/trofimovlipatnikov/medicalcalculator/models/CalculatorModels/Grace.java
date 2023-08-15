package com.trofimovlipatnikov.medicalcalculator.models.CalculatorModels;

public class Grace {

    //  Модель калькулятора Grace

    private int age;
    private int heartRate;
    private int sbp;
    private double serumCreatinine;
    private boolean heartStop;
    private boolean segDeviationST;
    private boolean hloce;
    private int selectValue;

    private int result;

    //  В задании было указано именно так получать информацию о калькуляторе, это не моя инициатива
    private String info = "<div class=\"about\">     <h2>Об этом калькуляторе</h2>     <p>Оценка внутригоспитальной летальности и летальности в течение 6 месяцев после выписки у пациентов с ОКС по шкале GRACE (Global Registry of Acute Coronary Events)</p> 	<h3>Формула</h3> 	<div id=\"formula\">     <p>Оценка по шкале GRACE является суммой следующих параметров: </p> 		    <table>             <tbody>                 <tr>                     <td>                         <strong>Возраст</strong>                     </td>                     <td>     Баллы             </td>                     <td>     <strong>Частота сердечных сокращений, в мин.</strong>                     </td>                     <td>     Баллы             </td>                 </tr>                 <tr>                     <td>                         &lt;30                     </td>                     <td>                         0                     </td>                     <td>                         &lt;50                     </td>                     <td>                         0                     </td>                 </tr>                 <tr>                     <td>                         30 - 39                     </td>                     <td>                         8                     </td>                     <td>                         50 - 69                     </td>                     <td>                         3                     </td>                 </tr>                 <tr>                     <td>                         40 - 49                     </td>                     <td>                         25                     </td>                     <td>                         70 - 89                     </td>                     <td>                         9                     </td>                 </tr>                 <tr>                     <td>                         50 - 59                     </td>                     <td>                         41                     </td>                     <td>                         90 - 109                     </td>                     <td>                         15                     </td>                 </tr>                 <tr>                     <td>                         60 - 69                     </td>                     <td>                         58                     </td>                     <td>                         110 - 149                     </td>                     <td>                         24                     </td>                 </tr>                 <tr>                     <td>                         70 - 79                     </td>                     <td>                         75                     </td>                     <td>                         150 - 199                     </td>                     <td>                         38                     </td>                 </tr>                 <tr>                     <td>                         80 - 89                     </td>                     <td>                         91                     </td>                     <td>                         &gt;200                     </td>                     <td>                         46                     </td>                 </tr>                 <tr>                     <td>                         &gt;90                     </td>                     <td>                         100                     </td>                     <td>                         &gt;250                     </td>                     <td>                         46                     </td>                 </tr>                 <tr>                     <td>     <strong>Систолическое артериальное давление, мм. рт. ст.</strong>                     </td>                     <td>     Баллы             </td>                     <td>     <strong>Креатинин сыворотки крови, мкмоль/л</strong>                     </td>                     <td>     Баллы             </td>                 </tr>                 <tr>                     <td>                         &lt;80                     </td>                     <td>                         58                     </td>                     <td>                         &lt;35.36                     </td>                     <td>                         1                     </td>                 </tr>                 <tr>                     <td>                         80 - 99                     </td>                     <td>                         53                     </td>                     <td>                         35.36 - 70.71                     </td>                     <td>                         4                     </td>                 </tr>                 <tr>                     <td>                         100 - 119                     </td>                     <td>                         43                     </td>                     <td>                         70.72 - 106.07                     </td>                     <td>                         7                     </td>                 </tr>                 <tr>                     <td>                         120 - 139                     </td>                     <td>                         34                     </td>                     <td>                         106.08 - 141.43                     </td>                     <td>                         10                     </td>                 </tr>                 <tr>                     <td>                         140 - 159                     </td>                     <td>                         24                     </td>                     <td>                         141.43 - 176.7                     </td>                     <td>                         13                     </td>                 </tr>                 <tr>                     <td>                         160 - 199                     </td>                     <td>                         10                     </td>                     <td>                         176.8 - 353                     </td>                     <td>                         21                     </td>                 </tr>                 <tr>                     <td>                         &gt;200                     </td>                     <td>                         0                     </td>                     <td>                         &gt;=354                     </td>                     <td>                         28                     </td>                 </tr>             </tbody>         </table>         <table>             <thead>                 </thead><caption>     Тяжесть сердечной недостаточности по классификации Killip                 </caption>             <tbody>                 <tr>     <td>     Кардиогенный шок (IV)                     </td>                     <td>                         59                     </td>                 </tr>                 <tr>                     <td>     Острый отек легких (III)                     </td>                     <td>                         39                     </td>                 </tr>                 <tr>                     <td>     Наличие хрипов в легких и/или повышенного давления в югулярных венах (II)                     </td>                     <td>                         20                     </td>                 </tr>                 <tr>                     <td>     Отсутствие признаков застойной сердечной недостаточности (I)                     </td>                     <td>                         0                     </td>                 </tr>             </tbody>         </table>         <table>             <thead>                 </thead><caption>     Другие клинические параметры             </caption>             <tbody>                 <tr>     <td>     Остановка сердца (на момент поступления пациента)                     </td>                     <td>                         39                     </td>                 </tr>                 <tr>                     <td>     Отклонение сегмента ST             </td>                     <td>                         28                     </td>                 </tr>                 <tr>                     <td>     Наличие диагностически значимого повышения уровня кардиоспецифических ферментов             </td>                     <td>                         14                     </td>                 </tr>             </tbody>         </table> 	</div> 	<h3>Интерпретация</h3> 	<div id=\"interpret\"> 	<table>           <thead>               </thead><caption>     Острый коронрный синдром с подъемом сегмента ST             </caption>             <tbody>                 <tr>     <td>             Вид летальности                     </td>     <td>             Сумма баллов                     </td>                     <td>     Риск             </td>                     <td>     Летальность             </td>                 </tr>                 <tr>                     <td>     Внутригоспитальная             </td>                     <td>                         &lt; 126                     </td>                     <td>     Низкий             </td>                     <td>                         &lt; 2%                     </td>                 </tr>                 <tr>                     <td>     Внутригоспитальная             </td>                     <td>                         126 - 154                     </td>                     <td>     Средний             </td>                     <td>                         2 - 5%                     </td>                 </tr>                 <tr>                     <td>     Внутригоспитальная             </td>                     <td>                         &gt; 154                     </td>                     <td>     Высокий             </td>                     <td>                         &gt; 5%                     </td>                 </tr>                 <tr>                     <td>     В течение 6 месяцев             </td>                     <td>                         &lt; 100                     </td>                     <td>     Низкий             </td>                     <td>                         &lt; 4.5%                     </td>                 </tr>                 <tr>                     <td>     В течение 6 месяцев             </td>                     <td>                         100 - 127                     </td>                     <td>     Средний             </td>                     <td>                         4.5 - 11%                     </td>                 </tr>                 <tr>                     <td>     В течение 6 месяцев             </td>                     <td>                         &gt; 127                     </td>                     <td>     Высокий             </td>                     <td>                         &gt; 11%                     </td>                 </tr>         </tbody>         </table>        <table>            <thead>                </thead><caption>     Острый коронрный синдром без подъема ST                </caption>            <tbody>             <tr>     <td>             Вид летальности                 </td>     <td>             Сумма баллов                 </td>                 <td>     Риск             </td>                 <td>     Летальность             </td>             </tr>             <tr>                 <td>     Внутригоспитальная             </td>                 <td>                     &lt; 109                 </td>                 <td>     Низкий             </td>                 <td>                     &lt; 1%                 </td>             </tr>             <tr>                 <td>     Внутригоспитальная             </td>                 <td>                     109 - 140                 </td>                 <td>     Средний             </td>                 <td>                     1 - 3%                 </td>             </tr>             <tr>                 <td>     Внутригоспитальная             </td>                 <td>                     &gt; 140                 </td>                 <td>     Высокий             </td>                 <td>                     &gt; 3%                 </td>             </tr>             <tr>                 <td>     В течение 6 месяцев             </td>                 <td>                     &lt; 89                 </td>                 <td>     Низкий             </td>                 <td>                     &lt; 3%                 </td>             </tr>             <tr>                 <td>     В течение 6 месяцев             </td>                 <td>                     89 - 118                 </td>                 <td>     Средний             </td>                 <td>                     3 - 8%                 </td>             </tr>             <tr>                 <td>     В течение 6 месяцев             </td>                 <td>                     &gt; 118                 </td>                 <td>     Высокий             </td>                 <td>                     &gt; 8%                 </td>             </tr>         </tbody>     </table> 	</div> </div>";

    public Grace() {}

    public Grace(int age, int heartRate, int sbp, double serumCreatinine, boolean heartStop, boolean segDeviationST, boolean hloce, int selectValue) {
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

    public double getSerumCreatinine() {
        return serumCreatinine;
    }

    public void setSerumCreatinine(double serumCreatinine) {
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

    //  Вычисление результата калькулятора
    public void setResult() {
        result = 0;
        result += (age >= 30 && age <= 39) ? 8 :
                (age >= 40 && age <= 49) ? 25 :
                        (age >= 50 && age <= 59) ? 41 :
                                (age >= 60 && age <= 69) ? 58 :
                                        (age >= 70 && age <= 79) ? 75 :
                                                (age >= 80 && age <= 89) ? 91 :
                                                        (age >= 90) ? 100 :
                                                                0;


        result += (heartRate >= 50 && heartRate <= 69) ? 3 :
                (heartRate >= 70 && heartRate <= 89) ? 9 :
                        (heartRate >= 90 && heartRate <= 109) ? 15 :
                                (heartRate >= 110 && heartRate <= 149) ? 24 :
                                        (heartRate >= 150 && heartRate <= 199) ? 38 :
                                                (heartRate > 200) ? 46 :
                                                        0;


        result += (sbp < 80) ? 58 :
                (sbp >= 80 && sbp <= 99) ? 53 :
                        (sbp >= 100 && sbp <= 119) ? 43 :
                                (sbp >= 120 && sbp <= 139) ? 34 :
                                        (sbp >= 140 && sbp <= 159) ? 24 :
                                                (sbp >= 160 && sbp <= 199) ? 10 :
                                                        0;

        result += (serumCreatinine < 35.36) ? 1 :
                (serumCreatinine >= 35.36 && serumCreatinine <= 70.71) ? 4 :
                        (serumCreatinine >= 70.72 && serumCreatinine <= 106.07) ? 7 :
                                (serumCreatinine >= 106.08 && serumCreatinine <= 141.43) ? 10 :
                                        (serumCreatinine >= 141.44 && serumCreatinine <= 176.7) ? 13 :
                                                (serumCreatinine > 176.7 && serumCreatinine <= 353) ? 21 :
                                                        (serumCreatinine > 353) ? 28 :
                                                                0;

        if(heartStop) {
            result += 39;
        }
        if(segDeviationST) {
            result += 28;
        }
        if(hloce) {
            result += 14;
        }
        result += selectValue;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
