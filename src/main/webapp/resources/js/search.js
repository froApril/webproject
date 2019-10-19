

(function ($) {

    $('#searchB').on('click',function() {
        var text = $("#searchI").val();
        console.log(text);


        if(text == null || text==""){
            alert("Need Input Value");
        }
        else{
            var param = {};
            param.topic = text.toString();
            $.ajax({
                url: "/getT",
                type: "get",
                data: param,
                datatype: "json",
                success: function (state) {
                    console.log(state);
                    if (state.result == "SUCCESS") {

                        window.location.href = state.link.toString();
                    }
                    else {
                        alert("Topic doesn't Exist")
                    }

                }
            });
        }
        return false;

    });


})(jQuery);