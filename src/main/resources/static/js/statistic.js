$(function() {
    $('[data-code]').mouseenter(function() {
        $('.district .title_region').html($(this).attr('data-title'));
        $('.district #result_number').html($(this).attr('value') || 0);
        $('.district').show();
    });
    $('[data-code]').mouseleave(function() {
        if (!$('.rf-map').hasClass("open")) {
            $('.district').hide();
        }
    });


    // $('[data-code]').each(function() {
    //     let id = $(this).attr('data-code');
    //     let title = $(this).attr('data-title');
    //     if ($('#' + id).text() != '') {
    //         $('.district-links').append('<div data-title="' + title + '" data-code="' + id + '">' + title + '</div>');
    //     }
    // });
});