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


function initTable() {
    //先销毁表格
    $('#cusTable').bootstrapTable('destroy');
    //初始化表格,动态从服务器加载数据
    $("#cusTable").bootstrapTable({
        method: "get",  //使用get请求到服务器获取数据
        //url: "<c:url value='/SellServlet?act=ajaxGetSellRecord'/>", //获取数据的Servlet地址
        url: "getTopicTable",
        striped: true,  //表格显示条纹
        //pagination: true, //启动分页
        //pageSize: 1,  //每页显示的记录数
        //pageNumber:1, //当前第几页
        //pageList: [5, 10, 15, 20, 25],  //记录数可选列表
        search: true,  //是否启用查询
        //showColumns: true,  //显示下拉框勾选要显示的列
        showRefresh: true,  //显示刷新按钮
        sidePagination: "server", //表示服务端请求
        //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
        //设置为limit可以获取limit, offset, search, sort, order
        queryParamsType : "undefined",
        queryParams: function queryParams(params) {   //设置查询参数
            var param = {
                pageNumber: params.pageNumber,
                pageSize: params.pageSize,
                orderNum : $("#orderNum").val()
            };
            return param;
        },
        onLoadSuccess: function(){  //加载成功时执行
            layer.msg("加载成功");
        },
        onLoadError: function(){  //加载失败时执行
            layer.msg("加载数据失败", {time : 1500, icon : 2});
        }
    });
}



$(document).ready(function () {
    //调用函数，初始化表格
    initTable();

    //打点击查询按钮的时候执行
    $("#search").bind("click", initTable);
});