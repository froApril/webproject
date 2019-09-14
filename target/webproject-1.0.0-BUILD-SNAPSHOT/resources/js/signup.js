
(function ($) {
    var input = $('.validate-input .account-info');

    $('#submit_btn').on('click',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }
       var param={};
        param.username = $("input[name='username']").val();
        param.password = $("input[name='pass']").val();
        param.email = $("input[name='email']").val();
        $.ajax({
            url:"signup",
            type:"post",
            data: param,
            datatype:"json",
            success: function (state) {
                if(state.result == 'SUCCESS')
                    console.log("Success");
            }
        })


    });

    $('#resend_button').on('click', function () {
        // TODO: send vaildate code to the email address.
        var param={};
        param.username = "123";
        param.password ="123";
        $.ajax({
            url:"signup",
            type:"post",
            data: param,
            datatype:"json",
            success: function (state) {
                if(state.result == 'SUCCESS')
                    console.log("ok");
            }
        })
    });

    
    $('[data-toggle="popover"]').popover({
        trigger: 'foucs' 
    });



    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
            hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }


})(jQuery);