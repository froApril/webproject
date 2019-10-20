var topic_html ="";
var topic_detail_html ="";

function getAllTopics(){
    $.ajax({
        url:"/main/allTopics",
        type:"get",
        datatype:"json",
        async : false,
        success: function(data){
            var index =1;
            for(var i=0;i<data.length;i++){
                insertTopicList(data[i],index);
                //insertTopicDetail(data[i],index);
                index++;
            }
            $(".list-group").html(topic_html);
            //$(".topics-details").html(topic_detail_html);
        }
    })
}

function insertTopicList(data,index){
    topic_html+="<a class=\"list-group-item list-group-item-action\" href=\"#list-item-"+index+"\">"+data.name+"</a>"
}

/*function insertTopicDetail(data,index) {
    topic_detail_html +="<h4 id=\"list-item-"+index+"\">"+data.topicName+"</h4>\n" +
        "<p>"+data.topicDescription+"</p>\n" +
        "<a href=\"/comments?topic="+data.topicName+"\" class=\"detail-link\">Discuss board</a>"
}*/