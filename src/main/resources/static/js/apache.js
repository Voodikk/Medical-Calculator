$(document).ready(function (){
    $('#lowerFiO2').change(function(){
        if(this.checked){
            $('#paO2d').css("display", "block");
            $('#gradientAAd').css("display", "none");
            document.getElementById('paO2').setAttribute('required', '');
            $('#gradientAA').removeAttr('required');
        }
        else{
            $('#paO2d').css("display", "none");
            $('#gradientAAd').css("display", "block");
            $('#paO2').removeAttr('required');
            document.getElementById('gradientAA').setAttribute('required', '');
        }
    });
    $('#availableABGC').change(function(){
        if(this.checked){
            $('#hiddenABGCcheck').css("display", "block");
            $('#serumBicarbonated').css("display", "none");
            document.getElementById('phArterialBlood').setAttribute('required', '');
            $('#serumBicarbonate').removeAttr('required');
            if(document.getElementById('lowerFiO2').checked){
                document.getElementById('paO2').setAttribute('required', '');
                $('#gradientAA').removeAttr('required');
            }
            else {
                $('#paO2').removeAttr('required');
                document.getElementById('gradientAA').setAttribute('required', '');
            }
        }
        else{
            $('#hiddenABGCcheck').css("display", "none");
            $('#serumBicarbonated').css("display", "block");
            $('#phArterialBlood').removeAttr('required');
            $('#paO2').removeAttr('required');
            $('#gradientAA').removeAttr('required');
            document.getElementById('serumBicarbonate').setAttribute('required', '');
        }
    });
})

