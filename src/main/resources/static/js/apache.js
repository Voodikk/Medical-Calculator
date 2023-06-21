$(document).ready(function (){
    $('#testbutton').on('click', function (){
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
    $('#myCheckbox').change(function(){
        if(this.checked){
// Если чекбокс выбран
            $('#myDiv').html('Чекбокс выбран!');
        }else{
// Если чекбокс не выбран
            $('#myDiv').html('Чекбокс не выбран!');
        }
    });
})
