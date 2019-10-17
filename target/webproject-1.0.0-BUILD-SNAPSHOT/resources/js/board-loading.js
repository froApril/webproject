// var originURL = sideIframe.location.href
// var i = document.getElementById('sideIframe')
// i.onload= function(){//这是异步加载的iframe
//   sideIframe.window.f();
// }

// <div class="card">
//     <div class="card-header" id="headingOne">
//       <h5 class="mb-0">
//         <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
//         	<!-- max 20 -->
//         	what's my question

//         </button>
//       </h5>
//     </div>

//     <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
//       <div class="card-body">
// 			<p class="author">Author: xyf</p>
// 			<p class="date">Last edition:5/10/2019</p>
//       </div>
//     </div>
// </div>

function test(data) {
    console.log(data)
}


function initData(){
    // $.cookie("username", "xiaoming",{ expires: 7, path: '/' });
    var ht="";
    $.ajax({
        url:"/comments/all"+"?topic="+getQueryVariable("topic"),
        type:"get",
        dataType:"json",
        async : false,
        success: function(list){
            ht = createHtml(list);
        }

    });
    return ht;
}


function getJsonLen(list){
    var i = 0;
    for(var i in list){
        i++;
    }
    return i;

}

function createHtml(list){
    var html="";
    // console.log(getJsonLen(list));
    for(var i=0;i<getJsonLen(list);i++){
        // accordion
        var comment = list[i];

        html += "<div class=\"card\">"
            +"<div class=\"card-header\" id=\"comment"+i+"\">"
            +"<h5 class=\"mb-0\">"
            +"<button id= \""+comment.commentTitle+"\"class=\"btn btn-link\""
            +"data-toggle=\"collapse\" data-target=\"#collapse"+i+"\"aria-expanded=\"true\" "
            +"aria-controls=\"collapse"+i+"\">";
        html += comment.commentTitle;
        html += "</button>"
            +"</h5></div>"
            +"<div id=\"collapse"+i+"\" class=\"collapse\" aria-labelledby=\"comment"+i+"\" data-parent=\"#accordion\"> "
            +"<div class=\"card-body\">"
            +"<p class=\"date\">Author: "+comment.authorName+"</p>"
            +"</div></div></div>";
    }
    return html;
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