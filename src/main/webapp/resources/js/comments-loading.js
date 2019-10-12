

function sethtml(html){
    $("#accordion").html(html);

    $(".btn-link").on("click",function (event) {
        var state = $(this).attr("value");
        if(state==null){
            // console.log($(this).text());
            parent.window.mainIframe.window.setInnerHTML($(this).text());
            $(this).attr("value","opened");
            console.log($(this).attr("value"));
        }
        else{

            $(this).attr("value",null);
            console.log($(this).attr("value"));
        }
    });
}
