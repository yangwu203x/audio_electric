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
    var color = $("#chooseColor .on").attr('title');
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
    var colorNo = $("#chooseColor .on").attr('alt');
    var series = $("#chooseSeries .on").attr('alt');
    if(!tip(colorNo,"请选择颜色") || !tip(series,"请选择套餐")){
        return;
    }
    postForm('/user/trolley/add',
        {productId:productId,count:count,colorNo:colorNo,series:series},
        function(result){
        if(result.code == 1)
            $('#addCartModal').modal();
        else if(result.code == 2){
            window.location.href = result.url;
        }else {
            alert(result.msg);
        }
    });
}

// 点击直接购买
function nowBuy() {
    var productId  = $('#productId').val();
    var count = $('#inputNum').val();
    var colorNo = $("#chooseColor .on").attr('alt');
    var series = $("#chooseSeries .on").attr('alt');
    tip(colorNo,"请选择颜色",true);
    tip(series,"请选择套餐",true);
    postForm('/user/orders/nowBuy',
        {productId:productId,count:count,colorNo:colorNo,series:series},
    function(result){
        if(result.code == 1)
            window.location.href=result.url;
        else if(result.code == 2){
            window.location.href = result.url;
        }else {
            alert(result.msg);
        }
    });
}


//  点击哪个选项给他一个‘on’类名，其余同类清除‘on’类名
$('.chooseColors li').click(function(){
    var id = $(this).parent().attr('id');
    var colorName = $(this).attr('title');
    //改变本标签样式
    if(!$(this).hasClass('disabledChoose')){
        $(this).addClass('on').siblings().removeClass('on');
    }
    //同步样式
    if(id.indexOf('-xs')>0){
        id = id.substring(0,id.length-3);
    }else{
        id += '-xs';
    }
    var lis = $('#'+id).find("li");
    for(var i =0;i<lis.length;i++){
        var li = lis[i];
        if(colorName == $(li).attr('title')){
            if(!$(li).hasClass('disabledChoose')){
                $(li).addClass('on').siblings().removeClass('on');
                break;
            }
        }
    }
    $('#productColor').html(colorName);
});
//输入数量改变pc
$('#inputNum').bind('input propertychange',function(){
    var inputNum = $('#inputNum').val();
    if(inputNum.trim() == '' || inputNum < 0){
        inputNum = 1;
        $('#inputNum').val(inputNum);
    }
    $('#inputNum-xs').val(inputNum);
    $("#productCount").html(inputNum+"件");
});
//输入数量改变mobile
$('#inputNum-xs').bind('input propertychange',function(){
    var inputNumxs = $('#inputNum-xs').val();
    if(inputNumxs.trim() == '' || inputNumxs < 0){
        inputNumxs = 1;
        $('#inputNum-xs').val(inputNumxs);
    }
    $('#inputNum').val(inputNumxs);
    $("#productCount").html(inputNumxs+"件");
});

//  点击，数字加减
function m_count(t) {
    var num = $('#inputNum').val();
    if($(t).find('i').hasClass('icon-jianhao')){
        num--;
    }else if($(t).find('i').hasClass('icon-jiahao1')){
        num++;
    }
    if(num < 1){
        num = 1;
    }
    $('#inputNum').val(num);
    $('#inputNum-xs').val(num);
    $("#productCount").html(num+"件");
}


//当屏幕向下滚时，导航栏固定在顶部
$(window).scroll(function () {
    var bodyWidth =document.body.clientWidth;//网页可见区域宽
    var headerXsHeight = $('.header-page-xs').height();
    var scrollHeight = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;
    var scrollNavTop = $('#content')[0].offsetTop;
    if(bodyWidth <= 991){
        if(scrollHeight >=  scrollNavTop-headerXsHeight){
            $('.header-page-xs').removeClass('header-page-fixed');
            $('.pageNav').addClass('scrollNavFixed');
        }else if (scrollHeight >  0) {
            $('.header-page-xs').addClass('header-page-fixed');
            $('.pageNav').removeClass('scrollNavFixed');
        }else{
            $('.header-page-xs').removeClass('header-page-fixed');
            $('.pageNav').removeClass('scrollNavFixed');
        }
    }else{
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
    }
});