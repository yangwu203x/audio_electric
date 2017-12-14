/**
 * Created by enter on 2017/9/15.
 */
/***
 * 移动端轮播左右滑动效果-start
 *
 *
 * **/
    // 获取手指在轮播图元素上的一个滑动方向（左右）
    // 获取界面上轮播图容器
var $carousels = $('.carousel');
var startX,endX;
// 在滑动的一定范围内，才切换图片
var offset = 50;
// 注册滑动事件
$carousels.on('touchstart',function (e) {
    // 手指触摸开始时记录一下手指所在的坐标x
    startX = e.originalEvent.touches[0].clientX;

});
$carousels.on('touchmove',function (e) {
    // 目的是：记录手指离开屏幕一瞬间的位置 ，用move事件重复赋值
    endX = e.originalEvent.touches[0].clientX;
});
$carousels.on('touchend',function (e) {
    //console.log(endX);
    //结束触摸一瞬间记录手指最后所在坐标x的位置 endX
    //比较endX与startX的大小，并获取每次运动的距离，当距离大于一定值时认为是有方向的变化
    var distance = Math.abs(startX - endX);
    if (distance > offset){
        //说明有方向的变化
        //根据获得的方向 判断是上一张还是下一张出现
        $(this).carousel(startX >endX ? 'next':'prev');
    }
});
/***
 * 移动端轮播左右滑动效果-end
 *
 *
 * **/

$(function () {
    /***
     * 移动端导航部分动画-start
     *
     *
     * **/
    $(".navIcons-xs").click(function(){
        $(this).toggleClass("icon-click icon-out");
        $('html').toggleClass('noscroll');
        $(".mobile-inner-nav").slideToggle(250);
    });
    $(".mobile-inner-nav a").each(function( index ) {
        $( this ).css({'animation-delay': (index/10)+'s'});
    });
    /***
     * 移动端导航部分动画--end!
     *
     *
     * **/
    var num = $('#cartTable .item').length;
    var numB = num-3;
    if(numB <= 0){
        $('#foot').removeClass('fixed-bottom');
    }
    //当屏幕向下滚时，导航栏固定在顶部
    $(document).scroll(function () {
        var scrollHeight = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;

        if(numB > 0){
            if (scrollHeight >= (numB*150+80)) {
                $('#foot').removeClass('fixed-bottom');
            }else{
                $('#foot').addClass('fixed-bottom');
            }
        }
        if (scrollHeight >  82) {
            $('.header').addClass('fixed-top');
        }else{
            $('.header').removeClass('fixed-top');
        }
    });
    // 头部个人中心列表动画
    $(".personList").each(function( index ) {
        $( this ).css({'animation-delay': (index/10)+'s'});
    });

    // 点击侧栏置顶标签页面滚动至顶部
    $('#toTop').click(function () {
        $("html, body").animate({ scrollTop: 0 }, 300);
    });
    // 收货地址选择
    $('.addMenu').click(function () {
        $(this).parent().addClass('defaultAdd').siblings().removeClass('defaultAdd');
    });


});

// 确认框自定义公共方法
var Common = {
    confirm:function(params){
        var model = $(params.nameId);
        $(params.btnId).click();
        //每次都将监听先关闭，防止多次监听发生，确保只有一次监听
        model.find(".cancel").die("click");
        model.find(".ok").die("click");
        model.find(".ok").live("click",function(){
            params.operate(true)
        });

        model.find(".cancel").live("click",function(){
            params.operate(false)
        })
    }
};



// 省市区联动效果
(function($){
    $.fn.selectAddress=function(options){
        //默认select的id
        var defaults={
            province: '#province',
            city: '#city',
            area: '#area'
        };
        var opts=$.extend({}, defaults, options),
            province=$(opts.province),
            city=$(opts.city),
            area=$(opts.area);
        //ajax公用函数
        function ajaxFun(url,type,obj,selectOption){
            $.ajax({
                url:url,
                dataType:type,
                type:"GET",
                success:function(xmlDoc){
                    var valueList = $(xmlDoc).find(selectOption);
                    if(obj==city || obj==area ){
                        valueList = $(xmlDoc).find(selectOption).children(obj);
                    }
                    $(valueList).each(function(){
                        obj.append("<option value='"+$(this).attr("postcode")+"'>"+$(this).attr("name")+"</option>");
                    });
                    $('#provinceVal').val($("#province option:selected").text());
                    $('#cityVal').val($("#city option:selected").text());
                    $('#areaVal').val($("#area option:selected").text());
                }
            });
        }
        //初始化数据
        function init(){
            province.append("<option value='0'>请选择省份..</option>");
            city.append("<option value='0'>请选择城市..</option>");
            area.append("<option value='0'>请选择县区..</option>");
            var selectOption="province";
            ajaxFun("/extands/areas/areas.xml","xml",province,selectOption);

        }

        //选择省份
        province.on('change', function() {
            if($(this).val() == "0") {
                city.find("option").remove();
                area.find("option").remove();
                city.append("<option value='0'>请选择城市..</option>");
                area.append("<option value='0'>请选择县区..</option>");
            }else{
                city.find("option").remove();
                area.find("option").remove();
                var selectVal = $(this).val();

                //被选择的省份
                var provinceOption="province[postcode="+selectVal+"]";
                //当选择省份时初始联动显示的第一个城市
                var cityOption="province[postcode="+selectVal+"] city:first";
                ajaxFun("/extands/areas/areas.xml","xml",city,provinceOption); //城市
                ajaxFun("/extands/areas/areas.xml","xml",area,cityOption);  //县区
            }

        });
        //选择城市
        city.on('change', function() {
            area.find("option").remove();
            var selectVal = $(this).val();
            var selectOption="city[postcode="+selectVal+"]";
            ajaxFun("/extands/areas/areas.xml","xml",area,selectOption);
        });
        init();

    }
})(jQuery);

(function ($) {
    "use strict";
    function centerModal() {
        $(this).css('display', 'block');
        var $dialog  = $(this).find(".modal-dialog"),
            offset       = ($(window).height() - $dialog.height()) / 2,
            bottomMargin = parseInt($dialog.css('marginBottom'), 10);

        // Make sure you don't hide the top part of the modal w/ a negative margin if it's longer than the screen height, and keep the margin equal to the bottom margin of the modal
        if(offset < bottomMargin) offset = bottomMargin;
        $dialog.css("margin-top", offset);
    }

    $(document).on('show.bs.modal', '.modal', centerModal);
    $(window).on("resize", function () {
        $('.modal:visible').each(centerModal);
    });
}(jQuery));