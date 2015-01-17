$( document ).ready(function() {
    $("[rel='tooltip']").tooltip();    
    $(this).find('.caption').slideUp(250);

    $('.thumbnail').hover(
        function(){
            $(this).find('.caption').slideDown(250); //.fadeOut(205)
        },
        function(){
            $(this).find('.caption').slideUp(250); //.fadeIn(250)
        }
    ); 
});