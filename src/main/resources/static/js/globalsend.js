$(function(){
    $("input:radio").click(function(){
        if ($("input:radio[value='해외송금']").is(":checked")){
            $("select").attr('disabled', false);
        }
        if ($("input:radio[value='해외송금']").is(":checked")== false){
            $("select").attr('disabled', true);
        }
    })
    $("#national").click(function(){
        var nation = $("#national option:selected")
        if ( nation =="중국"){
            var 
        }
    })
});