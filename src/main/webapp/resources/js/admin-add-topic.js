function addOne() {


    /*var param = {};
    param.topicName = $("input[name='topicName']").val();
    param.topicDescription = $("input[name='topicDescription']").val();
    alert(param.topicName.toString());*/
    var param=[];
    param[0] = $("input[name='topicName']").val();
    param[1] = $("input[name='topicDescription']").val();
    //alert(param);

    var r = confirm("Are you sure to delete?");
    if (r==true) {
        $.ajax({
            url: "/admin/ceshi",
            type: "post",
            datatype: "json",
            contentType: "application/json",
            data: JSON.stringify(param),
            success: function (data) {


                alert("Successfully deleted!");

            }
        })
    }

    /*$.ajax({
        url: "addNewTopic",
        type: "post",
        datatype: "json",

        data: param,
        success: function (data) {

            if (data.result == 'success') {
                alert("OK!");

            }
            else {
                alert("NO!");

            }




        }
    })*/
    
}