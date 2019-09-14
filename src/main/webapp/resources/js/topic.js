window.onload = function () {
    clickListener();
}
function clickListener() {
    $("#add-topic").click(
        function(e){
            var topic={};
            topic.name = $("#new-topic").val();
            console.log(topic);
            $.ajax({
                url:"topic/add",
                type:"post",
                datatype:"json",
                data:topic,
                success:function(data){
                    alert(data.result);
                }
            })
        }
    );
    $(".filter").click(
        function(e){
            $.ajax({
                url:"topic/sort",
                type:"get",
                dataType:"json",
                success: function(data) {
                    console.log(data);
                    // $("#test").html(data.topicName+ " "+ data.id);
                    var html ="";
                    $("#topics").html(html);
                    if(e.target.id == 'high-to-low'){
                        for(var i=0;i<data.length;i++){
                            html += data[i].topicName+" "+ data[i].score+"</br>";
                        }
                    }
                    else if(e.target.id == 'low-to-high'){
                        for(var i=data.length-1;i>=0;i--){
                            html += data[i].topicName+" "+ data[i].score+"</br>";
                        }
                    }

                    $("#topics").html(html);
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.status);
                    alert(XMLHttpRequest.readyState);
                    alert(textStatus);
                }
            });
        }
    )
}
