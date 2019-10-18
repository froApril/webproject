

function initData(){
    var topicList="";
    var topicDetails="";
    $.ajax({
        url:"/main/all",
        type:"get",
        dataType:"json",
        async : false,
        success: function(list){
            topicList = createList(list);
            console.log("read");
        }

    });
    return topicList;
}

function createList(list){
    var topicList ="";
    for(var i=0;i<getJsonLen(list);i++){
        var topic = list[i];
        topicList += "<a class='list-group-item list-group-item-action' href='#list-item-" + i + "'>" + topic.topicname + "</a>";
    }
    return topicList;
}


function getJsonLen(list){
    var i = 0;
    for(var i in list){
        i++;
    }
    return i;

}