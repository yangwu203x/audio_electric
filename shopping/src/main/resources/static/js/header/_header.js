$(function(){
    var $el = $("#js_showCart");
    var $cart = $('#shopCartBlock');
    var $showPerson = $("#js_showPerson");
    var $person = $("#personBlock");
    var $showNav = $('#showNav');
    var $sideBar = $('#sideBar');
    var headerTimer;
    $.ajax({
        url:'/user/trolley/totalCount',
        type:"get",
        ContentType: "application/json; charset=utf-8",
        success: function (result) {
            if(result.code == 1){
                var num = result.data;
                if(num >0){
                    $("#totalNum").html(num);
                }
                if(num > 0){
                    refreshTrolley();
                    $('#noGoods').css('display','none');
                    $('#withGoods').css('display','block');
                }else{
                    $('#noGoods').css('display','block');
                    $('#withGoods').css('display','none');
                }
            }else{
                $('#noGoods').html("<a th:href='/login'>登录后可显示<br>您账号中已加入的商品哦~</a>");
                $('#noGoods').css('display','block');
                $('#withGoods').css('display','none');
            }

        },
        error:function (error) {
            //弹出错误信息
        }
    });
    //  鼠标移入导航标志，出现侧导航动画
    $showNav.hover(function(){
        $(this).addClass('icon-click').removeClass('icon-out');
        $sideBar.stop(true).addClass('sideBarLeft');
    },function (e) {
        e.stopPropagation();
        headerTimer = setTimeout(function () {
            $sideBar.stop(true).removeClass('sideBarLeft');
            $showNav.addClass('icon-out').removeClass('icon-click');
        }, 200);
    });
    $sideBar.hover(function () {
        clearTimeout(headerTimer);
    },function () {
        $showNav.addClass('icon-out').removeClass('icon-click');
        $sideBar.stop(true).removeClass('sideBarLeft');
    });

    $el.hover(function(e){
        $cart.stop(true).show();
    },function (e) {
        timer = setTimeout(function () {
            $cart.stop(true).hide();
        }, 200);
        e.stopPropagation();
    });
    $cart.hover(function () {
        clearTimeout(timer);
    },function () {
        $cart.stop(true).hide();
    });

    $showPerson.hover(function(e){
        $person.stop(true).show();
    },function(e){
        e.stopPropagation();
        timer = setTimeout(function () {
            $person.stop(true).hide();
        }, 200);
    });

    $el.click(function(e){
        window.location.href="/user/trolley/view";
    });

    $person.hover(function () {
        clearTimeout(timer);
    },function () {
        $person.stop(true).hide();
    });

    $('.js_deleteGoods').click(function (e) {
        e.stopPropagation();
        $(this).parent('li').remove();
    });
    $(document).on('click',function(e){
        if($(e.target).hasClass('js_deleteGoods')){
            del($(e.target));
            return;
        }
    });
});





function refreshTrolley(){
    $.ajax({
        url:'/user/trolley/ajax/view',
        type:"get",
        ContentType: "application/json; charset=utf-8",
        success: function (result) {
            try {
                if(result.code != 1){
                    window.location.href="/login"
                    return;
                }
                var obj = result.data;
                var innerHtml = "";
                var price = 0;
                var num = 0;
                for(var i = 0;i < obj.length; i++){
                    var itemHtml = "<li class='clearfix'><a class='shopCart_img pull-left' href='/product/view/id/" + obj[i].product.id
                        + "'><img height='64px' src="+obj[i].product.thumbnail3 +"></a><div class='cartRight'><p class='cartInfo'><a class='cartGoodsName' href='/product/view/id/"+
                        + obj[i].product.id + " '>" +obj[i].product.categoryName+' '+ obj[i].product.name+"</a>" +
                        "<span class='cartGoodsNum'><i class='iconfont icon-close iconNum'></i>"+ obj[i].count + "</span></p><p class='cartGoodsMoney'>¥" + obj[i].product.priceSale + "</p></div><i class='iconfont icon-close js_deleteGoods' id='"+ obj[i].id +"' ></i></li>";
                    innerHtml += itemHtml;
                    price += obj[i].product.priceSale * obj[i].count;
                    num += obj[i].count;
                }
                $("#cartList").html(innerHtml);
                if(num >0){
                    var totalHtml = "<p>共<span class='totalNum'>"+ num +"</span>件商品</p><p class='totalYuan'>￥"+ price +"</p>"
                    $("#cartFooter").html(totalHtml);
                    $("#totalNum").html(num);
                }
            } catch (e) {
                window.location.href="/login";
            }
        },
        error:function (error) {
            //弹出错误信息
        }
    });
}

function del(obj){
    var trolleyId = $(obj).attr("id");
    $.ajax({url:'/user/trolley/delete/id/'+trolleyId,
        type:'delete',
        data:{},
        success:function(result){
            if(result.code == 1){
                refreshTrolley();
            }
        }
    });



}