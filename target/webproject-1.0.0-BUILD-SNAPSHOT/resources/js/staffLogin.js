
(function ($){
    "use strict";

    var input = $('.validate-input .input100');

    //login button on click 
    $('.login100-form-btn').on('click',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }
        if (check){
            var param={};
            param.username = $("input[name='username']").val();
            param.password = $("input[name='pass']").val();
            $.ajax({
                url:"staffLogin",
                type:"post",
                data: param,
                datatype:"json",
                success: function (state) {


                    if(state.result == 'SUCCESS'){

                        $.cookie("username",param.username,{expires:7, path:'/'});
                        window.location.href ="/addTopic"




                    }
                    else if(state.result == "Fail"){

                        if($('#erruser').css("display") == "block" || $('#errstaff').css("display") == "block"){
                            $('#erruser').css("display","none")
                            $('#errstaff').css("display","none")
                        }

                        $('#errpss').css('display','block');

                    }
                    else if(state.result == "fail not staff"){
                        if($('#erruser').css("display") == "block" || $('#errpss').css("display") == "block"){
                            $('#erruser').css("display","none")
                            $('#errpss').css("display","none")
                        }


                        $('#errstaff').css('display','block');

                    }
                    else{
                        if($('#errstaff').css("display") == "block" || $('#errpss').css("display") == "block"){
                            $('#errstaff').css("display","none")
                            $('#errpss').css("display","none")
                        }
                        $('#erruser').css('display','block');
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