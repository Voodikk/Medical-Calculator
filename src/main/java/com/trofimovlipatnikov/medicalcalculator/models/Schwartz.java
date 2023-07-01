package com.trofimovlipatnikov.medicalcalculator.models;

public class Schwartz {

    private boolean gender;
    private int age;
    private double height;
    private double creat;
    private boolean race;
    private boolean idms;

    private int result;



    public String info = "<div class=\"about\">                   <p class=\"big_text_info\">Об этом калькуляторе</p>                   <p class=\"text_info\">Расчет скорости клубочковой фильтрации по модифицированной 4-х вариабельной формуле MDRD (Modification of diet in renal  disease).</p>                   <p class=\"text_info\">Для детей и подростков младше 19 лет используется формула Schwartz.</p>                   <p class=\"text_info\">Даннный калькулятор не следует использовать при остром повреждении почек.</p>                   <p class=\"text_info\">Также нужно помнить о том, что, согласно последним исследованиям, данные полученные с помощью формулы MDRD могут отличаться от реальных на ±29%.</p>                   <p class=\"text_info\">NKDEP рекомендует использовать для СКФ большей или равной 60 мл/мин/1.73 м<sup>2</sup> не точное число, но только 60 мл/мин/1.73 м<sup>2</sup>.</p>                   <p class=\"text_info\">Формула MDRD не проверялась у лиц старше 70 лет, поэтому результат ее использования у лиц данного возраста может быть не точен.</p>                   <p class=\"big_text_info\">Формула</p>                   <div id=\"formula\">                       <p class=\"text_info\">Оценка производится по следующим формулам:</p>                       <p class=\"text_info\">Для лиц старше 18 лет используется формула из исследования MDRD:</p>                       <p class=\"text_info\">СКФ (мл/мин/1.73 м<sup>2</sup>) = 175 x (Scr*IDMS/88.4)<sup>-1.154</sup> x (Возраст, лет)<sup>-0.203</sup> x (0.742 для женщин) x (1.212 для афроамериканцев) (в единицах СИ).</p>                       <p class=\"text_info\">Формула не требует веса пациента, так как результат приводится к 1.73 м<sup>2</sup>, что является общепринятой площадью поверности тела среднего взрослого.</p>                       <p class=\"text_info\">Для лиц возрастом равным 18 годам и менее используется формула Schwartz GJ (2009):</p>                       <p class=\"text_info\">СКФ (мл/мин/1.73 м<sup>2</sup>) = (36.2 × Рост, см) / Scr</p>                       <p class=\"text_info\">Сокращения:</p>                       <p class=\"text_info\">СКФ - скорость клубочковой фильтрации;</p>                       <p class=\"text_info\">Scr - кретинин сыворотки крови, мкмоль/л.</p>                       <p class=\"text_info\">IDMS - 1, если ваша лаборатория <strong>не</strong> использует метод дилюционной изотоп-масс-спектрометрии как метод определения креатинина в сыворотке крови, 0.95 - если использует.</p>                   </div>                   <p class=\"big_text_info\">Интерпретация</p>                   <div id=\"interpret\" class=\"interpret\">   <p>Значение скорости клубочковой фильтрации менее 60 мл/мин считается началом хронической болезни почек ввиду соответствия гибели более 50% нефронов.</p>                       <table>   <caption>Классификация хронической болезни почек Национального Почечного Фонда</caption>                           <tbody><tr>                               <th>Стадия</th>                               <th>Характеристика</th>                               <th>СКФ, мл/мин</th>   <th>Рекомендуемые мероприятия</th>                           </tr>                           <tr>                               <td></td>   <td>Наличие факторов риска<br>(АГ, СД, ХСН и т.д.)</td>                               <td>≥ 90</td>                               <td>Наблюдение, снижение риска развития патологии почек</td>                           </tr>                           <tr>                               <td>I</td>   <td>Поражение почек с нормальной или повышенной СКФ</td>                               <td>≥ 90</td>   <td>Лечение основного заболевания, замедление темпов развития и снижения риска<br>с/с осложнений</td>                           </tr>                           <tr>                               <td>II</td>   <td>Повреждение почек с умеренным снижением СКФ</td>                               <td>60-89</td>   <td>Оценка скорости прогрессирования</td>                           </tr>                           <tr>                               <td>III</td>   <td>Средняя степень снижения СКФ (а, b)</td>                               <td>30-59</td>   <td>Выявление и лечение осложнений</td>                           </tr>                           <tr>                               <td>IV</td>   <td>Выраженная степень снижения СКФ</td>                               <td>15-29</td>   <td>Подготовка к почечно-заместительной терапии, выбор метода ПЗТ<br></td>                           </tr>                           <tr>                               <td>V</td>   <td>Почечная недостаточность</td>                               <td>&lt; 15</td>                               <td>Почечно-заместительная терапия</td>                           </tr>                           </tbody></table>                       <table>                           <tbody><tr>                           </tr></tbody><caption>Референтные значения СКФ согласно NHANES III</caption>                           <tbody><tr><th>Возраст, лет<br></th>                               <th>СКФ, мл/мин/1.73 м<sup>2</sup><br></th>                           </tr>                           <tr>                               <td>20-29</td>                               <td>116</td>                           </tr>                           <tr>                               <td>30-39</td>                               <td>107</td>                           </tr>                           <tr>                               <td>40-49</td>                               <td>99</td>                           </tr>                           <tr>                               <td>50-59</td>                               <td>93</td>                           </tr>                           <tr>                               <td>60-69</td>                               <td>85</td>                           </tr>                           <tr>                               <td>70+</td>                               <td>75</td>                           </tr>                           </tbody></table>                   </div>               </div>";



    public Schwartz() {}



    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getCreat() {
        return creat;
    }

    public void setCreat(double creat) {
        this.creat = creat;
    }

    public boolean isRace() {
        return race;
    }

    public void setRace(boolean race) {
        this.race = race;
    }

    public boolean isIdms() {
        return idms;
    }

    public void setIdms(boolean idms) {
        this.idms = idms;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getResult() {
        return result;
    }




    public void setResult() {

    }
}
