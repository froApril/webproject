

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

    $('#searchBB').on('click',function() {
        var comment = $("#searchII").val();
        console.log(comment);


        if(comment == null || comment==""){
            alert("Need Input Value");
        }
        else{
            var title = comment;
            var reg = new RegExp("(^|&)" + "topic" + "=([^&]*)(&|$)");
            var r = window.parent.location.search.substr(1).match(reg);
            var topic = unescape(r[2]);

            $.ajax({
                url: "/comments/topicComment" + "?topicComment=" + comment + "&topic=" + topic,
                type: "get",
                dataType: "json",
                async: false,
                success: function(data) {


                    if(data.id != -1){
                        console.log("asd");
                        parent.window.mainIframe.window.getTopicComment(data);
                        parent.window.mainIframe.window.getCommentDetails(title);
                    }
                    else{

                        alert("No Such Thread!");
                    }

                }


            });
        }


    });


})(jQuery);