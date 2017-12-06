

$(document).ready(function () {
    $('#demo1').banqh({
        box: "#demo1",//总框架
        pic: "#ban_pic1",//大图框架
        pnum: "#ban_num1",//小图框架
        prev_btn: "#prev_btn1",//小图左箭头
        next_btn: "#next_btn1",//小图右箭头
        pop_prev: "#prev2",//弹出框左箭头
        pop_next: "#next2",//弹出框右箭头
        prev: "#prev1",//大图左箭头
        next: "#next1",//大图右箭头
        mhc: ".mhc",//朦灰层
        autoplay: false,//是否自动播放
        interTime: 5000,//图片自动切换间隔
        delayTime: 400,//切换一张图片时间
        order: 0,//当前显示的图片（从0开始）
        picdire: true,//大图滚动方向（true为水平方向滚动）
        mindire: true,//小图滚动方向（true为水平方向滚动）
        min_picnum: 4,//小图显示数量
        pop_up: false//大图是否有弹出框
    });
    $('.zoom').magnify();//初始化放大镜效果
    // 点击+号页面展开回收动效
    $('#change').on('click', function () {
        $(this).parent('.block3').toggleClass('block3-relate');
        $(this).toggleClass('rotates');
        $(this).prev('.elva').slideToggle(1500);
        $(this).next('.block2-div').toggleClass('display');
    });
    var color = $("input[name='color']:checked").attr("title");
    $("#productColor").html(color);
});
// 如果轮播图个数大于四，就显示左右切换键，否则将其隐藏
var banLiIndex = $('#ban_pic1 ul li').length;
if(banLiIndex > 4){
    $('.prev_next').show();
}else{
    $('.prev_next').hide();
}
// 点击加入购物车，购物车数量和选择的数量一致
function addCart() {
    var productId  = $('#productId').val();
    var count = $('#inputNum').val();
    var colorNo = $("input[name='color']:checked").val();
    var series = $("input[name='series']:checked").val();
    if(!colorNo){
        alert("请选择颜色");
        return
    }
    if(!series){
        alert("请选择套餐");
        return
    }
    $.ajax({
        type:'post',
        url:'/user/trolley/add',
        data:{productId:productId,count:count,colorNo:colorNo,series:series},
        success:function(result){
            if(result.code == 1)
                $('#addCartModal').modal();
            else if(result.code == 2){
                window.location.href = result.url;
            }else {
                alert(result.msg);
            }
        },error:function(){}
    })
}

// 点击直接购买
function nowBuy() {
    var productId  = $('#productId').val();
    var count = $('#inputNum').val();
    var colorNo = $("input[name='color']:checked").val();
    var series = $("input[name='series']:checked").val();
    if(!colorNo){
        alert("请选择颜色");
        return
    }
    if(!series){
        alert("请选择套餐");
        return
    }
    $.ajax({
        type:'post',
        url:'/user/orders/nowBuy',
        data:{productId:productId,count:count,colorNo:colorNo,series:series},
        success:function(result){
            if(result.code == 1)
                window.location.href=result.url;
            else if(result.code == 2){
                window.location.href = result.url;
            }else {
                alert(result.msg);
            }
        },error:function(){}
    })
}






//  点击减号，数字减一
function m_subtract(t) {
    var obj = t.parentNode.getElementsByTagName('input')[0];
    if (obj.value > 1)
        obj.value--;
    $("#productCount").html(obj.value+"件");
}
//  点击加号，数字加一
function m_add(t) {
    var obj = t.parentNode.getElementsByTagName('input')[0];
    obj.value++;
    $("#productCount").html(obj.value+"件");
}

function changeColor(t){
    $("#productColor").html($(t).attr("title"));
}

//当屏幕向下滚时，导航栏固定在顶部
$(window).scroll(function () {
    var scrollHeight = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;
    var scrollNavTop = $('#content')[0].offsetTop;
    if(scrollHeight >=  scrollNavTop-82){
        $('.header').removeClass('fixed-top');
        $('.pageNav').addClass('scrollNavFixed');
        $('.scrollBuyTo').css('visibility','visible');
    }else if (scrollHeight >  82 ) {
        $('.header').addClass('fixed-top');
        $('.pageNav').removeClass('scrollNavFixed');
        $('.scrollBuyTo').css('visibility','hidden');
    }else{
        $('.header').removeClass('fixed-top');
        $('.pageNav').removeClass('scrollNavFixed');
    }
});