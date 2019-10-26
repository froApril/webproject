//BingKun Miao
function addOne() {
    var param = {};
    param.topicName = $("input[name='topicName']").val();
    param.topicDescription = $("textarea[name='topicDescription']").val();
    param.check = $("input[name='check']").val();
    if (param.topicName.toString().length == 0) {
        alert("Please fill in the course name");
    }
    else if (param.topicDescription.toString().length == 0) {
        alert("Please fill in the course description");

    }
    else {
        $.ajax({
            url: "/admin/addTopic",
            type: "post",
            datatype: "json",

            data: param,
            success: function (data) {

                if (data.result == 'success') {
                    alert("Add topic success!!!");

                } else {
                    alert("This topic exists, please check!");

                }
                window.location.href = "addTopic";
            }
        })
    }
}