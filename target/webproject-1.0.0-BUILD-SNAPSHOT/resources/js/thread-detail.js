var parent_comment;

function getTopicComment(comment) {
    var html = "";
    parent_comment = comment;
   // console.log(comment);

    html+= "<div class=\"container thread-title thread-main\">"+
        "<h1 style=\"margin-top: 20px\">"+comment.commentTitle+"</h1>"
        +"</div>";
    html += "<div class=\"container requester\">" +
        "<div class=\"row\">" +
        "<div class=\"col-2\">" +
        "<img src=\"resources/images/photo/"+comment.imgUrl+".png\"/>" +
        "</div>" +
        "<div class=\"col-10 user-info\">" +
        "<p class=\"user-name\">"+comment.authorName+"</p>" +
        "</div>" +
        "</div>" +
        "<div class=\"row thread-message \">" +
        "<div class=\"col-2\">" +
        "</div>" +
        "<div class=\"col-10\">" +
        "<p>" +
        comment.commentMessage +
        "</p>" +
        "</div>" +
        "</div>" +
        "</div>"

    $("#topic-comment-heading").html(html);

}



function getCommentDetails(title){
    var t = parent.window.getQueryVariable('topic');
    $.ajax({
        url:"/comments/detail"+"?topic="+t+"&title="+title,
        type:"get",
        dataType:"json",
        async : false,
        success: function(data){
            // console.log(data)
            var temp ="";
            for(var i =0;i<data.length; i++){

                temp += "<div class=\"container requester\">" +
                    "<div class=\"row\">" +
                    "<div class=\"col-2\">" +
                    "<img src=\"resources/images/photo/"+data[i].imgUrl+".png\"/>" +
                    "</div>" +
                    "<div class=\"col-10 user-info\">" +
                    "<p class=\"user-name\">"+data[i].authorName+"</p>" +
                    "</div>" +
                    "</div>" +
                    "<div class=\"row thread-message \">" +
                    "<div class=\"col-2\">" +
                    "</div>" +
                    "<div class=\"col-10\">" +
                    "<p>" +
                    TransferString(data[i].commentMessage) +
                    "</p>" +
                    "</div>" +
                    "</div>" +
                    "</div>";


            }
            $("#replies-to-comment").html(temp);

            var textare= "<div class=\"container thread-main form-section\" style=\"margin-bottom: 40px\">" +
                "<form role=\"form\">" +
                "<div class=\"form-group\">" +
                "<h3 style=\"margin-top: 100px; margin-bottom: 20px;\">Your answer</h3>" +
                "<textarea class=\"form-control comment-textarea\" rows=\"8\" id=\"textarea-id\">" +
                "</textarea>" +
                "</div>" +
                "<button type='submit' class=\"btn btn-default form-submit\">Submit</button>" +
                "</form>" +
                "</div>"

            $("#text-area-block").html(textare);

        }

    });

    $("form").submit(function(e){
        $.ajax({
            url:"/getNickname?username="+$.cookie("username"),
            type:"get",
            datatype:"json",
            async:false,
            success:function(data){

                var imgURL = data.photoPro;
                $.ajax({
                    type:"post",
                    url:"/comments/add",
                    data:{author:data.nickname,parent_id:parent_comment.id
                        ,message:$("#textarea-id").val(),topic_id: parent_comment.topicId},
                    datatype:"json",
                    async: false,
                    success: function(data){
                        var newComment = "";
                        newComment+="<div class=\"container requester\">" +
                            "<div class=\"row\">" +
                            "<div class=\"col-2\">" +
                            "<img src=\"resources/images/photo/"+ imgURL+".png\"/>" +
                            "</div>" +
                            "<div class=\"col-10 user-info\">" +
                            "<p class=\"user-name\">"+data.authorName+"</p>" +
                            "</div>" +
                            "</div>" +
                            "<div class=\"row thread-message \">" +
                            "<div class=\"col-2\">" +
                            "</div>" +
                            "<div class=\"col-10\">" +
                            "<p>" +
                            TransferString(data.commentMessage) +
                            "</p>" +
                            "</div>" +
                            "</div>" +
                            "</div>";
                        $("#replies-to-comment").append(newComment);
                        $("#textarea-id").val("");
                    }

                });

            }

        });
        return false;
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


function TransferString(content)
{
    var string = content;
    try{
        string=string.replace(/\r\n/g,"<br>")
        string=string.replace(/\n/g,"<br>");
    }catch(e) {
        alert(e.message);
    }
    return string;
}



