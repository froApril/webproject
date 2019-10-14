

function sethtml(html,topic){
    $("#accordion").html(html);

    $(".btn-link").on("click",function (event) {

            var title = $(this).text();
            // parent.window.mainIframe.window.setInnerHTML($(this).text());
            $.ajax({
                url:"/comments/topicComment"+"?topicComment="+$(this).text()+ "&topic="+topic,
                type:"get",
                dataType:"json",
                async : false,
                success: function(data){
                    parent.window.mainIframe.window.getTopicComment(data);
                    parent.window.mainIframe.window.getCommentDetails(title);
                }

            });


    });
}

function getQueryVariable(variable)
{
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}
