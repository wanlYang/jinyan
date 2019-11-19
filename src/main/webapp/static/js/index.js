if($(window).width()<=768){
    $('a').each(function(){  $(this).attr('target', ''); });
}else{
    $('a').each(function(){ $(this).attr('target'); });
}
