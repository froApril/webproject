var html ="";

function getAllTopics(){
    $.ajax({
        url:"tpl",
        type:"get",
        datatype:"json",
        async : false,
        success: function(data){
            //var index =1;
            for(var i=0;i<data.length;i++){

                insertTopicDetail(data[i]);
                //index++;
            }

            $(".content").html(html);
            html="";
        }
    })
}


function insertTopicDetail(data) {
    /*html +="<tr>\n"+"<th scope=\"row\">"+index+"</th>\n"+"<td>"+data.major+"</td>\n"+
        "<td>"+data.courseId+"</td>\n"+"<td>"+data.name+"</td>\n"+"</tr>\n"*/

    html +="<tr>\n"+"<td>"+"<input type='checkbox' id='checkbox' name='checkbox' value="+data.name+"/>"+"</td>\n"+"<td>"+data.major+"</td>\n"+
        "<td>"+data.courseId+"</td>\n"+"<td>"+data.name+"</td>\n"+"</tr>\n"
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
        /*confirm("Are you sure to delete?", "", function (isConfirm) {
            if (isConfirm) {*/
        var r = confirm("Are you sure to delete?");
        if (r==true) {
            $.ajax({
                url:"det",
                type:"post",
                datatype:"json",
                contentType:"application/json",
                data:JSON.stringify(checkID),
                success : function(data) {

                    for(var i=0;i<data.length;i++){

                        insertTopicDetail(data[i]);

                    }

                    $(".content").html(html);
                    html="";

                    alert("Successfully deleted!");

                }
            })

        }


           // }
        //})

        /*$.ajax({
            url:"det",
            type:"post",
            datatype:"json",
            contentType:"application/json",
            data:JSON.stringify(checkID),
            success: function(data){
                alert("yes")
            }
        })*/


    }
}
