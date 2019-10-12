$('.conLeft li').on('click',function(){
    $(this).addClass('bg').siblings().removeClass('bg');
    var intername=$(this).children('.liRight').children('.intername').text();
    $('.headName').text(intername);
    $('.newsList').html('');
})
$('.sendBtn').on('click',function(){
    var news=$('#dope').val();
    if(news==''){
        alert('can not be empty');
    }else{
        $('#dope').val('');
        var str='';
        str+='<li>'+
            '<div class="nesHead"><img src="resources/images/portrait.jpg"/></div>'+
            '<div class="news"><img class="jiao" src="resources/images/jiao-1.jpg">'+news+'</div>'+
            '</li>';
        $('.newsList').append(str);
        setTimeout(answers,1000);
        $('.conLeft').find('li.bg').children('.liRight').children('.infor').text(news);
        $('.RightCont').scrollTop($('.RightCont')[0].scrollHeight );
    }

})
function answers(){
    var arr=["Hello","Good","what are you doing","how are you","...","123","spring very good","5619 is good","5619 is useful","hhh","thanks"];
    var aa=Math.floor((Math.random()*arr.length));
    var answer='';
    answer+='<li>'+
        '<div class="answerHead"><img src="resources/images/portrait-2.jpg"/></div>'+
        '<div class="answers"><img class="jiao" src="resources/images/jiao.jpg">'+arr[aa]+'</div>'+
        '</li>';
    $('.newsList').append(answer);
    $('.RightCont').scrollTop($('.RightCont')[0].scrollHeight );
}
$('.ExP').on('mouseenter',function(){
    $('.emjon').show();
})
$('.emjon').on('mouseleave',function(){
    $('.emjon').hide();
})
$('.emjon li').on('click',function(){
    var imgSrc=$(this).children('img').attr('src');
    var str="";
    str+='<li>'+
        '<div class="nesHead"><img src="resources/images/portrait.jpg"/></div>'+
        '<div class="news"><img class="jiao" src="resources/images/jiao-1.jpg"><img class="Expr" src="'+imgSrc+'"></div>'+
        '</li>';
    $('.newsList').append(str);
    $('.emjon').hide();
    $('.RightCont').scrollTop($('.RightCont')[0].scrollHeight );
})



// for(i=0;i=+1;){
//getMessage();
// }

//
// function getMessage(){
//   var userlist=getAllUser;
//
//     $.ajax({
//         url:"/messages/allmessagesbyposter,
//         type:"get",
//         dataType:"json",
//         async : false,
//         success: function(list){
//
//         <li>
//           <div class="liLeft"> <img src="resources/images/portrait-3.jpg"/>   </div>
//           <div class="liRight"> <span  class="intername">this.username = username</span> </div>
//         </li>
//
//     });
// }
//
