//BingKun Miao
var html ="";

function getAllUsers(){
    $.ajax({
        url:"/admin/getUser",
        type:"get",
        datatype:"json",
        async : false,
        success: function(data){

            for (var i=0;i<data.length;i++) {
                insertUserDetail(data[i]);
            }

            $(".content").html(html);
            html="";
        }
    })
}

function insertUserDetail(data) {

    html +="<tr>\n"+"<td>"+"<input type='checkbox' id='checkbox' name='checkbox' value="+data.username+"/>"+"</td>\n"+"<td>"+data.username+"</td>\n"+
        "<td>"+data.nickname+"</td>\n"+"</tr>\n"
}

function specialDel() {
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
                url:"/admin/deleteUser",
                type:"post",
                datatype:"json",
                contentType:"application/json",
                data:JSON.stringify(checkID),
                success : function(data) {

                    for (var i=0;i<data.length;i++) {
                        insertUserDetail(data[i]);
                    }

                    $(".content").html(html);
                    html="";

                    alert("Successfully deleted!");
                }
            })
        }
    }
}
