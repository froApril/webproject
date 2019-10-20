/*function Table_bs($box){

    var _init_bit = false;
    var _box = $box;

    this.init = function(){

        _box.addClass('table-responsive');

        var html = '';
        html += '<table class="table table-bordered " style="text-align: center; ">';
        html += '<thead style="font-weight: bold;">';

        html += '</thead>';
        html += '<tbody>';

        html += '</tbody>';
        html += '</table>';

        _box.append($(html));

        _init_bit = true;
    }
    this.load = function(option){

        if(!_init_bit){
            this.init();
        }


        var thead = option.colNames;

        var html_thead = '';
        html_thead += '<tr>';
        for(var i=0;i<thead.length;i++){
            html_thead += '<td>' + thead[i] + '</td>';
        }
        html_thead += '</tr>';

        _box.find('thead').append($(html_thead));


        var tbody = option.data;
        var html_tbody = '';

        for(var j1=0;j1<tbody.length;j1++){
            var buff = tbody[j1];

            html_tbody += '<tr>';
            for(var j2=0;j2<buff.length;j2++){
                html_tbody += '<td>' + buff[j2] + '</td>';
            }
            html_tbody += '</tr>';
        }
        _box.find('tbody').append($(html_tbody));
    }
}

var option = {
    colNames: ['Picking', 'Major', 'Course ID', 'Course Name'],
    data:[
        ['<input type="checkbox">','aaa','aaa','aaa'],
        ['<input type="checkbox">','bbb','bbb','bbb']
    ]
}

$(function(){
    var t = new Table_bs($('#kechengguanli'));
    t.load(option);
});*/



/*$(function(){
    $('#topic-table').bootstrapTable({
        ajax : function (request) {
            $.ajax({
                type : "GET",
                url : "aha",
                contentType: "application/json;charset=utf-8",
                dataType:"jsonp",
                data:'',
                jsonp:'callback',
                success : function (msg) {
                    request.success({
                        row : msg
                    });
                    $('#topic-table').bootstrapTable('load', msg);
                },
                error:function(){
                    alert("error");
                }
            });
        },

        toolbar:'#toolbar',
        singleSelect:true,
        clickToSelect:true,
        sortName: "create_time",
        sortOrder: "desc",
        pageSize: 15,
        pageNumber: 1,
        pageList: "[10, 25, 50, 100, All]",
        showToggle: true,
        showRefresh: true,
        showColumns: true,
        search: true,
        pagination: true,
        columns: [{
            field: 'major',
            title: 'Major',
            switchable: true
        }, {
            field: 'courseId',
            title: 'Course ID',
            switchable: true
        }, {
            field: 'name',
            title: 'Course Name',
            switchable: true
        }],

    });
})*/




function getTopics() {
    $.ajax({
        url:"/main/allTopics",
        type:"get",
        datatype:"json",
        async : false,
        success: function(data){
            var html = "";
            for(var i=0;i<data.length;i++){
                html += "<tr>"+
                    "<td>"+data[i].major+"</td>"+
                    "<td>"+data[i].courseId+"</td>"+
                    "<td>"+data[i].name+"</td>"+
                    "</tr>";
            }
            $("#content").html(html);

        }
    })
    
}