function sendForm() {
    let form = $("#form");
    let data = {
        value: form.find("select[name='value']").val(),
        renalFailure: $('#checkboxIsRenalFailure').is(":checked"),
        age: form.find("input[name='age']").val(),
        rectalTemper: form.find("input[name='rectalTemper']").val(),
        avgBloodPressure: form.find("input[name='avgBloodPressure']").val(),
        heartRate: form.find("input[name='heartRate']").val(),
        respiratoryRate: form.find("input[name='respiratoryRate']").val(),
        serumSodium: form.find("input[name='serumSodium']").val(),
        serumPotassium: form.find("input[name='serumPotassium']").val(),
        serumCreatinine: form.find("input[name='serumCreatinine']").val(),
        percHematocrit: form.find("input[name='percHematocrit']").val(),
        wbc: form.find("input[name='wbc']").val(),
        gcs: form.find("input[name='gcs']").val(),
        availableABGC: $('#availableABGC').is(":checked"),
        phArterialBlood:form.find("input[name='phArterialBlood']").val() == null ? 0 : form.find("input[name='phArterialBlood']").val(),
        lowerFiO2:$('#lowerFiO2').is(":checked"),
        paO2: form.find("input[name='paO2']").val() == null ? 0 : form.find("input[name='paO2']").val(),
        gradientAA: form.find("input[name='gradientAA']").val() == null ? 0 : form.find("input[name='gradientAA']").val(),
        serumBicarbonate: form.find("input[name='serumBicarbonate']").val() == null ? 0 : form.find("input[name='serumBicarbonate']").val()
    };
    $.ajax({
        url: "http://localhost:8080/apache/result",
        type: "POST",
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data),
        success: function(information) {
            console.log(information.result, information.percLetal);
        },
        error: function(request,msg,error) {
            // обработка ошибки отправки формы
        }
    });

    return false; // отмена действия по умолчанию
}
document.addEventListener('DOMContentLoaded', function() {
    var htmlCode = '<p class="big_text_info">Об этом калькуляторе</p>\n' +
        '                    <p class="text_info">Прогноз летальности у пациентов в ОРИТ по шкале APACHE II (шкала оценки острых физиологических расстройств и хронических нарушений состояния II)</p>\n' +
        '                    <div>\n' +
        '                        <p class="big_text_info">Формула</p>\n' +
        '                        <p class="text_info">Сумма баллов по следующим критериям:</p>\n' +
        '                        <table>\n' +
        '                            <tbody><tr class="big_text_info">\n' +
        '                                <th><span>Критерий</span></th>\n' +
        '                                <th><span>Количество баллов</span></th>\n' +
        '                            </tr>\n' +
        '                            <tr class="big_text_info">\n' +
        '                                <td><span>Возраст, лет</span></td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&lt;=44</td>\n' +
        '                                <td>0</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>45-54</td>\n' +
        '                                <td>2</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>55-64</td>\n' +
        '                                <td>3</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>65-74</td>\n' +
        '                                <td>5</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&gt;74</td>\n' +
        '                                <td>6</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="big_text_info">\n' +
        '                                <td><span>Тяжелая органная дисфункция или иммуносупрессия в анамнезе</span></td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>Нет</td>\n' +
        '                                <td>0</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>Да, планово оперированные пациенты</td>\n' +
        '                                <td>2</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>Да, неоперированные пациенты, оперированные по экстренным показаниям</td>\n' +
        '                                <td>5</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="big_text_info">\n' +
        '                                <td><span>Ректальная температура, <sup>°</sup>C</span></td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&gt;40.9</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>39-40.9</td>\n' +
        '                                <td>3</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>38.5-38.9</td>\n' +
        '                                <td>1</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>36-38.4</td>\n' +
        '                                <td>0</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>34-35.9</td>\n' +
        '                                <td>1</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>32-33.9</td>\n' +
        '                                <td>2</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>30-31.9</td>\n' +
        '                                <td>3</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&lt;30</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="big_text_info">\n' +
        '                                <td><span>Среднее артериальное давление, мм Hg</span></td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&gt;159</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>130-159</td>\n' +
        '                                <td>3</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>110-129</td>\n' +
        '                                <td>2</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>70-109</td>\n' +
        '                                <td>0</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>50-69</td>\n' +
        '                                <td>2</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&lt;50</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="big_text_info">\n' +
        '                                <td><span>Частота сердечных сокращений, уд/мин</span></td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&gt;179</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>140-179</td>\n' +
        '                                <td>3</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>110-139</td>\n' +
        '                                <td>2</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>70-109</td>\n' +
        '                                <td>0</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>55-69</td>\n' +
        '                                <td>2</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>40-54</td>\n' +
        '                                <td>3</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&lt;40</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td colspan="2"><span style="font-weight:bold">Частота дыхания, дых/мин</span></td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&gt;49</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>35-49</td>\n' +
        '                                <td>3</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>25-34</td>\n' +
        '                                <td>1</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>12-24</td>\n' +
        '                                <td>0</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>10-11</td>\n' +
        '                                <td>1</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>6-9</td>\n' +
        '                                <td>2</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&lt;6</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="big_text_info">\n' +
        '                                <td><span>Оксигенация</span> (если FiO<sub>2</sub> &lt; 0.5 - используется PaO<sub>2</sub>, мм Hg; если &gt;= 0.5 - A-a - градиент, мм Hg)</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>A-a - градиент &gt;499</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>A-a - градиент 350-499</td>\n' +
        '                                <td>3</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>A-a - градиент 200-349</td>\n' +
        '                                <td>2</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>A-a - градиент &lt;200 (если FiO<sub>2</sub> &gt; 0.49) или PaO<sub>2</sub> &gt;70 (если<span style="font-weight:bold"> </span>FiO<sub>2</sub> &lt; 0.5)</td>\n' +
        '                                <td>0</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>PaO<sub>2</sub> 61-70</td>\n' +
        '                                <td>1</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>PaO<sub>2</sub> 55-60</td>\n' +
        '                                <td>3</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>PaO<sub>2</sub> &lt;55</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="big_text_info">\n' +
        '                                <td><span>pH артериальной крови</span></td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&gt;7.69</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>7.60-7.69</td>\n' +
        '                                <td>3</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>7.50-7.59</td>\n' +
        '                                <td>1</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>7.33-7.49</td>\n' +
        '                                <td>0</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>7.25-7.32</td>\n' +
        '                                <td>2</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>7.15-7.24</td>\n' +
        '                                <td>3</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&lt;7.15</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="big_text_info">\n' +
        '                                <td><span>Натрий сыворотки, ммоль/л</span></td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&gt;179</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>160-179</td>\n' +
        '                                <td>3</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>155-159</td>\n' +
        '                                <td>2</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>150-154</td>\n' +
        '                                <td>1</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>130-149</td>\n' +
        '                                <td>0</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>120-129</td>\n' +
        '                                <td>2</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>111-119</td>\n' +
        '                                <td>3</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&lt;111</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="big_text_info">\n' +
        '                                <td><span>Калий сыворотки, ммоль/л</span></td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&gt;6.9</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>6-6.9</td>\n' +
        '                                <td>3</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>5.5-5.9</td>\n' +
        '                                <td>1</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>3.5-5.4</td>\n' +
        '                                <td>0</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>3-3.4</td>\n' +
        '                                <td>1</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>2.5-2.9</td>\n' +
        '                                <td>2</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&lt;2.5</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="big_text_info">\n' +
        '                                <td><span>Креатинин сыворотки, мкмоль/л</span></td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&gt;300.56 и ОПН</td>\n' +
        '                                <td>8</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>176.8-300.56 и ОПН</td>\n' +
        '                                <td>6</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&gt;300.56 и ХПН</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>132.6-176.7 и ОПН</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>176.8-300.56 и ХПН</td>\n' +
        '                                <td>3</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>132.6-176.7 и ХПН</td>\n' +
        '                                <td>2</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>53.04-132.5</td>\n' +
        '                                <td>0</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&lt;53.04</td>\n' +
        '                                <td>2</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="big_text_info">\n' +
        '                                <td><span>Гематокрит, %</span></td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&gt;59.9</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>50-59.9</td>\n' +
        '                                <td>2</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>46-49.9</td>\n' +
        '                                <td>1</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>30-45.9</td>\n' +
        '                                <td>0</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>20-29.9</td>\n' +
        '                                <td>2</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&lt;20</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="big_text_info">\n' +
        '                                <td><span>Лейкоциты, *10<sup>9</sup>/л</span></td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&gt;39.9</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>20-39.9</td>\n' +
        '                                <td>2</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>15-19.9</td>\n' +
        '                                <td>1</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>3.0-14.9</td>\n' +
        '                                <td>0</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>1.0-2.9</td>\n' +
        '                                <td>2</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&lt;1.0</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr>\n' +
        '                                <td><span class="big_text_info">Шкала комы Глазго</span></td>\n' +
        '                                <td class="text_info">15 - Оценка комы по Глазго</td>\n' +
        '                            </tr>\n' +
        '                            <tr>\n' +
        '                                <td class="text_info">\n' +
        '                                    <span class="big_text_info">Бикарбонат, ммоль/л.</span> Применяется, когда невозможно оценить газовый состав крови у пациентов с нормальной оксигенацией.\n' +
        '                                </td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&gt;52</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>41-52</td>\n' +
        '                                <td>3</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>32-40.9</td>\n' +
        '                                <td>1</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>22-31.9</td>\n' +
        '                                <td>0</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>18-21.9</td>\n' +
        '                                <td>2</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>15-17.9</td>\n' +
        '                                <td>3</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&lt;15</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            </tbody></table>\n' +
        '                        <p class="text_info">Тяжелая органная дисфункция подразумевает под собой (анамнестически, до текущей госпитализации):</p>\n' +
        '                        <p class="big_text_info">Печень</p>\n' +
        '                        <ul class="text_info">\n' +
        '                            <li>Цирроз, подтвержденный биопсией</li>\n' +
        '                            <li>Подтвержденная портальная гипертензия (ПГ)</li>\n' +
        '                            <li>ЖК-кровотечение, ассоциированное с ПГ</li>\n' +
        '                            <li>Печеночная энцефалопатия, кома</li>\n' +
        '                        </ul>\n' +
        '                        <p class="big_text_info">Сердце и сосуды</p>\n' +
        '                        <ul class="text_info">\n' +
        '                            <li>Сердечная недостаточность NYHA IV</li>\n' +
        '                        </ul>\n' +
        '                        <p class="big_text_info">Дыхательная система</p>\n' +
        '                        <ul class="text_info">\n' +
        '                            <li>Хроническое рестриктивное, обструктивное или васкулярное заболевание, приведшеое к значительному ограничению физической активности, - неспособности подняться по лестнице или неспособности вести домашнее хозяйство.</li>\n' +
        '                            <li>Задокументированная хроническая гипоксия, гиперкапния, вторичная полицитемия, тяжелая легочная гипертензия (&gt;40 мм Hg), зависимость от респиратора.</li>\n' +
        '                        </ul>\n' +
        '                        <p class="big_text_info">Почки</p>\n' +
        '                        <ul class="text_info">\n' +
        '                            <li>Программный гемодиализ</li>\n' +
        '                        </ul>\n' +
        '                        <p class="big_text_info">Иммуносупрессия</p>\n' +
        '                        <ul>\n' +
        '                            <li class="text_info">Пациент получал иммуносупрессиную терапию, снизившую его сопротивляемость к инфекции: химиотерапия, облучение, высокие дозы стероидов. Заболевания, снижающие сопротивляемость к инфекции: лейкемия, лимфома, ВИЧ и проч.</li>\n' +
        '                        </ul>\n' +
        '                    </div>\n' +
        '\n' +
        '                    <div>\n' +
        '                        <p class="big_text_info">Интерпретация</p>\n' +
        '                        <table>\n' +
        '                            <tbody><tr class="big_text_info">\n' +
        '                                <th>Оценка по шкале APACHE II</th>\n' +
        '                                <th>    Летальность, %</th>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>0-4</td>\n' +
        '                                <td>4</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>5-9</td>\n' +
        '                                <td>8</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>10-14</td>\n' +
        '                                <td>15</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>15-19</td>\n' +
        '                                <td>25</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>20-24</td>\n' +
        '                                <td>40</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>25-29</td>\n' +
        '                                <td>55</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>30-34</td>\n' +
        '                                <td>75</td>\n' +
        '                            </tr>\n' +
        '                            <tr class="text_info">\n' +
        '                                <td>&gt;34</td>\n' +
        '                                <td>85</td>\n' +
        '                            </tr>\n' +
        '                            </tbody></table>\n' +
        '                    </div>\n' +
        '                    <div>\n' +
        '                        <p class="big_text_info">Дополнительные сведения</p>\n' +
        '                        <p class="text_info">Шкалы APACHE III и APACHE IV, несмотря на доскональную разработку и высокую прогностическую значимость, не получили широкого распространения по причине защиты их статистических методов авторским правом.</p>\n' +
        '                        <p class="text_info">Шкала APACHE II может быть использована с целью информирования родственников пациента о вероятном исходе лечения и агрессивности терапии.</p>\n' +
        '                        <p class="text_info">Все шкалы, применяемые в ОРИТ, должны быть периодически рекалиброваны для сответствия постоянно изменяющимся подходам в лечении и демографии.</p>\n' +
        '                    </div>';
    var json = JSON.stringify({ html: htmlCode });
    var data = JSON.parse(json);
    console.log(data.html);

    var modalBody = document.querySelector('.modal-body');
    var htmlElement = document.createElement('div');
    htmlElement.innerHTML = data.html;

    modalBody.appendChild(htmlElement);
});
