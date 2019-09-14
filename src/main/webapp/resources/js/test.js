window.onload =function () {
    clickListener();
}

function clickListener() {
    $("#btn1").click(
        function(){
            $.ajax({
                url:"test",
                type:"get",
                dataType:"json",
                success: function(data) {
                    console.log(data);
                    $("#test").html(data.topicName+ " "+ data.id);
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status);
                    alert(XMLHttpRequest.readyState);
                    alert(textStatus);
                },
            });
        }
    )
}