$(document).ready(function() {
    $('.change_profile_button').click(function() {
        $('.input_div .change_input').removeAttr('disabled').attr('required', true);
        $('.submit_input_div').css('display', 'flex');
        $('.discard_changes_div').css('display', 'flex');
        $('.change_profile_button').css('display', 'none');
    });
});

