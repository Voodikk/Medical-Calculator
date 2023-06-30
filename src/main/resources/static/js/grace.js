function sendForm() {
    let form = $("#form");
    let data = {
        age: form.find("input[name='age']").val(),
        heartRate: form.find("input[name='heartRate']").val(),
        sbp: form.find("input[name='sbp']").val(),
        serumCreatinine: form.find("input[name='serumCreatinine']").val(),
        heartStop: $('#heartStop').is(":checked"),
        segDeviationST:$('#segDeviationST').is(":checked"),
        hloce:$('#hloce').is(":checked"),
        selectValue: form.find("select[name='value']").val()
    };
    $.ajax({
        url: "http://localhost:8080/grace/result",
        type: "POST",
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data),
        success: function(result) {
            if(result < 126) {
                $('#result1').html("<table class=\"result_table\"><tr><td colSpan=\"3\" style=\"font-weight: bold\">Результат</td></tr><tr><td colSpan=\"3\" style=\"font-weight: bold\">" + result + " Баллов</td></tr><tr><td>Вид летальности</td><td>Риск</td><td>Летальность</td></tr><tr><td> Внутригоспитальная </td><td> Низкий </td><td> < 2% </td> </tr></table>");
            }
            else if(result >= 126 && result <= 154) {
                $('#result1').html("<table class=\"result_table\"><tr><td colSpan=\"3\" style=\"font-weight: bold\">Результат</td></tr><tr><td colSpan=\"3\" style=\"font-weight: bold\">" + result + " Баллов</td></tr><tr><td>Вид летальности</td><td>Риск</td><td>Летальность</td></tr><tr><td> Внутригоспитальная </td><td> Средний </td><td> 2 - 5% </td> </tr></table>");
            }
            else if(result > 154) {
                $('#result1').html("<table class=\"result_table\"><tr><td colSpan=\"3\" style=\"font-weight: bold\">Результат</td></tr><tr><td colSpan=\"3\" style=\"font-weight: bold\">" + result + " Баллов</td></tr><tr><td>Вид летальности</td><td>Риск</td><td>Летальность</td></tr><tr><td> Внутригоспитальная </td><td> Высокий </td><td> > 5% </td> </tr></table>");
            }

            if(result < 100) {
                $('#result2').html("<table class=\"result_table\"><tr><td> В течение 6 месяцев </td><td> Низкий </td><td> < 4.5% </td> </tr></table>");
            }
            else if(result >= 100 && result <= 127) {
                $('#result2').html("<table class=\"result_table\"><tr><td> В течение 6 месяцев </td><td> Средний </td><td> 4.5 - 11% </td> </tr></table>");
            }
            else if(result > 127) {
                $('#result2').html("<table class=\"result_table\"><tr><td> В течение 6 месяцев </td><td> Высокий </td><td> > 11% </td> </tr></table>");
            }

            if(result < 109) {
                $('#result3').html("<table class=\"result_table\"><tr><td> Внутригоспитальная </td><td> Низкий </td><td> < 1% </td> </tr></table>");
            }
            else if(result >= 109 && result <= 140) {
                $('#result3').html("<table class=\"result_table\"><tr><td> Внутригоспитальная </td><td> Средний </td><td> 1 - 3% </td> </tr></table>");
            }
            else if(result > 140) {
                $('#result3').html("<table class=\"result_table\"><tr><td> Внутригоспитальная </td><td> Высокий </td><td> > 3% </td> </tr></table>");
            }

            if(result < 89) {
                $('#result4').html("<table class=\"result_table\"><tr><td> В течение 6 месяцев </td><td> Средний </td><td> < 3% </td> </tr></table>");
            }
            else if(result >= 89 && result <= 118) {
                $('#result4').html("<table class=\"result_table\"><tr><td> В течение 6 месяцев </td><td> Средний </td><td> 3 - 8% </td> </tr></table>");
            }
            else if(result > 118) {
                $('#result4').html("<table class=\"result_table\"><tr><td> В течение 6 месяцев </td><td> Средний </td><td> > 8% </td> </tr></table>");
            }
        },
        error: function(request,msg,error) {
            // обработка ошибки отправки формы
        }
    });

    return false; // отмена действия по умолчанию
}
document.addEventListener('DOMContentLoaded', function() {
    $.ajax({
        url: "http://localhost:8080/grace/info",
        type: "GET",
        contentType: 'application/json; charset=utf-8',
        success: function(information) {
            var json = JSON.stringify({ info: information});
            var data = JSON.parse(json);
            var modalBody = document.querySelector('.modal-body');
            var htmlElement = document.createElement('div');
            htmlElement.innerHTML = data.info;
            modalBody.appendChild(htmlElement);
        },
        error: function(request,msg,error) {
            // обработка ошибки отправки формы
        }
    });
});