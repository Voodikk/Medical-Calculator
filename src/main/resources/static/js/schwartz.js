function sendForm() {
    let form = $("#form");
    let data = {
        gender: $('#gender').is(":checked"),
        age: form.find("input[name='age']").val(),
        height: form.find("input[name='height']").val(),
        creat: form.find("input[name='creat']").val(),
        race: $('#race').is(":checked"),
        idms:$('#idms').is(":checked")
    };
    $.ajax({
        url: "http://localhost:8080/schwartz/result",
        type: "POST",
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data),
        success: function(result) {
            var st;
            var add = "";
            if(result >= 150) {
                $('#result').html("<tr><td style=\"font-weight: bold\">Результат</td></tr><tr><td>СКФ=" + result + " мл/мин/1.73 м<sup>2</sup></td></tr><tr><td>Нельзя исключить фильтрацию</td></tr>");
                return 0;
            }
            else if(result >= 90) {
                st = "I";
                add = "<br>при наличии факторов риска<br>или повреждение почек<br>с нормальной почечной функцией</td></tr>";
            }
            else if(result >= 60) {
                st = "II";
            }
            else if(result >= 45) {
                st = "IIIa";
            }
            else if(result >= 30) {
                st = "IIIb";
            }
            else if(result >= 15) {
                st = "IV";
            }
            else {
                st = "V";
            }
            $('#result').html("<tr><td style=\"font-weight: bold\">Результат</td></tr><tr><td>СКФ=" + result + " мл/мин/1.73 м<sup>2</sup></td></tr><tr><td>Стадия ХБП: " + st + add);
        },
        error: function(request,msg,error) {
            // обработка ошибки отправки формы
        }
    });

    return false; // отмена действия по умолчанию
}

document.addEventListener('DOMContentLoaded', function() {
    $.ajax({
        url: "http://localhost:8080/schwartz/info",
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

$(document).ready(function (){
    $('#age').on('input',function () {
        let value = $('#age').val();
        if(value > 0 && value <= 18) {
            $('#secondInput').css("display", "block");
            document.getElementById('secondInput').setAttribute('required', '');
        }
        else {
            $('#secondInput').css("display", "none");
            $('#secondInput').removeAttr('required');
        }
    })
})
