(function ($){
class Circle {

    constructor(x, y) {
        this.x = x;
        this.y = y;
        this.r = Math.random() * 10 ;
        this._mx = Math.random() ;
        this._my = Math.random() ;

    }

    drawCircle(ctx) {
        ctx.beginPath();
        ctx.arc(this.x, this.y, this.r, 0, 360)
        ctx.closePath();
        ctx.fillStyle = 'rgba(204, 204, 204, 0.3)';
        ctx.fill();
    }

    drawLine(ctx, _circle) {
        let dx = this.x - _circle.x;
        let dy = this.y - _circle.y;
        let d = Math.sqrt(dx * dx + dy * dy)
        if (d < 150) {
            ctx.beginPath();
            ctx.moveTo(this.x, this.y);
            ctx.lineTo(_circle.x, _circle.y);
            ctx.closePath();
            ctx.strokeStyle = 'rgba(204, 204, 204, 0.3)';
            ctx.stroke();
        }
    }


    move(w, h) {
        this._mx = (this.x < w && this.x > 0) ? this._mx : (-this._mx);
        this._my = (this.y < h && this.y > 0) ? this._my : (-this._my);
        this.x += this._mx / 2;
        this.y += this._my / 2;
    }
}

class currentCirle extends Circle {
    constructor(x, y) {
        super(x, y)
    }

    drawCircle(ctx) {

        ctx.fill();
    }
}
window.requestAnimationFrame = window.requestAnimationFrame || window.mozRequestAnimationFrame || window.webkitRequestAnimationFrame || window.msRequestAnimationFrame;

let canvas = document.getElementById('canvas');
let ctx = canvas.getContext('2d');
let w = canvas.width = canvas.offsetWidth;
let h = canvas.height = canvas.offsetHeight;
let circles = [];
let current_circle = new currentCirle(0, 0)

let draw = function () {
    ctx.clearRect(0, 0, w, h);
    for (let i = 0; i < circles.length; i++) {
        circles[i].move(w, h);
        circles[i].drawCircle(ctx);
        for (j = i + 1; j < circles.length; j++) {
            circles[i].drawLine(ctx, circles[j])
        }
    }
    if (current_circle.x) {
        current_circle.drawCircle(ctx);
        for (var k = 1; k < circles.length; k++) {
            current_circle.drawLine(ctx, circles[k])
        }
    }
    requestAnimationFrame(draw)
}

let init = function (num) {
    for (var i = 0; i < num; i++) {
        circles.push(new Circle(Math.random() * w, Math.random() * h));
    }
    draw();
}
window.addEventListener('load', init(60));
window.onmousemove = function (e) {
    e = e || window.event;
    current_circle.x = e.clientX;
    current_circle.y = e.clientY;
}
window.onmouseout = function () {
    current_circle.x = null;
    current_circle.y = null;

};



    var param = {};

    param.username = $.cookie("username").toString();

    $.ajax({
        url: "getProfile",
        type: "post",
        data: param,
        datatype: "json",
        success: function (state) {

            var plink = "resources/images/photo/" + state.userImg.toString() +".png";
            $('#photo').attr("src",plink.toString());
            $('#username').html(state.username.toString());
            $('#nickname').html(state.userN.toString());
            $('#contact').html(state.userCon.toString());
            $('#userPre').html(state.userPre.toString());
            var link = "resources/images/gender/" + state.userGen.toString() +".png";
            $('#gender').attr("src",link.toString());


        }
    });


    $('#changePh').on('click',function(){

            var pCode =prompt("Enter Redemption Code");
            if (pCode!=null && pCode!=""){
                var param = {};
                param.username = $.cookie("username").toString();
                param.pCode = pCode;
                $.ajax({
                    url: "changePh",
                    type: "post",
                    data: param,
                    datatype: "json",
                    success: function (state) {
                        if(state.result == "SUCCESS"){
                            var plink = "resources/images/photo/" + state.userImg.toString() +".png";
                            $('#photo').attr("src",plink.toString());
                            console.log(state.result);

                            window.location.reload();
                        }
                        else
                            alert("Invalid Redemption Code")
                    }
                });

            }

    });


    $('#changeN').on('click',function(){

        var nick =prompt("Enter New Nick Name");
        if (nick!=null && nick!=""){
            var param = {};
            param.username = $.cookie("username").toString();
            param.nick = nick;
            $.ajax({
                url: "changeN",
                type: "post",
                data: param,
                datatype: "json",
                success: function (state) {
                    $('#nickname').html(state.userN.toString());
                    console.log(state.result);
                    window.location.reload();
                }
            });

        }
    });
    $('#changePs').on('click',function(){

        var ps =prompt("Enter Old Password");
        if (ps!=null && ps!=""){
            var param = {};
            param.username = $.cookie("username").toString();
            param.ps = ps;
            $.ajax({
                url: "oldPas",
                type: "get",
                data: param,
                datatype: "json",
                success: function (state) {
                    if(state.result == "SUCCESS"){
                        while(1){
                            var nps =prompt("Enter New Password");
                            if(nps.toString().length < 8)
                            {
                                alert("At least eight characters length password ");

                            }
                            else
                                break;
                        }

                        var ps = {};
                        ps.username = $.cookie("username").toString();
                        ps.ps = nps;
                        $.ajax({
                            url: "newPas",
                            type: "get",
                            data: ps,
                            datatype: "json",
                            success: function (state) {
                                alert("You Password has Changed")
                                console.log(state.result);
                                window.location.reload();
                            }
                        });

                    }
                    else
                    {
                        alert("Wrong Password");
                    }

                }
            });

        }
        else
            alert("Password shouldn't be Empty")
    });

    $('#changeC').on('click',function(){
        var contactI =prompt("Enter Contact information");
        if (contactI!=null && contactI!=""){
            var param = {};
            param.username = $.cookie("username").toString();
            param.contactI = contactI;
            $.ajax({
                url: "changeC",
                type: "get",
                data: param,
                datatype: "json",
                success: function (state) {
                    if(state.result == "SUCCESS"){
                        $('#contact').html(state.userCon.toString());
                        console.log(state.result);

                        window.location.reload();
                    }
                    else
                        alert("Information is Empty ");
                }
            });

        }
    });
    // $('#ichangePh').on('click',function(){
    //     console.log($.cookie("username").toString());
    // });
})(jQuery);