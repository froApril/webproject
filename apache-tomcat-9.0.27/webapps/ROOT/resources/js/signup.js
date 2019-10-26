
(function ($) {


    var input = $('.validate-input .account-info');

    $('.login100-form-btn').on('click',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if (validate(input[i]) == false ) {
                showValidate(input[i]);
                check = false;
            }
        }
        if(check) {


            var param = {};
            param.username = $("input[name='username']").val();
            param.password = $("input[name='pass']").val();
            param.email = $("input[name='email']").val();
            param.gen = $("#ss").children("option:selected").val();
            $.ajax({
                url: "signup",
                type: "post",
                data: param,
                datatype: "json",
                success: function (state) {
                    if (state.result == 'SUCCESS') {
                        console.log("Success");

                        $.cookie("username",param.username,{expires:7, path:'/'});

                        window.location.href = "/main"
                    } else {

                        $('#errlog').css("display", "block")
                    }

                }
            })
        }


    });



    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
            hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@+uni\.sydney\.edu\.au/) == null) {
                return false;
            }
        }
        if($(input).attr('name') == 'pass') {
            if($(input).val().length < 8) {
                return false;
            }
        }
        if($(input).attr('name') == 'confirmPassword') {
            if($(input).val() != $("input[name='pass']").val()) {
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