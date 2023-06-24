$(document).ready(function (){
    $('#InformationButton').on('click', function (){
        return new Promise((resolve, reject) => {
            $.ajax({
                url: '/apache/info',
                type: 'GET',
                success: function(data) {
                    alert(data.infor);
                    resolve(true);
                },
                error: function(jqXHR) {
                    if (jqXHR.status === 403) {
                        alert("Ошибка");
                    }
                    else {
                        alert("Другая ошибка");
                    }
                    resolve(false);
                }
            });
        });
    })
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
