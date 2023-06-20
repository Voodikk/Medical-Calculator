$(document).ready(function (){
    $('#testbutton').on('click', function (){
        return new Promise((resolve, reject) => {
            $.ajax({
                url: '/apache/info',
                type: 'GET',
                success: function(data) {
                    alert(data.username + data.password);
                    resolve(true);
                },
                error: function(jqXHR) {
                    if (jqXHR.status === 403) {
                        alert("Ошибка нахуй");
                    }
                    resolve(false);
                }
            });
        });
    })
    $('#myCheckbox').change(function(){
        if(this.checked){
// Если чекбокс выбран
            $('#myDiv').html('');
        }else{
// Если чекбокс не выбран
            $('#myDiv').html('Чекбокс не выбран!');
        }
    });
})
