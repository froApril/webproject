//BingKun Miao
var html ="";

function getAllTopics(){
    $.ajax({
        url:"/admin/getTopic",
        type:"get",
        datatype:"json",
        async : false,
        success: function(data){
            for(var i=0;i<data.length;i++){

                insertTopicDetail(data[i]);
            }

            $(".content").html(html);
            html="";
        }
    })
}

function insertTopicDetail(data) {
    html +="<tr>\n"+"<td>"+"<input type='checkbox' id='checkbox' name='checkbox' value="+data.topicName+"/>"+"</td>\n"+"<td>"+data.topicName+"</td>\n"+
        "<td>"+data.topicDescription+"</td>\n"+"</tr>\n"
}

function specialDel(){
    var checkID=[];
    $("input[name='checkbox']:checked").each(function(i){
        checkID[i] = $(this).val();
    });
    if(checkID.length == 0){
        alert("Please make a selection");
    }
    else {
        var r = confirm("Are you sure to delete?");
        if (r==true) {
            $.ajax({
                url:"/admin/deleteTopic",
                type:"post",
                datatype:"json",
                contentType:"application/json",
                data:JSON.stringify(checkID),
                success : function(data) {

                    for (var i=0;i<data.length;i++) {
                        insertTopicDetail(data[i]);
                    }

                    $(".content").html(html);
                    html="";

                    alert("Successfully deleted!");
                }
            })
        }
    }
}
