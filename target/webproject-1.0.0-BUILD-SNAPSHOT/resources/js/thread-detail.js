// <div class="container thread-title thread-main">
//     <h1 style="margin-top: 20px">This is my topic</h1>
// </div>
// <div class="container requester">
//     <div class="row">
//     <div class="col-2">
//     <img src="resources/images/icons/user.svg" alt="">
//     </div>
//     <div class="col-10 user-info">
//     <p class="user-name">Little Ming</p>
// <p class="thread-date">6/10/2019</p>
//     </div>
//     </div>
//
//     <div class="row thread-message ">
//     <div class="col-2">
//     </div>
//     <div class="col-10">
//     <p>
//     Hi tutors
// <br>
// Due to an urgent incident, I was unable to submit my individual report on the wiki page.
// <br>
// I am wondering if late submissions are allowed or not?
// </p>
// </div>
//
// </div>
//
// </div>
//
//
// <div class="container thread-main" style="margin-bottom: 40px">
//     <form role="form">
//     <div class="form-group">
//     <h3 style="margin-top: 100px; margin-bottom: 20px;">Your answer</h3>
// <textarea class="form-control comment-textarea" rows="8" id="textarea-id">
//     </textarea>
//     </div>
//     <button type="submit" class="btn btn-default">Submit</button>
//     </form>
//     </div>


function setInnerHTML(title) {
    var details = getCommentDetails(title);
    var html = constructHtmlString(details);

}

function getCommentDetails(title){

    var t = parent.window.getQueryVariable('topic');
    $.ajax({
        url:"/comments/detail"+"?topic="+t+"&title="+title,
        type:"get",
        dataType:"json",
        async : false,
        success: function(data){
            return data;
        }

    });
    return null;
}

function constructHtmlString(data) {
    var html = "";
    html += "<div class=\"container thread-title thread-main\">"+
                "<h1 style=\"margin-top: 20px\">"+data.commentTitle+"</h1>"
                +"</div>";

// <div class="container requester">
    //     <div class="row">
    //     <div class="col-2">
    //     <img src="resources/images/icons/user.svg" alt="">
    //     </div>
    //     <div class="col-10 user-info">
// <p class="user-name">Little Ming</p>
// <p class="thread-date">6/10/2019</p>
//     </div>

    html += "<div class=\"container requester\">" +
        "<div class=\"row\">" +
        "<div class=\"col-2\">" +
        "<img src=\"resources/images/icons/user.svg\" alt=\"\">" +
        "</div>" +
        "<div class=\"col-10 user-info\">" +
        "<p class=\"user-name\">"+data+"</p>"
}



// function setInnerHtml(title){
//     $("body").html(title);
// }

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



