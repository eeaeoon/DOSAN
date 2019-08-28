$(function(){
    $("input:radio").click(function(){
        if ($("input:radio[value='해외송금']").is(":checked")){
            $("select").attr('disabled', false);
            $("#int_send").attr('disabled', false);
            $("#nt_send").attr('disabled', true);
            
        }
        if ($("input:radio[value='해외송금']").is(":checked")== false){
            $("select").attr('disabled', true);
            $("#nt_send").attr('disabled', false);
            $("#int_send").attr('disabled', true);
        }
    })

    $("#int_send").keyup(function(){
        var nation = $("#national option:selected").val();
        var money = $("#int_send").val();
        var sum;
        if (nation =="중국"){
            var exchange_rate = 169.34;
            sum = money / exchange_rate;
        }
        else if (nation == "미국"){
            var exchange_rate = 1213.40;
            sum = money / exchange_rate;
        }
        else if (nation == "베트남"){
            var exchange_rate =  0.052;
            sum = money / exchange_rate;
        }
        $("input[name='send_value2']").val(sum);
    })
});