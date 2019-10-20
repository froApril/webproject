// <a class="list-group-item list-group-item-action" href="#list-item-1">comp2017</a>
//     <a class="list-group-item list-group-item-action" href="#list-item-2">Item 2</a>
// <a class="list-group-item list-group-item-action" href="#list-item-3">Item 4</a>
// <a class="list-group-item list-group-item-action" href="#list-item-4">Item 1</a>
//
// <h4 id="list-item-1">Comp2017</h4>
//     <p>Ex consequat commodo adipisicing exercitation aute excepteur occaecat ullamco duis aliqua id magna ullamco eu. Do aute ipsum ipsum ullamco cillum consectetur ut et aute consectetur labore. Fugiat laborum incididunt tempor eu consequat enim dolore proident. Qui laborum do non excepteur nulla magna eiusmod consectetur in. Aliqua et aliqua officia quis et incididunt voluptate non anim reprehenderit adipisicing dolore ut consequat deserunt mollit dolore. Aliquip nulla enim veniam non fugiat id cupidatat nulla elit cupidatat commodo velit ut eiusmod cupidatat elit dolore.</p>
// <a href="/comments?topic=comp2017" class="detail-link">Discuss board</a>

//var topic_html ="";
/*var topic_detail_html ="";

function getAllTopics(){
    $.ajax({
        url:"tpl",
        type:"get",
        datatype:"json",
        async : false,
        success: function(data){
            var index =1;
            for(var i=0;i<data.length;i++){

                insertTopicDetail(data[i],index);
                index++;
            }

            $(".topics-details").html(topic_detail_html);
        }
    })
}*/

var html ="";

function getAllTopics(){
    $.ajax({
        url:"tpl",
        type:"get",
        datatype:"json",
        async : false,
        success: function(data){
            var index =1;
            for(var i=0;i<data.length;i++){

                insertTopicDetail(data[i],index);
                index++;
            }

            $(".content").html(html);
        }
    })
}


function insertTopicDetail(data,index) {
    //html +="<h4 id=\"list-item-"+index+"\">"+data.courseId+"</h4>\n"
    html +="<tr>\n"+"<th scope=\"row\">"+index+"</th>\n"+"<td>"+data.major+"</td>\n"+
        "<td>"+data.courseId+"</td>\n"+"<td>"+data.name+"</td>\n"+"</tr>\n"
}