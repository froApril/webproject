// <a class="list-group-item list-group-item-action" href="#list-item-1">comp2017</a>
//     <a class="list-group-item list-group-item-action" href="#list-item-2">Item 2</a>
// <a class="list-group-item list-group-item-action" href="#list-item-3">Item 4</a>
// <a class="list-group-item list-group-item-action" href="#list-item-4">Item 1</a>
//
// <h4 id="list-item-1">Comp2017</h4>
//     <p>Ex consequat commodo adipisicing exercitation aute excepteur occaecat ullamco duis aliqua id magna ullamco eu. Do aute ipsum ipsum ullamco cillum consectetur ut et aute consectetur labore. Fugiat laborum incididunt tempor eu consequat enim dolore proident. Qui laborum do non excepteur nulla magna eiusmod consectetur in. Aliqua et aliqua officia quis et incididunt voluptate non anim reprehenderit adipisicing dolore ut consequat deserunt mollit dolore. Aliquip nulla enim veniam non fugiat id cupidatat nulla elit cupidatat commodo velit ut eiusmod cupidatat elit dolore.</p>
// <a href="/comments?topic=comp2017" class="detail-link">Discuss board</a>

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
                insertTopicDetail(data[i],index);
                index++;
            }
            $(".list-group").html(topic_html);
            $(".topics-details").html(topic_detail_html);
        }
    })
}

function insertTopicList(data,index){
    topic_html+="<a class=\"list-group-item list-group-item-action\" href=\"#list-item-"+index+"\">"+data.topicName+"</a>"
}

function insertTopicDetail(data,index) {
    topic_detail_html +="<h4 id=\"list-item-"+index+"\">"+data.topicName+"</h4>\n" +
        "<p>"+data.topicDescription+"</p>\n" +
        "<a href=\"/comments?topic="+data.topicName+"\" class=\"detail-link\">Discuss board</a>"
}
