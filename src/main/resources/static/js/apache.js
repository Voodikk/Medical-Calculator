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
// Если чекбокс выбран
            $('#paO2').css("display", "block");
            $('#gradientAA').css("display", "none");
        }else{
// Если чекбокс не выбран
            $('#paO2').css("display", "none");
            $('#gradientAA').css("display", "block");
        }
    });
    $('#availableABGC').change(function(){
        if(this.checked){
// Если чекбокс выбран
            $('#hiddenABGCcheck').css("display", "block");
            $('#serumBicarbonate').css("display", "none");
        }else{
// Если чекбокс не выбран
            $('#hiddenABGCcheck').css("display", "none");
            $('#serumBicarbonate').css("display", "block");
        }
    });
})
