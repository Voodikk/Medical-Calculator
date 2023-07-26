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
        url: "http://localhost:8090/calculators/apache/result",
        type: "POST",
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data),
        success: function(information) {
            $('#result').html("<table class=\"result_table\"><tr><td colSpan=\"2\" style=\"font-weight: bold\">Результат</td></tr><tr><td>Баллов</td><td>Летальность</td></tr><tr><td>" + information.result + "</td><td>" + information.percLetal + "%</td></tr></table>");
        },
        error: function(request,msg,error) {
            // обработка ошибки отправки формы
        }
    });

    return false; // отмена действия по умолчанию
}
document.addEventListener('DOMContentLoaded', function() {
    $.ajax({
        url: "http://localhost:8090/calculators/apache/info",
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
