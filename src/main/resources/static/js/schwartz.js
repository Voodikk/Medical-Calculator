function sendForm() {
    let form = $("#form");
    let data = {
        gender: $('#gender').is(":checked"),
        age: form.find("input[name='age']").val(),
        height: form.find("input[name='height']"),
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
